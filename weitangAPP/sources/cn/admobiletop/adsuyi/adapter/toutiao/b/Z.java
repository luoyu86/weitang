package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class Z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ea f3974a;

    public Z(ea eaVar) {
        this.f3974a = eaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3974a.m.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
    }
}
