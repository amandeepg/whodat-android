package ca.amandeep.playernumber.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.squareup.sqldelight.SqlDelightStatement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.amandeep.playernumber.BuildConfig;
import ca.amandeep.playernumber.PlayerNumberApplication;
import ca.amandeep.playernumber.core.Config;
import ca.amandeep.playernumber.core.Logger;
import ca.amandeep.playernumber.db.DbOpenHelper;
import ca.amandeep.playernumber.models.Player;
import ca.amandeep.playernumber.models.PlayerModel;
import ca.amandeep.playernumber.models.PlayerTeam;
import ca.amandeep.playernumber.models.Team;
import rx.Single;
import rx.schedulers.Schedulers;

public class PlayersRepository {

    private static final String TAG = "PlayersRepository";

    private static final String PREF_LAST_PLAYERS_FETCH = "PREF_LAST_PLAYERS_FETCH_";
    private static final String MAX_AGE_PLAYERS_KEY = "max_age_players";
    @NonNull private final SharedPreferences mPrefs;
    @NonNull private final DbOpenHelper mDbHelper;

    public PlayersRepository(@NonNull Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mDbHelper = DbOpenHelper.getInstance(context);
    }

    @NonNull
    public Single<List<Player>> getPlayers(@NonNull Team team) {
        return Single.<Boolean>create(subscriber -> subscriber.onSuccess(shouldFetchFromCache(team)))
                .subscribeOn(Schedulers.io())
                .flatMap(shouldFetchFromCache -> {
                    if (!shouldFetchFromCache) {
                        Logger.d(TAG, "go fetch from api");
                        return PlayerNumberApplication.getService().listPlayers(team.id())
                                .subscribeOn(Schedulers.io())
                                .observeOn(Schedulers.io())
                                .doOnNext(playerTeams -> Logger.d(TAG, "fetched from api: " + playerTeams.size()))
                                .toSingle()
                                .doOnSuccess(playerTeams -> removePlayersFromTeam(team))
                                .doOnSuccess(this::writePlayersToDb)
                                .map(playerTeams -> null);
                    } else {
                        return Single.just(null);
                    }
                }).map(ignore -> readPlayersFromDb(findTeam(team)));
    }

    private void removePlayersFromTeam(@NonNull Team team) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final PlayerModel.DeleteTeam deleteTeam = new PlayerModel.DeleteTeam(db);
        deleteTeam.bind(team.id());
        deleteTeam.program.executeUpdateDelete();
    }

    @NonNull
    private List<Player> readPlayersFromDb(@NonNull Team team) {
        Logger.d(TAG, "Thread report: Read from DB on: " + Thread.currentThread());
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final SqlDelightStatement query = Player.FACTORY.forTeam(team.id());

        final Cursor playersCursor = db.rawQuery(query.statement, query.args);
        try {
            final List<Player> players = new ArrayList<>(playersCursor.getCount());
            while (playersCursor.moveToNext()) {
                players.add(Player.FOR_TEAM_MAPPER.map(playersCursor).player());
            }
            Logger.d(TAG, "readPlayersFromDb: players.size(): " + players.size());
            return players;
        } finally {
            if (playersCursor != null) {
                playersCursor.close();
            }
        }
    }

    private void writePlayersToDb(@NonNull List<PlayerTeam> playerTeams) {
        Logger.d(TAG, "Thread report: Save to DB on: " + Thread.currentThread());
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final PlayerModel.InsertPlayer insertPlayer = new PlayerModel.InsertPlayer(db, Player.FACTORY);

        final Set<Team> teamsWritten = new HashSet<>();

        for (final PlayerTeam playerTeam : playerTeams) {
            final Player player = playerTeam.player();
            final Team team = findTeam(playerTeam.team());

            insertPlayer.bind(
                    player.id(),
                    team._id(),
                    player.firstName(),
                    player.lastName(),
                    player.jerseyNumber(),
                    player.position(),
                    player.height(),
                    player.weight(),
                    player.birthDate(),
                    player.age(),
                    player.birthCity(),
                    player.birthCountry(),
                    player.gamesPlayed()
            );
            insertPlayer.program.executeInsert();
            teamsWritten.add(team);
        }

        final long currentTimeMillis = System.currentTimeMillis();
        final SharedPreferences.Editor editor = mPrefs.edit();
        for (Team team : teamsWritten) {
            Logger.d(TAG, "writePlayersToDb: Setting PREF flag, players of team %s written now at %s",
                    team.abbreviation(), String.valueOf(currentTimeMillis));
            editor.putLong(PREF_LAST_PLAYERS_FETCH + team.id(), currentTimeMillis);
        }
        editor.apply();
    }

    private boolean shouldFetchFromCache(@NonNull Team team) {
        Logger.d(TAG, "Thread report: Read from prefs on: " + Thread.currentThread());
        final long lastFetch = mPrefs.getLong(PREF_LAST_PLAYERS_FETCH + team.id(), 0);
        final long staleMillis = System.currentTimeMillis() - lastFetch;
        final boolean fetchFromCache = staleMillis <= Config.getLong(MAX_AGE_PLAYERS_KEY);
        Logger.d(TAG, "shouldFetchFromCache: " + fetchFromCache);
        return fetchFromCache;
    }

    @NonNull
    private Team findTeam(@NonNull Team team) {
        return findTeam(mDbHelper, team);
    }

    @NonNull
    private static Team findTeam(@NonNull DbOpenHelper dbHelper, @NonNull Team team) {
        return findTeam(dbHelper, team.id());
    }

    @NonNull
    public static Team findTeam(@NonNull Context context, @NonNull String teamId) {
        return findTeam(DbOpenHelper.getInstance(context), teamId);
    }

    @NonNull
    private static Team findTeam(@NonNull DbOpenHelper dbHelper, @NonNull String teamId) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final SqlDelightStatement query = Team.FACTORY.findTeam(teamId);

        final Cursor teamsCursor = db.rawQuery(query.statement, query.args);
        try {
            if (BuildConfig.DEBUG) {
                if (teamsCursor.getCount() != 1) {
                    throw new RuntimeException("Should only find 1 team");
                }
            }
            teamsCursor.moveToFirst();
            return Team.SELECT_ALL_MAPPER.map(teamsCursor);
        } finally {
            if (teamsCursor != null) {
                teamsCursor.close();
            }
        }
    }
}
