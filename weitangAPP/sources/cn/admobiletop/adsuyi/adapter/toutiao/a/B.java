package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3867a;

    public B(J j) {
        this.f3867a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3867a.getAdListener() != 0) {
            ((ADSuyiNativeAdListener) this.f3867a.getAdListener()).onAdClick(this.f3867a);
        }
    }
}
