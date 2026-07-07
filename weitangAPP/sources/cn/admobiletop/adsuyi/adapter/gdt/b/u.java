package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.adapter.gdt.c.i;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class u implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3673a;

    public u(v vVar) {
        this.f3673a = vVar;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.c.i.a
    public void a(int i2) {
        ADSuyiLogUtil.d("animationStart:" + i2);
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.c.i.a
    public void a() {
        ADSuyiLogUtil.d("animationEnd");
        this.f3673a.k.zoomOutAnimationFinish();
    }
}
