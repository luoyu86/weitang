package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0274d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0278h f3898a;

    public RunnableC0274d(C0278h c0278h) {
        this.f3898a = c0278h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3898a.getAdListener() != 0) {
            ((ADSuyiSplashAdListener) this.f3898a.getAdListener()).onAdClose(this.f3898a);
        }
    }
}
