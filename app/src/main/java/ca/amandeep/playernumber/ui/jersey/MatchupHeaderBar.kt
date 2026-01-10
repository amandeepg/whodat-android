package ca.amandeep.playernumber.ui.jersey

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.MlbTeams
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle

@Composable
internal fun MatchupHeaderBar(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
    onTeamSelectorClick: () -> Unit,
    modifier: Modifier = Modifier,
    onChevronPosition: (Offset) -> Unit = {},
    onPillPosition: (Rect) -> Unit = {},
) {
    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(4.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        val pillColor = MaterialTheme.colorScheme.surfaceVariant
        val pillContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        val borderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        val glassColor = pillColor.copy(alpha = 0.28f)
        val labelStyle = MaterialTheme.typography.labelLarge
        val singleLineLabelStyle =
            labelStyle.copy(
                lineHeight = labelStyle.fontSize,
                lineHeightStyle = SingleLineHeightStyle,
            )
        Surface(
            onClick = onTeamSelectorClick,
            color = glassColor,
            contentColor = pillContentColor,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, borderColor),
            modifier =
                Modifier.onGloballyPositioned { coordinates ->
                    onPillPosition(coordinates.boundsInWindow())
                },
        ) {
            Row(
                modifier =
                    Modifier.padding(
                        start = 15.dp,
                        end = 8.dp,
                        top = 4.dp,
                        bottom = 4.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val baseContentColor = LocalContentColor.current
                Text(
                    text = awayTeam.abbreviation,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    style = singleLineLabelStyle,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.matchup_at_separator),
                    color = baseContentColor.copy(alpha = 0.6f),
                    style = singleLineLabelStyle,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = homeTeam.abbreviation,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    style = singleLineLabelStyle,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.select_teams_content_description),
                    tint = baseContentColor.copy(alpha = 0.7f),
                    modifier =
                        Modifier
                            .size(20.dp)
                            .onGloballyPositioned { coordinates ->
                                val position = coordinates.positionInWindow()
                                val center =
                                    Offset(
                                        x = position.x + coordinates.size.width / 2f,
                                        y = position.y + coordinates.size.height / 2f,
                                    )
                                onChevronPosition(center)
                            },
                )
            }
        }
    }
}

@Composable
private fun MatchupHeaderBarPreviewContent(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
) {
    PlayerNumberTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            MatchupHeaderBar(
                awayTeam = awayTeam,
                homeTeam = homeTeam,
                onTeamSelectorClick = {},
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun MatchupHeaderBarPreview(
    @PreviewParameter(MatchupHeaderBarPreviewProvider::class) matchup: MatchupHeaderBarPreviewData,
) {
    MatchupHeaderBarPreviewContent(awayTeam = matchup.awayTeam, homeTeam = matchup.homeTeam)
}

private data class MatchupHeaderBarPreviewData(
    val awayTeam: AnyTeam,
    val homeTeam: AnyTeam,
)

private class MatchupHeaderBarPreviewProvider : PreviewParameterProvider<MatchupHeaderBarPreviewData> {
    private val previewValues =
        listOf(
            MatchupHeaderBarPreviewData(
                awayTeam = MlbTeams.first { it.abbreviation == "TOR" },
                homeTeam = MlbTeams.first { it.abbreviation == "LAA" },
            ),
            MatchupHeaderBarPreviewData(
                awayTeam = MlbTeams.first { it.abbreviation == "NYY" },
                homeTeam = MlbTeams.first { it.abbreviation == "BOS" },
            ),
            MatchupHeaderBarPreviewData(
                awayTeam = MlbTeams.first { it.abbreviation == "LAD" },
                homeTeam = MlbTeams.first { it.abbreviation == "CHC" },
            ),
        )

    override val values: Sequence<MatchupHeaderBarPreviewData> = previewValues.asSequence()

    override fun getDisplayName(index: Int): String? {
        val value = previewValues.getOrNull(index) ?: return null
        return "${value.awayTeam.abbreviation} @ ${value.homeTeam.abbreviation}"
    }
}
