package ca.amandeep.playernumber.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import ca.amandeep.playernumber.PlayerNumberViewModel
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.ui.jersey.PlayerNumberScreen
import ca.amandeep.playernumber.ui.matchup.TeamSelectionScreen
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    viewModel: PlayerNumberViewModel,
    modifier: Modifier = Modifier,
) {
    val backStack = remember { mutableStateListOf<MainDestination>(MainDestination.Jersey) }
    val popBackStack =
        remember(backStack) {
            {
                if (backStack.size > 1) {
                    backStack.removeAt(backStack.lastIndex)
                }
            }
        }
    val openMatchup =
        remember(backStack) {
            {
                if (backStack.lastOrNull() != MainDestination.Matchup) {
                    backStack.add(MainDestination.Matchup)
                }
            }
        }
    val closeMatchup = popBackStack
    val playerNumberState by viewModel.uiState.collectAsState()

    NavDisplay(
        backStack = backStack,
        onBack = popBackStack,
        modifier = modifier.fillMaxSize(),
        entryProvider =
            entryProvider {
                entry<MainDestination.Matchup> {
                    MatchupDestination(
                        awayTeam = viewModel.awayTeam,
                        homeTeam = viewModel.homeTeam,
                        onAwayTeamSelect = viewModel::updateAwayTeam,
                        onHomeTeamSelect = viewModel::updateHomeTeam,
                        onDismiss = closeMatchup,
                    )
                }
                entry<MainDestination.Jersey> {
                    PlayerNumberScreen(
                        state = playerNumberState,
                        onJerseyInputChange = viewModel::onJerseyInputChange,
                        onTeamSelectorClick = openMatchup,
                    )
                }
            },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MatchupDestination(
    awayTeam: AnyTeam,
    homeTeam: AnyTeam,
    onAwayTeamSelect: (AnyTeam) -> Unit,
    onHomeTeamSelect: (AnyTeam) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val initialAway = remember { awayTeam }
    val initialHome = remember { homeTeam }
    val resetCounter = remember { mutableIntStateOf(0) }
    val onResetTeams =
        rememberUpdatedState {
            onAwayTeamSelect(initialAway)
            onHomeTeamSelect(initialHome)
            resetCounter.intValue += 1
        }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.select_matchup_title),
                        style =
                            MaterialTheme.typography.titleLarge.copy(
                                lineHeightStyle = SingleLineHeightStyle,
                            ),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_content_description),
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { onResetTeams.value.invoke() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = stringResource(R.string.reset_matchup_content_description),
                        )
                    }
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.onBackground,
                        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                    ),
            )
        },
    ) { innerPadding ->
        TeamSelectionScreen(
            awayTeam = awayTeam,
            homeTeam = homeTeam,
            onAwayTeamSelect = onAwayTeamSelect,
            onHomeTeamSelect = onHomeTeamSelect,
            resetSignal = resetCounter.intValue,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

private sealed interface MainDestination {
    data object Jersey : MainDestination

    data object Matchup : MainDestination
}
