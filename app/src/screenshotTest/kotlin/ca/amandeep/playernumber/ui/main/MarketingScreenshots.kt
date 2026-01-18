package ca.amandeep.playernumber.ui.main

import androidx.compose.runtime.Composable
import ca.amandeep.playernumber.ui.preview.Pixel9DayNightPreview
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotLacOkcPreview
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotTeamSelectionPreview
import ca.amandeep.playernumber.ui.preview.PlayerNumberScreenshotTorLaaPreview
import com.android.tools.screenshot.PreviewTest

@PreviewTest
@Pixel9DayNightPreview
@Composable
fun PlayerNumberScreenshotTorLaa() = PlayerNumberScreenshotTorLaaPreview()

@PreviewTest
@Pixel9DayNightPreview
@Composable
fun PlayerNumberScreenshotLacOkc() = PlayerNumberScreenshotLacOkcPreview()

@PreviewTest
@Pixel9DayNightPreview
@Composable
fun PlayerNumberScreenshotTeamSelection() = PlayerNumberScreenshotTeamSelectionPreview()
