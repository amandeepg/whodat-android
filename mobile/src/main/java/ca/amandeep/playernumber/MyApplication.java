package ca.amandeep.playernumber;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.moshi.Moshi;

import ca.amandeep.playernumber.api.PlayerNumberService;
import ca.amandeep.playernumber.models.AutoValueMoshiFactory;
import ca.amandeep.playernumber.models.CalendarAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MyApplication extends Application {
    private static PlayerNumberService sService;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://player-number.herokuapp.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder()
                        .add(AutoValueMoshiFactory.create())
                        .add(new CalendarAdapter())
                        .build()))
                .build();

        sService = retrofit.create(PlayerNumberService.class);
    }

    public static synchronized PlayerNumberService getsService() {
        return sService;
    }
}
