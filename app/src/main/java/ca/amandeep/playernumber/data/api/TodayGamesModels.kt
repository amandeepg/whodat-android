package ca.amandeep.playernumber.data.api

import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.LeagueId
import java.time.LocalDate

data class TodayGame(
    val eventId: String,
    val away: AnyTeam,
    val home: AnyTeam,
)

data class LeagueGames(
    val leagueId: LeagueId,
    val games: List<TodayGame>,
)

data class TodayGamesResult(
    val date: LocalDate,
    val leagues: List<LeagueGames>,
)
