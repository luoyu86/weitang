package cn.admobiletop.adsuyi.adapter.tianmu.loader;

import android.view.View;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.b.q;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.listener.SplashAdListener;

/* JADX INFO: loaded from: classes.dex */
public class SplashAdLoader implements ADSuyiAdapterLoader<ADSuyiSplashAd, ADSuyiSplashAdListener>, ADSuyiBidManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f3858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SplashAd f3859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiSplashAd f3860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiAdapterParams f3861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiSplashAdListener f3862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3863f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        q qVar;
        if (ADSuyiAdUtil.isReleased(this.f3860c) || this.f3860c.getContainer() == null || (aDSuyiAdapterParams = this.f3861d) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3861d.getPlatformPosId() == null || this.f3862e == null) {
            return;
        }
        if (this.f3863f != null && (qVar = this.f3858a) != null) {
            qVar.a();
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.f3861d.getPlatformPosId();
        View skipView = this.f3860c.getSkipView();
        if (skipView == null || !this.f3860c.isSetSkipView("tianmu")) {
            SplashAd splashAd = new SplashAd(this.f3860c.getActivity());
            this.f3859b = splashAd;
            splashAd.setImmersive(this.f3860c.isImmersive());
        } else {
            this.f3859b = new SplashAd(this.f3860c.getActivity(), skipView);
        }
        ADSuyiExtraParams localExtraParams = this.f3860c.getLocalExtraParams();
        if (localExtraParams != null) {
            this.f3859b.setSensorDisable(localExtraParams.isAdShakeDisable());
        }
        q qVar2 = new q(platformPosId.getPlatformPosId(), this.f3862e, this.f3860c.getContainer(), this.f3863f);
        this.f3858a = qVar2;
        this.f3859b.setListener((SplashAdListener) qVar2);
        this.f3859b.loadAd(platformPosId.getPlatformPosId());
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3863f = aDSuyiBidAdapterCallback;
        a();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiSplashAd) {
                this.f3860c = (ADSuyiSplashAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3861d = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiSplashAdListener) {
                this.f3862e = (ADSuyiSplashAdListener) aDSuyiBidParams.getListener();
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
        q qVar = this.f3858a;
        if (qVar != null) {
            qVar.release();
            this.f3858a = null;
        }
        SplashAd splashAd = this.f3859b;
        if (splashAd != null) {
            splashAd.release();
            this.f3859b = null;
        }
        this.f3863f = null;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        this.f3860c = aDSuyiSplashAd;
        this.f3861d = aDSuyiAdapterParams;
        this.f3862e = aDSuyiSplashAdListener;
        a();
    }
}
