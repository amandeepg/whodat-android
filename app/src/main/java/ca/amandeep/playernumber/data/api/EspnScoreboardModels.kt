package ca.amandeep.playernumber.data.api

data class EspnScoreboardResponse(
    val events: List<EspnScoreboardEvent>? = null,
)

data class EspnScoreboardEvent(
    val id: String? = null,
    val competitions: List<EspnScoreboardCompetition>? = null,
)

data class EspnScoreboardCompetition(
    val competitors: List<EspnScoreboardCompetitor>? = null,
)

data class EspnScoreboardCompetitor(
    val homeAway: String? = null,
    val team: EspnScoreboardTeam? = null,
)

data class EspnScoreboardTeam(
    val id: String? = null,
    val abbreviation: String? = null,
    val displayName: String? = null,
    val shortDisplayName: String? = null,
)
