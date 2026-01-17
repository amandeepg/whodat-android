package ca.amandeep.playernumber.ui.matchup

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.data.NhlTeamRefs
import ca.amandeep.playernumber.data.api.LeagueGames
import ca.amandeep.playernumber.data.api.TodayGame
import ca.amandeep.playernumber.data.api.TodayGamesResult
import ca.amandeep.playernumber.data.api.TodayGamesStore
import ca.amandeep.playernumber.data.location.AndroidLocationRepository
import ca.amandeep.playernumber.data.location.LocationFetchResult
import ca.amandeep.playernumber.data.location.LocationRepository
import ca.amandeep.playernumber.ui.theme.FontWidth
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.theme.withFontWidth
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.Locale
import kotlin.math.roundToInt

internal enum class TeamSlot {
    Away,
    Home,
}

internal sealed interface TodayGamesUiState {
    data object Loading : TodayGamesUiState

    data class Loaded(
        val date: LocalDate,
        val leagues: List<LeagueGames>,
    ) : TodayGamesUiState

    data class Error(
        val message: String? = null,
    ) : TodayGamesUiState
}

private val TeamSelectionBadgeSize = 54.dp
private const val ACTIVE_BORDER_ALPHA = 0.6f
private const val LOG_TAG = "TeamSelection"

private data class TeamSelectionActions(
    val dispatch: (TeamSelectionViewModel.Intent) -> Unit,
    val onTeamSelect: (AnyTeam) -> Unit,
    val onGameSelect: (TodayGame) -> Unit,
)

private data class TeamSelectionBarEntry(
    val slot: TeamSlot,
    val labelRes: Int,
    val team: AnyTeam,
    val query: String,
    val isActive: Boolean,
    val isCleared: Boolean,
)

internal class TeamSelectionViewModel(
    private val locationRepository: LocationRepository,
    private val searchDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    internal data class State(
        val awayQuery: String = "",
        val homeQuery: String = "",
        val activeSlot: TeamSlot? = null,
        val awayCleared: Boolean = false,
        val homeCleared: Boolean = false,
        val groupedMatches: List<TeamSearchEngine.LeagueMatches> = emptyList(),
        val todayGamesState: TodayGamesUiState = TodayGamesUiState.Loading,
        val locationPermissionGranted: Boolean = false,
        val locationFetchResult: LocationFetchResult = LocationFetchResult.MissingPermission,
        val nearbyGames: NearbyGames? = null,
    ) {
        val isAwayActive: Boolean
            get() = activeSlot == TeamSlot.Away
        val isHomeActive: Boolean
            get() = activeSlot == TeamSlot.Home
        val activeQuery: String
            get() = when (activeSlot) {
                TeamSlot.Away -> awayQuery
                TeamSlot.Home -> homeQuery
                null -> ""
            }

        fun activeSelectedName(
            awayTeam: AnyTeam,
            homeTeam: AnyTeam,
        ): String = when (activeSlot) {
            TeamSlot.Away -> if (awayCleared || awayQuery.isNotBlank()) "" else awayTeam.name
            TeamSlot.Home -> if (homeCleared || homeQuery.isNotBlank()) "" else homeTeam.name
            null -> ""
        }
    }

    internal sealed interface Intent {
        data class UpdateTeams(
            val awayTeam: AnyTeam,
            val homeTeam: AnyTeam,
        ) : Intent

        data class UpdateLocationPermission(
            val granted: Boolean,
        ) : Intent

        data object RefreshLocation : Intent

        data object ResetSession : Intent

        data class Activate(
            val slot: TeamSlot,
        ) : Intent

        data class QueryChanged(
            val slot: TeamSlot,
            val query: String,
        ) : Intent

        data class ClearTeam(
            val slot: TeamSlot,
        ) : Intent

        data class FinishSelection(
            val slot: TeamSlot,
        ) : Intent
    }

    private val _uiState = MutableStateFlow(State())
    val uiState: StateFlow<State> = _uiState.asStateFlow()

    private var awayTeam: AnyTeam? = null
    private var homeTeam: AnyTeam? = null
    private var searchJob: Job? = null
    private var todayGamesJob: Job? = null
    private var locationJob: Job? = null

    init {
        refreshTodayGames()
    }

    fun dispatch(intent: Intent) {
        when (intent) {
            is Intent.UpdateTeams -> {
                updateTeams(intent.awayTeam, intent.homeTeam)
            }

            is Intent.UpdateLocationPermission -> {
                updateLocationPermission(intent.granted)
            }

            Intent.RefreshLocation -> {
                refreshLocation()
            }

            Intent.ResetSession -> {
                updateState {
                    copy(
                        awayQuery = "",
                        homeQuery = "",
                        awayCleared = false,
                        homeCleared = false,
                        activeSlot = null,
                    )
                }
            }

            is Intent.Activate -> {
                updateState { withActiveSlot(this, intent.slot) }
            }

            is Intent.QueryChanged -> {
                updateState { withQuery(this, intent.slot, intent.query) }
            }

            is Intent.ClearTeam -> {
                updateState { clearTeam(this, intent.slot) }
            }

            is Intent.FinishSelection -> {
                updateState { finishSelection(this, intent.slot) }
            }
        }
    }

    private fun updateTeams(
        awayTeam: AnyTeam,
        homeTeam: AnyTeam,
    ) {
        if (this.awayTeam == awayTeam && this.homeTeam == homeTeam) return
        this.awayTeam = awayTeam
        this.homeTeam = homeTeam
        refreshSearch(_uiState.value)
    }

    private fun updateLocationPermission(granted: Boolean) {
        if (_uiState.value.locationPermissionGranted == granted) return
        _uiState.update { it.copy(locationPermissionGranted = granted) }
        if (granted) {
            refreshLocation()
        } else {
            updateLocationResult(LocationFetchResult.MissingPermission)
        }
    }

    private fun refreshLocation() {
        if (locationJob?.isActive == true) return
        locationJob?.cancel()
        locationJob = viewModelScope.launch {
            locationRepository.locationFlow().collect { result ->
                updateLocationResult(result)
            }
        }
    }

    private fun updateLocationResult(result: LocationFetchResult) {
        val todayGamesState = _uiState.value.todayGamesState
        val nearbyGames = if (todayGamesState is TodayGamesUiState.Loaded && result is LocationFetchResult.Available) {
            computeNearbyGames(todayGamesState.leagues, result.location)
        } else {
            null
        }
        _uiState.update {
            it.copy(
                locationFetchResult = result,
                nearbyGames = nearbyGames,
            )
        }
    }

    private fun updateState(reducer: State.() -> State) {
        _uiState.update { state -> state.reducer() }
        refreshSearch(_uiState.value)
    }

    private fun refreshSearch(state: State) {
        val away = awayTeam ?: return
        val home = homeTeam ?: return
        val query = state.activeQuery
        if (query.isBlank()) {
            searchJob?.cancel()
            if (state.groupedMatches.isNotEmpty()) {
                _uiState.update { it.copy(groupedMatches = emptyList()) }
            }
            return
        }
        val selectedName = state.activeSelectedName(away, home)
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            val results = runSearch(query, selectedName)
            _uiState.update { it.copy(groupedMatches = results) }
        }
    }

    private fun refreshTodayGames() {
        if (todayGamesJob?.isActive == true) return
        todayGamesJob?.cancel()
        updateTodayGamesState(TodayGamesUiState.Loading)
        todayGamesJob = viewModelScope.launch {
            try {
                val result = TodayGamesStore.await(ioDispatcher)
                updateTodayGamesState(result.toUiState())
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (error: Exception) {
                Log.e(LOG_TAG, "Failed to load today's games", error)
                updateTodayGamesState(TodayGamesUiState.Error())
            }
        }
    }

    private suspend fun runSearch(
        query: String,
        selectedName: String,
    ): List<TeamSearchEngine.LeagueMatches> = withContext(searchDispatcher) {
        TeamSearchEngineStore.await(searchDispatcher).search(query, selectedName)
    }

    private fun updateTodayGamesState(state: TodayGamesUiState) {
        _uiState.update { current ->
            val nearbyGames = if (state is TodayGamesUiState.Loaded) {
                val location = (current.locationFetchResult as? LocationFetchResult.Available)?.location
                if (location != null) {
                    computeNearbyGames(state.leagues, location)
                } else {
                    null
                }
            } else {
                null
            }
            current.copy(
                todayGamesState = state,
                nearbyGames = nearbyGames,
            )
        }
    }

    private fun withQuery(
        state: State,
        slot: TeamSlot,
        query: String,
    ) = when (slot) {
        TeamSlot.Away -> state.copy(awayQuery = query)
        TeamSlot.Home -> state.copy(homeQuery = query)
    }

    private fun withActiveSlot(
        state: State,
        slot: TeamSlot,
    ) = state.copy(activeSlot = slot)

    private fun clearTeam(
        state: State,
        slot: TeamSlot,
    ) = when (slot) {
        TeamSlot.Away -> state.copy(activeSlot = slot, awayQuery = "", awayCleared = true)
        TeamSlot.Home -> state.copy(activeSlot = slot, homeQuery = "", homeCleared = true)
    }

    private fun finishSelection(
        state: State,
        slot: TeamSlot,
    ) = when (slot) {
        TeamSlot.Away -> state.copy(activeSlot = null, awayQuery = "", awayCleared = false)
        TeamSlot.Home -> state.copy(activeSlot = null, homeQuery = "", homeCleared = false)
    }
}

private fun TodayGamesResult.toUiState(): TodayGamesUiState = TodayGamesUiState.Loaded(
    date = date,
    leagues = leagues,
)

private class TeamSelectionViewModelFactory(
    private val appContext: Context,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamSelectionViewModel::class.java)) {
            val repository = AndroidLocationRepository(appContext)
            @Suppress("UNCHECKED_CAST")
            return TeamSelectionViewModel(
                locationRepository = repository,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
    }
}

@Composable
private fun rememberTeamSelectionViewModel(): TeamSelectionViewModel {
    val context = LocalContext.current
    val storeOwner = context as? ViewModelStoreOwner
        ?: error("ViewModelStoreOwner not found for TeamSelectionScreen")
    val appContext = remember(context) { context.applicationContext }
    val factory = remember(appContext) { TeamSelectionViewModelFactory(appContext) }
    return remember(storeOwner, factory) {
        ViewModelProvider(storeOwner, factory).get(TeamSelectionViewModel::class.java)
    }
}

@Composable
private fun rememberTeamSelectionActions(
    viewModel: TeamSelectionViewModel,
    state: TeamSelectionViewModel.State,
    onAwayTeamSelect: (AnyTeam) -> Unit,
    onHomeTeamSelect: (AnyTeam) -> Unit,
): TeamSelectionActions = remember(
    viewModel,
    state.activeSlot,
    onAwayTeamSelect,
    onHomeTeamSelect,
) {
    TeamSelectionActions(
        dispatch = viewModel::dispatch,
        onTeamSelect = { team ->
            val slot = state.activeSlot
            if (slot != null) {
                viewModel.dispatch(TeamSelectionViewModel.Intent.FinishSelection(slot))
                when (slot) {
                    TeamSlot.Away -> onAwayTeamSelect(team)
                    TeamSlot.Home -> onHomeTeamSelect(team)
                }
            }
        },
        onGameSelect = { game ->
            onAwayTeamSelect(game.away)
            onHomeTeamSelect(game.home)
            viewModel.dispatch(TeamSelectionViewModel.Intent.ResetSession)
        },
    )
}

@Composable
fun TeamSelectionScreen(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
    onAwayTeamSelect: (AnyTeam) -> Unit,
    onHomeTeamSelect: (AnyTeam) -> Unit,
    resetSignal: Int,
    modifier: Modifier = Modifier,
) {
    val viewModel = rememberTeamSelectionViewModel()
    LaunchedEffect(awayTeam, homeTeam) {
        viewModel.dispatch(TeamSelectionViewModel.Intent.UpdateTeams(awayTeam, homeTeam))
    }
    LaunchedEffect(resetSignal) {
        viewModel.dispatch(TeamSelectionViewModel.Intent.ResetSession)
    }
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val actions = rememberTeamSelectionActions(
        viewModel = viewModel,
        state = state,
        onAwayTeamSelect = onAwayTeamSelect,
        onHomeTeamSelect = onHomeTeamSelect,
    )

    TeamSelectionScreenContent(
        awayTeam = awayTeam,
        homeTeam = homeTeam,
        state = state,
        actions = actions,
        modifier = modifier,
    )
}

@Composable
private fun TeamSelectionScreenContent(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
    state: TeamSelectionViewModel.State,
    actions: TeamSelectionActions,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val permissionGranted = ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION,
    ) == PackageManager.PERMISSION_GRANTED
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            actions.dispatch(TeamSelectionViewModel.Intent.UpdateLocationPermission(granted))
        },
    )
    val requestLocationPermission = remember(permissionLauncher) {
        {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
    LaunchedEffect(permissionGranted) {
        actions.dispatch(TeamSelectionViewModel.Intent.UpdateLocationPermission(permissionGranted))
    }
    val activeQuery = state.activeQuery
    val groupedMatches = state.groupedMatches
    val barEntries = remember(
        awayTeam,
        homeTeam,
        state.awayQuery,
        state.homeQuery,
        state.awayCleared,
        state.homeCleared,
        state.activeSlot,
    ) {
        teamSelectionBarEntries(
            awayTeam = awayTeam,
            homeTeam = homeTeam,
            state = state,
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .imePadding(),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TeamSelectionBars(
                entries = barEntries,
                actions = actions,
            )

            val contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 18.dp,
                bottom = 160.dp,
            )
            val showSearchResults = groupedMatches.isNotEmpty() || activeQuery.isNotBlank()
            Crossfade(
                targetState = showSearchResults,
                modifier = Modifier.weight(1f),
                label = "MatchupResultsCrossfade",
            ) { showSearch ->
                if (showSearch) {
                    TeamSearchResults(
                        groupedMatches = groupedMatches,
                        query = activeQuery,
                        onTeamSelect = actions.onTeamSelect,
                        contentPadding = contentPadding,
                    )
                } else {
                    TodayGamesSection(
                        state = state.todayGamesState,
                        nearbyGames = state.nearbyGames,
                        locationPermissionGranted = state.locationPermissionGranted,
                        onRequestLocationPermission = requestLocationPermission,
                        onGameSelect = actions.onGameSelect,
                        contentPadding = contentPadding,
                    )
                }
            }
        }
    }
}

@Composable
private fun TeamSelectionBars(
    entries: List<TeamSelectionBarEntry>,
    actions: TeamSelectionActions,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.colorScheme
    val primary = colors.primary
    val background = colors.background
    val surface = colors.surfaceContainerHigh
    val textColor = colors.onSurface
    val awayBounds = remember { mutableStateOf<Rect?>(null) }
    val homeBounds = remember { mutableStateOf<Rect?>(null) }
    val badgeBounds = remember { mutableStateOf<Rect?>(null) }
    val activeSlot = entries.firstOrNull { it.isActive }?.slot
    val topBorderAlpha = if (activeSlot == TeamSlot.Away) ACTIVE_BORDER_ALPHA else 0f
    val bottomBorderAlpha = if (activeSlot == TeamSlot.Home) ACTIVE_BORDER_ALPHA else 0f
    val topBorderColor = primary.copy(alpha = topBorderAlpha)
    val bottomBorderColor = primary.copy(alpha = bottomBorderAlpha)
    val awayBadgeClip = remember(awayBounds.value, badgeBounds.value) {
        badgeBorderClip(awayBounds.value, badgeBounds.value)
    }
    val homeBadgeClip = remember(homeBounds.value, badgeBounds.value) {
        badgeBorderClip(homeBounds.value, badgeBounds.value)
    }
    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            entries.forEach { entry ->
                val entryModifier = when (entry.slot) {
                    TeamSlot.Away -> {
                        Modifier.onGloballyPositioned { coordinates ->
                            awayBounds.value = coordinates.rectInWindow()
                        }
                    }

                    TeamSlot.Home -> {
                        Modifier.onGloballyPositioned { coordinates ->
                            homeBounds.value = coordinates.rectInWindow()
                        }
                    }
                }
                TeamSelectionBar(
                    entry = entry,
                    actions = actions,
                    modifier = entryModifier,
                )
            }
        }
        if (entries.size >= 2) {
            MatchupVsBadge(
                background = surface,
                backgroundBorderColor = background,
                topBorderColor = topBorderColor,
                bottomBorderColor = bottomBorderColor,
                topBorderClip = awayBadgeClip,
                bottomBorderClip = homeBadgeClip,
                textColor = textColor,
                modifier = Modifier
                    .align(Alignment.Center)
                    .onGloballyPositioned { coordinates ->
                        badgeBounds.value = coordinates.rectInWindow()
                    },
            )
        }
    }
}

@Composable
private fun TeamSelectionBar(
    entry: TeamSelectionBarEntry,
    actions: TeamSelectionActions,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.colorScheme
    val primary = colors.primary
    val surface = colors.surfaceContainerHigh
    val muted = colors.onSurfaceVariant
    val textColor = colors.onSurface
    val team = entry.team
    val label = stringResource(entry.labelRes)
    val query = entry.query
    val isActive = entry.isActive
    val isCleared = entry.isCleared
    val slot = entry.slot
    val onQueryChange = remember(actions, slot) {
        { updated: String -> actions.dispatch(TeamSelectionViewModel.Intent.QueryChanged(slot, updated)) }
    }
    val onActivate = remember(actions, slot) {
        { actions.dispatch(TeamSelectionViewModel.Intent.Activate(slot)) }
    }
    val focusRequester = remember { FocusRequester() }
    val isSearching = isActive && query.isNotBlank()
    val showSearchPlaceholder = isCleared && isActive
    val trailingIconModifier = remember { Modifier.size(32.dp) }

    val cardColor = if (isActive) surface else surface.copy(alpha = 0.92f)
    val activeBorder = if (isActive) {
        BorderStroke(TeamSelectionActiveBorderWidth, primary.copy(alpha = ACTIVE_BORDER_ALPHA))
    } else {
        null
    }

    Surface(
        onClick = onActivate,
        enabled = !isActive,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 96.dp),
        shape = RoundedCornerShape(30.dp),
        color = cardColor,
        border = activeBorder,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    PaddingValues(
                        horizontal = 20.dp,
                        vertical = 18.dp,
                    ),
                ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            TeamBarLabel(
                label = label,
                color = muted,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BoxWithConstraints(modifier = Modifier.weight(1f)) {
                    val textStyleBase = teamSelectionInputTextStyle()
                    val textMaxWidth = maxWidth - TeamSelectionBadgeSize - 14.dp
                    val fontWidth = rememberFittingFontWidth(
                        textStyle = textStyleBase,
                        maxWidth = textMaxWidth,
                    )
                    val textStyle = textStyleBase.withFontWidth(fontWidth)

                    val showPlaceholderBadge = showSearchPlaceholder || isSearching
                    val placeholderText = if (showSearchPlaceholder) {
                        stringResource(R.string.team_search_placeholder)
                    } else {
                        team.name
                    }
                    val placeholderColor = when {
                        showSearchPlaceholder -> muted.copy(alpha = 0.7f)
                        isActive -> textColor.copy(alpha = 0.6f)
                        else -> textColor
                    }
                    if (isActive) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            TeamAbbreviationBadge(
                                team = team,
                                size = TeamSelectionBadgeSize,
                                isEmpty = showPlaceholderBadge,
                            )
                            TeamSearchField(
                                query = query,
                                textStyle = textStyle,
                                placeholder = placeholderText,
                                placeholderColor = placeholderColor,
                                fontWidth = fontWidth,
                                onQueryChange = onQueryChange,
                                focusRequester = focusRequester,
                                modifier = Modifier.weight(1f),
                            )
                        }
                    } else {
                        Crossfade(
                            targetState = team,
                            label = "TeamSelectionSummaryCrossfade",
                        ) { selectedTeam ->
                            TeamSelectionSummary(
                                team = selectedTeam,
                                textStyle = textStyle,
                                fontWidth = fontWidth,
                            )
                        }
                    }
                }
                when {
                    isActive -> {
                        CloseIconButton(
                            contentDescription = stringResource(R.string.clear_team_content_description),
                            tint = primary,
                            onClick = { actions.dispatch(TeamSelectionViewModel.Intent.ClearTeam(slot)) },
                            background = primary.copy(alpha = 0.16f),
                            modifier = trailingIconModifier,
                        )
                    }

                    else -> {
                        Box(
                            modifier = trailingIconModifier,
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = muted.copy(alpha = 0.7f),
                                modifier = Modifier.size(24.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TeamBarLabel(
    label: String,
    color: Color,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(LocalContentColor provides color) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = label.uppercase(Locale.ROOT),
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 3.sp,
                    lineHeightStyle = SingleLineHeightStyle,
                ),
            )
        }
    }
}

@Composable
private fun TeamSearchField(
    query: String,
    textStyle: TextStyle,
    placeholder: String,
    placeholderColor: Color,
    fontWidth: FontWidth?,
    onQueryChange: (String) -> Unit,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier,
) {
    var fieldValue by remember {
        mutableStateOf(TextFieldValue(query, selection = TextRange(query.length)))
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    LaunchedEffect(query) {
        if (query != fieldValue.text) {
            fieldValue = TextFieldValue(query, selection = TextRange(query.length))
        }
    }
    BasicTextField(
        value = fieldValue,
        onValueChange = { updated ->
            fieldValue = updated
            onQueryChange(updated.text)
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = textStyle.copy(color = MaterialTheme.colorScheme.onSurface),
        modifier = modifier.focusRequester(focusRequester),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
            ) {
                if (fieldValue.text.isEmpty()) {
                    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                        val placeholderStyle = reduceFontWidthIfNeeded(
                            text = placeholder,
                            textStyle = textStyle,
                            fontWidth = fontWidth,
                        )
                        Text(
                            text = placeholder,
                            color = placeholderColor,
                            style = placeholderStyle,
                            maxLines = 1,
                            autoSize = TextAutoSize.StepBased(maxFontSize = placeholderStyle.fontSize),
                        )
                    }
                }
                innerTextField()
            }
        },
    )
}

@Composable
private fun CloseIconButton(
    contentDescription: String,
    tint: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    background: Color? = null,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .then(if (background != null) Modifier.background(background) else Modifier)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = contentDescription,
            tint = tint,
        )
    }
}

@Composable
private fun TeamSelectionSummary(
    team: AnyTeam,
    textStyle: TextStyle,
    fontWidth: FontWidth?,
) {
    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TeamAbbreviationBadge(
                team = team,
                size = TeamSelectionBadgeSize,
            )
            BoxWithConstraints(modifier = Modifier.weight(1f)) {
                val textStyle = reduceFontWidthIfNeeded(
                    text = team.name,
                    textStyle = textStyle,
                    fontWidth = fontWidth,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = team.name,
                    style = textStyle,
                    autoSize = TextAutoSize.StepBased(maxFontSize = textStyle.fontSize),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
private fun teamSelectionInputTextStyle(): TextStyle {
    val baseStyle = MaterialTheme.typography.headlineSmall
    return remember(baseStyle) {
        baseStyle.copy(
            fontWeight = FontWeight.Medium,
            lineHeight = baseStyle.fontSize,
            lineHeightStyle = SingleLineHeightStyle,
        )
    }
}

@Composable
internal fun rememberFittingFontWidth(
    textStyle: TextStyle,
    maxWidth: Dp,
): FontWidth? {
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current
    val maxWidthPx = remember(maxWidth, density) {
        with(density) { maxWidth.toPx() }.roundToInt().toFloat().coerceAtLeast(0f)
    }
    return remember(textStyle, maxWidthPx) {
        computeFittingFontWidth(
            textMeasurer = textMeasurer,
            textStyle = textStyle,
            maxWidthPx = maxWidthPx,
        )
    }
}

private val PreviewTeamSelectionActions = TeamSelectionActions(
    dispatch = {},
    onTeamSelect = {},
    onGameSelect = {},
)

@PreviewLightDark
@Composable
private fun TeamSelectionPreviewBothSelected() {
    PlayerNumberTheme {
        TeamSelectionBarsPreviewContent(
            awayTeam = NhlTeamRefs.UTAH,
            homeTeam = NhlTeamRefs.NSH,
            activeSlot = null,
        )
    }
}

@PreviewLightDark
@Composable
private fun TeamSelectionPreviewAwaySelectedSearchHome() {
    PlayerNumberTheme {
        TeamSelectionBarsPreviewContent(
            awayTeam = NbaTeamRefs.HOU,
            homeTeam = NbaTeamRefs.LAL,
            activeSlot = TeamSlot.Home,
        )
    }
}

@PreviewLightDark
@Composable
private fun TeamSelectionPreviewHomeSelectedSearchAway() {
    PlayerNumberTheme {
        TeamSelectionBarsPreviewContent(
            awayTeam = NbaTeamRefs.BOS,
            homeTeam = NbaTeamRefs.CHA,
            activeSlot = TeamSlot.Away,
        )
    }
}

@PreviewLightDark
@Composable
private fun TeamSelectionPreviewSearchPlaceholder() {
    PlayerNumberTheme {
        TeamSelectionBarsPreviewContent(
            awayTeam = MlbTeamRefs.TOR,
            homeTeam = MlbTeamRefs.NYY,
            activeSlot = TeamSlot.Away,
            awayCleared = true,
        )
    }
}

@PreviewLightDark
@Composable
private fun TeamSelectionPreviewSearchingWithQuery() {
    PlayerNumberTheme {
        TeamSelectionBarsPreviewContent(
            awayTeam = MlbTeamRefs.TOR,
            homeTeam = MlbTeamRefs.NYY,
            activeSlot = TeamSlot.Away,
            awayQuery = "Tor",
        )
    }
}

@Composable
private fun TeamSelectionBarsPreviewContent(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
    activeSlot: TeamSlot?,
    awayQuery: String = "",
    homeQuery: String = "",
    awayCleared: Boolean = false,
    homeCleared: Boolean = false,
) {
    val colors = MaterialTheme.colorScheme
    val state = TeamSelectionViewModel.State(
        awayQuery = awayQuery,
        homeQuery = homeQuery,
        awayCleared = awayCleared,
        homeCleared = homeCleared,
        activeSlot = activeSlot,
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.background),
    ) {
        val entries = teamSelectionBarEntries(
            awayTeam = awayTeam,
            homeTeam = homeTeam,
            state = state,
        )
        TeamSelectionBars(
            entries = entries,
            actions = PreviewTeamSelectionActions,
            modifier = Modifier.padding(vertical = 16.dp),
        )
    }
}

private fun teamSelectionBarEntries(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
    state: TeamSelectionViewModel.State,
): List<TeamSelectionBarEntry> = listOf(
    TeamSelectionBarEntry(
        slot = TeamSlot.Away,
        labelRes = R.string.away_team_label,
        team = awayTeam,
        query = state.awayQuery,
        isActive = state.isAwayActive,
        isCleared = state.awayCleared,
    ),
    TeamSelectionBarEntry(
        slot = TeamSlot.Home,
        labelRes = R.string.home_team_label,
        team = homeTeam,
        query = state.homeQuery,
        isActive = state.isHomeActive,
        isCleared = state.homeCleared,
    ),
)

private fun LayoutCoordinates.rectInWindow(): Rect {
    val topLeft = positionInWindow()
    return Rect(
        offset = topLeft,
        size = Size(size.width.toFloat(), size.height.toFloat()),
    )
}
