package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0297b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f3979a;

    public RunnableC0297b(r rVar) {
        this.f3979a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3979a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
