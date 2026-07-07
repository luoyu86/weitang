package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0278h;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0315u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A f4047a;

    public RunnableC0315u(A a2) {
        this.f4047a = a2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4047a.getAdListener() != 0) {
            A a2 = this.f4047a;
            a2.f3922d = new C0278h(a2.getPlatformPosId());
            this.f4047a.f3922d.setAdapterAdInfo(this.f4047a.f3925g);
            this.f4047a.f3922d.setAdListener(this.f4047a.getAdListener());
            ((ADSuyiSplashAdListener) this.f4047a.getAdListener()).onAdReceive(this.f4047a.f3922d);
        }
    }
}
