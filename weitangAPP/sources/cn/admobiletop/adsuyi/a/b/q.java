package cn.admobiletop.adsuyi.a.b;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeListener;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiExposeListener f3208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f3212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3213f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f3215h;
    public boolean j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f3214g = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f3216i = new p(this);
    public boolean k = true;

    public void a() {
        if (this.f3210c) {
            return;
        }
        this.f3210c = true;
        b("满足可见条件，满足曝光条件");
        ADSuyiExposeListener aDSuyiExposeListener = this.f3208a;
        if (aDSuyiExposeListener != null) {
            aDSuyiExposeListener.onExpose();
        }
    }

    public void b(String str) {
        if (this.k) {
            ADSuyiLogUtil.d(str);
        }
    }

    public void c(boolean z) {
        int i2;
        int i3;
        int i4;
        View view = this.f3212e;
        if (view == null || this.f3210c || this.f3213f) {
            return;
        }
        if (view.getVisibility() != 0) {
            b("控件不可见");
            return;
        }
        if (this.f3209b && !this.f3212e.hasWindowFocus()) {
            b("控件没有WindowFocus");
            return;
        }
        int measuredWidth = this.f3212e.getMeasuredWidth();
        int measuredHeight = this.f3212e.getMeasuredHeight();
        if (measuredWidth <= 30 || measuredHeight <= 30) {
            b("控件宽高小于最小宽高");
            return;
        }
        this.f3214g.set(0, 0, 0, 0);
        this.f3212e.getLocalVisibleRect(this.f3214g);
        Rect rect = this.f3214g;
        int i5 = rect.left;
        if (i5 < 0 || (i2 = rect.right) > measuredWidth || (i3 = rect.top) < 0 || (i4 = rect.bottom) > measuredHeight || i2 - i5 < measuredWidth / 2 || i4 - i3 < measuredHeight / 2) {
            return;
        }
        if (!this.f3211d || z) {
            a();
        } else {
            f();
        }
    }

    public void e() {
        this.f3212e = null;
        this.f3208a = null;
        this.j = true;
        Handler handler = this.f3215h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3215h = null;
        }
    }

    public final void f() {
        if (this.f3213f || this.j) {
            return;
        }
        this.f3213f = true;
        b("满足可见条件，开始展示时长校验");
        if (this.f3215h == null) {
            this.f3215h = new Handler(Looper.getMainLooper());
        }
        this.f3215h.removeCallbacksAndMessages(null);
        this.f3215h.postDelayed(this.f3216i, 1000L);
    }

    public void setShowLog(boolean z) {
        this.k = z;
    }
}
