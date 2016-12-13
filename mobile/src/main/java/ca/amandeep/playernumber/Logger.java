package ca.amandeep.playernumber;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Locale;

public class Logger {
    public static void d(@NonNull String tag, @NonNull String message, @Nullable String... args) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, String.format(Locale.US, message, (Object[]) args));
        }
    }

    public static void d(@NonNull String tag, @NonNull String message, @NonNull Exception e) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message, e);
        }
    }

    public static void d(@NonNull String tag, @NonNull String message, @NonNull Throwable t) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message, t);
        }
    }
}
