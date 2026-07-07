package cn.admobiletop.adsuyi.adapter.gdt.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiFullScreenVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.f;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenVodAdLoader implements ADSuyiAdapterLoader<ADSuyiFullScreenVodAd, ADSuyiFullScreenVodAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UnifiedInterstitialAD f3721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f3722b;

    public final void a(ADSuyiFullScreenVodAd aDSuyiFullScreenVodAd, ADSuyiFullScreenVodAdListener aDSuyiFullScreenVodAdListener, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        this.f3722b = new f(aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiFullScreenVodAdListener);
        this.f3721a = new UnifiedInterstitialAD(aDSuyiFullScreenVodAd.getActivity(), aDSuyiPlatformPosId.getPlatformPosId(), this.f3722b);
        this.f3721a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(1).build());
        this.f3722b.a(this.f3721a);
        this.f3721a.loadFullScreenAD();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f3721a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f3721a = null;
        }
        f fVar = this.f3722b;
        if (fVar != null) {
            fVar.release();
            this.f3722b = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiFullScreenVodAd aDSuyiFullScreenVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiFullScreenVodAdListener aDSuyiFullScreenVodAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiFullScreenVodAd) || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatform() == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiFullScreenVodAdListener == null) {
            return;
        }
        a(aDSuyiFullScreenVodAd, aDSuyiFullScreenVodAdListener, aDSuyiAdapterParams.getPlatformPosId());
    }
}
