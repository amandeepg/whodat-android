package ca.amandeep.playernumber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance(
                getString(R.string.intro1_title),
                getString(R.string.intro1_desc),
                R.drawable.dialog,
                ContextCompat.getColor(this, R.color.primary_dark)));
        addSlide(AppIntroFragment.newInstance(
                getString(R.string.intro2_title),
                getString(R.string.intro2_desc),
                R.drawable.number,
                ContextCompat.getColor(this, R.color.accent)));
        addSlide(AppIntroFragment.newInstance(
                getString(R.string.intro3_title),
                getString(R.string.intro3_desc),
                R.drawable.reimer,
                ContextCompat.getColor(this, R.color.primary_dark)));

        // Hide Skip/Done button.
        showSkipButton(false);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}
