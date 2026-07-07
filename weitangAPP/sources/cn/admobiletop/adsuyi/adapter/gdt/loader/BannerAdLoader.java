package cn.admobiletop.adsuyi.adapter.gdt.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.a;
import cn.admobiletop.adsuyi.adapter.gdt.widget.b;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.banner2.UnifiedBannerView;

/* JADX INFO: loaded from: classes.dex */
public class BannerAdLoader implements ADSuyiAdapterLoader<ADSuyiBannerAd, ADSuyiBannerAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiBannerAd f3714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiBannerAdListener f3716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f3717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UnifiedBannerView f3718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f3719f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3714a) || this.f3714a.getContainer() == null || (aDSuyiAdapterParams = this.f3715b) == null || aDSuyiAdapterParams.getPlatformPosId() == null || this.f3716c == null) {
            return;
        }
        if (this.f3715b.isCompelRefresh()) {
            c();
        } else {
            b();
        }
    }

    public final void b() {
        ADSuyiPlatformPosId platformPosId = this.f3715b.getPlatformPosId();
        this.f3717d = new a(platformPosId.getPlatformPosId(), this.f3716c);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(this.f3714a.getActivity(), platformPosId.getPlatformPosId(), this.f3717d);
        this.f3718e = unifiedBannerView;
        unifiedBannerView.setRefresh((int) this.f3714a.getAutoRefreshInterval());
        this.f3717d.a(this.f3718e);
        ADSuyiExtraParams localExtraParams = this.f3714a.getLocalExtraParams();
        int width = this.f3714a.getActivity().getResources().getDisplayMetrics().widthPixels;
        if (localExtraParams != null && localExtraParams.getAdSize() != null) {
            ADSuyiAdSize adSize = localExtraParams.getAdSize();
            if (adSize.getWidth() > 0) {
                width = adSize.getWidth();
            }
        }
        ADSuyiAdSize aDSuyiAdSize = platformPosId.getAdSize() == null ? new ADSuyiAdSize(640, 100) : platformPosId.getAdSize();
        this.f3717d.a(this.f3714a.getContainer(), width, (int) (width / (aDSuyiAdSize.getWidth() / aDSuyiAdSize.getHeight())));
        this.f3718e.loadAD();
    }

    public final void c() {
        ADSuyiPlatformPosId platformPosId = this.f3715b.getPlatformPosId();
        this.f3719f = new b(this.f3714a, this.f3715b, this.f3716c, platformPosId.getAdSize() == null ? new ADSuyiAdSize(640, 100) : platformPosId.getAdSize());
        this.f3714a.getContainer().removeAllViews();
        this.f3714a.getContainer().addView(this.f3719f);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
        ADSuyiBannerAd aDSuyiBannerAd;
        if (this.f3718e == null || (aDSuyiBannerAd = this.f3714a) == null || ((int) aDSuyiBannerAd.getAutoRefreshInterval()) <= 0) {
            return;
        }
        this.f3718e.setRefresh(0);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
        ADSuyiBannerAd aDSuyiBannerAd;
        if (this.f3718e == null || (aDSuyiBannerAd = this.f3714a) == null || ((int) aDSuyiBannerAd.getAutoRefreshInterval()) <= 0) {
            return;
        }
        this.f3718e.setRefresh((int) this.f3714a.getAutoRefreshInterval());
        this.f3718e.loadAD();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        UnifiedBannerView unifiedBannerView = this.f3718e;
        if (unifiedBannerView != null) {
            ADSuyiViewUtil.removeSelfFromParent(unifiedBannerView);
            this.f3718e.destroy();
            this.f3718e = null;
        }
        a aVar = this.f3717d;
        if (aVar != null) {
            aVar.release();
            this.f3717d = null;
        }
        b bVar = this.f3719f;
        if (bVar != null) {
            bVar.release();
            this.f3719f = null;
        }
        this.f3714a = null;
        this.f3715b = null;
        this.f3716c = null;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        this.f3714a = aDSuyiBannerAd;
        this.f3715b = aDSuyiAdapterParams;
        this.f3716c = aDSuyiBannerAdListener;
        a();
    }
}
