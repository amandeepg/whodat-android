package ca.amandeep.playernumber.core;

import android.content.Context;
import android.support.annotation.NonNull;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.google.firebase.analytics.FirebaseAnalytics;

public class Analytics {

    public static void logEvent(@NonNull Context context, @NonNull String event) {
        Answers.getInstance().logCustom(new CustomEvent(event));
        FirebaseAnalytics.getInstance(context).logEvent(event, null);
    }
}
