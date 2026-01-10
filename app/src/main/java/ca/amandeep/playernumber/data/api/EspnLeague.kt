package ca.amandeep.playernumber.data.api

import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.LeagueId

enum class EspnLeague(
    val leagueId: String,
    val sportSlug: String,
    val leagueSlug: String,
) {
    NBA("NBA", "basketball", "nba"),
    NHL("NHL", "hockey", "nhl"),
    NFL("NFL", "football", "nfl"),
    MLB("MLB", "baseball", "mlb"),
    MLS("MLS", "soccer", "usa.1"),
    ;

    companion object {
        fun fromLeagueId(id: String): EspnLeague? = entries.firstOrNull { it.leagueId == id }
    }
}

fun espnLeagueFor(team: AnyTeam): EspnLeague = team.league.toEspnLeague()

fun LeagueId.toEspnLeague(): EspnLeague =
    when (this) {
        LeagueId.NBA -> EspnLeague.NBA
        LeagueId.NHL -> EspnLeague.NHL
        LeagueId.NFL -> EspnLeague.NFL
        LeagueId.MLB -> EspnLeague.MLB
        LeagueId.MLS -> EspnLeague.MLS
    }

fun EspnLeague.toLeagueId(): LeagueId =
    when (this) {
        EspnLeague.NBA -> LeagueId.NBA
        EspnLeague.NHL -> LeagueId.NHL
        EspnLeague.NFL -> LeagueId.NFL
        EspnLeague.MLB -> LeagueId.MLB
        EspnLeague.MLS -> LeagueId.MLS
    }
