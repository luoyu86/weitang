package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap sampleTime = this.mAppCompatProgressBarHelper.getSampleTime();
        if (sampleTime != null) {
            setMeasuredDimension(View.resolveSizeAndState(sampleTime.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = appCompatProgressBarHelper;
        appCompatProgressBarHelper.loadFromAttributes(attributeSet, i2);
    }
}
