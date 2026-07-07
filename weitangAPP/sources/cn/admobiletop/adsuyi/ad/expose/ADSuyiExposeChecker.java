package cn.admobiletop.adsuyi.ad.expose;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import cn.admobiletop.adsuyi.R;
import cn.admobiletop.adsuyi.a.b.q;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiExposeChecker extends q implements ViewTreeObserver.OnPreDrawListener {
    public boolean l;
    public ViewTreeObserver.OnWindowFocusChangeListener m;

    public ADSuyiExposeChecker(ADSuyiExposeListener aDSuyiExposeListener) {
        this(true, aDSuyiExposeListener);
    }

    @Override // cn.admobiletop.adsuyi.a.b.q
    public void a() {
        super.a();
        i();
    }

    public final void h() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.m = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeChecker.1
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    if (z) {
                        ADSuyiExposeChecker.this.c(false);
                    }
                }
            };
        }
    }

    public final void i() {
        View view;
        if (!this.l || (view = this.f3212e) == null || view.getViewTreeObserver() == null) {
            return;
        }
        try {
            b("停止曝光校验");
            this.f3212e.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.m != null && Build.VERSION.SDK_INT >= 18) {
                this.f3212e.getViewTreeObserver().removeOnWindowFocusChangeListener(this.m);
            }
            this.l = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view;
        if (!this.l || (view = this.f3212e) == null || this == view.getTag(R.id.adsuyi_id_view_expose_tag)) {
            c(false);
            return true;
        }
        b("广告控件当前绑定的曝光校验器不一致");
        i();
        return true;
    }

    public void releaseExposeCheck() {
        i();
        this.m = null;
        super.e();
    }

    @Override // cn.admobiletop.adsuyi.a.b.q
    public void setShowLog(boolean z) {
        super.setShowLog(z);
    }

    public void startExposeCheck(View view) {
        if (view != null) {
            i();
            this.f3212e = view;
            view.setTag(R.id.adsuyi_id_view_expose_tag, this);
            if (this.f3210c || view.getViewTreeObserver() == null) {
                return;
            }
            try {
                this.l = true;
                view.getViewTreeObserver().addOnPreDrawListener(this);
                if (this.m != null && Build.VERSION.SDK_INT >= 18) {
                    view.getViewTreeObserver().addOnWindowFocusChangeListener(this.m);
                }
                b("开始曝光校验");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ADSuyiExposeChecker(boolean z, ADSuyiExposeListener aDSuyiExposeListener) {
        this(z, true, aDSuyiExposeListener);
    }

    public ADSuyiExposeChecker(boolean z, boolean z2, ADSuyiExposeListener aDSuyiExposeListener) {
        this.f3209b = z;
        this.f3211d = z2;
        this.f3208a = aDSuyiExposeListener;
        h();
    }
}
