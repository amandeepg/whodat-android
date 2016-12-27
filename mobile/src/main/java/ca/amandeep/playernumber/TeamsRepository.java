package ca.amandeep.playernumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import java.util.List;

import ca.amandeep.playernumber.core.Config;
import ca.amandeep.playernumber.core.Logger;
import ca.amandeep.playernumber.db.DbOpenHelper;
import ca.amandeep.playernumber.models.Team;
import ca.amandeep.playernumber.models.TeamModel;
import rx.Single;
import rx.schedulers.Schedulers;

public class TeamsRepository {

    private static final String TAG = "TeamsRepository";

    private static final String PREF_LAST_TEAMS_FETCH = "PREF_LAST_TEAMS_FETCH_";
    private static final String MAX_AGE_TEAMS_KEY = "max_age_teams";

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
                        Logger.d(TAG, "go fetch from api");
                        return PlayerNumberApplication.getService().listTeams()
                                .subscribeOn(Schedulers.io())
                                .observeOn(Schedulers.io())
                                .doOnNext(teams -> Logger.d(TAG, "fetched from api: " + teams.size()))
                                .toSingle()
                                .doOnSuccess(this::writeTeamsToDb)
                                .map(teams -> null);
                    } else {
                        return Single.just(null);
                    }
                });
    }

    private void writeTeamsToDb(List<Team> teams) {
        Logger.d(TAG, "Thread report: Save to DB on: " + Thread.currentThread());
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
        Logger.d(TAG, "Thread report: Read from prefs on: " + Thread.currentThread());
        final long lastFetch = mPrefs.getLong(PREF_LAST_TEAMS_FETCH, 0);
        final boolean fetchFromCache = System.currentTimeMillis() - lastFetch <= Config.getLong(MAX_AGE_TEAMS_KEY);
        Logger.d(TAG, "shouldFetchFromCache: " + fetchFromCache);
        return fetchFromCache;
    }
}
