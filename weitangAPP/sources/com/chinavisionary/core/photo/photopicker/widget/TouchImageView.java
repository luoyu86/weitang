package com.chinavisionary.core.photo.photopicker.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class TouchImageView extends AppCompatImageView {
    public View.OnTouchListener A;
    public f B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f6624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f6625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f6626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f6631i;
    public Context j;
    public d k;
    public ImageView.ScaleType l;
    public boolean m;
    public boolean n;
    public j o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6632q;
    public int r;
    public int s;
    public float t;
    public float u;
    public float v;
    public float w;
    public ScaleGestureDetector x;
    public GestureDetector y;
    public GestureDetector.OnDoubleTapListener z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6633a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f6633a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6633a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6633a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6633a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6633a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @TargetApi(9)
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Scroller f6634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OverScroller f6635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6636c;

        public b(Context context) {
            if (Build.VERSION.SDK_INT < 9) {
                this.f6636c = true;
                this.f6634a = new Scroller(context);
            } else {
                this.f6636c = false;
                this.f6635b = new OverScroller(context);
            }
        }

        public boolean computeScrollOffset() {
            if (this.f6636c) {
                return this.f6634a.computeScrollOffset();
            }
            this.f6635b.computeScrollOffset();
            return this.f6635b.computeScrollOffset();
        }

        public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (this.f6636c) {
                this.f6634a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            } else {
                this.f6635b.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            }
        }

        public void forceFinished(boolean z) {
            if (this.f6636c) {
                this.f6634a.forceFinished(z);
            } else {
                this.f6635b.forceFinished(z);
            }
        }

        public int getCurrX() {
            return this.f6636c ? this.f6634a.getCurrX() : this.f6635b.getCurrX();
        }

        public int getCurrY() {
            return this.f6636c ? this.f6634a.getCurrY() : this.f6635b.getCurrY();
        }

        public boolean isFinished() {
            return this.f6636c ? this.f6634a.isFinished() : this.f6635b.isFinished();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f6638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f6641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f6642e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6643f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AccelerateDecelerateInterpolator f6644g = new AccelerateDecelerateInterpolator();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PointF f6645h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PointF f6646i;

        public c(float f2, float f3, float f4, boolean z) {
            TouchImageView.this.setState(i.ANIMATE_ZOOM);
            this.f6638a = System.currentTimeMillis();
            this.f6639b = TouchImageView.this.f6623a;
            this.f6640c = f2;
            this.f6643f = z;
            PointF pointFL = TouchImageView.this.L(f3, f4, false);
            float f5 = pointFL.x;
            this.f6641d = f5;
            float f6 = pointFL.y;
            this.f6642e = f6;
            this.f6645h = TouchImageView.this.K(f5, f6);
            this.f6646i = new PointF(TouchImageView.this.p / 2, TouchImageView.this.f6632q / 2);
        }

        public final double a(float f2) {
            float f3 = this.f6639b;
            return ((double) (f3 + (f2 * (this.f6640c - f3)))) / ((double) TouchImageView.this.f6623a);
        }

        public final float b() {
            return this.f6644g.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.f6638a) / 500.0f));
        }

        public final void c(float f2) {
            PointF pointF = this.f6645h;
            float f3 = pointF.x;
            PointF pointF2 = this.f6646i;
            float f4 = f3 + ((pointF2.x - f3) * f2);
            float f5 = pointF.y;
            float f6 = f5 + (f2 * (pointF2.y - f5));
            PointF pointFK = TouchImageView.this.K(this.f6641d, this.f6642e);
            TouchImageView.this.f6624b.postTranslate(f4 - pointFK.x, f6 - pointFK.y);
        }

        @Override // java.lang.Runnable
        public void run() {
            float fB = b();
            TouchImageView.this.H(a(fB), this.f6641d, this.f6642e, this.f6643f);
            c(fB);
            TouchImageView.this.C();
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.setImageMatrix(touchImageView.f6624b);
            if (TouchImageView.this.B != null) {
                TouchImageView.this.B.onMove();
            }
            if (fB < 1.0f) {
                TouchImageView.this.A(this);
            } else {
                TouchImageView.this.setState(i.NONE);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f6647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6649c;

        public d(int i2, int i3) {
            int imageWidth;
            int i4;
            int imageHeight;
            int i5;
            TouchImageView.this.setState(i.FLING);
            this.f6647a = TouchImageView.this.new b(TouchImageView.this.j);
            TouchImageView.this.f6624b.getValues(TouchImageView.this.f6631i);
            int i6 = (int) TouchImageView.this.f6631i[2];
            int i7 = (int) TouchImageView.this.f6631i[5];
            if (TouchImageView.this.getImageWidth() > TouchImageView.this.p) {
                imageWidth = TouchImageView.this.p - ((int) TouchImageView.this.getImageWidth());
                i4 = 0;
            } else {
                imageWidth = i6;
                i4 = imageWidth;
            }
            if (TouchImageView.this.getImageHeight() > TouchImageView.this.f6632q) {
                imageHeight = TouchImageView.this.f6632q - ((int) TouchImageView.this.getImageHeight());
                i5 = 0;
            } else {
                imageHeight = i7;
                i5 = imageHeight;
            }
            this.f6647a.fling(i6, i7, i2, i3, imageWidth, i4, imageHeight, i5);
            this.f6648b = i6;
            this.f6649c = i7;
        }

        public void cancelFling() {
            if (this.f6647a != null) {
                TouchImageView.this.setState(i.NONE);
                this.f6647a.forceFinished(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchImageView.this.B != null) {
                TouchImageView.this.B.onMove();
            }
            if (this.f6647a.isFinished()) {
                this.f6647a = null;
                return;
            }
            if (this.f6647a.computeScrollOffset()) {
                int currX = this.f6647a.getCurrX();
                int currY = this.f6647a.getCurrY();
                int i2 = currX - this.f6648b;
                int i3 = currY - this.f6649c;
                this.f6648b = currX;
                this.f6649c = currY;
                TouchImageView.this.f6624b.postTranslate(i2, i3);
                TouchImageView.this.D();
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.setImageMatrix(touchImageView.f6624b);
                TouchImageView.this.A(this);
            }
        }
    }

    public class e extends GestureDetector.SimpleOnGestureListener {
        public e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean zOnDoubleTap = TouchImageView.this.z != null ? TouchImageView.this.z.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.f6626d != i.NONE) {
                return zOnDoubleTap;
            }
            TouchImageView.this.A(TouchImageView.this.new c(TouchImageView.this.f6623a == TouchImageView.this.f6627e ? TouchImageView.this.f6628f : TouchImageView.this.f6627e, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageView.this.z != null) {
                return TouchImageView.this.z.onDoubleTapEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (TouchImageView.this.k != null) {
                TouchImageView.this.k.cancelFling();
            }
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.k = touchImageView.new d((int) f2, (int) f3);
            TouchImageView touchImageView2 = TouchImageView.this;
            touchImageView2.A(touchImageView2.k);
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return TouchImageView.this.z != null ? TouchImageView.this.z.onSingleTapConfirmed(motionEvent) : TouchImageView.this.performClick();
        }

        public /* synthetic */ e(TouchImageView touchImageView, a aVar) {
            this();
        }
    }

    public interface f {
        void onMove();
    }

    public class h extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public h() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.H(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (TouchImageView.this.B == null) {
                return true;
            }
            TouchImageView.this.B.onMove();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.setState(i.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.setState(i.NONE);
            float f2 = TouchImageView.this.f6623a;
            boolean z = true;
            if (TouchImageView.this.f6623a > TouchImageView.this.f6628f) {
                f2 = TouchImageView.this.f6628f;
            } else if (TouchImageView.this.f6623a < TouchImageView.this.f6627e) {
                f2 = TouchImageView.this.f6627e;
            } else {
                z = false;
            }
            float f3 = f2;
            if (z) {
                TouchImageView.this.A(TouchImageView.this.new c(f3, r4.p / 2, TouchImageView.this.f6632q / 2, true));
            }
        }

        public /* synthetic */ h(TouchImageView touchImageView, a aVar) {
            this();
        }
    }

    public enum i {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    public class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView.ScaleType f6659d;

        public j(float f2, float f3, float f4, ImageView.ScaleType scaleType) {
            this.f6656a = f2;
            this.f6657b = f3;
            this.f6658c = f4;
            this.f6659d = scaleType;
        }
    }

    public TouchImageView(Context context) {
        super(context);
        this.z = null;
        this.A = null;
        this.B = null;
        J(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageHeight() {
        return this.u * this.f6623a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageWidth() {
        return this.t * this.f6623a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(i iVar) {
        this.f6626d = iVar;
    }

    @TargetApi(16)
    public final void A(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16L);
        }
    }

    public final void B() {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0 || this.f6624b == null || this.f6625c == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float f2 = intrinsicWidth;
        float fMax = this.p / f2;
        float f3 = intrinsicHeight;
        float f4 = this.f6632q / f3;
        int i2 = a.f6633a[this.l.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    fMax = Math.min(1.0f, Math.min(fMax, f4));
                    f4 = fMax;
                } else if (i2 != 4) {
                    if (i2 != 5) {
                        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
                    }
                }
                fMax = Math.min(fMax, f4);
            } else {
                fMax = Math.max(fMax, f4);
            }
            f4 = fMax;
        } else {
            fMax = 1.0f;
            f4 = 1.0f;
        }
        int i3 = this.p;
        float f5 = i3 - (fMax * f2);
        int i4 = this.f6632q;
        float f6 = i4 - (f4 * f3);
        this.t = i3 - f5;
        this.u = i4 - f6;
        if (isZoomed() || this.m) {
            if (this.v == 0.0f || this.w == 0.0f) {
                G();
            }
            this.f6625c.getValues(this.f6631i);
            float[] fArr = this.f6631i;
            float f7 = this.t / f2;
            float f8 = this.f6623a;
            fArr[0] = f7 * f8;
            fArr[4] = (this.u / f3) * f8;
            float f9 = fArr[2];
            float f10 = fArr[5];
            M(2, f9, this.v * f8, getImageWidth(), this.r, this.p, intrinsicWidth);
            M(5, f10, this.w * this.f6623a, getImageHeight(), this.s, this.f6632q, intrinsicHeight);
            this.f6624b.setValues(this.f6631i);
        } else {
            this.f6624b.setScale(fMax, f4);
            this.f6624b.postTranslate(f5 / 2.0f, f6 / 2.0f);
            this.f6623a = 1.0f;
        }
        D();
        setImageMatrix(this.f6624b);
    }

    public final void C() {
        D();
        this.f6624b.getValues(this.f6631i);
        float imageWidth = getImageWidth();
        int i2 = this.p;
        if (imageWidth < i2) {
            this.f6631i[2] = (i2 - getImageWidth()) / 2.0f;
        }
        float imageHeight = getImageHeight();
        int i3 = this.f6632q;
        if (imageHeight < i3) {
            this.f6631i[5] = (i3 - getImageHeight()) / 2.0f;
        }
        this.f6624b.setValues(this.f6631i);
    }

    public final void D() {
        this.f6624b.getValues(this.f6631i);
        float[] fArr = this.f6631i;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float F = F(f2, this.p, getImageWidth());
        float F2 = F(f3, this.f6632q, getImageHeight());
        if (F == 0.0f && F2 == 0.0f) {
            return;
        }
        this.f6624b.postTranslate(F, F2);
    }

    public final float E(float f2, float f3, float f4) {
        if (f4 <= f3) {
            return 0.0f;
        }
        return f2;
    }

    public final float F(float f2, float f3, float f4) {
        float f5;
        float f6;
        if (f4 <= f3) {
            f6 = f3 - f4;
            f5 = 0.0f;
        } else {
            f5 = f3 - f4;
            f6 = 0.0f;
        }
        if (f2 < f5) {
            return (-f2) + f5;
        }
        if (f2 > f6) {
            return (-f2) + f6;
        }
        return 0.0f;
    }

    public final void G() {
        Matrix matrix = this.f6624b;
        if (matrix == null || this.f6632q == 0 || this.p == 0) {
            return;
        }
        matrix.getValues(this.f6631i);
        this.f6625c.setValues(this.f6631i);
        this.w = this.u;
        this.v = this.t;
        this.s = this.f6632q;
        this.r = this.p;
    }

    public final void H(double d2, float f2, float f3, boolean z) {
        float f4;
        float f5;
        if (z) {
            f4 = this.f6629g;
            f5 = this.f6630h;
        } else {
            f4 = this.f6627e;
            f5 = this.f6628f;
        }
        float f6 = this.f6623a;
        float f7 = (float) (((double) f6) * d2);
        this.f6623a = f7;
        if (f7 > f5) {
            this.f6623a = f5;
            d2 = f5 / f6;
        } else if (f7 < f4) {
            this.f6623a = f4;
            d2 = f4 / f6;
        }
        float f8 = (float) d2;
        this.f6624b.postScale(f8, f8, f2, f3);
        C();
    }

    public final int I(int i2, int i3, int i4) {
        return i2 != Integer.MIN_VALUE ? i2 != 0 ? i3 : i4 : Math.min(i4, i3);
    }

    public final void J(Context context) {
        super.setClickable(true);
        this.j = context;
        a aVar = null;
        this.x = new ScaleGestureDetector(context, new h(this, aVar));
        this.y = new GestureDetector(context, new e(this, aVar));
        this.f6624b = new Matrix();
        this.f6625c = new Matrix();
        this.f6631i = new float[9];
        this.f6623a = 1.0f;
        if (this.l == null) {
            this.l = ImageView.ScaleType.FIT_CENTER;
        }
        this.f6627e = 1.0f;
        this.f6628f = 3.0f;
        this.f6629g = 1.0f * 0.75f;
        this.f6630h = 3.0f * 1.25f;
        setImageMatrix(this.f6624b);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(i.NONE);
        this.n = false;
        super.setOnTouchListener(new g(this, aVar));
    }

    public final PointF K(float f2, float f3) {
        this.f6624b.getValues(this.f6631i);
        return new PointF(this.f6631i[2] + (getImageWidth() * (f2 / getDrawable().getIntrinsicWidth())), this.f6631i[5] + (getImageHeight() * (f3 / getDrawable().getIntrinsicHeight())));
    }

    public final PointF L(float f2, float f3, boolean z) {
        this.f6624b.getValues(this.f6631i);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float[] fArr = this.f6631i;
        float f4 = fArr[2];
        float f5 = fArr[5];
        float imageWidth = ((f2 - f4) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f3 - f5) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    public final void M(int i2, float f2, float f3, float f4, int i3, int i4, int i5) {
        float f5 = i4;
        if (f4 < f5) {
            float[] fArr = this.f6631i;
            fArr[i2] = (f5 - (i5 * fArr[0])) * 0.5f;
        } else if (f2 > 0.0f) {
            this.f6631i[i2] = -((f4 - f5) * 0.5f);
        } else {
            this.f6631i[i2] = -((((Math.abs(f2) + (i3 * 0.5f)) / f3) * f4) - (f5 * 0.5f));
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        this.f6624b.getValues(this.f6631i);
        float f2 = this.f6631i[2];
        if (getImageWidth() < this.p) {
            return false;
        }
        if (f2 < -1.0f || i2 >= 0) {
            return (Math.abs(f2) + ((float) this.p)) + 1.0f < getImageWidth() || i2 <= 0;
        }
        return false;
    }

    public boolean canScrollHorizontallyFroyo(int i2) {
        return canScrollHorizontally(i2);
    }

    public float getCurrentZoom() {
        return this.f6623a;
    }

    public float getMaxZoom() {
        return this.f6628f;
    }

    public float getMinZoom() {
        return this.f6627e;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.l;
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF pointFL = L(this.p / 2, this.f6632q / 2, true);
        pointFL.x /= intrinsicWidth;
        pointFL.y /= intrinsicHeight;
        return pointFL;
    }

    public RectF getZoomedRect() {
        if (this.l == ImageView.ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF pointFL = L(0.0f, 0.0f, true);
        PointF pointFL2 = L(this.p, this.f6632q, true);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        return new RectF(pointFL.x / intrinsicWidth, pointFL.y / intrinsicHeight, pointFL2.x / intrinsicWidth, pointFL2.y / intrinsicHeight);
    }

    public boolean isZoomed() {
        return this.f6623a != 1.0f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        G();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.n = true;
        this.m = true;
        j jVar = this.o;
        if (jVar != null) {
            setZoom(jVar.f6656a, jVar.f6657b, jVar.f6658c, jVar.f6659d);
            this.o = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.p = I(mode, size, intrinsicWidth);
        int I = I(mode2, size2, intrinsicHeight);
        this.f6632q = I;
        setMeasuredDimension(this.p, I);
        B();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f6623a = bundle.getFloat("saveScale");
        float[] floatArray = bundle.getFloatArray("matrix");
        this.f6631i = floatArray;
        this.f6625c.setValues(floatArray);
        this.w = bundle.getFloat("matchViewHeight");
        this.v = bundle.getFloat("matchViewWidth");
        this.s = bundle.getInt("viewHeight");
        this.r = bundle.getInt("viewWidth");
        this.m = bundle.getBoolean("imageRendered");
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.f6623a);
        bundle.putFloat("matchViewHeight", this.u);
        bundle.putFloat("matchViewWidth", this.t);
        bundle.putInt("viewWidth", this.p);
        bundle.putInt("viewHeight", this.f6632q);
        this.f6624b.getValues(this.f6631i);
        bundle.putFloatArray("matrix", this.f6631i);
        bundle.putBoolean("imageRendered", this.m);
        return bundle;
    }

    public void resetZoom() {
        this.f6623a = 1.0f;
        B();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        G();
        B();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        G();
        B();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        G();
        B();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        G();
        B();
    }

    public void setMaxZoom(float f2) {
        this.f6628f = f2;
        this.f6630h = f2 * 1.25f;
    }

    public void setMinZoom(float f2) {
        this.f6627e = f2;
        this.f6629g = f2 * 0.75f;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.z = onDoubleTapListener;
    }

    public void setOnTouchImageViewListener(f fVar) {
        this.B = fVar;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A = onTouchListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        }
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
        if (scaleType == scaleType2) {
            super.setScaleType(scaleType2);
            return;
        }
        this.l = scaleType;
        if (this.n) {
            setZoom(this);
        }
    }

    public void setScrollPosition(float f2, float f3) {
        setZoom(this.f6623a, f2, f3);
    }

    public void setZoom(float f2) {
        setZoom(f2, 0.5f, 0.5f);
    }

    public class g implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PointF f6652a;

        public g() {
            this.f6652a = new PointF();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.photo.photopicker.widget.TouchImageView.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public /* synthetic */ g(TouchImageView touchImageView, a aVar) {
            this();
        }
    }

    public void setZoom(float f2, float f3, float f4) {
        setZoom(f2, f3, f4, this.l);
    }

    public void setZoom(float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        if (!this.n) {
            this.o = new j(f2, f3, f4, scaleType);
            return;
        }
        if (scaleType != this.l) {
            setScaleType(scaleType);
        }
        resetZoom();
        H(f2, this.p / 2, this.f6632q / 2, true);
        this.f6624b.getValues(this.f6631i);
        this.f6631i[2] = -((f3 * getImageWidth()) - (this.p * 0.5f));
        this.f6631i[5] = -((f4 * getImageHeight()) - (this.f6632q * 0.5f));
        this.f6624b.setValues(this.f6631i);
        D();
        setImageMatrix(this.f6624b);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = null;
        this.A = null;
        this.B = null;
        J(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = null;
        this.A = null;
        this.B = null;
        J(context);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        setZoom(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }
}
