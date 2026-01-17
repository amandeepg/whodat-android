package ca.amandeep.playernumber.ui.main

import androidx.compose.runtime.Composable
import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalConfiguration
import com.android.tools.screenshot.PreviewTest
import ca.amandeep.playernumber.ui.preview.AppScreenshotPreviewContent

@PreviewTest
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
@Preview(
    name = "Pixel 9 Pro Day",
    device = Devices.PIXEL_9_PRO,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Pixel 9 Pro Night",
    device = Devices.PIXEL_9_PRO,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Pixel 9 Pro XL Day",
    device = Devices.PIXEL_9_PRO_XL,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Pixel 9 Pro XL Night",
    device = Devices.PIXEL_9_PRO_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun MarketingAppScreenshot() {
    val uiMode = LocalConfiguration.current.uiMode
    val isDark = (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    AppScreenshotPreviewContent(darkTheme = isDark)
}
