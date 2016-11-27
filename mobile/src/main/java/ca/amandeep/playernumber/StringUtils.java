package ca.amandeep.playernumber;

import android.support.annotation.NonNull;

public class StringUtils {
    private StringUtils() {
        //no instance
    }

    public static int toInt(@NonNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
