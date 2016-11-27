package ca.amandeep.playernumber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Nullable private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenter(this, getApplicationContext());
        mMainPresenter.startFetchData();
    }

    @Override
    public void onBackPressed() {
        if (mMainPresenter != null) {
            mMainPresenter.onBackPressed();
        }
    }
}
