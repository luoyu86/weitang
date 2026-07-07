package com.wildma.idcardcamera.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import c.r.a.b.b;

/* JADX INFO: loaded from: classes2.dex */
public class CropOverlayView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f12408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Point f12409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Point f12410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Point f12411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Point f12412i;
    public float j;
    public float k;
    public b l;
    public int m;
    public int n;
    public int o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12413q;
    public int r;
    public int s;
    public int t;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12414a;

        static {
            int[] iArr = new int[b.values().length];
            f12414a = iArr;
            try {
                iArr[b.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12414a[b.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12414a[b.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12414a[b.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CropOverlayView(Context context) {
        super(context);
        this.f12404a = 100;
        this.f12405b = 100;
        this.f12406c = 30;
        this.f12407d = 3;
        this.m = 0;
        this.n = 0;
        this.s = 40;
        this.t = 40;
    }

    public final void a(int i2, int i3) {
        Point point = this.f12411h;
        int i4 = point.x + i2;
        int i5 = this.o;
        if (i4 < i5) {
            i4 = i5;
        }
        int i6 = this.p;
        if (i4 > i6) {
            i4 = i6;
        }
        int i7 = point.y + i3;
        int i8 = this.r;
        if (i7 > i8) {
            i7 = i8;
        }
        int i9 = this.f12413q;
        if (i7 < i9) {
            i7 = i9;
        }
        point.set(i4, i7);
    }

    public final void b(int i2, int i3) {
        Point point = this.f12412i;
        int i4 = point.x + i2;
        int i5 = this.p;
        if (i4 > i5) {
            i4 = i5;
        }
        int i6 = this.o;
        if (i4 < i6) {
            i4 = i6;
        }
        int i7 = point.y + i3;
        int i8 = this.r;
        if (i7 > i8) {
            i7 = i8;
        }
        int i9 = this.f12413q;
        if (i7 < i9) {
            i7 = i9;
        }
        point.set(i4, i7);
    }

    public final void c(int i2, int i3) {
        Point point = this.f12409f;
        int i4 = point.x + i2;
        int i5 = this.o;
        if (i4 < i5) {
            i4 = i5;
        }
        int i6 = this.p;
        if (i4 > i6) {
            i4 = i6;
        }
        int i7 = point.y + i3;
        int i8 = this.f12413q;
        if (i7 < i8) {
            i7 = i8;
        }
        int i9 = this.r;
        if (i7 > i9) {
            i7 = i9;
        }
        point.set(i4, i7);
    }

    public void crop(c.r.a.b.a aVar, boolean z) {
        if (this.f12409f == null) {
            return;
        }
        float fMax = Math.max((this.f12408e.getWidth() * 1.0f) / getWidth(), (this.f12408e.getHeight() * 1.0f) / getHeight());
        Log.e("stk", "maxScale=" + fMax);
        Point point = this.f12409f;
        Point point2 = new Point((int) (((float) (point.x - this.o)) * fMax), (int) (((float) (point.y - this.f12413q)) * fMax));
        Point point3 = this.f12410g;
        Point point4 = new Point((int) ((point3.x - this.o) * fMax), (int) ((point3.y - this.f12413q) * fMax));
        Point point5 = this.f12411h;
        Point point6 = new Point((int) ((point5.x - this.o) * fMax), (int) ((point5.y - this.f12413q) * fMax));
        Point point7 = this.f12412i;
        Point point8 = new Point((int) ((point7.x - this.o) * fMax), (int) ((point7.y - this.f12413q) * fMax));
        Log.e("stk", "bitmapPoints=" + point2.toString() + " " + point4.toString() + " " + point8.toString() + " " + point6.toString() + " ");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f12408e.getWidth() + 1, this.f12408e.getHeight() + 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Path path = new Path();
        path.moveTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point4.x, (float) point4.y);
        path.lineTo((float) point8.x, (float) point8.y);
        path.lineTo((float) point6.x, (float) point6.y);
        path.close();
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.f12408e, 0.0f, 0.0f, paint);
        Rect rect = new Rect(Math.min(point2.x, point6.x), Math.min(point2.y, point4.y), Math.max(point8.x, point4.x), Math.max(point8.y, point6.y));
        if (rect.width() <= 0 || rect.height() <= 0) {
            aVar.onFinish(null);
            return;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, rect.left, rect.top, rect.width(), rect.height());
        if (!z) {
            aVar.onFinish(bitmapCreateBitmap2);
            return;
        }
        Point point9 = new Point();
        Point point10 = new Point();
        Point point11 = new Point();
        Point point12 = new Point();
        int i2 = point2.x;
        int i3 = point6.x;
        point9.x = i2 > i3 ? i2 - i3 : 0;
        int i4 = point2.y;
        int i5 = point4.y;
        point9.y = i4 > i5 ? i4 - i5 : 0;
        point10.x = point4.x > point8.x ? rect.width() : rect.width() - Math.abs(point8.x - point4.x);
        int i6 = point2.y;
        int i7 = point4.y;
        point10.y = i6 > i7 ? 0 : Math.abs(i6 - i7);
        int i8 = point2.x;
        int i9 = point6.x;
        point11.x = i8 > i9 ? 0 : Math.abs(i8 - i9);
        point11.y = point6.y > point8.y ? rect.height() : rect.height() - Math.abs(point8.y - point6.y);
        point12.x = point4.x > point8.x ? rect.width() - Math.abs(point8.x - point4.x) : rect.width();
        point12.y = point6.y > point8.y ? rect.height() - Math.abs(point8.y - point6.y) : rect.height();
        Log.e("stk", bitmapCreateBitmap2.getWidth() + "x" + bitmapCreateBitmap2.getHeight());
        Log.e("stk", "cutPoints=" + point9.toString() + " " + point10.toString() + " " + point12.toString() + " " + point11.toString() + " ");
        float width = (float) bitmapCreateBitmap2.getWidth();
        float height = (float) bitmapCreateBitmap2.getHeight();
        float[] fArr = {(float) point9.x, (float) point9.y, (float) point10.x, (float) point10.y, (float) point12.x, (float) point12.y, (float) point11.x, (float) point11.y};
        float[] fArr2 = {0.0f, 0.0f, width, 0.0f, width, height, 0.0f, height};
        Matrix matrix = new Matrix();
        matrix.setPolyToPoly(fArr, 0, fArr2, 0, 4);
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap3);
        canvas2.concat(matrix);
        canvas2.drawBitmapMesh(bitmapCreateBitmap2, this.s, this.t, i(bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight()), 0, null, 0, null);
        aVar.onFinish(bitmapCreateBitmap3);
    }

    public final void d(int i2, int i3) {
        Point point = this.f12410g;
        int i4 = point.x + i2;
        int i5 = this.p;
        if (i4 > i5) {
            i4 = i5;
        }
        int i6 = this.o;
        if (i4 < i6) {
            i4 = i6;
        }
        int i7 = point.y + i3;
        int i8 = this.f12413q;
        if (i7 < i8) {
            i7 = i8;
        }
        int i9 = this.r;
        if (i7 > i9) {
            i7 = i9;
        }
        point.set(i4, i7);
    }

    public final int e(Point point, Point point2) {
        return (int) Math.sqrt(Math.pow(point.x - point2.x, 2.0d) + Math.pow(point.y - point2.y, 2.0d));
    }

    public final void f(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#66000000"));
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        Point point = this.f12409f;
        path.moveTo(point.x, point.y);
        Point point2 = this.f12410g;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.f12412i;
        path.lineTo(point3.x, point3.y);
        Point point4 = this.f12411h;
        path.lineTo(point4.x, point4.y);
        path.close();
        canvas.save();
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawColor(Color.parseColor("#66000000"));
        canvas.restore();
    }

    public final void g(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStrokeWidth(3.0f);
        paint.setAntiAlias(true);
        Point point = this.f12409f;
        float f2 = point.x;
        float f3 = point.y;
        Point point2 = this.f12410g;
        canvas.drawLine(f2, f3, point2.x, point2.y, paint);
        Point point3 = this.f12409f;
        float f4 = point3.x;
        float f5 = point3.y;
        Point point4 = this.f12411h;
        canvas.drawLine(f4, f5, point4.x, point4.y, paint);
        Point point5 = this.f12412i;
        float f6 = point5.x;
        float f7 = point5.y;
        Point point6 = this.f12410g;
        canvas.drawLine(f6, f7, point6.x, point6.y, paint);
        Point point7 = this.f12412i;
        float f8 = point7.x;
        float f9 = point7.y;
        Point point8 = this.f12411h;
        canvas.drawLine(f8, f9, point8.x, point8.y, paint);
    }

    public final void h(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        Point point = this.f12409f;
        canvas.drawCircle(point.x, point.y, this.f12406c, paint);
        Point point2 = this.f12410g;
        canvas.drawCircle(point2.x, point2.y, this.f12406c, paint);
        Point point3 = this.f12411h;
        canvas.drawCircle(point3.x, point3.y, this.f12406c, paint);
        Point point4 = this.f12412i;
        canvas.drawCircle(point4.x, point4.y, this.f12406c, paint);
        Log.e("stk", "vertextPoints=" + this.f12409f.toString() + " " + this.f12410g.toString() + " " + this.f12412i.toString() + " " + this.f12411h.toString());
    }

    public final float[] i(int i2, int i3) {
        int i4 = this.s;
        int i5 = this.t;
        float[] fArr = new float[(i4 + 1) * (i5 + 1) * 2];
        float f2 = i2 / i4;
        float f3 = i3 / i5;
        for (int i6 = 0; i6 <= this.t; i6++) {
            for (int i7 = 0; i7 <= this.s; i7++) {
                int i8 = this.t;
                int i9 = i7 * 2;
                fArr[((i8 + 1) * 2 * i6) + i9] = i7 * f2;
                fArr[((i8 + 1) * 2 * i6) + i9 + 1] = i6 * f3;
            }
        }
        return fArr;
    }

    public final void j(MotionEvent motionEvent) {
        this.j = motionEvent.getX();
        this.k = motionEvent.getY();
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        int iE = e(point, this.f12409f);
        this.l = b.TOP_LEFT;
        if (iE > e(point, this.f12410g)) {
            iE = e(point, this.f12410g);
            this.l = b.TOP_RIGHT;
        }
        if (iE > e(point, this.f12411h)) {
            iE = e(point, this.f12411h);
            this.l = b.BOTTOM_LEFT;
        }
        if (iE > e(point, this.f12412i)) {
            e(point, this.f12412i);
            this.l = b.BOTTOM_RIGHT;
        }
    }

    public final void k(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() - this.j);
        int y = (int) (motionEvent.getY() - this.k);
        int i2 = a.f12414a[this.l.ordinal()];
        if (i2 == 1) {
            c(x, y);
            invalidate();
        } else if (i2 == 2) {
            d(x, y);
            invalidate();
        } else if (i2 == 3) {
            a(x, y);
            invalidate();
        } else if (i2 == 4) {
            b(x, y);
            invalidate();
        }
        this.j = motionEvent.getX();
        this.k = motionEvent.getY();
    }

    public final void l() {
        int height;
        int width;
        int width2;
        Log.e("stk", "resetPoints, bitmap=" + this.f12408e);
        float width3 = (((float) this.f12408e.getWidth()) * 1.0f) / ((float) getWidth());
        float height2 = (((float) this.f12408e.getHeight()) * 1.0f) / ((float) getHeight());
        float fMax = Math.max(width3, height2);
        int width4 = getWidth();
        int height3 = getHeight();
        if (fMax == height2) {
            width2 = (getWidth() - ((int) (this.f12408e.getWidth() / fMax))) / 2;
            width = getWidth() - width2;
            height = 0;
        } else {
            height = (getHeight() - ((int) (this.f12408e.getHeight() / fMax))) / 2;
            height3 = getHeight() - height;
            width = width4;
            width2 = 0;
        }
        this.o = width2;
        this.f12413q = height;
        this.p = width;
        this.r = height3;
        int i2 = width - width2;
        int i3 = this.f12404a;
        if (i2 < i3 || height3 - height < i3) {
            this.f12404a = 0;
        } else {
            this.f12404a = 30;
        }
        Log.e("stk", "maxX - minX=" + i2);
        Log.e("stk", "maxY - minY=" + (height3 - height));
        int i4 = this.f12404a;
        this.f12409f = new Point(width2 + i4, i4 + height);
        int i5 = this.f12404a;
        this.f12410g = new Point(width - i5, height + i5);
        int i6 = this.f12404a;
        this.f12411h = new Point(width2 + i6, height3 - i6);
        int i7 = this.f12404a;
        this.f12412i = new Point(width - i7, height3 - i7);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() != this.m || getHeight() != this.n) {
            this.m = getWidth();
            this.n = getHeight();
            l();
        }
        Log.e("stk", "canvasSize=" + getWidth() + "x" + getHeight());
        f(canvas);
        h(canvas);
        g(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            j(motionEvent);
            return true;
        }
        if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
            k(motionEvent);
            return true;
        }
        return false;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f12408e = bitmap;
        l();
        invalidate();
    }

    public CropOverlayView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12404a = 100;
        this.f12405b = 100;
        this.f12406c = 30;
        this.f12407d = 3;
        this.m = 0;
        this.n = 0;
        this.s = 40;
        this.t = 40;
    }
}
