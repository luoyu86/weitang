package cn.admobiletop.adsuyi.ad.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.admobiletop.adsuyi.a.n.g;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeChecker;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiSplashAdContainer extends g {
    public ADSuyiExposeChecker p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ADSuyiSplashAdListener f3565q;
    public long r;
    public View s;

    public ADSuyiSplashAdContainer(Context context) {
        super(context);
    }

    @Override // cn.admobiletop.adsuyi.a.n.g
    public long getCustomCountDownTime() {
        return this.r;
    }

    @Override // cn.admobiletop.adsuyi.a.n.g
    public View getCustomSkipTextView() {
        return this.s;
    }

    @Override // cn.admobiletop.adsuyi.a.n.g
    public ADSuyiExposeChecker getExposeChecker() {
        return this.p;
    }

    @Override // cn.admobiletop.adsuyi.a.n.g
    public ADSuyiSplashAdListener getSplashAdListener() {
        return this.f3565q;
    }

    public final void j() {
        ADSuyiExposeChecker aDSuyiExposeChecker = this.p;
        if (aDSuyiExposeChecker != null) {
            aDSuyiExposeChecker.releaseExposeCheck();
            this.p = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.a.n.g, cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        release(true);
    }

    @Deprecated
    public void render(ADSuyiAdInfo aDSuyiAdInfo, View view, TextView textView, RelativeLayout.LayoutParams layoutParams, boolean z, boolean z2, boolean z3) {
    }

    @Deprecated
    public void render(ADSuyiAdInfo aDSuyiAdInfo, View view, TextView textView, boolean z, boolean z2) {
    }

    @Deprecated
    public void render(ADSuyiAdInfo aDSuyiAdInfo, View view, TextView textView, boolean z, boolean z2, boolean z3) {
    }

    public void render(ADSuyiAdInfo aDSuyiAdInfo, boolean z, ADSuyiSplashAd aDSuyiSplashAd) {
        d(aDSuyiAdInfo, aDSuyiSplashAd.getSkipView(), aDSuyiSplashAd.getSkipViewType(), aDSuyiSplashAd.isImmersive(), z, aDSuyiSplashAd);
    }

    public void setCountDownTime(long j) {
        this.r = j;
    }

    public void setExposeChecker(ADSuyiExposeChecker aDSuyiExposeChecker) {
        this.p = aDSuyiExposeChecker;
    }

    public void setSkipView(View view) {
        view.setAlpha(0.0f);
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        this.s = view;
    }

    public void setSplashAdListener(ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        this.f3565q = aDSuyiSplashAdListener;
    }

    @Override // cn.admobiletop.adsuyi.a.n.g
    public void release(boolean z) {
        this.f3565q = null;
        j();
        super.release(z);
    }
}
