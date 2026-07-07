package cn.admobiletop.adsuyi.a.g;

import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams;

/* JADX INFO: loaded from: classes.dex */
public class b implements ADSuyiAdapterIniterExtParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f3272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3275d = "admob.library.api.business.bean.AdmApiAdImp";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3276e;

    public b(int i2, String str, double d2, String str2) {
        this.f3273b = i2;
        this.f3274c = str;
        this.f3272a = d2;
        this.f3276e = str2;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public double getApiInterval() {
        return this.f3272a;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public String getCName() {
        return this.f3275d;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public String getExtKey() {
        return this.f3274c;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public String getNovelJson() {
        return this.f3276e;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams
    public int getTurn() {
        return this.f3273b;
    }
}
