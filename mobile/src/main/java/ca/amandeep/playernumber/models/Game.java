package ca.amandeep.playernumber.models;

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
}
