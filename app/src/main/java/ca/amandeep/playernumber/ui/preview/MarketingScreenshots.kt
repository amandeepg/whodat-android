package ca.amandeep.playernumber.ui.preview

import androidx.compose.runtime.Composable
import ca.amandeep.playernumber.data.LeagueId
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.data.NflTeamRefs
import ca.amandeep.playernumber.data.NhlTeamRefs
import ca.amandeep.playernumber.data.api.LeagueGames
import ca.amandeep.playernumber.data.api.TodayGame
import ca.amandeep.playernumber.ui.main.MatchupDestinationPreview
import ca.amandeep.playernumber.ui.matchup.HighlightedGame
import ca.amandeep.playernumber.ui.matchup.NearbyGames
import ca.amandeep.playernumber.ui.matchup.TeamSearchEngine
import ca.amandeep.playernumber.ui.matchup.TeamSelectionViewModel
import ca.amandeep.playernumber.ui.matchup.TeamSlot
import ca.amandeep.playernumber.ui.matchup.TodayGamesUiState
import java.time.LocalDate

@Composable
fun PlayerNumberScreenshotTorLaaPreview() =
    DeviceScreenshot {
        PlayerNumberMarketingPreview(
            jerseyNumber = "27",
            awayTeam = MlbTeamRefs.TOR,
            homeTeam = MlbTeamRefs.LAA,
        )
    }

@Composable
fun PlayerNumberScreenshotLacOkcPreview() =
    DiagonalSplitDeviceScreenshot {
        PlayerNumberMarketingPreview(
            jerseyNumber = "2",
            awayTeam = NbaTeamRefs.LAC,
            homeTeam = NbaTeamRefs.OKC,
        )
    }

@Composable
fun PlayerNumberScreenshotTeamSelectionPreview() =
    DeviceScreenshot {
        val searchTerm = "san "
        val state =
            TeamSelectionViewModel.State(
                awayQuery = searchTerm,
                activeSlot = TeamSlot.Away,
                groupedMatches = TeamSearchEngine().search(searchTerm, ""),
            )
        MatchupDestinationPreview(
            awayTeam = NbaTeamRefs.LAC,
            homeTeam = NbaTeamRefs.CHI,
            state = state,
        )
    }

@Composable
fun PlayerNumberScreenshotTeamSelectionAtStadiumPreview() =
    DeviceScreenshot {
        val nhlGames =
            listOf(
                TodayGame(
                    eventId = "nhl-1",
                    away = NhlTeamRefs.TOR,
                    home = NhlTeamRefs.NJ,
                ),
            )
        val mlbGames =
            listOf(
                TodayGame(
                    eventId = "mlb-1",
                    away = MlbTeamRefs.TOR,
                    home = MlbTeamRefs.NYY,
                ),
                TodayGame(
                    eventId = "mlb-2",
                    away = MlbTeamRefs.PHI,
                    home = MlbTeamRefs.NYM,
                ),
            )
        val nflGames =
            listOf(
                TodayGame(
                    eventId = "nfl-1",
                    away = NflTeamRefs.PHI,
                    home = NflTeamRefs.NYG,
                ),
                TodayGame(
                    eventId = "nfl-2",
                    away = NflTeamRefs.NE,
                    home = NflTeamRefs.NYJ,
                ),
            )
        val nbaGames =
            listOf(
                TodayGame(
                    eventId = "nba-1",
                    away = NbaTeamRefs.BOS,
                    home = NbaTeamRefs.NY,
                ),
            )
        val sampleGames =
            listOf(
                LeagueGames(
                    leagueId = LeagueId.NHL,
                    games = nhlGames,
                ),
                LeagueGames(
                    leagueId = LeagueId.MLB,
                    games = mlbGames,
                ),
                LeagueGames(
                    leagueId = LeagueId.NFL,
                    games = nflGames,
                ),
                LeagueGames(
                    leagueId = LeagueId.NBA,
                    games = nbaGames,
                ),
            )
        val atStadium =
            HighlightedGame(
                game = mlbGames.first(),
                distanceMeters = 75.0,
            )
        val closest =
            listOf(
                HighlightedGame(
                    game = nbaGames.first(),
                    distanceMeters = 9800.0,
                ),
                HighlightedGame(
                    game = mlbGames[1],
                    distanceMeters = 12200.0,
                ),
            )
        val state =
            TeamSelectionViewModel.State(
                todayGamesState = TodayGamesUiState.Loaded(LocalDate.now(), sampleGames),
                locationPermissionGranted = true,
                nearbyGames =
                    NearbyGames(
                        atStadium = atStadium,
                        closest = closest,
                    ),
            )
        MatchupDestinationPreview(
            awayTeam = nhlGames.first().away,
            homeTeam = nhlGames.first().home,
            state = state,
        )
    }

@Composable
@PreviewPixel9DayNight
private fun PlayerNumberScreenshotTorLaaPreviewWrapper() = PlayerNumberScreenshotTorLaaPreview()

@Composable
@PreviewPixel9DayNight
private fun PlayerNumberScreenshotLacOkcPreviewWrapper() = PlayerNumberScreenshotLacOkcPreview()

@Composable
@PreviewPixel9DayNight
private fun PlayerNumberScreenshotTeamSelectionPreviewWrapper() = PlayerNumberScreenshotTeamSelectionPreview()

@Composable
@PreviewPixel9DayNight
private fun PlayerNumberScreenshotTeamSelectionAtStadiumPreviewWrapper() = PlayerNumberScreenshotTeamSelectionAtStadiumPreview()
