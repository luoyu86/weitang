package g.a.g.a.c0;

import g.a.g.a.j;
import g.a.g.a.r;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f14079b;

    public e(g.a.g.a.e eVar, f fVar) {
        this.f14078a = fVar;
        this.f14079b = new r(eVar.fromBigInteger(fVar.getBeta()));
    }

    @Override // g.a.g.a.c0.d
    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        return c.decomposeScalar(this.f14078a.getSplitParams(), bigInteger);
    }

    @Override // g.a.g.a.c0.d, g.a.g.a.c0.a
    public j getPointMap() {
        return this.f14079b;
    }

    @Override // g.a.g.a.c0.d, g.a.g.a.c0.a
    public boolean hasEfficientPointMap() {
        return true;
    }
}
