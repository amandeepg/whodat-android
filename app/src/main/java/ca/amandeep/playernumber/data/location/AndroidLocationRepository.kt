package ca.amandeep.playernumber.data.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.CancellationSignal
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class AndroidLocationRepository(
    private val context: Context,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : LocationRepository {
    @SuppressLint("MissingPermission")
    override fun locationFlow(): Flow<LocationFetchResult> =
        flow {
            val hasFinePermission = hasFinePermission()
            val hasCoarsePermission = hasCoarsePermission()
            if (!hasFinePermission && !hasCoarsePermission) {
                emit(LocationFetchResult.MissingPermission)
                return@flow
            }
            val locationManager = context.getSystemService(LocationManager::class.java)
            if (locationManager == null) {
                emit(LocationFetchResult.Error("LocationManager unavailable"))
                return@flow
            }
            val lastKnown = bestLastKnownLocation(locationManager)
            if (lastKnown != null) {
                emit(lastKnown.toFetchResult())
            }
            emit(fetchCurrentLocation(locationManager, hasFinePermission))
        }.flowOn(ioDispatcher)

    private fun hasFinePermission(): Boolean =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION,
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasCoarsePermission(): Boolean =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ) == PackageManager.PERMISSION_GRANTED

    private fun bestProvider(
        locationManager: LocationManager,
        hasFinePermission: Boolean,
    ): String? {
        val providers = locationManager.getProviders(true)
        return when {
            hasFinePermission && LocationManager.GPS_PROVIDER in providers -> LocationManager.GPS_PROVIDER
            LocationManager.NETWORK_PROVIDER in providers -> LocationManager.NETWORK_PROVIDER
            LocationManager.PASSIVE_PROVIDER in providers -> LocationManager.PASSIVE_PROVIDER
            else -> null
        }
    }

    @SuppressLint("MissingPermission")
    private suspend fun fetchCurrentLocation(
        locationManager: LocationManager,
        hasFinePermission: Boolean,
    ): LocationFetchResult {
        val provider =
            bestProvider(locationManager, hasFinePermission)
                ?: return bestLastKnownLocation(locationManager)?.toFetchResult()
                    ?: LocationFetchResult.Unavailable
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            suspendCancellableCoroutine { continuation ->
                val cancellationSignal = CancellationSignal()
                continuation.invokeOnCancellation { cancellationSignal.cancel() }
                val executor = ContextCompat.getMainExecutor(context)
                try {
                    locationManager.getCurrentLocation(
                        provider,
                        cancellationSignal,
                        executor,
                    ) { location ->
                        val result =
                            location?.toFetchResult()
                                ?: bestLastKnownLocation(locationManager)?.toFetchResult()
                                ?: LocationFetchResult.Unavailable
                        if (continuation.isActive) {
                            continuation.resume(result)
                        }
                    }
                } catch (error: Exception) {
                    if (continuation.isActive) {
                        continuation.resume(LocationFetchResult.Error(error.message))
                    }
                }
            }
        } else {
            bestLastKnownLocation(locationManager)?.toFetchResult()
                ?: LocationFetchResult.Unavailable
        }
    }

    private fun bestLastKnownLocation(locationManager: LocationManager): Location? {
        val providers = locationManager.getProviders(true)
        var bestLocation: Location? = null
        for (provider in providers) {
            val location =
                try {
                    locationManager.getLastKnownLocation(provider)
                } catch (_: SecurityException) {
                    null
                }
            if (location != null) {
                if (bestLocation == null || location.time > bestLocation.time) {
                    bestLocation = location
                }
            }
        }
        return bestLocation
    }

    private fun Location.toFetchResult(): LocationFetchResult =
        LocationFetchResult.Available(
            DeviceLocation(
                latitude = latitude,
                longitude = longitude,
                accuracyMeters = if (hasAccuracy()) accuracy else null,
                timestampMillis = if (time > 0L) time else null,
            ),
        )
}
