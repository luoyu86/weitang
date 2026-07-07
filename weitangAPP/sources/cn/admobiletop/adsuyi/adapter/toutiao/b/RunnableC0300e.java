package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0300e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0303h f3984a;

    public RunnableC0300e(C0303h c0303h) {
        this.f3984a = c0303h;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ADSuyiBannerAdListener) this.f3984a.f3998a.getAdListener()).onAdExpose(this.f3984a.f3998a.f4038e);
    }
}
