package ca.amandeep.playernumber.ui.preview

import androidx.compose.runtime.Composable
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.ui.main.MatchupDestinationPreview
import ca.amandeep.playernumber.ui.matchup.TeamSearchEngine
import ca.amandeep.playernumber.ui.matchup.TeamSelectionViewModel
import ca.amandeep.playernumber.ui.matchup.TeamSlot

@Composable
fun PlayerNumberScreenshotTorLaaPreview() = DeviceScreenshot {
    PlayerNumberMarketingPreview(
        jerseyNumber = "27",
        awayTeam = MlbTeamRefs.TOR,
        homeTeam = MlbTeamRefs.LAA,
    )
}

@Composable
fun PlayerNumberScreenshotLacOkcPreview() = DiagonalSplitDeviceScreenshot {
    PlayerNumberMarketingPreview(
        jerseyNumber = "2",
        awayTeam = NbaTeamRefs.LAC,
        homeTeam = NbaTeamRefs.OKC,
    )
}

@Composable
fun PlayerNumberScreenshotTeamSelectionPreview() = DeviceScreenshot {
    val searchTerm = "san "
    val state = TeamSelectionViewModel.State(
        awayQuery = searchTerm,
        activeSlot = TeamSlot.Away,
        groupedMatches = TeamSearchEngine().search(searchTerm, ""),
    )
    MatchupDestinationPreview(
        awayTeam = NbaTeamRefs.LAC,
        homeTeam = NbaTeamRefs.CHI,
        state = state,
    )
}

@Composable
@Pixel9DayNightPreview
private fun PlayerNumberScreenshotTorLaaPreviewWrapper() = PlayerNumberScreenshotTorLaaPreview()

@Composable
@Pixel9DayNightPreview
private fun PlayerNumberScreenshotLacOkcPreviewWrapper() = PlayerNumberScreenshotLacOkcPreview()

@Composable
@Pixel9DayNightPreview
private fun PlayerNumberScreenshotTeamSelectionPreviewWrapper() = PlayerNumberScreenshotTeamSelectionPreview()
