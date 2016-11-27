package ca.amandeep.playernumber;

import android.view.View;
import android.widget.TextView;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PlayerViewHolder {
    public abstract TextView getFirstNameView();
    public abstract TextView getLastNameView();
    public abstract TextView getBirthPlaceView();
    public abstract TextView getTeamLabelView();
    public abstract View getContainerView();

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

        abstract PlayerViewHolder autoBuild();

        public PlayerViewHolder build() {
            final PlayerViewHolder playerViewHolder = autoBuild();

            assert playerViewHolder.getFirstNameView() != null;
            assert playerViewHolder.getLastNameView() != null;
            assert playerViewHolder.getBirthPlaceView() != null;
            assert playerViewHolder.getTeamLabelView() != null;
            assert playerViewHolder.getContainerView() != null;

            return playerViewHolder;
        }
    }
}
