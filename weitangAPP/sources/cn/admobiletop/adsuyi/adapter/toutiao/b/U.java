package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class U implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f3963a;

    public U(W w) {
        this.f3963a = w;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3963a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
