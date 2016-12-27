package ca.amandeep.playernumber.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import ca.amandeep.playernumber.R;

public class MaskImageView extends SquareImageView {

    @NonNull private final Paint mMaskPaint = new Paint();
    @NonNull private final Bitmap mMaskBitmap;

    public MaskImageView(@NonNull Context context) {
        this(context, null);
    }

    public MaskImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaskImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MaskImageView, 0, 0);

        @DrawableRes final int maskDrawableResId;
        try {
            maskDrawableResId = a.getResourceId(R.styleable.MaskImageView_mask_src, 0);
        } finally {
            a.recycle();
        }

        mMaskBitmap = ((BitmapDrawable) ContextCompat.getDrawable(getContext(), maskDrawableResId)).getBitmap();

        mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mMaskPaint.setAntiAlias(true);
        mMaskPaint.setFilterBitmap(true);

        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.concat(getImageMatrix());
        canvas.drawBitmap(mMaskBitmap, 0, 0, mMaskPaint);
        canvas.restore();
    }
}
