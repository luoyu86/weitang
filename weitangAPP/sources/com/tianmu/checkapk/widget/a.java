package com.tianmu.checkapk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GestureDetector f11938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f11942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f11944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f11945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f11946i;
    private float j;
    private Handler k;
    private ObjectAnimator l;
    private boolean m;
    private boolean n;
    public int o;

    /* JADX INFO: renamed from: com.tianmu.checkapk.widget.a$a, reason: collision with other inner class name */
    public class C0215a extends com.tianmu.d.b.b {
        public C0215a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            a.this.a((int) (motionEvent2.getX() - motionEvent.getX()), (int) (motionEvent2.getY() - motionEvent.getY()));
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            a.this.f11946i = motionEvent.getX();
            a.this.j = motionEvent.getY();
            a.this.e();
            return true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c();
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11949a;

        public c(boolean z) {
            this.f11949a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.n = true;
            if (a.this.a() != null) {
                if (this.f11949a) {
                    a.this.a().b();
                } else {
                    a.this.a().c();
                }
            }
        }
    }

    public a(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f11939b = 3;
        h();
        d();
        a(true);
    }

    private void d() {
        this.f11942e = getX();
        float y = getY();
        this.f11943f = y;
        if (this.f11944g == -727272.0f && this.f11945h == -727272.0f) {
            this.f11944g = this.f11942e;
            this.f11945h = y;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (a() != null) {
            a().a();
        }
    }

    private void f() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.l = null;
        }
    }

    private void g() {
        h();
        this.k = null;
    }

    private void h() {
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void i() {
        if (this.k != null) {
            h();
            this.k.postDelayed(new b(), 10000L);
        }
    }

    private void j() {
        try {
            int i2 = this.f11939b;
            if (1 == i2 || 2 == i2) {
                this.l = ObjectAnimator.ofFloat(this, "translationX", 0.0f);
            } else {
                this.l = ObjectAnimator.ofFloat(this, "translationY", 0.0f);
            }
            this.l.setDuration(150L);
            this.l.start();
        } catch (Exception unused) {
        }
    }

    public abstract com.tianmu.d.b.a a();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(this.o, getMeasuredWidth()), WXVideoFileObject.FILE_SIZE_LIMIT), i3);
        this.f11940c = getMeasuredWidth();
        this.f11941d = getMeasuredHeight();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!this.m && this.n && 5 != actionMasked && 6 != actionMasked && 65280 != actionMasked && 8 != actionMasked && this.f11938a != null) {
            if (actionMasked == 0) {
                d();
                h();
            }
            this.f11938a.onTouchEvent(motionEvent);
            if (!this.m && (1 == actionMasked || 3 == actionMasked)) {
                motionEvent.getX();
                motionEvent.getY();
                a(false);
                this.f11939b = 0;
            }
        }
        return true;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11939b = 0;
        this.f11944g = -727272.0f;
        this.f11945h = -727272.0f;
        this.k = new Handler(Looper.getMainLooper());
        this.n = true;
        a(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.o = (Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) * 2) / 3;
    }

    public void b() {
        this.f11938a = null;
        g();
        f();
    }

    private void a(Context context) {
        this.f11938a = new GestureDetector(context, new C0215a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (this.f11939b == 0) {
            if (Math.abs(i2) > Math.abs(i3)) {
                this.f11939b = i2 > 0 ? 2 : 1;
            } else if (i3 < 0) {
                this.f11939b = 3;
            }
        }
        int i4 = this.f11939b;
        if (i4 != 0) {
            if (1 == i4 || 2 == i4) {
                i3 = 0;
            } else if (3 == i4) {
                i2 = 0;
            }
            setX(getX() + i2);
            setY(Math.min(getY() + i3, this.f11945h));
        }
    }

    private void b(boolean z) {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            try {
                this.n = false;
                objectAnimator.setDuration(150L);
                this.l.start();
                this.l.addListener(new c(z));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(boolean z) {
        if (this.f11939b == 0) {
            i();
            return;
        }
        f();
        int i2 = this.f11939b;
        if (1 == i2) {
            float x = getX() - this.f11942e;
            boolean z2 = z || Math.abs(x) >= ((float) this.f11940c) / 2.0f;
            this.m = z2;
            if (z2) {
                this.l = ObjectAnimator.ofFloat(this, "translationX", (x - this.f11944g) - this.f11940c);
            }
        } else if (2 == i2) {
            float x2 = getX() - this.f11942e;
            boolean z3 = z || Math.abs(x2) >= ((float) this.f11940c) / 2.0f;
            this.m = z3;
            if (z3) {
                this.l = ObjectAnimator.ofFloat(this, "translationX", x2, ((((ViewGroup) getParent()) == null ? getResources().getDisplayMetrics().widthPixels : r2.getWidth()) - this.f11944g) + this.f11940c);
            }
        } else if (3 == i2) {
            float y = getY() - this.f11943f;
            boolean z4 = z || Math.abs(y) >= ((float) this.f11941d) / 2.0f;
            this.m = z4;
            if (z4) {
                float[] fArr = new float[2];
                fArr[0] = y;
                fArr[1] = z4 ? (-this.f11945h) - this.f11941d : 0.0f;
                this.l = ObjectAnimator.ofFloat(this, "translationY", fArr);
            }
        }
        if (this.m && this.l != null) {
            b(z);
        } else {
            i();
            j();
        }
    }
}
