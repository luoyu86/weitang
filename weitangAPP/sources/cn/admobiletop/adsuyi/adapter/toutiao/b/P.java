package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;

/* JADX INFO: loaded from: classes.dex */
public class P implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f3954a;

    public P(S s) {
        this.f3954a = s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3954a.getAdListener() != 0) {
            ((ADSuyiInterstitialAdListener) this.f3954a.getAdListener()).onAdReceive(this.f3954a.f3956d);
        }
    }
}
