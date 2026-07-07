package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class X implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f3890a;

    public X(ba baVar) {
        this.f3890a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3890a.getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) this.f3890a.getAdListener()).onAdClose(this.f3890a);
        }
    }
}
