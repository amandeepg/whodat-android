package ca.amandeep.playernumber;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import ca.amandeep.playernumber.models.Game;
import rx.Single;
import rx.schedulers.Schedulers;

public class GamesRepository {

    private static final String TAG = "GamesRepository";

    @NonNull
    public Single<List<Game>> getGames() {
        return MyApplication.getsService().listGames()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(games -> Log.d(TAG, "fetched from api: " + games.size()))
                .toSingle();
    }

}
