package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class SubsamplingScaleImageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8849a = SubsamplingScaleImageView.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f8850b = Arrays.asList(0, 90, Integer.valueOf(BaseTransientBottomBar.ANIMATION_FADE_DURATION), 270, -1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Integer> f8851c = Arrays.asList(1, 2, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f8852d = Arrays.asList(2, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<Integer> f8853e = Arrays.asList(1, 2, 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Integer> f8854f = Arrays.asList(2, 1, 3);
    public float A;
    public PointF A0;
    public boolean A1;
    public boolean A2;
    public g A3;
    public View.OnLongClickListener A4;
    public float B;
    public PointF C;
    public float C0;
    public c C1;
    public PointF D;
    public Float E;
    public PointF F;
    public PointF G;
    public int H;
    public int I;
    public int J;
    public Rect K;
    public Rect L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public GestureDetector Q;
    public c.g.a.a.c.d R;
    public final Object S;
    public c.g.a.a.c.b<? extends c.g.a.a.c.c> T;
    public c.g.a.a.c.b<? extends c.g.a.a.c.d> U;
    public PointF V;
    public float W;
    public boolean W2;
    public final float c0;
    public PointF c1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f8855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8857i;
    public Uri j;
    public int k;
    public Handler k5;
    public Map<Integer, List<i>> l;
    public Paint l5;
    public boolean m;
    public Paint m5;
    public int n;
    public Paint n5;
    public float o;
    public h o5;
    public float p;
    public Matrix p5;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8858q;
    public RectF q5;
    public int r;
    public float[] r5;
    public int s;
    public float[] s5;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public float x;
    public int y;
    public int z;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && SubsamplingScaleImageView.this.A4 != null) {
                SubsamplingScaleImageView.this.P = 0;
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.A4);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8860a;

        public b(Context context) {
            this.f8860a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!SubsamplingScaleImageView.this.v || !SubsamplingScaleImageView.this.A2 || SubsamplingScaleImageView.this.C == null) {
                return super.onDoubleTapEvent(motionEvent);
            }
            SubsamplingScaleImageView.this.setGestureDetector(this.f8860a);
            if (!SubsamplingScaleImageView.this.w) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                subsamplingScaleImageView.T(subsamplingScaleImageView.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            SubsamplingScaleImageView.this.V = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView.this.D = new PointF(SubsamplingScaleImageView.this.C.x, SubsamplingScaleImageView.this.C.y);
            SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView2.B = subsamplingScaleImageView2.A;
            SubsamplingScaleImageView.this.O = true;
            SubsamplingScaleImageView.this.M = true;
            SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView3.A0 = subsamplingScaleImageView3.viewToSourceCoord(subsamplingScaleImageView3.V);
            SubsamplingScaleImageView.this.C0 = -1.0f;
            SubsamplingScaleImageView.this.c1 = new PointF(SubsamplingScaleImageView.this.A0.x, SubsamplingScaleImageView.this.A0.y);
            SubsamplingScaleImageView.this.A1 = false;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (!SubsamplingScaleImageView.this.u || !SubsamplingScaleImageView.this.A2 || SubsamplingScaleImageView.this.C == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f3) <= 500.0f) || SubsamplingScaleImageView.this.M))) {
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            PointF pointF = new PointF(SubsamplingScaleImageView.this.C.x + (f2 * 0.25f), SubsamplingScaleImageView.this.C.y + (f3 * 0.25f));
            new d(SubsamplingScaleImageView.this, new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.A, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.A), (a) null).withEasing(1).b(false).start();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f8871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f8872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PointF f8873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8875e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8877g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public f f8878h;

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, PointF pointF2, a aVar) {
            this(f2, pointF, pointF2);
        }

        public final d b(boolean z) {
            this.f8877g = z;
            return this;
        }

        public void start() {
            PointF pointFG0;
            if (SubsamplingScaleImageView.this.C1 != null && SubsamplingScaleImageView.this.C1.l != null) {
                try {
                    SubsamplingScaleImageView.this.C1.l.onInterruptedByNewAnim();
                } catch (Exception e2) {
                    Log.w(SubsamplingScaleImageView.f8849a, "Error thrown by animation listener", e2);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float fH0 = SubsamplingScaleImageView.this.h0(this.f8871a);
            if (this.f8877g) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF = this.f8872b;
                pointFG0 = subsamplingScaleImageView.g0(pointF.x, pointF.y, fH0, new PointF());
            } else {
                pointFG0 = this.f8872b;
            }
            a aVar = null;
            SubsamplingScaleImageView.this.C1 = new c(aVar);
            SubsamplingScaleImageView.this.C1.f8862a = SubsamplingScaleImageView.this.A;
            SubsamplingScaleImageView.this.C1.f8863b = fH0;
            SubsamplingScaleImageView.this.C1.k = System.currentTimeMillis();
            SubsamplingScaleImageView.this.C1.f8866e = pointFG0;
            SubsamplingScaleImageView.this.C1.f8864c = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.C1.f8865d = pointFG0;
            SubsamplingScaleImageView.this.C1.f8867f = SubsamplingScaleImageView.this.sourceToViewCoord(pointFG0);
            SubsamplingScaleImageView.this.C1.f8868g = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.C1.f8869h = this.f8874d;
            SubsamplingScaleImageView.this.C1.f8870i = this.f8876f;
            SubsamplingScaleImageView.this.C1.j = this.f8875e;
            SubsamplingScaleImageView.this.C1.k = System.currentTimeMillis();
            SubsamplingScaleImageView.this.C1.l = this.f8878h;
            PointF pointF2 = this.f8873c;
            if (pointF2 != null) {
                float f2 = pointF2.x - (SubsamplingScaleImageView.this.C1.f8864c.x * fH0);
                float f3 = this.f8873c.y - (SubsamplingScaleImageView.this.C1.f8864c.y * fH0);
                h hVar = new h(fH0, new PointF(f2, f3), aVar);
                SubsamplingScaleImageView.this.a0(true, hVar);
                SubsamplingScaleImageView.this.C1.f8868g = new PointF(this.f8873c.x + (hVar.f8888b.x - f2), this.f8873c.y + (hVar.f8888b.y - f3));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public d withDuration(long j) {
            this.f8874d = j;
            return this;
        }

        public d withEasing(int i2) {
            if (SubsamplingScaleImageView.f8852d.contains(Integer.valueOf(i2))) {
                this.f8875e = i2;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i2);
        }

        public d withInterruptible(boolean z) {
            this.f8876f = z;
            return this;
        }

        public d withOnAnimationEventListener(f fVar) {
            this.f8878h = fVar;
            return this;
        }

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, a aVar) {
            this(f2, pointF);
        }

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, float f2, a aVar) {
            this(f2);
        }

        public /* synthetic */ d(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, a aVar) {
            this(pointF);
        }

        public d(PointF pointF) {
            this.f8874d = 500L;
            this.f8875e = 2;
            this.f8876f = true;
            this.f8877g = true;
            this.f8871a = SubsamplingScaleImageView.this.A;
            this.f8872b = pointF;
            this.f8873c = null;
        }

        public d(float f2) {
            this.f8874d = 500L;
            this.f8875e = 2;
            this.f8876f = true;
            this.f8877g = true;
            this.f8871a = f2;
            this.f8872b = SubsamplingScaleImageView.this.getCenter();
            this.f8873c = null;
        }

        public d(float f2, PointF pointF) {
            this.f8874d = 500L;
            this.f8875e = 2;
            this.f8876f = true;
            this.f8877g = true;
            this.f8871a = f2;
            this.f8872b = pointF;
            this.f8873c = null;
        }

        public d(float f2, PointF pointF, PointF pointF2) {
            this.f8874d = 500L;
            this.f8875e = 2;
            this.f8876f = true;
            this.f8877g = true;
            this.f8871a = f2;
            this.f8872b = pointF;
            this.f8873c = pointF2;
        }
    }

    public static class e extends AsyncTask<Void, Void, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f8880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Context> f8881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<c.g.a.a.c.b<? extends c.g.a.a.c.c>> f8882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f8883d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f8884e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f8885f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Exception f8886g;

        public e(SubsamplingScaleImageView subsamplingScaleImageView, Context context, c.g.a.a.c.b<? extends c.g.a.a.c.c> bVar, Uri uri, boolean z) {
            this.f8880a = new WeakReference<>(subsamplingScaleImageView);
            this.f8881b = new WeakReference<>(context);
            this.f8882c = new WeakReference<>(bVar);
            this.f8883d = uri;
            this.f8884e = z;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                String string = this.f8883d.toString();
                Context context = this.f8881b.get();
                c.g.a.a.c.b<? extends c.g.a.a.c.c> bVar = this.f8882c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f8880a.get();
                if (context == null || bVar == null || subsamplingScaleImageView == null) {
                    return null;
                }
                this.f8885f = bVar.make().decode(context, this.f8883d);
                return Integer.valueOf(subsamplingScaleImageView.b0(string));
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.f8849a, "Failed to load bitmap", e2);
                this.f8886g = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(SubsamplingScaleImageView.f8849a, "Failed to load bitmap - OutOfMemoryError", e3);
                this.f8886g = new RuntimeException(e3);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f8880a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f8885f;
                if (bitmap != null && num != null) {
                    if (this.f8884e) {
                        subsamplingScaleImageView.l0(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.k0(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.f8886g == null || subsamplingScaleImageView.A3 == null) {
                    return;
                }
                if (this.f8884e) {
                    subsamplingScaleImageView.A3.onPreviewLoadError(this.f8886g);
                } else {
                    subsamplingScaleImageView.A3.onImageLoadError(this.f8886g);
                }
            }
        }
    }

    public interface f {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface g {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PointF f8888b;

        public /* synthetic */ h(float f2, PointF pointF, a aVar) {
            this(f2, pointF);
        }

        public h(float f2, PointF pointF) {
            this.f8887a = f2;
            this.f8888b = pointF;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f8889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f8891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Rect f8894f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Rect f8895g;

        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public static class j extends AsyncTask<Void, Void, Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f8896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<c.g.a.a.c.d> f8897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<i> f8898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Exception f8899d;

        public j(SubsamplingScaleImageView subsamplingScaleImageView, c.g.a.a.c.d dVar, i iVar) {
            this.f8896a = new WeakReference<>(subsamplingScaleImageView);
            this.f8897b = new WeakReference<>(dVar);
            this.f8898c = new WeakReference<>(iVar);
            iVar.f8892d = true;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmapDecodeRegion;
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.f8896a.get();
                c.g.a.a.c.d dVar = this.f8897b.get();
                i iVar = this.f8898c.get();
                if (dVar == null || iVar == null || subsamplingScaleImageView == null || !dVar.isReady() || !iVar.f8893e) {
                    if (iVar == null) {
                        return null;
                    }
                    iVar.f8892d = false;
                    return null;
                }
                synchronized (subsamplingScaleImageView.S) {
                    subsamplingScaleImageView.Y(iVar.f8889a, iVar.f8895g);
                    if (subsamplingScaleImageView.K != null) {
                        iVar.f8895g.offset(subsamplingScaleImageView.K.left, subsamplingScaleImageView.K.top);
                    }
                    bitmapDecodeRegion = dVar.decodeRegion(iVar.f8895g, iVar.f8890b);
                }
                return bitmapDecodeRegion;
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.f8849a, "Failed to decode tile", e2);
                this.f8899d = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(SubsamplingScaleImageView.f8849a, "Failed to decode tile - OutOfMemoryError", e3);
                this.f8899d = new RuntimeException(e3);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f8896a.get();
            i iVar = this.f8898c.get();
            if (subsamplingScaleImageView == null || iVar == null) {
                return;
            }
            if (bitmap != null) {
                iVar.f8891c = bitmap;
                iVar.f8892d = false;
                subsamplingScaleImageView.n0();
            } else {
                if (this.f8899d == null || subsamplingScaleImageView.A3 == null) {
                    return;
                }
                subsamplingScaleImageView.A3.onTileLoadError(this.f8899d);
            }
        }
    }

    public static class k extends AsyncTask<Void, Void, int[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f8900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Context> f8901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<c.g.a.a.c.b<? extends c.g.a.a.c.d>> f8902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f8903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c.g.a.a.c.d f8904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Exception f8905f;

        public k(SubsamplingScaleImageView subsamplingScaleImageView, Context context, c.g.a.a.c.b<? extends c.g.a.a.c.d> bVar, Uri uri) {
            this.f8900a = new WeakReference<>(subsamplingScaleImageView);
            this.f8901b = new WeakReference<>(context);
            this.f8902c = new WeakReference<>(bVar);
            this.f8903d = uri;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int[] doInBackground(Void... voidArr) {
            try {
                String string = this.f8903d.toString();
                Context context = this.f8901b.get();
                c.g.a.a.c.b<? extends c.g.a.a.c.d> bVar = this.f8902c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f8900a.get();
                if (context == null || bVar == null || subsamplingScaleImageView == null) {
                    return null;
                }
                c.g.a.a.c.d dVarMake = bVar.make();
                this.f8904e = dVarMake;
                Point pointInit = dVarMake.init(context, this.f8903d);
                int iWidth = pointInit.x;
                int iHeight = pointInit.y;
                int iB0 = subsamplingScaleImageView.b0(string);
                if (subsamplingScaleImageView.K != null) {
                    iWidth = subsamplingScaleImageView.K.width();
                    iHeight = subsamplingScaleImageView.K.height();
                }
                return new int[]{iWidth, iHeight, iB0};
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.f8849a, "Failed to initialise bitmap decoder", e2);
                this.f8905f = e2;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f8900a.get();
            if (subsamplingScaleImageView != null) {
                c.g.a.a.c.d dVar = this.f8904e;
                if (dVar != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.o0(dVar, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.f8905f == null || subsamplingScaleImageView.A3 == null) {
                        return;
                    }
                    subsamplingScaleImageView.A3.onImageLoadError(this.f8905f);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        int resourceId;
        String string;
        super(context, attributeSet);
        this.n = 0;
        this.o = 2.0f;
        this.p = i0();
        this.f8858q = -1;
        this.r = 1;
        this.s = 1;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = 1.0f;
        this.y = 1;
        this.z = 500;
        this.S = new Object();
        this.T = new c.g.a.a.c.a(c.g.a.a.c.e.class);
        this.U = new c.g.a.a.c.a(c.g.a.a.c.f.class);
        this.r5 = new float[8];
        this.s5 = new float[8];
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setGestureDetector(context);
        this.k5 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (typedArrayObtainStyledAttributes.hasValue(1) && (string = typedArrayObtainStyledAttributes.getString(1)) != null && string.length() > 0) {
                setImage(c.g.a.a.a.asset(string).tilingEnabled());
            }
            if (typedArrayObtainStyledAttributes.hasValue(0) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) > 0) {
                setImage(c.g.a.a.a.resource(resourceId).tilingEnabled());
            }
            if (typedArrayObtainStyledAttributes.hasValue(2)) {
                setPanEnabled(typedArrayObtainStyledAttributes.getBoolean(2, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(3)) {
                setZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(3, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(4)) {
                setQuickScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(4, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(5)) {
                setTileBackgroundColor(typedArrayObtainStyledAttributes.getColor(5, Color.argb(0, 0, 0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.c0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int getRequiredRotation() {
        int i2 = this.n;
        return i2 == -1 ? this.J : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.Q = new GestureDetector(context, new b(context));
    }

    public final PointF A0(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.o5 == null) {
            this.o5 = new h(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.o5.f8887a = f4;
        this.o5.f8888b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        a0(true, this.o5);
        return this.o5.f8888b;
    }

    public final float B0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.A;
    }

    public final float C0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.A;
    }

    public final int O(float f2) {
        int iRound;
        if (this.f8858q > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.f8858q / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iU0 = (int) (u0() * f2);
        int iT0 = (int) (t0() * f2);
        if (iU0 == 0 || iT0 == 0) {
            return 32;
        }
        int i2 = 1;
        if (t0() > iT0 || u0() > iU0) {
            iRound = Math.round(t0() / iT0);
            int iRound2 = Math.round(u0() / iU0);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= iRound) {
                return i2;
            }
            i2 = i3;
        }
    }

    public final boolean P() {
        boolean zF0 = f0();
        if (!this.W2 && zF0) {
            p0();
            this.W2 = true;
            j0();
            g gVar = this.A3;
            if (gVar != null) {
                gVar.onImageLoaded();
            }
        }
        return zF0;
    }

    public final boolean Q() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.H > 0 && this.I > 0 && (this.f8855g != null || f0());
        if (!this.A2 && z) {
            p0();
            this.A2 = true;
            m0();
            g gVar = this.A3;
            if (gVar != null) {
                gVar.onReady();
            }
        }
        return z;
    }

    public final void R() {
        if (this.l5 == null) {
            Paint paint = new Paint();
            this.l5 = paint;
            paint.setAntiAlias(true);
            this.l5.setFilterBitmap(true);
            this.l5.setDither(true);
        }
        if (this.m5 == null && this.m) {
            Paint paint2 = new Paint();
            this.m5 = paint2;
            paint2.setTextSize(18.0f);
            this.m5.setColor(-65281);
            this.m5.setStyle(Paint.Style.STROKE);
        }
    }

    public final float S(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    public final void T(PointF pointF, PointF pointF2) {
        if (!this.u) {
            PointF pointF3 = this.G;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = u0() / 2;
                pointF.y = t0() / 2;
            }
        }
        float fMin = Math.min(this.o, this.x);
        boolean z = ((double) this.A) <= ((double) fMin) * 0.9d;
        if (!z) {
            fMin = i0();
        }
        float f2 = fMin;
        int i2 = this.y;
        if (i2 == 3) {
            setScaleAndCenter(f2, pointF);
        } else if (i2 == 2 || !z || !this.u) {
            new d(this, f2, pointF, (a) null).withInterruptible(false).withDuration(this.z).start();
        } else if (i2 == 1) {
            new d(this, f2, pointF, pointF2, null).withInterruptible(false).withDuration(this.z).start();
        }
        invalidate();
    }

    public final float U(int i2, long j2, float f2, float f3, long j3) {
        if (i2 == 1) {
            return W(j2, f2, f3, j3);
        }
        if (i2 == 2) {
            return V(j2, f2, f3, j3);
        }
        throw new IllegalStateException("Unexpected easing type: " + i2);
    }

    public final float V(long j2, float f2, float f3, long j3) {
        float f4;
        float f5 = j2 / (j3 / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    public final float W(long j2, float f2, float f3, long j3) {
        float f4 = j2 / j3;
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    public final void X(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.t && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                return;
            } catch (Exception e2) {
                Log.i(f8849a, "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e2);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    public final void Y(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i2 = rect.top;
            int i3 = this.I;
            rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
        } else if (getRequiredRotation() != 180) {
            int i4 = this.H;
            rect2.set(i4 - rect.bottom, rect.left, i4 - rect.top, rect.right);
        } else {
            int i5 = this.H;
            int i6 = i5 - rect.right;
            int i7 = this.I;
            rect2.set(i6, i7 - rect.bottom, i5 - rect.left, i7 - rect.top);
        }
    }

    public final void Z(boolean z) {
        boolean z2;
        float f2 = 0.0f;
        if (this.C == null) {
            z2 = true;
            this.C = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.o5 == null) {
            this.o5 = new h(f2, new PointF(0.0f, 0.0f), null);
        }
        this.o5.f8887a = this.A;
        this.o5.f8888b.set(this.C);
        a0(z, this.o5);
        this.A = this.o5.f8887a;
        this.C.set(this.o5.f8888b);
        if (z2) {
            this.C.set(A0(u0() / 2, t0() / 2, this.A));
        }
    }

    public final void a0(boolean z, h hVar) {
        float fMax;
        int iMax;
        float fMax2;
        if (this.r == 2 && isReady()) {
            z = false;
        }
        PointF pointF = hVar.f8888b;
        float fH0 = h0(hVar.f8887a);
        float fU0 = u0() * fH0;
        float fT0 = t0() * fH0;
        if (this.r == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - fU0);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - fT0);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - fU0);
            pointF.y = Math.max(pointF.y, getHeight() - fT0);
        } else {
            pointF.x = Math.max(pointF.x, -fU0);
            pointF.y = Math.max(pointF.y, -fT0);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.r == 3 && isReady()) {
            fMax = Math.max(0, getWidth() / 2);
            iMax = Math.max(0, getHeight() / 2);
        } else {
            if (z) {
                fMax = Math.max(0.0f, (getWidth() - fU0) * paddingLeft);
                fMax2 = Math.max(0.0f, (getHeight() - fT0) * paddingTop);
                pointF.x = Math.min(pointF.x, fMax);
                pointF.y = Math.min(pointF.y, fMax2);
                hVar.f8887a = fH0;
            }
            fMax = Math.max(0, getWidth());
            iMax = Math.max(0, getHeight());
        }
        fMax2 = iMax;
        pointF.x = Math.min(pointF.x, fMax);
        pointF.y = Math.min(pointF.y, fMax2);
        hVar.f8887a = fH0;
    }

    public d animateCenter(PointF pointF) {
        a aVar = null;
        if (isReady()) {
            return new d(this, pointF, aVar);
        }
        return null;
    }

    public d animateScale(float f2) {
        a aVar = null;
        if (isReady()) {
            return new d(this, f2, aVar);
        }
        return null;
    }

    public d animateScaleAndCenter(float f2, PointF pointF) {
        a aVar = null;
        if (isReady()) {
            return new d(this, f2, pointF, aVar);
        }
        return null;
    }

    public final int b0(String str) {
        int i2 = 0;
        if (str.startsWith("content")) {
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (cursorQuery == null) {
                    return 0;
                }
                if (cursorQuery.moveToFirst()) {
                    int i3 = cursorQuery.getInt(0);
                    if (!f8850b.contains(Integer.valueOf(i3)) || i3 == -1) {
                        Log.w(f8849a, "Unsupported orientation: " + i3);
                    } else {
                        i2 = i3;
                    }
                }
                cursorQuery.close();
                return i2;
            } catch (Exception unused) {
                Log.w(f8849a, "Could not get orientation of image from media store");
                return i2;
            }
        }
        if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
            if (attributeInt != 1 && attributeInt != 0) {
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return BaseTransientBottomBar.ANIMATION_FADE_DURATION;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                Log.w(f8849a, "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            }
            return 0;
        } catch (Exception unused2) {
            Log.w(f8849a, "Could not get EXIF orientation of image");
            return 0;
        }
    }

    public final Point c0(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                return new Point(((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue(), ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue());
            } catch (Exception unused) {
            }
        }
        return new Point(2048, 2048);
    }

    public final synchronized void d0(Point point) {
        h hVar = new h(0.0f, new PointF(0.0f, 0.0f), null);
        this.o5 = hVar;
        a0(true, hVar);
        int iO = O(this.o5.f8887a);
        this.k = iO;
        if (iO > 1) {
            this.k = iO / 2;
        }
        if (this.k != 1 || this.K != null || u0() >= point.x || t0() >= point.y) {
            e0(point);
            Iterator<i> it = this.l.get(Integer.valueOf(this.k)).iterator();
            while (it.hasNext()) {
                X(new j(this, this.R, it.next()));
            }
            q0(true);
        } else {
            this.R.recycle();
            this.R = null;
            X(new e(this, getContext(), this.T, this.j, false));
        }
    }

    public final void e0(Point point) {
        this.l = new LinkedHashMap();
        int i2 = this.k;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int iU0 = u0() / i4;
            int iT0 = t0() / i5;
            int i6 = iU0 / i2;
            int i7 = iT0 / i2;
            while (true) {
                if (i6 + i4 + i3 <= point.x && (i6 <= ((double) getWidth()) * 1.25d || i2 >= this.k)) {
                    break;
                }
                i4++;
                iU0 = u0() / i4;
                i6 = iU0 / i2;
            }
            while (true) {
                if (i7 + i5 + i3 <= point.y && (i7 <= ((double) getHeight()) * 1.25d || i2 >= this.k)) {
                    break;
                }
                i5++;
                iT0 = t0() / i5;
                i7 = iT0 / i2;
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    i iVar = new i(null);
                    iVar.f8890b = i2;
                    iVar.f8893e = i2 == this.k;
                    iVar.f8889a = new Rect(i8 * iU0, i9 * iT0, i8 == i4 + (-1) ? u0() : (i8 + 1) * iU0, i9 == i5 + (-1) ? t0() : (i9 + 1) * iT0);
                    iVar.f8894f = new Rect(0, 0, 0, 0);
                    iVar.f8895g = new Rect(iVar.f8889a);
                    arrayList.add(iVar);
                    i9++;
                }
                i8++;
            }
            this.l.put(Integer.valueOf(i2), arrayList);
            i3 = 1;
            if (i2 == 1) {
                return;
            } else {
                i2 /= 2;
            }
        }
    }

    public final boolean f0() {
        boolean z = true;
        if (this.f8855g != null && !this.f8856h) {
            return true;
        }
        Map<Integer, List<i>> map = this.l;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.k) {
                for (i iVar : entry.getValue()) {
                    if (iVar.f8892d || iVar.f8891c == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public final PointF g0(float f2, float f3, float f4, PointF pointF) {
        PointF pointFA0 = A0(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - pointFA0.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - pointFA0.y) / f4);
        return pointF;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.o;
    }

    public final float getMinScale() {
        return i0();
    }

    public final int getOrientation() {
        return this.n;
    }

    public final int getSHeight() {
        return this.I;
    }

    public final int getSWidth() {
        return this.H;
    }

    public final float getScale() {
        return this.A;
    }

    public final c.g.a.a.b getState() {
        if (this.C == null || this.H <= 0 || this.I <= 0) {
            return null;
        }
        return new c.g.a.a.b(getScale(), getCenter(), getOrientation());
    }

    public final float h0(float f2) {
        return Math.min(this.o, Math.max(i0(), f2));
    }

    public final float i0() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i2 = this.s;
        if (i2 == 2) {
            return Math.max((getWidth() - paddingLeft) / u0(), (getHeight() - paddingBottom) / t0());
        }
        if (i2 == 3) {
            float f2 = this.p;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / u0(), (getHeight() - paddingBottom) / t0());
    }

    public final boolean isImageLoaded() {
        return this.W2;
    }

    public final boolean isPanEnabled() {
        return this.u;
    }

    public final boolean isQuickScaleEnabled() {
        return this.w;
    }

    public final boolean isReady() {
        return this.A2;
    }

    public final boolean isZoomEnabled() {
        return this.v;
    }

    public void j0() {
    }

    public final synchronized void k0(Bitmap bitmap, int i2, boolean z) {
        int i3 = this.H;
        if (i3 > 0 && this.I > 0 && (i3 != bitmap.getWidth() || this.I != bitmap.getHeight())) {
            r0(false);
        }
        Bitmap bitmap2 = this.f8855g;
        if (bitmap2 != null && !this.f8857i) {
            bitmap2.recycle();
        }
        this.f8856h = false;
        this.f8857i = z;
        this.f8855g = bitmap;
        this.H = bitmap.getWidth();
        this.I = bitmap.getHeight();
        this.J = i2;
        boolean zQ = Q();
        boolean zP = P();
        if (zQ || zP) {
            invalidate();
            requestLayout();
        }
    }

    public final synchronized void l0(Bitmap bitmap) {
        if (this.f8855g == null && !this.W2) {
            Rect rect = this.L;
            if (rect != null) {
                this.f8855g = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.L.height());
            } else {
                this.f8855g = bitmap;
            }
            this.f8856h = true;
            if (Q()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    public void m0() {
    }

    public final synchronized void n0() {
        Bitmap bitmap;
        Q();
        P();
        if (f0() && (bitmap = this.f8855g) != null) {
            if (!this.f8857i) {
                bitmap.recycle();
            }
            this.f8855g = null;
            this.f8856h = false;
            this.f8857i = false;
        }
        invalidate();
    }

    public final synchronized void o0(c.g.a.a.c.d dVar, int i2, int i3, int i4) {
        int i5;
        int i6 = this.H;
        if (i6 > 0 && (i5 = this.I) > 0 && (i6 != i2 || i5 != i3)) {
            r0(false);
            Bitmap bitmap = this.f8855g;
            if (bitmap != null) {
                if (!this.f8857i) {
                    bitmap.recycle();
                }
                this.f8855g = null;
                this.f8856h = false;
                this.f8857i = false;
            }
        }
        this.R = dVar;
        this.H = i2;
        this.I = i3;
        this.J = i4;
        Q();
        P();
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float height;
        super.onDraw(canvas);
        R();
        if (this.H == 0 || this.I == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.l == null && this.R != null) {
            d0(c0(canvas));
        }
        if (Q()) {
            p0();
            if (this.C1 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.C1.k;
                boolean z = jCurrentTimeMillis > this.C1.f8869h;
                long jMin = Math.min(jCurrentTimeMillis, this.C1.f8869h);
                this.A = U(this.C1.j, jMin, this.C1.f8862a, this.C1.f8863b - this.C1.f8862a, this.C1.f8869h);
                float fU = U(this.C1.j, jMin, this.C1.f8867f.x, this.C1.f8868g.x - this.C1.f8867f.x, this.C1.f8869h);
                float fU2 = U(this.C1.j, jMin, this.C1.f8867f.y, this.C1.f8868g.y - this.C1.f8867f.y, this.C1.f8869h);
                this.C.x -= x0(this.C1.f8865d.x) - fU;
                this.C.y -= y0(this.C1.f8865d.y) - fU2;
                Z(z || this.C1.f8862a == this.C1.f8863b);
                q0(z);
                if (z) {
                    if (this.C1.l != null) {
                        try {
                            this.C1.l.onComplete();
                        } catch (Exception e2) {
                            Log.w(f8849a, "Error thrown by animation listener", e2);
                        }
                    }
                    this.C1 = null;
                }
                invalidate();
            }
            if (this.l == null || !f0()) {
                if (this.f8855g != null) {
                    float width = this.A;
                    if (this.f8856h) {
                        width *= this.H / r0.getWidth();
                        height = this.A * (this.I / this.f8855g.getHeight());
                    } else {
                        height = width;
                    }
                    if (this.p5 == null) {
                        this.p5 = new Matrix();
                    }
                    this.p5.reset();
                    this.p5.postScale(width, height);
                    this.p5.postRotate(getRequiredRotation());
                    Matrix matrix = this.p5;
                    PointF pointF = this.C;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.p5;
                        float f2 = this.A;
                        matrix2.postTranslate(this.H * f2, f2 * this.I);
                    } else if (getRequiredRotation() == 90) {
                        this.p5.postTranslate(this.A * this.I, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.p5.postTranslate(0.0f, this.A * this.H);
                    }
                    if (this.n5 != null) {
                        if (this.q5 == null) {
                            this.q5 = new RectF();
                        }
                        this.q5.set(0.0f, 0.0f, this.H, this.I);
                        this.p5.mapRect(this.q5);
                        canvas.drawRect(this.q5, this.n5);
                    }
                    canvas.drawBitmap(this.f8855g, this.p5, this.l5);
                    return;
                }
                return;
            }
            int iMin = Math.min(this.k, O(this.A));
            boolean z2 = false;
            for (Map.Entry<Integer, List<i>> entry : this.l.entrySet()) {
                if (entry.getKey().intValue() == iMin) {
                    for (i iVar : entry.getValue()) {
                        if (iVar.f8893e && (iVar.f8892d || iVar.f8891c == null)) {
                            z2 = true;
                        }
                    }
                }
            }
            for (Map.Entry<Integer, List<i>> entry2 : this.l.entrySet()) {
                if (entry2.getKey().intValue() == iMin || z2) {
                    for (i iVar2 : entry2.getValue()) {
                        w0(iVar2.f8889a, iVar2.f8894f);
                        if (!iVar2.f8892d && iVar2.f8891c != null) {
                            if (this.n5 != null) {
                                canvas.drawRect(iVar2.f8894f, this.n5);
                            }
                            if (this.p5 == null) {
                                this.p5 = new Matrix();
                            }
                            this.p5.reset();
                            v0(this.r5, 0.0f, 0.0f, iVar2.f8891c.getWidth(), 0.0f, iVar2.f8891c.getWidth(), iVar2.f8891c.getHeight(), 0.0f, iVar2.f8891c.getHeight());
                            if (getRequiredRotation() == 0) {
                                v0(this.s5, iVar2.f8894f.left, iVar2.f8894f.top, iVar2.f8894f.right, iVar2.f8894f.top, iVar2.f8894f.right, iVar2.f8894f.bottom, iVar2.f8894f.left, iVar2.f8894f.bottom);
                            } else if (getRequiredRotation() == 90) {
                                v0(this.s5, iVar2.f8894f.right, iVar2.f8894f.top, iVar2.f8894f.right, iVar2.f8894f.bottom, iVar2.f8894f.left, iVar2.f8894f.bottom, iVar2.f8894f.left, iVar2.f8894f.top);
                            } else if (getRequiredRotation() == 180) {
                                v0(this.s5, iVar2.f8894f.right, iVar2.f8894f.bottom, iVar2.f8894f.left, iVar2.f8894f.bottom, iVar2.f8894f.left, iVar2.f8894f.top, iVar2.f8894f.right, iVar2.f8894f.top);
                            } else if (getRequiredRotation() == 270) {
                                v0(this.s5, iVar2.f8894f.left, iVar2.f8894f.bottom, iVar2.f8894f.left, iVar2.f8894f.top, iVar2.f8894f.right, iVar2.f8894f.top, iVar2.f8894f.right, iVar2.f8894f.bottom);
                            }
                            this.p5.setPolyToPoly(this.r5, 0, this.s5, 0, 4);
                            canvas.drawBitmap(iVar2.f8891c, this.p5, this.l5);
                            if (this.m) {
                                canvas.drawRect(iVar2.f8894f, this.m5);
                            }
                        } else if (iVar2.f8892d && this.m) {
                            canvas.drawText("LOADING", iVar2.f8894f.left + 5, iVar2.f8894f.top + 35, this.m5);
                        }
                        if (iVar2.f8893e && this.m) {
                            canvas.drawText("ISS " + iVar2.f8890b + " RECT " + iVar2.f8889a.top + "," + iVar2.f8889a.left + "," + iVar2.f8889a.bottom + "," + iVar2.f8889a.right, iVar2.f8894f.left + 5, iVar2.f8894f.top + 15, this.m5);
                        }
                    }
                }
            }
            if (this.m) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.A)));
                canvas.drawText(sb.toString(), 5.0f, 15.0f, this.m5);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.C.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.C.y)), 5.0f, 35.0f, this.m5);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.m5);
                c cVar = this.C1;
                if (cVar != null) {
                    PointF pointFSourceToViewCoord = sourceToViewCoord(cVar.f8864c);
                    PointF pointFSourceToViewCoord2 = sourceToViewCoord(this.C1.f8866e);
                    PointF pointFSourceToViewCoord3 = sourceToViewCoord(this.C1.f8865d);
                    canvas.drawCircle(pointFSourceToViewCoord.x, pointFSourceToViewCoord.y, 10.0f, this.m5);
                    canvas.drawCircle(pointFSourceToViewCoord2.x, pointFSourceToViewCoord2.y, 20.0f, this.m5);
                    canvas.drawCircle(pointFSourceToViewCoord3.x, pointFSourceToViewCoord3.y, 25.0f, this.m5);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.m5);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.H > 0 && this.I > 0) {
            if (z && z2) {
                size = u0();
                size2 = t0();
            } else if (z2) {
                size2 = (int) ((((double) t0()) / ((double) u0())) * ((double) size));
            } else if (z) {
                size = (int) ((((double) u0()) / ((double) t0())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        PointF center = getCenter();
        if (!this.A2 || center == null) {
            return;
        }
        this.C1 = null;
        this.E = Float.valueOf(this.A);
        this.F = center;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
    
        if (r5 != 262) goto L136;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 1082
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p0() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.H <= 0 || this.I <= 0) {
            return;
        }
        if (this.F != null && (f2 = this.E) != null) {
            this.A = f2.floatValue();
            if (this.C == null) {
                this.C = new PointF();
            }
            this.C.x = (getWidth() / 2) - (this.A * this.F.x);
            this.C.y = (getHeight() / 2) - (this.A * this.F.y);
            this.F = null;
            this.E = null;
            Z(true);
            q0(true);
        }
        Z(false);
    }

    public final void q0(boolean z) {
        if (this.R == null || this.l == null) {
            return;
        }
        int iMin = Math.min(this.k, O(this.A));
        Iterator<Map.Entry<Integer, List<i>>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            for (i iVar : it.next().getValue()) {
                if (iVar.f8890b < iMin || (iVar.f8890b > iMin && iVar.f8890b != this.k)) {
                    iVar.f8893e = false;
                    if (iVar.f8891c != null) {
                        iVar.f8891c.recycle();
                        iVar.f8891c = null;
                    }
                }
                if (iVar.f8890b == iMin) {
                    if (z0(iVar)) {
                        iVar.f8893e = true;
                        if (!iVar.f8892d && iVar.f8891c == null && z) {
                            X(new j(this, this.R, iVar));
                        }
                    } else if (iVar.f8890b != this.k) {
                        iVar.f8893e = false;
                        if (iVar.f8891c != null) {
                            iVar.f8891c.recycle();
                            iVar.f8891c = null;
                        }
                    }
                } else if (iVar.f8890b == this.k) {
                    iVar.f8893e = true;
                }
            }
        }
    }

    public final void r0(boolean z) {
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = null;
        this.D = null;
        this.E = Float.valueOf(0.0f);
        this.F = null;
        this.G = null;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.k = 0;
        this.V = null;
        this.W = 0.0f;
        this.A0 = null;
        this.C0 = 0.0f;
        this.c1 = null;
        this.A1 = false;
        this.C1 = null;
        this.o5 = null;
        this.p5 = null;
        this.q5 = null;
        if (z) {
            this.j = null;
            if (this.R != null) {
                synchronized (this.S) {
                    this.R.recycle();
                    this.R = null;
                }
            }
            Bitmap bitmap = this.f8855g;
            if (bitmap != null && !this.f8857i) {
                bitmap.recycle();
            }
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = null;
            this.L = null;
            this.A2 = false;
            this.W2 = false;
            this.f8855g = null;
            this.f8856h = false;
            this.f8857i = false;
        }
        Map<Integer, List<i>> map = this.l;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<i>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (i iVar : it.next().getValue()) {
                    iVar.f8893e = false;
                    if (iVar.f8891c != null) {
                        iVar.f8891c.recycle();
                        iVar.f8891c = null;
                    }
                }
            }
            this.l = null;
        }
        setGestureDetector(getContext());
    }

    public void recycle() {
        r0(true);
        this.l5 = null;
        this.m5 = null;
        this.n5 = null;
    }

    public final void resetScaleAndCenter() {
        this.C1 = null;
        this.E = Float.valueOf(h0(0.0f));
        if (isReady()) {
            this.F = new PointF(u0() / 2, t0() / 2);
        } else {
            this.F = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void s0(c.g.a.a.b bVar) {
        if (bVar == null || bVar.getCenter() == null || !f8850b.contains(Integer.valueOf(bVar.getOrientation()))) {
            return;
        }
        this.n = bVar.getOrientation();
        this.E = Float.valueOf(bVar.getScale());
        this.F = bVar.getCenter();
        invalidate();
    }

    public final void setBitmapDecoderClass(Class<? extends c.g.a.a.c.c> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.T = new c.g.a.a.c.a(cls);
    }

    public final void setBitmapDecoderFactory(c.g.a.a.c.b<? extends c.g.a.a.c.c> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.T = bVar;
    }

    public final void setDebug(boolean z) {
        this.m = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.z = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.x = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (f8851c.contains(Integer.valueOf(i2))) {
            this.y = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i2);
    }

    public final void setImage(c.g.a.a.a aVar) {
        setImage(aVar, null, null);
    }

    public final void setMaxScale(float f2) {
        this.o = f2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.p = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinimumScaleType(int i2) {
        if (!f8854f.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid scale type: " + i2);
        }
        this.s = i2;
        if (isReady()) {
            Z(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f8858q = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (isReady()) {
            r0(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(g gVar) {
        this.A3 = gVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.A4 = onLongClickListener;
    }

    public final void setOrientation(int i2) {
        if (!f8850b.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid orientation: " + i2);
        }
        this.n = i2;
        r0(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.u = z;
        if (z || (pointF = this.C) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.A * (u0() / 2));
        this.C.y = (getHeight() / 2) - (this.A * (t0() / 2));
        if (isReady()) {
            q0(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i2) {
        if (!f8853e.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i2);
        }
        this.r = i2;
        if (isReady()) {
            Z(true);
            invalidate();
        }
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.t = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.w = z;
    }

    public final void setRegionDecoderClass(Class<? extends c.g.a.a.c.d> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.U = new c.g.a.a.c.a(cls);
    }

    public final void setRegionDecoderFactory(c.g.a.a.c.b<? extends c.g.a.a.c.d> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.U = bVar;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.C1 = null;
        this.E = Float.valueOf(f2);
        this.F = pointF;
        this.G = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.n5 = null;
        } else {
            Paint paint = new Paint();
            this.n5 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.n5.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.v = z;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final int t0() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.H : this.I;
    }

    public final int u0() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.I : this.H;
    }

    public final void v0(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final Rect w0(Rect rect, Rect rect2) {
        rect2.set((int) x0(rect.left), (int) y0(rect.top), (int) x0(rect.right), (int) y0(rect.bottom));
        return rect2;
    }

    public final float x0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.A) + pointF.x;
    }

    public final float y0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.A) + pointF.y;
    }

    public final boolean z0(i iVar) {
        return B0(0.0f) <= ((float) iVar.f8889a.right) && ((float) iVar.f8889a.left) <= B0((float) getWidth()) && C0(0.0f) <= ((float) iVar.f8889a.bottom) && ((float) iVar.f8889a.top) <= C0((float) getHeight());
    }

    public final void setImage(c.g.a.a.a aVar, c.g.a.a.b bVar) {
        setImage(aVar, null, bVar);
    }

    public final PointF sourceToViewCoord(float f2, float f3) {
        return sourceToViewCoord(f2, f3, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        return viewToSourceCoord(f2, f3, new PointF());
    }

    public final void setImage(c.g.a.a.a aVar, c.g.a.a.a aVar2) {
        setImage(aVar, aVar2, null);
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final void setImage(c.g.a.a.a aVar, c.g.a.a.a aVar2, c.g.a.a.b bVar) {
        Objects.requireNonNull(aVar, "imageSource must not be null");
        r0(true);
        if (bVar != null) {
            s0(bVar);
        }
        if (aVar2 != null) {
            if (aVar.a() == null) {
                if (aVar.e() > 0 && aVar.c() > 0) {
                    this.H = aVar.e();
                    this.I = aVar.c();
                    this.L = aVar2.d();
                    if (aVar2.a() != null) {
                        this.f8857i = aVar2.h();
                        l0(aVar2.a());
                    } else {
                        Uri uriG = aVar2.g();
                        if (uriG == null && aVar2.b() != null) {
                            uriG = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar2.b());
                        }
                        X(new e(this, getContext(), this.T, uriG, true));
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                }
            } else {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
        }
        if (aVar.a() != null && aVar.d() != null) {
            k0(Bitmap.createBitmap(aVar.a(), aVar.d().left, aVar.d().top, aVar.d().width(), aVar.d().height()), 0, false);
            return;
        }
        if (aVar.a() != null) {
            k0(aVar.a(), 0, aVar.h());
            return;
        }
        this.K = aVar.d();
        Uri uriG2 = aVar.g();
        this.j = uriG2;
        if (uriG2 == null && aVar.b() != null) {
            this.j = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar.b());
        }
        if (!aVar.f() && this.K == null) {
            X(new e(this, getContext(), this.T, this.j, false));
        } else {
            X(new k(this, getContext(), this.U, this.j));
        }
    }

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        if (this.C == null) {
            return null;
        }
        pointF.set(x0(f2), y0(f3));
        return pointF;
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        if (this.C == null) {
            return null;
        }
        pointF.set(B0(f2), C0(f3));
        return pointF;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PointF f8864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PointF f8865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PointF f8866e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PointF f8867f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PointF f8868g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f8869h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8870i;
        public int j;
        public long k;
        public f l;

        public c() {
            this.f8869h = 500L;
            this.f8870i = true;
            this.j = 2;
            this.k = System.currentTimeMillis();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
