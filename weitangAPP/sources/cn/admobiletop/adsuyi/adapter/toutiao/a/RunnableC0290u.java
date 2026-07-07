package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0290u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0293x f3918a;

    public RunnableC0290u(C0293x c0293x) {
        this.f3918a = c0293x;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3918a.getAdListener() != 0) {
            ((ADSuyiFullScreenVodAdListener) this.f3918a.getAdListener()).onAdClick(this.f3918a);
        }
    }
}
