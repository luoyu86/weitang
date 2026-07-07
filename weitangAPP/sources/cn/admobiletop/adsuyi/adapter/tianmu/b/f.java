package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3797a;

    public f(i iVar) {
        this.f3797a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3797a.getAdListener() == 0 || this.f3797a.f3801d == null) {
            return;
        }
        ((ADSuyiInnerNoticeAdListener) this.f3797a.getAdListener()).onAdClick(this.f3797a.f3801d);
    }
}
