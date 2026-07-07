package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0289t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0293x f3917a;

    public RunnableC0289t(C0293x c0293x) {
        this.f3917a = c0293x;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3917a.getAdListener() != 0) {
            ((ADSuyiFullScreenVodAdListener) this.f3917a.getAdListener()).onAdExpose(this.f3917a);
        }
    }
}
