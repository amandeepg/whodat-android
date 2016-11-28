package ca.amandeep.playernumber;

import android.app.Application;

import com.squareup.moshi.Moshi;

import ca.amandeep.playernumber.api.PlayerNumberService;
import ca.amandeep.playernumber.models.AutoValueMoshiFactory;
import ca.amandeep.playernumber.models.CalendarAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class PlayerNumberApplication extends Application {
    public static final String BASE_URL = "https://player-number.herokuapp.com";

    private static PlayerNumberService sService;

    public static synchronized PlayerNumberService getService() {
        return sService;
    }

    public void onCreate() {
        super.onCreate();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder()
                        .add(AutoValueMoshiFactory.create())
                        .add(new CalendarAdapter())
                        .build()))
                .build();

        sService = retrofit.create(PlayerNumberService.class);
    }
}
