package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import android.app.Activity;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.A;
import cn.admobiletop.adsuyi.adapter.toutiao.b.la;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.d.c;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.adapter.toutiao.e.b;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;

/* JADX INFO: loaded from: classes.dex */
public class SplashAdLoader implements ADSuyiAdapterLoader<ADSuyiSplashAd, ADSuyiSplashAdListener>, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiSplashAd f4088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f4089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiSplashAdListener f4090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public A f4091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public la f4092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f4093f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f4088a) || this.f4088a.getContainer() == null || (aDSuyiAdapterParams = this.f4089b) == null || aDSuyiAdapterParams.getPlatformPosId() == null || this.f4090c == null) {
            return;
        }
        if ("flow".equals(this.f4089b.getPlatformPosId().getAdType())) {
            e();
        } else {
            d();
        }
    }

    public final void b(Activity activity, TTAdNative tTAdNative, ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        aDSuyiSplashAd.setAutoSkip(true);
        aDSuyiSplashAd.setAllowCustomSkipView(true);
        ADSuyiExtraParams localExtraParams = aDSuyiSplashAd.getLocalExtraParams();
        MediationAdSlot.Builder builder = new MediationAdSlot.Builder();
        int height = 1920;
        if (localExtraParams != null) {
            if (localExtraParams.getAdSize() != null) {
                ADSuyiAdSize adSize = localExtraParams.getAdSize();
                width = adSize.getWidth() > 0 ? adSize.getWidth() : 1080;
                if (adSize.getHeight() > 0) {
                    height = adSize.getHeight();
                }
            }
            if (localExtraParams.isAdShakeDisable()) {
                builder.setSplashShakeButton(false);
            }
        }
        float initiallyDensity = ADSuyiSdk.getInstance().getInitiallyDensity();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(aDSuyiPlatformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(aDSuyiAdapterParams.getCount()).setExpressViewAcceptedSize(width / initiallyDensity, height / initiallyDensity).setImageAcceptedSize(640, 320).setMediationAdSlot(builder.build()).build();
        la laVar = new la(activity, aDSuyiSplashAd.getContainer(), aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiSplashAdListener, this.f4093f);
        this.f4092e = laVar;
        tTAdNative.loadNativeExpressAd(adSlotBuild, laVar);
    }

    public final void c(TTAdNative tTAdNative, ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiSplashAdListener aDSuyiSplashAdListener, c cVar) {
        ADSuyiExtraParams localExtraParams = aDSuyiSplashAd.getLocalExtraParams();
        int iD = b.d(aDSuyiSplashAd.getActivity());
        int iA = b.a(aDSuyiSplashAd.getActivity());
        if (aDSuyiSplashAd.isImmersive()) {
            iA = (int) (iA + b.e(aDSuyiSplashAd.getActivity()));
        }
        float fC = b.c(aDSuyiSplashAd.getActivity());
        float fA = b.a(aDSuyiSplashAd.getActivity(), iA);
        if (localExtraParams != null && localExtraParams.getAdSize() != null) {
            ADSuyiAdSize adSize = localExtraParams.getAdSize();
            if (adSize.getWidth() > 0) {
                iD = adSize.getWidth();
                fC = b.a(aDSuyiSplashAd.getActivity(), iD);
            }
            if (adSize.getHeight() > 0) {
                iA = (int) (adSize.getHeight() + b.e(aDSuyiSplashAd.getActivity()));
                fA = b.a(aDSuyiSplashAd.getActivity(), iA);
            }
        }
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(aDSuyiPlatformPosId.getPlatformPosId()).setExpressViewAcceptedSize(fC, fA).setImageAcceptedSize(iD, iA).build();
        A a2 = new A(aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiSplashAdListener, cVar);
        this.f4091d = a2;
        tTAdNative.loadSplashAd(adSlotBuild, a2, (int) aDSuyiSplashAd.getPlatformTimeout(aDSuyiAdapterParams.getPosId()));
    }

    public final void d() {
        A a2;
        if (this.f4093f != null && (a2 = this.f4091d) != null) {
            a2.a();
            return;
        }
        this.f4088a.getContainer().setSplashAdListener(this.f4090c);
        ADSuyiPlatformPosId platformPosId = this.f4089b.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            c cVar = this.f4093f;
            if (cVar != null) {
                cVar.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(-1, "过滤Splash广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
                return;
            } else {
                this.f4090c.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤Splash广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
                return;
            }
        }
        TTAdNative tTAdNativeA = d.a().a(this.f4088a.getActivity());
        if (tTAdNativeA != null) {
            c(tTAdNativeA, this.f4088a, this.f4089b, platformPosId, this.f4090c, this.f4093f);
            return;
        }
        c cVar2 = this.f4093f;
        if (cVar2 != null) {
            cVar2.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(-1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
        } else {
            this.f4090c.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
        }
    }

    public final void e() {
        la laVar;
        if (this.f4093f != null && (laVar = this.f4092e) != null) {
            laVar.a();
            return;
        }
        this.f4088a.getContainer().setSplashAdListener(this.f4090c);
        ADSuyiPlatformPosId platformPosId = this.f4089b.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            c cVar = this.f4093f;
            if (cVar != null) {
                cVar.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(-1, "过滤Splash广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
                return;
            } else {
                this.f4090c.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤Splash广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
                return;
            }
        }
        TTAdNative tTAdNativeA = d.a().a(this.f4088a.getActivity());
        if (tTAdNativeA != null) {
            b(this.f4088a.getActivity(), tTAdNativeA, this.f4088a, this.f4089b, platformPosId, this.f4090c);
            return;
        }
        c cVar2 = this.f4093f;
        if (cVar2 != null) {
            cVar2.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(-1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
        } else {
            this.f4090c.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
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
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiSplashAd) {
            this.f4088a = (ADSuyiSplashAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f4089b = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiSplashAdListener) {
            this.f4090c = (ADSuyiSplashAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f4093f = new cn.admobiletop.adsuyi.adapter.toutiao.d.b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        A a2 = this.f4091d;
        if (a2 != null) {
            a2.release();
            this.f4091d = null;
        }
        la laVar = this.f4092e;
        if (laVar != null) {
            laVar.release();
            this.f4092e = null;
        }
        c cVar = this.f4093f;
        if (cVar != null) {
            cVar.release();
            this.f4093f = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        this.f4088a = aDSuyiSplashAd;
        this.f4089b = aDSuyiAdapterParams;
        this.f4090c = aDSuyiSplashAdListener;
        a();
    }
}
