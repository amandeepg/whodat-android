package ca.amandeep.playernumber.data.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EspnScoreboardResponse(
    val events: List<EspnScoreboardEvent>? = null,
)

@JsonClass(generateAdapter = true)
data class EspnScoreboardEvent(
    val id: String? = null,
    val competitions: List<EspnScoreboardCompetition>? = null,
)

@JsonClass(generateAdapter = true)
data class EspnScoreboardCompetition(
    val competitors: List<EspnScoreboardCompetitor>? = null,
)

@JsonClass(generateAdapter = true)
data class EspnScoreboardCompetitor(
    val homeAway: String? = null,
    val team: EspnScoreboardTeam? = null,
)

@JsonClass(generateAdapter = true)
data class EspnScoreboardTeam(
    val id: String? = null,
    val abbreviation: String? = null,
    val displayName: String? = null,
    val shortDisplayName: String? = null,
)
