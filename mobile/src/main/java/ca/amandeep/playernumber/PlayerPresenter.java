package ca.amandeep.playernumber;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ca.amandeep.playernumber.models.Player;
import ca.amandeep.playernumber.models.Team;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.math.operators.OperatorMinMax;

public class PlayerPresenter {

    private static final double TEAM_LABEL_LIGHTEN_AMOUNT = 0.9;
    private static final double TEAM_LABEL_DARKEN_AMOUNT = 0.2;
    private static final int ALPHA_PLAYER_LABEL = (int) (255 * 0.9);
    @NonNull private final Context mContext;
    @NonNull private final Type mType;
    @NonNull private final PlayerViewHolder mViewHolder;
    @NonNull private final List<Player> mPlayers = new ArrayList<>();
    private final int mFabSize;

    private int mJerseyNumber;

    public PlayerPresenter(@NonNull Context context, @NonNull Type type, @NonNull PlayerViewHolder viewHolder) {
        mContext = context;
        mType = type;
        mViewHolder = viewHolder;
        mFabSize = mContext.getResources().getDimensionPixelSize(R.dimen.fab_size);
    }

    public void bindTeam(@NonNull Team team) {
        final int foregroundColor;
        final int teamLabelColor;
        final int backgroundColor = Color.parseColor("#" + team.colour());
        if (ColourUtils.isBright(backgroundColor)) {
            foregroundColor = ColourUtils.modifyAlpha(Color.BLACK, ALPHA_PLAYER_LABEL);
            teamLabelColor = ColourUtils.lighten(backgroundColor, TEAM_LABEL_LIGHTEN_AMOUNT);
        } else {
            foregroundColor = ColourUtils.modifyAlpha(Color.WHITE, ALPHA_PLAYER_LABEL);
            if (ColourUtils.isBlackOrAlmostBlack(backgroundColor)) {
                teamLabelColor = Color.DKGRAY;
            } else {
                teamLabelColor = ColourUtils.darken(backgroundColor, TEAM_LABEL_DARKEN_AMOUNT);
            }
        }

        mViewHolder.getFirstNameView().setTextColor(foregroundColor);
        mViewHolder.getLastNameView().setTextColor(foregroundColor);
        mViewHolder.getBirthPlaceView().setTextColor(foregroundColor);

        mViewHolder.getContainerView().setBackgroundColor(backgroundColor);

        mViewHolder.getTeamLabelView().setText(team.abbreviation());
        mViewHolder.getTeamLabelView().setTextColor(teamLabelColor);

        if (mType == Type.HOME) {
            mViewHolder.getContainerView().setPadding(0, mFabSize / 2, 0, 0);
        } else {
            mViewHolder.getContainerView().setPadding(0, 0, 0, mFabSize / 2);
        }

        new PlayersRepository(mContext)
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

        Analytics.logEvent(mContext, "Player queried");

        if (player != null) {
            Analytics.logEvent(mContext, "Player found");

            mViewHolder.getFirstNameView().setText(player.firstName());
            mViewHolder.getLastNameView().setText(player.lastName());
            if (player.birthCity() != null && player.birthCountry() != null) {
                mViewHolder.getBirthPlaceView().setText(player.birthCity() + ", " + player.birthCountry());
            } else if (player.birthCity() != null) {
                mViewHolder.getBirthPlaceView().setText(player.birthCity());
            } else if (player.birthCountry() != null) {
                mViewHolder.getBirthPlaceView().setText(player.birthCountry());
            } else {
                mViewHolder.getBirthPlaceView().setText(null);
            }
        } else {
            mViewHolder.getFirstNameView().setText(null);
            mViewHolder.getLastNameView().setText(null);
            mViewHolder.getBirthPlaceView().setText(null);
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

    private void bindPlayers(@Nullable List<Player> players) {
        mPlayers.clear();
        if (players != null) {
            mPlayers.addAll(players);
        }
        bindPlayerNum();
    }

    public enum Type {
        AWAY, HOME
    }
}
