package ca.amandeep.playernumber.ui.matchup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.theme.withFontWidth
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import ca.amandeep.playernumber.ui.utils.fadingEdges
import java.util.Locale

@Composable
internal fun TeamSearchResults(
    groupedMatches: List<TeamSearchEngine.LeagueMatches>,
    query: String,
    onTeamSelect: (AnyTeam) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val listState = rememberLazyListState()
    val textMeasurer = rememberTextMeasurer()
    val fadeModifier = Modifier.fadingEdges(listState)
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .then(fadeModifier),
        state = listState,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        groupedMatches.forEach { section ->
            item {
                LeagueSectionHeader(
                    leagueLabel = section.leagueLabel,
                )
            }
            items(section.teams, key = { team -> "${section.leagueLabel}:${team.abbreviation}" }) { team ->
                TeamResultRow(
                    team = team,
                    query = query,
                    onTeamSelect = onTeamSelect,
                    textMeasurer = textMeasurer,
                )
            }
        }
    }
}

@Composable
internal fun LeagueSectionHeader(
    leagueLabel: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Icon(
            imageVector = leagueIconFor(leagueLabel),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
        )
        Text(
            text = leagueLabel,
            style =
                MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    lineHeightStyle = SingleLineHeightStyle,
                ),
        )
    }
}

@Composable
internal fun RowScope.TeamResultRowContent(
    team: AnyTeam,
    query: String,
    modifier: Modifier = Modifier,
    textMeasurer: TextMeasurer? = null,
) {
    val colors = MaterialTheme.colorScheme
    val titleStyleBase = MaterialTheme.typography.titleLarge
    TeamAbbreviationBadge(team = team, size = 36.dp)
    BoxWithConstraints(modifier = modifier.weight(1f)) {
        val textStyleBase =
            titleStyleBase.copy(
                fontWeight = FontWeight.Normal,
                lineHeight = titleStyleBase.fontSize,
                lineHeightStyle = SingleLineHeightStyle,
            )
        val fontWidth =
            if (textMeasurer != null) {
                val maxWidthPx = constraints.maxWidth.toFloat().coerceAtLeast(0f)
                computeFittingFontWidth(
                    textMeasurer = textMeasurer,
                    textStyle = textStyleBase,
                    maxWidthPx = maxWidthPx,
                )
            } else {
                rememberFittingFontWidth(
                    textStyle = textStyleBase,
                    maxWidth = maxWidth,
                )
            }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = highlightMatch(team.name, query, colors.primary),
            style = textStyleBase.withFontWidth(fontWidth),
            color = colors.onSurface,
            autoSize = TextAutoSize.StepBased(maxFontSize = textStyleBase.fontSize),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun TeamResultRow(
    team: AnyTeam,
    query: String,
    onTeamSelect: (AnyTeam) -> Unit,
    modifier: Modifier = Modifier,
    textMeasurer: TextMeasurer? = null,
) {
    val colors = MaterialTheme.colorScheme
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = colors.surfaceContainerHigh,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .clickable { onTeamSelect(team) }
                    .padding(horizontal = 14.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TeamResultRowContent(
                team = team,
                query = query,
                textMeasurer = textMeasurer,
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = colors.primary,
            )
        }
    }
}

private fun highlightMatch(
    text: String,
    query: String,
    highlight: Color,
) = buildAnnotatedString {
    if (query.isBlank()) {
        append(text)
        return@buildAnnotatedString
    }
    val lower = text.lowercase(Locale.ROOT)
    val match = query.trim().lowercase(Locale.ROOT)
    val index = lower.indexOf(match)
    if (index < 0) {
        append(text)
        return@buildAnnotatedString
    }
    append(text.substring(0, index))
    withStyle(SpanStyle(color = highlight, textDecoration = TextDecoration.Underline)) {
        append(text.substring(index, index + match.length))
    }
    append(text.substring(index + match.length))
}

@PreviewLightDark
@Composable
private fun TeamSearchResultsPreview() {
    val query = "New"
    val searchEngine = remember { TeamSearchEngine() }
    val groupedMatches =
        remember(searchEngine, query) {
            searchEngine.search(query, "")
        }
    PlayerNumberTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TeamSearchResults(
                modifier = Modifier.padding(20.dp),
                groupedMatches = groupedMatches,
                query = query,
                onTeamSelect = {},
            )
        }
    }
}
