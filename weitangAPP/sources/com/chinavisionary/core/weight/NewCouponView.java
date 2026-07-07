package com.chinavisionary.core.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public class NewCouponView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f6718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f6719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f6720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f6721i;
    public Canvas j;
    public int k;

    public NewCouponView(Context context) {
        super(context);
        c(context, null);
    }

    public final void a(Canvas canvas) {
        Rect rect = new Rect();
        rect.left = 0;
        rect.right = this.k;
        rect.top = 0;
        rect.bottom = this.f6714b;
        this.j.drawRect(rect, this.f6719g);
    }

    public final void b(boolean z) {
        int i2 = this.f6714b / 2;
        int i3 = this.f6715c / 2;
        int i4 = this.f6713a - i3;
        RectF rectF = new RectF();
        float f2 = i2 - i3;
        rectF.top = f2;
        rectF.bottom = f2 + this.f6715c;
        if (z) {
            rectF.left = i4;
            rectF.right = this.f6713a + i3;
        } else {
            rectF.left = -i3;
            rectF.right = i3;
        }
        this.j.drawArc(rectF, 0.0f, 360.0f, true, this.f6718f);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_16);
        this.k = getResources().getDimensionPixelOffset(R.dimen.dp_106);
        getResources().getDimensionPixelSize(R.dimen.dp_4);
        int color = getResources().getColor(R.color.color_white);
        this.f6717e = getResources().getColor(R.color.colorFE9A02);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NewCouponView, 0, 0);
            this.f6716d = typedArrayObtainStyledAttributes.getColor(R.styleable.NewCouponView_bg_color, color);
            this.f6717e = typedArrayObtainStyledAttributes.getColor(R.styleable.NewCouponView_left_bg_color, this.f6717e);
            this.f6715c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.NewCouponView_gap_width, dimensionPixelOffset);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f6715c = dimensionPixelOffset;
            this.f6716d = color;
        }
        Paint paint = new Paint(1);
        this.f6718f = paint;
        paint.setAntiAlias(true);
        this.f6718f.setStyle(Paint.Style.FILL);
        this.f6718f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint(1);
        this.f6719g = paint2;
        paint2.setColor(this.f6717e);
        this.f6719g.setAntiAlias(true);
        this.f6719g.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f6720h = paint3;
        paint3.setAntiAlias(true);
        this.f6720h.setStyle(Paint.Style.STROKE);
        this.f6720h.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f));
    }

    public final void d() {
        this.f6721i = Bitmap.createBitmap(this.f6713a, this.f6714b, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(this.f6721i);
        this.j = canvas;
        canvas.drawColor(this.f6716d);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f6721i, 0.0f, 0.0f, (Paint) null);
        a(canvas);
        b(true);
        b(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f6713a = i2;
        this.f6714b = i3;
        d();
    }

    public void setBgColor(int i2) {
        if (i2 != this.f6716d) {
            this.f6716d = i2;
            this.j.drawColor(i2);
            postInvalidate();
        }
    }

    public void setLeftBgColor(int i2) {
        if (i2 != this.f6717e) {
            this.f6717e = i2;
            this.f6719g.setColor(i2);
            postInvalidate();
        }
    }

    public NewCouponView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public NewCouponView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
