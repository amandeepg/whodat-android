package ca.amandeep.playernumber.player;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.amandeep.playernumber.R;
import ca.amandeep.playernumber.core.Analytics;
import ca.amandeep.playernumber.core.BaseSubscriber;
import ca.amandeep.playernumber.models.Player;
import ca.amandeep.playernumber.models.Team;
import ca.amandeep.playernumber.utils.ColourUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.math.operators.OperatorMinMax;

public class PlayerPresenter {

    private static final int ALPHA_PLAYER_LABEL = (int) (255f * 0.9f);
    private static final int ALPHA_STATUS = (int) (255f * 0.75f);
    private static final int CROSSFADE_DURATION_MILLIS = 100;
    private static final int ALPHA_TEAM_LABEL = (int) (255f / 4f);

    @NonNull private final Context mContext;
    @NonNull private final Type mType;
    @NonNull private final PlayerViewHolder mViewHolder;
    @NonNull private final List<Player> mPlayers = new ArrayList<>();
    private final int mFabSize;

    private int mJerseyNumber;
    private boolean mLoading;
    private Animation mInAnim;
    private Animation mOutAnim;
    private ArgbEvaluator mArgbEvaluator;
    @ColorInt private int mPreviousBackgroundColor;

    public PlayerPresenter(@NonNull Context context, @NonNull Type type, @NonNull PlayerViewHolder viewHolder) {
        mContext = context;
        mType = type;
        mViewHolder = viewHolder;
        mFabSize = mContext.getResources().getDimensionPixelSize(R.dimen.fab_size);

        mInAnim = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
        mOutAnim = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out);
        mInAnim.setDuration(CROSSFADE_DURATION_MILLIS);
        mOutAnim.setDuration(CROSSFADE_DURATION_MILLIS);

        setupTextSwitcher(mViewHolder.getFirstNameView());
        setupTextSwitcher(mViewHolder.getStatusView());
        setupTextSwitcher(mViewHolder.getTeamLabelView());
        setupTextSwitcher(mViewHolder.getLastNameView());
        setupTextSwitcher(mViewHolder.getPositionView());

        mPreviousBackgroundColor = Color.BLACK;
        mViewHolder.getContainerView().setBackgroundColor(mPreviousBackgroundColor);

        mArgbEvaluator = new ArgbEvaluator();
    }

    private void setupTextSwitcher(@NonNull TextSwitcher textSwitcher) {
        textSwitcher.setInAnimation(mInAnim);
        textSwitcher.setOutAnimation(mOutAnim);
    }

    public void bindTeam(@NonNull Team team) {
        @ColorInt final int backgroundColor = Color.parseColor("#" + team.colour());
        @ColorInt final int textColor = ColourUtils.isBright(backgroundColor) ? Color.BLACK : Color.WHITE;
        @ColorInt final int foregroundColor = ColourUtils.modifyAlpha(textColor, ALPHA_PLAYER_LABEL);
        @ColorInt final int teamLabelColor = ColourUtils.modifyAlpha(textColor, ALPHA_TEAM_LABEL);

        setTextColor(mViewHolder.getFirstNameView(), foregroundColor);
        setTextColor(mViewHolder.getLastNameView(), foregroundColor);
        setTextColor(mViewHolder.getPositionView(), foregroundColor);
        setTextColor(mViewHolder.getStatusView(), ColourUtils.modifyAlpha(foregroundColor, ALPHA_STATUS));

        ObjectAnimator.ofObject(mViewHolder.getContainerView(), "backgroundColor",
                mArgbEvaluator, mPreviousBackgroundColor, backgroundColor)
                .setDuration(CROSSFADE_DURATION_MILLIS)
                .start();
        mPreviousBackgroundColor = backgroundColor;

        mViewHolder.getTeamLabelView().setText(team.abbreviation());
        setTextColor(mViewHolder.getTeamLabelView(), teamLabelColor);

        if (mType == Type.HOME) {
            mViewHolder.getContainerView().setPadding(0, mFabSize / 2, 0, 0);
        } else {
            mViewHolder.getContainerView().setPadding(0, 0, 0, mFabSize / 2);
        }

        bindPlayerNum(-1);
        mViewHolder.getStatusView().setText(mContext.getString(R.string.loading));

        mLoading = true;
        new PlayersRepository(mContext)
                .getPlayers(team)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<List<Player>>() {
                    @Override
                    public void onNext(List<Player> players) {
                        PlayerPresenter.this.bindPlayers(players);
                    }
                });

    }

    private void setTextColor(@NonNull TextSwitcher textSwitcher, @ColorInt int color) {
        setTextColor((TextView) textSwitcher.getChildAt(0), color);
        setTextColor((TextView) textSwitcher.getChildAt(1), color);
    }

    private void setTextColor(@Nullable TextView child, @ColorInt int color) {
        if (child != null) {
            child.setTextColor(color);
        }
    }

    public void bindPlayerNum(int jerseyNumber) {
        mJerseyNumber = jerseyNumber;
        if (!mLoading) {
            bindPlayerNum();
        }
    }

    private void bindPlayerNum() {
        final Player player = getPlayerWithJerseyNumber(mJerseyNumber);

        Analytics.logEvent(mContext, "Player queried");

        if (player != null) {
            Analytics.logEvent(mContext, "Player found");

            mViewHolder.getFirstNameView().setText(player.firstName());
            mViewHolder.getLastNameView().setText(player.lastName());
            mViewHolder.getPositionView().setText(player.position());
            mViewHolder.getStatusView().setText(null);
        } else {
            mViewHolder.getFirstNameView().setText(null);
            mViewHolder.getLastNameView().setText(null);
            mViewHolder.getPositionView().setText(null);
            mViewHolder.getStatusView().setText(mContext.getString(R.string.no_player));
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
        mLoading = false;
        mViewHolder.getStatusView().setText(null);
        bindPlayerNum();
    }

    public enum Type {
        AWAY, HOME
    }
}
