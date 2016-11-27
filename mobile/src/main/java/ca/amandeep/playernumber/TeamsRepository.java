package ca.amandeep.playernumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import ca.amandeep.playernumber.db.DbOpenHelper;
import ca.amandeep.playernumber.models.Team;
import ca.amandeep.playernumber.models.TeamModel;
import rx.Single;
import rx.schedulers.Schedulers;

public class TeamsRepository {

    private static final String TAG = "TeamsRepository";

    private static final String PREF_LAST_TEAMS_FETCH = "PREF_LAST_TEAMS_FETCH_";
    private static final long MAX_STALE_ALLOWANCE_MILLIS = 1000L * 60L * 60L * 24L * 60L; // 1000 ms * 60 s * 60 m * 24 h * 60 d = 1month

    private final SharedPreferences mPrefs;
    private final DbOpenHelper mDbHelper;

    public TeamsRepository(@NonNull Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mDbHelper = DbOpenHelper.getInstance(context);
    }

    @NonNull
    public Single<Void> getTeams() {
        return Single.<Boolean>create(subscriber -> subscriber.onSuccess(shouldFetchFromCache()))
                .subscribeOn(Schedulers.io())
                .flatMap(shouldFetchFromCache -> {
                    if (!shouldFetchFromCache) {
                        Log.d(TAG, "go fetch from api");
                        return MyApplication.getsService().listTeams()
                                .subscribeOn(Schedulers.io())
                                .observeOn(Schedulers.io())
                                .doOnNext(teams -> Log.d(TAG, "fetched from api: " + teams.size()))
                                .toSingle()
                                .doOnSuccess(this::writeTeamsToDb)
                                .map(teams -> null);
                    } else {
                        return Single.just(null);
                    }
                });
    }

    private void writeTeamsToDb(List<Team> teams) {
        Log.d(TAG, "Thread report: Save to DB on: " + Thread.currentThread());
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final TeamModel.InsertTeam insertTeam = new TeamModel.InsertTeam(db);

        for (final Team team : teams) {
            insertTeam.bind(team.id(), team.city(), team.name(), team.abbreviation(), team.colour());
            try {
                insertTeam.program.executeInsert();
            } catch (SQLiteConstraintException ignored) {
                // skip if already inside
            }
        }

        mPrefs
                .edit()
                .putLong(PREF_LAST_TEAMS_FETCH, System.currentTimeMillis())
                .apply();
    }

    private boolean shouldFetchFromCache() {
        Log.d(TAG, "Thread report: Read from prefs on: " + Thread.currentThread());
        final long lastFetch = mPrefs.getLong(PREF_LAST_TEAMS_FETCH, 0);
        final boolean fetchFromCache = System.currentTimeMillis() - lastFetch <= MAX_STALE_ALLOWANCE_MILLIS;
        Log.d(TAG, "shouldFetchFromCache: " + fetchFromCache);
        return fetchFromCache;
    }
}
