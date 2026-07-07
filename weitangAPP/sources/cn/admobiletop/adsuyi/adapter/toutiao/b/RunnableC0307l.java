package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0307l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0311p f4008a;

    public RunnableC0307l(C0311p c0311p) {
        this.f4008a = c0311p;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ADSuyiBannerAdListener) this.f4008a.f4029a.getAdListener()).onAdReceive(this.f4008a.f4029a.f4032e);
    }
}
