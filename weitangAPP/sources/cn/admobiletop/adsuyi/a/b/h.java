package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public class h implements cn.admobiletop.adsuyi.a.k.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3183a;

    public h(k kVar) {
        this.f3183a = kVar;
    }

    @Override // cn.admobiletop.adsuyi.a.k.a.a.a
    public void a() {
        if (this.f3183a.B == null || this.f3183a.C == null) {
            return;
        }
        this.f3183a.B.post(this.f3183a.C);
    }

    @Override // cn.admobiletop.adsuyi.a.k.a.a.a
    public void b() {
        this.f3183a.t(ADSuyiErrorConfig.AD_FAILED_ALL_PLATFORM_BID_NO_AD, ADSuyiErrorConfig.MSG_AD_FAILED_ALL_PLATFORM_BID_NO_AD);
        this.f3183a.u0();
    }
}
