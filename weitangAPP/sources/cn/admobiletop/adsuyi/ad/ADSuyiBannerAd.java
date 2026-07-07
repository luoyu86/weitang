package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeChecker;
import cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiInterceptContainer;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiBannerAd extends u<ADSuyiBannerAdListener> implements ADSuyiSceneAd {
    public long m;
    public RelativeLayout n;
    public boolean o;
    public ADSuyiExposeChecker p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f3476q;
    public ADSuyiExtraParams r;

    public ADSuyiBannerAd(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        super(activity);
        this.m = 0L;
        h(viewGroup);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return "banner";
    }

    public long getAutoRefreshInterval() {
        return this.m;
    }

    public RelativeLayout getContainer() {
        return this.n;
    }

    public ADSuyiExtraParams getLocalExtraParams() {
        return this.r;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public String getSceneId() {
        return this.f3476q;
    }

    public final void h(ViewGroup viewGroup) {
        if (viewGroup != null) {
            ADSuyiInterceptContainer aDSuyiInterceptContainer = new ADSuyiInterceptContainer(viewGroup.getContext());
            this.n = aDSuyiInterceptContainer;
            viewGroup.addView(aDSuyiInterceptContainer, new ViewGroup.LayoutParams(-1, -1));
        }
        setTimeout(10000L);
    }

    public final void l() {
        ADSuyiExposeChecker aDSuyiExposeChecker = this.p;
        if (aDSuyiExposeChecker != null) {
            aDSuyiExposeChecker.releaseExposeCheck();
            this.p = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void loadAd(final String str, int i2) {
        if (getContainer() == null) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_CONTAINER_IS_EMPTY, "广告容器不能为空"));
            }
        } else {
            l();
            ADSuyiExposeChecker aDSuyiExposeChecker = new ADSuyiExposeChecker(false, false, new ADSuyiExposeListener() { // from class: cn.admobiletop.adsuyi.ad.ADSuyiBannerAd.1
                @Override // cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeListener
                public void onExpose() {
                    if (ADSuyiBannerAd.this.o) {
                        ADSuyiLogUtil.d("每个SuyiBannerAd对象只能调用一次loadAd...");
                    } else {
                        ADSuyiBannerAd.this.o = true;
                        ADSuyiBannerAd.super.loadAd(str, 1);
                    }
                }
            });
            this.p = aDSuyiExposeChecker;
            aDSuyiExposeChecker.setShowLog(false);
            this.p.startExposeCheck(getContainer());
            getContainer().setMinimumHeight(50);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void release() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.n = null;
        }
        l();
        super.release();
    }

    public void setAutoRefreshInterval(long j) {
        if (j <= 0) {
            j = 0;
        } else if (j < 30) {
            j = 30;
        } else if (j > 120) {
            j = 120;
        }
        this.m = j;
    }

    public void setLocalExtraParams(ADSuyiExtraParams aDSuyiExtraParams) {
        this.r = aDSuyiExtraParams;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public void setSceneId(String str) {
        this.f3476q = str;
    }

    public ADSuyiBannerAd(@NonNull Fragment fragment, @NonNull ViewGroup viewGroup) {
        super(fragment);
        this.m = 0L;
        h(viewGroup);
    }
}
