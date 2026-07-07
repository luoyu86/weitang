package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.ad.api.ADSuyiNetworkRequestInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiSplashAd extends u<ADSuyiSplashAdListener> {
    public static final int SKIP_VIEW_CUSTOM = 1;
    public static final int SKIP_VIEW_DEFAULT = 0;
    public String[] A;
    public ADSuyiExtraParams m;
    public ADSuyiSplashAdContainer n;
    public View o;
    public View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f3479q;
    public boolean r;
    public boolean s;
    public int skipViewType;
    public boolean t;
    public boolean u;
    public boolean v;
    public List<String> w;
    public List<String> x;
    public boolean y;
    public ADSuyiSplashAdInfo z;

    public ADSuyiSplashAd(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        super(activity);
        this.f3479q = 5500L;
        this.t = true;
        this.u = true;
        this.v = false;
        this.skipViewType = 0;
        this.y = false;
        this.A = new String[]{ADSuyiPlatform.PLAFORM_ADMOBILE, "inmobi"};
        h(viewGroup);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return ADSuyiAdType.TYPE_SPLASH;
    }

    public ADSuyiSplashAdContainer getContainer() {
        return this.n;
    }

    public long getCountDownTime() {
        long j = this.f3479q;
        if (j < 3000 || j > 5500) {
            return 5500L;
        }
        return j;
    }

    public ADSuyiExtraParams getLocalExtraParams() {
        return this.m;
    }

    @Deprecated
    public long getPlatformTimeout(String str) {
        ADSuyiPosId aDSuyiPosIdD = h.l().d(str);
        return (aDSuyiPosIdD == null || aDSuyiPosIdD.getPlatformPosIdList() == null || aDSuyiPosIdD.getPlatformPosIdList().size() > 2) ? Math.max(3000L, (long) (getTimeout() * 0.8f)) : Math.max(3000L, getTimeout());
    }

    public View getSkipView() {
        View view = this.o;
        if (view != null && this.skipViewType == 1) {
            return view;
        }
        if (this.p == null) {
            this.p = ADSuyiViewUtil.getDefaultSkipView(getActivity());
        }
        return this.p;
    }

    public int getSkipViewType() {
        return this.skipViewType;
    }

    public List<String> getSplashCustomSkipSdks() {
        if (this.x == null) {
            this.x = new ArrayList();
            if (h.l().i() != null && h.l().i().q() != null && h.l().i().q().size() > 0) {
                this.x = h.l().i().q();
            }
            for (String str : this.A) {
                if (!this.x.contains(str)) {
                    this.x.add(str);
                }
            }
        }
        return this.x;
    }

    public List<String> getSplashHotAreaSdks() {
        if (this.w == null) {
            if (h.l().i() == null || h.l().i().r() == null || h.l().i().r().size() <= 0) {
                this.w = new ArrayList();
            } else {
                this.w = h.l().i().r();
            }
        }
        return this.w;
    }

    public void h(ViewGroup viewGroup) {
        if (viewGroup != null) {
            ADSuyiSplashAdContainer aDSuyiSplashAdContainer = new ADSuyiSplashAdContainer(viewGroup.getContext());
            this.n = aDSuyiSplashAdContainer;
            viewGroup.addView(aDSuyiSplashAdContainer, new ViewGroup.LayoutParams(-1, -1));
        }
        setTimeout(6000L);
    }

    public boolean isAllowActionButton() {
        return this.u;
    }

    public boolean isAllowCustomSkipView() {
        return this.t;
    }

    public boolean isAutoSkip() {
        return this.v;
    }

    public boolean isImmersive() {
        return this.r;
    }

    public boolean isOnlyLoad() {
        return this.y;
    }

    public boolean isSetSkipView(String str) {
        return getSplashCustomSkipSdks().size() > 0 ? getSplashCustomSkipSdks().contains(str) : Arrays.asList(this.A).contains(str);
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void loadAd(String str, int i2) {
        if (getContainer() == null) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_CONTAINER_IS_EMPTY, "广告容器不能为空"));
            }
        } else if (this.s) {
            ADSuyiLogUtil.d("每个SuyiSplashAd对象只能调用一次loadAd...");
        } else {
            this.s = true;
            super.loadAd(str, 1);
        }
    }

    public void loadOnly(String str) {
        this.y = true;
        super.loadAd(str, 1);
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void release() {
        ADSuyiSplashAdContainer aDSuyiSplashAdContainer = this.n;
        if (aDSuyiSplashAdContainer != null) {
            aDSuyiSplashAdContainer.release(false);
            this.n = null;
        }
        super.release();
        this.w = null;
        this.x = null;
    }

    public void setAdSuyiSplashAdInfo(ADSuyiSplashAdInfo aDSuyiSplashAdInfo) {
        this.z = aDSuyiSplashAdInfo;
    }

    public void setAllowActionButton(boolean z) {
        this.u = z;
    }

    public void setAllowCustomSkipView(boolean z) {
        this.t = z;
    }

    public void setAutoSkip(boolean z) {
        this.v = z;
    }

    public void setImmersive(boolean z) {
        this.r = z;
    }

    public void setLocalExtraParams(ADSuyiExtraParams aDSuyiExtraParams) {
        this.m = aDSuyiExtraParams;
    }

    @Deprecated
    public void setSkipView(View view) {
        setSkipView(view, this.f3479q);
    }

    public void showSplash() {
        if (!isOnlyLoad()) {
            ADSuyiLogUtil.d("当前广告未调用loadOnly方法，不支持加载与展示分离");
            return;
        }
        ADSuyiSplashAdInfo aDSuyiSplashAdInfo = this.z;
        if (aDSuyiSplashAdInfo == null) {
            ADSuyiLogUtil.d("广告还未准备好，请在onAdReceive回调后再展示广告");
        } else {
            aDSuyiSplashAdInfo.showSplash(this.n);
        }
    }

    @Deprecated
    public void setSkipView(View view, long j) {
        ADSuyiSplashAdContainer aDSuyiSplashAdContainer = this.n;
        if (aDSuyiSplashAdContainer == null || view == null) {
            return;
        }
        this.o = view;
        this.f3479q = j;
        aDSuyiSplashAdContainer.setSkipView(view);
        this.n.setCountDownTime(getCountDownTime());
        this.skipViewType = 1;
    }

    public void loadOnly(String str, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        this.y = true;
        loadAd(str, aDSuyiNetworkRequestInfo);
    }

    public void loadAd(String str, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        if (getContainer() == null) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_CONTAINER_IS_EMPTY, "广告容器不能为空"));
            }
        } else if (!this.s) {
            this.s = true;
            super.loadDefaultAd(str, 1, aDSuyiNetworkRequestInfo);
        } else {
            ADSuyiLogUtil.d("每个SuyiSplashAd对象只能调用一次loadAd...");
        }
    }

    public ADSuyiSplashAd(@NonNull Fragment fragment, @NonNull ViewGroup viewGroup) {
        super(fragment);
        this.f3479q = 5500L;
        this.t = true;
        this.u = true;
        this.v = false;
        this.skipViewType = 0;
        this.y = false;
        this.A = new String[]{ADSuyiPlatform.PLAFORM_ADMOBILE, "inmobi"};
        h(viewGroup);
    }
}
