package ca.amandeep.playernumber.ui.jersey

import ca.amandeep.playernumber.data.AnyPlayer
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.api.RosterSource
import ca.amandeep.playernumber.data.api.RosterState

data class RosterStatus(
    val source: RosterSource,
    val lastUpdatedMillis: Long?,
)

data class PlayerNumberUiState(
    val jerseyNumber: Int?,
    val away: TeamRosterUiState,
    val home: TeamRosterUiState,
)

data class TeamRosterUiState(
    val team: AnyTeam,
    val player: AnyPlayer?,
    val rosterStatus: RosterStatus,
)

fun RosterState.toStatus() =
    RosterStatus(
        source = source,
        lastUpdatedMillis = lastUpdatedMillis,
    )
