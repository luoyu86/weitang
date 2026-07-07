package cn.admobiletop.adsuyi.adapter.gdt.loader;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.n;
import cn.admobiletop.adsuyi.adapter.gdt.b.o;
import cn.admobiletop.adsuyi.adapter.gdt.d.a;
import cn.admobiletop.adsuyi.adapter.gdt.d.b;
import cn.admobiletop.adsuyi.adapter.gdt.d.c;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeUnifiedAD;

/* JADX INFO: loaded from: classes.dex */
public class NativeAdLoader implements ADSuyiAdapterLoader<ADSuyiNativeAd, ADSuyiNativeAdListener>, ADSuyiBidManager, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiNativeAd f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiNativeAdListener f3732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f3733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f3734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f3735f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3730a) || (aDSuyiAdapterParams = this.f3731b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3731b.getPlatformPosId() == null || this.f3732c == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.f3731b.getPlatformPosId();
        if (1 == platformPosId.getRenderType()) {
            c(this.f3730a, this.f3731b.getPosId(), platformPosId, this.f3731b.getCount(), this.f3732c);
        } else if (2 == platformPosId.getRenderType()) {
            b(this.f3730a, platformPosId, this.f3731b.getCount(), this.f3732c);
        } else {
            c(this.f3730a, this.f3731b.getPosId(), platformPosId, this.f3731b.getCount(), this.f3732c);
        }
    }

    public final void b(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiPlatformPosId aDSuyiPlatformPosId, int i2, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        n nVar;
        if (this.f3735f != null && (nVar = this.f3734e) != null) {
            nVar.a();
        } else {
            this.f3734e = new n(aDSuyiNativeAd, aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiNativeAdListener, this.f3735f);
            new NativeUnifiedAD(aDSuyiNativeAd.getActivity(), aDSuyiPlatformPosId.getPlatformPosId(), this.f3734e).loadData(i2);
        }
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3735f = new a(aDSuyiBidAdapterCallback);
        a();
    }

    public final void c(ADSuyiNativeAd aDSuyiNativeAd, String str, ADSuyiPlatformPosId aDSuyiPlatformPosId, int i2, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        o oVar;
        if (this.f3735f != null && (oVar = this.f3733d) != null) {
            oVar.a();
            return;
        }
        int height = -2;
        ADSuyiExtraParams localExtraParams = aDSuyiNativeAd.getLocalExtraParams();
        if (localExtraParams != null) {
            ADSuyiAdSize adSize = localExtraParams.getAdSize();
            float initiallyDensity = ADSuyiSdk.getInstance().getInitiallyDensity();
            width = adSize.getWidth() > 0 ? (int) (adSize.getWidth() / initiallyDensity) : -1;
            if (adSize.getHeight() > 0) {
                height = (int) (adSize.getHeight() / initiallyDensity);
            }
        }
        this.f3733d = new o(str, aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiNativeAdListener, this.f3735f);
        NativeExpressAD nativeExpressAD = new NativeExpressAD(aDSuyiNativeAd.getActivity(), new ADSize(width, height), aDSuyiPlatformPosId.getPlatformPosId(), this.f3733d);
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(aDSuyiNativeAd.isMute()).setDetailPageMuted(aDSuyiNativeAd.isMute()).build());
        nativeExpressAD.loadAD(i2);
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiNativeAd) {
                this.f3730a = (ADSuyiNativeAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3731b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiNativeAdListener) {
                this.f3732c = (ADSuyiNativeAdListener) aDSuyiBidParams.getListener();
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
        n nVar = this.f3734e;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController
    public void parallelLoad(ADSuyiPreLoadParams aDSuyiPreLoadParams, String str, ADSuyiParallelCallback aDSuyiParallelCallback) {
        if (aDSuyiPreLoadParams == null) {
            aDSuyiParallelCallback.onFailed("gdt", "并行请求参数错误");
            return;
        }
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiNativeAd) {
            this.f3730a = (ADSuyiNativeAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f3731b = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiNativeAdListener) {
            this.f3732c = (ADSuyiNativeAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f3735f = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        o oVar = this.f3733d;
        if (oVar != null) {
            oVar.release();
            this.f3733d = null;
        }
        n nVar = this.f3734e;
        if (nVar != null) {
            nVar.release();
            this.f3734e = null;
        }
        this.f3730a = null;
        this.f3731b = null;
        this.f3732c = null;
        c cVar = this.f3735f;
        if (cVar != null) {
            cVar.release();
            this.f3735f = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiNativeAd aDSuyiNativeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        this.f3730a = aDSuyiNativeAd;
        this.f3731b = aDSuyiAdapterParams;
        this.f3732c = aDSuyiNativeAdListener;
        a();
    }
}
