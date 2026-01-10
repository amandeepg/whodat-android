package ca.amandeep.playernumber.ui.matchup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme

internal val TeamSelectionActiveBorderWidth = 2.dp
private val TeamSelectionVsSize = 48.dp
private val TeamSelectionVsOuterSize = TeamSelectionVsSize + TeamSelectionActiveBorderWidth * 2
private val TeamSelectionVsBackgroundBorderWidth = 6.dp

private enum class MatchupVsBorderHalf {
    Top,
    Bottom,
}

internal data class BadgeBorderClip(
    val topPx: Float,
    val bottomPx: Float,
)

@Composable
internal fun MatchupVsBadge(
    background: Color,
    backgroundBorderColor: Color,
    topBorderColor: Color,
    bottomBorderColor: Color,
    topBorderClip: BadgeBorderClip?,
    bottomBorderClip: BadgeBorderClip?,
    textColor: Color,
    modifier: Modifier = Modifier,
) {
    val borderWidthPx = with(LocalDensity.current) { TeamSelectionActiveBorderWidth.toPx() }
    val backgroundBorderWidthPx = with(LocalDensity.current) { TeamSelectionVsBackgroundBorderWidth.toPx() }
    val innerRadiusPx = with(LocalDensity.current) { TeamSelectionVsSize.toPx() } / 2f
    Box(
        modifier =
            modifier
                .size(TeamSelectionVsOuterSize)
                .drawWithContent {
                    drawContent()
                    if (backgroundBorderWidthPx > 0f) {
                        val ringRadius = innerRadiusPx - backgroundBorderWidthPx / 2f
                        if (ringRadius > 0f) {
                            drawCircle(
                                color = backgroundBorderColor,
                                radius = ringRadius,
                                style = Stroke(width = backgroundBorderWidthPx),
                            )
                        }
                    }
                    val arcInset = borderWidthPx / 2f
                    val arcSize =
                        Size(
                            width = size.width - borderWidthPx,
                            height = size.height - borderWidthPx,
                        )
                    if (arcSize.width <= 0f || arcSize.height <= 0f) return@drawWithContent
                    drawVsBorderArc(
                        color = topBorderColor,
                        startAngle = 180f,
                        sweepAngle = 180f,
                        borderWidthPx = borderWidthPx,
                        arcInset = arcInset,
                        arcSize = arcSize,
                        borderHalf = MatchupVsBorderHalf.Top,
                        clip = topBorderClip,
                    )
                    drawVsBorderArc(
                        color = bottomBorderColor,
                        startAngle = 0f,
                        sweepAngle = 180f,
                        borderWidthPx = borderWidthPx,
                        arcInset = arcInset,
                        arcSize = arcSize,
                        borderHalf = MatchupVsBorderHalf.Bottom,
                        clip = bottomBorderClip,
                    )
                },
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier.size(TeamSelectionVsSize),
            shape = CircleShape,
            color = background,
            contentColor = textColor.copy(alpha = 0.9f),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.AlternateEmail,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                )
            }
        }
    }
}

internal fun badgeBorderClip(
    activeBounds: Rect?,
    badgeBounds: Rect?,
): BadgeBorderClip? {
    if (activeBounds == null || badgeBounds == null) return null
    val left = maxOf(activeBounds.left, badgeBounds.left)
    val right = minOf(activeBounds.right, badgeBounds.right)
    val top = maxOf(activeBounds.top, badgeBounds.top)
    val bottom = minOf(activeBounds.bottom, badgeBounds.bottom)
    if (right <= left || bottom <= top) return null
    return BadgeBorderClip(
        topPx = top - badgeBounds.top,
        bottomPx = bottom - badgeBounds.top,
    )
}

private fun DrawScope.drawVsBorderArc(
    color: Color,
    startAngle: Float,
    sweepAngle: Float,
    borderWidthPx: Float,
    arcInset: Float,
    arcSize: Size,
    borderHalf: MatchupVsBorderHalf,
    clip: BadgeBorderClip?,
) {
    if (color.alpha == 0f) return
    if (clip == null) {
        drawArc(
            color = color,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = Offset(arcInset, arcInset),
            size = arcSize,
            style = Stroke(width = borderWidthPx),
        )
        return
    }
    val top = clip.topPx.coerceIn(0f, size.height)
    val bottom = clip.bottomPx.coerceIn(0f, size.height)
    if (bottom <= top) return
    clipRect(
        top = top + (if (borderHalf == MatchupVsBorderHalf.Bottom) borderWidthPx else 0f),
        bottom = bottom - (if (borderHalf == MatchupVsBorderHalf.Top) borderWidthPx else 0f),
    ) {
        drawArc(
            color = color,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = Offset(arcInset, arcInset),
            size = arcSize,
            style = Stroke(width = borderWidthPx),
        )
    }
}

@PreviewLightDark
@Composable
private fun MatchupVsBadgePreview() {
    PlayerNumberTheme {
        val colors = MaterialTheme.colorScheme
        Box(modifier = Modifier.padding(16.dp)) {
            MatchupVsBadge(
                background = colors.surfaceContainerHigh,
                backgroundBorderColor = colors.background,
                topBorderColor = colors.primary.copy(alpha = 0.6f),
                bottomBorderColor = Color.Transparent,
                topBorderClip = null,
                bottomBorderClip = null,
                textColor = colors.onSurface,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun MatchupVsBadgeBottomActivePreview() {
    PlayerNumberTheme {
        val colors = MaterialTheme.colorScheme
        Box(modifier = Modifier.padding(16.dp)) {
            MatchupVsBadge(
                background = colors.surfaceContainerHigh,
                backgroundBorderColor = colors.background,
                topBorderColor = Color.Transparent,
                bottomBorderColor = colors.primary.copy(alpha = 0.6f),
                topBorderClip = null,
                bottomBorderClip = null,
                textColor = colors.onSurface,
            )
        }
    }
}
