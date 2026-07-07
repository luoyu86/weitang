package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f3964a;

    public V(W w) {
        this.f3964a = w;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3964a.getAdListener() == 0 || this.f3964a.f3966e == null) {
            return;
        }
        ((ADSuyiNativeAdListener) this.f3964a.getAdListener()).onAdReceive(this.f3964a.f3966e);
    }
}
