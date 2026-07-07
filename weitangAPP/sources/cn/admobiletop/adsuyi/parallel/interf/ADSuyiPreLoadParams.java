package cn.admobiletop.adsuyi.parallel.interf;

import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiPreLoadParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiAdapterParams f4339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAd f4340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiAdListener f4341c;

    public ADSuyiAdapterParams getAdapterParams() {
        return this.f4339a;
    }

    public ADSuyiAdListener getListener() {
        return this.f4341c;
    }

    public ADSuyiAd getSuyiAd() {
        return this.f4340b;
    }

    public void setAdapterParams(ADSuyiAdapterParams aDSuyiAdapterParams) {
        this.f4339a = aDSuyiAdapterParams;
    }

    public void setListener(ADSuyiAdListener aDSuyiAdListener) {
        this.f4341c = aDSuyiAdListener;
    }

    public void setSuyiAd(ADSuyiAd aDSuyiAd) {
        this.f4340b = aDSuyiAd;
    }
}
