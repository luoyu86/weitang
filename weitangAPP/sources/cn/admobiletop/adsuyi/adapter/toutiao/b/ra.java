package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class ra implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sa f4041a;

    public ra(sa saVar) {
        this.f4041a = saVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4041a.getAdListener() == 0 || this.f4041a.f4042d == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) this.f4041a.getAdListener()).onVideoCache(this.f4041a.f4042d);
    }
}
