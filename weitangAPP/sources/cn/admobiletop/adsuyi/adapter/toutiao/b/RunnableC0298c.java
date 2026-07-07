package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0298c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0303h f3981a;

    public RunnableC0298c(C0303h c0303h) {
        this.f3981a = c0303h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3981a.f3998a.getAdListener() == 0 || this.f3981a.f3998a.f4038e == null) {
            return;
        }
        ((ADSuyiBannerAdListener) this.f3981a.f3998a.getAdListener()).onAdClick(this.f3981a.f3998a.f4038e);
    }
}
