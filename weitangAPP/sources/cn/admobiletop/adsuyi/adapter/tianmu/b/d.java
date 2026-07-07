package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3795a;

    public d(i iVar) {
        this.f3795a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3795a.getAdListener() == 0 || this.f3795a.f3801d == null) {
            return;
        }
        ((ADSuyiInnerNoticeAdListener) this.f3795a.getAdListener()).onAdReceive(this.f3795a.f3801d);
        ((ADSuyiInnerNoticeAdListener) this.f3795a.getAdListener()).onAdReady(this.f3795a.f3801d);
    }
}
