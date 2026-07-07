package cn.admobiletop.adsuyi.adapter.gdt.a;

import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.adapter.gdt.R;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.splash.SplashAD;

/* JADX INFO: loaded from: classes.dex */
public class l extends b<ADSuyiSplashAdListener, SplashAD> implements ADSuyiSplashAdInfo {
    public boolean k;

    public l(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(SplashAD splashAD) {
        super.setAdapterAdInfo(splashAD);
        if (splashAD == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        splashAD.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo
    public void showSplash(ADSuyiSplashAdContainer aDSuyiSplashAdContainer) {
        if (aDSuyiSplashAdContainer == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        aDSuyiSplashAdContainer.removeCustomSkipView();
        getAdapterAdInfo().showAd(aDSuyiSplashAdContainer);
        ADSuyiViewUtil.addLogoToAdView(aDSuyiSplashAdContainer, 0, R.drawable.adsuyi_gdt_platform_icon2, ADSuyiDisplayUtil.dp2px(10), ADSuyiDisplayUtil.dp2px(16), ADSuyiDisplayUtil.dp2px(16), 0.5f);
        this.k = true;
    }
}
