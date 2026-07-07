package g.a.g.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class k extends b {
    @Override // g.a.g.a.b
    public i b(i iVar, BigInteger bigInteger) {
        e curve = iVar.getCurve();
        if (bigInteger.bitLength() > m.getCombSize(curve)) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        l lVarPrecompute = m.precompute(iVar);
        g lookupTable = lVarPrecompute.getLookupTable();
        int width = lVarPrecompute.getWidth();
        int i2 = ((r1 + width) - 1) / width;
        i infinity = curve.getInfinity();
        int i3 = width * i2;
        int[] iArrFromBigInteger = g.a.g.c.n.fromBigInteger(i3, bigInteger);
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = 0;
            for (int i7 = i4 - i5; i7 >= 0; i7 -= i2) {
                int i8 = iArrFromBigInteger[i7 >>> 5] >>> (i7 & 31);
                i6 = ((i6 ^ (i8 >>> 1)) << 1) ^ i8;
            }
            infinity = infinity.twicePlus(lookupTable.lookup(i6));
        }
        return infinity.add(lVarPrecompute.getOffset());
    }
}
