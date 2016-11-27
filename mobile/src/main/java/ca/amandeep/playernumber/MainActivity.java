package ca.amandeep.playernumber;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import ca.amandeep.playernumber.models.Game;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements GamesAdapter.GameSelectListener {

    private AlertDialog mDialog;
    private PlayerViewPresenter mAwayPlayerViewPresenter;
    private PlayerViewPresenter mHomePlayerViewPresenter;
    private EditText mNumEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPlayerViews();
        setupNumberEdit();
        startFetchData();
    }

    private void startFetchData() {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "", getString(R.string.loading_todays_games), true);

        new TeamsRepository(this)
                .getTeams()
                .flatMap(ignore -> new GamesRepository().getGames())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(games -> {
                    showGamesDialog(progressDialog, games);
                });
    }

    private void showGamesDialog(ProgressDialog progressDialog, List<Game> games) {
        @SuppressLint("InflateParams")
        final View view = getLayoutInflater().inflate(R.layout.dialog_games, null);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(new GamesAdapter(games, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        progressDialog.hide();
        mDialog = new AlertDialog.Builder(MainActivity.this)
                .setCancelable(false)
                .setView(view)
                .show();
    }

    private void setupPlayerViews() {
        mHomePlayerViewPresenter = new PlayerViewPresenter(PlayerViewPresenter.Type.HOME);
        mAwayPlayerViewPresenter = new PlayerViewPresenter(PlayerViewPresenter.Type.AWAY);

        mHomePlayerViewPresenter.bindView(findViewById(R.id.play_view_home));
        mAwayPlayerViewPresenter.bindView(findViewById(R.id.play_view_away));
    }

    private void setupNumberEdit() {
        mNumEdit = (EditText) findViewById(R.id.number_edit);
        mNumEdit.addTextChangedListener(new AfterTextWatcherHolder(this::onNumberEditChanged));
        mNumEdit.setVisibility(View.INVISIBLE);
    }

    private void onNumberEditChanged(@NonNull Editable editable) {
        int num = StringUtils.toInt(editable.toString());

        mHomePlayerViewPresenter.bindPlayerNum(num);
        mAwayPlayerViewPresenter.bindPlayerNum(num);
    }

    @Override
    public void onGameSelect(@NonNull Game game) {
        mDialog.cancel();
        mDialog = null;
        mNumEdit.setVisibility(View.VISIBLE);

        mAwayPlayerViewPresenter.bindTeam(game.awayTeam());
        mHomePlayerViewPresenter.bindTeam(game.homeTeam());

        onNumberEditChanged(mNumEdit.getText());
    }

    @Override
    public void onBackPressed() {
        if (mDialog != null) {
            super.onBackPressed();
        } else {
            startFetchData();
        }
    }
}
