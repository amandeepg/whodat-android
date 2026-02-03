package ca.amandeep.playernumber.data

import java.util.Locale

@JvmInline
value class JerseyNumber private constructor(
    val value: String,
) {
    companion object {
        fun from(raw: String): JerseyNumber? = raw.trim().takeIf { it.isNotEmpty() }?.let(::JerseyNumber)
    }
}

@JvmInline
value class TeamId private constructor(
    val value: String,
) {
    companion object {
        fun from(team: AnyTeam): TeamId = from(team.league, team.abbreviation)

        fun from(
            league: LeagueId,
            abbreviation: String,
        ): TeamId = TeamId("${league.name}:${abbreviation.trim().uppercase(Locale.ROOT)}")
    }
}

fun AnyTeam.teamId(): TeamId = TeamId.from(this)

interface RosterLookup {
    fun findPlayer(
        team: TeamId,
        number: JerseyNumber,
    ): AnyPlayer?
}

private val teamsById: Map<TeamId, AnyTeam> by lazy(LazyThreadSafetyMode.NONE) {
    AllTeams.associateBy(AnyTeam::teamId)
}

internal fun teamForId(teamId: TeamId): AnyTeam? = teamsById[teamId]

internal fun findPlayerInRoster(
    players: List<AnyPlayer>,
    number: JerseyNumber,
): AnyPlayer? = players.lastOrNull { it.jerseyNumber == number.value }

object StaticRosterLookup : RosterLookup {
    override fun findPlayer(
        team: TeamId,
        number: JerseyNumber,
    ): AnyPlayer? = teamForId(team)?.roster?.let { findPlayerInRoster(it, number) }
}
