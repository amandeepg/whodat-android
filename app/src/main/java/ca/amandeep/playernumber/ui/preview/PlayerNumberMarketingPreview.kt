package ca.amandeep.playernumber.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.JerseyNumber
import ca.amandeep.playernumber.data.StaticRosterLookup
import ca.amandeep.playernumber.data.teamId
import ca.amandeep.playernumber.data.api.RosterSource
import ca.amandeep.playernumber.ui.jersey.PlayerNumberScreen
import ca.amandeep.playernumber.ui.jersey.PlayerNumberUiState
import ca.amandeep.playernumber.ui.jersey.RosterStatus
import ca.amandeep.playernumber.ui.jersey.TeamRosterUiState

@Composable
internal fun PlayerNumberMarketingPreview(
    jerseyNumber: String,
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
) {
    PlayerNumberScreen(
        state = remember {
            buildPreviewState(
                jerseyNumber = jerseyNumber,
                awayTeam = awayTeam,
                homeTeam = homeTeam,
            )
        },
        onJerseyInputChange = { },
        onTeamSelectorClick = { },
    )
}

private fun buildPreviewState(
    jerseyNumber: String,
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
): PlayerNumberUiState {
    val previewNumber = JerseyNumber.from(jerseyNumber)!!
    val awayPlayer = StaticRosterLookup.findPlayer(awayTeam.teamId(), previewNumber)
    val homePlayer = StaticRosterLookup.findPlayer(homeTeam.teamId(), previewNumber)

    return PlayerNumberUiState(
        jerseyNumber = jerseyNumber,
        away = TeamRosterUiState(
            team = awayTeam,
            player = awayPlayer,
            rosterStatus = PreviewRosterStatus,
        ),
        home = TeamRosterUiState(
            team = homeTeam,
            player = homePlayer,
            rosterStatus = PreviewRosterStatus,
        ),
    )
}
private val PreviewRosterStatus = RosterStatus(
    source = RosterSource.STATIC,
    lastUpdatedMillis = null,
)
