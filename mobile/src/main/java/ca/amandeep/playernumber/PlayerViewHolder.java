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
    @NonNull public abstract View getContainerView();

    @NonNull
    public static Builder newBuilder() {
        return new AutoValue_PlayerViewHolder.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setFirstNameView(TextView firstNameView);
        public abstract Builder setLastNameView(TextView lastNameView);
        public abstract Builder setBirthPlaceView(TextView birthPlaceView);
        public abstract Builder setTeamLabelView(TextView teamLabelView);
        public abstract Builder setContainerView(View containerView);

        abstract PlayerViewHolder build();
    }
}
