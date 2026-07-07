package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiInterstitialAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.S;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.d.b;
import cn.admobiletop.adsuyi.adapter.toutiao.d.c;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialAdLoader implements ADSuyiAdapterLoader<ADSuyiInterstitialAd, ADSuyiInterstitialAdListener>, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f4072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiInterstitialAd f4073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiAdapterParams f4074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiInterstitialAdListener f4075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f4076e;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f4073b) || (aDSuyiAdapterParams = this.f4074c) == null || aDSuyiAdapterParams.getPlatformPosId() == null || this.f4075d == null) {
            return;
        }
        b(this.f4074c.getPlatformPosId());
    }

    public final void b(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        S s;
        if (this.f4076e != null && (s = this.f4072a) != null) {
            s.b();
            this.f4072a.a();
            return;
        }
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            c cVar = this.f4076e;
            if (cVar != null) {
                cVar.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(-1, "过滤Interstitial广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
                return;
            } else {
                this.f4075d.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, aDSuyiPlatformPosId.getPlatformPosId(), -1, "过滤Interstitial广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
                return;
            }
        }
        TTAdNative tTAdNativeA = d.a().a(this.f4073b.getActivity());
        if (tTAdNativeA != null) {
            AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(aDSuyiPlatformPosId.getPlatformPosId()).setExpressViewAcceptedSize(500.0f, 500.0f).setSupportDeepLink(true).setOrientation(2 != aDSuyiPlatformPosId.getScreenOrientation() ? 1 : 2).build();
            S s2 = new S(aDSuyiPlatformPosId.getPlatformPosId(), this.f4075d, this.f4076e);
            this.f4072a = s2;
            tTAdNativeA.loadFullScreenVideoAd(adSlotBuild, s2);
            return;
        }
        c cVar2 = this.f4076e;
        if (cVar2 != null) {
            cVar2.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(-1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
        } else {
            this.f4075d.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, aDSuyiPlatformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
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
            aDSuyiParallelCallback.onFailed(ADSuyiIniter.PLATFORM, "并行请求参数错误");
            return;
        }
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiInterstitialAd) {
            this.f4073b = (ADSuyiInterstitialAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f4074c = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiInterstitialAdListener) {
            this.f4075d = (ADSuyiInterstitialAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f4076e = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        S s = this.f4072a;
        if (s != null) {
            s.release();
            this.f4072a = null;
        }
        c cVar = this.f4076e;
        if (cVar != null) {
            cVar.release();
            this.f4076e = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiInterstitialAd aDSuyiInterstitialAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener) {
        this.f4073b = aDSuyiInterstitialAd;
        this.f4074c = aDSuyiAdapterParams;
        this.f4075d = aDSuyiInterstitialAdListener;
        a();
    }
}
