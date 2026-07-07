package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0299d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0303h f3982a;

    public RunnableC0299d(C0303h c0303h) {
        this.f3982a = c0303h;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ADSuyiBannerAdListener) this.f3982a.f3998a.getAdListener()).onAdReceive(this.f3982a.f3998a.f4038e);
    }
}
