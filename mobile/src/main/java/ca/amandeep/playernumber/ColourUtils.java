package ca.amandeep.playernumber;

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

    public static int lighten(@ColorInt int color, double fraction) {
        final int red = lightenColor(Color.red(color), fraction);
        final int green = lightenColor(Color.green(color), fraction);
        final int blue = lightenColor(Color.blue(color), fraction);
        final int alpha = Color.alpha(color);

        return Color.argb(alpha, red, green, blue);
    }

    public static int darken(@ColorInt int color, double fraction) {
        final int red = darkenColor(Color.red(color), fraction);
        final int green = darkenColor(Color.green(color), fraction);
        final int blue = darkenColor(Color.blue(color), fraction);
        final int alpha = Color.alpha(color);

        return Color.argb(alpha, red, green, blue);
    }

    private static int darkenColor(int color, double fraction) {
        return (int) Math.max(color - (color * fraction), 0);
    }

    private static int lightenColor(int color, double fraction) {
        return (int) Math.min(color + (color * fraction), 255);
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

    public static boolean isBlackOrAlmostBlack(int color) {
        return getLuminance(color) < 0.03;
    }

    @ColorInt
    public static int modifyAlpha(@ColorInt int color, int alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }
}
