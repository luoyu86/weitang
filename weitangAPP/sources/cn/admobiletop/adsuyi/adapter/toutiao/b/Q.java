package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;

/* JADX INFO: loaded from: classes.dex */
public class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f3955a;

    public Q(S s) {
        this.f3955a = s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3955a.getAdListener() == 0 || this.f3955a.f3956d == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) this.f3955a.getAdListener()).onAdReady(this.f3955a.f3956d);
    }
}
