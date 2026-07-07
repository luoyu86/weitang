package com.tianmu.biz.widget.sway;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tianmu.c.f.c;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwayProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f11207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f11208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f11209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f11210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RectF f11211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f11213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bitmap f11215i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;

    public SwayProgressBar(Context context) {
        super(context);
        this.f11207a = new Paint(1);
        this.f11208b = new Path();
        this.f11209c = new Path();
        this.f11210d = TianmuDisplayUtil.dp2px(40);
        this.f11213g = 24.0f;
        this.f11214h = 0;
        d();
    }

    private float a() {
        return this.f11212f / this.f11213g;
    }

    private float b() {
        float fA = (a() * 106.0f) / 2.0f;
        return this.f11214h == 1 ? fA : -fA;
    }

    private RectF c() {
        RectF rectF = this.f11211e;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF((getWidth() / 2.0f) - this.f11210d, (getHeight() / 2.0f) - this.f11210d, (getWidth() / 2.0f) + this.f11210d, (getHeight() / 2.0f) + this.f11210d);
        this.f11211e = rectF2;
        return rectF2;
    }

    private void d() {
        this.f11207a.setStrokeWidth(TianmuDisplayUtil.dp2px(5));
        this.f11207a.setStrokeCap(Paint.Cap.ROUND);
        this.f11207a.setStyle(Paint.Style.STROKE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f11215i = BitmapFactory.decodeResource(getResources(), c.f11275a, options);
        this.j = BitmapFactory.decodeResource(getResources(), c.f11276b, options);
        this.k = BitmapFactory.decodeResource(getResources(), c.f11277c, options);
        this.l = BitmapFactory.decodeResource(getResources(), c.f11278d, options);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f11207a.setColor(Color.parseColor("#6F7170"));
        canvas.drawPath(this.f11208b, this.f11207a);
        float width = (float) (((double) (getWidth() / 2.0f)) - (((double) this.f11210d) * Math.sin(Math.toRadians(53.0d))));
        float height = (float) (((double) (getHeight() / 2.0f)) - (((double) this.f11210d) * Math.cos(Math.toRadians(53.0d))));
        int width2 = this.f11215i.getWidth();
        int height2 = this.f11215i.getHeight();
        float width3 = (float) (((double) (getWidth() / 2.0f)) + (((double) this.f11210d) * Math.sin(Math.toRadians(53.0d))));
        float height3 = (float) (((double) (getHeight() / 2.0f)) - (((double) this.f11210d) * Math.cos(Math.toRadians(53.0d))));
        if (a() == 1.0f && this.f11214h == 0) {
            float f2 = width2 / 2.0f;
            float f3 = height2 / 2.0f;
            canvas.drawBitmap(this.k, width - f2, height - f3, this.f11207a);
            canvas.drawBitmap(this.j, width3 - f2, height3 - f3, this.f11207a);
        } else if (a() == 1.0f && this.f11214h == 1) {
            float f4 = width2 / 2.0f;
            float f5 = height2 / 2.0f;
            canvas.drawBitmap(this.f11215i, width - f4, height - f5, this.f11207a);
            canvas.drawBitmap(this.l, width3 - f4, height3 - f5, this.f11207a);
        } else {
            float f6 = width2 / 2.0f;
            float f7 = height2 / 2.0f;
            canvas.drawBitmap(this.f11215i, width - f6, height - f7, this.f11207a);
            canvas.drawBitmap(this.j, width3 - f6, height3 - f7, this.f11207a);
        }
        this.f11209c.reset();
        this.f11209c.addArc(c(), 270.0f, b());
        this.f11207a.setColor(Color.parseColor("#ffffff"));
        canvas.drawPath(this.f11209c, this.f11207a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f11208b.reset();
        RectF rectF = new RectF((getWidth() / 2.0f) - this.f11210d, (getHeight() / 2.0f) - this.f11210d, (getWidth() / 2.0f) + this.f11210d, (getHeight() / 2.0f) + this.f11210d);
        this.f11211e = rectF;
        this.f11208b.addArc(rectF, 217.0f, 106.0f);
    }

    public void a(float f2) {
        this.f11212f = f2;
    }

    public void a(int i2) {
        this.f11214h = i2;
    }

    public void b(float f2) {
        this.f11213g = f2;
    }

    public SwayProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11207a = new Paint(1);
        this.f11208b = new Path();
        this.f11209c = new Path();
        this.f11210d = TianmuDisplayUtil.dp2px(40);
        this.f11213g = 24.0f;
        this.f11214h = 0;
        d();
    }

    public SwayProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11207a = new Paint(1);
        this.f11208b = new Path();
        this.f11209c = new Path();
        this.f11210d = TianmuDisplayUtil.dp2px(40);
        this.f11213g = 24.0f;
        this.f11214h = 0;
        d();
    }
}
