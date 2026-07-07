package com.tianmu.c.j;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tianmu.ad.base.BaseExposeChecker;
import com.tianmu.c.f.u;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseExposeChecker implements ViewTreeObserver.OnPreDrawListener {
    private boolean m;
    private ViewTreeObserver.OnWindowFocusChangeListener n;

    /* JADX INFO: renamed from: com.tianmu.c.j.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnWindowFocusChangeListenerC0210a implements ViewTreeObserver.OnWindowFocusChangeListener {
        public ViewTreeObserverOnWindowFocusChangeListenerC0210a() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            if (z) {
                a.this.a(false);
            }
        }
    }

    public a(b bVar) {
        this(true, bVar);
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.n = new ViewTreeObserverOnWindowFocusChangeListenerC0210a();
        }
    }

    private void e() {
        View view;
        if (!this.m || (view = this.f10656f) == null || view.getViewTreeObserver() == null) {
            return;
        }
        try {
            a("停止曝光校验");
            this.f10656f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.n != null && Build.VERSION.SDK_INT >= 18) {
                this.f10656f.getViewTreeObserver().removeOnWindowFocusChangeListener(this.n);
            }
            this.m = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        e();
        this.n = null;
        super.b();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view;
        if (!this.m || (view = this.f10656f) == null || this == view.getTag(u.f11521a)) {
            a(false);
            return true;
        }
        a("广告控件当前绑定的曝光校验器不一致");
        e();
        return true;
    }

    @Override // com.tianmu.ad.base.BaseExposeChecker
    public void setShowLog(boolean z) {
        super.setShowLog(z);
    }

    public a(boolean z, b bVar) {
        this(z, true, bVar);
    }

    @Override // com.tianmu.ad.base.BaseExposeChecker
    public void a() {
        super.a();
        e();
    }

    public a(boolean z, boolean z2, b bVar) {
        this.f10653c = z;
        this.f10655e = z2;
        this.f10652b = bVar;
        d();
    }

    public void a(View view) {
        if (view != null) {
            e();
            this.f10656f = view;
            view.setTag(u.f11521a, this);
            if (this.f10654d || view.getViewTreeObserver() == null) {
                return;
            }
            try {
                this.m = true;
                view.getViewTreeObserver().addOnPreDrawListener(this);
                if (this.n != null && Build.VERSION.SDK_INT >= 18) {
                    view.getViewTreeObserver().addOnWindowFocusChangeListener(this.n);
                }
                TianmuLogUtil.iD("开始曝光校验");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
