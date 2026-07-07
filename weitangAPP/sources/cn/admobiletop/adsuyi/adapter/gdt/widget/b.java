package cn.admobiletop.adsuyi.adapter.gdt.widget;

import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.banner2.UnifiedBannerView;

/* JADX INFO: loaded from: classes.dex */
public class b extends ADSuyiBannerAdContainer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ADSuyiBannerAd f3770i;
    public ADSuyiAdapterParams j;
    public ADSuyiBannerAdListener k;
    public cn.admobiletop.adsuyi.adapter.gdt.b.b l;
    public UnifiedBannerView m;
    public a n;

    public interface a {
        void a();
    }

    public b(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener, ADSuyiAdSize aDSuyiAdSize) {
        super(aDSuyiBannerAd.getActivity(), 15000L, aDSuyiAdSize);
        this.n = new cn.admobiletop.adsuyi.adapter.gdt.widget.a(this);
        this.f3770i = aDSuyiBannerAd;
        this.j = aDSuyiAdapterParams;
        this.k = aDSuyiBannerAdListener;
        onRefresh();
    }

    public void d() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        f();
        if (ADSuyiAdUtil.isReleased(this.f3770i) || this.f3770i.getContainer() == null || (aDSuyiAdapterParams = this.j) == null || aDSuyiAdapterParams.getPlatform() == null || this.j.getPlatformPosId() == null || this.k == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.j.getPlatformPosId();
        this.l = new cn.admobiletop.adsuyi.adapter.gdt.b.b(platformPosId.getPlatformPosId(), this.k, this.n);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(this.f3770i.getActivity(), platformPosId.getPlatformPosId(), this.l);
        this.m = unifiedBannerView;
        unifiedBannerView.setRefresh(0);
        this.l.a(this.m);
        removeAllViews();
        addView(this.m);
        this.m.loadAD();
    }

    public final void f() {
        UnifiedBannerView unifiedBannerView = this.m;
        if (unifiedBannerView != null) {
            ADSuyiViewUtil.removeSelfFromParent(unifiedBannerView);
            this.m.destroy();
            this.m = null;
        }
        cn.admobiletop.adsuyi.adapter.gdt.b.b bVar = this.l;
        if (bVar != null) {
            bVar.release();
            this.l = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer
    public void onRefresh() {
        d();
    }

    @Override // cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer
    public void release() {
        super.release();
        f();
    }
}
