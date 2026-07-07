package g.a.g.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class v extends b {
    @Override // g.a.g.a.b
    public i b(i iVar, BigInteger bigInteger) {
        i iVarAdd;
        w wVarPrecompute = x.precompute(iVar, x.getWindowSize(bigInteger.bitLength()), true);
        i[] preComp = wVarPrecompute.getPreComp();
        i[] preCompNeg = wVarPrecompute.getPreCompNeg();
        int width = wVarPrecompute.getWidth();
        int[] iArrGenerateCompactWindowNaf = x.generateCompactWindowNaf(width, bigInteger);
        i infinity = iVar.getCurve().getInfinity();
        int length = iArrGenerateCompactWindowNaf.length;
        if (length > 1) {
            length--;
            int i2 = iArrGenerateCompactWindowNaf[length];
            int i3 = i2 >> 16;
            int i4 = i2 & 65535;
            int iAbs = Math.abs(i3);
            i[] iVarArr = i3 < 0 ? preCompNeg : preComp;
            if ((iAbs << 2) < (1 << width)) {
                int iNumberOfLeadingZeros = 32 - g.a.j.g.numberOfLeadingZeros(iAbs);
                int i5 = width - iNumberOfLeadingZeros;
                iVarAdd = iVarArr[((1 << (width - 1)) - 1) >>> 1].add(iVarArr[(((iAbs ^ (1 << (iNumberOfLeadingZeros - 1))) << i5) + 1) >>> 1]);
                i4 -= i5;
            } else {
                iVarAdd = iVarArr[iAbs >>> 1];
            }
            infinity = iVarAdd.timesPow2(i4);
        }
        while (length > 0) {
            length--;
            int i6 = iArrGenerateCompactWindowNaf[length];
            int i7 = i6 >> 16;
            infinity = infinity.twicePlus((i7 < 0 ? preCompNeg : preComp)[Math.abs(i7) >>> 1]).timesPow2(i6 & 65535);
        }
        return infinity;
    }
}
