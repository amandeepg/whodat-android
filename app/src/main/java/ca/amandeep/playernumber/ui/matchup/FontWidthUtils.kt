package ca.amandeep.playernumber.ui.matchup

import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.isUnspecified
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.ui.theme.FontWidth
import ca.amandeep.playernumber.ui.theme.withFontWidth
import kotlin.math.roundToInt

internal fun computeFittingFontWidth(
    textMeasurer: TextMeasurer,
    textStyle: TextStyle,
    maxWidthPx: Float,
): FontWidth? {
    val safeWidth = maxWidthPx.coerceAtLeast(0f)
    val fontSize =
        if (textStyle.fontSize.isUnspecified) {
            0f
        } else {
            textStyle.fontSize.value
        }
    val cacheKey =
        FontWidthCacheKey(
            maxWidthPx = safeWidth.roundToInt(),
            fontSizeSp = fontSize,
            fontWeight = textStyle.fontWeight?.weight,
        )
    return synchronized(FontWidthCache) {
        val cached =
            FontWidthCache.values.getOrPut(cacheKey) {
                val text = NbaTeamRefs.POR.name
                val defaultMeasured =
                    textMeasurer.measure(
                        text = text,
                        style = textStyle,
                        maxLines = 1,
                    )
                if (defaultMeasured.size.width <= safeWidth) {
                    FontWidthCacheValue.NoChange
                } else {
                    val width =
                        WidthOptions.firstOrNull { width ->
                            val measured =
                                textMeasurer.measure(
                                    text = text,
                                    style = textStyle.withFontWidth(width),
                                    maxLines = 1,
                                )
                            measured.size.width <= safeWidth
                        } ?: FontWidth.SuperCondensed
                    FontWidthCacheValue.Width(width)
                }
            }
        when (cached) {
            FontWidthCacheValue.NoChange -> null
            is FontWidthCacheValue.Width -> cached.value
        }
    }
}

private val WidthOptions = FontWidth.entries.sortedByDescending { it.axisValue }

private data class FontWidthCacheKey(
    val maxWidthPx: Int,
    val fontSizeSp: Float,
    val fontWeight: Int?,
)

private object FontWidthCache {
    val values = mutableMapOf<FontWidthCacheKey, FontWidthCacheValue>()
}

private sealed interface FontWidthCacheValue {
    data object NoChange : FontWidthCacheValue

    data class Width(
        val value: FontWidth,
    ) : FontWidthCacheValue
}
