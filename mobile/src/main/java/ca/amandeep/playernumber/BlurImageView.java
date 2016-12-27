package ca.amandeep.playernumber;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import jp.wasabeef.blurry.Blurry;

public class BlurImageView extends AppCompatImageView {

    public BlurImageView(@NonNull Context context) {
        super(context);
    }

    public BlurImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BlurImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        Blurry.with(getContext())
                .radius(15)
                .sampling(3)
                .async()
                .color(Color.argb(25, 0, 0, 0))
                .from(bitmap)
                .into(this);
    }
}
