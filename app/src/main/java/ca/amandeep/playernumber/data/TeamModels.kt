package ca.amandeep.playernumber.data

import androidx.compose.ui.graphics.Color

sealed interface Position {
    val shortName: String
    val longName: String
}

data class CustomPosition(
    override val shortName: String,
    override val longName: String,
) : Position

enum class NbaPosition(
    override val shortName: String,
    override val longName: String,
) : Position {
    GUARD("G", "Guard"),
    SHOOTING_GUARD("SG", "Shooting Guard"),
    FORWARD("F", "Forward"),
    POWER_FORWARD("PF", "Power Forward"),
    CENTER("C", "Center"),
}

enum class NhlPosition(
    override val shortName: String,
    override val longName: String,
) : Position {
    CENTER("C", "Center"),
    LEFT_WING("LW", "Left Wing"),
    RIGHT_WING("RW", "Right Wing"),
    DEFENSE("D", "Defense"),
    GOALIE("G", "Goalie"),
}

enum class NflPosition(
    override val shortName: String,
    override val longName: String,
) : Position {
    QUARTERBACK("QB", "Quarterback"),
    RUNNING_BACK("RB", "Running Back"),
    FULLBACK("FB", "Fullback"),
    WIDE_RECEIVER("WR", "Wide Receiver"),
    TIGHT_END("TE", "Tight End"),
    CENTER("C", "Center"),
    GUARD("G", "Guard"),
    OFFENSIVE_TACKLE("OT", "Offensive Tackle"),
    DEFENSIVE_END("DE", "Defensive End"),
    DEFENSIVE_TACKLE("DT", "Defensive Tackle"),
    LINEBACKER("LB", "Linebacker"),
    CORNERBACK("CB", "Cornerback"),
    SAFETY("S", "Safety"),
    PUNTER("P", "Punter"),
    PLACEKICKER("PK", "Placekicker"),
    LONG_SNAPPER("LS", "Long Snapper"),
}

enum class MlbPosition(
    override val shortName: String,
    override val longName: String,
) : Position {
    FIRST_BASE("1B", "First Base"),
    SECOND_BASE("2B", "Second Base"),
    THIRD_BASE("3B", "Third Base"),
    SHORTSTOP("SS", "Shortstop"),
    CATCHER("C", "Catcher"),
    DESIGNATED_HITTER("DH", "Designated Hitter"),
    LEFT_FIELD("LF", "Left Field"),
    CENTER_FIELD("CF", "Center Field"),
    RIGHT_FIELD("RF", "Right Field"),
    OUTFIELD("OF", "Outfield"),
    STARTING_PITCHER("SP", "Starting Pitcher"),
    RELIEF_PITCHER("RP", "Relief Pitcher"),
}

enum class MlsPosition(
    override val shortName: String,
    override val longName: String,
) : Position {
    GOALKEEPER("GK", "Goalkeeper"),
    DEFENDER("D", "Defender"),
    MIDFIELDER("M", "Midfielder"),
    FORWARD("F", "Forward"),
}

data class Player<out P : Position>(
    val firstName: String,
    val lastName: String,
    val position: P,
    val jerseyNumber: Int,
    val suffix: String? = null,
) {
    val lastNameWithSuffix: String
        get() {
            val trimmedSuffix = suffix?.trim().orEmpty()
            return if (trimmedSuffix.isNotEmpty()) {
                "$lastName $trimmedSuffix"
            } else {
                lastName
            }
        }
    val firstNameWithSuffix: String
        get() {
            val trimmedSuffix = suffix?.trim().orEmpty()
            return if (trimmedSuffix.isNotEmpty()) {
                "$firstName $trimmedSuffix"
            } else {
                firstName
            }
        }
}

data class TeamColors(
    val primary: Color,
    val nameAccent: Color,
)

data class VenueLocation(
    val lat: Double,
    val long: Double,
)

data class TeamVenue(
    val name: String,
    val location: VenueLocation,
)

enum class LeagueId {
    NBA,
    NHL,
    NFL,
    MLB,
    MLS,
}

data class Team<out P : Position>(
    val name: String,
    val nameWidthPercent: Float,
    val abbreviation: String,
    val league: LeagueId,
    val colors: TeamColors,
    val venue: TeamVenue,
    val roster: List<Player<P>>,
) {
    val playerByNumber: Map<Int, Player<P>> = roster.associateBy { it.jerseyNumber }

    fun nickname(): String {
        val parts = name.trim().split(Regex("\\s+"))
        if (parts.size <= 1) {
            return name
        }
        return parts.last()
    }
}

data class League<out P : Position>(
    val id: String,
    val displayName: String,
    val teams: List<Team<P>>,
)

typealias AnyPlayer = Player<Position>
typealias AnyTeam = Team<Position>
typealias AnyLeague = League<Position>
