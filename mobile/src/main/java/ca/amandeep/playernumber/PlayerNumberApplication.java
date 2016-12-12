package ca.amandeep.playernumber;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashlyticsCore;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
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
    private static final String BASE_URL_KEY = "base_url";

    private static PlayerNumberService sService;

    public static synchronized PlayerNumberService getService() {
        return sService;
    }

    public void onCreate() {
        super.onCreate();

        Fabric.with(this,
                new Answers(),
                new Crashlytics.Builder()
                        .core(new CrashlyticsCore.Builder()
                                .disabled(BuildConfig.DEBUG)
                                .build())
                        .build());

        final FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        remoteConfig.setDefaults(R.xml.remote_config_defaults);
        final long cacheExpiration = getRemoteConfigCacheExpiration();
        remoteConfig.fetch(cacheExpiration)
                .addOnFailureListener(Crashlytics::logException)
                .addOnFailureListener(Throwable::printStackTrace)
                .addOnSuccessListener(nothing -> {
                    remoteConfig.activateFetched();
                    printRemoteConfig();
                });

        printRemoteConfig();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(remoteConfig.getString(BASE_URL_KEY))
                .client(createOkHttpClientBuilder(getApplicationContext())
                        .build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder()
                        .add(AutoValueMoshiFactory.create())
                        .add(new CalendarAdapter())
                        .build()))
                .build();

        sService = retrofit.create(PlayerNumberService.class);

    }

    private void printRemoteConfig() {
        final FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        for (final String key : remoteConfig.getKeysByPrefix(null)) {
            Logger.d(TAG, "printRemoteConfig: " + key + " = " + remoteConfig.getString(key));
        }
    }

    private long getRemoteConfigCacheExpiration() {
        return BuildConfig.DEBUG ? 0 : 3600;
    }

    protected OkHttpClient.Builder createOkHttpClientBuilder(@NonNull Context context) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            final Cache responseCache = new Cache(context.getCacheDir(), 5 * 1024 * 1024);
            builder.cache(responseCache);
        } catch (Exception e) {
            Logger.d(TAG, "Unable to set http cache", e);
        }

        return builder;
    }
}
