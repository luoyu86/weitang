package cn.admobiletop.adsuyi.adapter.gdt.c;

import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiReleaseListener;

/* JADX INFO: loaded from: classes.dex */
public class d implements ADSuyiReleaseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3682a;

    public d(e eVar) {
        this.f3682a = eVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiReleaseListener
    public void onRelease(ADSuyiAd aDSuyiAd) {
        if (aDSuyiAd != null) {
            this.f3682a.c(aDSuyiAd.getKey());
        }
    }
}
