package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0288s f3916a;

    public r(C0288s c0288s) {
        this.f3916a = c0288s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3916a.getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) this.f3916a.getAdListener()).onAdClose(this.f3916a);
        }
    }
}
