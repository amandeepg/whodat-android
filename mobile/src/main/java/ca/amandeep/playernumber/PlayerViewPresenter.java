package ca.amandeep.playernumber;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import ca.amandeep.playernumber.models.Player;
import ca.amandeep.playernumber.models.Team;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.math.operators.OperatorMinMax;


public class PlayerViewPresenter {

    @NonNull private final Type mType;
    @BindView(R.id.first_name) TextView firstName;
    @BindView(R.id.last_name) TextView lastName;
    @BindView(R.id.birth_place) TextView birthPlace;
    @BindView(R.id.team_label) TextView teamLabel;
    @BindView(R.id.info_container) View infoContainer;
    @BindDimen(R.dimen.fab_size) int fabSize;
    private View container;
    private List<Player> mPlayers = new ArrayList<>();
    private int mJerseyNumber;

    public PlayerViewPresenter(@NonNull Type type) {
        mType = type;
    }

    public void bindView(@NonNull View view) {
        container = view;
        ButterKnife.bind(this, view);
    }

    public void bindTeam(@NonNull Team team) {
        final int foregroundColor;
        final int teamLabelColor;
        final int backgroundColor = Color.parseColor("#" + team.colour());
        if (ColourUtils.isBright(backgroundColor)) {
            foregroundColor = ColourUtils.modifyAlpha(Color.BLACK, (int) (255 * 0.9));
            teamLabelColor = ColourUtils.lighten(backgroundColor, 0.9);
        } else {
            foregroundColor = ColourUtils.modifyAlpha(Color.WHITE, (int) (255 * 0.9));
            teamLabelColor = ColourUtils.darken(backgroundColor, 0.2);
        }

        firstName.setTextColor(foregroundColor);
        lastName.setTextColor(foregroundColor);
        birthPlace.setTextColor(foregroundColor);

        container.setBackgroundColor(backgroundColor);

        teamLabel.setText(team.abbreviation());
        teamLabel.setTextColor(teamLabelColor);

        if (mType == Type.HOME) {
            infoContainer.setPadding(0, fabSize / 2, 0, 0);
        } else {
            infoContainer.setPadding(0, 0, 0, fabSize / 2);
        }

        new PlayersRepository(container.getContext())
                .getPlayers(team)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bindPlayers);

        bindPlayerNum(-1);
    }

    public void bindPlayerNum(int jerseyNumber) {
        mJerseyNumber = jerseyNumber;
        bindPlayerNum();
    }

    private void bindPlayerNum() {
        final Player player = getPlayerWithJerseyNumber(mJerseyNumber);

        if (player != null) {
            firstName.setText(player.firstName());
            lastName.setText(player.lastName());
            if (player.birthCity() != null && player.birthCountry() != null) {
                birthPlace.setText(player.birthCity() + ", " + player.birthCountry());
            } else if (player.birthCity() != null) {
                birthPlace.setText(player.birthCity());
            } else if (player.birthCountry() != null) {
                birthPlace.setText(player.birthCountry());
            } else {
                birthPlace.setText(null);
            }
        } else {
            firstName.setText(null);
            lastName.setText(null);
            birthPlace.setText(null);
        }
    }

    @Nullable
    private Player getPlayerWithJerseyNumber(int num) {
        final List<Player> players = OperatorMinMax.maxBy(
                Observable
                        .from(mPlayers)
                        .filter(player -> player.jerseyNumber() == num),
                Player::gamesPlayed)
                .toBlocking()
                .first();
        if (players.size() > 0) {
            return players.get(0);
        } else {
            return null;
        }
    }

    private void bindPlayers(List<Player> players) {
        mPlayers = players;
        bindPlayerNum();
    }

    public enum Type {
        AWAY, HOME
    }
}
