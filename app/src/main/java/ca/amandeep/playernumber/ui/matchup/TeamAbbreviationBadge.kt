@file:OptIn(ExperimentalTextApi::class)

package ca.amandeep.playernumber.ui.matchup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isUnspecified
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.data.NflTeamRefs
import ca.amandeep.playernumber.data.NhlTeamRefs
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import ca.amandeep.playernumber.ui.utils.legibleBlendToward
import kotlin.math.roundToInt

@Composable
internal fun TeamAbbreviationBadge(
    team: AnyTeam,
    size: Dp,
    modifier: Modifier = Modifier,
    isEmpty: Boolean = false,
) {
    if (isEmpty) {
        val colors = MaterialTheme.colorScheme
        val background = colors.surfaceVariant.copy(alpha = 0.55f)
        val iconTint = colors.onSurfaceVariant.copy(alpha = 0.8f)
        Box(
            modifier =
                modifier
                    .size(size)
                    .clip(CircleShape)
                    .background(background),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Shield,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(size * 0.45f),
            )
        }
        return
    }
    val bg = team.colors.primary.copy(alpha = 0.85f)
    val textColor =
        legibleBlendToward(
            background = bg,
            desiredTextColor = team.colors.nameAccent,
        )
    val labelStyle = MaterialTheme.typography.labelLarge
    val textStyle =
        labelStyle.copy(
            fontWeight = FontWeight.Black,
            letterSpacing = (-0.5).sp,
            lineHeight = labelStyle.fontSize,
            lineHeightStyle = SingleLineHeightStyle,
        )
    val maxFontSize = rememberBadgeMaxFontSize(size = size, textStyle = textStyle)
    val autoSize =
        remember(maxFontSize) {
            TextAutoSize.StepBased(minFontSize = 1.sp, maxFontSize = maxFontSize)
        }

    Box(
        modifier =
            modifier
                .size(size)
                .clip(CircleShape)
                .background(bg),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = size * 0.12f),
            text = team.abbreviation,
            maxLines = 1,
            autoSize = autoSize,
            style = textStyle,
            color = textColor,
        )
    }
}

@Composable
private fun rememberBadgeMaxFontSize(
    size: Dp,
    textStyle: TextStyle,
): TextUnit {
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()
    return remember(size, textStyle, density) {
        val sizePx = with(density) { size.toPx() }.roundToInt()
        val maxWidthPx = sizePx.toFloat()
        if (sizePx <= 0) {
            return@remember 1.sp
        }
        val fontSize =
            if (textStyle.fontSize.isUnspecified) {
                0f
            } else {
                textStyle.fontSize.value
            }
        val key =
            BadgeFontCacheKey(
                sizePx = sizePx,
                fontSizeSp = fontSize,
                fontWeight = textStyle.fontWeight?.weight,
            )
        synchronized(BadgeFontSizeCache) {
            BadgeFontSizeCache.values.getOrPut(key) {
                val maxAllowed = with(density) { size.toSp() }.value.coerceAtLeast(1f)
                var low = 1f
                var high = maxAllowed
                repeat(8) {
                    val mid = (low + high) / 2f
                    val layout =
                        textMeasurer.measure(
                            text = AnnotatedString(TEAM_BADGE_MEASURE_TEXT),
                            style = textStyle.copy(fontSize = mid.sp, lineHeight = mid.sp),
                            maxLines = 1,
                            softWrap = false,
                        )
                    if (layout.size.width <= maxWidthPx) {
                        low = mid
                    } else {
                        high = mid
                    }
                }
                low.sp
            }
        }
    }
}

private data class BadgeFontCacheKey(
    val sizePx: Int,
    val fontSizeSp: Float,
    val fontWeight: Int?,
)

private object BadgeFontSizeCache {
    val values = mutableMapOf<BadgeFontCacheKey, TextUnit>()
}

@PreviewLightDark
@Composable
private fun TeamAbbreviationBadgePreview(
    @PreviewParameter(TeamAbbreviationBadgePreviewProvider::class) preview: TeamAbbreviationBadgePreviewData,
) {
    PlayerNumberTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TeamAbbreviationBadge(
                team = preview.team,
                size = preview.size,
                isEmpty = preview.isEmpty,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

private data class TeamAbbreviationBadgePreviewData(
    val team: AnyTeam,
    val size: Dp,
    val isEmpty: Boolean = false,
)

private class TeamAbbreviationBadgePreviewProvider : PreviewParameterProvider<TeamAbbreviationBadgePreviewData> {
    private val previewValues =
        listOf(
            TeamAbbreviationBadgePreviewData(MlbTeamRefs.TOR, MatchupBadgeSize),
            TeamAbbreviationBadgePreviewData(NbaTeamRefs.BOS, MatchupBadgeSize),
            TeamAbbreviationBadgePreviewData(NhlTeamRefs.CAR, MatchupBadgeSize),
            TeamAbbreviationBadgePreviewData(NflTeamRefs.MIN, MatchupBadgeSize),
            TeamAbbreviationBadgePreviewData(NbaTeamRefs.UTAH, MatchupBadgeSize),
            TeamAbbreviationBadgePreviewData(MlbTeamRefs.TOR, ResultsBadgeSize),
            TeamAbbreviationBadgePreviewData(NbaTeamRefs.BOS, ResultsBadgeSize),
            TeamAbbreviationBadgePreviewData(NhlTeamRefs.CAR, ResultsBadgeSize),
            TeamAbbreviationBadgePreviewData(NflTeamRefs.MIN, ResultsBadgeSize),
            TeamAbbreviationBadgePreviewData(NbaTeamRefs.UTAH, ResultsBadgeSize),
            TeamAbbreviationBadgePreviewData(NbaTeamRefs.BOS, MatchupBadgeSize, isEmpty = true),
            TeamAbbreviationBadgePreviewData(NbaTeamRefs.BOS, ResultsBadgeSize, isEmpty = true),
        )

    override val values: Sequence<TeamAbbreviationBadgePreviewData> = previewValues.asSequence()

    override fun getDisplayName(index: Int): String? {
        val value = previewValues.getOrNull(index) ?: return null
        val sizeLabel =
            when (value.size) {
                MatchupBadgeSize -> "matchup"
                ResultsBadgeSize -> "results"
                else -> "${value.size.value.toInt()}dp"
            }
        val emptyLabel = if (value.isEmpty) "-empty" else ""
        return "${value.team.abbreviation}-$sizeLabel$emptyLabel"
    }
}

private val MatchupBadgeSize = 54.dp
private val ResultsBadgeSize = 36.dp

private const val TEAM_BADGE_MEASURE_TEXT = "MMM"
