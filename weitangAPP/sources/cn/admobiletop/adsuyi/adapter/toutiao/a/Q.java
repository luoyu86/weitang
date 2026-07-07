package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3885a;

    public Q(T t) {
        this.f3885a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3885a.getAdListener() != 0) {
            ((ADSuyiNativeAdListener) this.f3885a.getAdListener()).onAdClick(this.f3885a);
        }
    }
}
