package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.nativ.NativeExpressADView;

/* JADX INFO: loaded from: classes.dex */
public class j extends b<ADSuyiSplashAdListener, NativeExpressADView> implements ADSuyiSplashAdInfo {
    public boolean k;

    public j(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(NativeExpressADView nativeExpressADView) {
        super.setAdapterAdInfo(nativeExpressADView);
        if (nativeExpressADView == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        nativeExpressADView.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
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
        FrameLayout frameLayout = new FrameLayout(aDSuyiSplashAdContainer.getContext());
        aDSuyiSplashAdContainer.addView(frameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        ADSuyiViewUtil.addAdViewToAdContainer(frameLayout, getAdapterAdInfo());
        aDSuyiSplashAdContainer.addActionButtonView();
        aDSuyiSplashAdContainer.forceAddSkipView();
        getAdapterAdInfo().render();
        this.k = true;
    }
}
