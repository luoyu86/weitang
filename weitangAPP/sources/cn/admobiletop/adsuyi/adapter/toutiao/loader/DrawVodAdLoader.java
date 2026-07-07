package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiDrawVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.F;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class DrawVodAdLoader implements ADSuyiAdapterLoader<ADSuyiDrawVodAd, ADSuyiDrawVodAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public F f4070a;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        F f2 = this.f4070a;
        if (f2 != null) {
            f2.release();
            this.f4070a = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiDrawVodAd aDSuyiDrawVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiDrawVodAdListener aDSuyiDrawVodAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiDrawVodAd) || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiDrawVodAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            aDSuyiDrawVodAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤Draw广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
            return;
        }
        ADSuyiExtraParams localExtraParams = aDSuyiDrawVodAd.getLocalExtraParams();
        if (localExtraParams == null || localExtraParams.getAdSize() == null) {
            aDSuyiDrawVodAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条DrawVod模板广告需要设置预期的size，请通过ADSuyiDrawVodAd的setLocalExtraParams()方法进行相关设置"));
            return;
        }
        ADSuyiAdSize adSize = localExtraParams.getAdSize();
        if (adSize.getWidth() <= 0 || adSize.getHeight() <= 0) {
            aDSuyiDrawVodAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条DrawVod模板广告ADSuyiAdSize中的宽高都必须大于0"));
            return;
        }
        TTAdNative tTAdNativeA = d.a().a(aDSuyiDrawVodAd.getActivity());
        if (tTAdNativeA == null) {
            aDSuyiDrawVodAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        float initiallyDensity = ADSuyiSdk.getInstance().getInitiallyDensity();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(aDSuyiAdapterParams.getCount()).setExpressViewAcceptedSize(adSize.getWidth() / initiallyDensity, adSize.getHeight() <= 0 ? 0.0f : adSize.getHeight() / initiallyDensity).setImageAcceptedSize(640, 320).build();
        F f2 = new F(adSize.getWidth(), adSize.getHeight(), aDSuyiDrawVodAd, platformPosId.getPlatformPosId(), aDSuyiDrawVodAdListener);
        this.f4070a = f2;
        tTAdNativeA.loadExpressDrawFeedAd(adSlotBuild, f2);
    }
}
