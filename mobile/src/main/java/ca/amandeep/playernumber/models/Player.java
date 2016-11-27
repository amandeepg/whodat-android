package ca.amandeep.playernumber.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.sqldelight.ColumnAdapter;
import com.squareup.sqldelight.RowMapper;

import java.util.Calendar;

@AutoValue
public abstract class Player implements PlayerModel {

    private static final ColumnAdapter<Calendar, Long> CALENDAR_ADAPTER = new ColumnAdapter<Calendar, Long>() {
        @NonNull
        @Override
        public Calendar decode(Long databaseValue) {
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(databaseValue);
            return calendar;
        }

        @Override
        public Long encode(@NonNull Calendar value) {
            return value.getTimeInMillis();
        }
    };

    public static final Factory<Player> FACTORY = new Factory<>(AutoValue_Player::new, CALENDAR_ADAPTER);

    public static final RowMapper<SelectAll> SELECT_ALL_MAPPER = FACTORY.selectAllMapper(AutoValue_Player_SelectAll::new, Team.FACTORY);

    @AutoValue
    public static abstract class SelectAll implements SelectAllModel<Player, Team> {}

    public static final RowMapper<ForTeam> FOR_TEAM_MAPPER = FACTORY.forTeamMapper(AutoValue_Player_ForTeam::new, Team.FACTORY);

    @AutoValue
    public static abstract class ForTeam implements ForTeamModel<Player, Team> {}

    public static final RowMapper<ForTwoTeams> FOR_TWO_TEAMS_MAPPER = FACTORY.forTwoTeamsMapper(AutoValue_Player_ForTwoTeams::new, Team.FACTORY);

    @AutoValue
    public static abstract class ForTwoTeams implements ForTwoTeamsModel<Player, Team> {}

    public static JsonAdapter<Player> jsonAdapter(Moshi moshi) {
        return new AutoValue_Player.MoshiJsonAdapter(moshi);
    }
}
