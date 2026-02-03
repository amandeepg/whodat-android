package ca.amandeep.playernumber.data.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EspnRosterResponse(
    val athletes: List<EspnRosterEntry>? = null,
)

@JsonClass(generateAdapter = true)
data class EspnRosterEntry(
    val firstName: String? = null,
    val lastName: String? = null,
    val fullName: String? = null,
    val displayName: String? = null,
    val jersey: String? = null,
    val position: Any? = null,
    val items: List<EspnRosterEntry>? = null,
)
