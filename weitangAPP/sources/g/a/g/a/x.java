package g.a.g.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14167a = {13, 41, TTDownloadField.CALL_DOWNLOAD_MODEL_DISTINCT_DIR, 337, 897, 2305};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f14168b = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f14169c = new int[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i[] f14170d = new i[0];

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14171a;

        public a(int i2) {
            this.f14171a = i2;
        }

        @Override // g.a.g.a.p
        public q precompute(q qVar) {
            w wVar = qVar instanceof w ? (w) qVar : null;
            if (wVar != null && wVar.getConfWidth() == this.f14171a) {
                wVar.c(0);
                return wVar;
            }
            w wVar2 = new w();
            wVar2.c(0);
            wVar2.setConfWidth(this.f14171a);
            if (wVar != null) {
                wVar2.setPreComp(wVar.getPreComp());
                wVar2.setPreCompNeg(wVar.getPreCompNeg());
                wVar2.setTwice(wVar.getTwice());
                wVar2.setWidth(wVar.getWidth());
            }
            return wVar2;
        }
    }

    public static class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f14174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f14175d;

        public b(int i2, boolean z, i iVar, e eVar) {
            this.f14172a = i2;
            this.f14173b = z;
            this.f14174c = iVar;
            this.f14175d = eVar;
        }

        public final boolean a(w wVar, int i2, int i3, boolean z) {
            return wVar != null && wVar.getWidth() >= Math.max(wVar.getConfWidth(), i2) && b(wVar.getPreComp(), i3) && (!z || b(wVar.getPreCompNeg(), i3));
        }

        public final boolean b(i[] iVarArr, int i2) {
            return iVarArr != null && iVarArr.length >= i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[PHI: r14
  0x00ef: PHI (r14v6 g.a.g.a.i) = (r14v4 g.a.g.a.i), (r14v9 g.a.g.a.i), (r14v9 g.a.g.a.i), (r14v9 g.a.g.a.i), (r14v9 g.a.g.a.i) binds: [B:28:0x0091, B:30:0x009d, B:32:0x00a5, B:34:0x00af, B:40:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0117 A[LOOP:1: B:57:0x0115->B:58:0x0117, LOOP_END] */
        @Override // g.a.g.a.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public g.a.g.a.q precompute(g.a.g.a.q r14) {
            /*
                Method dump skipped, instruction units count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.g.a.x.b.precompute(g.a.g.a.q):g.a.g.a.q");
        }
    }

    public static class c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f14176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f14178c;

        public c(w wVar, boolean z, j jVar) {
            this.f14176a = wVar;
            this.f14177b = z;
            this.f14178c = jVar;
        }

        public final boolean a(w wVar, int i2, int i3, boolean z) {
            return wVar != null && wVar.getWidth() >= i2 && b(wVar.getPreComp(), i3) && (!z || b(wVar.getPreCompNeg(), i3));
        }

        public final boolean b(i[] iVarArr, int i2) {
            return iVarArr != null && iVarArr.length >= i2;
        }

        @Override // g.a.g.a.p
        public q precompute(q qVar) {
            w wVar = qVar instanceof w ? (w) qVar : null;
            int width = this.f14176a.getWidth();
            if (a(wVar, width, this.f14176a.getPreComp().length, this.f14177b)) {
                wVar.a();
                return wVar;
            }
            w wVar2 = new w();
            wVar2.c(this.f14176a.b());
            i twice = this.f14176a.getTwice();
            if (twice != null) {
                wVar2.setTwice(this.f14178c.map(twice));
            }
            i[] preComp = this.f14176a.getPreComp();
            int length = preComp.length;
            i[] iVarArr = new i[length];
            for (int i2 = 0; i2 < preComp.length; i2++) {
                iVarArr[i2] = this.f14178c.map(preComp[i2]);
            }
            wVar2.setPreComp(iVarArr);
            wVar2.setWidth(width);
            if (this.f14177b) {
                i[] iVarArr2 = new i[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iVarArr2[i3] = iVarArr[i3].negate();
                }
                wVar2.setPreCompNeg(iVarArr2);
            }
            return wVar2;
        }
    }

    public static i[] c(i[] iVarArr, int i2) {
        i[] iVarArr2 = new i[i2];
        System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
        return iVarArr2;
    }

    public static void configureBasepoint(i iVar) {
        e curve = iVar.getCurve();
        if (curve == null) {
            return;
        }
        BigInteger order = curve.getOrder();
        curve.precompute(iVar, "bc_wnaf", new a(Math.min(16, getWindowSize(order == null ? curve.getFieldSize() + 1 : order.bitLength()) + 3)));
    }

    public static byte[] d(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    public static int[] e(int[] iArr, int i2) {
        int[] iArr2 = new int[i2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        return iArr2;
    }

    public static int[] generateCompactNaf(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (bigInteger.signum() == 0) {
            return f14169c;
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength();
        int i2 = iBitLength >> 1;
        int[] iArr = new int[i2];
        BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
        int i3 = iBitLength - 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i6 < i3) {
            if (bigIntegerXor.testBit(i6)) {
                iArr[i4] = i5 | ((bigInteger.testBit(i6) ? -1 : 1) << 16);
                i6++;
                i4++;
                i5 = 1;
            } else {
                i5++;
            }
            i6++;
        }
        int i7 = i4 + 1;
        iArr[i4] = 65536 | i5;
        return i2 > i7 ? e(iArr, i7) : iArr;
    }

    public static int[] generateCompactWindowNaf(int i2, BigInteger bigInteger) {
        if (i2 == 2) {
            return generateCompactNaf(bigInteger);
        }
        if (i2 < 2 || i2 > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        }
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (bigInteger.signum() == 0) {
            return f14169c;
        }
        int iBitLength = (bigInteger.bitLength() / i2) + 1;
        int[] iArr = new int[iBitLength];
        int i3 = 1 << i2;
        int i4 = i3 - 1;
        int i5 = i3 >>> 1;
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        while (i6 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i6) == z) {
                i6++;
            } else {
                bigInteger = bigInteger.shiftRight(i6);
                int iIntValue = bigInteger.intValue() & i4;
                if (z) {
                    iIntValue++;
                }
                z = (iIntValue & i5) != 0;
                if (z) {
                    iIntValue -= i3;
                }
                if (i7 > 0) {
                    i6--;
                }
                iArr[i7] = i6 | (iIntValue << 16);
                i6 = i2;
                i7++;
            }
        }
        return iBitLength > i7 ? e(iArr, i7) : iArr;
    }

    public static byte[] generateJSF(BigInteger bigInteger, BigInteger bigInteger2) {
        int iMax = Math.max(bigInteger.bitLength(), bigInteger2.bitLength()) + 1;
        byte[] bArr = new byte[iMax];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if ((i2 | i3) == 0 && bigInteger.bitLength() <= i4 && bigInteger2.bitLength() <= i4) {
                break;
            }
            int iIntValue = ((bigInteger.intValue() >>> i4) + i2) & 7;
            int iIntValue2 = ((bigInteger2.intValue() >>> i4) + i3) & 7;
            int i6 = iIntValue & 1;
            if (i6 != 0) {
                i6 -= iIntValue & 2;
                if (iIntValue + i6 == 4 && (iIntValue2 & 3) == 2) {
                    i6 = -i6;
                }
            }
            int i7 = iIntValue2 & 1;
            if (i7 != 0) {
                i7 -= iIntValue2 & 2;
                if (iIntValue2 + i7 == 4 && (iIntValue & 3) == 2) {
                    i7 = -i7;
                }
            }
            if ((i2 << 1) == i6 + 1) {
                i2 ^= 1;
            }
            if ((i3 << 1) == i7 + 1) {
                i3 ^= 1;
            }
            i4++;
            if (i4 == 30) {
                bigInteger = bigInteger.shiftRight(30);
                bigInteger2 = bigInteger2.shiftRight(30);
                i4 = 0;
            }
            bArr[i5] = (byte) ((i6 << 4) | (i7 & 15));
            i5++;
        }
        return iMax > i5 ? d(bArr, i5) : bArr;
    }

    public static byte[] generateNaf(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return f14168b;
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength() - 1;
        byte[] bArr = new byte[iBitLength];
        BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
        int i2 = 1;
        while (i2 < iBitLength) {
            if (bigIntegerXor.testBit(i2)) {
                bArr[i2 - 1] = (byte) (bigInteger.testBit(i2) ? -1 : 1);
                i2++;
            }
            i2++;
        }
        bArr[iBitLength - 1] = 1;
        return bArr;
    }

    public static byte[] generateWindowNaf(int i2, BigInteger bigInteger) {
        if (i2 == 2) {
            return generateNaf(bigInteger);
        }
        if (i2 < 2 || i2 > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        }
        if (bigInteger.signum() == 0) {
            return f14168b;
        }
        int iBitLength = bigInteger.bitLength() + 1;
        byte[] bArr = new byte[iBitLength];
        int i3 = 1 << i2;
        int i4 = i3 - 1;
        int i5 = i3 >>> 1;
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        while (i6 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i6) == z) {
                i6++;
            } else {
                bigInteger = bigInteger.shiftRight(i6);
                int iIntValue = bigInteger.intValue() & i4;
                if (z) {
                    iIntValue++;
                }
                z = (iIntValue & i5) != 0;
                if (z) {
                    iIntValue -= i3;
                }
                if (i7 > 0) {
                    i6--;
                }
                int i8 = i7 + i6;
                bArr[i8] = (byte) iIntValue;
                i7 = i8 + 1;
                i6 = i2;
            }
        }
        return iBitLength > i7 ? d(bArr, i7) : bArr;
    }

    public static int getNafWeight(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static w getWNafPreCompInfo(i iVar) {
        return getWNafPreCompInfo(iVar.getCurve().getPreCompInfo(iVar, "bc_wnaf"));
    }

    public static w getWNafPreCompInfo(q qVar) {
        if (qVar instanceof w) {
            return (w) qVar;
        }
        return null;
    }

    public static int getWindowSize(int i2) {
        return getWindowSize(i2, f14167a, 16);
    }

    public static int getWindowSize(int i2, int i3) {
        return getWindowSize(i2, f14167a, i3);
    }

    public static int getWindowSize(int i2, int[] iArr) {
        return getWindowSize(i2, iArr, 16);
    }

    public static int getWindowSize(int i2, int[] iArr, int i3) {
        int i4 = 0;
        while (i4 < iArr.length && i2 >= iArr[i4]) {
            i4++;
        }
        return Math.max(2, Math.min(i3, i4 + 2));
    }

    public static w precompute(i iVar, int i2, boolean z) {
        e curve = iVar.getCurve();
        return (w) curve.precompute(iVar, "bc_wnaf", new b(i2, z, iVar, curve));
    }

    public static w precomputeWithPointMap(i iVar, j jVar, w wVar, boolean z) {
        return (w) iVar.getCurve().precompute(iVar, "bc_wnaf", new c(wVar, z, jVar));
    }
}
