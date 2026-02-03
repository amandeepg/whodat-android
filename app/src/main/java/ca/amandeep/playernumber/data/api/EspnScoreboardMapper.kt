package ca.amandeep.playernumber.data.api

import android.util.Log
import ca.amandeep.playernumber.data.AnyLeague
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.LeagueCatalog
import java.util.Locale

internal fun EspnScoreboardResponse.toTodayGames(league: EspnLeague): List<TodayGame> {
    val leagueModel = LeagueCatalog.firstOrNull { it.id == league.leagueId } ?: return emptyList()
    val resolver = EspnTeamResolver(leagueModel)
    val games = ArrayList<TodayGame>()
    events.orEmpty().forEach { event ->
        val competition = event.competitions?.firstOrNull() ?: return@forEach
        val competitors = competition.competitors.orEmpty()
        val away = competitors.firstOrNull { it.homeAway.equals("away", ignoreCase = true) }?.team
        val home = competitors.firstOrNull { it.homeAway.equals("home", ignoreCase = true) }?.team
        val awayTeam = resolver.resolve(away)
        val homeTeam = resolver.resolve(home)
        if (awayTeam == null || homeTeam == null) {
            return@forEach
        }
        val eventId =
            event.id
                ?: "${league.leagueId}-${awayTeam.abbreviation}-${homeTeam.abbreviation}"
        games.add(
            TodayGame(
                eventId = eventId,
                away = awayTeam,
                home = homeTeam,
            ),
        )
    }
    return games
}

internal class EspnTeamResolver(
    private val league: AnyLeague,
) {
    private val byAbbreviation: Map<String, AnyTeam>
    private val byName: Map<String, AnyTeam>

    init {
        val abbrevMap = LinkedHashMap<String, AnyTeam>(league.teams.size)
        val nameMap = LinkedHashMap<String, AnyTeam>(league.teams.size)
        league.teams.forEach { team ->
            val abbrevKey = normalizeAbbreviation(team.abbreviation)
            if (abbrevKey.isNotEmpty()) {
                abbrevMap.putIfAbsent(abbrevKey, team)
            }
            val nameKey = normalizeName(team.name)
            if (nameKey.isNotEmpty()) {
                nameMap.putIfAbsent(nameKey, team)
            }
        }
        byAbbreviation = abbrevMap
        byName = nameMap
    }

    fun resolve(team: EspnScoreboardTeam?): AnyTeam? {
        if (team == null) return null
        val abbrevKey = team.abbreviation?.let { normalizeAbbreviation(it) }
        if (!abbrevKey.isNullOrEmpty()) {
            byAbbreviation[abbrevKey]?.let { return it }
        }
        val displayKey = team.displayName?.let { normalizeName(it) }
        if (!displayKey.isNullOrEmpty()) {
            byName[displayKey]?.let { return it }
        }
        val shortKey = team.shortDisplayName?.let { normalizeName(it) }
        if (!shortKey.isNullOrEmpty()) {
            byName[shortKey]?.let { return it }
        }
        Log.w(
            LOG_TAG,
            "Unmapped team in ${league.displayName}: abbrev=${team.abbreviation} display=${team.displayName} short=${team.shortDisplayName}",
        )
        return null
    }
}

private fun normalizeAbbreviation(value: String): String =
    value
        .trim()
        .uppercase(Locale.US)
        .replace(Regex("[^A-Z0-9]"), "")

private fun normalizeName(value: String): String =
    value
        .trim()
        .lowercase(Locale.US)
        .replace(Regex("[^a-z0-9]"), "")

private const val LOG_TAG = "EspnScoreboard"
