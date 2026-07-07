package cn.admobiletop.adsuyi.adapter.gdt.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiInterstitialAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.m;
import cn.admobiletop.adsuyi.adapter.gdt.d.a;
import cn.admobiletop.adsuyi.adapter.gdt.d.b;
import cn.admobiletop.adsuyi.adapter.gdt.d.c;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialAdLoader implements ADSuyiAdapterLoader<ADSuyiInterstitialAd, ADSuyiInterstitialAdListener>, ADSuyiBidManager, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiInterstitialAd f3724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiInterstitialAdListener f3726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f3727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UnifiedInterstitialAD f3728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f3729f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3724a) || (aDSuyiAdapterParams = this.f3725b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3725b.getPlatformPosId() == null || this.f3726c == null) {
            return;
        }
        b(this.f3724a, this.f3726c, this.f3725b.getPlatformPosId());
    }

    public final void b(ADSuyiInterstitialAd aDSuyiInterstitialAd, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        m mVar;
        if (this.f3729f != null && (mVar = this.f3727d) != null) {
            mVar.a();
            return;
        }
        this.f3727d = new m(aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiInterstitialAdListener, aDSuyiPlatformPosId.getContentSize(), this.f3729f);
        this.f3728e = new UnifiedInterstitialAD(aDSuyiInterstitialAd.getActivity(), aDSuyiPlatformPosId.getPlatformPosId(), this.f3727d);
        this.f3728e.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(aDSuyiInterstitialAd.isMute()).setDetailPageMuted(aDSuyiInterstitialAd.isMute()).setAutoPlayPolicy(0).build());
        this.f3727d.a(this.f3728e);
        if (1 == aDSuyiPlatformPosId.getContentSize()) {
            this.f3728e.loadAD();
        } else {
            this.f3728e.loadFullScreenAD();
        }
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3729f = new a(aDSuyiBidAdapterCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiInterstitialAd) {
                this.f3724a = (ADSuyiInterstitialAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3725b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiInterstitialAdListener) {
                this.f3726c = (ADSuyiInterstitialAdListener) aDSuyiBidParams.getListener();
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController
    public void parallelLoad(ADSuyiPreLoadParams aDSuyiPreLoadParams, String str, ADSuyiParallelCallback aDSuyiParallelCallback) {
        if (aDSuyiPreLoadParams == null) {
            aDSuyiParallelCallback.onFailed("gdt", "并行请求参数错误");
            return;
        }
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiInterstitialAd) {
            this.f3724a = (ADSuyiInterstitialAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f3725b = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiInterstitialAdListener) {
            this.f3726c = (ADSuyiInterstitialAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f3729f = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f3728e;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f3728e = null;
        }
        m mVar = this.f3727d;
        if (mVar != null) {
            mVar.release();
            this.f3727d = null;
        }
        this.f3724a = null;
        this.f3725b = null;
        this.f3726c = null;
        c cVar = this.f3729f;
        if (cVar != null) {
            cVar.release();
            this.f3729f = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiInterstitialAd aDSuyiInterstitialAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener) {
        this.f3724a = aDSuyiInterstitialAd;
        this.f3725b = aDSuyiAdapterParams;
        this.f3726c = aDSuyiInterstitialAdListener;
        a();
    }
}
