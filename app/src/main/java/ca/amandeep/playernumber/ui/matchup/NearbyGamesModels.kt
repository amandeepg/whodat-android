package ca.amandeep.playernumber.ui.matchup

import android.location.Location
import ca.amandeep.playernumber.data.VenueLocation
import ca.amandeep.playernumber.data.api.LeagueGames
import ca.amandeep.playernumber.data.api.TodayGame
import ca.amandeep.playernumber.data.location.DeviceLocation

internal data class HighlightedGame(
    val game: TodayGame,
    val distanceMeters: Double,
)

internal data class NearbyGames(
    val atStadium: HighlightedGame?,
    val closest: List<HighlightedGame>,
)

internal fun computeNearbyGames(
    leagues: List<LeagueGames>,
    location: DeviceLocation,
    atStadiumMeters: Double = 609.6,
): NearbyGames {
    val candidates =
        leagues.flatMap { league ->
            league.games.map { game ->
                HighlightedGame(
                    game = game,
                    distanceMeters = distanceMeters(location, game.home.venue.location),
                )
            }
        }
    if (candidates.isEmpty()) {
        return NearbyGames(atStadium = null, closest = emptyList())
    }
    val atStadium =
        candidates
            .filter { it.distanceMeters <= atStadiumMeters }
            .minByOrNull { it.distanceMeters }
    val closest =
        candidates
            .filter { it.distanceMeters <= CLOSEST_RANGE_METERS }
            .filter { it.game.eventId != atStadium?.game?.eventId }
            .sortedBy { it.distanceMeters }
    return NearbyGames(atStadium = atStadium, closest = closest)
}

private const val METERS_PER_MILE = 1609.344
private const val CLOSEST_RANGE_METERS = METERS_PER_MILE * 20.0

private fun distanceMeters(
    from: DeviceLocation,
    to: VenueLocation,
): Double {
    val results = FloatArray(1)
    Location.distanceBetween(
        from.latitude,
        from.longitude,
        to.lat,
        to.long,
        results,
    )
    return results.firstOrNull()?.toDouble() ?: Double.POSITIVE_INFINITY
}
