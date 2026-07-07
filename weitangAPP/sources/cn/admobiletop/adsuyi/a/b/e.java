package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3180a;

    public e(k kVar) {
        this.f3180a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3180a.m()) {
            return;
        }
        this.f3180a.e();
        this.f3180a.t(ADSuyiErrorConfig.AD_FAILED_TIME_OUT, "获取广告超时");
        this.f3180a.u0();
    }
}
