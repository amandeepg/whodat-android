package ca.amandeep.playernumber.ui.preview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme

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
                modifier =
                    Modifier
                        .fillMaxSize()
                        .consumeWindowInsets(WindowInsets(top = SyntheticStatusBarHeight / 2)),
            ) {
                content()
                SyntheticStatusBar(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                )
            }
        }
    }
}

@Composable
internal fun DiagonalSplitDeviceScreenshot(content: @Composable () -> Unit) {
    val dividerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = DIAGONAL_DIVIDER_ALPHA)
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .diagonalClip(clipTopRight = true),
        ) {
            DeviceScreenshot(
                darkTheme = isSystemInDarkTheme(),
                content = content,
            )
        }
        Box(
            modifier =
                Modifier
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
                strokeWidth = DIAGONAL_DIVIDER_STROKE_WIDTH.toPx(),
            )
        }
    }
}

private fun Modifier.diagonalClip(clipTopRight: Boolean): Modifier =
    drawWithContent {
        val path =
            Path().apply {
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

private const val DIAGONAL_DIVIDER_ALPHA = 0.6f
private val DIAGONAL_DIVIDER_STROKE_WIDTH: Dp = 4.dp
