package ca.amandeep.playernumber.ui.jersey

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme

@Composable
internal fun AssistHintsOverlay(
    showHints: Boolean,
    onRequestFocus: () -> Unit,
    onTeamSelectorClick: () -> Unit,
    jerseyArrowOffsetFromTop: Dp,
    jerseyAnchorFraction: Float,
    teamSelectorArrowOffsetFromTop: Dp,
    teamSelectorAnchorFraction: Float,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = showHints,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.TopCenter,
        ) {
            FloatingAssistBubble(
                text = stringResource(R.string.enter_jersey_number),
                arrowDirection = AssistBubbleDirection.Down,
                onClick = onRequestFocus,
                baseOffset = jerseyArrowOffsetFromTop,
                lineAnchorFraction = jerseyAnchorFraction,
            )
            FloatingAssistBubble(
                text = stringResource(R.string.change_teams_hint),
                arrowDirection = AssistBubbleDirection.Up,
                onClick = onTeamSelectorClick,
                baseOffset = teamSelectorArrowOffsetFromTop,
                lineAnchorFraction = teamSelectorAnchorFraction,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun AssistHintsOverlayPreview() {
    PlayerNumberTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Box(
                modifier = Modifier.size(320.dp, 520.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                AssistHintsOverlay(
                    showHints = true,
                    onRequestFocus = {},
                    onTeamSelectorClick = {},
                    jerseyArrowOffsetFromTop = 240.dp,
                    jerseyAnchorFraction = DEFAULT_JERSEY_HINT_ANCHOR_FRACTION,
                    teamSelectorArrowOffsetFromTop = DefaultTeamSelectorAssistOffset,
                    teamSelectorAnchorFraction = DEFAULT_TEAM_HINT_ANCHOR_FRACTION,
                    modifier = Modifier,
                )
            }
        }
    }
}

internal val DefaultTeamSelectorAssistOffset = HelperChipArrowRadius + 6.dp
internal const val DEFAULT_JERSEY_HINT_ANCHOR_FRACTION = 0.66f
internal const val DEFAULT_TEAM_HINT_ANCHOR_FRACTION = 0.84f
