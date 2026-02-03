package ca.amandeep.playernumber.ui.main

import androidx.compose.runtime.Composable
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotLacOkcPreview
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotTeamSelectionAtStadiumPreview
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotTeamSelectionPreview
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotTorLaaPreview
import ca.amandeep.playernumber.ui.preview.PreviewPixel9DayNight
import com.android.tools.screenshot.PreviewTest

@PreviewTest
@PreviewPixel9DayNight
@Composable
private fun PlayerNumberScreenshotTorLaa() = PlayerNumberScreenshotTorLaaPreview()

@PreviewTest
@PreviewPixel9DayNight
@Composable
private fun PlayerNumberScreenshotLacOkc() = PlayerNumberScreenshotLacOkcPreview()

@PreviewTest
@PreviewPixel9DayNight
@Composable
private fun PlayerNumberScreenshotTeamSelection() = PlayerNumberScreenshotTeamSelectionPreview()

@PreviewTest
@PreviewPixel9DayNight
@Composable
private fun PlayerNumberScreenshotTeamSelectionAtStadium() = PlayerNumberScreenshotTeamSelectionAtStadiumPreview()
