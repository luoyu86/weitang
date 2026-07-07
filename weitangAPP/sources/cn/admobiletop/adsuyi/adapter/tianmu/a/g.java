package cn.admobiletop.adsuyi.adapter.tianmu.a;

import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.tianmu.ad.bean.SplashAdInfo;

/* JADX INFO: loaded from: classes.dex */
public class g extends a<ADSuyiSplashAdListener, SplashAdInfo> implements ADSuyiSplashAdInfo {
    public boolean k;

    public g(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(SplashAdInfo splashAdInfo) {
        super.setAdapterAdInfo(splashAdInfo);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return getAdapterAdInfo().isOvertime();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.tianmu.a.a, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo
    public void showSplash(ADSuyiSplashAdContainer aDSuyiSplashAdContainer) {
        if (aDSuyiSplashAdContainer == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        ADSuyiViewUtil.addAdViewToAdContainer(aDSuyiSplashAdContainer, getAdapterAdInfo().getSplashAdView(), new ViewGroup.LayoutParams(-1, -1));
        getAdapterAdInfo().render();
        if (aDSuyiSplashAdContainer.isSetSkipView()) {
            aDSuyiSplashAdContainer.addSkipView();
            aDSuyiSplashAdContainer.startCountDown();
        } else {
            aDSuyiSplashAdContainer.removeCustomSkipView();
        }
        this.k = true;
    }
}
