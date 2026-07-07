package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0305j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0312q f4004a;

    public RunnableC0305j(C0312q c0312q) {
        this.f4004a = c0312q;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4004a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
