package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class P implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3884a;

    public P(T t) {
        this.f3884a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3884a.getAdListener() != 0) {
            ((ADSuyiNativeAdListener) this.f3884a.getAdListener()).onAdClose(this.f3884a);
        }
    }
}
