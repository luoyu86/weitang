package cn.admobiletop.adsuyi.adapter.gdt.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiDrawVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.d;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.nativ.NativeUnifiedAD;

/* JADX INFO: loaded from: classes.dex */
public class DrawVodAdLoader implements ADSuyiAdapterLoader<ADSuyiDrawVodAd, ADSuyiDrawVodAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f3720a;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
        d dVar = this.f3720a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        d dVar = this.f3720a;
        if (dVar != null) {
            dVar.release();
            this.f3720a = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiDrawVodAd aDSuyiDrawVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiDrawVodAdListener aDSuyiDrawVodAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiDrawVodAd) || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiDrawVodAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        ADSuyiExtraParams localExtraParams = aDSuyiDrawVodAd.getLocalExtraParams();
        if (localExtraParams == null || localExtraParams.getAdSize() == null) {
            aDSuyiDrawVodAdListener.onAdFailed(ADSuyiError.createErrorDesc("gdt", platformPosId.getPlatformPosId(), -1, "优量汇（广点通）DrawVod模板广告需要设置预期的size，请通过ADSuyiDrawVodAd的setLocalExtraParams()方法进行相关设置"));
            return;
        }
        ADSuyiAdSize adSize = localExtraParams.getAdSize();
        if (adSize.getWidth() <= 0 || adSize.getHeight() <= 0) {
            aDSuyiDrawVodAdListener.onAdFailed(ADSuyiError.createErrorDesc("gdt", platformPosId.getPlatformPosId(), -1, "优量汇（广点通）DrawVod模板广告ADSuyiAdSize中的宽高都必须大于0"));
        } else {
            this.f3720a = new d(adSize.getWidth(), adSize.getHeight(), platformPosId.getPlatformPosId(), aDSuyiDrawVodAdListener);
            new NativeUnifiedAD(aDSuyiDrawVodAd.getActivity(), platformPosId.getPlatformPosId(), this.f3720a).loadData(aDSuyiAdapterParams.getCount());
        }
    }
}
