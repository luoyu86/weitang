package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class pa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sa f4030a;

    public pa(sa saVar) {
        this.f4030a = saVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4030a.onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
