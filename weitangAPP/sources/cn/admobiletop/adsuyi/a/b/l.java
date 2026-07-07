package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes.dex */
public class l<E> extends cn.admobiletop.adsuyi.a.i.c<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f3196d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, v vVar, String str, int i2) {
        super(vVar, str, i2);
        this.f3196d = nVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TE;Ljava/lang/String;I)V */
    @Override // cn.admobiletop.adsuyi.a.i.c
    public void a(v vVar, String str, int i2) {
        ADSuyiLogUtil.d("初始化已完成...");
        this.f3196d.g(vVar, str, i2);
    }
}
