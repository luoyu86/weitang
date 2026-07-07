package cn.admobiletop.adsuyi.adapter.tianmu.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiInterstitialAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.b.j;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.InterstitialAd;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialAdLoader implements ADSuyiAdapterLoader<ADSuyiInterstitialAd, ADSuyiInterstitialAdListener>, ADSuyiBidManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiInterstitialAd f3838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiInterstitialAdListener f3840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f3841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterstitialAd f3842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3843f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3838a) || (aDSuyiAdapterParams = this.f3839b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3839b.getPlatformPosId() == null || this.f3840c == null) {
            return;
        }
        b(this.f3838a, this.f3840c, this.f3839b.getPlatformPosId());
    }

    public final void b(ADSuyiInterstitialAd aDSuyiInterstitialAd, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        j jVar;
        if (this.f3843f != null && (jVar = this.f3841d) != null) {
            jVar.a();
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(aDSuyiInterstitialAd.getActivity());
        this.f3842e = interstitialAd;
        interstitialAd.setMute(aDSuyiInterstitialAd.isMute());
        j jVar2 = new j(aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiInterstitialAdListener, this.f3843f);
        this.f3841d = jVar2;
        this.f3842e.setListener(jVar2);
        this.f3842e.loadAd(aDSuyiPlatformPosId.getPlatformPosId());
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3843f = aDSuyiBidAdapterCallback;
        a();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiInterstitialAd) {
                this.f3838a = (ADSuyiInterstitialAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3839b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiInterstitialAdListener) {
                this.f3840c = (ADSuyiInterstitialAdListener) aDSuyiBidParams.getListener();
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        InterstitialAd interstitialAd = this.f3842e;
        if (interstitialAd != null) {
            interstitialAd.release();
            this.f3842e = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiInterstitialAd aDSuyiInterstitialAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener) {
        this.f3838a = aDSuyiInterstitialAd;
        this.f3839b = aDSuyiAdapterParams;
        this.f3840c = aDSuyiInterstitialAdListener;
        a();
    }
}
