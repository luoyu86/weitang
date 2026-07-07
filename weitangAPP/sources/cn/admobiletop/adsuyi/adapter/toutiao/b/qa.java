package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class qa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sa f4036a;

    public qa(sa saVar) {
        this.f4036a = saVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4036a.getAdListener() != 0) {
            sa saVar = this.f4036a;
            saVar.f4042d = new cn.admobiletop.adsuyi.adapter.toutiao.a.ba(saVar.getPlatformPosId());
            this.f4036a.f4042d.setAdapterAdInfo(this.f4036a.f4045g);
            this.f4036a.f4042d.setAdListener(this.f4036a.getAdListener());
            ((ADSuyiRewardVodAdListener) this.f4036a.getAdListener()).onAdReceive(this.f4036a.f4042d);
            ((ADSuyiRewardVodAdListener) this.f4036a.getAdListener()).onVideoCache(this.f4036a.f4042d);
        }
    }
}
