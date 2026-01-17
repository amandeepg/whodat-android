package ca.amandeep.playernumber.ui.utils

import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val BOTTOM_FADING_EDGE_SHADER = """
    const half4 BLACK_COLOR = half4(0, 0, 0, 1);
    uniform float2 resolution;
    uniform float bottomFade;
    half4 main(float2 coord) {
        if (bottomFade < 1) {
            return BLACK_COLOR; // no fading needed at all
        } else if (coord.y < resolution.y - bottomFade) {
            return BLACK_COLOR; // no fading needed outside of the fading edge area
        } else {
            // formula: y = ((1 - x)^3 + 3(1 - x)^2 * x)^2
            float x = ((resolution.y - coord.y) / bottomFade); // x is 0 at the BOTTOM
            float y = (1.0 - x) * (1.0 - x) * (1.0 - x) + 3.0 * (1.0 - x) * (1.0 - x) * x;
            float alpha = 1.0 - y * y;
            return half4(0, 0, 0, alpha); // return black color with the calculated alpha
        }
    }
"""

private const val TOP_FADING_EDGE_SHADER = """
    const half4 BLACK_COLOR = half4(0, 0, 0, 1);
    uniform float2 resolution;
    uniform float topFade;
    half4 main(float2 coord) {
        if (topFade < 1) {
            return BLACK_COLOR; // no fading needed at all
        } else if (coord.y > topFade) {
            return BLACK_COLOR; // no fading needed outside of the fading edge area
        } else {
            // formula: y = ((1 - x)^3 + 3(1 - x)^2 * x)^2
            float x = coord.y / topFade; // x is 0 at the TOP
            float y = (1.0 - x) * (1.0 - x) * (1.0 - x) + 3.0 * (1.0 - x) * (1.0 - x) * x;
            float alpha = 1.0 - y * y;
            return half4(0, 0, 0, alpha); // return black color with the calculated alpha
        }
    }
"""

fun Modifier.fadingEdges(
    scrollableState: ScrollableState,
    topEdgeHeight: Dp = 22.dp,
    bottomEdgeHeight: Dp = 22.dp,
) = if (Build.VERSION.SDK_INT >= 33) {
    drawFadingEdgesApi33(
        scrollableState = scrollableState,
        topEdgeHeight = topEdgeHeight,
        bottomEdgeHeight = bottomEdgeHeight,
    )
} else {
    drawFadingEdgesOldApi(
        scrollableState = scrollableState,
        topEdgeHeight = topEdgeHeight,
        bottomEdgeHeight = bottomEdgeHeight,
    )
}

@Stable
@RequiresApi(33)
private fun Modifier.drawFadingEdgesApi33(
    scrollableState: ScrollableState,
    topEdgeHeight: Dp,
    bottomEdgeHeight: Dp,
) = then(
    Modifier
        .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
        .drawWithCache {
            val topEdgeShader = RuntimeShader(TOP_FADING_EDGE_SHADER)
            topEdgeShader.setFloatUniform("resolution", size.width, size.height)
            val topEdgeBrush = ShaderBrush(topEdgeShader)
            val bottomEdgeShader = RuntimeShader(BOTTOM_FADING_EDGE_SHADER)
            bottomEdgeShader.setFloatUniform("resolution", size.width, size.height)
            val bottomEdgeBrush = ShaderBrush(bottomEdgeShader)

            onDrawWithContent {
                drawContent()
                val topEdgeHeightPx = if (scrollableState.canScrollBackward) {
                    topEdgeHeight.toPx()
                } else {
                    0f
                }
                if (topEdgeHeightPx > 1f && topEdgeHeightPx < size.height) {
                    topEdgeShader.setFloatUniform("topFade", topEdgeHeightPx)
                    drawRect(
                        brush = topEdgeBrush,
                        blendMode = BlendMode.DstIn,
                    )
                }
                val bottomEdgeHeightPx = if (scrollableState.canScrollForward) {
                    bottomEdgeHeight.toPx()
                } else {
                    0f
                }
                if (bottomEdgeHeightPx > 1f && bottomEdgeHeightPx < size.height) {
                    bottomEdgeShader.setFloatUniform("bottomFade", bottomEdgeHeightPx)
                    drawRect(
                        brush = bottomEdgeBrush,
                        blendMode = BlendMode.DstIn,
                    )
                }
            }
        },
)

@Stable
private fun Modifier.drawFadingEdgesOldApi(
    scrollableState: ScrollableState,
    topEdgeHeight: Dp,
    bottomEdgeHeight: Dp,
) = then(
    Modifier
        .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
        .drawWithContent {
            drawContent()
            val topEdgeHeightPx = if (scrollableState.canScrollBackward) {
                topEdgeHeight.toPx()
            } else {
                0f
            }
            if (topEdgeHeightPx > 1f && topEdgeHeightPx < size.height) {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 0f,
                        endY = topEdgeHeightPx,
                    ),
                    blendMode = BlendMode.DstIn,
                )
            }
            val bottomEdgeHeightPx = if (scrollableState.canScrollForward) {
                bottomEdgeHeight.toPx()
            } else {
                0f
            }
            if (bottomEdgeHeightPx > 1f && bottomEdgeHeightPx < size.height) {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black, Color.Transparent),
                        startY = size.height - bottomEdgeHeightPx,
                        endY = size.height,
                    ),
                    blendMode = BlendMode.DstIn,
                )
            }
        },
)
