package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0277g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0278h f3902a;

    public RunnableC0277g(C0278h c0278h) {
        this.f3902a = c0278h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3902a.getAdListener() != 0) {
            ((ADSuyiSplashAdListener) this.f3902a.getAdListener()).onAdClose(this.f3902a);
        }
    }
}
