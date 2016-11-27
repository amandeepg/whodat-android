package ca.amandeep.playernumber;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.amandeep.playernumber.models.Game;
import ca.amandeep.playernumber.models.Team;
import rx.Observable;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    private static final int HEADER = 1;
    private static final int GAME = 2;

    private final GameSelectListener mListener;
    private final List<GameOrHeader> gameOrHeaders;

    public GamesAdapter(List<Game> games, GameSelectListener listener) {
        games = Observable.from(games)
                .toSortedList((game1, game2) -> game1.league().compareTo(game2.league()))
                .toBlocking()
                .first();

        gameOrHeaders = new ArrayList<>();
        Game lastGame = null;
        for (final Game game : games) {
            if (lastGame == null || !lastGame.league().equals(game.league())) {
                gameOrHeaders.add(new GameOrHeader(game.league(), null));
            }
            gameOrHeaders.add(new GameOrHeader(null, game));
            lastGame = game;
        }

        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.headerView.setVisibility(View.GONE);
        holder.atView.setVisibility(View.GONE);
        holder.homeTeamTextView.setVisibility(View.GONE);
        holder.awayTeamTextView.setVisibility(View.GONE);

        if (getItemViewType(position) == HEADER) {
            final String league = gameOrHeaders.get(position).league;
            holder.headerView.setText(league.toUpperCase());

            holder.headerView.setVisibility(View.VISIBLE);
        } else {
            final Game game = gameOrHeaders.get(position).game;
            final Team awayTeam = game.awayTeam();
            final Team homeTeam = game.homeTeam();

            holder.awayTeamTextView.setText(awayTeam.city() + " " + awayTeam.name());
            holder.homeTeamTextView.setText(homeTeam.city() + " " + homeTeam.name());

            holder.itemView.setOnClickListener(view -> mListener.onGameSelect(game));

            holder.atView.setVisibility(View.VISIBLE);
            holder.homeTeamTextView.setVisibility(View.VISIBLE);
            holder.awayTeamTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return gameOrHeaders.size();
    }

    @Override
    public int getItemViewType(int position) {
        return gameOrHeaders.get(position).league != null ? HEADER : GAME;
    }

    public interface GameSelectListener {
        void onGameSelect(Game game);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView awayTeamTextView;
        private final TextView homeTeamTextView;
        private final View atView;
        private final TextView headerView;

        private ViewHolder(View itemView) {
            super(itemView);
            awayTeamTextView = (TextView) itemView.findViewById(R.id.away_team);
            homeTeamTextView = (TextView) itemView.findViewById(R.id.home_team);
            atView = itemView.findViewById(R.id.at);
            headerView = (TextView) itemView.findViewById(R.id.header);
        }
    }

    private static class GameOrHeader {
        private final String league;
        private final Game game;

        private GameOrHeader(String league, Game game) {
            this.league = league;
            this.game = game;
        }
    }
}
