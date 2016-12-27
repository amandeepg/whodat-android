package ca.amandeep.playernumber.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;

import ca.amandeep.playernumber.Analytics;
import ca.amandeep.playernumber.R;

public class IntroActivity extends AppIntro2 {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Analytics.logEvent(this, "start_tutorial");

        setColorTransitionsEnabled(true);

        addSlide(SlideFragment.newInstance(R.layout.intro1, R.color.intro1_bg));
        addSlide(SlideFragment.newInstance(R.layout.intro2, R.color.intro2_bg));
        addSlide(SlideFragment.newInstance(R.layout.intro3, R.color.intro3_bg));
        addSlide(SlideFragment.newInstance(R.layout.intro4, R.color.intro4_bg));
        addSlide(SlideFragment.newInstance(R.layout.intro5, R.color.intro1_bg));

        // Hide Skip/Done button.
        showSkipButton(false);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Analytics.logEvent(this, "finish_tutorial");
        finish();
    }
}
