package ca.amandeep.playernumber.ui.adaptive

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

enum class SizeBucket {
    Small,
    Medium,
    Large,
}

data class SizeBreakpoints(
    val mediumLowerBound: Dp,
    val largeLowerBound: Dp,
)

fun resolveHeightBucket(
    windowWidthDp: Dp,
    windowHeightDp: Dp,
    breakpoints: SizeBreakpoints,
): SizeBucket {
    val effectiveHeightDp = maxOf(windowWidthDp, windowHeightDp)
    return calculateSizeBucket(effectiveHeightDp, breakpoints)
}

fun resolveWidthBucket(
    windowWidthDp: Dp,
    windowHeightDp: Dp,
    breakpoints: SizeBreakpoints,
): SizeBucket {
    val effectiveWidthDp = minOf(windowWidthDp, windowHeightDp)
    return calculateSizeBucket(effectiveWidthDp, breakpoints)
}

private fun calculateSizeBucket(
    sizeDp: Dp,
    breakpoints: SizeBreakpoints,
): SizeBucket =
    when {
        sizeDp >= breakpoints.largeLowerBound -> SizeBucket.Large
        sizeDp >= breakpoints.mediumLowerBound -> SizeBucket.Medium
        else -> SizeBucket.Small
    }

@Composable
internal fun PreviewWindowSizeClassHint(
    widthBucket: SizeBucket,
    heightBucket: SizeBucket,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier,
) {
    @Suppress("ConstantConditionIf")
    if (false) return

    if (!LocalInspectionMode.current) return

    Surface(
        color = Color.Black.copy(alpha = 0.35f),
        contentColor = Color.White.copy(alpha = 0.85f),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier.padding(8.dp),
    ) {
        Text(
            text =
                "W:${widthBucket.name} (${width.value.roundToInt()}dp)\n" +
                    "H:${heightBucket.name} (${height.value.roundToInt()}dp)",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}
