package com.chinavisionary.microtang.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class MerchantSaleTagTv extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f8668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8674g;

    public MerchantSaleTagTv(Context context) {
        super(context);
        this.f8673f = 5;
        this.f8674g = 14;
        this.f8671d = getResources().getDimensionPixelSize(R.dimen.sp_11);
        this.f8672e = getResources().getDimensionPixelSize(R.dimen.dp_26);
        Paint paint = new Paint(1);
        this.f8668a = paint;
        paint.setAntiAlias(true);
        this.f8668a.setStyle(Paint.Style.FILL);
        this.f8668a.setColor(-1);
        this.f8668a.setStrokeWidth(6.0f);
        this.f8668a.setTextSize(this.f8671d);
        this.f8668a.setTextAlign(Paint.Align.CENTER);
        this.f8668a.setPathEffect(new DashPathEffect(new float[]{3.0f, 2.0f}, 0.0f));
        setBackgroundResource(R.drawable.bg_btn_alert_confirm_radius_2);
        setTextSize(13.0f);
        setTextColor(-1);
        setGravity(19);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_2);
        setPadding(dimensionPixelSize * 2, dimensionPixelSize, this.f8672e + this.f8671d, dimensionPixelSize);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint.FontMetrics fontMetrics = this.f8668a.getFontMetrics();
        int i2 = this.f8669b - this.f8672e;
        float fAbs = (this.f8670c / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        float f2 = i2;
        canvas.drawText("领", (int) ((this.f8672e / 2.0f) + f2), fAbs, this.f8668a);
        canvas.drawCircle(f2, 0.0f, this.f8673f, this.f8668a);
        canvas.drawCircle(f2, this.f8670c, this.f8673f, this.f8668a);
        int i3 = this.f8670c;
        int i4 = this.f8673f;
        int i5 = this.f8674g;
        int i6 = i3 - ((i4 + i5) * 2);
        int i7 = (i6 + (i5 * (i6 / i4))) / i4;
        for (int i8 = 0; i8 < i7; i8++) {
            canvas.drawCircle(f2, (i8 * r3) + (this.f8674g * i8), this.f8673f, this.f8668a);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8669b = i2;
        this.f8670c = i3;
    }

    public MerchantSaleTagTv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8673f = 5;
        this.f8674g = 14;
        this.f8671d = getResources().getDimensionPixelSize(R.dimen.sp_11);
        this.f8672e = getResources().getDimensionPixelSize(R.dimen.dp_26);
        Paint paint = new Paint(1);
        this.f8668a = paint;
        paint.setAntiAlias(true);
        this.f8668a.setStyle(Paint.Style.FILL);
        this.f8668a.setColor(-1);
        this.f8668a.setStrokeWidth(6.0f);
        this.f8668a.setTextSize(this.f8671d);
        this.f8668a.setTextAlign(Paint.Align.CENTER);
        this.f8668a.setPathEffect(new DashPathEffect(new float[]{3.0f, 2.0f}, 0.0f));
        setBackgroundResource(R.drawable.bg_btn_alert_confirm_radius_2);
        setTextSize(13.0f);
        setTextColor(-1);
        setGravity(19);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_2);
        setPadding(dimensionPixelSize * 2, dimensionPixelSize, this.f8672e + this.f8671d, dimensionPixelSize);
    }

    public MerchantSaleTagTv(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8673f = 5;
        this.f8674g = 14;
        this.f8671d = getResources().getDimensionPixelSize(R.dimen.sp_11);
        this.f8672e = getResources().getDimensionPixelSize(R.dimen.dp_26);
        Paint paint = new Paint(1);
        this.f8668a = paint;
        paint.setAntiAlias(true);
        this.f8668a.setStyle(Paint.Style.FILL);
        this.f8668a.setColor(-1);
        this.f8668a.setStrokeWidth(6.0f);
        this.f8668a.setTextSize(this.f8671d);
        this.f8668a.setTextAlign(Paint.Align.CENTER);
        this.f8668a.setPathEffect(new DashPathEffect(new float[]{3.0f, 2.0f}, 0.0f));
        setBackgroundResource(R.drawable.bg_btn_alert_confirm_radius_2);
        setTextSize(13.0f);
        setTextColor(-1);
        setGravity(19);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_2);
        setPadding(dimensionPixelSize * 2, dimensionPixelSize, this.f8672e + this.f8671d, dimensionPixelSize);
    }
}
