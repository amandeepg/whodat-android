package ca.amandeep.playernumber.data.api

data class EspnRosterResponse(
    val athletes: List<EspnRosterEntry>? = null,
)

data class EspnRosterEntry(
    val firstName: String? = null,
    val lastName: String? = null,
    val fullName: String? = null,
    val displayName: String? = null,
    val jersey: String? = null,
    val position: Any? = null,
    val items: List<EspnRosterEntry>? = null,
)
