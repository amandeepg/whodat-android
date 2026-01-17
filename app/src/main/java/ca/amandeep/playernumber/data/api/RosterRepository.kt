package ca.amandeep.playernumber.data.api

import android.util.Log
import ca.amandeep.playernumber.data.AnyPlayer
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.JerseyNumber
import ca.amandeep.playernumber.data.Player
import ca.amandeep.playernumber.data.RosterLookup
import ca.amandeep.playernumber.data.TeamId
import ca.amandeep.playernumber.data.cache.CachedPlayer
import ca.amandeep.playernumber.data.cache.CachedRoster
import ca.amandeep.playernumber.data.cache.RosterCacheStore
import ca.amandeep.playernumber.data.findPlayerInRoster
import ca.amandeep.playernumber.data.teamForId
import ca.amandeep.playernumber.data.teamId
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

enum class RosterSource {
    STATIC,
    CACHE,
    ESPN,
}

data class RosterState(
    val team: AnyTeam,
    val players: List<AnyPlayer>,
    val source: RosterSource,
    val lastUpdatedMillis: Long?,
)

interface RosterRepository : RosterLookup {
    fun rosterState(team: AnyTeam): StateFlow<RosterState>

    fun refresh(
        team: AnyTeam,
        force: Boolean = false,
    )
}

class EspnRosterRepository(
    private val api: EspnRosterApi,
    private val cache: RosterCacheStore,
    private val scope: CoroutineScope,
    private val ioDispatcher: CoroutineDispatcher,
    private val refreshAfterMillis: Long = 7L * 24 * 60 * 60 * 1000,
    private val expireAfterMillis: Long = 14L * 24 * 60 * 60 * 1000,
    private val clock: () -> Long = { System.currentTimeMillis() },
) : RosterRepository {
    private val stateByTeam = ConcurrentHashMap<TeamId, MutableStateFlow<RosterState>>()
    private val refreshJobs = ConcurrentHashMap<TeamId, Job>()

    override fun rosterState(team: AnyTeam): StateFlow<RosterState> {
        val teamId = team.teamId()
        return stateByTeam.getOrPut(teamId) {
            MutableStateFlow(staticState(team)).also { flow ->
                scope.launch(ioDispatcher) {
                    val cached = readCache(team)
                    if (cached != null) {
                        flow.value = cachedState(team, cached)
                    }
                }
            }
        }
    }

    override fun refresh(
        team: AnyTeam,
        force: Boolean,
    ) {
        val teamId = team.teamId()
        val flow = stateFlowFor(team)
        if (refreshJobs[teamId]?.isActive == true) return

        refreshJobs[teamId] = scope.launch(ioDispatcher) {
            val cached = readCache(team)
            val now = clock()
            val decision = decideRefresh(team, flow.value, cached, force, now)
            decision.preRefreshState?.let { flow.value = it }
            if (!decision.shouldRefresh) {
                return@launch
            }

            try {
                val league = espnLeagueFor(team)
                val players = api.fetchRoster(league, team.abbreviation)
                if (players.isEmpty()) {
                    return@launch
                }
                val updatedAt = clock()
                flow.value = buildRosterState(
                    team = team,
                    players = players,
                    source = RosterSource.ESPN,
                    lastUpdatedMillis = updatedAt,
                )
                cache.write(team, cachedRosterFor(team, league.leagueId, updatedAt, players))
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (error: Exception) {
                Log.e(LOG_TAG, "Roster refresh failed team=${team.abbreviation}", error)
            }
        }
    }

    override fun findPlayer(
        team: TeamId,
        number: JerseyNumber,
    ): AnyPlayer? {
        val resolvedTeam = teamForId(team) ?: return null
        val rosterState = rosterState(resolvedTeam).value
        return findPlayerInRoster(rosterState.players, number)
    }

    private fun stateFlowFor(team: AnyTeam): MutableStateFlow<RosterState> = stateByTeam.getOrPut(team.teamId()) { MutableStateFlow(staticState(team)) }

    private fun decideRefresh(
        team: AnyTeam,
        current: RosterState,
        cached: CachedRoster?,
        force: Boolean,
        now: Long,
    ): RefreshDecision {
        if (cached == null) {
            return RefreshDecision(preRefreshState = null, shouldRefresh = true)
        }
        val cachedAge = now - cached.fetchedAtMillis
        if (!force && cachedAge < refreshAfterMillis) {
            val preState = if (current.source == RosterSource.STATIC) {
                cachedState(team, cached)
            } else {
                null
            }
            return RefreshDecision(preRefreshState = preState, shouldRefresh = false)
        }
        if (cachedAge < expireAfterMillis) {
            val preState = if (current.source != RosterSource.CACHE) {
                cachedState(team, cached)
            } else {
                null
            }
            return RefreshDecision(preRefreshState = preState, shouldRefresh = true)
        }
        val preState = if (current.source != RosterSource.CACHE) {
            cachedState(team, cached)
        } else {
            null
        }
        return RefreshDecision(preRefreshState = preState, shouldRefresh = true)
    }

    private fun staticState(team: AnyTeam): RosterState = buildRosterState(
        team = team,
        players = team.roster,
        source = RosterSource.STATIC,
        lastUpdatedMillis = null,
    )

    private fun cachedState(
        team: AnyTeam,
        cached: CachedRoster,
    ): RosterState {
        val league = EspnLeague.fromLeagueId(cached.leagueId) ?: espnLeagueFor(team)
        val players = cached.players.map { cachedPlayer ->
            val position = mapPositionForLeague(
                league = league,
                abbreviation = cachedPlayer.positionShortName,
                name = cachedPlayer.positionLongName,
            )
            Player(
                firstName = cachedPlayer.firstName,
                lastName = cachedPlayer.lastName,
                position = position,
                jerseyNumber = cachedPlayer.jerseyNumber,
                suffix = cachedPlayer.suffix,
            )
        }
        return buildRosterState(
            team = team,
            players = players,
            source = RosterSource.CACHE,
            lastUpdatedMillis = cached.fetchedAtMillis,
        )
    }

    private fun buildRosterState(
        team: AnyTeam,
        players: List<AnyPlayer>,
        source: RosterSource,
        lastUpdatedMillis: Long?,
    ): RosterState = RosterState(
        team = team,
        players = players,
        source = source,
        lastUpdatedMillis = lastUpdatedMillis,
    )

    private fun cachedRosterFor(
        team: AnyTeam,
        leagueId: String,
        fetchedAt: Long,
        players: List<AnyPlayer>,
    ): CachedRoster = CachedRoster(
        leagueId = leagueId,
        teamAbbreviation = team.abbreviation,
        fetchedAtMillis = fetchedAt,
        players = players.map { player ->
            CachedPlayer(
                firstName = player.firstName,
                lastName = player.lastName,
                positionShortName = player.position.shortName,
                positionLongName = player.position.longName,
                jerseyNumber = player.jerseyNumber,
                suffix = player.suffix,
            )
        },
    )

    private suspend fun readCache(team: AnyTeam): CachedRoster? = try {
        val leagueId = espnLeagueFor(team).leagueId
        cache.read(team)?.takeIf { cached ->
            cached.teamAbbreviation == team.abbreviation && cached.leagueId == leagueId
        }
    } catch (cancelled: CancellationException) {
        throw cancelled
    } catch (error: Exception) {
        Log.e(LOG_TAG, "Cache read failed team=${team.abbreviation}", error)
        null
    }

}

private data class RefreshDecision(
    val preRefreshState: RosterState?,
    val shouldRefresh: Boolean,
)

private const val LOG_TAG = "RosterRepository"
