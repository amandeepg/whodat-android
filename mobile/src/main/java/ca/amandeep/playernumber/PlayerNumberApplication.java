package ca.amandeep.playernumber;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.crashlytics.android.answers.Answers;
import com.squareup.moshi.Moshi;

import ca.amandeep.playernumber.api.PlayerNumberService;
import ca.amandeep.playernumber.models.AutoValueMoshiFactory;
import ca.amandeep.playernumber.models.CalendarAdapter;
import io.fabric.sdk.android.Fabric;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class PlayerNumberApplication extends Application {
    private static final String TAG = "PlayerNumberApplication";
    private static final String BASE_URL = "https://player-number.amandeep.ca";

    private static PlayerNumberService sService;

    public static synchronized PlayerNumberService getService() {
        return sService;
    }

    public void onCreate() {
        super.onCreate();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClientBuilder(getApplicationContext())
                        .build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder()
                        .add(AutoValueMoshiFactory.create())
                        .add(new CalendarAdapter())
                        .build()))
                .build();

        sService = retrofit.create(PlayerNumberService.class);

        Fabric.with(this, new Answers());
    }

    protected OkHttpClient.Builder createOkHttpClientBuilder(@NonNull Context context) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            final Cache responseCache = new Cache(context.getCacheDir(), 5 * 1024 * 1024);
            builder.cache(responseCache);
        } catch (Exception e) {
            Log.d(TAG, "Unable to set http cache", e);
        }

        return builder;
    }
}
