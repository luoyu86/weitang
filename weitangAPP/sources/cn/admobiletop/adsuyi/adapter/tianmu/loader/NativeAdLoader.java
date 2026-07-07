package cn.admobiletop.adsuyi.adapter.tianmu.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.b.l;
import cn.admobiletop.adsuyi.adapter.tianmu.b.n;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.NativeAd;
import com.tianmu.ad.NativeExpressAd;
import com.tianmu.ad.entity.TianmuAdSize;
import com.tianmu.ad.listener.NativeExpressAdListener;

/* JADX INFO: loaded from: classes.dex */
public class NativeAdLoader implements ADSuyiAdapterLoader<ADSuyiNativeAd, ADSuyiNativeAdListener>, ADSuyiBidManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiNativeAd f3844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiNativeAdListener f3846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f3847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NativeExpressAd f3848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NativeAd f3849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f3850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3851h;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3844a) || (aDSuyiAdapterParams = this.f3845b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3845b.getPlatformPosId() == null || this.f3846c == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.f3845b.getPlatformPosId();
        if (1 == platformPosId.getRenderType()) {
            c(this.f3844a, this.f3845b.getPosId(), platformPosId, this.f3845b.getCount(), this.f3846c);
        } else if (2 == platformPosId.getRenderType()) {
            b(this.f3844a, platformPosId, this.f3845b.getCount(), this.f3846c);
        }
    }

    public final void b(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiPlatformPosId aDSuyiPlatformPosId, int i2, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        l lVar;
        if (this.f3851h != null && (lVar = this.f3850g) != null) {
            lVar.a();
            return;
        }
        this.f3850g = new l(aDSuyiNativeAd, aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiNativeAdListener, this.f3851h);
        NativeAd nativeAd = new NativeAd(aDSuyiNativeAd.getActivity());
        this.f3849f = nativeAd;
        nativeAd.setListener(this.f3850g);
        this.f3849f.setMute(aDSuyiNativeAd.isMute());
        this.f3849f.loadAd(aDSuyiPlatformPosId.getPlatformPosId(), i2);
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3851h = aDSuyiBidAdapterCallback;
        a();
    }

    public final void c(ADSuyiNativeAd aDSuyiNativeAd, String str, ADSuyiPlatformPosId aDSuyiPlatformPosId, int i2, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        int width;
        n nVar;
        if (this.f3851h != null && (nVar = this.f3847d) != null) {
            nVar.a();
            return;
        }
        ADSuyiExtraParams localExtraParams = aDSuyiNativeAd.getLocalExtraParams();
        if (localExtraParams != null) {
            ADSuyiAdSize adSize = localExtraParams.getAdSize();
            if (adSize.getWidth() <= 0) {
                ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3851h;
                if (aDSuyiBidAdapterCallback != null) {
                    aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(-1, "InterstitialAdInfo is null").toString());
                }
                aDSuyiNativeAdListener.onAdFailed(ADSuyiError.createErrorDesc("tianmu", aDSuyiPlatformPosId.getPlatformPosId(), -1, "天目信息流广告需要设置预期的size，请通过ADSuyiNativeAd的setLocalExtraParams()方法进行相关设置"));
                return;
            }
            width = adSize.getWidth();
        } else {
            width = 0;
        }
        this.f3847d = new n(str, aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiNativeAdListener, this.f3851h);
        NativeExpressAd nativeExpressAd = new NativeExpressAd(aDSuyiNativeAd.getActivity(), new TianmuAdSize(width, 0));
        this.f3848e = nativeExpressAd;
        nativeExpressAd.setListener((NativeExpressAdListener) this.f3847d);
        this.f3848e.setMute(aDSuyiNativeAd.isMute());
        this.f3848e.loadAd(aDSuyiPlatformPosId.getPlatformPosId(), i2);
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiNativeAd) {
                this.f3844a = (ADSuyiNativeAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3845b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiNativeAdListener) {
                this.f3846c = (ADSuyiNativeAdListener) aDSuyiBidParams.getListener();
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
        n nVar = this.f3847d;
        if (nVar != null) {
            nVar.release();
            this.f3847d = null;
        }
        NativeExpressAd nativeExpressAd = this.f3848e;
        if (nativeExpressAd != null) {
            nativeExpressAd.release();
            this.f3848e = null;
        }
        l lVar = this.f3850g;
        if (lVar != null) {
            lVar.release();
            this.f3850g = null;
        }
        NativeAd nativeAd = this.f3849f;
        if (nativeAd != null) {
            nativeAd.release();
            this.f3849f = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        this.f3844a = aDSuyiNativeAd;
        this.f3845b = aDSuyiAdapterParams;
        this.f3846c = aDSuyiNativeAdListener;
        a();
    }
}
