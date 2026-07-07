package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3798a;

    public g(i iVar) {
        this.f3798a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3798a.getAdListener() == 0 || this.f3798a.f3801d == null) {
            return;
        }
        ((ADSuyiInnerNoticeAdListener) this.f3798a.getAdListener()).onAdClick(this.f3798a.f3801d);
    }
}
