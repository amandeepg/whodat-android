package ca.amandeep.playernumber.ui.jersey

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ca.amandeep.playernumber.data.MlbTeams
import ca.amandeep.playernumber.data.api.RosterSource
import ca.amandeep.playernumber.ui.adaptive.PreviewWindowSizeClassHint
import ca.amandeep.playernumber.ui.adaptive.SizeBucket
import ca.amandeep.playernumber.ui.adaptive.resolveHeightBucket
import ca.amandeep.playernumber.ui.adaptive.resolveWidthBucket
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.themedTeamBackground
import kotlin.math.sqrt

@Composable
fun PlayerNumberScreen(
    state: PlayerNumberUiState,
    onJerseyInputChange: (String) -> Unit,
    onTeamSelectorClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val actions = rememberPlayerNumberActions(onJerseyInputChange, onTeamSelectorClick)
    PlayerNumberScreenContent(
        state = state,
        actions = actions,
        modifier = modifier,
    )
}

@Composable
private fun PlayerNumberScreenContent(
    state: PlayerNumberUiState,
    actions: PlayerNumberActions,
    modifier: Modifier = Modifier,
) {
    val showHints = state.jerseyNumber.isBlank()
    val focusRequester = rememberNumberEntryFocusRequester(showHints)
    val chevronCenterInWindow: MutableState<Offset?> = remember { mutableStateOf(null) }
    val pillBoundsInWindow: MutableState<Rect?> = remember { mutableStateOf(null) }
    val rootBoundsState = remember { mutableStateOf<LayoutBounds?>(null) }
    val bodyBoundsState = remember { mutableStateOf<LayoutBounds?>(null) }
    val layoutState = remember { mutableStateOf<PlayerNumberLayout?>(null) }
    val hintsReady by remember {
        derivedStateOf {
            val rootBounds = rootBoundsState.value
            val bodyBounds = bodyBoundsState.value
            val layout = layoutState.value
            val teamTargetReady =
                pillBoundsInWindow.value != null || chevronCenterInWindow.value != null
            rootBounds != null && bodyBounds != null && layout != null && teamTargetReady
        }
    }
    val assistTargets =
        rememberAssistHintTargets(
            chevronCenterInWindow = chevronCenterInWindow.value,
            pillBoundsInWindow = pillBoundsInWindow.value,
            rootBounds = rootBoundsState.value,
            bodyBounds = bodyBoundsState.value,
            layout = layoutState.value,
        )

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .onGloballyPositioned { coordinates ->
                    rootBoundsState.value =
                        LayoutBounds(
                            topLeft = coordinates.positionInWindow(),
                            size = coordinates.size,
                        )
                },
    ) {
        Scaffold(
            topBar = {
                PlayerNumberTopBar(
                    state = state,
                    actions = actions,
                    onChevronPosition = { chevronCenterInWindow.value = it },
                    onPillPosition = { pillBoundsInWindow.value = it },
                )
            },
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            PlayerNumberBody(
                state = state,
                actions = actions,
                focusRequester = focusRequester,
                onBodyBoundsChange = { bounds ->
                    if (bodyBoundsState.value != bounds) {
                        bodyBoundsState.value = bounds
                    }
                },
                onLayoutChange = { layout ->
                    if (layoutState.value != layout) {
                        layoutState.value = layout
                    }
                },
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .imePadding(),
            )
        }
        AssistHintsOverlay(
            showHints = showHints && hintsReady,
            onRequestFocus = { focusRequester.requestFocus() },
            onTeamSelectorClick = actions.onTeamSelectorClick,
            jerseyArrowOffsetFromTop = assistTargets.jerseyBaseOffset,
            jerseyAnchorFraction = assistTargets.jerseyAnchorFraction,
            teamSelectorArrowOffsetFromTop = assistTargets.teamBaseOffset,
            teamSelectorAnchorFraction = assistTargets.teamAnchorFraction,
            modifier =
                Modifier
                    .fillMaxSize()
                    .zIndex(ASSIST_HINTS_OVERLAY_Z_INDEX),
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PlayerNumberTopBar(
    state: PlayerNumberUiState,
    actions: PlayerNumberActions,
    onChevronPosition: (Offset) -> Unit,
    onPillPosition: (Rect) -> Unit,
) {
    val surfaceColor = MaterialTheme.colorScheme.surface
    val isDarkTheme = isSystemInDarkTheme()
    val awayBaseColor =
        remember(state.away.team.colors.primary, isDarkTheme) {
            themedTeamBackground(state.away.team.colors.primary, isDarkTheme)
        }
    val topBarContainerColor =
        remember(awayBaseColor, surfaceColor) {
            lerp(awayBaseColor, surfaceColor, TOP_BAR_BLEND_FRACTION)
        }

    TopAppBar(
        title = {
            MatchupHeaderBar(
                awayTeam = state.away.team,
                homeTeam = state.home.team,
                onTeamSelectorClick = actions.onTeamSelectorClick,
                onChevronPosition = onChevronPosition,
                onPillPosition = onPillPosition,
            )
        },
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = topBarContainerColor,
                scrolledContainerColor = topBarContainerColor,
            ),
    )
}

@Composable
private fun PlayerNumberBody(
    state: PlayerNumberUiState,
    actions: PlayerNumberActions,
    focusRequester: FocusRequester,
    onBodyBoundsChange: (LayoutBounds) -> Unit,
    onLayoutChange: (PlayerNumberLayout) -> Unit,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(
        modifier =
            modifier.onGloballyPositioned { coordinates ->
                onBodyBoundsChange(
                    LayoutBounds(
                        topLeft = coordinates.positionInWindow(),
                        size = coordinates.size,
                    ),
                )
            },
    ) {
        val layout = rememberPlayerNumberLayout(maxWidth = maxWidth, maxHeight = maxHeight)
        SideEffect { onLayoutChange(layout) }
        TeamsColumn(
            state = state,
            layout = layout,
            modifier = Modifier.fillMaxSize(),
        )
        NumberEntryOverlay(
            jerseyInput = state.jerseyNumber,
            onJerseyInputChange = actions.onJerseyInputChange,
            focusRequester = focusRequester,
            layout = layout,
            modifier = Modifier.align(Alignment.Center),
        )
        PreviewWindowSizeClassHint(
            widthBucket = layout.widthBucket,
            heightBucket = layout.heightBucket,
            width = maxWidth,
            height = maxHeight,
            modifier = Modifier.align(Alignment.TopStart),
        )
    }
}

@Composable
private fun TeamsColumn(
    state: PlayerNumberUiState,
    layout: PlayerNumberLayout,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        TeamSection(
            player = state.away.player,
            jerseyNumber = state.jerseyNumber,
            team = state.away.team,
            heightBucket = layout.heightBucket,
            contentPadding = PaddingValues(bottom = layout.awayPaddingBottom),
            centerBiasTopWeight = layout.centerBiasTopWeight,
            chipSpacing = layout.chipSpacing,
            modifier = Modifier.weight(1f),
        )
        TeamSection(
            player = state.home.player,
            jerseyNumber = state.jerseyNumber,
            team = state.home.team,
            heightBucket = layout.heightBucket,
            contentPadding = PaddingValues(top = layout.awayPaddingBottom),
            centerBiasTopWeight = layout.centerBiasBottomWeight,
            chipSpacing = layout.chipSpacing,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun NumberEntryOverlay(
    jerseyInput: String,
    onJerseyInputChange: (String) -> Unit,
    focusRequester: FocusRequester,
    layout: PlayerNumberLayout,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        NumberEntryCircle(
            value = jerseyInput,
            onValueChange = onJerseyInputChange,
            focusRequester = focusRequester,
            diameter = layout.numberEntryDiameter,
            textStyle = layout.numberEntryTextStyle,
            heightBucket = layout.heightBucket,
        )
    }
}

@Composable
private fun rememberNumberEntryFocusRequester(showHints: Boolean): FocusRequester {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(showHints) {
        if (showHints) {
            focusRequester.requestFocus()
            keyboardController?.show()
        }
    }
    return focusRequester
}

@Composable
private fun rememberPlayerNumberLayout(
    maxWidth: Dp,
    maxHeight: Dp,
): PlayerNumberLayout {
    val heightBucket = resolveHeightBucket(maxWidth, maxHeight, HeightBreakpoints)
    val widthBucket = resolveWidthBucket(maxWidth, maxHeight, WidthBreakpoints)
    val chipSpacing = heightBucket.chipSpacing
    val numberEntryTextStyle = rememberNumberEntryTextStyle()
    val numberEntryDiameter =
        rememberNumberEntryDiameter(
            textStyle = numberEntryTextStyle,
            heightBucket = heightBucket,
        )
    val awayPaddingBottom = numberEntryDiameter / 2
    val helperArrowOffset = numberEntryDiameter / 2 + HelperChipSpacing / 2 - 8.dp
    val helperArrowOffsetFromTop = maxHeight / 2f - helperArrowOffset
    val centerBiasTopWeight = 1.4f

    return PlayerNumberLayout(
        heightBucket = heightBucket,
        widthBucket = widthBucket,
        numberEntryDiameter = numberEntryDiameter,
        numberEntryTextStyle = numberEntryTextStyle,
        awayPaddingBottom = awayPaddingBottom,
        chipSpacing = chipSpacing,
        helperArrowOffsetFromTop = helperArrowOffsetFromTop,
        centerBiasTopWeight = centerBiasTopWeight,
        centerBiasBottomWeight = 1f / centerBiasTopWeight,
    )
}

private data class PlayerNumberLayout(
    val heightBucket: SizeBucket,
    val widthBucket: SizeBucket,
    val numberEntryDiameter: Dp,
    val numberEntryTextStyle: TextStyle,
    val awayPaddingBottom: Dp,
    val chipSpacing: Dp,
    val helperArrowOffsetFromTop: Dp,
    val centerBiasTopWeight: Float,
    val centerBiasBottomWeight: Float,
)

private data class LayoutBounds(
    val topLeft: Offset,
    val size: IntSize,
)

private data class AssistHintTargets(
    val jerseyBaseOffset: Dp,
    val jerseyAnchorFraction: Float,
    val teamBaseOffset: Dp,
    val teamAnchorFraction: Float,
)

@Composable
private fun rememberAssistHintTargets(
    chevronCenterInWindow: Offset?,
    pillBoundsInWindow: Rect?,
    rootBounds: LayoutBounds?,
    bodyBounds: LayoutBounds?,
    layout: PlayerNumberLayout?,
): AssistHintTargets {
    val density = LocalDensity.current
    return remember(
        chevronCenterInWindow,
        pillBoundsInWindow,
        rootBounds,
        bodyBounds,
        layout,
        density,
    ) {
        val rootTop = rootBounds?.topLeft?.y ?: 0f
        val rootCenterX = rootBounds?.let { it.topLeft.x + it.size.width / 2f } ?: 0f
        val lineWidthPx = with(density) { AssistHintLineWidth.toPx() }
        val targetAnchor: (Float) -> Float = { targetX ->
            (0.5f + (targetX - rootCenterX) / lineWidthPx).coerceIn(0.1f, 0.9f)
        }
        val targetGapPx = with(density) { AssistHintTargetGap.toPx() }
        val strokeGapPx = with(density) { (AssistHintLineStrokeWidth / 2).toPx() }
        val visualGapPx = targetGapPx + strokeGapPx
        val bottomVisualGapPx = visualGapPx + with(density) { BottomArrowExtraGap.toPx() }
        val teamNudgeX = with(density) { TeamArrowNudgeX.toPx() }
        val teamNudgeY = with(density) { TeamArrowNudgeY.toPx() }

        val teamTarget =
            if (pillBoundsInWindow != null) {
                val cornerOffset = visualGapPx / sqrt(2f)
                Offset(
                    x = pillBoundsInWindow.right + cornerOffset + teamNudgeX,
                    y = pillBoundsInWindow.bottom + cornerOffset - teamNudgeY,
                )
            } else if (chevronCenterInWindow != null) {
                Offset(
                    x = chevronCenterInWindow.x + teamNudgeX,
                    y = chevronCenterInWindow.y + visualGapPx - teamNudgeY,
                )
            } else {
                null
            }
        val teamAnchorFraction =
            if (teamTarget != null && rootBounds != null) {
                targetAnchor(teamTarget.x)
            } else {
                DEFAULT_TEAM_HINT_ANCHOR_FRACTION
            }
        val teamBaseOffset =
            if (teamTarget != null && rootBounds != null) {
                with(density) { (teamTarget.y - rootTop).toDp() }
            } else {
                DefaultTeamSelectorAssistOffset
            }

        val jerseyTarget =
            if (layout != null && bodyBounds != null && rootBounds != null) {
                val centerX = bodyBounds.topLeft.x + bodyBounds.size.width / 2f
                val centerY = bodyBounds.topLeft.y + bodyBounds.size.height / 2f
                val radiusPx = with(density) { layout.numberEntryDiameter.toPx() / 2f }
                val offset = (radiusPx + bottomVisualGapPx) / sqrt(2f)
                Offset(centerX + offset, centerY - offset)
            } else {
                null
            }
        val jerseyAnchorFraction =
            if (jerseyTarget != null && rootBounds != null) {
                targetAnchor(jerseyTarget.x)
            } else {
                DEFAULT_JERSEY_HINT_ANCHOR_FRACTION
            }
        val jerseyBaseOffset =
            when {
                jerseyTarget != null && rootBounds != null -> {
                    with(density) {
                        (jerseyTarget.y - rootTop).toDp()
                    }
                }

                layout != null && bodyBounds != null && rootBounds != null -> {
                    with(density) {
                        (bodyBounds.topLeft.y - rootTop + layout.helperArrowOffsetFromTop.toPx()).toDp()
                    }
                }

                layout != null -> {
                    layout.helperArrowOffsetFromTop
                }

                else -> {
                    DefaultJerseyAssistOffset
                }
            }

        AssistHintTargets(
            jerseyBaseOffset = jerseyBaseOffset,
            jerseyAnchorFraction = jerseyAnchorFraction,
            teamBaseOffset = teamBaseOffset,
            teamAnchorFraction = teamAnchorFraction,
        )
    }
}

private const val ASSIST_HINTS_OVERLAY_Z_INDEX = 1f
private const val TOP_BAR_BLEND_FRACTION = 0.42f
private val DefaultJerseyAssistOffset = 240.dp
private val AssistHintTargetGap = 3.dp
private val BottomArrowExtraGap = 2.dp
private val TeamArrowNudgeX = 4.dp
private val TeamArrowNudgeY = 2.dp
private val HelperChipSpacing = 70.dp
private val SizeBucket.chipSpacing: Dp
    get() =
        when (this) {
            SizeBucket.Small -> 2.dp
            SizeBucket.Medium -> 5.dp
            SizeBucket.Large -> 12.dp
        }

private data class PlayerNumberActions(
    val onJerseyInputChange: (String) -> Unit,
    val onTeamSelectorClick: () -> Unit,
)

@Composable
private fun rememberPlayerNumberActions(
    onJerseyInputChange: (String) -> Unit,
    onTeamSelectorClick: () -> Unit,
): PlayerNumberActions =
    remember(onJerseyInputChange, onTeamSelectorClick) {
        PlayerNumberActions(
            onJerseyInputChange = onJerseyInputChange,
            onTeamSelectorClick = onTeamSelectorClick,
        )
    }

@PreviewLightDark
@Preview(name = "Small", widthDp = 320, heightDp = HEIGHT_MEDIUM_LOWER_BOUND - 50)
@Preview(name = "Medium", widthDp = 320, heightDp = HEIGHT_MEDIUM_LOWER_BOUND + 72)
@Preview(name = "Large", widthDp = 320, heightDp = HEIGHT_LARGE_LOWER_BOUND + 72)
@Composable
private fun PlayerNumberSizedPreview() {
    PlayerNumberTheme {
        val state =
            PlayerNumberUiState(
                jerseyNumber = PREVIEW_JERSEY_NUMBER,
                away =
                    TeamRosterUiState(
                        team = PreviewAwayTeam,
                        player = PreviewAwayTeam.playerByNumber[PREVIEW_JERSEY_NUMBER],
                        rosterStatus = PreviewRosterStatus,
                    ),
                home =
                    TeamRosterUiState(
                        team = PreviewHomeTeam,
                        player = PreviewHomeTeam.playerByNumber[PREVIEW_JERSEY_NUMBER],
                        rosterStatus = PreviewRosterStatus,
                    ),
            )
        PlayerNumberPreview(state)
    }
}

@PreviewLightDark
@Composable
private fun PlayerNumberEmptyPreview() {
    PlayerNumberTheme {
        val state =
            PlayerNumberUiState(
                jerseyNumber = "",
                away =
                    TeamRosterUiState(
                        team = PreviewAwayTeam,
                        player = null,
                        rosterStatus = PreviewRosterStatus,
                    ),
                home =
                    TeamRosterUiState(
                        team = PreviewHomeTeam,
                        player = null,
                        rosterStatus = PreviewRosterStatus,
                    ),
            )
        PlayerNumberPreview(state)
    }
}

private const val PREVIEW_JERSEY_NUMBER = "27"

private val PreviewAwayTeam = MlbTeams.first { it.abbreviation == "TOR" }
private val PreviewHomeTeam = MlbTeams.first { it.abbreviation == "LAA" }

private val PreviewRosterStatus =
    RosterStatus(
        source = RosterSource.STATIC,
        lastUpdatedMillis = null,
    )

private val PreviewPlayerNumberActions =
    PlayerNumberActions(
        onJerseyInputChange = {},
        onTeamSelectorClick = {},
    )

@Composable
private fun PlayerNumberPreview(state: PlayerNumberUiState) {
    PlayerNumberScreenContent(
        state = state,
        actions = PreviewPlayerNumberActions,
    )
}
