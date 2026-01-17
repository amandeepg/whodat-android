package ca.amandeep.playernumber.ui.jersey

import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.ui.adaptive.SizeBreakpoints

internal const val HEIGHT_MEDIUM_LOWER_BOUND = 400
internal const val HEIGHT_LARGE_LOWER_BOUND = 550

internal val HeightBreakpoints = SizeBreakpoints(
    mediumLowerBound = HEIGHT_MEDIUM_LOWER_BOUND.dp,
    largeLowerBound = HEIGHT_LARGE_LOWER_BOUND.dp,
)

internal const val WIDTH_MEDIUM_LOWER_BOUND = 600
internal const val WIDTH_LARGE_LOWER_BOUND = 840

internal val WidthBreakpoints = SizeBreakpoints(
    mediumLowerBound = WIDTH_MEDIUM_LOWER_BOUND.dp,
    largeLowerBound = WIDTH_LARGE_LOWER_BOUND.dp,
)
