package ca.amandeep.playernumber.games;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ca.amandeep.playernumber.R;
import ca.amandeep.playernumber.core.Analytics;
import ca.amandeep.playernumber.models.Game;
import ca.amandeep.playernumber.player.PlayersRepository;

public class GamesPresenter {

    private static final String PREF_OVERRIDE_GAMES = "override_games";

    @NonNull private final LayoutInflater mLayoutInflater;
    @NonNull private final Context mContext;
    @NonNull private final ViewDelegate mViewDelegate;
    @NonNull private final AlertDialog.Builder mDialogBuilder;

    private AlertDialog mDialog;

    public GamesPresenter(@NonNull AppCompatActivity activity, @NonNull Context context,
            @NonNull LayoutInflater layoutInflater, @NonNull ViewDelegate viewDelegate) {
        mLayoutInflater = layoutInflater;
        mContext = context;
        mViewDelegate = viewDelegate;

        mDialogBuilder = new AlertDialog.Builder(activity)
                .setCancelable(false);
    }

    public void showGamesDialog(@NonNull List<Game> games) {
        @SuppressLint("InflateParams")
        final View view = mLayoutInflater.inflate(R.layout.dialog_games, null);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(new GamesAdapter(getOverrideGamesIfSet(games), this::onGameSelect));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        mViewDelegate.hideProgressSpinner();
        mDialog = mDialogBuilder
                .setView(view)
                .setOnKeyListener((dialogInterface, keyCode, keyEvent) -> {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        mViewDelegate.onDismiss();
                        return true;
                    }
                    return false;
                })
                .show();
    }

    @NonNull
    private List<Game> getOverrideGamesIfSet(@NonNull List<Game> nonOverrideGames) {
        final String overrideGameIds = PreferenceManager.getDefaultSharedPreferences(mContext).getString(PREF_OVERRIDE_GAMES, "");

        if (!TextUtils.isEmpty(overrideGameIds)) {
            final String[] gamesStr = overrideGameIds.split("-");
            final List<Game> games = new ArrayList<>(gamesStr.length);
            for (final String gameStr : gamesStr) {
                final String[] splitGameStr = gameStr.split(",");
                final String awayTeam = splitGameStr[0];
                final String homeTeam = splitGameStr[1];
                final String league = splitGameStr[2];
                games.add(Game.newBuilder()
                        .setAwayTeam(PlayersRepository.findTeam(mContext, awayTeam))
                        .setHomeTeam(PlayersRepository.findTeam(mContext, homeTeam))
                        .setLeague(league)
                        .setDate(Calendar.getInstance())
                        .setLocation("here")
                        .setTime("7pm")
                        .build());
            }
            return games;
        } else {
            return nonOverrideGames;
        }
    }

    private void onGameSelect(Game game) {
        mDialog.cancel();
        mDialog = null;

        Analytics.logEvent(mContext, "Game selected");

        mViewDelegate.onGameSelect(game);
    }

    public interface ViewDelegate {
        void hideProgressSpinner();
        void onGameSelect(@NonNull Game game);
        void onDismiss();
    }
}
