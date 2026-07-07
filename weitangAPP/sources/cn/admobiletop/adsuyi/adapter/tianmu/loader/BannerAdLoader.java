package cn.admobiletop.adsuyi.adapter.tianmu.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.b.a;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.BannerAd;
import com.tianmu.ad.listener.BannerAdListener;

/* JADX INFO: loaded from: classes.dex */
public class BannerAdLoader implements ADSuyiAdapterLoader<ADSuyiBannerAd, ADSuyiBannerAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f3834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BannerAd f3835b;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
        BannerAd bannerAd = this.f3835b;
        if (bannerAd != null) {
            bannerAd.pause();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
        BannerAd bannerAd = this.f3835b;
        if (bannerAd != null) {
            bannerAd.resume();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        BannerAd bannerAd = this.f3835b;
        if (bannerAd != null) {
            bannerAd.release();
            this.f3835b = null;
        }
        a aVar = this.f3834a;
        if (aVar != null) {
            aVar.release();
            this.f3834a = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiBannerAd) || aDSuyiBannerAd.getContainer() == null || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatform() == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiBannerAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        this.f3834a = new a(platformPosId.getPlatformPosId(), aDSuyiBannerAdListener);
        BannerAd bannerAd = new BannerAd(aDSuyiBannerAd.getActivity(), aDSuyiBannerAd.getContainer());
        this.f3835b = bannerAd;
        bannerAd.setListener((BannerAdListener) this.f3834a);
        this.f3835b.loadAd(platformPosId.getPlatformPosId());
    }
}
