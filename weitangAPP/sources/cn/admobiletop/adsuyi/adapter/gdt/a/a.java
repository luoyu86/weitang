package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.data.ADSuyiBannerAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import com.qq.e.ads.banner2.UnifiedBannerView;

/* JADX INFO: loaded from: classes.dex */
public class a extends b<ADSuyiBannerAdListener, UnifiedBannerView> implements ADSuyiBannerAdInfo {
    public a(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(UnifiedBannerView unifiedBannerView) {
        super.setAdapterAdInfo(unifiedBannerView);
        if (unifiedBannerView == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        unifiedBannerView.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBannerAdInfo
    public int getECPM() {
        return 0;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return false;
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

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBannerAdInfo
    public void showBanner(ViewGroup viewGroup) {
    }
}
