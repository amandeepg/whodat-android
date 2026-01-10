package ca.amandeep.playernumber.data.location

import kotlinx.coroutines.flow.Flow

sealed interface LocationFetchResult {
    data class Available(
        val location: DeviceLocation,
    ) : LocationFetchResult

    data object MissingPermission : LocationFetchResult

    data object Unavailable : LocationFetchResult

    data class Error(
        val message: String?,
    ) : LocationFetchResult
}

interface LocationRepository {
    fun locationFlow(): Flow<LocationFetchResult>
}
