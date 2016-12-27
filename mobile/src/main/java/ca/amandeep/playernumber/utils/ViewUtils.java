package ca.amandeep.playernumber.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtils {
    public static void showKeyboard(@NonNull View view) {
        final InputMethodManager inputMethodManager =
                (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInputFromWindow(
                view.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
    }
}
