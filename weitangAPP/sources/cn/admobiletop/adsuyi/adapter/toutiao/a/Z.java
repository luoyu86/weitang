package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public class Z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f3892a;

    public Z(ba baVar) {
        this.f3892a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3892a.getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) this.f3892a.getAdListener()).onVideoError(this.f3892a, new ADSuyiError(-1, "unknown"));
        }
    }
}
