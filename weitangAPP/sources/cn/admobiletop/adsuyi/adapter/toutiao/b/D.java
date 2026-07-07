package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F f3930a;

    public D(F f2) {
        this.f3930a = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3930a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
