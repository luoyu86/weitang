package com.tianmu.biz.widget.interaction.slideanimalview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class DottedLineView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f11027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f11028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11035i;

    public DottedLineView(Context context) {
        super(context);
        this.f11035i = 23;
        c();
    }

    private void c() {
        this.f11027a = new Path();
        Paint paint = new Paint();
        this.f11028b = paint;
        paint.setColor(-1);
        this.f11028b.setStyle(Paint.Style.STROKE);
        this.f11028b.setPathEffect(new DashPathEffect(new float[]{15.0f, 15.0f, 15.0f, 15.0f}, 1.0f));
        this.f11028b.setStrokeWidth(5.0f);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f11035i = i2;
        this.f11029c = i3;
        this.f11030d = i4;
        this.f11031e = i5;
        this.f11032f = i6;
        this.f11033g = i7;
        this.f11034h = i8;
        b();
    }

    public void b() {
        Path path = this.f11027a;
        if (path != null) {
            int i2 = this.f11035i;
            if (i2 == 23) {
                path.moveTo(this.f11029c, this.f11030d);
                this.f11027a.quadTo(this.f11031e, this.f11032f, this.f11033g, this.f11034h);
            } else if (i2 == 22) {
                path.moveTo(this.f11029c, this.f11030d);
                this.f11027a.lineTo(this.f11033g, this.f11034h);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f11027a, this.f11028b);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public DottedLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11035i = 23;
        c();
    }

    public DottedLineView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11035i = 23;
        c();
    }

    public void a() {
        if (this.f11028b != null) {
            this.f11028b = null;
        }
        if (this.f11027a != null) {
            this.f11027a = null;
        }
    }
}
