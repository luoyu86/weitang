package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3868a;

    public C(J j) {
        this.f3868a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3868a.getAdListener() != 0) {
            ((ADSuyiNativeAdListener) this.f3868a.getAdListener()).onAdClick(this.f3868a);
        }
    }
}
