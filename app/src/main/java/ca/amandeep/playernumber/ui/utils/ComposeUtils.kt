package ca.amandeep.playernumber.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

/**
 * Superellipse / "squircle" shape.
 * exponent:
 *  - 2f  -> circle/ellipse
 *  - ~4–6 -> nice squircle
 *  - higher -> more boxy
 */
internal class SquircleShape(
    private val exponent: Float = 5f,
    private val steps: Int = 50,
) : Shape {
    init {
        require(exponent >= 2f) { "exponent must be >= 2" }
        require(steps >= 16) { "steps must be >= 16" }
    }

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        if (size.width <= 0f || size.height <= 0f) {
            return Outline.Rectangle(Rect(0f, 0f, size.width, size.height))
        }

        val a = size.width / 2f
        val b = size.height / 2f
        val cx = a
        val cy = b

        val p = 2f / exponent
        val path = Path()
        val twoPi = (2.0 * Math.PI).toFloat()

        for (i in 0..steps) {
            val t = twoPi * (i.toFloat() / steps.toFloat())
            val ct = cos(t)
            val st = sin(t)

            val x = cx + a * sign(ct) * abs(ct).pow(p)
            val y = cy + b * sign(st) * abs(st).pow(p)

            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        path.close()
        return Outline.Generic(path)
    }

    private fun sign(value: Float) = if (value < 0f) -1f else 1f
}

@Composable
fun TextUnit.toDp(): Dp = with(LocalDensity.current) { this@toDp.toDp() }

internal val SingleLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.Both,
)
