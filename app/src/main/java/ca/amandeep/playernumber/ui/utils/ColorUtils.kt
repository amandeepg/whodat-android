package ca.amandeep.playernumber.ui.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.luminance
import kotlin.math.max
import kotlin.math.min

private fun contrastRatio(
    bg: Color,
    fg: Color,
): Double {
    val l1 = bg.luminance().toDouble()
    val l2 = fg.luminance().toDouble()
    val lighter = max(l1, l2)
    val darker = min(l1, l2)
    return (lighter + 0.05) / (darker + 0.05)
}

private fun mostLegibleOn(background: Color): Color {
    val black = Color.Black
    val white = Color.White
    return if (contrastRatio(background, black) >= contrastRatio(background, white)) black else white
}

/**
 * Blend the most-legible base (black/white) toward desiredTextColor while keeping contrast >= minContrast.
 *
 * minContrast:
 *  - 4.5 for normal body text
 *  - 3.0 for large text
 */
fun legibleBlendToward(
    background: Color,
    onBackground: Color = mostLegibleOn(background),
    desiredTextColor: Color,
    minContrast: Double = 4.5,
): Color {
    // If desired already passes, use it.
    if (contrastRatio(background, desiredTextColor) >= minContrast) return desiredTextColor

    // Otherwise, binary search the largest blend factor that still passes.
    var lo = 0f
    var hi = 1f
    repeat(20) {
        val mid = (lo + hi) / 2f
        val candidate = lerp(onBackground, desiredTextColor, mid)
        if (contrastRatio(background, candidate) >= minContrast) lo = mid else hi = mid
    }
    return lerp(onBackground, desiredTextColor, lo)
}

fun themedTeamBackground(
    base: Color,
    isDarkTheme: Boolean,
    lightBlend: Float = 0.18f,
    darkBlend: Float = 0.12f,
): Color {
    val target = if (isDarkTheme) Color.Black else Color.White
    val blend = if (isDarkTheme) darkBlend else lightBlend
    return lerp(base, target, blend)
}
