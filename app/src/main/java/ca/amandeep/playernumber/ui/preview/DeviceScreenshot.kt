package ca.amandeep.playernumber.ui.preview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.clipPath
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.ui.theme.LocalSystemDarkTheme
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle

@Composable
internal fun DeviceScreenshot(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    PlayerNumberTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .consumeWindowInsets(WindowInsets(top = SyntheticStatusBarHeight / 2))
                ,
            ) {
                content()
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
internal fun DiagonalSplitDeviceScreenshot(
    content: @Composable () -> Unit,
) {
    val dividerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = DiagonalDividerAlpha)
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .diagonalClip(clipTopRight = true),
        ) {
            DeviceScreenshot(
                darkTheme = isSystemInDarkTheme(),
                content = content,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .diagonalClip(clipTopRight = false),
        ) {
            DeviceScreenshot(
                darkTheme = !isSystemInDarkTheme(),
                content = content,
            )
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawLine(
                color = dividerColor,
                start = Offset.Zero,
                end = Offset(size.width, size.height),
                strokeWidth = DiagonalDividerStrokeWidth.toPx(),
            )
        }
    }
}


private fun Modifier.diagonalClip(clipTopRight: Boolean): Modifier = drawWithContent {
    val path = Path().apply {
        if (clipTopRight) {
            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width, size.height)
        } else {
            moveTo(0f, 0f)
            lineTo(0f, size.height)
            lineTo(size.width, size.height)
        }
        close()
    }
    clipPath(path) {
        this@drawWithContent.drawContent()
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

private const val PREVIEW_TIME = "9:06"
private const val DiagonalDividerAlpha = 0.6f
private val DiagonalDividerStrokeWidth: Dp = 4.dp
private val SyntheticStatusBarHeight = 45.dp
private val StatusBarHorizontalPadding = 25.dp
private val StatusBarVerticalPadding = 6.dp
private val StatusBarIconSpacing = 6.dp
private val StatusBarIconSize = 16.dp
