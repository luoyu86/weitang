package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0295z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A f3921a;

    public RunnableC0295z(A a2) {
        this.f3921a = a2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3921a.f3866d.getAdListener() != 0) {
            ((ADSuyiNativeAdListener) this.f3921a.f3866d.getAdListener()).onAdClose(this.f3921a.f3866d);
        }
    }
}
