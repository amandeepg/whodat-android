package ca.amandeep.playernumber.intro;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.paolorotolo.appintro.ISlideBackgroundColorHolder;

import ca.amandeep.playernumber.R;

public class SlideFragment extends Fragment implements ISlideBackgroundColorHolder {

    private static final String ARG_LAYOUT_RES_ID = "mLayoutResId";
    private static final String ARG_COLOR_RES_ID = "colorResId";
    @LayoutRes private int mLayoutResId;
    @Nullable private View mContainerView;
    @ColorInt private int mBgColorInt;

    @NonNull
    public static SlideFragment newInstance(@LayoutRes int layoutResId, @ColorRes int colorResId) {
        SlideFragment sampleSlide = new SlideFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        args.putInt(ARG_COLOR_RES_ID, colorResId);
        sampleSlide.setArguments(args);

        return sampleSlide;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            mLayoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }
        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            final int colorResId = getArguments().getInt(ARG_COLOR_RES_ID);
            mBgColorInt = ContextCompat.getColor(getContext(), colorResId);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(mLayoutResId, container, false);
        mContainerView = view.findViewById(R.id.bg_container);
        return view;
    }

    @Override
    public int getDefaultBackgroundColor() {
        return mBgColorInt;
    }

    @Override
    public void setBackgroundColor(@ColorInt int backgroundColor) {
        if (mContainerView != null) {
            mContainerView.setBackgroundColor(backgroundColor);
        }
    }
}
