package ca.amandeep.playernumber.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.sqldelight.RowMapper;

@AutoValue
public abstract class Team implements TeamModel {

    public static final Factory<Team> FACTORY = new Factory<>(AutoValue_Team::new);

    public static final RowMapper<Team> SELECT_ALL_MAPPER = FACTORY.selectAllMapper();

    public static JsonAdapter<Team> jsonAdapter(Moshi moshi) {
        return new AutoValue_Team.MoshiJsonAdapter(moshi);
    }
}
