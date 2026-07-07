package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f3888a;

    public V(ba baVar) {
        this.f3888a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3888a.getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) this.f3888a.getAdListener()).onAdExpose(this.f3888a);
        }
    }
}
