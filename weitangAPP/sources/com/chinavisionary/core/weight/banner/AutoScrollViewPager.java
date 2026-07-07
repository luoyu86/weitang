package com.chinavisionary.core.weight.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class AutoScrollViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6725a = c.e.a.a.a.getInstance().isDebug();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f6731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewParent f6732h;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AutoScrollViewPager f6733a;

        public a(AutoScrollViewPager autoScrollViewPager) {
            this.f6733a = autoScrollViewPager;
        }

        public void a(AutoScrollViewPager autoScrollViewPager) {
            this.f6733a = autoScrollViewPager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AutoScrollViewPager autoScrollViewPager;
            if (message.what == 4097 && (autoScrollViewPager = this.f6733a) != null) {
                autoScrollViewPager.b();
            }
        }
    }

    public static class b extends Scroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6734a;

        public b(Context context, int i2) {
            super(context);
            this.f6734a = 750;
            this.f6734a = i2;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            startScroll(i2, i3, i4, i5, this.f6734a);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, this.f6734a);
        }

        public b(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.f6734a = 750;
            this.f6734a = 750;
        }

        public b(Context context, Interpolator interpolator, boolean z) {
            super(context, interpolator, z);
            this.f6734a = 750;
            this.f6734a = 750;
        }
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6726b = false;
        this.f6729e = 5000L;
        this.f6730f = false;
        this.f6731g = new a(this);
        f(context, attributeSet);
    }

    public final void b() {
        if (getAdapter() == null || getAdapter().getCount() <= 1 || !this.f6730f) {
            return;
        }
        int currentItem = getCurrentItem();
        int count = getAdapter().getCount();
        if (currentItem < 0 || currentItem >= count - 1) {
            setCurrentItem(0, true);
        } else {
            setCurrentItem(currentItem + 1, true);
        }
        this.f6731g.sendEmptyMessageDelayed(4097, this.f6729e);
    }

    public final void c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof ViewPager) || (parent instanceof RecyclerView) || (parent instanceof ListView) || (parent instanceof ScrollView)) {
                this.f6732h = parent;
                return;
            }
        }
    }

    public final float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX();
        } catch (Throwable th) {
            if (!f6725a) {
                return 0.0f;
            }
            th.printStackTrace();
            return 0.0f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[Catch: Exception -> 0x0081, TryCatch #1 {Exception -> 0x0081, blocks: (B:8:0x0018, B:15:0x0026, B:17:0x002a, B:19:0x0038, B:20:0x003f, B:22:0x0051, B:23:0x005a, B:24:0x0060, B:26:0x0064, B:27:0x0068, B:29:0x006c), top: B:44:0x0018 }] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r1 = 3
            r2 = 0
            r3 = 1
            if (r0 != 0) goto Lf
            r6.f6726b = r3
            r6.i()
            goto L18
        Lf:
            if (r0 == r3) goto L13
            if (r0 != r1) goto L18
        L13:
            r6.f6726b = r2
            r6.h()
        L18:
            int r0 = r7.getAction()     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L68
            if (r0 == r3) goto L60
            r4 = 2
            if (r0 == r4) goto L26
            if (r0 == r1) goto L60
            goto L89
        L26:
            android.view.ViewParent r0 = r6.f6732h     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L89
            float r0 = r6.d(r7)     // Catch: java.lang.Exception -> L81
            float r1 = r6.e(r7)     // Catch: java.lang.Exception -> L81
            android.view.ViewParent r4 = r6.f6732h     // Catch: java.lang.Exception -> L81
            boolean r5 = r4 instanceof androidx.viewpager.widget.ViewPager     // Catch: java.lang.Exception -> L81
            if (r5 == 0) goto L3f
            r4.requestDisallowInterceptTouchEvent(r3)     // Catch: java.lang.Exception -> L81
            r6.setClickable(r3)     // Catch: java.lang.Exception -> L81
            goto L89
        L3f:
            float r4 = r6.f6727c     // Catch: java.lang.Exception -> L81
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)     // Catch: java.lang.Exception -> L81
            float r4 = r6.f6728d     // Catch: java.lang.Exception -> L81
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)     // Catch: java.lang.Exception -> L81
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L5a
            android.view.ViewParent r0 = r6.f6732h     // Catch: java.lang.Exception -> L81
            r0.requestDisallowInterceptTouchEvent(r3)     // Catch: java.lang.Exception -> L81
            r6.setClickable(r3)     // Catch: java.lang.Exception -> L81
            goto L89
        L5a:
            android.view.ViewParent r0 = r6.f6732h     // Catch: java.lang.Exception -> L81
            r0.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> L81
            goto L89
        L60:
            android.view.ViewParent r0 = r6.f6732h     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L89
            r0.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> L81
            goto L89
        L68:
            android.view.ViewParent r0 = r6.f6732h     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L89
            float r0 = r6.d(r7)     // Catch: java.lang.Exception -> L81
            r6.f6727c = r0     // Catch: java.lang.Exception -> L81
            float r0 = r6.e(r7)     // Catch: java.lang.Exception -> L81
            r6.f6728d = r0     // Catch: java.lang.Exception -> L81
            android.view.ViewParent r0 = r6.f6732h     // Catch: java.lang.Exception -> L81
            r0.requestDisallowInterceptTouchEvent(r3)     // Catch: java.lang.Exception -> L81
            r6.setClickable(r3)     // Catch: java.lang.Exception -> L81
            goto L89
        L81:
            r0 = move-exception
            boolean r1 = com.chinavisionary.core.weight.banner.AutoScrollViewPager.f6725a
            if (r1 == 0) goto L89
            r0.printStackTrace()
        L89:
            boolean r7 = super.dispatchTouchEvent(r7)     // Catch: java.lang.Throwable -> L8e
            return r7
        L8e:
            r7 = move-exception
            boolean r0 = com.chinavisionary.core.weight.banner.AutoScrollViewPager.f6725a
            if (r0 == 0) goto La3
            java.lang.String r0 = r7.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Banner"
            android.util.Log.e(r1, r0)
            r7.printStackTrace()
        La3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.weight.banner.AutoScrollViewPager.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY();
        } catch (Throwable th) {
            if (!f6725a) {
                return 0.0f;
            }
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void f(Context context, AttributeSet attributeSet) {
        g();
    }

    public final void g() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            declaredField.set(this, new b(getContext(), (Interpolator) declaredField2.get(null)));
        } catch (Exception e2) {
            if (f6725a) {
                e2.printStackTrace();
            }
        }
    }

    public final void h() {
        if (this.f6730f) {
            i();
            this.f6731g.sendEmptyMessageDelayed(4097, this.f6729e);
        }
    }

    public final void i() {
        this.f6731g.removeMessages(4097);
    }

    public boolean isTouched() {
        return this.f6726b;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        if (this.f6731g != null) {
            requestLayout();
            this.f6731g.a(this);
            if (getAdapter() == null || getAdapter().getCount() <= 1) {
                return;
            }
            startAutoScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f6732h = null;
        a aVar = this.f6731g;
        if (aVar != null) {
            aVar.a(null);
            this.f6731g.removeCallbacksAndMessages(null);
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void recyclerReference() {
        this.f6731g.removeCallbacksAndMessages(null);
        this.f6731g = null;
    }

    public void setAutoScrollInterval(long j) {
        this.f6729e = j;
    }

    public void startAutoScroll() {
        this.f6731g.a(this);
        this.f6730f = true;
        h();
    }

    public void stopAutoScroll() {
        this.f6731g.a(null);
        this.f6730f = false;
        i();
    }

    public AutoScrollViewPager(Context context) {
        super(context);
        this.f6726b = false;
        this.f6729e = 5000L;
        this.f6730f = false;
        this.f6731g = new a(this);
        f(context, null);
    }
}
