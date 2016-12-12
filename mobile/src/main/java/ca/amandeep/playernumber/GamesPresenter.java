package ca.amandeep.playernumber;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

import ca.amandeep.playernumber.models.Game;

public class GamesPresenter {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final ViewDelegate mViewDelegate;
    private final AlertDialog.Builder mDialogBuilder;

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
        recyclerView.setAdapter(new GamesAdapter(games, this::onGameSelect));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        mViewDelegate.hideProgressSpinner();
        mDialog = mDialogBuilder
                .setView(view)
                .show();
    }

    private void onGameSelect(Game game) {
        mDialog.cancel();
        mDialog = null;

        Analytics.logEvent(mContext, "Game selected");

        mViewDelegate.onGameSelect(game);
    }

    public interface ViewDelegate {
        void hideProgressSpinner();
        void onGameSelect(Game game);
    }
}
