package ca.amandeep.playernumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import ca.amandeep.playernumber.models.Game;
import rx.android.schedulers.AndroidSchedulers;

public class MainPresenter implements GamesAdapter.GameSelectListener, GamesPresenter.ViewDelegate {

    @NonNull private final Context mContext;
    @NonNull private final PlayerPresenter mAwayPlayerPresenter;
    @NonNull private final PlayerPresenter mHomePlayerPresenter;
    @NonNull private final EditText mNumEdit;
    @NonNull private final ProgressDialog mProgressDialog;
    @NonNull private final GamesPresenter mGamesPresenter;

    public MainPresenter(@NonNull AppCompatActivity activity, @NonNull Context context) {
        mContext = context;
        mHomePlayerPresenter = new PlayerPresenter(PlayerPresenter.Type.HOME);
        mAwayPlayerPresenter = new PlayerPresenter(PlayerPresenter.Type.AWAY);

        mHomePlayerPresenter.bindView(activity.findViewById(R.id.play_view_home));
        mAwayPlayerPresenter.bindView(activity.findViewById(R.id.play_view_away));

        mNumEdit = (EditText) activity.findViewById(R.id.number_edit);
        mNumEdit.addTextChangedListener(new AfterTextWatcherHolder(this::onNumberEditChanged));
        mNumEdit.setVisibility(View.INVISIBLE);

        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(mContext.getString(R.string.loading_todays_games));

        mGamesPresenter = new GamesPresenter(activity, mContext, this);
    }

    public void startFetchData() {
        mProgressDialog.show();

        new TeamsRepository(mContext)
                .getTeams()
                .flatMap(ignore -> new GamesRepository().getGames())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mGamesPresenter::showGamesDialog);
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
    }

    public void onBackPressed() {
        startFetchData();
    }

    @Override
    public void hideProgressSpinner() {
        mProgressDialog.hide();
    }
}