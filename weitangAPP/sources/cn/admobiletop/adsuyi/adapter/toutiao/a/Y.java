package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class Y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f3891a;

    public Y(ba baVar) {
        this.f3891a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3891a.getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) this.f3891a.getAdListener()).onVideoComplete(this.f3891a);
        }
    }
}
