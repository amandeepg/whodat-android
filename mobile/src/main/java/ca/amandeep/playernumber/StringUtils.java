package ca.amandeep.playernumber;


public class StringUtils {
    private StringUtils() {
        //no instance
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
