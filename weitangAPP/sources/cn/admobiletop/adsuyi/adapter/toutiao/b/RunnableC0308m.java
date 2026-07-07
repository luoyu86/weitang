package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0308m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0311p f4015a;

    public RunnableC0308m(C0311p c0311p) {
        this.f4015a = c0311p;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ADSuyiBannerAdListener) this.f4015a.f4029a.getAdListener()).onAdExpose(this.f4015a.f4029a.f4032e);
        if (this.f4015a.f4029a.f4034g != null) {
            this.f4015a.f4029a.f4034g.a();
        }
    }
}
