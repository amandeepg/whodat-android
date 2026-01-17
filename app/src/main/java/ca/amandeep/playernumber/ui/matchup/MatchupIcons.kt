package ca.amandeep.playernumber.ui.matchup

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsBaseball
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material.icons.filled.SportsFootball
import androidx.compose.material.icons.filled.SportsHockey
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Locale

internal fun leagueIconFor(leagueLabel: String): ImageVector = when (leagueLabel.uppercase(Locale.ROOT)) {
    "NBA" -> Icons.Default.SportsBasketball
    "NHL" -> Icons.Default.SportsHockey
    "NFL" -> Icons.Default.SportsFootball
    "MLB" -> Icons.Default.SportsBaseball
    "MLS" -> Icons.Default.SportsSoccer
    else -> Icons.Default.Star
}
