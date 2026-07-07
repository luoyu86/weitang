package g.a.g.a;

import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static i a(i iVar) {
        if (iVar.i()) {
            return iVar;
        }
        throw new IllegalStateException("Invalid result");
    }

    public static i b(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        i iVarAdd;
        i offset;
        e curve = iVar.getCurve();
        int combSize = m.getCombSize(curve);
        if (bigInteger.bitLength() > combSize || bigInteger2.bitLength() > combSize) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        l lVarPrecompute = m.precompute(iVar);
        l lVarPrecompute2 = m.precompute(iVar2);
        g lookupTable = lVarPrecompute.getLookupTable();
        g lookupTable2 = lVarPrecompute2.getLookupTable();
        int width = lVarPrecompute.getWidth();
        if (width != lVarPrecompute2.getWidth()) {
            k kVar = new k();
            iVarAdd = kVar.multiply(iVar, bigInteger);
            offset = kVar.multiply(iVar2, bigInteger2);
        } else {
            int i2 = ((combSize + width) - 1) / width;
            i infinity = curve.getInfinity();
            int i3 = width * i2;
            int[] iArrFromBigInteger = g.a.g.c.n.fromBigInteger(i3, bigInteger);
            int[] iArrFromBigInteger2 = g.a.g.c.n.fromBigInteger(i3, bigInteger2);
            int i4 = i3 - 1;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = 0;
                int i7 = 0;
                for (int i8 = i4 - i5; i8 >= 0; i8 -= i2) {
                    int i9 = i8 >>> 5;
                    int i10 = i8 & 31;
                    int i11 = iArrFromBigInteger[i9] >>> i10;
                    i6 = ((i6 ^ (i11 >>> 1)) << 1) ^ i11;
                    int i12 = iArrFromBigInteger2[i9] >>> i10;
                    i7 = ((i7 ^ (i12 >>> 1)) << 1) ^ i12;
                }
                infinity = infinity.twicePlus(lookupTable.lookupVar(i6).add(lookupTable2.lookupVar(i7)));
            }
            iVarAdd = infinity.add(lVarPrecompute.getOffset());
            offset = lVarPrecompute2.getOffset();
        }
        return iVarAdd.add(offset);
    }

    public static i c(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        e curve = iVar.getCurve();
        i infinity = curve.getInfinity();
        i[] iVarArr = {iVar2, iVar.subtract(iVar2), iVar, iVar.add(iVar2)};
        curve.normalizeAll(iVarArr);
        i[] iVarArr2 = {iVarArr[3].negate(), iVarArr[2].negate(), iVarArr[1].negate(), iVarArr[0].negate(), infinity, iVarArr[0], iVarArr[1], iVarArr[2], iVarArr[3]};
        byte[] bArrGenerateJSF = x.generateJSF(bigInteger, bigInteger2);
        int length = bArrGenerateJSF.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            byte b2 = bArrGenerateJSF[length];
            infinity = infinity.twicePlus(iVarArr2[(((b2 << 24) >> 28) * 3) + 4 + ((b2 << 28) >> 28)]);
        }
    }

    public static i cleanPoint(e eVar, i iVar) {
        if (eVar.equals(iVar.getCurve())) {
            return eVar.decodePoint(iVar.getEncoded(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static i d(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() < 0;
        boolean z2 = bigInteger2.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        int windowSize = x.getWindowSize(bigIntegerAbs.bitLength(), 8);
        int windowSize2 = x.getWindowSize(bigIntegerAbs2.bitLength(), 8);
        w wVarPrecompute = x.precompute(iVar, windowSize, true);
        w wVarPrecompute2 = x.precompute(iVar2, windowSize2, true);
        int combSize = m.getCombSize(iVar.getCurve());
        if (!z && !z2 && bigInteger.bitLength() <= combSize && bigInteger2.bitLength() <= combSize && wVarPrecompute.isPromoted() && wVarPrecompute2.isPromoted()) {
            return b(iVar, bigInteger, iVar2, bigInteger2);
        }
        int iMin = Math.min(8, wVarPrecompute.getWidth());
        int iMin2 = Math.min(8, wVarPrecompute2.getWidth());
        return f(z ? wVarPrecompute.getPreCompNeg() : wVarPrecompute.getPreComp(), z ? wVarPrecompute.getPreComp() : wVarPrecompute.getPreCompNeg(), x.generateWindowNaf(iMin, bigIntegerAbs), z2 ? wVarPrecompute2.getPreCompNeg() : wVarPrecompute2.getPreComp(), z2 ? wVarPrecompute2.getPreComp() : wVarPrecompute2.getPreCompNeg(), x.generateWindowNaf(iMin2, bigIntegerAbs2));
    }

    public static i e(g.a.g.a.c0.a aVar, i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() < 0;
        boolean z2 = bigInteger2.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        w wVarPrecompute = x.precompute(iVar, x.getWindowSize(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8), true);
        w wVarPrecomputeWithPointMap = x.precomputeWithPointMap(g.a.g.a.c0.c.mapPoint(aVar, iVar), aVar.getPointMap(), wVarPrecompute, true);
        int iMin = Math.min(8, wVarPrecompute.getWidth());
        int iMin2 = Math.min(8, wVarPrecomputeWithPointMap.getWidth());
        return f(z ? wVarPrecompute.getPreCompNeg() : wVarPrecompute.getPreComp(), z ? wVarPrecompute.getPreComp() : wVarPrecompute.getPreCompNeg(), x.generateWindowNaf(iMin, bigIntegerAbs), z2 ? wVarPrecomputeWithPointMap.getPreCompNeg() : wVarPrecomputeWithPointMap.getPreComp(), z2 ? wVarPrecomputeWithPointMap.getPreComp() : wVarPrecomputeWithPointMap.getPreCompNeg(), x.generateWindowNaf(iMin2, bigIntegerAbs2));
    }

    public static i f(i[] iVarArr, i[] iVarArr2, byte[] bArr, i[] iVarArr3, i[] iVarArr4, byte[] bArr2) {
        i iVarAdd;
        int iMax = Math.max(bArr.length, bArr2.length);
        i infinity = iVarArr[0].getCurve().getInfinity();
        int i2 = iMax - 1;
        i iVarTwicePlus = infinity;
        int i3 = 0;
        while (i2 >= 0) {
            byte b2 = i2 < bArr.length ? bArr[i2] : (byte) 0;
            byte b3 = i2 < bArr2.length ? bArr2[i2] : (byte) 0;
            if ((b2 | b3) == 0) {
                i3++;
            } else {
                if (b2 != 0) {
                    iVarAdd = infinity.add((b2 < 0 ? iVarArr2 : iVarArr)[Math.abs((int) b2) >>> 1]);
                } else {
                    iVarAdd = infinity;
                }
                if (b3 != 0) {
                    iVarAdd = iVarAdd.add((b3 < 0 ? iVarArr4 : iVarArr3)[Math.abs((int) b3) >>> 1]);
                }
                if (i3 > 0) {
                    iVarTwicePlus = iVarTwicePlus.timesPow2(i3);
                    i3 = 0;
                }
                iVarTwicePlus = iVarTwicePlus.twicePlus(iVarAdd);
            }
            i2--;
        }
        return i3 > 0 ? iVarTwicePlus.timesPow2(i3) : iVarTwicePlus;
    }

    public static i g(g.a.g.a.c0.a aVar, i[] iVarArr, BigInteger[] bigIntegerArr) {
        i[] iVarArr2 = iVarArr;
        int length = iVarArr2.length;
        int i2 = length << 1;
        boolean[] zArr = new boolean[i2];
        w[] wVarArr = new w[i2];
        byte[][] bArr = new byte[i2][];
        j pointMap = aVar.getPointMap();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 << 1;
            int i5 = i4 + 1;
            BigInteger bigInteger = bigIntegerArr[i4];
            zArr[i4] = bigInteger.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i5];
            zArr[i5] = bigInteger2.signum() < 0;
            BigInteger bigIntegerAbs2 = bigInteger2.abs();
            int windowSize = x.getWindowSize(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8);
            i iVar = iVarArr2[i3];
            w wVarPrecompute = x.precompute(iVar, windowSize, true);
            w wVarPrecomputeWithPointMap = x.precomputeWithPointMap(g.a.g.a.c0.c.mapPoint(aVar, iVar), pointMap, wVarPrecompute, true);
            int iMin = Math.min(8, wVarPrecompute.getWidth());
            int iMin2 = Math.min(8, wVarPrecomputeWithPointMap.getWidth());
            wVarArr[i4] = wVarPrecompute;
            wVarArr[i5] = wVarPrecomputeWithPointMap;
            bArr[i4] = x.generateWindowNaf(iMin, bigIntegerAbs);
            bArr[i5] = x.generateWindowNaf(iMin2, bigIntegerAbs2);
            i3++;
            iVarArr2 = iVarArr;
        }
        return i(zArr, wVarArr, bArr);
    }

    public static i h(i[] iVarArr, BigInteger[] bigIntegerArr) {
        int length = iVarArr.length;
        boolean[] zArr = new boolean[length];
        w[] wVarArr = new w[length];
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < length; i2++) {
            BigInteger bigInteger = bigIntegerArr[i2];
            zArr[i2] = bigInteger.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            w wVarPrecompute = x.precompute(iVarArr[i2], x.getWindowSize(bigIntegerAbs.bitLength(), 8), true);
            int iMin = Math.min(8, wVarPrecompute.getWidth());
            wVarArr[i2] = wVarPrecompute;
            bArr[i2] = x.generateWindowNaf(iMin, bigIntegerAbs);
        }
        return i(zArr, wVarArr, bArr);
    }

    public static i i(boolean[] zArr, w[] wVarArr, byte[][] bArr) {
        int length = bArr.length;
        int iMax = 0;
        for (byte[] bArr2 : bArr) {
            iMax = Math.max(iMax, bArr2.length);
        }
        i infinity = wVarArr[0].getPreComp()[0].getCurve().getInfinity();
        int i2 = iMax - 1;
        i iVarTwicePlus = infinity;
        int i3 = 0;
        while (i2 >= 0) {
            i iVarAdd = infinity;
            for (int i4 = 0; i4 < length; i4++) {
                byte[] bArr3 = bArr[i4];
                byte b2 = i2 < bArr3.length ? bArr3[i2] : (byte) 0;
                if (b2 != 0) {
                    int iAbs = Math.abs((int) b2);
                    w wVar = wVarArr[i4];
                    iVarAdd = iVarAdd.add(((b2 < 0) == zArr[i4] ? wVar.getPreComp() : wVar.getPreCompNeg())[iAbs >>> 1]);
                }
            }
            if (iVarAdd == infinity) {
                i3++;
            } else {
                if (i3 > 0) {
                    iVarTwicePlus = iVarTwicePlus.timesPow2(i3);
                    i3 = 0;
                }
                iVarTwicePlus = iVarTwicePlus.twicePlus(iVarAdd);
            }
            i2--;
        }
        return i3 > 0 ? iVarTwicePlus.timesPow2(i3) : iVarTwicePlus;
    }

    public static i importPoint(e eVar, i iVar) {
        if (eVar.equals(iVar.getCurve())) {
            return eVar.importPoint(iVar);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(e eVar) {
        return isF2mField(eVar.getField());
    }

    public static boolean isF2mField(g.a.g.b.a aVar) {
        return aVar.getDimension() > 1 && aVar.getCharacteristic().equals(d.f14092c) && (aVar instanceof g.a.g.b.f);
    }

    public static boolean isFpCurve(e eVar) {
        return isFpField(eVar.getField());
    }

    public static boolean isFpField(g.a.g.b.a aVar) {
        return aVar.getDimension() == 1;
    }

    public static i j(i[] iVarArr, BigInteger[] bigIntegerArr, g.a.g.a.c0.d dVar) {
        BigInteger order = iVarArr[0].getCurve().getOrder();
        int length = iVarArr.length;
        int i2 = length << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            BigInteger[] bigIntegerArrDecomposeScalar = dVar.decomposeScalar(bigIntegerArr[i4].mod(order));
            int i5 = i3 + 1;
            bigIntegerArr2[i3] = bigIntegerArrDecomposeScalar[0];
            i3 = i5 + 1;
            bigIntegerArr2[i5] = bigIntegerArrDecomposeScalar[1];
        }
        if (dVar.hasEfficientPointMap()) {
            return g(dVar, iVarArr, bigIntegerArr2);
        }
        i[] iVarArr2 = new i[i2];
        int i6 = 0;
        for (i iVar : iVarArr) {
            i iVarMapPoint = g.a.g.a.c0.c.mapPoint(dVar, iVar);
            int i7 = i6 + 1;
            iVarArr2[i6] = iVar;
            i6 = i7 + 1;
            iVarArr2[i7] = iVarMapPoint;
        }
        return h(iVarArr2, bigIntegerArr2);
    }

    public static void montgomeryTrick(f[] fVarArr, int i2, int i3) {
        montgomeryTrick(fVarArr, i2, i3, null);
    }

    public static void montgomeryTrick(f[] fVarArr, int i2, int i3, f fVar) {
        f[] fVarArr2 = new f[i3];
        int i4 = 0;
        fVarArr2[0] = fVarArr[i2];
        while (true) {
            i4++;
            if (i4 >= i3) {
                break;
            } else {
                fVarArr2[i4] = fVarArr2[i4 - 1].multiply(fVarArr[i2 + i4]);
            }
        }
        int i5 = i4 - 1;
        if (fVar != null) {
            fVarArr2[i5] = fVarArr2[i5].multiply(fVar);
        }
        f fVarInvert = fVarArr2[i5].invert();
        while (i5 > 0) {
            int i6 = i5 - 1;
            int i7 = i5 + i2;
            f fVar2 = fVarArr[i7];
            fVarArr[i7] = fVarArr2[i6].multiply(fVarInvert);
            fVarInvert = fVarInvert.multiply(fVar2);
            i5 = i6;
        }
        fVarArr[i2] = fVarInvert;
    }

    public static i referenceMultiply(i iVar, BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        i infinity = iVar.getCurve().getInfinity();
        int iBitLength = bigIntegerAbs.bitLength();
        if (iBitLength > 0) {
            if (bigIntegerAbs.testBit(0)) {
                infinity = iVar;
            }
            for (int i2 = 1; i2 < iBitLength; i2++) {
                iVar = iVar.twice();
                if (bigIntegerAbs.testBit(i2)) {
                    infinity = infinity.add(iVar);
                }
            }
        }
        return bigInteger.signum() < 0 ? infinity.negate() : infinity;
    }

    public static i shamirsTrick(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        return a(c(iVar, bigInteger, importPoint(iVar.getCurve(), iVar2), bigInteger2));
    }

    public static i sumOfMultiplies(i[] iVarArr, BigInteger[] bigIntegerArr) {
        if (iVarArr != null && bigIntegerArr != null && iVarArr.length == bigIntegerArr.length) {
            if (iVarArr.length >= 1) {
                int length = iVarArr.length;
                if (length == 1) {
                    return iVarArr[0].multiply(bigIntegerArr[0]);
                }
                if (length == 2) {
                    return sumOfTwoMultiplies(iVarArr[0], bigIntegerArr[0], iVarArr[1], bigIntegerArr[1]);
                }
                i iVar = iVarArr[0];
                e curve = iVar.getCurve();
                i[] iVarArr2 = new i[length];
                iVarArr2[0] = iVar;
                for (int i2 = 1; i2 < length; i2++) {
                    iVarArr2[i2] = importPoint(curve, iVarArr[i2]);
                }
                g.a.g.a.c0.a endomorphism = curve.getEndomorphism();
                return endomorphism instanceof g.a.g.a.c0.d ? a(j(iVarArr2, bigIntegerArr, (g.a.g.a.c0.d) endomorphism)) : a(h(iVarArr2, bigIntegerArr));
            }
        }
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static i sumOfTwoMultiplies(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        i iVarJ;
        e curve = iVar.getCurve();
        i iVarImportPoint = importPoint(curve, iVar2);
        if ((curve instanceof e.b) && ((e.b) curve).isKoblitz()) {
            iVarJ = iVar.multiply(bigInteger).add(iVarImportPoint.multiply(bigInteger2));
        } else {
            g.a.g.a.c0.a endomorphism = curve.getEndomorphism();
            iVarJ = endomorphism instanceof g.a.g.a.c0.d ? j(new i[]{iVar, iVarImportPoint}, new BigInteger[]{bigInteger, bigInteger2}, (g.a.g.a.c0.d) endomorphism) : d(iVar, bigInteger, iVarImportPoint, bigInteger2);
        }
        return a(iVarJ);
    }

    public static i validatePoint(i iVar) {
        if (iVar.isValid()) {
            return iVar;
        }
        throw new IllegalStateException("Invalid point");
    }
}
