package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.r;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.adapter.toutiao.f.b;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class BannerAdLoader implements ADSuyiAdapterLoader<ADSuyiBannerAd, ADSuyiBannerAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f4068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4069b;

    public final void a(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiBannerAd) || aDSuyiBannerAd.getContainer() == null || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiBannerAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            aDSuyiBannerAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤Banner广告，经过测试头条的模板广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
            return;
        }
        TTAdNative tTAdNativeA = d.a().a(aDSuyiBannerAd.getActivity());
        if (tTAdNativeA == null) {
            aDSuyiBannerAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        ADSuyiAdSize aDSuyiAdSize = platformPosId.getAdSize() == null ? new ADSuyiAdSize(640, 100) : platformPosId.getAdSize();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize((int) (aDSuyiBannerAd.getContainer().getWidth() / ADSuyiSdk.getInstance().getInitiallyDensity()), (aDSuyiAdSize.getHeight() * r2) / aDSuyiAdSize.getWidth()).setImageAcceptedSize(aDSuyiAdSize.getWidth(), aDSuyiAdSize.getHeight()).build();
        r rVar = new r(aDSuyiBannerAd, platformPosId.getPlatformPosId(), aDSuyiBannerAdListener);
        this.f4068a = rVar;
        tTAdNativeA.loadBannerExpressAd(adSlotBuild, rVar);
    }

    public final void b(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiBannerAd) || aDSuyiBannerAd.getContainer() == null || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiBannerAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        this.f4069b = new b(aDSuyiBannerAd, aDSuyiAdapterParams, aDSuyiBannerAdListener, platformPosId.getAdSize() == null ? new ADSuyiAdSize(640, 100) : platformPosId.getAdSize());
        aDSuyiBannerAd.getContainer().removeAllViews();
        aDSuyiBannerAd.getContainer().addView(this.f4069b);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        r rVar = this.f4068a;
        if (rVar != null) {
            rVar.release();
            this.f4068a = null;
        }
        b bVar = this.f4069b;
        if (bVar != null) {
            bVar.release();
            this.f4069b = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        if (aDSuyiAdapterParams.isCompelRefresh()) {
            b(aDSuyiBannerAd, aDSuyiAdapterParams, aDSuyiBannerAdListener);
        } else {
            a(aDSuyiBannerAd, aDSuyiAdapterParams, aDSuyiBannerAdListener);
        }
    }
}
