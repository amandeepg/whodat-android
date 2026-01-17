package ca.amandeep.playernumber.data.api

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import java.time.Clock
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EspnTodayGamesRepository(
    private val service: EspnScoreboardService,
    private val ioDispatcher: CoroutineDispatcher,
    private val clock: Clock = Clock.systemDefaultZone(),
) {
    suspend fun fetchTodayGames(): TodayGamesResult = withContext(ioDispatcher) {
        val date = LocalDate.now(clock)
        val dateParam = date.format(DateTimeFormatter.BASIC_ISO_DATE)
        val leagueGames = ArrayList<LeagueGames>()
        val failures = ArrayList<Pair<EspnLeague, Throwable>>()

        supervisorScope {
            val requests = EspnLeague.entries.map { league ->
                league to
                    async {
                        service.fetchScoreboard(
                            sport = league.sportSlug,
                            league = league.leagueSlug,
                            dates = dateParam,
                        )
                    }
            }
            for ((league, deferred) in requests) {
                try {
                    val response = deferred.await()
                    val games = response.toTodayGames(league)
                    if (games.isNotEmpty()) {
                        leagueGames.add(
                            LeagueGames(
                                leagueId = league.toLeagueId(),
                                games = games,
                            ),
                        )
                    }
                } catch (error: CancellationException) {
                    throw error
                } catch (error: Exception) {
                    failures.add(league to error)
                    Log.e(LOG_TAG, "Scoreboard fetch failed league=${league.leagueId}", error)
                }
            }
        }

        if (leagueGames.isEmpty() && failures.isNotEmpty()) {
            throw failures.first().second
        }
        TodayGamesResult(
            date = date,
            leagues = leagueGames,
        )
    }
}

private const val LOG_TAG = "EspnTodayGames"
