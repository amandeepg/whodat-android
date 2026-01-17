package ca.amandeep.playernumber.ui.jersey

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle

@Composable
internal fun HelperChip(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AssistBubble(
        onClick = onClick,
        modifier = modifier,
    )
}

@Composable
internal fun AssistBubble(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val text = stringResource(R.string.enter_jersey_number)
    val arrowDirection = AssistBubbleDirection.Down
    val arrowAtTop = arrowDirection == AssistBubbleDirection.Up
    val topPadding = HelperChipVerticalPadding + if (arrowAtTop) HelperChipArrowRadius else 0.dp
    val bottomPadding = HelperChipVerticalPadding + if (arrowAtTop) 0.dp else HelperChipArrowRadius
    val arrowAlignment = if (arrowAtTop) Alignment.TopCenter else Alignment.BottomCenter
    val arrowIcon = if (arrowAtTop) {
        Icons.Rounded.KeyboardArrowUp
    } else {
        Icons.Rounded.KeyboardArrowDown
    }

    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = AssistBubbleShape(
            arrowDiameter = HelperChipArrowDiameter,
            cornerRadius = HelperChipCornerRadius,
            arrowDirection = arrowDirection,
        ),
        color = HelperChipContainerColor,
        contentColor = HelperChipLabelColor,
        border = null as BorderStroke?,
    ) {
        Box {
            Box(
                modifier = Modifier.padding(
                    start = HelperChipHorizontalPadding,
                    end = HelperChipHorizontalPadding,
                    top = topPadding,
                    bottom = bottomPadding,
                ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = text,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.5.sp,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeightStyle = SingleLineHeightStyle,
                    ),
                )
            }
            Box(
                modifier = Modifier
                    .align(arrowAlignment)
                    .size(HelperChipArrowDiameter),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = arrowIcon,
                    contentDescription = null,
                    modifier = Modifier.size(HelperChipArrowIconSize),
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 240)
@Composable
private fun HelperChipPreview() {
    PlayerNumberTheme {
        Surface(color = Color(0xFF00205B)) {
            HelperChip(
                onClick = {},
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

internal class AssistBubbleShape(
    private val arrowDiameter: Dp,
    private val cornerRadius: Dp,
    private val arrowDirection: AssistBubbleDirection,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        if (size.width <= 0f || size.height <= 0f) {
            return Outline.Rectangle(Rect(0f, 0f, size.width, size.height))
        }

        val arrowRadius = with(density) { arrowDiameter.toPx() / 2f }
        val rectTop = if (arrowDirection == AssistBubbleDirection.Up) arrowRadius else 0f
        val rectBottom = if (arrowDirection == AssistBubbleDirection.Up) {
            size.height
        } else {
            (size.height - arrowRadius).coerceAtLeast(0f)
        }
        val rectHeight = (rectBottom - rectTop).coerceAtLeast(0f)
        val maxCornerRadius = minOf(size.width / 2f, rectHeight / 2f)
        val corner = with(density) { cornerRadius.toPx() }.coerceAtMost(maxCornerRadius)

        val path = Path().apply {
            addRoundRect(
                RoundRect(
                    rect = Rect(0f, rectTop, size.width, rectBottom),
                    cornerRadius = CornerRadius(corner, corner),
                ),
            )
            if (arrowRadius > 0f) {
                val centerX = size.width / 2f
                val arrowCenterY = if (arrowDirection == AssistBubbleDirection.Up) {
                    rectTop
                } else {
                    rectBottom
                }
                addOval(
                    Rect(
                        left = centerX - arrowRadius,
                        top = arrowCenterY - arrowRadius,
                        right = centerX + arrowRadius,
                        bottom = arrowCenterY + arrowRadius,
                    ),
                )
            }
        }
        return Outline.Generic(path)
    }
}

internal enum class AssistBubbleDirection {
    Up,
    Down,
}

private val HelperChipContainerColor = Color.White.copy(alpha = 0.16f)
private val HelperChipLabelColor = Color.White.copy(alpha = 0.92f)
internal val HelperChipArrowDiameter = 32.dp
internal val HelperChipArrowRadius = HelperChipArrowDiameter / 2
private val HelperChipArrowIconSize = 20.dp
private val HelperChipCornerRadius = 999.dp
private val HelperChipHorizontalPadding = 18.dp
private val HelperChipVerticalPadding = 8.dp
