package ca.amandeep.playernumber.utils;

import android.graphics.Color;
import android.support.annotation.ColorInt;

public class ColourUtils {

    private ColourUtils() {
        //no instance
    }

    private static float getLuminanceComponent(float c) {
        c /= 255.0f;
        if (c < 0.03928) {
            c /= 12.92f;
        } else {
            c = (float) Math.pow((c + 0.055f) / 1.055f, 2.4);
        }
        return c;
    }

    private static float getLuminance(@ColorInt int backgroundColor) {
        final float r = getLuminanceComponent(Color.red(backgroundColor));
        final float g = getLuminanceComponent(Color.green(backgroundColor));
        final float b = getLuminanceComponent(Color.blue(backgroundColor));
        return 0.2126f * r + 0.7152f * g + 0.0722f * b;
    }

    public static boolean isBright(@ColorInt int color) {
        return getLuminance(color) > 0.179f;
    }

    @ColorInt
    public static int modifyAlpha(@ColorInt int color, int alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }
}
