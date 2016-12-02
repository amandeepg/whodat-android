package ca.amandeep.playernumber.api;

import java.util.List;

import ca.amandeep.playernumber.models.Game;
import ca.amandeep.playernumber.models.PlayerTeam;
import ca.amandeep.playernumber.models.Team;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PlayerNumberService {
    @GET("/1/games.json")
    Observable<List<Game>> listGames();

    @GET("/1/teams.json")
    Observable<List<Team>> listTeams();

    @GET("/1/players.json")
    Observable<List<PlayerTeam>> listPlayers(@Query("team") String team);
}
