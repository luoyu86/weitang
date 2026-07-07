package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import com.tianmu.ad.bean.BannerAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.BannerAdListener;

/* JADX INFO: loaded from: classes.dex */
public class a extends b<ADSuyiBannerAdListener> implements BannerAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.tianmu.a.a f3792d;

    public a(String str, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        super(str, aDSuyiBannerAdListener);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(BannerAdInfo bannerAdInfo) {
        if (getAdListener() == 0 || this.f3792d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdClick(this.f3792d);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(BannerAdInfo bannerAdInfo) {
        if (getAdListener() == 0 || this.f3792d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdClose(this.f3792d);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(BannerAdInfo bannerAdInfo) {
        if (getAdListener() == 0 || this.f3792d == null) {
            return;
        }
        ((ADSuyiBannerAdListener) getAdListener()).onAdExpose(this.f3792d);
    }

    @Override // com.tianmu.ad.listener.AdInfoListener
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(BannerAdInfo bannerAdInfo) {
        if (getAdListener() != 0) {
            a();
            cn.admobiletop.adsuyi.adapter.tianmu.a.a aVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.a(getPlatformPosId());
            this.f3792d = aVar;
            aVar.setAdapterAdInfo(bannerAdInfo);
            ((ADSuyiBannerAdListener) getAdListener()).onAdReceive(this.f3792d);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        if (tianmuError != null) {
            onAdFailed(tianmuError.getCode(), tianmuError.getError());
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        a();
    }

    public final void a() {
        cn.admobiletop.adsuyi.adapter.tianmu.a.a aVar = this.f3792d;
        if (aVar != null) {
            aVar.release();
            this.f3792d = null;
        }
    }
}
