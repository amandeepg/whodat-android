package ca.amandeep.playernumber.ui.preview

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.data.JerseyNumber
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.MlbTeams
import ca.amandeep.playernumber.data.StaticRosterLookup
import ca.amandeep.playernumber.data.teamId
import ca.amandeep.playernumber.data.api.RosterSource
import ca.amandeep.playernumber.ui.jersey.PlayerNumberScreen
import ca.amandeep.playernumber.ui.jersey.PlayerNumberUiState
import ca.amandeep.playernumber.ui.jersey.RosterStatus
import ca.amandeep.playernumber.ui.jersey.TeamRosterUiState
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle

@Composable
@Preview(
    name = "Pixel 9 Day",
    device = Devices.PIXEL_9,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Pixel 9 Night",
    device = Devices.PIXEL_9,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
private fun AppScreenshotPreview() {
    val uiMode = LocalConfiguration.current.uiMode
    val isDark = (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    AppScreenshotPreviewContent(darkTheme = isDark)
}

@Composable
internal fun AppScreenshotPreviewContent(darkTheme: Boolean) {
    PlayerNumberTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                val previewState = remember { buildPreviewState() }
                PlayerNumberScreen(
                    state = previewState,
                    onJerseyInputChange = { },
                    onTeamSelectorClick = { },
                    modifier = Modifier
                        .fillMaxSize()
                        .consumeWindowInsets(WindowInsets(top = SyntheticStatusBarHeight)),
                )
                SyntheticStatusBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                )
            }
        }
    }
}

@Composable
private fun SyntheticStatusBar(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(SyntheticStatusBarHeight)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = StatusBarHorizontalPadding,
                        vertical = StatusBarVerticalPadding
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = PREVIEW_TIME,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        lineHeightStyle = SingleLineHeightStyle,
                    ),
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(StatusBarIconSpacing),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.status_cell_4_bar),
                        contentDescription = null,
                        modifier = Modifier.size(StatusBarIconSize),
                    )
                    Icon(
                        painter = painterResource(R.drawable.status_wifi),
                        contentDescription = null,
                        modifier = Modifier.size(StatusBarIconSize),
                    )
                    Icon(
                        painter = painterResource(R.drawable.status_battery),
                        contentDescription = null,
                        modifier = Modifier.size(StatusBarIconSize),
                    )
                }
            }
        }
    }
}

private fun buildPreviewState(): PlayerNumberUiState {
    val previewNumber = JerseyNumber.from(PREVIEW_JERSEY_NUMBER)!!
    val awayPlayer = StaticRosterLookup.findPlayer(PreviewAwayTeam.teamId(), previewNumber)
    val homePlayer = StaticRosterLookup.findPlayer(PreviewHomeTeam.teamId(), previewNumber)

    return PlayerNumberUiState(
        jerseyNumber = PREVIEW_JERSEY_NUMBER,
        away = TeamRosterUiState(
            team = PreviewAwayTeam,
            player = awayPlayer,
            rosterStatus = PreviewRosterStatus,
        ),
        home = TeamRosterUiState(
            team = PreviewHomeTeam,
            player = homePlayer,
            rosterStatus = PreviewRosterStatus,
        ),
    )
}

private const val PREVIEW_TIME = "9:06"
private const val PREVIEW_JERSEY_NUMBER = "27"
private val PreviewAwayTeam = MlbTeamRefs.TOR
private val PreviewHomeTeam = MlbTeamRefs.LAA
private val PreviewRosterStatus = RosterStatus(
    source = RosterSource.STATIC,
    lastUpdatedMillis = null,
)
private val SyntheticStatusBarHeight = 34.dp
private val StatusBarHorizontalPadding = 18.dp
private val StatusBarVerticalPadding = 6.dp
private val StatusBarIconSpacing = 6.dp
private val StatusBarIconSize = 16.dp
