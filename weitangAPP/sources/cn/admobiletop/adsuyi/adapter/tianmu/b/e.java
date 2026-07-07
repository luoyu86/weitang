package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3796a;

    public e(i iVar) {
        this.f3796a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3796a.getAdListener() == 0 || this.f3796a.f3801d == null) {
            return;
        }
        ((ADSuyiInnerNoticeAdListener) this.f3796a.getAdListener()).onAdExpose(this.f3796a.f3801d);
    }
}
