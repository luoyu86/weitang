package com.chinavisionary.microtang.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import c.e.a.d.q;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeImageView extends CoreRoundedImageView {
    public int A;
    public int B;
    public Paint C;
    public Paint D;
    public boolean E;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public BadgeImageView(Context context) {
        super(context);
        this.E = false;
        o(context, null);
    }

    public final void n(Canvas canvas) {
        int i2 = this.v;
        canvas.drawCircle(i2 - r1, this.x, this.y, this.C);
        int i3 = this.A;
        if (i3 > 0) {
            if (i3 > 99) {
                this.D.setTextSize(18.0f);
                int i4 = this.v;
                int i5 = this.y;
                canvas.drawText("99+", i4 - i5, i5 + 6, this.D);
            } else {
                this.D.setTextSize(24.0f);
                String str = this.A + "";
                int i6 = this.v;
                int i7 = this.y;
                canvas.drawText(str, i6 - i7, i7 + 8, this.D);
            }
        }
        q.d(getClass().getSimpleName(), "drawRightBadge isShowBadge = " + this.E);
    }

    public final void o(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_7);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_4);
        int color = getResources().getColor(R.color.image_color_red);
        this.y = dimensionPixelOffset;
        this.x = dimensionPixelOffset;
        this.z = dimensionPixelSize;
        this.B = color;
        Paint paint = new Paint(1);
        this.C = paint;
        paint.setAntiAlias(true);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setColor(color);
        int color2 = getResources().getColor(R.color.color_white);
        Paint paint2 = new Paint(1);
        this.D = paint2;
        paint2.setTextAlign(Paint.Align.CENTER);
        this.D.setTextSize(24.0f);
        this.D.setTypeface(Typeface.DEFAULT_BOLD);
        this.D.setColor(color2);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.E) {
            n(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.v = i2;
        this.w = i3;
    }

    public void setupShowBadge(boolean z, Integer num) {
        if (num != null) {
            this.E = num.intValue() > 0;
            this.A = num.intValue();
        } else {
            this.x = this.y + 6;
            this.y = this.z;
            this.E = z;
        }
        postInvalidate();
        q.d(getClass().getSimpleName(), "setupShowBadge isShow = " + z);
    }

    public BadgeImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = false;
        o(context, attributeSet);
    }

    public BadgeImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.E = false;
        o(context, attributeSet);
    }
}
