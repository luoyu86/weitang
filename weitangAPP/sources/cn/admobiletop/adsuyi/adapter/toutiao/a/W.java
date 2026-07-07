package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class W implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f3889a;

    public W(ba baVar) {
        this.f3889a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3889a.getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) this.f3889a.getAdListener()).onAdClick(this.f3889a);
        }
    }
}
