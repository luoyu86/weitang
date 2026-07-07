package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0291v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0293x f3919a;

    public RunnableC0291v(C0293x c0293x) {
        this.f3919a = c0293x;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3919a.getAdListener() != 0) {
            ((ADSuyiFullScreenVodAdListener) this.f3919a.getAdListener()).onAdClose(this.f3919a);
        }
    }
}
