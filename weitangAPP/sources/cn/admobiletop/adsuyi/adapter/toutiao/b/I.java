package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f3941a;

    public I(K k) {
        this.f3941a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3941a.getAdListener() != 0) {
            ((ADSuyiFullScreenVodAdListener) this.f3941a.getAdListener()).onAdReceive(this.f3941a.f3943d);
        }
    }
}
