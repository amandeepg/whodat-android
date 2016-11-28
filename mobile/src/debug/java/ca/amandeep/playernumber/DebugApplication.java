package ca.amandeep.playernumber;

import com.facebook.stetho.Stetho;

public class DebugApplication extends PlayerNumberApplication {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
