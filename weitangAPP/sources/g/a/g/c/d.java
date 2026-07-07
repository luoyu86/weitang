package g.a.g.c;

import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + (((long) iArr2[0]) & UIDFolder.MAXUID) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + (((long) iArr2[1]) & UIDFolder.MAXUID);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + (((long) iArr2[2]) & UIDFolder.MAXUID);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + (((long) iArr2[3]) & UIDFolder.MAXUID);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + (((long) iArr2[0]) & UIDFolder.MAXUID) + (((long) iArr3[0]) & UIDFolder.MAXUID) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + (((long) iArr2[1]) & UIDFolder.MAXUID) + (((long) iArr3[1]) & UIDFolder.MAXUID);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + (((long) iArr2[2]) & UIDFolder.MAXUID) + (((long) iArr3[2]) & UIDFolder.MAXUID);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + (((long) iArr2[3]) & UIDFolder.MAXUID) + (((long) iArr3[3]) & UIDFolder.MAXUID);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addTo(int[] iArr, int i2, int[] iArr2, int i3, int i4) {
        int i5 = i3 + 0;
        long j = (((long) i4) & UIDFolder.MAXUID) + (((long) iArr[i2 + 0]) & UIDFolder.MAXUID) + (((long) iArr2[i5]) & UIDFolder.MAXUID);
        iArr2[i5] = (int) j;
        int i6 = i3 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i2 + 1]) & UIDFolder.MAXUID) + (((long) iArr2[i6]) & UIDFolder.MAXUID);
        iArr2[i6] = (int) j2;
        int i7 = i3 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i2 + 2]) & UIDFolder.MAXUID) + (((long) iArr2[i7]) & UIDFolder.MAXUID);
        iArr2[i7] = (int) j3;
        int i8 = i3 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i2 + 3]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) iArr2[i8]));
        iArr2[i8] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + (((long) iArr2[0]) & UIDFolder.MAXUID) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + (((long) iArr2[1]) & UIDFolder.MAXUID);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + (((long) iArr2[2]) & UIDFolder.MAXUID);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) iArr2[3]));
        iArr2[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i2 + 0;
        int i5 = i3 + 0;
        long j = (((long) iArr[i4]) & UIDFolder.MAXUID) + (((long) iArr2[i5]) & UIDFolder.MAXUID) + 0;
        int i6 = (int) j;
        iArr[i4] = i6;
        iArr2[i5] = i6;
        int i7 = i2 + 1;
        int i8 = i3 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i7]) & UIDFolder.MAXUID) + (((long) iArr2[i8]) & UIDFolder.MAXUID);
        int i9 = (int) j2;
        iArr[i7] = i9;
        iArr2[i8] = i9;
        int i10 = i2 + 2;
        int i11 = i3 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i10]) & UIDFolder.MAXUID) + (((long) iArr2[i11]) & UIDFolder.MAXUID);
        int i12 = (int) j3;
        iArr[i10] = i12;
        iArr2[i11] = i12;
        int i13 = i2 + 3;
        int i14 = i3 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i13]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) iArr2[i14]));
        int i15 = (int) j4;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        return (int) (j4 >>> 32);
    }

    public static void copy(int[] iArr, int i2, int[] iArr2, int i3) {
        iArr2[i3 + 0] = iArr[i2 + 0];
        iArr2[i3 + 1] = iArr[i2 + 1];
        iArr2[i3 + 2] = iArr[i2 + 2];
        iArr2[i3 + 3] = iArr[i2 + 3];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void copy64(long[] jArr, int i2, long[] jArr2, int i3) {
        jArr2[i3 + 0] = jArr[i2 + 0];
        jArr2[i3 + 1] = jArr[i2 + 1];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static int[] create() {
        return new int[4];
    }

    public static long[] create64() {
        return new long[2];
    }

    public static int[] createExt() {
        return new int[8];
    }

    public static long[] createExt64() {
        return new long[4];
    }

    public static boolean diff(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        boolean zGte = gte(iArr, i2, iArr2, i3);
        if (zGte) {
            sub(iArr, i2, iArr2, i3, iArr3, i4);
        } else {
            sub(iArr2, i3, iArr, i2, iArr3, i4);
        }
        return zGte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i2 = 3; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i2 = 1; i2 >= 0; i2--) {
            if (jArr[i2] != jArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] iArrCreate = create();
        for (int i2 = 0; i2 < 4; i2++) {
            iArrCreate[i2] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrCreate;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        long[] jArrCreate64 = create64();
        for (int i2 = 0; i2 < 2; i2++) {
            jArrCreate64[i2] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrCreate64;
    }

    public static int getBit(int[] iArr, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = iArr[0];
        } else {
            int i4 = i2 >> 5;
            if (i4 < 0 || i4 >= 4) {
                return 0;
            }
            i3 = iArr[i4] >>> (i2 & 31);
        }
        return i3 & 1;
    }

    public static boolean gte(int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 3; i4 >= 0; i4--) {
            int i5 = iArr[i2 + i4] ^ Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE ^ iArr2[i3 + i4];
            if (i5 < i6) {
                return false;
            }
            if (i5 > i6) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i2 = 3; i2 >= 0; i2--) {
            int i3 = iArr[i2] ^ Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE ^ iArr2[i2];
            if (i3 < i4) {
                return false;
            }
            if (i3 > i4) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 4; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 2; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) iArr2[i3 + 0]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr2[i3 + 1]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr2[i3 + 2]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[i3 + 3]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr[i2 + 0]) & UIDFolder.MAXUID;
        long j6 = (j5 * j) + 0;
        iArr3[i4 + 0] = (int) j6;
        long j7 = (j6 >>> 32) + (j5 * j2);
        iArr3[i4 + 1] = (int) j7;
        long j8 = (j7 >>> 32) + (j5 * j3);
        iArr3[i4 + 2] = (int) j8;
        long j9 = (j8 >>> 32) + (j5 * j4);
        iArr3[i4 + 3] = (int) j9;
        iArr3[i4 + 4] = (int) (j9 >>> 32);
        int i5 = 1;
        int i6 = i4;
        int i7 = 1;
        while (i7 < 4) {
            i6 += i5;
            long j10 = ((long) iArr[i2 + i7]) & UIDFolder.MAXUID;
            int i8 = i6 + 0;
            long j11 = j;
            long j12 = (j10 * j) + (((long) iArr3[i8]) & UIDFolder.MAXUID) + 0;
            iArr3[i8] = (int) j12;
            int i9 = i6 + 1;
            long j13 = (j12 >>> 32) + (j10 * j2) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
            iArr3[i9] = (int) j13;
            int i10 = i6 + 2;
            long j14 = j2;
            long j15 = (j13 >>> 32) + (j10 * j3) + (((long) iArr3[i10]) & UIDFolder.MAXUID);
            iArr3[i10] = (int) j15;
            int i11 = i6 + 3;
            long j16 = (j15 >>> 32) + (j10 * j4) + (((long) iArr3[i11]) & UIDFolder.MAXUID);
            iArr3[i11] = (int) j16;
            iArr3[i6 + 4] = (int) (j16 >>> 32);
            i7++;
            j2 = j14;
            j = j11;
            i5 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & UIDFolder.MAXUID;
        int i2 = 1;
        long j2 = ((long) iArr2[1]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr2[2]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[3]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr[0]) & UIDFolder.MAXUID;
        long j6 = (j5 * j) + 0;
        iArr3[0] = (int) j6;
        long j7 = (j6 >>> 32) + (j5 * j2);
        iArr3[1] = (int) j7;
        long j8 = (j7 >>> 32) + (j5 * j3);
        iArr3[2] = (int) j8;
        long j9 = (j8 >>> 32) + (j5 * j4);
        iArr3[3] = (int) j9;
        int i3 = (int) (j9 >>> 32);
        iArr3[4] = i3;
        for (int i4 = 4; i2 < i4; i4 = 4) {
            long j10 = ((long) iArr[i2]) & UIDFolder.MAXUID;
            int i5 = i2 + 0;
            long j11 = (j10 * j) + (((long) iArr3[i5]) & UIDFolder.MAXUID) + 0;
            iArr3[i5] = (int) j11;
            int i6 = i2 + 1;
            long j12 = (j11 >>> 32) + (j10 * j2) + (((long) iArr3[i6]) & UIDFolder.MAXUID);
            iArr3[i6] = (int) j12;
            int i7 = i2 + 2;
            long j13 = (j12 >>> 32) + (j10 * j3) + (((long) iArr3[i7]) & UIDFolder.MAXUID);
            iArr3[i7] = (int) j13;
            int i8 = i2 + 3;
            long j14 = (j13 >>> 32) + (j10 * j4) + (((long) iArr3[i8]) & UIDFolder.MAXUID);
            iArr3[i8] = (int) j14;
            iArr3[i2 + 4] = (int) (j14 >>> 32);
            i2 = i6;
            j = j;
        }
    }

    public static long mul33Add(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[i3 + 0]) & UIDFolder.MAXUID;
        long j3 = (j * j2) + (((long) iArr2[i4 + 0]) & UIDFolder.MAXUID) + 0;
        iArr3[i5 + 0] = (int) j3;
        long j4 = ((long) iArr[i3 + 1]) & UIDFolder.MAXUID;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i4 + 1]) & UIDFolder.MAXUID);
        iArr3[i5 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i3 + 2]) & UIDFolder.MAXUID;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i4 + 2]) & UIDFolder.MAXUID);
        iArr3[i5 + 2] = (int) j8;
        long j9 = ((long) iArr[i3 + 3]) & UIDFolder.MAXUID;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (UIDFolder.MAXUID & ((long) iArr2[i4 + 3]));
        iArr3[i5 + 3] = (int) j10;
        return (j10 >>> 32) + j9;
    }

    public static int mul33DWordAdd(int i2, long j, int[] iArr, int i3) {
        long j2 = ((long) i2) & UIDFolder.MAXUID;
        long j3 = j & UIDFolder.MAXUID;
        int i4 = i3 + 0;
        long j4 = (j2 * j3) + (((long) iArr[i4]) & UIDFolder.MAXUID) + 0;
        iArr[i4] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr[i5]) & UIDFolder.MAXUID);
        iArr[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr[i6]) & UIDFolder.MAXUID);
        iArr[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (j8 >>> 32) + (((long) iArr[i7]) & UIDFolder.MAXUID);
        iArr[i7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mul33WordAdd(int i2, int i3, int[] iArr, int i4) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        long j2 = ((long) i3) & UIDFolder.MAXUID;
        int i5 = i4 + 0;
        long j3 = (j * j2) + (((long) iArr[i5]) & UIDFolder.MAXUID) + 0;
        iArr[i5] = (int) j3;
        int i6 = i4 + 1;
        long j4 = (j3 >>> 32) + j2 + (((long) iArr[i6]) & UIDFolder.MAXUID);
        iArr[i6] = (int) j4;
        long j5 = j4 >>> 32;
        int i7 = i4 + 2;
        long j6 = j5 + (((long) iArr[i7]) & UIDFolder.MAXUID);
        iArr[i7] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return n.incAt(4, iArr, i4, 3);
    }

    public static int mulAddTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = iArr2[i3 + 0];
        long j2 = UIDFolder.MAXUID;
        long j3 = j & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[i3 + 1]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr2[i3 + 2]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr2[i3 + 3]) & UIDFolder.MAXUID;
        int i5 = i4;
        int i6 = 0;
        long j7 = 0;
        while (i6 < 4) {
            long j8 = ((long) iArr[i2 + i6]) & j2;
            int i7 = i5 + 0;
            long j9 = (j8 * j3) + (((long) iArr3[i7]) & j2) + 0;
            iArr3[i7] = (int) j9;
            int i8 = i5 + 1;
            long j10 = j4;
            long j11 = (j9 >>> 32) + (j8 * j4) + (((long) iArr3[i8]) & UIDFolder.MAXUID);
            iArr3[i8] = (int) j11;
            int i9 = i5 + 2;
            long j12 = (j11 >>> 32) + (j8 * j5) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
            iArr3[i9] = (int) j12;
            int i10 = i5 + 3;
            long j13 = (j12 >>> 32) + (j8 * j6) + (((long) iArr3[i10]) & UIDFolder.MAXUID);
            iArr3[i10] = (int) j13;
            int i11 = i5 + 4;
            long j14 = j7 + (j13 >>> 32) + (((long) iArr3[i11]) & UIDFolder.MAXUID);
            iArr3[i11] = (int) j14;
            j7 = j14 >>> 32;
            i6++;
            i5 = i8;
            j3 = j3;
            j2 = 4294967295L;
            j4 = j10;
            j5 = j5;
        }
        return (int) j7;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = 0;
        long j = iArr2[0];
        long j2 = UIDFolder.MAXUID;
        long j3 = j & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[1]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr2[2]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr2[3]) & UIDFolder.MAXUID;
        long j7 = 0;
        while (i2 < 4) {
            long j8 = ((long) iArr[i2]) & j2;
            int i3 = i2 + 0;
            long j9 = (j8 * j3) + (((long) iArr3[i3]) & j2) + 0;
            iArr3[i3] = (int) j9;
            int i4 = i2 + 1;
            long j10 = (j9 >>> 32) + (j8 * j4) + (((long) iArr3[i4]) & UIDFolder.MAXUID);
            iArr3[i4] = (int) j10;
            int i5 = i2 + 2;
            long j11 = (j10 >>> 32) + (j8 * j5) + (((long) iArr3[i5]) & UIDFolder.MAXUID);
            iArr3[i5] = (int) j11;
            int i6 = i2 + 3;
            long j12 = (j11 >>> 32) + (j8 * j6) + (((long) iArr3[i6]) & UIDFolder.MAXUID);
            iArr3[i6] = (int) j12;
            int i7 = i2 + 4;
            long j13 = j7 + (j12 >>> 32) + (((long) iArr3[i7]) & UIDFolder.MAXUID);
            iArr3[i7] = (int) j13;
            j7 = j13 >>> 32;
            i2 = i4;
            j2 = 4294967295L;
            j3 = j3;
            j4 = j4;
        }
        return (int) j7;
    }

    public static int mulWord(int i2, int[] iArr, int[] iArr2, int i3) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        long j2 = 0;
        int i4 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i4]) & UIDFolder.MAXUID) * j);
            iArr2[i3 + i4] = (int) j3;
            j2 = j3 >>> 32;
            i4++;
        } while (i4 < 4);
        return (int) j2;
    }

    public static int mulWordAddExt(int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        int i5 = i4 + 0;
        long j2 = ((((long) iArr[i3 + 0]) & UIDFolder.MAXUID) * j) + (((long) iArr2[i5]) & UIDFolder.MAXUID) + 0;
        iArr2[i5] = (int) j2;
        int i6 = i4 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i3 + 1]) & UIDFolder.MAXUID) * j) + (((long) iArr2[i6]) & UIDFolder.MAXUID);
        iArr2[i6] = (int) j3;
        int i7 = i4 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i3 + 2]) & UIDFolder.MAXUID) * j) + (((long) iArr2[i7]) & UIDFolder.MAXUID);
        iArr2[i7] = (int) j4;
        int i8 = i4 + 3;
        long j5 = (j4 >>> 32) + (j * (((long) iArr[i3 + 3]) & UIDFolder.MAXUID)) + (((long) iArr2[i8]) & UIDFolder.MAXUID);
        iArr2[i8] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int mulWordDwordAdd(int i2, long j, int[] iArr, int i3) {
        long j2 = ((long) i2) & UIDFolder.MAXUID;
        int i4 = i3 + 0;
        long j3 = ((j & UIDFolder.MAXUID) * j2) + (((long) iArr[i4]) & UIDFolder.MAXUID) + 0;
        iArr[i4] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i5 = i3 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i5]) & UIDFolder.MAXUID);
        iArr[i5] = (int) j5;
        int i6 = i3 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i6]) & UIDFolder.MAXUID);
        iArr[i6] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return n.incAt(4, iArr, i3, 3);
    }

    public static int mulWordsAdd(int i2, int i3, int[] iArr, int i4) {
        long j = (((long) i3) & UIDFolder.MAXUID) * (((long) i2) & UIDFolder.MAXUID);
        int i5 = i4 + 0;
        long j2 = j + (((long) iArr[i5]) & UIDFolder.MAXUID) + 0;
        iArr[i5] = (int) j2;
        int i6 = i4 + 1;
        long j3 = (j2 >>> 32) + (UIDFolder.MAXUID & ((long) iArr[i6]));
        iArr[i6] = (int) j3;
        if ((j3 >>> 32) == 0) {
            return 0;
        }
        return n.incAt(4, iArr, i4, 2);
    }

    public static void square(int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) iArr[i2 + 0]) & UIDFolder.MAXUID;
        int i4 = 0;
        int i5 = 8;
        int i6 = 3;
        while (true) {
            int i7 = i6 - 1;
            long j2 = ((long) iArr[i2 + i6]) & UIDFolder.MAXUID;
            long j3 = j2 * j2;
            int i8 = i5 - 1;
            iArr2[i3 + i8] = (i4 << 31) | ((int) (j3 >>> 33));
            i5 = i8 - 1;
            iArr2[i3 + i5] = (int) (j3 >>> 1);
            i4 = (int) j3;
            if (i7 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i4 << 31)) & UIDFolder.MAXUID) | (j4 >>> 33);
                iArr2[i3 + 0] = (int) j4;
                long j6 = ((long) iArr[i2 + 1]) & UIDFolder.MAXUID;
                int i9 = i3 + 2;
                long j7 = ((long) iArr2[i9]) & UIDFolder.MAXUID;
                long j8 = j5 + (j6 * j);
                int i10 = (int) j8;
                iArr2[i3 + 1] = (i10 << 1) | (((int) (j4 >>> 32)) & 1);
                int i11 = i10 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[i2 + 2]) & UIDFolder.MAXUID;
                int i12 = i3 + 3;
                long j11 = ((long) iArr2[i12]) & UIDFolder.MAXUID;
                int i13 = i3 + 4;
                long j12 = ((long) iArr2[i13]) & UIDFolder.MAXUID;
                long j13 = j9 + (j10 * j);
                int i14 = (int) j13;
                iArr2[i9] = (i14 << 1) | i11;
                int i15 = i14 >>> 31;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & UIDFolder.MAXUID;
                long j17 = ((long) iArr[i2 + 3]) & UIDFolder.MAXUID;
                int i16 = i3 + 5;
                long j18 = (((long) iArr2[i16]) & UIDFolder.MAXUID) + (j15 >>> 32);
                long j19 = j15 & UIDFolder.MAXUID;
                int i17 = i3 + 6;
                long j20 = (((long) iArr2[i17]) & UIDFolder.MAXUID) + (j18 >>> 32);
                long j21 = UIDFolder.MAXUID & j18;
                long j22 = j16 + (j * j17);
                int i18 = (int) j22;
                iArr2[i12] = (i18 << 1) | i15;
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j20 + (j24 >>> 32);
                int i19 = (int) j23;
                iArr2[i13] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j24;
                iArr2[i16] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j25;
                iArr2[i17] = i22 | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = i3 + 7;
                iArr2[i25] = i24 | ((iArr2[i25] + ((int) (j25 >>> 32))) << 1);
                return;
            }
            i6 = i7;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & UIDFolder.MAXUID;
        int i2 = 8;
        int i3 = 3;
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            long j2 = ((long) iArr[i3]) & UIDFolder.MAXUID;
            long j3 = j2 * j2;
            int i6 = i2 - 1;
            iArr2[i6] = (i4 << 31) | ((int) (j3 >>> 33));
            i2 = i6 - 1;
            iArr2[i2] = (int) (j3 >>> 1);
            int i7 = (int) j3;
            if (i5 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i7 << 31)) & UIDFolder.MAXUID) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & UIDFolder.MAXUID;
                long j7 = ((long) iArr2[2]) & UIDFolder.MAXUID;
                long j8 = j5 + (j6 * j);
                int i8 = (int) j8;
                iArr2[1] = (i8 << 1) | (((int) (j4 >>> 32)) & 1);
                int i9 = i8 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & UIDFolder.MAXUID;
                long j11 = ((long) iArr2[3]) & UIDFolder.MAXUID;
                long j12 = ((long) iArr2[4]) & UIDFolder.MAXUID;
                long j13 = j9 + (j10 * j);
                int i10 = (int) j13;
                iArr2[2] = (i10 << 1) | i9;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & UIDFolder.MAXUID;
                long j17 = ((long) iArr[3]) & UIDFolder.MAXUID;
                long j18 = (((long) iArr2[5]) & UIDFolder.MAXUID) + (j15 >>> 32);
                long j19 = j15 & UIDFolder.MAXUID;
                long j20 = (((long) iArr2[6]) & UIDFolder.MAXUID) + (j18 >>> 32);
                long j21 = j18 & UIDFolder.MAXUID;
                long j22 = j16 + (j * j17);
                int i11 = (int) j22;
                iArr2[3] = (i11 << 1) | (i10 >>> 31);
                long j23 = j19 + (j22 >>> 32) + (j6 * j17);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j20 + (j24 >>> 32);
                long j26 = j24 & UIDFolder.MAXUID;
                int i12 = (int) j23;
                iArr2[4] = (i11 >>> 31) | (i12 << 1);
                int i13 = (int) j26;
                iArr2[5] = (i12 >>> 31) | (i13 << 1);
                int i14 = (int) j25;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                iArr2[7] = ((iArr2[7] + ((int) (j25 >>> 32))) << 1) | (i14 >>> 31);
                return;
            }
            i3 = i5;
            i4 = i7;
        }
    }

    public static int sub(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((((long) iArr[i2 + 0]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 0]) & UIDFolder.MAXUID)) + 0;
        iArr3[i4 + 0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i2 + 1]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 1]) & UIDFolder.MAXUID));
        iArr3[i4 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i2 + 2]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 2]) & UIDFolder.MAXUID));
        iArr3[i4 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i2 + 3]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 3]) & UIDFolder.MAXUID));
        iArr3[i4 + 3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & UIDFolder.MAXUID) - (((long) iArr2[0]) & UIDFolder.MAXUID)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & UIDFolder.MAXUID) - (((long) iArr2[1]) & UIDFolder.MAXUID));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & UIDFolder.MAXUID) - (((long) iArr2[2]) & UIDFolder.MAXUID));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & UIDFolder.MAXUID) - (((long) iArr2[3]) & UIDFolder.MAXUID));
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & UIDFolder.MAXUID) - (((long) iArr[0]) & UIDFolder.MAXUID)) - (((long) iArr2[0]) & UIDFolder.MAXUID)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & UIDFolder.MAXUID) - (((long) iArr[1]) & UIDFolder.MAXUID)) - (((long) iArr2[1]) & UIDFolder.MAXUID));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & UIDFolder.MAXUID) - (((long) iArr[2]) & UIDFolder.MAXUID)) - (((long) iArr2[2]) & UIDFolder.MAXUID));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & UIDFolder.MAXUID) - (((long) iArr[3]) & UIDFolder.MAXUID)) - (((long) iArr2[3]) & UIDFolder.MAXUID));
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int subFrom(int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        long j = ((((long) iArr2[i4]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 0]) & UIDFolder.MAXUID)) + 0;
        iArr2[i4] = (int) j;
        int i5 = i3 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i5]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 1]) & UIDFolder.MAXUID));
        iArr2[i5] = (int) j2;
        int i6 = i3 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i6]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 2]) & UIDFolder.MAXUID));
        iArr2[i6] = (int) j3;
        int i7 = i3 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i7]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 3]) & UIDFolder.MAXUID));
        iArr2[i7] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & UIDFolder.MAXUID) - (((long) iArr[0]) & UIDFolder.MAXUID)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & UIDFolder.MAXUID) - (((long) iArr[1]) & UIDFolder.MAXUID));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & UIDFolder.MAXUID) - (((long) iArr[2]) & UIDFolder.MAXUID));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & UIDFolder.MAXUID) - (UIDFolder.MAXUID & ((long) iArr[3])));
        iArr2[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                g.a.j.k.intToBigEndian(i3, bArr, (3 - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 2; i2++) {
            long j = jArr[i2];
            if (j != 0) {
                g.a.j.k.longToBigEndian(j, bArr, (1 - i2) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
    }
}
