package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class E implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F f3931a;

    public E(F f2) {
        this.f3931a = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3931a.getAdListener() == 0 || this.f3931a.f3935g == null) {
            return;
        }
        ((ADSuyiDrawVodAdListener) this.f3931a.getAdListener()).onAdReceive(this.f3931a.f3935g);
    }
}
