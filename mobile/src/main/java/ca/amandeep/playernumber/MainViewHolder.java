package ca.amandeep.playernumber;

import android.support.annotation.NonNull;
import android.widget.EditText;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MainViewHolder {
    @NonNull public abstract PlayerViewHolder getHomePlayerViewHolder();
    @NonNull public abstract PlayerViewHolder getAwayPlayerViewHolder();
    @NonNull public abstract EditText getJerseyNumberEditText();

    @NonNull
    public static Builder newBuilder() {
        return new AutoValue_MainViewHolder.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setHomePlayerViewHolder(PlayerViewHolder homePlayerViewHolder);
        public abstract Builder setAwayPlayerViewHolder(PlayerViewHolder awayPlayerViewHolder);
        public abstract Builder setJerseyNumberEditText(EditText jerseyNumberEditText);

        abstract MainViewHolder build();
    }
}
