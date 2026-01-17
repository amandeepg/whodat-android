package ca.amandeep.playernumber.data.cache

import android.content.Context
import android.util.Log
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.api.espnLeagueFor
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.File

data class CachedRoster(
    val leagueId: String,
    val teamAbbreviation: String,
    val fetchedAtMillis: Long,
    val players: List<CachedPlayer>,
)

data class CachedPlayer(
    val firstName: String,
    val lastName: String,
    val positionShortName: String,
    val positionLongName: String,
    val jerseyNumber: String,
    val suffix: String?,
)

interface RosterCacheStore {
    suspend fun read(team: AnyTeam): CachedRoster?

    suspend fun write(
        team: AnyTeam,
        roster: CachedRoster,
    )

    suspend fun delete(team: AnyTeam)
}

class FileRosterCacheStore(
    private val context: Context,
    private val moshi: Moshi,
    private val ioDispatcher: CoroutineDispatcher,
) : RosterCacheStore {
    private val adapter = moshi.adapter(CachedRoster::class.java)

    override suspend fun read(team: AnyTeam): CachedRoster? =
        withContext(ioDispatcher) {
            val file = cacheFile(team)
            if (!file.exists()) {
                return@withContext null
            }
            return@withContext try {
                adapter.fromJson(file.readText()).also { roster ->
                    if (roster == null) {
                        Log.e(LOG_TAG, "Cache decode failed team=${team.abbreviation}")
                    }
                }
            } catch (error: Exception) {
                Log.e(LOG_TAG, "Cache decode failed team=${team.abbreviation}", error)
                file.delete()
                null
            }
        }

    override suspend fun write(
        team: AnyTeam,
        roster: CachedRoster,
    ) {
        withContext(ioDispatcher) {
            val file = cacheFile(team)
            file.writeText(adapter.toJson(roster))
        }
    }

    override suspend fun delete(team: AnyTeam) {
        withContext(ioDispatcher) {
            cacheFile(team).delete()
        }
    }

    private fun cacheFile(team: AnyTeam): File {
        val league = espnLeagueFor(team)
        val fileName = "roster_${league.leagueId.lowercase()}_${team.abbreviation.lowercase()}.json"
        return context.filesDir.resolve(fileName)
    }
}

private const val LOG_TAG = "RosterCacheStore"
