package ca.amandeep.playernumber;


import android.text.Editable;
import android.text.TextWatcher;

public class AfterTextWatcherHolder implements TextWatcher {

    private final AfterTextWatcher mAfterTextWatcher;

    public AfterTextWatcherHolder(AfterTextWatcher afterTextWatcher) {
        mAfterTextWatcher = afterTextWatcher;
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        mAfterTextWatcher.afterTextChanged(editable);
    }

    public interface AfterTextWatcher {
        void afterTextChanged(Editable editable);
    }
}
