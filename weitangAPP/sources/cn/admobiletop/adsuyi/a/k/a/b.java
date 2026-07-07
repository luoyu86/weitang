package cn.admobiletop.adsuyi.a.k.a;

import cn.admobiletop.adsuyi.a.k.a.e;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3349b;

    public b(e eVar, List list) {
        this.f3349b = eVar;
        this.f3348a = list;
    }

    @Override // cn.admobiletop.adsuyi.a.k.a.e.a
    public void a(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        if (this.f3349b.a()) {
            return;
        }
        this.f3349b.a(true);
        this.f3349b.n();
        if (aDSuyiPlatformPosId != null) {
            this.f3349b.f(aDSuyiPlatformPosId, this.f3348a);
        } else {
            this.f3349b.y();
            this.f3349b.q(this.f3348a);
        }
    }
}
