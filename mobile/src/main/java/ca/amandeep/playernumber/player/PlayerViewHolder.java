package ca.amandeep.playernumber.player;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextSwitcher;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PlayerViewHolder {
    @NonNull public abstract TextSwitcher getFirstNameView();
    @NonNull public abstract TextSwitcher getLastNameView();
    @NonNull public abstract TextSwitcher getPositionView();
    @NonNull public abstract TextSwitcher getTeamLabelView();
    @NonNull public abstract TextSwitcher getStatusView();
    @NonNull public abstract View getContainerView();

    @NonNull
    public static Builder newBuilder() {
        return new AutoValue_PlayerViewHolder.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setFirstNameView(TextSwitcher val);
        public abstract Builder setLastNameView(TextSwitcher val);
        public abstract Builder setPositionView(TextSwitcher val);
        public abstract Builder setTeamLabelView(TextSwitcher val);
        public abstract Builder setStatusView(TextSwitcher val);
        public abstract Builder setContainerView(View val);

        public abstract PlayerViewHolder build();
    }
}
