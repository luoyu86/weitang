package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class j implements cn.admobiletop.adsuyi.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3185a;

    public j(k kVar) {
        this.f3185a = kVar;
    }

    @Override // cn.admobiletop.adsuyi.b.c.a
    public void a() {
        this.f3185a.H.b();
        ADSuyiLogUtil.ti("ADSuyiParallel", "并发请求结果已返回，过滤结果发起发起请求");
        k kVar = this.f3185a;
        kVar.I(kVar.f3194i);
        this.f3185a.k();
    }
}
