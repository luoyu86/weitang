package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes.dex */
public class m<E> extends cn.admobiletop.adsuyi.a.i.b<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f3197d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, v vVar, ADSuyiPosId aDSuyiPosId, int i2) {
        super(vVar, aDSuyiPosId, i2);
        this.f3197d = nVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TE;Lcn/admobiletop/adsuyi/ad/data/ADSuyiPosId;I)V */
    @Override // cn.admobiletop.adsuyi.a.i.b
    public void a(v vVar, ADSuyiPosId aDSuyiPosId, int i2) {
        ADSuyiLogUtil.d("控频校验完成...");
        this.f3197d.f(vVar, aDSuyiPosId, i2);
    }
}
