package ca.amandeep.playernumber.data.api

import android.util.Log
import ca.amandeep.playernumber.data.AnyPlayer
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class EspnRosterApi(
    private val service: EspnRosterService,
    private val ioDispatcher: CoroutineDispatcher,
) {
    suspend fun fetchRoster(
        league: EspnLeague,
        teamAbbreviation: String,
    ): List<AnyPlayer> = withContext(ioDispatcher) {
        val start = System.currentTimeMillis()
        try {
            service
                .fetchRoster(
                    sport = league.sportSlug,
                    league = league.leagueSlug,
                    abbreviation = teamAbbreviation.lowercase(),
                ).toPlayers(league)
        } catch (error: Exception) {
            val durationMs = System.currentTimeMillis() - start
            Log.e(
                LOG_TAG,
                "Failed roster fetch league=${league.leagueId} team=$teamAbbreviation after ${durationMs}ms",
                error,
            )
            throw error
        }
    }
}

private const val LOG_TAG = "EspnRosterApi"
