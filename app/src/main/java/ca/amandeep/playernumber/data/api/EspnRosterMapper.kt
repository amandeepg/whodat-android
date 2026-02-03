package ca.amandeep.playernumber.data.api

import ca.amandeep.playernumber.data.AnyPlayer
import ca.amandeep.playernumber.data.CustomPosition
import ca.amandeep.playernumber.data.MlbPosition
import ca.amandeep.playernumber.data.MlsPosition
import ca.amandeep.playernumber.data.NbaPosition
import ca.amandeep.playernumber.data.NflPosition
import ca.amandeep.playernumber.data.NhlPosition
import ca.amandeep.playernumber.data.Player
import ca.amandeep.playernumber.data.Position
import java.util.Locale

internal fun EspnRosterResponse.toPlayers(league: EspnLeague): List<AnyPlayer> {
    val entries = athletes.orEmpty()
    if (entries.isEmpty()) return emptyList()
    val flattened =
        entries.flatMap { entry ->
            entry.items?.takeIf { it.isNotEmpty() } ?: listOf(entry)
        }
    return flattened.mapNotNull { entry -> entry.toPlayer(league) }
}

private fun EspnRosterEntry.toPlayer(league: EspnLeague): AnyPlayer? {
    val jerseyNumber = jersey?.trim().orEmpty()
    if (jerseyNumber.isBlank()) return null
    val resolvedNames =
        resolveNames(
            firstName = firstName,
            lastName = lastName,
            displayName = displayName,
            fullName = fullName,
        )
    val first = resolvedNames.first
    val last = resolvedNames.second
    if (first.isBlank() && last.isBlank()) return null

    val (cleanLast, suffix) = splitSuffixFromLastName(last)
    val suffixFromFull = suffix ?: extractSuffix(fullName) ?: extractSuffix(displayName)

    val (positionAbbrev, positionName) = resolvePosition(position)
    val positionValue =
        mapPositionForLeague(
            league = league,
            abbreviation = positionAbbrev,
            name = positionName,
        )
    return Player(
        firstName = first,
        lastName = cleanLast,
        position = positionValue,
        jerseyNumber = jerseyNumber,
        suffix = suffixFromFull,
    )
}

private fun resolveNames(
    firstName: String?,
    lastName: String?,
    displayName: String?,
    fullName: String?,
): Pair<String, String> {
    val safeFirst = firstName?.trim().orEmpty()
    val safeLast = lastName?.trim().orEmpty()
    if (safeFirst.isNotBlank() && safeLast.isNotBlank()) {
        return safeFirst to safeLast
    }

    val source = displayName?.takeIf { it.isNotBlank() } ?: fullName.orEmpty()
    val trimmedSource = source.trim()
    if (trimmedSource.isBlank()) {
        return safeFirst to safeLast
    }
    val parts = trimmedSource.split(whitespaceRegex)
    val derivedFirst = parts.first()
    val derivedLast = parts.drop(1).joinToString(" ")
    return when {
        safeFirst.isBlank() && safeLast.isBlank() -> derivedFirst to derivedLast
        safeFirst.isBlank() -> derivedFirst to safeLast
        safeLast.isBlank() -> safeFirst to derivedLast
        else -> safeFirst to safeLast
    }
}

private val whitespaceRegex = Regex("\\s+")

private val suffixTokens =
    mapOf(
        "JR" to "Jr.",
        "SR" to "Sr.",
        "II" to "II",
        "III" to "III",
        "IV" to "IV",
        "V" to "V",
    )

private fun splitSuffixFromLastName(lastName: String): Pair<String, String?> {
    val trimmed = lastName.trim()
    if (trimmed.isBlank()) return trimmed to null
    val parts = trimmed.split(whitespaceRegex)
    val lastToken = parts.last()
    val suffix = suffixTokens[normalizeSuffixToken(lastToken)]
    return if (suffix != null && parts.size > 1) {
        parts.dropLast(1).joinToString(" ") to suffix
    } else {
        trimmed to null
    }
}

private fun extractSuffix(source: String?): String? {
    val trimmed = source?.trim().orEmpty()
    if (trimmed.isBlank()) return null
    val parts = trimmed.split(whitespaceRegex)
    val lastToken = parts.last()
    return suffixTokens[normalizeSuffixToken(lastToken)]
}

private fun resolvePosition(position: Any?): Pair<String?, String?> =
    when (position) {
        is Map<*, *> -> {
            val abbrev = position["abbreviation"] as? String
            val name =
                (position["name"] as? String).takeUnless { it.isNullOrBlank() }
                    ?: position["displayName"] as? String
            abbrev to name
        }

        is String -> {
            position to position
        }

        else -> {
            null to null
        }
    }

internal fun mapPositionForLeague(
    league: EspnLeague,
    abbreviation: String?,
    name: String?,
): Position {
    val normalizedAbbrev = abbreviation?.trim()?.uppercase(Locale.US)
    val normalizedName = name?.trim()
    val mapped =
        when (league) {
            EspnLeague.NBA -> mapNbaPosition(normalizedAbbrev, normalizedName)
            EspnLeague.NHL -> mapNhlPosition(normalizedAbbrev, normalizedName)
            EspnLeague.NFL -> mapNflPosition(normalizedAbbrev, normalizedName)
            EspnLeague.MLB -> mapMlbPosition(normalizedAbbrev, normalizedName)
            EspnLeague.MLS -> mapMlsPosition(normalizedAbbrev, normalizedName)
        }

    return mapped ?: fallbackPosition(normalizedAbbrev, normalizedName)
}

private fun mapNbaPosition(
    abbrev: String?,
    name: String?,
): Position? =
    when (abbrev) {
        "PG" -> NbaPosition.GUARD
        "SG" -> NbaPosition.SHOOTING_GUARD
        "SF" -> NbaPosition.FORWARD
        "PF" -> NbaPosition.POWER_FORWARD
        "G" -> NbaPosition.GUARD
        "F" -> NbaPosition.FORWARD
        "C" -> NbaPosition.CENTER
        else -> name?.let { mapByLongName(it, NbaPosition.entries) }
    }

private fun mapNhlPosition(
    abbrev: String?,
    name: String?,
): Position? =
    when (abbrev) {
        "C" -> NhlPosition.CENTER
        "LW" -> NhlPosition.LEFT_WING
        "RW" -> NhlPosition.RIGHT_WING
        "D" -> NhlPosition.DEFENSE
        "G" -> NhlPosition.GOALIE
        else -> name?.let { mapByLongName(it, NhlPosition.entries) }
    }

private fun mapNflPosition(
    abbrev: String?,
    name: String?,
): Position? =
    when (abbrev) {
        "QB" -> NflPosition.QUARTERBACK
        "RB" -> NflPosition.RUNNING_BACK
        "FB" -> NflPosition.FULLBACK
        "WR" -> NflPosition.WIDE_RECEIVER
        "TE" -> NflPosition.TIGHT_END
        "C" -> NflPosition.CENTER
        "G" -> NflPosition.GUARD
        "OT" -> NflPosition.OFFENSIVE_TACKLE
        "DE" -> NflPosition.DEFENSIVE_END
        "DT" -> NflPosition.DEFENSIVE_TACKLE
        "LB" -> NflPosition.LINEBACKER
        "CB" -> NflPosition.CORNERBACK
        "S" -> NflPosition.SAFETY
        "FS" -> NflPosition.SAFETY
        "SS" -> NflPosition.SAFETY
        "P" -> NflPosition.PUNTER
        "PK" -> NflPosition.PLACEKICKER
        "K" -> NflPosition.PLACEKICKER
        "LS" -> NflPosition.LONG_SNAPPER
        else -> name?.let { mapByLongName(it, NflPosition.entries) }
    }

private fun mapMlbPosition(
    abbrev: String?,
    name: String?,
): Position? =
    when (abbrev) {
        "1B" -> MlbPosition.FIRST_BASE
        "2B" -> MlbPosition.SECOND_BASE
        "3B" -> MlbPosition.THIRD_BASE
        "SS" -> MlbPosition.SHORTSTOP
        "C" -> MlbPosition.CATCHER
        "DH" -> MlbPosition.DESIGNATED_HITTER
        "LF" -> MlbPosition.LEFT_FIELD
        "CF" -> MlbPosition.CENTER_FIELD
        "RF" -> MlbPosition.RIGHT_FIELD
        "OF" -> MlbPosition.OUTFIELD
        "SP" -> MlbPosition.STARTING_PITCHER
        "RP" -> MlbPosition.RELIEF_PITCHER
        else -> name?.let { mapByLongName(it, MlbPosition.entries) }
    }

private fun mapMlsPosition(
    abbrev: String?,
    name: String?,
): Position? =
    when (abbrev) {
        "GK", "G" -> MlsPosition.GOALKEEPER
        "D", "DF", "CB", "LB", "RB", "LWB", "RWB" -> MlsPosition.DEFENDER
        "M", "MF", "CM", "DM", "AM", "LM", "RM", "CDM", "CAM" -> MlsPosition.MIDFIELDER
        "F", "FW", "ST", "CF", "LW", "RW" -> MlsPosition.FORWARD
        else -> name?.let { mapByLongName(it, MlsPosition.entries) }
    }

private fun <T> mapByLongName(
    name: String,
    entries: Iterable<T>,
): Position? where T : Enum<T>, T : Position {
    val normalized = name.trim().lowercase(Locale.US)
    return entries.firstOrNull { it.longName.lowercase(Locale.US) == normalized }
}

private fun fallbackPosition(
    abbrev: String?,
    name: String?,
): Position {
    val shortName =
        abbrev?.takeIf { it.isNotBlank() }
            ?: name
                ?.trim()
                ?.takeIf { it.isNotBlank() }
                ?.split(whitespaceRegex)
                ?.joinToString("") { it.first().toString() }
            ?: "UNK"
    val longName =
        name?.trim()?.takeIf { it.isNotBlank() }
            ?: abbrev?.takeIf { it.isNotBlank() }
            ?: "Unknown"
    return CustomPosition(shortName, longName)
}

private fun normalizeSuffixToken(token: String): String = token.replace(".", "").uppercase(Locale.US)
