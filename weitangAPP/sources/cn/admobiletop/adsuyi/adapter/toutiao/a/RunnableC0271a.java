package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0271a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0272b f3893a;

    public RunnableC0271a(C0272b c0272b) {
        this.f3893a = c0272b;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3893a.getAdListener() != 0) {
            ((ADSuyiBannerAdListener) this.f3893a.getAdListener()).onAdClose(this.f3893a);
        }
    }
}
