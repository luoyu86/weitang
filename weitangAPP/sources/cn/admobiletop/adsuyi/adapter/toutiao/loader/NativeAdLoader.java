package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.W;
import cn.admobiletop.adsuyi.adapter.toutiao.b.ea;
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
public class NativeAdLoader implements ADSuyiAdapterLoader<ADSuyiNativeAd, ADSuyiNativeAdListener>, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ea f4077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public W f4078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiNativeAd f4079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiAdapterParams f4080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiNativeAdListener f4081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f4082f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        ea eaVar;
        if (ADSuyiAdUtil.isReleased(this.f4079c) || (aDSuyiAdapterParams = this.f4080d) == null || aDSuyiAdapterParams.getPlatformPosId() == null || this.f4081e == null) {
            return;
        }
        if (this.f4082f != null && (eaVar = this.f4077a) != null) {
            eaVar.a();
        } else if (2 == this.f4080d.getPlatformPosId().getRenderType()) {
            b(this.f4079c, this.f4080d, this.f4081e);
        } else {
            c(this.f4079c, this.f4080d, this.f4081e);
        }
    }

    public final void b(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        TTAdNative tTAdNativeA = d.a().a(aDSuyiNativeAd.getActivity());
        if (tTAdNativeA == null) {
            aDSuyiNativeAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(aDSuyiAdapterParams.getCount()).setImageAcceptedSize(640, 320).build();
        W w = new W(aDSuyiAdapterParams.getPosId(), aDSuyiNativeAd, aDSuyiNativeAdListener);
        this.f4078b = w;
        tTAdNativeA.loadFeedAd(adSlotBuild, w);
    }

    public final void c(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            aDSuyiNativeAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤信息流广告，经过测试头条的模板广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
            return;
        }
        ADSuyiExtraParams localExtraParams = aDSuyiNativeAd.getLocalExtraParams();
        if (localExtraParams == null || localExtraParams.getAdSize() == null) {
            aDSuyiNativeAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条信息流模板广告需要设置预期的size，请通过ADSuyiNativeAd的setLocalExtraParams()方法进行相关设置"));
            return;
        }
        ADSuyiAdSize adSize = localExtraParams.getAdSize();
        if (adSize.getWidth() <= 0) {
            aDSuyiNativeAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条信息流模板广告ADSuyiAdSize中的宽度必须大于0"));
            return;
        }
        TTAdNative tTAdNativeA = d.a().a(aDSuyiNativeAd.getActivity());
        if (tTAdNativeA == null) {
            aDSuyiNativeAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        float initiallyDensity = ADSuyiSdk.getInstance().getInitiallyDensity();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(aDSuyiAdapterParams.getCount()).setExpressViewAcceptedSize(adSize.getWidth() / initiallyDensity, adSize.getHeight() <= 0 ? 0.0f : adSize.getHeight() / initiallyDensity).setImageAcceptedSize(640, 320).build();
        ea eaVar = new ea(aDSuyiAdapterParams.getPosId(), adSize.getWidth(), adSize.getHeight(), aDSuyiNativeAd, platformPosId.getPlatformPosId(), aDSuyiNativeAdListener, this.f4082f);
        this.f4077a = eaVar;
        tTAdNativeA.loadNativeExpressAd(adSlotBuild, eaVar);
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
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiNativeAd) {
            this.f4079c = (ADSuyiNativeAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f4080d = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiNativeAdListener) {
            this.f4081e = (ADSuyiNativeAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f4082f = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        ea eaVar = this.f4077a;
        if (eaVar != null) {
            eaVar.release();
            this.f4077a = null;
        }
        W w = this.f4078b;
        if (w != null) {
            w.release();
            this.f4078b = null;
        }
        c cVar = this.f4082f;
        if (cVar != null) {
            cVar.release();
            this.f4082f = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        this.f4079c = aDSuyiNativeAd;
        this.f4080d = aDSuyiAdapterParams;
        this.f4081e = aDSuyiNativeAdListener;
        a();
    }
}
