package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0275e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0278h f3900a;

    public RunnableC0275e(C0278h c0278h) {
        this.f3900a = c0278h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3900a.getAdListener() != 0) {
            ((ADSuyiSplashAdListener) this.f3900a.getAdListener()).onAdExpose(this.f3900a);
        }
    }
}
