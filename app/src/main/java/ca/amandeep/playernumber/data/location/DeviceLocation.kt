package ca.amandeep.playernumber.data.location

data class DeviceLocation(
    val latitude: Double,
    val longitude: Double,
    val accuracyMeters: Float?,
    val timestampMillis: Long?,
)
