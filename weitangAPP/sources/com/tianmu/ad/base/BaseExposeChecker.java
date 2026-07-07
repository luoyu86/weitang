package com.tianmu.ad.base;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tianmu.c.j.b;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BaseExposeChecker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f10652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f10656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10657g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f10659i;
    private boolean k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10651a = 1000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f10658h = new Rect();
    private Runnable j = new Runnable() { // from class: com.tianmu.ad.base.BaseExposeChecker.1
        @Override // java.lang.Runnable
        public void run() {
            BaseExposeChecker.this.f10657g = false;
            BaseExposeChecker.this.a(true);
        }
    };
    private boolean l = false;

    private void c() {
        if (this.f10657g || this.k) {
            return;
        }
        this.f10657g = true;
        a("满足可见条件，开始展示时长校验");
        if (this.f10659i == null) {
            this.f10659i = new Handler(Looper.getMainLooper());
        }
        this.f10659i.removeCallbacksAndMessages(null);
        this.f10659i.postDelayed(this.j, this.f10651a);
    }

    public void b() {
        this.f10656f = null;
        this.f10652b = null;
        this.k = true;
        Handler handler = this.f10659i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10659i = null;
        }
    }

    public void setExposeCheckNeedTime(long j) {
        this.f10651a = j;
    }

    public void setShowLog(boolean z) {
        this.l = z;
    }

    public void a(boolean z) {
        int i2;
        int i3;
        int i4;
        View view = this.f10656f;
        if (view == null || this.f10654d || this.f10657g) {
            return;
        }
        if (view.getVisibility() != 0) {
            a("控件不可见");
            return;
        }
        if (this.f10653c && !this.f10656f.hasWindowFocus()) {
            a("控件没有WindowFocus");
            return;
        }
        int measuredWidth = this.f10656f.getMeasuredWidth();
        int measuredHeight = this.f10656f.getMeasuredHeight();
        if (measuredWidth <= 30 || measuredHeight <= 30) {
            a("控件宽高小于最小宽高");
            return;
        }
        this.f10658h.set(0, 0, 0, 0);
        this.f10656f.getLocalVisibleRect(this.f10658h);
        Rect rect = this.f10658h;
        int i5 = rect.left;
        if (i5 < 0 || (i2 = rect.right) > measuredWidth || (i3 = rect.top) < 0 || (i4 = rect.bottom) > measuredHeight || i2 - i5 < measuredWidth / 2 || i4 - i3 < measuredHeight / 2) {
            return;
        }
        if (!this.f10655e || z) {
            a();
        } else {
            c();
        }
    }

    public void a(String str) {
        if (this.l) {
            TianmuLogUtil.iD(str);
        }
    }

    public void a() {
        if (this.f10654d) {
            return;
        }
        this.f10654d = true;
        a("满足可见条件，满足曝光条件");
        b bVar = this.f10652b;
        if (bVar != null) {
            bVar.onViewExpose();
        }
    }
}
