package ca.amandeep.playernumber;

import android.support.annotation.NonNull;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class Config {

    @NonNull
    public static String getString(@NonNull String key) {
        return getConfig().getString(key);
    }

    public static int getInt(@NonNull String key) {
        return (int) getConfig().getLong(key);
    }

    public static long getLong(@NonNull String key) {
        return getConfig().getLong(key);
    }
    public static float getFloat(@NonNull String key) {
        return (float) getConfig().getDouble(key);
    }

    @NonNull
    private static FirebaseRemoteConfig getConfig() {
        return FirebaseRemoteConfig.getInstance();
    }
}
