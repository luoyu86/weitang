package cn.admobiletop.adsuyi.a.g;

import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams;

/* JADX INFO: loaded from: classes.dex */
public class g implements ADSuyiAdapterIniterExtParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f3303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3306d = "admob.library.api.business.bean.AdmApiAdImp";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3307e;

    public g(int i2, String str, double d2, String str2) {
        this.f3304b = i2;
        this.f3305c = str;
        this.f3303a = d2;
        this.f3307e = str2;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public double getApiInterval() {
        return this.f3303a;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public String getCName() {
        return this.f3306d;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public String getExtKey() {
        return this.f3305c;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public String getNovelJson() {
        return this.f3307e;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public int getTurn() {
        return this.f3304b;
    }
}
