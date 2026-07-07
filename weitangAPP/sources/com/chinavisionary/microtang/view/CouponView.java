package com.chinavisionary.microtang.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class CouponView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f8646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f8647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Canvas f8648h;

    public CouponView(Context context) {
        super(context);
        b(context, null);
    }

    public final void a(boolean z) {
        int i2 = this.f8642b;
        int i3 = this.f8643c;
        int i4 = i2 / (this.f8644d + i3);
        int i5 = i3 / 2;
        int i6 = this.f8641a - i5;
        int i7 = 0;
        while (i7 < i4) {
            RectF rectF = new RectF();
            int i8 = this.f8643c;
            int i9 = i8 * i7;
            i7++;
            float f2 = i9 + (this.f8644d * i7);
            rectF.top = f2;
            rectF.bottom = f2 + i8;
            if (z) {
                rectF.left = i6;
                rectF.right = this.f8641a + i5;
            } else {
                rectF.left = -i5;
                rectF.right = i5;
            }
            this.f8648h.drawArc(rectF, 0.0f, 360.0f, true, this.f8646f);
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_8);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_4);
        int color = getResources().getColor(R.color.color_white);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CouponView, 0, 0);
            this.f8645e = typedArrayObtainStyledAttributes.getColor(0, color);
            this.f8643c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, dimensionPixelOffset);
            this.f8644d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelSize);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f8643c = dimensionPixelOffset;
            this.f8644d = dimensionPixelSize;
            this.f8645e = color;
        }
        Paint paint = new Paint(1);
        this.f8646f = paint;
        paint.setAntiAlias(true);
        this.f8646f.setStyle(Paint.Style.FILL);
        this.f8646f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public final void c() {
        this.f8647g = Bitmap.createBitmap(this.f8641a, this.f8642b, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(this.f8647g);
        this.f8648h = canvas;
        canvas.drawColor(this.f8645e);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f8647g, 0.0f, 0.0f, (Paint) null);
        a(true);
        a(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8641a = i2;
        this.f8642b = i3;
        c();
    }

    public CouponView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public CouponView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }
}
