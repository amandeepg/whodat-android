package ca.amandeep.playernumber.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Calendar;

@AutoValue
public abstract class Game {
    public abstract Team homeTeam();
    public abstract Team awayTeam();
    public abstract Calendar date();
    public abstract String time();
    public abstract String location();
    public abstract String league();

    public static JsonAdapter<Game> jsonAdapter(Moshi moshi) {
        return new AutoValue_Game.MoshiJsonAdapter(moshi);
    }

    @NonNull
    public static Builder newBuilder() {
        return new AutoValue_Game.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setHomeTeam(Team val);
        public abstract Builder setAwayTeam(Team val);
        public abstract Builder setDate(Calendar val);
        public abstract Builder setTime(String val);
        public abstract Builder setLocation(String val);
        public abstract Builder setLeague(String val);

        public abstract Game build();
    }
}
