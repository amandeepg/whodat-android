package ca.amandeep.playernumber.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface EspnRosterService {
    @GET("apis/site/v2/sports/{sport}/{league}/teams/{abbreviation}/roster")
    suspend fun fetchRoster(
        @Path("sport") sport: String,
        @Path("league") league: String,
        @Path("abbreviation") abbreviation: String,
    ): EspnRosterResponse
}
