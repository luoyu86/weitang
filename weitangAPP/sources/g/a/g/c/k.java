package g.a.g.c;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static void copy64(long[] jArr, int i2, long[] jArr2, int i3) {
        jArr2[i3 + 0] = jArr[i2 + 0];
        jArr2[i3 + 1] = jArr[i2 + 1];
        jArr2[i3 + 2] = jArr[i2 + 2];
        jArr2[i3 + 3] = jArr[i2 + 3];
        jArr2[i3 + 4] = jArr[i2 + 4];
        jArr2[i3 + 5] = jArr[i2 + 5];
        jArr2[i3 + 6] = jArr[i2 + 6];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    public static long[] create64() {
        return new long[7];
    }

    public static long[] createExt64() {
        return new long[14];
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i2 = 6; i2 >= 0; i2--) {
            if (jArr[i2] != jArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 448) {
            throw new IllegalArgumentException();
        }
        long[] jArrCreate64 = create64();
        for (int i2 = 0; i2 < 7; i2++) {
            jArrCreate64[i2] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrCreate64;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 7; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i2 = 0; i2 < 7; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        g.mul(iArr, iArr2, iArr3);
        g.mul(iArr, 7, iArr2, 7, iArr3, 14);
        int iAddToEachOther = g.addToEachOther(iArr3, 7, iArr3, 14);
        int iAddTo = iAddToEachOther + g.addTo(iArr3, 21, iArr3, 14, g.addTo(iArr3, 0, iArr3, 7, 0) + iAddToEachOther);
        int[] iArrCreate = g.create();
        int[] iArrCreate2 = g.create();
        boolean z = g.diff(iArr, 7, iArr, 0, iArrCreate, 0) != g.diff(iArr2, 7, iArr2, 0, iArrCreate2, 0);
        int[] iArrCreateExt = g.createExt();
        g.mul(iArrCreate, iArrCreate2, iArrCreateExt);
        n.addWordAt(28, iAddTo + (z ? n.addTo(14, iArrCreateExt, 0, iArr3, 7) : n.subFrom(14, iArrCreateExt, 0, iArr3, 7)), iArr3, 21);
    }

    public static void square(int[] iArr, int[] iArr2) {
        g.square(iArr, iArr2);
        g.square(iArr, 7, iArr2, 14);
        int iAddToEachOther = g.addToEachOther(iArr2, 7, iArr2, 14);
        int iAddTo = iAddToEachOther + g.addTo(iArr2, 21, iArr2, 14, g.addTo(iArr2, 0, iArr2, 7, 0) + iAddToEachOther);
        int[] iArrCreate = g.create();
        g.diff(iArr, 7, iArr, 0, iArrCreate, 0);
        int[] iArrCreateExt = g.createExt();
        g.square(iArrCreate, iArrCreateExt);
        n.addWordAt(28, iAddTo + n.subFrom(14, iArrCreateExt, 0, iArr2, 7), iArr2, 21);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[56];
        for (int i2 = 0; i2 < 7; i2++) {
            long j = jArr[i2];
            if (j != 0) {
                g.a.j.k.longToBigEndian(j, bArr, (6 - i2) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
