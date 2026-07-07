package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class S implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3886a;

    public S(T t) {
        this.f3886a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3886a.getAdListener() == 0 || this.f3886a.p) {
            return;
        }
        this.f3886a.p = true;
        ((ADSuyiNativeAdListener) this.f3886a.getAdListener()).onAdExpose(this.f3886a);
    }
}
