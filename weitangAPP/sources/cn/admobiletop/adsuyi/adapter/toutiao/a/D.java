package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3869a;

    public D(J j) {
        this.f3869a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3869a.getAdListener() == 0 || this.f3869a.l) {
            return;
        }
        this.f3869a.l = true;
        ((ADSuyiNativeAdListener) this.f3869a.getAdListener()).onAdExpose(this.f3869a);
    }
}
