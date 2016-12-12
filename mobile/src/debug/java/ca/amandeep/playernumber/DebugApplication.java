package ca.amandeep.playernumber;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class DebugApplication extends PlayerNumberApplication {

    public void onCreate() {
        Stetho.initializeWithDefaults(this);

        super.onCreate();
    }

    @Override
    protected OkHttpClient.Builder createOkHttpClientBuilder(@NonNull Context context) {
        return super.createOkHttpClientBuilder(context)
                .addNetworkInterceptor(new StethoInterceptor());
    }
}
