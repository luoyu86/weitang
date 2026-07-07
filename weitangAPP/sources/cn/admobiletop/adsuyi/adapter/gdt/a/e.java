package cn.admobiletop.adsuyi.adapter.gdt.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2;

/* JADX INFO: loaded from: classes.dex */
public class e implements ADSuyiNoticeListener2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3620a;

    public e(f fVar) {
        this.f3620a = fVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2
    public void onAutoDismiss() {
        if (this.f3620a.getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) this.f3620a.getAdListener()).onAdClose(this.f3620a);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2
    public void onManuallyDismiss() {
        if (this.f3620a.getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) this.f3620a.getAdListener()).onAdSkip(this.f3620a);
            ((ADSuyiInnerNoticeAdListener) this.f3620a.getAdListener()).onAdClose(this.f3620a);
        }
    }
}
