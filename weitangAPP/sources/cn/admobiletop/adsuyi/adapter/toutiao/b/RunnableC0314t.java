package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0314t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A f4046a;

    public RunnableC0314t(A a2) {
        this.f4046a = a2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4046a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
