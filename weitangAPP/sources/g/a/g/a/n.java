package g.a.g.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class n extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.a.g.a.c0.d f14140b;

    public n(e eVar, g.a.g.a.c0.d dVar) {
        if (eVar == null || eVar.getOrder() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.f14139a = eVar;
        this.f14140b = dVar;
    }

    @Override // g.a.g.a.b
    public i b(i iVar, BigInteger bigInteger) {
        if (!this.f14139a.equals(iVar.getCurve())) {
            throw new IllegalStateException();
        }
        BigInteger[] bigIntegerArrDecomposeScalar = this.f14140b.decomposeScalar(bigInteger.mod(iVar.getCurve().getOrder()));
        BigInteger bigInteger2 = bigIntegerArrDecomposeScalar[0];
        BigInteger bigInteger3 = bigIntegerArrDecomposeScalar[1];
        return this.f14140b.hasEfficientPointMap() ? c.e(this.f14140b, iVar, bigInteger2, bigInteger3) : c.d(iVar, bigInteger2, g.a.g.a.c0.c.mapPoint(this.f14140b, iVar), bigInteger3);
    }
}
