package ca.amandeep.playernumber.ui.matchup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.data.LeagueCatalog
import ca.amandeep.playernumber.data.LeagueId
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.data.NhlTeamRefs
import ca.amandeep.playernumber.data.api.LeagueGames
import ca.amandeep.playernumber.data.api.TodayGame
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import ca.amandeep.playernumber.ui.utils.fadingEdges
import java.time.LocalDate
import java.util.Locale

@Composable
internal fun TodayGamesSection(
    state: TodayGamesUiState,
    onGameSelect: (TodayGame) -> Unit,
    nearbyGames: NearbyGames?,
    locationPermissionGranted: Boolean,
    onRequestLocationPermission: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val loadedState = state as? TodayGamesUiState.Loaded ?: return
    val leaguesWithGames = loadedState.leagues.filter { it.games.isNotEmpty() }
    if (leaguesWithGames.isEmpty()) return
    val listState = rememberLazyListState()
    val textMeasurer = rememberTextMeasurer()
    val fadeModifier = Modifier.fadingEdges(listState)
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .then(fadeModifier),
        state = listState,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (!locationPermissionGranted) {
            item {
                EnableLocationPill(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onRequestLocationPermission,
                )
            }
        }
        item { TodayGamesHeader() }
        val atStadium = nearbyGames?.atStadium
        val closest = nearbyGames?.closest.orEmpty()
        val displayClosest =
            closest.filter { it.game.eventId != atStadium?.game?.eventId }
        if (atStadium != null) {
            item {
                NearbyGamesSectionHeader(
                    icon = Icons.Default.Stadium,
                    label = stringResource(atStadiumLabel(atStadium.game.home.league)),
                    subtitle =
                        stringResource(
                            R.string.nearby_games_at_venue_format,
                            atStadium.game.home.venue.name,
                        ),
                )
            }
            item {
                TodayGameCard(
                    game = atStadium.game,
                    onClick = { onGameSelect(atStadium.game) },
                    textMeasurer = textMeasurer,
                    showLeagueLabel = true,
                )
            }
        }
        if (displayClosest.isNotEmpty()) {
            item {
                NearbyGamesSectionHeader(
                    icon = Icons.Default.MyLocation,
                    label = stringResource(R.string.nearby_games_closest_label),
                )
            }
            items(
                displayClosest,
                key = { game -> "closest:${game.game.eventId}" },
            ) { highlighted ->
                TodayGameCard(
                    game = highlighted.game,
                    onClick = { onGameSelect(highlighted.game) },
                    textMeasurer = textMeasurer,
                    showLeagueLabel = true,
                )
            }
        }
        leaguesWithGames.forEach { league ->
            val leagueLabel = leagueLabelFor(league.leagueId)
            item { LeagueSectionHeader(leagueLabel = leagueLabel) }
            items(league.games, key = { game -> "${league.leagueId.name}:${game.eventId}" }) { game ->
                TodayGameCard(
                    game = game,
                    onClick = { onGameSelect(game) },
                    textMeasurer = textMeasurer,
                )
            }
        }
    }
}

private fun leagueLabelFor(leagueId: LeagueId): String =
    LeagueCatalog.firstOrNull { it.id == leagueId.name }?.displayName ?: leagueId.name

@Composable
private fun TodayGamesHeader(modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    Text(
        modifier = modifier,
        text = stringResource(R.string.today_games_header),
        style =
            MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                lineHeightStyle = SingleLineHeightStyle,
            ),
        color = colors.onSurfaceVariant,
    )
}

@Composable
private fun EnableLocationPill(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.colorScheme
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(999.dp),
        color = colors.secondary,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.MyLocation,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
            )
            Text(
                text = stringResource(R.string.enable_location_for_nearby_games),
                style =
                    MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 1.sp,
                        lineHeightStyle = SingleLineHeightStyle,
                    ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
private fun NearbyGamesSectionHeader(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
) {
    val colors = MaterialTheme.colorScheme
    CompositionLocalProvider(LocalContentColor provides colors.onSurfaceVariant) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                )
                Text(
                    text = label.uppercase(Locale.ROOT),
                    style =
                        MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold,
                            lineHeightStyle = SingleLineHeightStyle,
                        ),
                )
            }
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style =
                        MaterialTheme.typography.bodySmall.copy(
                            lineHeightStyle = SingleLineHeightStyle,
                        ),
                )
            }
        }
    }
}

@Composable
private fun TodayGameCard(
    game: TodayGame,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textMeasurer: TextMeasurer? = null,
    showLeagueLabel: Boolean = false,
) {
    val colors = MaterialTheme.colorScheme
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = colors.surfaceContainerHigh,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onClick)
                    .padding(horizontal = 14.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                if (showLeagueLabel) {
                    val leagueLabel = game.home.league.name
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = leagueIconFor(leagueLabel),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = colors.onSurfaceVariant,
                        )
                        Text(
                            text = leagueLabel,
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                lineHeightStyle = SingleLineHeightStyle,
                            ),
                            color = colors.onSurfaceVariant,
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TeamResultRowContent(
                        team = game.away,
                        query = "",
                        textMeasurer = textMeasurer,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TeamResultRowContent(
                        team = game.home,
                        query = "",
                        textMeasurer = textMeasurer,
                    )
                }
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = colors.primary,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun TodayGamesSectionPreview() {
    val sampleGames =
        listOf(
            LeagueGames(
                leagueId = LeagueId.NBA,
                games =
                    listOf(
                        TodayGame(
                            eventId = "1",
                            away = NbaTeamRefs.BOS,
                            home = NbaTeamRefs.LAL,
                        ),
                        TodayGame(
                            eventId = "2",
                            away = NbaTeamRefs.GS,
                            home = NbaTeamRefs.MIA,
                        ),
                    ),
            ),
            LeagueGames(
                leagueId = LeagueId.NHL,
                games =
                    listOf(
                        TodayGame(
                            eventId = "3",
                            away = NhlTeamRefs.BOS,
                            home = NhlTeamRefs.COL,
                        ),
                        TodayGame(
                            eventId = "4",
                            away = NhlTeamRefs.WPG,
                            home = NhlTeamRefs.MIN,
                        ),
                    ),
            ),
        )
    PlayerNumberTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TodayGamesSection(
                state = TodayGamesUiState.Loaded(LocalDate.now(), sampleGames),
                modifier = Modifier.padding(20.dp),
                onGameSelect = {},
                nearbyGames = null,
                locationPermissionGranted = true,
                onRequestLocationPermission = {},
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun TodayGamesSectionNearbyGamesPreview() {
    val sampleGames =
        listOf(
            LeagueGames(
                leagueId = LeagueId.NBA,
                games =
                    listOf(
                        TodayGame(
                            eventId = "1",
                            away = NbaTeamRefs.BOS,
                            home = NbaTeamRefs.LAL,
                        ),
                        TodayGame(
                            eventId = "2",
                            away = NbaTeamRefs.GS,
                            home = NbaTeamRefs.LAC,
                        ),
                    ),
            ),
            LeagueGames(
                leagueId = LeagueId.NHL,
                games =
                    listOf(
                        TodayGame(
                            eventId = "3",
                            away = NhlTeamRefs.BOS,
                            home = NhlTeamRefs.WPG,
                        ),
                    ),
            ),
        )
    val nbaGames = sampleGames.first().games
    val nhlGames = sampleGames[1].games
    val atStadiumGame = nhlGames.first()
    val closestGame = nbaGames[1]
    val atStadium =
        HighlightedGame(
            game = atStadiumGame,
            distanceMeters = 120.0,
        )
    val closest =
        listOf(
            HighlightedGame(
                game = closestGame,
                distanceMeters = 480.0,
            ),
            HighlightedGame(
                game = nbaGames.first(),
                distanceMeters = 920.0,
            ),
        )
    PlayerNumberTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TodayGamesSection(
                state = TodayGamesUiState.Loaded(LocalDate.now(), sampleGames),
                modifier = Modifier.padding(20.dp),
                onGameSelect = {},
                nearbyGames =
                    NearbyGames(
                        atStadium = atStadium,
                        closest = closest,
                    ),
                locationPermissionGranted = true,
                onRequestLocationPermission = {},
            )
        }
    }
}

@Composable
private fun atStadiumLabel(leagueId: LeagueId): Int =
    when (leagueId) {
        LeagueId.NBA,
        LeagueId.NHL,
        -> R.string.nearby_games_at_arena_label
        LeagueId.MLB -> R.string.nearby_games_at_ballpark_label
        else -> R.string.nearby_games_at_stadium_label
    }

@PreviewLightDark
@Composable
private fun TodayGamesSectionLocationPillPreview() {
    val sampleGames =
        listOf(
            LeagueGames(
                leagueId = LeagueId.NBA,
                games =
                    listOf(
                        TodayGame(
                            eventId = "1",
                            away = NbaTeamRefs.BOS,
                            home = NbaTeamRefs.LAL,
                        ),
                    ),
            ),
        )
    PlayerNumberTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TodayGamesSection(
                state = TodayGamesUiState.Loaded(LocalDate.now(), sampleGames),
                modifier = Modifier.padding(20.dp),
                onGameSelect = {},
                nearbyGames = null,
                locationPermissionGranted = false,
                onRequestLocationPermission = {},
            )
        }
    }
}
