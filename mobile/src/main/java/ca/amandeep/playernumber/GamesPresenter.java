package ca.amandeep.playernumber;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
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

    private AlertDialog mDialog;
    private AlertDialog.Builder mDialogBuilder;

    public GamesPresenter(AppCompatActivity activity, Context context, ViewDelegate viewDelegate) {
        mLayoutInflater = LayoutInflater.from(activity);
        mContext = context;
        mViewDelegate = viewDelegate;

        mDialogBuilder = new AlertDialog.Builder(activity)
                .setCancelable(false);
    }

    public void showGamesDialog(List<Game> games) {
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
        mViewDelegate.onGameSelect(game);
    }

    public interface ViewDelegate {
        void hideProgressSpinner();
        void onGameSelect(Game game);
    }
}
