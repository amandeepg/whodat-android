package ca.amandeep.playernumber.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EspnScoreboardService {
    @GET("apis/site/v2/sports/{sport}/{league}/scoreboard")
    suspend fun fetchScoreboard(
        @Path("sport") sport: String,
        @Path("league") league: String,
        @Query("dates") dates: String,
    ): EspnScoreboardResponse
}
