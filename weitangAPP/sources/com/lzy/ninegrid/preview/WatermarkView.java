package com.lzy.ninegrid.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class WatermarkView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f9472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f9474d;

    public WatermarkView(Context context) {
        this(context, null);
    }

    public final void a() {
        Paint paint = new Paint();
        this.f9472b = paint;
        paint.setColor(Color.parseColor("#40000000"));
        this.f9472b.setTextSize(TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.f9472b.setAntiAlias(true);
        this.f9473c = TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f9471a)) {
            return;
        }
        float fMeasureText = this.f9472b.measureText(this.f9471a);
        float f2 = this.f9472b.getFontMetrics().bottom - this.f9472b.getFontMetrics().top;
        double radians = Math.toRadians(this.f9474d);
        float width = (float) ((((double) getWidth()) * Math.cos(radians)) + (((double) getHeight()) * Math.sin(radians)));
        float width2 = (float) ((((double) getWidth()) * Math.sin(radians)) + (((double) getHeight()) * Math.cos(radians)));
        int iCeil = (int) Math.ceil(width / (this.f9473c + fMeasureText));
        int iCeil2 = (int) Math.ceil(width2 / (this.f9473c + f2));
        canvas.save();
        canvas.rotate(this.f9474d, getWidth() / 2.0f, getHeight() / 2.0f);
        for (int i2 = -iCeil2; i2 <= iCeil2; i2++) {
            for (int i3 = -iCeil; i3 <= iCeil; i3++) {
                canvas.drawText(this.f9471a, (i3 * (this.f9473c + fMeasureText)) + ((getWidth() - width) / 2.0f), ((i2 * (this.f9473c + f2)) - this.f9472b.getFontMetrics().top) + ((getHeight() - width2) / 2.0f), this.f9472b);
            }
        }
        canvas.restore();
    }

    public void setWatermarkText(String str) {
        this.f9471a = str;
        invalidate();
    }

    public WatermarkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WatermarkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9471a = "";
        this.f9474d = 45.0f;
        a();
    }
}
