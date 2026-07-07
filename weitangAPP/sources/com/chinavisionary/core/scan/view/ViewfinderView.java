package com.chinavisionary.core.scan.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import c.e.a.c.a.c;
import com.chinavisionary.core.R;
import com.google.zxing.ResultPoint;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f6663a = {0, 64, 128, 192, 255, 192, 128, 64};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f6664b = 48;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f6665c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f6666d = 24;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f6667e = 60;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f6668f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static float f6669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f6670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f6671i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public Bitmap o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Collection<ResultPoint> f6672q;
    public int r;
    public int s;
    public int t;
    public Bitmap u;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 2;
        this.t = 15;
        float f2 = context.getResources().getDisplayMetrics().density;
        f6669g = f2;
        f6664b = (int) (24.0f * f2);
        f6665c = (int) (5.0f * f2);
        f6666d = (int) (12.0f * f2);
        f6667e = (int) (30.0f * f2);
        f6668f = (int) (f2 * 8.0f);
        Paint paint = new Paint();
        this.f6670h = paint;
        paint.setAntiAlias(true);
        Resources resources = getResources();
        this.f6671i = resources.getColor(R.color.viewfinder_mask);
        this.j = resources.getColor(R.color.result_view);
        this.l = resources.getColor(R.color.viewfinder_frame);
        this.k = resources.getColor(R.color.viewfinder_corner);
        this.m = resources.getColor(R.color.viewfinder_laser);
        this.n = resources.getColor(R.color.possible_result_points);
        this.p = 0;
        this.f6672q = new HashSet(5);
    }

    public final void a(Canvas canvas, Rect rect) {
        this.u = BitmapFactory.decodeResource(getResources(), R.drawable.ic_wx_scan_line);
        if (this.s == 0) {
            this.s = rect.top;
        }
        int i2 = this.s;
        if (i2 >= rect.bottom - 30) {
            this.s = rect.top;
            return;
        }
        this.s = i2 + this.t;
        int i3 = rect.left;
        int i4 = this.s;
        canvas.drawBitmap(this.u, (Rect) null, new Rect(i3, i4, rect.right, i4 + 30), this.f6670h);
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        this.f6672q.add(resultPoint);
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.o = bitmap;
        invalidate();
    }

    public void drawViewfinder() {
        this.o = null;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect framingRect = c.get().getFramingRect(this.r);
        if (framingRect == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f6670h.setColor(this.o != null ? this.j : this.f6671i);
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, framingRect.top, this.f6670h);
        canvas.drawRect(0.0f, framingRect.top, framingRect.left, framingRect.bottom + 1, this.f6670h);
        canvas.drawRect(framingRect.right + 1, framingRect.top, f2, framingRect.bottom + 1, this.f6670h);
        canvas.drawRect(0.0f, framingRect.bottom + 1, f2, height, this.f6670h);
        if (this.o != null) {
            this.f6670h.setAlpha(255);
            canvas.drawBitmap(this.o, framingRect.left, framingRect.top, this.f6670h);
            return;
        }
        this.f6670h.setColor(this.l);
        canvas.drawRect(framingRect.left, framingRect.top, framingRect.right + 1, r0 + 2, this.f6670h);
        canvas.drawRect(framingRect.left, framingRect.top + 2, r0 + 2, framingRect.bottom - 1, this.f6670h);
        int i2 = framingRect.right;
        canvas.drawRect(i2 - 1, framingRect.top, i2 + 1, framingRect.bottom - 1, this.f6670h);
        float f3 = framingRect.left;
        int i3 = framingRect.bottom;
        canvas.drawRect(f3, i3 - 1, framingRect.right + 1, i3 + 1, this.f6670h);
        this.f6670h.setColor(this.k);
        int i4 = framingRect.left;
        int i5 = f6665c;
        Rect rect = new Rect(i4 - i5, framingRect.top - i5, framingRect.right + i5, framingRect.bottom + i5);
        canvas.drawRect(rect.left, rect.top, r0 + f6664b, r2 + f6665c, this.f6670h);
        canvas.drawRect(rect.left, rect.top, r0 + f6665c, r2 + f6664b, this.f6670h);
        int i6 = rect.right;
        canvas.drawRect(i6 - f6664b, rect.top, i6, r2 + f6665c, this.f6670h);
        int i7 = rect.right;
        canvas.drawRect(i7 - f6665c, rect.top, i7, r2 + f6664b, this.f6670h);
        canvas.drawRect(rect.left, r2 - f6665c, r0 + f6664b, rect.bottom, this.f6670h);
        canvas.drawRect(rect.left, r2 - f6664b, r0 + f6665c, rect.bottom, this.f6670h);
        int i8 = rect.right;
        canvas.drawRect(i8 - f6664b, r2 - f6665c, i8, rect.bottom, this.f6670h);
        int i9 = rect.right;
        canvas.drawRect(i9 - f6665c, r2 - f6664b, i9, rect.bottom, this.f6670h);
        a(canvas, framingRect);
        this.f6670h.setColor(-1);
        this.f6670h.setTextSize(f6666d);
        this.f6670h.setAlpha(255);
        this.f6670h.setTypeface(Typeface.create("System", 0));
        String string = getResources().getString(R.string.scan_code_tip_bar_code_line);
        canvas.drawText(string, (f2 - this.f6670h.measureText(string)) / 2.0f, framingRect.bottom + f6667e, this.f6670h);
        postInvalidateDelayed(100L, framingRect.left, framingRect.top, framingRect.right, framingRect.bottom);
    }

    public void setCodeViewHight(int i2) {
        this.r = i2;
        postInvalidate();
    }
}
