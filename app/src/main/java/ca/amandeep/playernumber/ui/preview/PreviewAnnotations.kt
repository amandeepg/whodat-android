package ca.amandeep.playernumber.ui.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Pixel_9_Day",
    device = Devices.PIXEL_9,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Pixel_9_Night",
    device = Devices.PIXEL_9,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class Pixel9DayNightPreview
