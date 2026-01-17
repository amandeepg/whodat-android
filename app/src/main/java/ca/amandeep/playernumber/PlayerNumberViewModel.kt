package ca.amandeep.playernumber

import android.app.Application
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.LeagueCatalog
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.api.EspnRosterApi
import ca.amandeep.playernumber.data.api.EspnRosterRepository
import ca.amandeep.playernumber.data.api.EspnRosterService
import ca.amandeep.playernumber.data.api.RosterRepository
import ca.amandeep.playernumber.data.api.RosterSource
import ca.amandeep.playernumber.data.api.RosterState
import ca.amandeep.playernumber.data.api.TodayGamesStore
import ca.amandeep.playernumber.data.cache.FileRosterCacheStore
import ca.amandeep.playernumber.ui.jersey.PlayerNumberUiState
import ca.amandeep.playernumber.ui.jersey.RosterStatus
import ca.amandeep.playernumber.ui.jersey.TeamRosterUiState
import ca.amandeep.playernumber.ui.jersey.toStatus
import ca.amandeep.playernumber.ui.matchup.TeamSearchEngineStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@OptIn(ExperimentalCoroutinesApi::class)
class PlayerNumberViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val sharedPreferences =
        application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private var jerseyInput by mutableStateOf("")

    private val rosterRepository: RosterRepository by lazy { createRosterRepository() }

    var awayTeam: AnyTeam by mutableStateOf(MlbTeamRefs.LAA)
        private set

    var homeTeam: AnyTeam by mutableStateOf(MlbTeamRefs.TOR)
        private set

    private val jerseyInputFlow = snapshotFlow { jerseyInput }.distinctUntilChanged()
    private val awayTeamFlow = snapshotFlow { awayTeam }.distinctUntilChanged()
    private val homeTeamFlow = snapshotFlow { homeTeam }.distinctUntilChanged()

    private val awayRosterFlow: Flow<RosterState> =
        awayTeamFlow
            .flatMapLatest { team ->
                rosterRepository.rosterState(team).onStart { rosterRepository.refresh(team) }
            }

    private val homeRosterFlow: Flow<RosterState> =
        homeTeamFlow
            .flatMapLatest { team ->
                rosterRepository.rosterState(team).onStart { rosterRepository.refresh(team) }
            }

    val uiState: StateFlow<PlayerNumberUiState> =
        combine(
            jerseyInputFlow,
            awayTeamFlow,
            homeTeamFlow,
        awayRosterFlow,
        homeRosterFlow,
    ) { jerseyInput, awayTeam, homeTeam, awayRosterState, homeRosterState ->
        val jerseyKey = jerseyInput.takeIf { it.isNotBlank() }
        PlayerNumberUiState(
            jerseyNumber = jerseyInput,
            away =
                TeamRosterUiState(
                    team = awayTeam,
                    player = jerseyKey?.let { awayRosterState.playersByNumber[it] },
                    rosterStatus = awayRosterState.toStatus(),
                ),
            home =
                TeamRosterUiState(
                    team = homeTeam,
                    player = jerseyKey?.let { homeRosterState.playersByNumber[it] },
                    rosterStatus = homeRosterState.toStatus(),
                ),
        )
    }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyUiState(),
        )

    init {
        restoreMatchup()
        TeamSearchEngineStore.prewarm(
            scope = viewModelScope,
            delayMs = PREWARM_DELAY_MS,
            dispatcher = Dispatchers.Default,
        )
        TodayGamesStore.prewarm(
            scope = viewModelScope,
            delayMs = PREWARM_DELAY_MS,
            dispatcher = Dispatchers.IO,
        )
    }

    fun onJerseyInputChange(updated: String) {
        jerseyInput = updated.filter(Char::isDigit).take(2)
    }

    fun updateAwayTeam(team: AnyTeam) {
        if (awayTeam == team) return
        awayTeam = team
        persistTeam(KEY_AWAY_LEAGUE, KEY_AWAY_ABBR, team)
    }

    fun updateHomeTeam(team: AnyTeam) {
        if (homeTeam == team) return
        homeTeam = team
        persistTeam(KEY_HOME_LEAGUE, KEY_HOME_ABBR, team)
    }

    private fun emptyUiState(): PlayerNumberUiState =
        PlayerNumberUiState(
            jerseyNumber = "",
            away =
                TeamRosterUiState(
                    team = awayTeam,
                    player = null,
                    rosterStatus =
                        RosterStatus(
                            source = RosterSource.STATIC,
                            lastUpdatedMillis = null,
                        ),
                ),
            home =
                TeamRosterUiState(
                    team = homeTeam,
                    player = null,
                    rosterStatus =
                        RosterStatus(
                            source = RosterSource.STATIC,
                            lastUpdatedMillis = null,
                        ),
                ),
        )

    private fun createRosterRepository(): RosterRepository {
        val moshi =
            Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit =
            Retrofit
                .Builder()
                .baseUrl("https://site.api.espn.com/")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        val service = retrofit.create(EspnRosterService::class.java)
        val api = EspnRosterApi(service, Dispatchers.IO)
        val cacheStore = FileRosterCacheStore(getApplication(), moshi, Dispatchers.IO)
        return EspnRosterRepository(
            api = api,
            cache = cacheStore,
            scope = viewModelScope,
            ioDispatcher = Dispatchers.IO,
        )
    }

    private companion object {
        private const val PREFS_NAME = "player_number_prefs"
        private const val KEY_AWAY_LEAGUE = "matchup_away_league"
        private const val KEY_AWAY_ABBR = "matchup_away_abbr"
        private const val KEY_HOME_LEAGUE = "matchup_home_league"
        private const val KEY_HOME_ABBR = "matchup_home_abbr"
        private const val PREWARM_DELAY_MS = 1_000L
    }

    private fun restoreMatchup() {
        loadSavedTeam(KEY_AWAY_LEAGUE, KEY_AWAY_ABBR)?.let { awayTeam = it }
        loadSavedTeam(KEY_HOME_LEAGUE, KEY_HOME_ABBR)?.let { homeTeam = it }
    }

    private fun loadSavedTeam(
        leagueKey: String,
        abbrKey: String,
    ): AnyTeam? {
        val leagueId = sharedPreferences.getString(leagueKey, null) ?: return null
        val abbreviation = sharedPreferences.getString(abbrKey, null) ?: return null
        return LeagueCatalog
            .firstOrNull { it.id == leagueId }
            ?.teams
            ?.firstOrNull { it.abbreviation == abbreviation }
    }

    private fun persistTeam(
        leagueKey: String,
        abbrKey: String,
        team: AnyTeam,
    ) {
        sharedPreferences.edit()
            .putString(leagueKey, team.league.name)
            .putString(abbrKey, team.abbreviation)
            .apply()
    }
}
