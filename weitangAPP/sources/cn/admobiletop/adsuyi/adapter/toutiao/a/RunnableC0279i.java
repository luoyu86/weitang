package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0279i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0282l f3903a;

    public RunnableC0279i(C0282l c0282l) {
        this.f3903a = c0282l;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3903a.f3908a.getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) this.f3903a.f3908a.getAdListener()).onAdClick(this.f3903a.f3908a);
        }
    }
}
