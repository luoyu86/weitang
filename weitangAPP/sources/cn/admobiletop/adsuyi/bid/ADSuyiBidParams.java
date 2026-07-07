package cn.admobiletop.adsuyi.bid;

import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiBidParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiAdapterParams f4100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAd f4101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiAdListener f4102c;

    public ADSuyiAdapterParams getAdapterParams() {
        return this.f4100a;
    }

    public ADSuyiAdListener getListener() {
        return this.f4102c;
    }

    public ADSuyiAd getSuyiAd() {
        return this.f4101b;
    }

    public void setAdapterParams(ADSuyiAdapterParams aDSuyiAdapterParams) {
        this.f4100a = aDSuyiAdapterParams;
    }

    public void setListener(ADSuyiAdListener aDSuyiAdListener) {
        this.f4102c = aDSuyiAdListener;
    }

    public void setSuyiAd(ADSuyiAd aDSuyiAd) {
        this.f4101b = aDSuyiAd;
    }
}
