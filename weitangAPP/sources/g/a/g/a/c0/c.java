package g.a.g.a.c0;

import g.a.g.a.i;
import g.a.g.a.p;
import g.a.g.a.q;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.a.g.a.c0.a f14076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f14077b;

        public a(g.a.g.a.c0.a aVar, i iVar) {
            this.f14076a = aVar;
            this.f14077b = iVar;
        }

        public final boolean a(b bVar, g.a.g.a.c0.a aVar) {
            return (bVar == null || bVar.getEndomorphism() != aVar || bVar.getMappedPoint() == null) ? false : true;
        }

        @Override // g.a.g.a.p
        public q precompute(q qVar) {
            b bVar = qVar instanceof b ? (b) qVar : null;
            if (a(bVar, this.f14076a)) {
                return bVar;
            }
            i map = this.f14076a.getPointMap().map(this.f14077b);
            b bVar2 = new b();
            bVar2.setEndomorphism(this.f14076a);
            bVar2.setMappedPoint(map);
            return bVar2;
        }
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, int i2) {
        boolean z = bigInteger2.signum() < 0;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2.abs());
        boolean zTestBit = bigIntegerMultiply.testBit(i2 - 1);
        BigInteger bigIntegerShiftRight = bigIntegerMultiply.shiftRight(i2);
        if (zTestBit) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(g.a.g.a.d.f14091b);
        }
        return z ? bigIntegerShiftRight.negate() : bigIntegerShiftRight;
    }

    public static BigInteger[] decomposeScalar(g gVar, BigInteger bigInteger) {
        int bits = gVar.getBits();
        BigInteger bigIntegerA = a(bigInteger, gVar.getG1(), bits);
        BigInteger bigIntegerA2 = a(bigInteger, gVar.getG2(), bits);
        return new BigInteger[]{bigInteger.subtract(bigIntegerA.multiply(gVar.getV1A()).add(bigIntegerA2.multiply(gVar.getV2A()))), bigIntegerA.multiply(gVar.getV1B()).add(bigIntegerA2.multiply(gVar.getV2B())).negate()};
    }

    public static i mapPoint(g.a.g.a.c0.a aVar, i iVar) {
        return ((b) iVar.getCurve().precompute(iVar, "bc_endo", new a(aVar, iVar))).getMappedPoint();
    }
}
