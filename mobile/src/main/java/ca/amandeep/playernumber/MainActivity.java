package ca.amandeep.playernumber;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Nullable private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenter(this, getApplicationContext(), LayoutInflater.from(this),
                MainViewHolder.newBuilder()
                        .setJerseyNumberEditText((EditText) findViewById(R.id.number_edit))
                        .setHomePlayerViewHolder(createPlayerViewHolderFrom(findViewById(R.id.play_view_home)))
                        .setAwayPlayerViewHolder(createPlayerViewHolderFrom(findViewById(R.id.play_view_away)))
                        .build());
        mMainPresenter.startFetchData();
    }

    @NonNull
    private PlayerViewHolder createPlayerViewHolderFrom(@NonNull View view) {
        return PlayerViewHolder.newBuilder()
                .setFirstNameView((TextView) view.findViewById(R.id.first_name))
                .setLastNameView((TextView) view.findViewById(R.id.last_name))
                .setBirthPlaceView((TextView) view.findViewById(R.id.birth_place))
                .setTeamLabelView((TextView) view.findViewById(R.id.team_label))
                .setContainerView(view)
                .build();
    }

    @Override
    public void onBackPressed() {
        if (mMainPresenter != null) {
            mMainPresenter.onBackPressed();
        }
    }
}
