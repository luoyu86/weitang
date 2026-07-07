package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.widget.b;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class b extends c<ADSuyiBannerAdListener> implements UnifiedBannerADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.b f3627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UnifiedBannerView f3628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b.a f3629f;

    public b(String str, ADSuyiBannerAdListener aDSuyiBannerAdListener, b.a aVar) {
        super(str, aDSuyiBannerAdListener);
        this.f3629f = aVar;
    }

    public void a(UnifiedBannerView unifiedBannerView) {
        this.f3628e = unifiedBannerView;
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADClicked() {
        if (getAdListener() == 0 || this.f3627d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdClick(this.f3627d);
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADClosed() {
        if (getAdListener() == 0 || this.f3627d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdClose(this.f3627d);
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADExposure() {
        if (getAdListener() != 0 && this.f3627d != null) {
            ((ADSuyiBannerAdListener) getAdListener()).onAdExpose(this.f3627d);
        }
        b.a aVar = this.f3629f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADLeftApplication() {
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADReceive() {
        if (this.f3628e != null && cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            this.f3628e.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
        }
        if (getAdListener() != 0) {
            if (this.f3628e == null) {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
            a();
            this.f3627d = new cn.admobiletop.adsuyi.adapter.gdt.a.b(getPlatformPosId());
            ((ADSuyiBannerAdListener) getAdListener()).onAdReceive(this.f3627d);
        }
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onNoAD(AdError adError) {
        onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        a();
    }

    public final void a() {
        cn.admobiletop.adsuyi.adapter.gdt.a.b bVar = this.f3627d;
        if (bVar != null) {
            bVar.release();
            this.f3627d = null;
        }
    }
}
