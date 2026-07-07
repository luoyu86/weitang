package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import android.util.DisplayMetrics;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiFullScreenVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.K;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenVodAdLoader implements ADSuyiAdapterLoader<ADSuyiFullScreenVodAd, ADSuyiFullScreenVodAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public K f4071a;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        K k = this.f4071a;
        if (k != null) {
            k.release();
            this.f4071a = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiFullScreenVodAd aDSuyiFullScreenVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiFullScreenVodAdListener aDSuyiFullScreenVodAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiFullScreenVodAd) || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiFullScreenVodAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            aDSuyiFullScreenVodAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤FullScreen广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
            return;
        }
        TTAdNative tTAdNativeA = d.a().a(aDSuyiFullScreenVodAd.getActivity());
        if (tTAdNativeA == null) {
            aDSuyiFullScreenVodAdListener.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        DisplayMetrics displayMetrics = aDSuyiFullScreenVodAd.getActivity().getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(i2 / f2, i3 / f2).setImageAcceptedSize(i2, i3).setOrientation(2 != platformPosId.getScreenOrientation() ? 1 : 2).build();
        K k = new K(platformPosId.getPlatformPosId(), aDSuyiFullScreenVodAdListener);
        this.f4071a = k;
        tTAdNativeA.loadFullScreenVideoAd(adSlotBuild, k);
    }
}
