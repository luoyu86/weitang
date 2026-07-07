package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0276f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0278h f3901a;

    public RunnableC0276f(C0278h c0278h) {
        this.f3901a = c0278h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3901a.getAdListener() != 0) {
            ((ADSuyiSplashAdListener) this.f3901a.getAdListener()).onAdClick(this.f3901a);
        }
    }
}
