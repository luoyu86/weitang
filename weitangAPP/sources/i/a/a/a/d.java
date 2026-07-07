package i.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class d implements i.a.a.a.c, View.OnTouchListener, i.a.a.a.e.e, ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f14887a = Log.isLoggable("PhotoViewAttacher", 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Interpolator f14888b = new AccelerateDecelerateInterpolator();
    public int A;
    public boolean B;
    public ImageView.ScaleType C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f14890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f14891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f14892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<ImageView> f14895i;
    public GestureDetector j;
    public i.a.a.a.e.d k;
    public final Matrix l;
    public final Matrix m;
    public final Matrix n;
    public final RectF o;
    public final float[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f14896q;
    public f r;
    public h s;
    public View.OnLongClickListener t;
    public g u;
    public int v;
    public int w;
    public int x;
    public int y;
    public RunnableC0270d z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.t != null) {
                d.this.t.onLongClick(d.this.getImageView());
            }
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14898a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f14898a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14898a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14898a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14898a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14898a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f14899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f14900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f14901c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f14902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f14903e;

        public c(float f2, float f3, float f4, float f5) {
            this.f14899a = f4;
            this.f14900b = f5;
            this.f14902d = f2;
            this.f14903e = f3;
        }

        public final float a() {
            return d.f14888b.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f14901c) * 1.0f) / d.this.f14889c));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.getImageView();
            if (imageView == null) {
                return;
            }
            float fA = a();
            float f2 = this.f14902d;
            d.this.onScale((f2 + ((this.f14903e - f2) * fA)) / d.this.getScale(), this.f14899a, this.f14900b);
            if (fA < 1.0f) {
                i.a.a.a.a.postOnAnimation(imageView, this);
            }
        }
    }

    /* JADX INFO: renamed from: i.a.a.a.d$d, reason: collision with other inner class name */
    public class RunnableC0270d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i.a.a.a.g.d f14905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14907c;

        public RunnableC0270d(Context context) {
            this.f14905a = i.a.a.a.g.d.getScroller(context);
        }

        public void cancelFling() {
            if (d.f14887a) {
                i.a.a.a.f.a.getLogger().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.f14905a.forceFinished(true);
        }

        public void fling(int i2, int i3, int i4, int i5) {
            int i6;
            int iRound;
            int i7;
            int iRound2;
            RectF displayRect = d.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int iRound3 = Math.round(-displayRect.left);
            float f2 = i2;
            if (f2 < displayRect.width()) {
                iRound = Math.round(displayRect.width() - f2);
                i6 = 0;
            } else {
                i6 = iRound3;
                iRound = i6;
            }
            int iRound4 = Math.round(-displayRect.top);
            float f3 = i3;
            if (f3 < displayRect.height()) {
                iRound2 = Math.round(displayRect.height() - f3);
                i7 = 0;
            } else {
                i7 = iRound4;
                iRound2 = i7;
            }
            this.f14906b = iRound3;
            this.f14907c = iRound4;
            if (d.f14887a) {
                i.a.a.a.f.a.getLogger().d("PhotoViewAttacher", "fling. StartX:" + iRound3 + " StartY:" + iRound4 + " MaxX:" + iRound + " MaxY:" + iRound2);
            }
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f14905a.fling(iRound3, iRound4, i4, i5, i6, iRound, i7, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            if (this.f14905a.isFinished() || (imageView = d.this.getImageView()) == null || !this.f14905a.computeScrollOffset()) {
                return;
            }
            int currX = this.f14905a.getCurrX();
            int currY = this.f14905a.getCurrY();
            if (d.f14887a) {
                i.a.a.a.f.a.getLogger().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.f14906b + " CurrentY:" + this.f14907c + " NewX:" + currX + " NewY:" + currY);
            }
            d.this.n.postTranslate(this.f14906b - currX, this.f14907c - currY);
            d dVar = d.this;
            dVar.q(dVar.getDrawMatrix());
            this.f14906b = currX;
            this.f14907c = currY;
            i.a.a.a.a.postOnAnimation(imageView, this);
        }
    }

    public interface e {
        void onMatrixChanged(RectF rectF);
    }

    public interface f {
        void onPhotoTap(View view, float f2, float f3);
    }

    public interface g {
        void onScaleChange(float f2, float f3, float f4);
    }

    public interface h {
        void onViewTap(View view, float f2, float f3);
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    public static void i(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    public static boolean n(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    public static boolean o(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.f14898a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    public static void r(ImageView imageView) {
        if (imageView == null || (imageView instanceof i.a.a.a.c) || ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // i.a.a.a.c
    public boolean canZoom() {
        return this.B;
    }

    public void cleanup() {
        WeakReference<ImageView> weakReference = this.f14895i;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            e();
        }
        GestureDetector gestureDetector = this.j;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.f14896q = null;
        this.r = null;
        this.s = null;
        this.f14895i = null;
    }

    public final void e() {
        RunnableC0270d runnableC0270d = this.z;
        if (runnableC0270d != null) {
            runnableC0270d.cancelFling();
            this.z = null;
        }
    }

    public final void f() {
        if (h()) {
            q(getDrawMatrix());
        }
    }

    public final void g() {
        ImageView imageView = getImageView();
        if (imageView != null && !(imageView instanceof i.a.a.a.c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    @Override // i.a.a.a.c
    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    @Override // i.a.a.a.c
    public RectF getDisplayRect() {
        h();
        return j(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.m.set(this.l);
        this.m.postConcat(this.n);
        return this.m;
    }

    @Override // i.a.a.a.c
    public i.a.a.a.c getIPhotoViewImplementation() {
        return this;
    }

    public ImageView getImageView() {
        WeakReference<ImageView> weakReference = this.f14895i;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            cleanup();
            i.a.a.a.f.a.getLogger().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    @Override // i.a.a.a.c
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // i.a.a.a.c
    public float getMaximumScale() {
        return this.f14892f;
    }

    @Override // i.a.a.a.c
    public float getMediumScale() {
        return this.f14891e;
    }

    @Override // i.a.a.a.c
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // i.a.a.a.c
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // i.a.a.a.c
    public float getMinimumScale() {
        return this.f14890d;
    }

    @Override // i.a.a.a.c
    public f getOnPhotoTapListener() {
        return this.r;
    }

    @Override // i.a.a.a.c
    public h getOnViewTapListener() {
        return this.s;
    }

    @Override // i.a.a.a.c
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(m(this.n, 0), 2.0d)) + ((float) Math.pow(m(this.n, 3), 2.0d)));
    }

    @Override // i.a.a.a.c
    public ImageView.ScaleType getScaleType() {
        return this.C;
    }

    @Override // i.a.a.a.c
    public Bitmap getVisibleRectangleBitmap() {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawingCache();
    }

    public final boolean h() {
        RectF rectFJ;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        ImageView imageView = getImageView();
        if (imageView == null || (rectFJ = j(getDrawMatrix())) == null) {
            return false;
        }
        float fHeight = rectFJ.height();
        float fWidth = rectFJ.width();
        float fK = k(imageView);
        float f8 = 0.0f;
        if (fHeight <= fK) {
            int i2 = b.f14898a[this.C.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    fK = (fK - fHeight) / 2.0f;
                    f3 = rectFJ.top;
                } else {
                    fK -= fHeight;
                    f3 = rectFJ.top;
                }
            } else {
                f2 = rectFJ.top;
                f4 = -f2;
            }
        } else {
            f2 = rectFJ.top;
            if (f2 > 0.0f) {
                f4 = -f2;
            } else {
                f3 = rectFJ.bottom;
                f4 = f3 < fK ? fK - f3 : 0.0f;
            }
        }
        float fL = l(imageView);
        if (fWidth <= fL) {
            int i3 = b.f14898a[this.C.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f6 = (fL - fWidth) / 2.0f;
                    f7 = rectFJ.left;
                } else {
                    f6 = fL - fWidth;
                    f7 = rectFJ.left;
                }
                f5 = f6 - f7;
            } else {
                f5 = -rectFJ.left;
            }
            f8 = f5;
            this.A = 2;
        } else {
            float f9 = rectFJ.left;
            if (f9 > 0.0f) {
                this.A = 0;
                f8 = -f9;
            } else {
                float f10 = rectFJ.right;
                if (f10 < fL) {
                    f8 = fL - f10;
                    this.A = 1;
                } else {
                    this.A = -1;
                }
            }
        }
        this.n.postTranslate(f8, f4);
        return true;
    }

    public final RectF j(Matrix matrix) {
        Drawable drawable;
        ImageView imageView = getImageView();
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return null;
        }
        this.o.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.o);
        return this.o;
    }

    public final int k(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int l(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final float m(Matrix matrix, int i2) {
        matrix.getValues(this.p);
        return this.p[i2];
    }

    @Override // i.a.a.a.e.e
    public void onDrag(float f2, float f3) {
        if (this.k.isScaling()) {
            return;
        }
        if (f14887a) {
            i.a.a.a.f.a.getLogger().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
        }
        ImageView imageView = getImageView();
        this.n.postTranslate(f2, f3);
        f();
        ViewParent parent = imageView.getParent();
        if (!this.f14893g || this.k.isScaling() || this.f14894h) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i2 = this.A;
        if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (i2 == 1 && f2 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // i.a.a.a.e.e
    public void onFling(float f2, float f3, float f4, float f5) {
        if (f14887a) {
            i.a.a.a.f.a.getLogger().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView imageView = getImageView();
        RunnableC0270d runnableC0270d = new RunnableC0270d(imageView.getContext());
        this.z = runnableC0270d;
        runnableC0270d.fling(l(imageView), k(imageView), (int) f4, (int) f5);
        imageView.post(this.z);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (!this.B) {
                s(imageView.getDrawable());
                return;
            }
            int top = imageView.getTop();
            int right = imageView.getRight();
            int bottom = imageView.getBottom();
            int left = imageView.getLeft();
            if (top == this.v && bottom == this.x && left == this.y && right == this.w) {
                return;
            }
            s(imageView.getDrawable());
            this.v = top;
            this.w = right;
            this.x = bottom;
            this.y = left;
        }
    }

    @Override // i.a.a.a.e.e
    public void onScale(float f2, float f3, float f4) {
        if (f14887a) {
            i.a.a.a.f.a.getLogger().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.f14892f || f2 < 1.0f) {
            g gVar = this.u;
            if (gVar != null) {
                gVar.onScaleChange(f2, f3, f4);
            }
            this.n.postScale(f2, f2, f3, f4);
            f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.B
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = n(r0)
            if (r0 == 0) goto La1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L49
            if (r3 == r2) goto L1f
            r0 = 3
            if (r3 == r0) goto L1f
            goto L5d
        L1f:
            float r0 = r10.getScale()
            float r3 = r10.f14890d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L5d
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L5d
            i.a.a.a.d$c r9 = new i.a.a.a.d$c
            float r5 = r10.getScale()
            float r6 = r10.f14890d
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = 1
            goto L5e
        L49:
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L5a
        L4f:
            i.a.a.a.f.b r11 = i.a.a.a.f.a.getLogger()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.i(r0, r3)
        L5a:
            r10.e()
        L5d:
            r11 = 0
        L5e:
            i.a.a.a.e.d r0 = r10.k
            if (r0 == 0) goto L95
            boolean r11 = r0.isScaling()
            i.a.a.a.e.d r0 = r10.k
            boolean r0 = r0.isDragging()
            i.a.a.a.e.d r3 = r10.k
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L7e
            i.a.a.a.e.d r11 = r10.k
            boolean r11 = r11.isScaling()
            if (r11 != 0) goto L7e
            r11 = 1
            goto L7f
        L7e:
            r11 = 0
        L7f:
            if (r0 != 0) goto L8b
            i.a.a.a.e.d r0 = r10.k
            boolean r0 = r0.isDragging()
            if (r0 != 0) goto L8b
            r0 = 1
            goto L8c
        L8b:
            r0 = 0
        L8c:
            if (r11 == 0) goto L91
            if (r0 == 0) goto L91
            r1 = 1
        L91:
            r10.f14894h = r1
            r1 = r3
            goto L96
        L95:
            r1 = r11
        L96:
            android.view.GestureDetector r11 = r10.j
            if (r11 == 0) goto La1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto La1
            r1 = 1
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.a.a.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void p() {
        this.n.reset();
        q(getDrawMatrix());
        h();
    }

    public final void q(Matrix matrix) {
        RectF rectFJ;
        ImageView imageView = getImageView();
        if (imageView != null) {
            g();
            imageView.setImageMatrix(matrix);
            if (this.f14896q == null || (rectFJ = j(matrix)) == null) {
                return;
            }
            this.f14896q.onMatrixChanged(rectFJ);
        }
    }

    public final void s(Drawable drawable) {
        ImageView imageView = getImageView();
        if (imageView == null || drawable == null) {
            return;
        }
        float fL = l(imageView);
        float fK = k(imageView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.l.reset();
        float f2 = intrinsicWidth;
        float f3 = fL / f2;
        float f4 = intrinsicHeight;
        float f5 = fK / f4;
        ImageView.ScaleType scaleType = this.C;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.l.postTranslate((fL - f2) / 2.0f, (fK - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.l.postScale(fMax, fMax);
            this.l.postTranslate((fL - (f2 * fMax)) / 2.0f, (fK - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.l.postScale(fMin, fMin);
            this.l.postTranslate((fL - (f2 * fMin)) / 2.0f, (fK - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fL, fK);
            int i2 = b.f14898a[this.C.ordinal()];
            if (i2 == 2) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 3) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 4) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 5) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        p();
    }

    @Override // i.a.a.a.c
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f14893g = z;
    }

    @Override // i.a.a.a.c
    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        ImageView imageView = getImageView();
        if (imageView == null || imageView.getDrawable() == null) {
            return false;
        }
        this.n.set(matrix);
        q(getDrawMatrix());
        h();
        return true;
    }

    @Override // i.a.a.a.c
    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    @Override // i.a.a.a.c
    public void setMaximumScale(float f2) {
        i(this.f14890d, this.f14891e, f2);
        this.f14892f = f2;
    }

    @Override // i.a.a.a.c
    public void setMediumScale(float f2) {
        i(this.f14890d, f2, this.f14892f);
        this.f14891e = f2;
    }

    @Override // i.a.a.a.c
    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    @Override // i.a.a.a.c
    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    @Override // i.a.a.a.c
    public void setMinimumScale(float f2) {
        i(f2, this.f14891e, this.f14892f);
        this.f14890d = f2;
    }

    @Override // i.a.a.a.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.j.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.j.setOnDoubleTapListener(new i.a.a.a.b(this));
        }
    }

    @Override // i.a.a.a.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.t = onLongClickListener;
    }

    @Override // i.a.a.a.c
    public void setOnMatrixChangeListener(e eVar) {
        this.f14896q = eVar;
    }

    @Override // i.a.a.a.c
    public void setOnPhotoTapListener(f fVar) {
        this.r = fVar;
    }

    @Override // i.a.a.a.c
    public void setOnScaleChangeListener(g gVar) {
        this.u = gVar;
    }

    @Override // i.a.a.a.c
    public void setOnViewTapListener(h hVar) {
        this.s = hVar;
    }

    @Override // i.a.a.a.c
    public void setPhotoViewRotation(float f2) {
        this.n.setRotate(f2 % 360.0f);
        f();
    }

    @Override // i.a.a.a.c
    public void setRotationBy(float f2) {
        this.n.postRotate(f2 % 360.0f);
        f();
    }

    @Override // i.a.a.a.c
    public void setRotationTo(float f2) {
        this.n.setRotate(f2 % 360.0f);
        f();
    }

    @Override // i.a.a.a.c
    public void setScale(float f2) {
        setScale(f2, false);
    }

    @Override // i.a.a.a.c
    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.f14890d = f2;
        this.f14891e = f3;
        this.f14892f = f4;
    }

    @Override // i.a.a.a.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!o(scaleType) || scaleType == this.C) {
            return;
        }
        this.C = scaleType;
        update();
    }

    @Override // i.a.a.a.c
    public void setZoomTransitionDuration(int i2) {
        if (i2 < 0) {
            i2 = 200;
        }
        this.f14889c = i2;
    }

    @Override // i.a.a.a.c
    public void setZoomable(boolean z) {
        this.B = z;
        update();
    }

    public void update() {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (!this.B) {
                p();
            } else {
                r(imageView);
                s(imageView.getDrawable());
            }
        }
    }

    public d(ImageView imageView, boolean z) {
        this.f14889c = 200;
        this.f14890d = 1.0f;
        this.f14891e = 1.75f;
        this.f14892f = 3.0f;
        this.f14893g = true;
        this.f14894h = false;
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new Matrix();
        this.o = new RectF();
        this.p = new float[9];
        this.A = 2;
        this.C = ImageView.ScaleType.FIT_CENTER;
        this.f14895i = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        r(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.k = i.a.a.a.e.f.newInstance(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
        this.j = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new i.a.a.a.b(this));
        setZoomable(z);
    }

    @Override // i.a.a.a.c
    public void setScale(float f2, boolean z) {
        if (getImageView() != null) {
            setScale(f2, r0.getRight() / 2, r0.getBottom() / 2, z);
        }
    }

    @Override // i.a.a.a.c
    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (f2 < this.f14890d || f2 > this.f14892f) {
                i.a.a.a.f.a.getLogger().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                imageView.post(new c(getScale(), f2, f3, f4));
            } else {
                this.n.setScale(f2, f2, f3, f4);
                f();
            }
        }
    }
}
