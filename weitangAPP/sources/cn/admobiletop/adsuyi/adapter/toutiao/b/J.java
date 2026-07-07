package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f3942a;

    public J(K k) {
        this.f3942a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3942a.getAdListener() == 0 || this.f3942a.f3943d == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) this.f3942a.getAdListener()).onVideoCache(this.f3942a.f3943d);
    }
}
