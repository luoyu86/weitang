package cn.admobiletop.adsuyi.adapter.gdt.b;

import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class a extends c<ADSuyiBannerAdListener> implements UnifiedBannerADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.a f3621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UnifiedBannerView f3622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f3624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3626i;

    public a(String str, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        super(str, aDSuyiBannerAdListener);
    }

    public void a(UnifiedBannerView unifiedBannerView) {
        this.f3622e = unifiedBannerView;
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADClicked() {
        if (getAdListener() == 0 || this.f3621d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdClick(this.f3621d);
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADClosed() {
        if (getAdListener() == 0 || this.f3621d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdClose(this.f3621d);
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADExposure() {
        if (getAdListener() == 0 || this.f3621d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdExpose(this.f3621d);
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADLeftApplication() {
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADReceive() {
        RelativeLayout relativeLayout;
        if (getAdListener() != 0) {
            UnifiedBannerView unifiedBannerView = this.f3622e;
            if (unifiedBannerView == null) {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
            if (!this.f3623f && (relativeLayout = this.f3624g) != null) {
                this.f3623f = true;
                relativeLayout.addView(unifiedBannerView, new RelativeLayout.LayoutParams(this.f3625h, this.f3626i));
            }
            a();
            cn.admobiletop.adsuyi.adapter.gdt.a.a aVar = new cn.admobiletop.adsuyi.adapter.gdt.a.a(getPlatformPosId());
            this.f3621d = aVar;
            aVar.setAdapterAdInfo(this.f3622e);
            ((ADSuyiBannerAdListener) getAdListener()).onAdReceive(this.f3621d);
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
        cn.admobiletop.adsuyi.adapter.gdt.a.a aVar = this.f3621d;
        if (aVar != null) {
            aVar.release();
            this.f3621d = null;
        }
    }

    public void a(RelativeLayout relativeLayout, int i2, int i3) {
        this.f3624g = relativeLayout;
        this.f3625h = i2;
        this.f3626i = i3;
    }
}
