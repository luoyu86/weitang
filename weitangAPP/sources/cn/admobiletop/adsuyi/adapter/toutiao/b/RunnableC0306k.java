package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0306k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0311p f4006a;

    public RunnableC0306k(C0311p c0311p) {
        this.f4006a = c0311p;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4006a.f4029a.getAdListener() == 0 || this.f4006a.f4029a.f4032e == null) {
            return;
        }
        ((ADSuyiBannerAdListener) this.f4006a.f4029a.getAdListener()).onAdClick(this.f4006a.f4029a.f4032e);
    }
}
