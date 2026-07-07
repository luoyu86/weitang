package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class fa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ la f3994a;

    public fa(la laVar) {
        this.f3994a = laVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3994a.f4014i.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
    }
}
