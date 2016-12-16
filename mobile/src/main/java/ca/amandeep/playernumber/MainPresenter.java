package ca.amandeep.playernumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.List;

import ca.amandeep.playernumber.models.Game;
import rx.android.schedulers.AndroidSchedulers;

public class MainPresenter implements GamesAdapter.GameSelectListener, GamesPresenter.ViewDelegate {

    private static final int DELAY_TO_SHOW_KEYBOARD = 250;
    private static final String KEY_SHOW_TOOLTIP = "SHOW_TOOLTIP";

    @NonNull private final AppCompatActivity mActivity;
    @NonNull private final Context mContext;
    @NonNull private final PlayerPresenter mAwayPlayerPresenter;
    @NonNull private final PlayerPresenter mHomePlayerPresenter;
    @NonNull private final EditText mNumEdit;
    @NonNull private final ProgressDialog mProgressDialog;
    @NonNull private final GamesPresenter mGamesPresenter;
    @NonNull private Resources mResources;
    @NonNull private SharedPreferences mPrefs;
    @NonNull private Handler mHandler;

    public MainPresenter(@NonNull AppCompatActivity activity, @NonNull Context context,
            @NonNull LayoutInflater layoutInflater, @NonNull MainViewHolder viewHolder) {
        mActivity = activity;
        mContext = context;
        mResources = mContext.getResources();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mHandler = new Handler();

        mHomePlayerPresenter =
                new PlayerPresenter(mContext, PlayerPresenter.Type.HOME, viewHolder.getHomePlayerViewHolder());
        mAwayPlayerPresenter =
                new PlayerPresenter(mContext, PlayerPresenter.Type.AWAY, viewHolder.getAwayPlayerViewHolder());

        mNumEdit = viewHolder.getJerseyNumberEditText();
        mNumEdit.addTextChangedListener(new AfterTextWatcherHolder(this::onNumberEditChanged));
        mNumEdit.setVisibility(View.INVISIBLE);

        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(mContext.getString(R.string.loading_todays_games));

        mGamesPresenter = new GamesPresenter(activity, mContext, layoutInflater, this);
    }

    public void startFetchData() {
        mProgressDialog.show();

        new TeamsRepository(mContext)
                .getTeams()
                .flatMap(ignore -> new GamesRepository().getGames())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<List<Game>>() {
                    @Override
                    public void onNext(List<Game> games) {
                        mGamesPresenter.showGamesDialog(games);
                    }
                });
    }

    private void onNumberEditChanged(@NonNull Editable editable) {
        int num = StringUtils.toInt(editable.toString());

        mHomePlayerPresenter.bindPlayerNum(num);
        mAwayPlayerPresenter.bindPlayerNum(num);
    }

    @Override
    public void onGameSelect(@NonNull Game game) {
        mNumEdit.setVisibility(View.VISIBLE);

        mAwayPlayerPresenter.bindTeam(game.awayTeam());
        mHomePlayerPresenter.bindTeam(game.homeTeam());

        onNumberEditChanged(mNumEdit.getText());

        showTapTargetDemo();
    }

    private void showTapTargetDemo() {
        if (!mPrefs.getBoolean(KEY_SHOW_TOOLTIP, true)) {
            return;
        }
        mPrefs.edit().putBoolean(KEY_SHOW_TOOLTIP, false).apply();

        TapTargetView.showFor(mActivity,
                TapTarget.forView(mNumEdit,
                        mContext.getString(R.string.tooltip_primary_text),
                        mContext.getString(R.string.tooltip_secondary_text))
                        .outerCircleColor(R.color.primary_dark)
                        .dimColorInt(Color.BLACK)
                        .targetCircleColor(android.R.color.transparent)
                        .titleTextDimen(R.dimen.tooltip_title_size)
                        .textColor(R.color.primary_text_light)
                        .descriptionTextDimen(R.dimen.tooltip_title_size)
                        .descriptionTextColor(R.color.secondary_text_light)
                        .transparentTarget(true)
                        .cancelable(true)
                        .targetRadius((int) (mResources.getDimensionPixelSize(R.dimen.fab_size) / mResources.getDisplayMetrics().density - 30)),
                new TapTargetView.Listener() {
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);
                        mNumEdit.requestFocus();
                        mHandler.postDelayed(() -> {
                            mNumEdit.requestFocus();
                            ViewUtils.showKeyboard(mNumEdit);
                        }, DELAY_TO_SHOW_KEYBOARD);
                    }
                }
        );
    }

    @Override
    public void onDismiss() {
        mActivity.finish();
    }

    public void onBackPressed() {
        startFetchData();
    }

    @Override
    public void hideProgressSpinner() {
        mProgressDialog.hide();
    }
}
