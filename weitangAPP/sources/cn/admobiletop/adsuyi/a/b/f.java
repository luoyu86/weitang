package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3181a;

    public f(k kVar) {
        this.f3181a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ADSuyiLogUtil.d("adSourceTimeoutRunnable code : " + hashCode());
        if (this.f3181a.m()) {
            return;
        }
        if (this.f3181a.k != null) {
            this.f3181a.k.release();
        }
        if (this.f3181a.l != null) {
            k kVar = this.f3181a;
            kVar.P(ADSuyiError.createErrorDesc(kVar.l.getPlatform(), this.f3181a.l.getPlatformPosId(), ADSuyiErrorConfig.AD_FAILED_AD_SOURCE_TIMEOUT, ADSuyiErrorConfig.MSG_AD_FAILED_AD_SOURCE_TIMEOUT));
        }
    }
}
