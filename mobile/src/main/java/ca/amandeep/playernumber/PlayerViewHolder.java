package ca.amandeep.playernumber;

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
    abstract static class Builder {
        public abstract Builder setFirstNameView(TextSwitcher v);
        public abstract Builder setLastNameView(TextSwitcher v);
        public abstract Builder setPositionView(TextSwitcher v);
        public abstract Builder setTeamLabelView(TextSwitcher v);
        public abstract Builder setStatusView(TextSwitcher v);
        public abstract Builder setContainerView(View v);

        abstract PlayerViewHolder build();
    }
}
