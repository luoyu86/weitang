package com.tianmu.c.j;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tianmu.c.f.u;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f11765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f11767c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f11769e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ViewTreeObserver.OnWindowFocusChangeListener f11772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11773i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Rect f11768d = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11770f = false;

    public class a implements ViewTreeObserver.OnWindowFocusChangeListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            if (z) {
                c.this.a();
            }
        }
    }

    public c(boolean z, boolean z2, d dVar) {
        this.f11766b = z;
        this.f11765a = dVar;
        f();
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f11772h = new a();
        }
    }

    private void g() {
        View view;
        if (!this.f11771g || (view = this.f11767c) == null || view.getViewTreeObserver() == null) {
            return;
        }
        try {
            a("停止曝光校验");
            this.f11767c.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f11772h != null && Build.VERSION.SDK_INT >= 18) {
                this.f11767c.getViewTreeObserver().removeOnWindowFocusChangeListener(this.f11772h);
            }
            this.f11771g = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        int i2;
        int i3;
        int i4;
        View view = this.f11767c;
        if (view != null) {
            if (view.getVisibility() != 0) {
                a("控件不可见");
                c();
                return;
            }
            if (this.f11766b && !this.f11767c.hasWindowFocus()) {
                a("控件没有WindowFocus");
                c();
                return;
            }
            int measuredWidth = this.f11767c.getMeasuredWidth();
            int measuredHeight = this.f11767c.getMeasuredHeight();
            if (measuredWidth < 30 || measuredHeight <= 30) {
                a("控件宽高小于最小宽高");
                c();
                return;
            }
            this.f11768d.set(0, 0, 0, 0);
            this.f11767c.getLocalVisibleRect(this.f11768d);
            Rect rect = this.f11768d;
            int i5 = rect.left;
            if (i5 < 0 || (i2 = rect.right) > measuredWidth || (i3 = rect.top) < 0 || (i4 = rect.bottom) > measuredHeight || i2 - i5 < measuredWidth / 2 || i4 - i3 < measuredHeight / 2) {
                c();
            } else {
                b();
            }
        }
    }

    public void b() {
        if (this.f11773i || this.f11765a == null) {
            return;
        }
        a("控件被展示");
        this.f11773i = true;
        this.f11765a.b();
    }

    public void c() {
        if (!this.f11773i || this.f11765a == null) {
            return;
        }
        a("控件被隐藏");
        this.f11773i = false;
        this.f11765a.a();
    }

    public void d() {
        this.f11767c = null;
        this.f11765a = null;
        Handler handler = this.f11769e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11769e = null;
        }
    }

    public void e() {
        g();
        this.f11772h = null;
        d();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view;
        if (!this.f11771g || (view = this.f11767c) == null || this == view.getTag(u.f11521a)) {
            a();
            return true;
        }
        a("广告控件当前绑定的曝光校验器不一致");
        g();
        return true;
    }

    public void a(String str) {
        if (this.f11770f) {
            TianmuLogUtil.iD(c.class.getName() + str);
        }
    }

    public void a(View view) {
        if (view != null) {
            g();
            this.f11767c = view;
            view.setTag(u.f11521a, this);
            if (view.getViewTreeObserver() != null) {
                try {
                    this.f11771g = true;
                    view.getViewTreeObserver().addOnPreDrawListener(this);
                    if (this.f11772h != null && Build.VERSION.SDK_INT >= 18) {
                        view.getViewTreeObserver().addOnWindowFocusChangeListener(this.f11772h);
                    }
                    a("开始曝光校验");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
