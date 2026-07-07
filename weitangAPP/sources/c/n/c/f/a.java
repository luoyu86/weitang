package c.n.c.f;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f2959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<View, a> f2960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f2961c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2963e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f2967i;
    public float j;
    public float k;
    public float n;
    public float o;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Camera f2962d = new Camera();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2964f = 1.0f;
    public float l = 1.0f;
    public float m = 1.0f;
    public final RectF p = new RectF();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f2968q = new RectF();
    public final Matrix r = new Matrix();

    static {
        f2959a = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f2960b = new WeakHashMap<>();
    }

    public a(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f2961c = new WeakReference<>(view);
    }

    public static a wrap(View view) {
        WeakHashMap<View, a> weakHashMap = f2960b;
        a aVar = weakHashMap.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        a aVar2 = new a(view);
        weakHashMap.put(view, aVar2);
        return aVar2;
    }

    public final void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.r;
        matrix.reset();
        d(matrix, view);
        this.r.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f2 = rectF.right;
        float f3 = rectF.left;
        if (f2 < f3) {
            rectF.right = f3;
            rectF.left = f2;
        }
        float f4 = rectF.bottom;
        float f5 = rectF.top;
        if (f4 < f5) {
            rectF.top = f4;
            rectF.bottom = f5;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        View view = this.f2961c.get();
        if (view != null) {
            transformation.setAlpha(this.f2964f);
            d(transformation.getMatrix(), view);
        }
    }

    public final void b() {
        View view = this.f2961c.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f2968q;
        a(rectF, view);
        rectF.union(this.p);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void c() {
        View view = this.f2961c.get();
        if (view != null) {
            a(this.p, view);
        }
    }

    public final void d(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f2963e;
        float f2 = z ? this.f2965g : width / 2.0f;
        float f3 = z ? this.f2966h : height / 2.0f;
        float f4 = this.f2967i;
        float f5 = this.j;
        float f6 = this.k;
        if (f4 != 0.0f || f5 != 0.0f || f6 != 0.0f) {
            Camera camera = this.f2962d;
            camera.save();
            camera.rotateX(f4);
            camera.rotateY(f5);
            camera.rotateZ(-f6);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }
        float f7 = this.l;
        float f8 = this.m;
        if (f7 != 1.0f || f8 != 1.0f) {
            matrix.postScale(f7, f8);
            matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
        }
        matrix.postTranslate(this.n, this.o);
    }

    public float getAlpha() {
        return this.f2964f;
    }

    public float getPivotX() {
        return this.f2965g;
    }

    public float getPivotY() {
        return this.f2966h;
    }

    public float getRotation() {
        return this.k;
    }

    public float getRotationX() {
        return this.f2967i;
    }

    public float getRotationY() {
        return this.j;
    }

    public float getScaleX() {
        return this.l;
    }

    public float getScaleY() {
        return this.m;
    }

    public int getScrollX() {
        View view = this.f2961c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = this.f2961c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.n;
    }

    public float getTranslationY() {
        return this.o;
    }

    public float getX() {
        if (this.f2961c.get() == null) {
            return 0.0f;
        }
        return r0.getLeft() + this.n;
    }

    public float getY() {
        if (this.f2961c.get() == null) {
            return 0.0f;
        }
        return r0.getTop() + this.o;
    }

    public void setAlpha(float f2) {
        if (this.f2964f != f2) {
            this.f2964f = f2;
            View view = this.f2961c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f2) {
        if (this.f2963e && this.f2965g == f2) {
            return;
        }
        c();
        this.f2963e = true;
        this.f2965g = f2;
        b();
    }

    public void setPivotY(float f2) {
        if (this.f2963e && this.f2966h == f2) {
            return;
        }
        c();
        this.f2963e = true;
        this.f2966h = f2;
        b();
    }

    public void setRotation(float f2) {
        if (this.k != f2) {
            c();
            this.k = f2;
            b();
        }
    }

    public void setRotationX(float f2) {
        if (this.f2967i != f2) {
            c();
            this.f2967i = f2;
            b();
        }
    }

    public void setRotationY(float f2) {
        if (this.j != f2) {
            c();
            this.j = f2;
            b();
        }
    }

    public void setScaleX(float f2) {
        if (this.l != f2) {
            c();
            this.l = f2;
            b();
        }
    }

    public void setScaleY(float f2) {
        if (this.m != f2) {
            c();
            this.m = f2;
            b();
        }
    }

    public void setScrollX(int i2) {
        View view = this.f2961c.get();
        if (view != null) {
            view.scrollTo(i2, view.getScrollY());
        }
    }

    public void setScrollY(int i2) {
        View view = this.f2961c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i2);
        }
    }

    public void setTranslationX(float f2) {
        if (this.n != f2) {
            c();
            this.n = f2;
            b();
        }
    }

    public void setTranslationY(float f2) {
        if (this.o != f2) {
            c();
            this.o = f2;
            b();
        }
    }

    public void setX(float f2) {
        if (this.f2961c.get() != null) {
            setTranslationX(f2 - r0.getLeft());
        }
    }

    public void setY(float f2) {
        if (this.f2961c.get() != null) {
            setTranslationY(f2 - r0.getTop());
        }
    }
}
