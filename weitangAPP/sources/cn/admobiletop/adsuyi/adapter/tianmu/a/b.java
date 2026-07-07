package cn.admobiletop.adsuyi.adapter.tianmu.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2;

/* JADX INFO: loaded from: classes.dex */
public class b implements ADSuyiNoticeListener2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3790a;

    public b(c cVar) {
        this.f3790a = cVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2
    public void onAutoDismiss() {
        if (this.f3790a.getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) this.f3790a.getAdListener()).onAdClose(this.f3790a);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2
    public void onManuallyDismiss() {
        if (this.f3790a.getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) this.f3790a.getAdListener()).onAdSkip(this.f3790a);
            ((ADSuyiInnerNoticeAdListener) this.f3790a.getAdListener()).onAdClose(this.f3790a);
        }
    }
}
