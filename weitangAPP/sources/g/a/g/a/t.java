package g.a.g.a;

import g.a.g.a.e;
import g.a.g.a.i;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f14151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f14152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f14153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0[] f14154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[][] f14155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a0[] f14156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[][] f14157g;

    static {
        BigInteger bigInteger = d.f14091b;
        BigInteger bigIntegerNegate = bigInteger.negate();
        f14151a = bigIntegerNegate;
        f14152b = d.f14092c.negate();
        BigInteger bigIntegerNegate2 = d.f14093d.negate();
        f14153c = bigIntegerNegate2;
        BigInteger bigInteger2 = d.f14090a;
        f14154d = new a0[]{null, new a0(bigInteger, bigInteger2), null, new a0(bigIntegerNegate2, bigIntegerNegate), null, new a0(bigIntegerNegate, bigIntegerNegate), null, new a0(bigInteger, bigIntegerNegate), null};
        f14155e = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        f14156f = new a0[]{null, new a0(bigInteger, bigInteger2), null, new a0(bigIntegerNegate2, bigInteger), null, new a0(bigIntegerNegate, bigInteger), null, new a0(bigInteger, bigInteger), null};
        f14157g = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static int a(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (bigInteger.equals(d.f14092c)) {
                return 1;
            }
            if (bigInteger.equals(d.f14094e)) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static s approximateDivisionByN(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b2, int i2, int i3) {
        BigInteger bigIntegerMultiply = bigInteger2.multiply(bigInteger.shiftRight(((i2 - r0) - 2) + b2));
        BigInteger bigIntegerAdd = bigIntegerMultiply.add(bigInteger3.multiply(bigIntegerMultiply.shiftRight(i2)));
        int i4 = (((i2 + 5) / 2) + i3) - i3;
        BigInteger bigIntegerShiftRight = bigIntegerAdd.shiftRight(i4);
        if (bigIntegerAdd.testBit(i4 - 1)) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(d.f14091b);
        }
        return new s(bigIntegerShiftRight, i3);
    }

    public static BigInteger[] getLucas(byte b2, int i2, boolean z) {
        BigInteger bigInteger;
        BigInteger bigIntegerSubtract;
        if (b2 != 1 && b2 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        if (z) {
            bigInteger = d.f14092c;
            bigIntegerSubtract = BigInteger.valueOf(b2);
        } else {
            bigInteger = d.f14090a;
            bigIntegerSubtract = d.f14091b;
        }
        int i3 = 1;
        while (i3 < i2) {
            i3++;
            BigInteger bigInteger2 = bigIntegerSubtract;
            bigIntegerSubtract = (b2 == 1 ? bigIntegerSubtract : bigIntegerSubtract.negate()).subtract(bigInteger.shiftLeft(1));
            bigInteger = bigInteger2;
        }
        return new BigInteger[]{bigInteger, bigIntegerSubtract};
    }

    public static byte getMu(int i2) {
        return (byte) (i2 == 0 ? -1 : 1);
    }

    public static byte getMu(e.b bVar) {
        if (bVar.isKoblitz()) {
            return bVar.getA().isZero() ? (byte) -1 : (byte) 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static byte getMu(f fVar) {
        return (byte) (fVar.isZero() ? -1 : 1);
    }

    public static i.b[] getPreComp(i.b bVar, byte b2) {
        byte[][] bArr = b2 == 0 ? f14155e : f14157g;
        i.b[] bVarArr = new i.b[(bArr.length + 1) >>> 1];
        bVarArr[0] = bVar;
        int length = bArr.length;
        for (int i2 = 3; i2 < length; i2 += 2) {
            bVarArr[i2 >>> 1] = multiplyFromTnaf(bVar, bArr[i2]);
        }
        bVar.getCurve().normalizeAll(bVarArr);
        return bVarArr;
    }

    public static BigInteger[] getSi(int i2, int i3, BigInteger bigInteger) {
        byte mu = getMu(i3);
        int iA = a(bigInteger);
        BigInteger[] lucas = getLucas(mu, (i2 + 3) - i3, false);
        if (mu == 1) {
            lucas[0] = lucas[0].negate();
            lucas[1] = lucas[1].negate();
        }
        BigInteger bigInteger2 = d.f14091b;
        return new BigInteger[]{bigInteger2.add(lucas[1]).shiftRight(iA), bigInteger2.add(lucas[0]).shiftRight(iA).negate()};
    }

    public static BigInteger[] getSi(e.b bVar) {
        if (!bVar.isKoblitz()) {
            throw new IllegalArgumentException("si is defined for Koblitz curves only");
        }
        int fieldSize = bVar.getFieldSize();
        int iIntValue = bVar.getA().toBigInteger().intValue();
        byte mu = getMu(iIntValue);
        int iA = a(bVar.getCofactor());
        BigInteger[] lucas = getLucas(mu, (fieldSize + 3) - iIntValue, false);
        if (mu == 1) {
            lucas[0] = lucas[0].negate();
            lucas[1] = lucas[1].negate();
        }
        BigInteger bigInteger = d.f14091b;
        return new BigInteger[]{bigInteger.add(lucas[1]).shiftRight(iA), bigInteger.add(lucas[0]).shiftRight(iA).negate()};
    }

    public static BigInteger getTw(byte b2, int i2) {
        if (i2 == 4) {
            return b2 == 1 ? BigInteger.valueOf(6L) : BigInteger.valueOf(10L);
        }
        BigInteger[] lucas = getLucas(b2, i2, false);
        BigInteger bit = d.f14090a.setBit(i2);
        return d.f14092c.multiply(lucas[0]).multiply(lucas[1].modInverse(bit)).mod(bit);
    }

    public static i.b multiplyFromTnaf(i.b bVar, byte[] bArr) {
        i.b bVar2 = (i.b) bVar.getCurve().getInfinity();
        i.b bVar3 = (i.b) bVar.negate();
        int i2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i2++;
            byte b2 = bArr[length];
            if (b2 != 0) {
                bVar2 = (i.b) bVar2.tauPow(i2).add(b2 > 0 ? bVar : bVar3);
                i2 = 0;
            }
        }
        return i2 > 0 ? bVar2.tauPow(i2) : bVar2;
    }

    public static i.b multiplyRTnaf(i.b bVar, BigInteger bigInteger) {
        e.b bVar2 = (e.b) bVar.getCurve();
        int fieldSize = bVar2.getFieldSize();
        int iIntValue = bVar2.getA().toBigInteger().intValue();
        return multiplyTnaf(bVar, partModReduction(bigInteger, fieldSize, (byte) iIntValue, bVar2.i(), getMu(iIntValue), (byte) 10));
    }

    public static i.b multiplyTnaf(i.b bVar, a0 a0Var) {
        return multiplyFromTnaf(bVar, tauAdicNaf(getMu(((e.b) bVar.getCurve()).getA()), a0Var));
    }

    public static s norm(byte b2, s sVar, s sVar2) {
        s sVarSubtract;
        s sVarMultiply = sVar.multiply(sVar);
        s sVarMultiply2 = sVar.multiply(sVar2);
        s sVarShiftLeft = sVar2.multiply(sVar2).shiftLeft(1);
        if (b2 == 1) {
            sVarSubtract = sVarMultiply.add(sVarMultiply2);
        } else {
            if (b2 != -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            sVarSubtract = sVarMultiply.subtract(sVarMultiply2);
        }
        return sVarSubtract.add(sVarShiftLeft);
    }

    public static BigInteger norm(byte b2, a0 a0Var) {
        BigInteger bigIntegerSubtract;
        BigInteger bigInteger = a0Var.f13887a;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger);
        BigInteger bigIntegerMultiply2 = a0Var.f13887a.multiply(a0Var.f13888b);
        BigInteger bigInteger2 = a0Var.f13888b;
        BigInteger bigIntegerShiftLeft = bigInteger2.multiply(bigInteger2).shiftLeft(1);
        if (b2 == 1) {
            bigIntegerSubtract = bigIntegerMultiply.add(bigIntegerMultiply2);
        } else {
            if (b2 != -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            bigIntegerSubtract = bigIntegerMultiply.subtract(bigIntegerMultiply2);
        }
        return bigIntegerSubtract.add(bigIntegerShiftLeft);
    }

    public static a0 partModReduction(BigInteger bigInteger, int i2, byte b2, BigInteger[] bigIntegerArr, byte b3, byte b4) {
        BigInteger bigIntegerAdd = b3 == 1 ? bigIntegerArr[0].add(bigIntegerArr[1]) : bigIntegerArr[0].subtract(bigIntegerArr[1]);
        BigInteger bigInteger2 = getLucas(b3, i2, true)[1];
        a0 a0VarRound = round(approximateDivisionByN(bigInteger, bigIntegerArr[0], bigInteger2, b2, i2, b4), approximateDivisionByN(bigInteger, bigIntegerArr[1], bigInteger2, b2, i2, b4), b3);
        return new a0(bigInteger.subtract(bigIntegerAdd.multiply(a0VarRound.f13887a)).subtract(BigInteger.valueOf(2L).multiply(bigIntegerArr[1]).multiply(a0VarRound.f13888b)), bigIntegerArr[1].multiply(a0VarRound.f13887a).subtract(bigIntegerArr[0].multiply(a0VarRound.f13888b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        if (r5.compareTo(g.a.g.a.t.f14151a) < 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r5.compareTo(r9) >= 0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static g.a.g.a.a0 round(g.a.g.a.s r8, g.a.g.a.s r9, byte r10) {
        /*
            int r0 = r8.getScale()
            int r1 = r9.getScale()
            if (r1 != r0) goto La5
            r0 = -1
            r1 = 1
            if (r10 == r1) goto L19
            if (r10 != r0) goto L11
            goto L19
        L11:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "mu must be 1 or -1"
            r8.<init>(r9)
            throw r8
        L19:
            java.math.BigInteger r2 = r8.round()
            java.math.BigInteger r3 = r9.round()
            g.a.g.a.s r8 = r8.subtract(r2)
            g.a.g.a.s r9 = r9.subtract(r3)
            g.a.g.a.s r4 = r8.add(r8)
            if (r10 != r1) goto L34
            g.a.g.a.s r4 = r4.add(r9)
            goto L38
        L34:
            g.a.g.a.s r4 = r4.subtract(r9)
        L38:
            g.a.g.a.s r5 = r9.add(r9)
            g.a.g.a.s r5 = r5.add(r9)
            g.a.g.a.s r9 = r5.add(r9)
            if (r10 != r1) goto L4f
            g.a.g.a.s r5 = r8.subtract(r5)
            g.a.g.a.s r8 = r8.add(r9)
            goto L57
        L4f:
            g.a.g.a.s r5 = r8.add(r5)
            g.a.g.a.s r8 = r8.subtract(r9)
        L57:
            java.math.BigInteger r9 = g.a.g.a.d.f14091b
            int r6 = r4.compareTo(r9)
            r7 = 0
            if (r6 < 0) goto L69
            java.math.BigInteger r6 = g.a.g.a.t.f14151a
            int r6 = r5.compareTo(r6)
            if (r6 >= 0) goto L73
            goto L71
        L69:
            java.math.BigInteger r1 = g.a.g.a.d.f14092c
            int r1 = r8.compareTo(r1)
            if (r1 < 0) goto L72
        L71:
            r7 = r10
        L72:
            r1 = 0
        L73:
            java.math.BigInteger r6 = g.a.g.a.t.f14151a
            int r4 = r4.compareTo(r6)
            if (r4 >= 0) goto L82
            int r8 = r5.compareTo(r9)
            if (r8 < 0) goto L8d
            goto L8a
        L82:
            java.math.BigInteger r9 = g.a.g.a.t.f14152b
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L8c
        L8a:
            int r8 = -r10
            byte r7 = (byte) r8
        L8c:
            r0 = r1
        L8d:
            long r8 = (long) r0
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r8)
            java.math.BigInteger r8 = r2.add(r8)
            long r9 = (long) r7
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            java.math.BigInteger r9 = r3.add(r9)
            g.a.g.a.a0 r10 = new g.a.g.a.a0
            r10.<init>(r8, r9)
            return r10
        La5:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "lambda0 and lambda1 do not have same scale"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.g.a.t.round(g.a.g.a.s, g.a.g.a.s, byte):g.a.g.a.a0");
    }

    public static i.b tau(i.b bVar) {
        return bVar.tau();
    }

    public static byte[] tauAdicNaf(byte b2, a0 a0Var) {
        if (b2 != 1 && b2 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int iBitLength = norm(b2, a0Var).bitLength();
        byte[] bArr = new byte[iBitLength > 30 ? iBitLength + 4 : 34];
        BigInteger bigIntegerClearBit = a0Var.f13887a;
        BigInteger bigInteger = a0Var.f13888b;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            BigInteger bigInteger2 = d.f14090a;
            if (bigIntegerClearBit.equals(bigInteger2) && bigInteger.equals(bigInteger2)) {
                int i4 = i2 + 1;
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, 0, bArr2, 0, i4);
                return bArr2;
            }
            if (bigIntegerClearBit.testBit(0)) {
                bArr[i3] = (byte) d.f14092c.subtract(bigIntegerClearBit.subtract(bigInteger.shiftLeft(1)).mod(d.f14094e)).intValue();
                bigIntegerClearBit = bArr[i3] == 1 ? bigIntegerClearBit.clearBit(0) : bigIntegerClearBit.add(d.f14091b);
                i2 = i3;
            } else {
                bArr[i3] = 0;
            }
            BigInteger bigIntegerShiftRight = bigIntegerClearBit.shiftRight(1);
            BigInteger bigIntegerAdd = b2 == 1 ? bigInteger.add(bigIntegerShiftRight) : bigInteger.subtract(bigIntegerShiftRight);
            BigInteger bigIntegerNegate = bigIntegerClearBit.shiftRight(1).negate();
            i3++;
            bigIntegerClearBit = bigIntegerAdd;
            bigInteger = bigIntegerNegate;
        }
    }

    public static byte[] tauAdicWNaf(byte b2, a0 a0Var, byte b3, BigInteger bigInteger, BigInteger bigInteger2, a0[] a0VarArr) {
        boolean z;
        if (b2 != 1 && b2 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int iBitLength = norm(b2, a0Var).bitLength();
        byte[] bArr = new byte[iBitLength > 30 ? iBitLength + 4 + b3 : b3 + 34];
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(1);
        BigInteger bigIntegerAdd = a0Var.f13887a;
        BigInteger bigIntegerAdd2 = a0Var.f13888b;
        int i2 = 0;
        while (true) {
            BigInteger bigInteger3 = d.f14090a;
            if (bigIntegerAdd.equals(bigInteger3) && bigIntegerAdd2.equals(bigInteger3)) {
                return bArr;
            }
            if (bigIntegerAdd.testBit(0)) {
                BigInteger bigIntegerMod = bigIntegerAdd.add(bigIntegerAdd2.multiply(bigInteger2)).mod(bigInteger);
                if (bigIntegerMod.compareTo(bigIntegerShiftRight) >= 0) {
                    bigIntegerMod = bigIntegerMod.subtract(bigInteger);
                }
                byte bIntValue = (byte) bigIntegerMod.intValue();
                bArr[i2] = bIntValue;
                if (bIntValue < 0) {
                    bIntValue = (byte) (-bIntValue);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    bigIntegerAdd = bigIntegerAdd.subtract(a0VarArr[bIntValue].f13887a);
                    bigIntegerAdd2 = bigIntegerAdd2.subtract(a0VarArr[bIntValue].f13888b);
                } else {
                    bigIntegerAdd = bigIntegerAdd.add(a0VarArr[bIntValue].f13887a);
                    bigIntegerAdd2 = bigIntegerAdd2.add(a0VarArr[bIntValue].f13888b);
                }
            } else {
                bArr[i2] = 0;
            }
            BigInteger bigIntegerShiftRight2 = bigIntegerAdd.shiftRight(1);
            BigInteger bigIntegerAdd3 = b2 == 1 ? bigIntegerAdd2.add(bigIntegerShiftRight2) : bigIntegerAdd2.subtract(bigIntegerShiftRight2);
            BigInteger bigIntegerNegate = bigIntegerAdd.shiftRight(1).negate();
            i2++;
            bigIntegerAdd = bigIntegerAdd3;
            bigIntegerAdd2 = bigIntegerNegate;
        }
    }
}
