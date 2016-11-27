package ca.amandeep.playernumber.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class PlayerTeam {
    public abstract Player player();
    public abstract Team team();

    public static JsonAdapter<PlayerTeam> jsonAdapter(Moshi moshi) {
        return new AutoValue_PlayerTeam.MoshiJsonAdapter(moshi);
    }
}