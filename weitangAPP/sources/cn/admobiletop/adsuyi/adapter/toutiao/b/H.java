package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f3940a;

    public H(K k) {
        this.f3940a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3940a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
