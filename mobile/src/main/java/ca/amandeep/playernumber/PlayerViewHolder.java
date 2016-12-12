package ca.amandeep.playernumber;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PlayerViewHolder {
    @NonNull public abstract TextView getFirstNameView();
    @NonNull public abstract TextView getLastNameView();
    @NonNull public abstract TextView getBirthPlaceView();
    @NonNull public abstract TextView getTeamLabelView();
    @NonNull public abstract TextView getStatusView();
    @NonNull public abstract View getContainerView();

    @NonNull
    public static Builder newBuilder() {
        return new AutoValue_PlayerViewHolder.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setFirstNameView(TextView v);
        public abstract Builder setLastNameView(TextView v);
        public abstract Builder setBirthPlaceView(TextView v);
        public abstract Builder setTeamLabelView(TextView v);
        public abstract Builder setStatusView(TextView v);
        public abstract Builder setContainerView(View v);

        abstract PlayerViewHolder build();
    }
}
