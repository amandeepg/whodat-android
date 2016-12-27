package ca.amandeep.playernumber.intro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

public class IntroStarter {

    private static final String PREF_FIRST_TIME = "first_time";
    private static final String PREF_OVERRIDE_FIRST_TIME = "override_first_time";

    public static void startIntroIfFirstTime(@NonNull Context context) {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (prefs.getBoolean(PREF_FIRST_TIME, true) || prefs.getBoolean(PREF_OVERRIDE_FIRST_TIME, false)) {
            context.startActivity(new Intent(context, IntroActivity.class));
        }
        prefs.edit().putBoolean(PREF_FIRST_TIME, false).apply();
    }
}
