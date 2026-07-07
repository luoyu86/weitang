package com.lzy.ninegrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class NineGridViewWrapper extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextPaint f9441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9442f;

    public NineGridViewWrapper(Context context) {
        this(context, null);
    }

    public int getMaskColor() {
        return this.f9438b;
    }

    public int getMoreNum() {
        return this.f9437a;
    }

    public int getTextColor() {
        return this.f9440d;
    }

    public float getTextSize() {
        return this.f9439c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9437a > 0) {
            canvas.drawColor(this.f9438b);
            canvas.drawText(this.f9442f, getWidth() / 2, (getHeight() / 2) - ((this.f9441e.ascent() + this.f9441e.descent()) / 2.0f), this.f9441e);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        int action = motionEvent.getAction();
        if (action == 0) {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        } else if ((action == 1 || action == 3) && (drawable = getDrawable()) != null) {
            drawable.clearColorFilter();
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaskColor(int i2) {
        this.f9438b = i2;
        invalidate();
    }

    public void setMoreNum(int i2) {
        this.f9437a = i2;
        this.f9442f = "+" + i2;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.f9440d = i2;
        this.f9441e.setColor(i2);
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f9439c = f2;
        this.f9441e.setTextSize(f2);
        invalidate();
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9437a = 0;
        this.f9438b = -2013265920;
        this.f9439c = 35.0f;
        this.f9440d = -1;
        this.f9442f = "";
        this.f9439c = TypedValue.applyDimension(2, 35.0f, getContext().getResources().getDisplayMetrics());
        TextPaint textPaint = new TextPaint();
        this.f9441e = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.f9441e.setAntiAlias(true);
        this.f9441e.setTextSize(this.f9439c);
        this.f9441e.setColor(this.f9440d);
    }
}
