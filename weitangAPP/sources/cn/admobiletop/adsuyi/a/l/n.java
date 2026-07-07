package cn.admobiletop.adsuyi.a.l;

import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class n implements ADSuyiInnerNoticeAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f3413a;

    public n(o oVar) {
        this.f3413a = oVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
        this.f3413a.l();
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoSkipListener
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onAdSkip(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
        ADSuyiLogUtil.d("InnerNoticeAd onAdSkip...");
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdFailed(ADSuyiError aDSuyiError) {
        if (this.f3413a.f3419f == null || this.f3413a.f3420g == null) {
            this.f3413a.v();
        } else if (aDSuyiError == null || !this.f3413a.c(aDSuyiError.getCode())) {
            this.f3413a.l();
        } else {
            this.f3413a.v();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener
    public void onAdReady(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
        this.f3413a.y();
        this.f3413a.f3416c = aDSuyiInnerNoticeAdInfo;
        this.f3413a.n();
    }
}
