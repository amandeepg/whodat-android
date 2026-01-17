package ca.amandeep.playernumber.ui.matchup

import android.os.SystemClock
import ca.amandeep.playernumber.data.AnyLeague
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.LeagueCatalog
import java.util.Locale
import kotlin.math.min

class TeamSearchEngine {
    private companion object {
        const val MAX_PREFIX_LENGTH = 3
        const val SINGLE_CHAR_MAX_RESULTS = 2
        const val DEFAULT_RESULTS_CAPACITY = 8
        val EmptyIntArray = IntArray(0)
    }

    data class LeagueMatches(
        val leagueLabel: String,
        val teams: List<AnyTeam>,
    )

    private val leagueSearchIndex: List<LeagueSearchIndex> = LeagueCatalog.map { league ->
        buildLeagueSearchIndex(league)
    }

    fun search(
        query: String,
        selectedName: String,
    ): List<LeagueMatches> {
        val start = SystemClock.elapsedRealtime()
        val queryTokens = tokenize(query)
        if (queryTokens.isEmpty()) {
            val durationMs = SystemClock.elapsedRealtime() - start
            return emptyList()
        }
        val selectedNameLower = selectedName.lowercase(Locale.ROOT)
        val results = leagueSearchIndex.mapNotNull { league ->
            val matches = filterTeams(
                league = league,
                queryTokens = queryTokens,
                selectedNameLower = selectedNameLower,
            )
            if (matches.isEmpty()) null else LeagueMatches(league.leagueLabel, matches)
        }
        val durationMs = SystemClock.elapsedRealtime() - start
        return results
    }

    private class LeagueSearchIndex(
        val leagueLabel: String,
        val teams: List<TeamSearchIndex>,
        val prefixIndex: Map<String, IntArray>,
        val prefixTop2: Map<String, IntArray>,
    )

    private class TeamSearchIndex(
        val team: AnyTeam,
        val nameLower: String,
        val tokenStarts: IntArray,
    )

    private fun filterTeams(
        league: LeagueSearchIndex,
        queryTokens: List<String>,
        selectedNameLower: String,
    ): List<AnyTeam> {
        if (queryTokens.isEmpty()) return emptyList()
        val singleToken = queryTokens.singleOrNull()
        return when {
            singleToken == null -> {
                filterMultiToken(league, queryTokens, selectedNameLower)
            }

            singleToken.length == 1 -> {
                filterSingleChar(league, singleToken, selectedNameLower)
            }

            singleToken.length <= MAX_PREFIX_LENGTH -> {
                collectMatches(
                    candidates = candidateIndices(league.prefixIndex, queryTokens),
                    teams = league.teams,
                    selectedNameLower = selectedNameLower,
                    maxResults = Int.MAX_VALUE,
                ) { true }
            }

            else -> {
                collectMatches(
                    candidates = candidateIndices(league.prefixIndex, queryTokens),
                    teams = league.teams,
                    selectedNameLower = selectedNameLower,
                    maxResults = Int.MAX_VALUE,
                ) { teamIndex ->
                    matchesSingleToken(teamIndex.nameLower, teamIndex.tokenStarts, singleToken)
                }
            }
        }
    }

    private fun filterMultiToken(
        league: LeagueSearchIndex,
        queryTokens: List<String>,
        selectedNameLower: String,
    ): List<AnyTeam> = collectMatches(
        candidates = candidateIndices(league.prefixIndex, queryTokens),
        teams = league.teams,
        selectedNameLower = selectedNameLower,
        maxResults = Int.MAX_VALUE,
    ) { teamIndex ->
        matchesWordStarts(teamIndex.nameLower, teamIndex.tokenStarts, queryTokens)
    }

    private fun filterSingleChar(
        league: LeagueSearchIndex,
        token: String,
        selectedNameLower: String,
    ): List<AnyTeam> {
        val fullCandidates = league.prefixIndex[token] ?: EmptyIntArray
        if (fullCandidates.isEmpty()) return emptyList()
        val matches = ArrayList<AnyTeam>(SINGLE_CHAR_MAX_RESULTS)
        val top2 = league.prefixTop2[token] ?: EmptyIntArray
        var picked0 = -1
        var picked1 = -1
        for (candidateIndex in top2) {
            if (addCandidateIfEligible(candidateIndex, league.teams, selectedNameLower, matches)) {
                if (picked0 == -1) picked0 = candidateIndex else picked1 = candidateIndex
                if (matches.size == SINGLE_CHAR_MAX_RESULTS) return matches
            }
        }
        if (matches.size < SINGLE_CHAR_MAX_RESULTS) {
            for (candidateIndex in fullCandidates) {
                if (candidateIndex == picked0 || candidateIndex == picked1) continue
                if (addCandidateIfEligible(candidateIndex, league.teams, selectedNameLower, matches)) {
                    if (matches.size == SINGLE_CHAR_MAX_RESULTS) break
                }
            }
        }
        return matches
    }

    private fun addCandidateIfEligible(
        candidateIndex: Int,
        teams: List<TeamSearchIndex>,
        selectedNameLower: String,
        matches: MutableList<AnyTeam>,
    ): Boolean {
        val teamIndex = teams[candidateIndex]
        if (teamIndex.nameLower == selectedNameLower) return false
        matches.add(teamIndex.team)
        return true
    }

    private inline fun collectMatches(
        candidates: IntArray,
        teams: List<TeamSearchIndex>,
        selectedNameLower: String,
        maxResults: Int,
        crossinline predicate: (TeamSearchIndex) -> Boolean,
    ): List<AnyTeam> {
        if (candidates.isEmpty()) return emptyList()
        val capacity = if (maxResults == Int.MAX_VALUE) {
            min(candidates.size, DEFAULT_RESULTS_CAPACITY)
        } else {
            maxResults
        }
        val matches = ArrayList<AnyTeam>(capacity)
        for (candidateIndex in candidates) {
            val teamIndex = teams[candidateIndex]
            if (teamIndex.nameLower == selectedNameLower) continue
            if (!predicate(teamIndex)) continue
            matches.add(teamIndex.team)
            if (matches.size == maxResults) break
        }
        return matches
    }

    private fun matchesWordStarts(
        textLower: String,
        tokenStarts: IntArray,
        queryTokens: List<String>,
    ): Boolean {
        if (queryTokens.isEmpty() || tokenStarts.isEmpty()) return false
        var index = 0
        for (token in queryTokens) {
            var matched = false
            while (index < tokenStarts.size) {
                val start = tokenStarts[index]
                if (textLower.startsWith(token, start, ignoreCase = false)) {
                    matched = true
                    index += 1
                    break
                }
                index += 1
            }
            if (!matched) {
                return false
            }
        }
        return true
    }

    private fun matchesSingleToken(
        textLower: String,
        tokenStarts: IntArray,
        token: String,
    ): Boolean {
        if (token.isEmpty() || tokenStarts.isEmpty()) return false
        for (start in tokenStarts) {
            if (textLower.startsWith(token, start, ignoreCase = false)) {
                return true
            }
        }
        return false
    }

    private fun buildLeagueSearchIndex(league: AnyLeague): LeagueSearchIndex {
        val start = SystemClock.elapsedRealtime()
        val teams = ArrayList<TeamSearchIndex>(league.teams.size)
        val prefixMap = HashMap<String, MutableList<Int>>(league.teams.size * 2)
        league.teams.forEachIndexed { index, team ->
            val teamIndex = buildTeamSearchIndex(team)
            teams.add(teamIndex)
            val tokens = tokenizeLower(teamIndex.nameLower)
            val seenPrefixes = HashSet<String>(tokens.size * 3)
            for (token in tokens) {
                val maxPrefix = min(MAX_PREFIX_LENGTH, token.length)
                for (length in 1..maxPrefix) {
                    val prefix = token.substring(0, length)
                    if (seenPrefixes.add(prefix)) {
                        prefixMap.getOrPut(prefix) { ArrayList() }.add(index)
                    }
                }
            }
        }
        val prefixIndex = prefixMap.mapValues { it.value.toIntArray() }
        val prefixTop2 = prefixIndex
            .filterKeys { it.length == 1 }
            .mapValues { (_, list) -> list.copyOf(min(2, list.size)) }
        val index = LeagueSearchIndex(
            leagueLabel = league.displayName,
            teams = teams,
            prefixIndex = prefixIndex,
            prefixTop2 = prefixTop2,
        )
        val durationMs = SystemClock.elapsedRealtime() - start
        return index
    }

    private fun candidateIndices(
        prefixIndex: Map<String, IntArray>,
        queryTokens: List<String>,
    ): IntArray {
        if (queryTokens.isEmpty()) return EmptyIntArray
        var candidates: IntArray? = null
        for (token in queryTokens) {
            if (token.isEmpty()) continue
            val prefixLength = min(MAX_PREFIX_LENGTH, token.length)
            val prefix = token.substring(0, prefixLength)
            val matches = prefixIndex[prefix] ?: return EmptyIntArray
            candidates = if (candidates == null) {
                matches
            } else {
                intersectSorted(candidates, matches)
            }
            if (candidates.isEmpty()) return candidates
        }
        return candidates ?: EmptyIntArray
    }

    private fun intersectSorted(
        a: IntArray,
        b: IntArray,
    ): IntArray {
        if (a.isEmpty() || b.isEmpty()) return EmptyIntArray
        val result = IntArray(min(a.size, b.size))
        var i = 0
        var j = 0
        var k = 0
        while (i < a.size && j < b.size) {
            val av = a[i]
            val bv = b[j]
            if (av == bv) {
                result[k] = av
                k += 1
                i += 1
                j += 1
            } else if (av < bv) {
                i += 1
            } else {
                j += 1
            }
        }
        return result.copyOf(k)
    }

    private fun buildTeamSearchIndex(team: AnyTeam): TeamSearchIndex {
        val lower = team.name.lowercase(Locale.ROOT)
        val tokenStarts = buildTokenStarts(lower)
        return TeamSearchIndex(
            team = team,
            nameLower = lower,
            tokenStarts = tokenStarts,
        )
    }

    private fun tokenize(value: String): List<String> {
        val lower = value.lowercase(Locale.ROOT)
        return tokenizeLower(lower)
    }

    private fun tokenizeLower(lower: String): List<String> {
        val tokens = ArrayList<String>(4)
        var start = -1
        for (i in lower.indices) {
            val ch = lower[i]
            if (ch.isLetterOrDigit()) {
                if (start == -1) {
                    start = i
                }
            } else if (start != -1) {
                tokens.add(lower.substring(start, i))
                start = -1
            }
        }
        if (start != -1) {
            tokens.add(lower.substring(start))
        }
        return tokens
    }

    private fun buildTokenStarts(lower: String): IntArray {
        var starts = IntArray(8)
        var size = 0
        var inToken = false
        for (i in lower.indices) {
            val isTokenChar = lower[i].isLetterOrDigit()
            if (isTokenChar && !inToken) {
                if (size == starts.size) {
                    starts = starts.copyOf(starts.size * 2)
                }
                starts[size] = i
                size += 1
                inToken = true
            } else if (!isTokenChar) {
                inToken = false
            }
        }
        return if (size == starts.size) starts else starts.copyOf(size)
    }
}
