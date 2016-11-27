package ca.amandeep.playernumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.sqldelight.SqlDelightStatement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
    private static final long MAX_STALE_ALLOWANCE_MILLIS = 1000L * 60L * 60L * 24L; // 1000 ms * 60 s * 60 m * 24 h = 1d
    private final SharedPreferences mPrefs;
    private final DbOpenHelper mDbHelper;

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
                        Log.d(TAG, "go fetch from api");
                        return MyApplication.getsService().listPlayers(team.id(), team.id())
                                .subscribeOn(Schedulers.io())
                                .observeOn(Schedulers.io())
                                .doOnNext(playerTeams -> Log.d(TAG, "fetched from api: " + playerTeams.size()))
                                .toSingle()
                                .doOnSuccess(this::writePlayersToDb)
                                .map(playerTeams -> null);
                    } else {
                        return Single.just(null);
                    }
                }).map(ignore -> readPlayersFromDb(findTeam(team)));
    }

    @NonNull
    private List<Player> readPlayersFromDb(@NonNull Team team) {
        Log.d(TAG, "Thread report: Read from DB on: " + Thread.currentThread());
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final SqlDelightStatement query = Player.FACTORY.forTeam(team.id());
        final Cursor playersCursor = db.rawQuery(query.statement, query.args);

        final List<Player> players = new ArrayList<>(playersCursor.getCount());
        while (playersCursor.moveToNext()) {
            players.add(Player.FOR_TEAM_MAPPER.map(playersCursor).player());
        }
        Log.d(TAG, "readPlayersFromDb: players.size(): " + players.size());
        return players;
    }

    private void writePlayersToDb(List<PlayerTeam> playerTeams) {
        Log.d(TAG, "Thread report: Save to DB on: " + Thread.currentThread());
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final PlayerModel.InsertPlayer insertPlayer = new PlayerModel.InsertPlayer(db, Player.FACTORY);

        final Set<Team> teamsWritten = new HashSet<>(2);

        for (final PlayerTeam playerTeam : playerTeams) {
            final Player player = playerTeam.player();
            final SqlDelightStatement query = Team.FACTORY.findTeam(playerTeam.team().id());
            final Cursor teamsCursor = db.rawQuery(query.statement, query.args);
            if (BuildConfig.DEBUG) {
                if (teamsCursor.getCount() != 1) {
                    throw new RuntimeException("Should only find 1 team");
                }
            }
            teamsCursor.moveToFirst();
            final Team team = Team.SELECT_ALL_MAPPER.map(teamsCursor);

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
            try {
                insertPlayer.program.executeInsert();
            } catch (SQLiteConstraintException ignored) {
                // skip if already inside
            }
            teamsWritten.add(team);
        }

        final long currentTimeMillis = System.currentTimeMillis();
        final SharedPreferences.Editor editor = mPrefs.edit();
        for (Team team : teamsWritten) {
            Log.d(TAG, String.format(Locale.US,
                    "writePlayersToDb: Setting PREF flag, players of team %s written now at %s",
                    team.abbreviation(), currentTimeMillis));
            editor.putLong(PREF_LAST_PLAYERS_FETCH + team.id(), currentTimeMillis);
        }
        editor.apply();
    }

    private boolean shouldFetchFromCache(@NonNull Team team) {
        Log.d(TAG, "Thread report: Read from prefs on: " + Thread.currentThread());
        final long lastFetch = mPrefs.getLong(PREF_LAST_PLAYERS_FETCH + team.id(), 0);
        final long staleMillis = System.currentTimeMillis() - lastFetch;
        final boolean fetchFromCache = staleMillis <= MAX_STALE_ALLOWANCE_MILLIS;
        Log.d(TAG, "shouldFetchFromCache: " + fetchFromCache);
        return fetchFromCache;
    }

    private Team findTeam(Team team) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final SqlDelightStatement query = Team.FACTORY.findTeam(team.id());
        final Cursor teamsCursor = db.rawQuery(query.statement, query.args);
        if (BuildConfig.DEBUG) {
            if (teamsCursor.getCount() != 1) {
                throw new RuntimeException("Should only find 1 team");
            }
        }
        teamsCursor.moveToFirst();
        return Team.SELECT_ALL_MAPPER.map(teamsCursor);
    }
}
