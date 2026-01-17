package ca.amandeep.playernumber.ui.jersey

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun FloatingAssistBubble(
    text: String,
    arrowDirection: AssistBubbleDirection,
    onClick: () -> Unit,
    baseOffset: Dp,
    modifier: Modifier = Modifier,
    lineAnchorFraction: Float = DEFAULT_ASSIST_LINE_ANCHOR_FRACTION,
) {
    val density = LocalDensity.current
    val basePx = with(density) { baseOffset.toPx() }
    val hintHeightPxState = remember { mutableIntStateOf(0) }
    val hintHeightPx = hintHeightPxState.intValue
    val translationY = if (arrowDirection == AssistBubbleDirection.Down) {
        if (hintHeightPx == 0) basePx else basePx - hintHeightPx
    } else {
        basePx
    }
    val lineColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
    val textColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f)
    val textStyle = MaterialTheme.typography.bodyLarge.copy(lineHeightStyle = SingleLineHeightStyle)

    Column(
        modifier = modifier
            .onSizeChanged { hintHeightPxState.intValue = it.height }
            .graphicsLayer { this.translationY = translationY }
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (arrowDirection == AssistBubbleDirection.Up) {
            AssistHintLine(
                arrowDirection = AssistBubbleDirection.Up,
                color = lineColor,
                anchorFraction = lineAnchorFraction,
            )
            Spacer(modifier = Modifier.height(AssistHintLineSpacing))
        }
        Text(
            text = text,
            color = textColor,
            style = textStyle,
        )
        if (arrowDirection == AssistBubbleDirection.Down) {
            Spacer(modifier = Modifier.height(AssistHintLineSpacing))
            AssistHintLine(
                arrowDirection = AssistBubbleDirection.Down,
                color = lineColor,
                anchorFraction = lineAnchorFraction,
            )
        }
    }
}

@Composable
private fun AssistHintLine(
    arrowDirection: AssistBubbleDirection,
    color: Color,
    anchorFraction: Float,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier.size(AssistHintLineWidth, AssistHintLineHeight)) {
        val strokeWidth = AssistHintLineStrokeWidth.toPx()
        val anchorX = (size.width * anchorFraction).coerceIn(0f, size.width)
        val startY = if (arrowDirection == AssistBubbleDirection.Down) 0f else size.height
        val endY = if (arrowDirection == AssistBubbleDirection.Down) size.height else 0f
        val direction = if (arrowDirection == AssistBubbleDirection.Down) 1f else -1f
        val curveOffset = size.width * 0.26f
        val curveHeight = size.height * 0.32f
        val control1 = Offset(
            x = anchorX + curveOffset,
            y = startY + direction * curveHeight,
        )
        val control2 = Offset(
            x = anchorX + curveOffset,
            y = endY - direction * curveHeight,
        )
        val path = Path().apply {
            moveTo(anchorX, startY)
            cubicTo(
                control1.x,
                control1.y,
                control2.x,
                control2.y,
                anchorX,
                endY,
            )
        }
        val chalkStroke = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        val edgeStroke = Stroke(
            width = strokeWidth * 1.4f,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round,
        )
        val dustEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(strokeWidth * 2.2f, strokeWidth * 1.6f),
            phase = strokeWidth * 0.6f,
        )
        val dustStroke = Stroke(
            width = strokeWidth * 0.9f,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round,
            pathEffect = dustEffect,
        )

        fun drawChalkPath(path: Path) {
            drawPath(
                path = path,
                color = color.copy(alpha = color.alpha * 0.5f),
                style = edgeStroke,
            )
            drawPath(
                path = path,
                color = color,
                style = chalkStroke,
            )
            withTransform({
                translate(
                    left = strokeWidth * 0.4f,
                    top = -strokeWidth * 0.35f,
                )
            }) {
                drawPath(
                    path = path,
                    color = color.copy(alpha = color.alpha * 0.4f),
                    style = dustStroke,
                )
            }
        }

        fun drawChalkLine(
            start: Offset,
            end: Offset,
        ) {
            val linePath = Path().apply {
                moveTo(start.x, start.y)
                lineTo(end.x, end.y)
            }
            drawChalkPath(linePath)
        }
        drawChalkPath(path)
        val arrowLength = AssistHintArrowLength.toPx()
        val arrowWidth = AssistHintArrowWidth.toPx()
        val halfWidth = arrowWidth / 2f
        val tip = Offset(anchorX, endY)
        val tangent = Offset(tip.x - control2.x, tip.y - control2.y)
        val tangentLength = kotlin.math.hypot(tangent.x, tangent.y).coerceAtLeast(0.001f)
        val unitX = tangent.x / tangentLength
        val unitY = tangent.y / tangentLength
        val baseX = -unitX
        val baseY = -unitY
        val angle = atan2(halfWidth, arrowLength)
        val cosAngle = cos(angle)
        val sinAngle = sin(angle)
        val leftDirX = baseX * cosAngle - baseY * sinAngle
        val leftDirY = baseX * sinAngle + baseY * cosAngle
        val rightDirX = baseX * cosAngle + baseY * sinAngle
        val rightDirY = -baseX * sinAngle + baseY * cosAngle
        val left = Offset(tip.x + leftDirX * arrowLength, tip.y + leftDirY * arrowLength)
        val right = Offset(tip.x + rightDirX * arrowLength, tip.y + rightDirY * arrowLength)
        drawChalkLine(tip, left)
        drawChalkLine(tip, right)
    }
}

internal val AssistHintLineWidth = 140.dp
private val AssistHintLineHeight = 56.dp
private val AssistHintLineSpacing = 12.dp
internal val AssistHintLineStrokeWidth = 2.dp
private val AssistHintArrowLength = 12.dp
private val AssistHintArrowWidth = 12.dp
private const val DEFAULT_ASSIST_LINE_ANCHOR_FRACTION = 0.5f
