package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0292w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0293x f3920a;

    public RunnableC0292w(C0293x c0293x) {
        this.f3920a = c0293x;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3920a.getAdListener() != 0) {
            ((ADSuyiFullScreenVodAdListener) this.f3920a.getAdListener()).onVideoComplete(this.f3920a);
        }
    }
}
