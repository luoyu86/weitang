package g.a.g.c;

import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static int add(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = (((long) iArr[i2 + 0]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 0]) & UIDFolder.MAXUID) + 0;
        iArr3[i4 + 0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[i2 + 1]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 1]) & UIDFolder.MAXUID);
        iArr3[i4 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[i2 + 2]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 2]) & UIDFolder.MAXUID);
        iArr3[i4 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[i2 + 3]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 3]) & UIDFolder.MAXUID);
        iArr3[i4 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[i2 + 4]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 4]) & UIDFolder.MAXUID);
        iArr3[i4 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[i2 + 5]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 5]) & UIDFolder.MAXUID);
        iArr3[i4 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[i2 + 6]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 6]) & UIDFolder.MAXUID);
        iArr3[i4 + 6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + (((long) iArr2[0]) & UIDFolder.MAXUID) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + (((long) iArr2[1]) & UIDFolder.MAXUID);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + (((long) iArr2[2]) & UIDFolder.MAXUID);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + (((long) iArr2[3]) & UIDFolder.MAXUID);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & UIDFolder.MAXUID) + (((long) iArr2[4]) & UIDFolder.MAXUID);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & UIDFolder.MAXUID) + (((long) iArr2[5]) & UIDFolder.MAXUID);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & UIDFolder.MAXUID) + (((long) iArr2[6]) & UIDFolder.MAXUID);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5 = i4 + 0;
        long j = (((long) iArr[i2 + 0]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 0]) & UIDFolder.MAXUID) + (((long) iArr3[i5]) & UIDFolder.MAXUID) + 0;
        iArr3[i5] = (int) j;
        int i6 = i4 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i2 + 1]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 1]) & UIDFolder.MAXUID) + (((long) iArr3[i6]) & UIDFolder.MAXUID);
        iArr3[i6] = (int) j2;
        int i7 = i4 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i2 + 2]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 2]) & UIDFolder.MAXUID) + (((long) iArr3[i7]) & UIDFolder.MAXUID);
        iArr3[i7] = (int) j3;
        int i8 = i4 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i2 + 3]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 3]) & UIDFolder.MAXUID) + (((long) iArr3[i8]) & UIDFolder.MAXUID);
        iArr3[i8] = (int) j4;
        int i9 = i4 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i2 + 4]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 4]) & UIDFolder.MAXUID) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
        iArr3[i9] = (int) j5;
        int i10 = i4 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i2 + 5]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 5]) & UIDFolder.MAXUID) + (((long) iArr3[i10]) & UIDFolder.MAXUID);
        iArr3[i10] = (int) j6;
        int i11 = i4 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i2 + 6]) & UIDFolder.MAXUID) + (((long) iArr2[i3 + 6]) & UIDFolder.MAXUID) + (((long) iArr3[i11]) & UIDFolder.MAXUID);
        iArr3[i11] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & UIDFolder.MAXUID) + (((long) iArr2[4]) & UIDFolder.MAXUID) + (((long) iArr3[4]) & UIDFolder.MAXUID);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & UIDFolder.MAXUID) + (((long) iArr2[5]) & UIDFolder.MAXUID) + (((long) iArr3[5]) & UIDFolder.MAXUID);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & UIDFolder.MAXUID) + (((long) iArr2[6]) & UIDFolder.MAXUID) + (((long) iArr3[6]) & UIDFolder.MAXUID);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j4 = (j3 >>> 32) + (((long) iArr[i2 + 3]) & UIDFolder.MAXUID) + (((long) iArr2[i8]) & UIDFolder.MAXUID);
        iArr2[i8] = (int) j4;
        int i9 = i3 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i2 + 4]) & UIDFolder.MAXUID) + (((long) iArr2[i9]) & UIDFolder.MAXUID);
        iArr2[i9] = (int) j5;
        int i10 = i3 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i2 + 5]) & UIDFolder.MAXUID) + (((long) iArr2[i10]) & UIDFolder.MAXUID);
        iArr2[i10] = (int) j6;
        int i11 = i3 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i2 + 6]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) iArr2[i11]));
        iArr2[i11] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + (((long) iArr2[0]) & UIDFolder.MAXUID) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + (((long) iArr2[1]) & UIDFolder.MAXUID);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + (((long) iArr2[2]) & UIDFolder.MAXUID);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + (((long) iArr2[3]) & UIDFolder.MAXUID);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & UIDFolder.MAXUID) + (((long) iArr2[4]) & UIDFolder.MAXUID);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & UIDFolder.MAXUID) + (((long) iArr2[5]) & UIDFolder.MAXUID);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) iArr2[6]));
        iArr2[6] = (int) j7;
        return (int) (j7 >>> 32);
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
        long j4 = (j3 >>> 32) + (((long) iArr[i13]) & UIDFolder.MAXUID) + (((long) iArr2[i14]) & UIDFolder.MAXUID);
        int i15 = (int) j4;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        int i16 = i2 + 4;
        int i17 = i3 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i16]) & UIDFolder.MAXUID) + (((long) iArr2[i17]) & UIDFolder.MAXUID);
        int i18 = (int) j5;
        iArr[i16] = i18;
        iArr2[i17] = i18;
        int i19 = i2 + 5;
        int i20 = i3 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i19]) & UIDFolder.MAXUID) + (((long) iArr2[i20]) & UIDFolder.MAXUID);
        int i21 = (int) j6;
        iArr[i19] = i21;
        iArr2[i20] = i21;
        int i22 = i2 + 6;
        int i23 = i3 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i22]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) iArr2[i23]));
        int i24 = (int) j7;
        iArr[i22] = i24;
        iArr2[i23] = i24;
        return (int) (j7 >>> 32);
    }

    public static void copy(int[] iArr, int i2, int[] iArr2, int i3) {
        iArr2[i3 + 0] = iArr[i2 + 0];
        iArr2[i3 + 1] = iArr[i2 + 1];
        iArr2[i3 + 2] = iArr[i2 + 2];
        iArr2[i3 + 3] = iArr[i2 + 3];
        iArr2[i3 + 4] = iArr[i2 + 4];
        iArr2[i3 + 5] = iArr[i2 + 5];
        iArr2[i3 + 6] = iArr[i2 + 6];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
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
        for (int i2 = 6; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArrCreate = create();
        for (int i2 = 0; i2 < 7; i2++) {
            iArrCreate[i2] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrCreate;
    }

    public static int getBit(int[] iArr, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = iArr[0];
        } else {
            int i4 = i2 >> 5;
            if (i4 < 0 || i4 >= 7) {
                return 0;
            }
            i3 = iArr[i4] >>> (i2 & 31);
        }
        return i3 & 1;
    }

    public static boolean gte(int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 6; i4 >= 0; i4--) {
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
        for (int i2 = 6; i2 >= 0; i2--) {
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
        for (int i2 = 1; i2 < 7; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i2 = 0; i2 < 7; i2++) {
            if (iArr[i2] != 0) {
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
        long j5 = ((long) iArr2[i3 + 4]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr2[i3 + 5]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr2[i3 + 6]) & UIDFolder.MAXUID;
        long j8 = ((long) iArr[i2 + 0]) & UIDFolder.MAXUID;
        long j9 = (j8 * j) + 0;
        iArr3[i4 + 0] = (int) j9;
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[i4 + 1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j3);
        iArr3[i4 + 2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[i4 + 3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[i4 + 4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j6);
        iArr3[i4 + 5] = (int) j14;
        long j15 = j7;
        long j16 = (j14 >>> 32) + (j8 * j15);
        iArr3[i4 + 6] = (int) j16;
        iArr3[i4 + 7] = (int) (j16 >>> 32);
        int i5 = 1;
        int i6 = i4;
        int i7 = 1;
        while (i7 < 7) {
            i6 += i5;
            long j17 = ((long) iArr[i2 + i7]) & UIDFolder.MAXUID;
            int i8 = i6 + 0;
            long j18 = (j17 * j) + (((long) iArr3[i8]) & UIDFolder.MAXUID) + 0;
            iArr3[i8] = (int) j18;
            int i9 = i6 + 1;
            long j19 = j15;
            long j20 = (j18 >>> 32) + (j17 * j2) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
            iArr3[i9] = (int) j20;
            int i10 = i6 + 2;
            long j21 = j3;
            long j22 = (j20 >>> 32) + (j17 * j3) + (((long) iArr3[i10]) & UIDFolder.MAXUID);
            iArr3[i10] = (int) j22;
            int i11 = i6 + 3;
            long j23 = (j22 >>> 32) + (j17 * j4) + (((long) iArr3[i11]) & UIDFolder.MAXUID);
            iArr3[i11] = (int) j23;
            int i12 = i6 + 4;
            long j24 = (j23 >>> 32) + (j17 * j5) + (((long) iArr3[i12]) & UIDFolder.MAXUID);
            iArr3[i12] = (int) j24;
            int i13 = i6 + 5;
            long j25 = (j24 >>> 32) + (j17 * j6) + (((long) iArr3[i13]) & UIDFolder.MAXUID);
            iArr3[i13] = (int) j25;
            int i14 = i6 + 6;
            long j26 = (j25 >>> 32) + (j17 * j19) + (((long) iArr3[i14]) & UIDFolder.MAXUID);
            iArr3[i14] = (int) j26;
            iArr3[i6 + 7] = (int) (j26 >>> 32);
            i7++;
            j3 = j21;
            j15 = j19;
            j4 = j4;
            i5 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr2[1]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr2[2]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[3]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr2[4]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr2[5]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr2[6]) & UIDFolder.MAXUID;
        long j8 = ((long) iArr[0]) & UIDFolder.MAXUID;
        long j9 = (j8 * j) + 0;
        iArr3[0] = (int) j9;
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j3);
        iArr3[2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j6);
        iArr3[5] = (int) j14;
        long j15 = (j14 >>> 32) + (j8 * j7);
        iArr3[6] = (int) j15;
        int i2 = (int) (j15 >>> 32);
        iArr3[7] = i2;
        int i3 = 1;
        for (int i4 = 7; i3 < i4; i4 = 7) {
            long j16 = ((long) iArr[i3]) & UIDFolder.MAXUID;
            int i5 = i3 + 0;
            long j17 = (j16 * j) + (((long) iArr3[i5]) & UIDFolder.MAXUID) + 0;
            iArr3[i5] = (int) j17;
            int i6 = i3 + 1;
            long j18 = j2;
            long j19 = (j17 >>> 32) + (j16 * j2) + (((long) iArr3[i6]) & UIDFolder.MAXUID);
            iArr3[i6] = (int) j19;
            int i7 = i3 + 2;
            long j20 = j6;
            long j21 = (j19 >>> 32) + (j16 * j3) + (((long) iArr3[i7]) & UIDFolder.MAXUID);
            iArr3[i7] = (int) j21;
            int i8 = i3 + 3;
            long j22 = (j21 >>> 32) + (j16 * j4) + (((long) iArr3[i8]) & UIDFolder.MAXUID);
            iArr3[i8] = (int) j22;
            int i9 = i3 + 4;
            long j23 = (j22 >>> 32) + (j16 * j5) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
            iArr3[i9] = (int) j23;
            int i10 = i3 + 5;
            long j24 = (j23 >>> 32) + (j16 * j20) + (((long) iArr3[i10]) & UIDFolder.MAXUID);
            iArr3[i10] = (int) j24;
            int i11 = i3 + 6;
            long j25 = (j24 >>> 32) + (j16 * j7) + (((long) iArr3[i11]) & UIDFolder.MAXUID);
            iArr3[i11] = (int) j25;
            iArr3[i3 + 7] = (int) (j25 >>> 32);
            i3 = i6;
            j = j;
            j2 = j18;
            j6 = j20;
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
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i4 + 3]) & UIDFolder.MAXUID);
        iArr3[i5 + 3] = (int) j10;
        long j11 = ((long) iArr[i3 + 4]) & UIDFolder.MAXUID;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (((long) iArr2[i4 + 4]) & UIDFolder.MAXUID);
        iArr3[i5 + 4] = (int) j12;
        long j13 = ((long) iArr[i3 + 5]) & UIDFolder.MAXUID;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (((long) iArr2[i4 + 5]) & UIDFolder.MAXUID);
        iArr3[i5 + 5] = (int) j14;
        long j15 = ((long) iArr[i3 + 6]) & UIDFolder.MAXUID;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (UIDFolder.MAXUID & ((long) iArr2[i4 + 6]));
        iArr3[i5 + 6] = (int) j16;
        return (j16 >>> 32) + j15;
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
        long j9 = (j8 >>> 32) + (UIDFolder.MAXUID & ((long) iArr[i7]));
        iArr[i7] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return n.incAt(7, iArr, i3, 4);
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
        return n.incAt(7, iArr, i4, 3);
    }

    public static int mulAddTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) iArr2[i3 + 0]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr2[i3 + 1]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr2[i3 + 2]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[i3 + 3]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr2[i3 + 4]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr2[i3 + 5]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr2[i3 + 6]) & UIDFolder.MAXUID;
        int i5 = i4;
        long j8 = 0;
        int i6 = 0;
        while (i6 < 7) {
            int i7 = i6;
            long j9 = ((long) iArr[i2 + i6]) & UIDFolder.MAXUID;
            int i8 = i5 + 0;
            long j10 = j;
            long j11 = (j9 * j) + (((long) iArr3[i8]) & UIDFolder.MAXUID) + 0;
            long j12 = j7;
            iArr3[i8] = (int) j11;
            int i9 = i5 + 1;
            long j13 = (j11 >>> 32) + (j9 * j2) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
            iArr3[i9] = (int) j13;
            int i10 = i5 + 2;
            long j14 = (j13 >>> 32) + (j9 * j3) + (((long) iArr3[i10]) & UIDFolder.MAXUID);
            iArr3[i10] = (int) j14;
            int i11 = i5 + 3;
            long j15 = (j14 >>> 32) + (j9 * j4) + (((long) iArr3[i11]) & UIDFolder.MAXUID);
            iArr3[i11] = (int) j15;
            int i12 = i5 + 4;
            long j16 = (j15 >>> 32) + (j9 * j5) + (((long) iArr3[i12]) & UIDFolder.MAXUID);
            iArr3[i12] = (int) j16;
            int i13 = i5 + 5;
            long j17 = (j16 >>> 32) + (j9 * j6) + (((long) iArr3[i13]) & UIDFolder.MAXUID);
            iArr3[i13] = (int) j17;
            int i14 = i5 + 6;
            long j18 = (j17 >>> 32) + (j9 * j12) + (((long) iArr3[i14]) & UIDFolder.MAXUID);
            iArr3[i14] = (int) j18;
            int i15 = i5 + 7;
            long j19 = (j18 >>> 32) + (((long) iArr3[i15]) & UIDFolder.MAXUID) + j8;
            iArr3[i15] = (int) j19;
            j8 = j19 >>> 32;
            i6 = i7 + 1;
            i5 = i9;
            j7 = j12;
            j = j10;
            j2 = j2;
        }
        return (int) j8;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr2[1]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr2[2]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr2[3]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr2[4]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr2[5]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr2[6]) & UIDFolder.MAXUID;
        long j8 = 0;
        int i2 = 0;
        while (i2 < 7) {
            long j9 = j7;
            long j10 = ((long) iArr[i2]) & UIDFolder.MAXUID;
            int i3 = i2 + 0;
            long j11 = j6;
            long j12 = (j10 * j) + (((long) iArr3[i3]) & UIDFolder.MAXUID) + 0;
            iArr3[i3] = (int) j12;
            int i4 = i2 + 1;
            long j13 = j2;
            long j14 = (j12 >>> 32) + (j10 * j2) + (((long) iArr3[i4]) & UIDFolder.MAXUID);
            iArr3[i4] = (int) j14;
            int i5 = i2 + 2;
            long j15 = (j14 >>> 32) + (j10 * j3) + (((long) iArr3[i5]) & UIDFolder.MAXUID);
            iArr3[i5] = (int) j15;
            int i6 = i2 + 3;
            long j16 = (j15 >>> 32) + (j10 * j4) + (((long) iArr3[i6]) & UIDFolder.MAXUID);
            iArr3[i6] = (int) j16;
            int i7 = i2 + 4;
            long j17 = (j16 >>> 32) + (j10 * j5) + (((long) iArr3[i7]) & UIDFolder.MAXUID);
            iArr3[i7] = (int) j17;
            int i8 = i2 + 5;
            long j18 = (j17 >>> 32) + (j10 * j11) + (((long) iArr3[i8]) & UIDFolder.MAXUID);
            iArr3[i8] = (int) j18;
            int i9 = i2 + 6;
            long j19 = (j18 >>> 32) + (j10 * j9) + (((long) iArr3[i9]) & UIDFolder.MAXUID);
            iArr3[i9] = (int) j19;
            int i10 = i2 + 7;
            long j20 = (j19 >>> 32) + (((long) iArr3[i10]) & UIDFolder.MAXUID) + j8;
            iArr3[i10] = (int) j20;
            j8 = j20 >>> 32;
            i2 = i4;
            j7 = j9;
            j6 = j11;
            j2 = j13;
        }
        return (int) j8;
    }

    public static int mulByWord(int i2, int[] iArr) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        long j2 = ((((long) iArr[0]) & UIDFolder.MAXUID) * j) + 0;
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr[1]) & UIDFolder.MAXUID) * j);
        iArr[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr[2]) & UIDFolder.MAXUID) * j);
        iArr[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr[3]) & UIDFolder.MAXUID) * j);
        iArr[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr[4]) & UIDFolder.MAXUID) * j);
        iArr[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr[5]) & UIDFolder.MAXUID) * j);
        iArr[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (UIDFolder.MAXUID & ((long) iArr[6])));
        iArr[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulByWordAddTo(int i2, int[] iArr, int[] iArr2) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        long j2 = ((((long) iArr2[0]) & UIDFolder.MAXUID) * j) + (((long) iArr[0]) & UIDFolder.MAXUID) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr2[1]) & UIDFolder.MAXUID) * j) + (((long) iArr[1]) & UIDFolder.MAXUID);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr2[2]) & UIDFolder.MAXUID) * j) + (((long) iArr[2]) & UIDFolder.MAXUID);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr2[3]) & UIDFolder.MAXUID) * j) + (((long) iArr[3]) & UIDFolder.MAXUID);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr2[4]) & UIDFolder.MAXUID) * j) + (((long) iArr[4]) & UIDFolder.MAXUID);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr2[5]) & UIDFolder.MAXUID) * j) + (((long) iArr[5]) & UIDFolder.MAXUID);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (((long) iArr2[6]) & UIDFolder.MAXUID)) + (UIDFolder.MAXUID & ((long) iArr[6]));
        iArr2[6] = (int) j8;
        return (int) (j8 >>> 32);
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
        } while (i4 < 7);
        return (int) j2;
    }

    public static int mulWordAddTo(int i2, int[] iArr, int i3, int[] iArr2, int i4) {
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
        long j5 = (j4 >>> 32) + ((((long) iArr[i3 + 3]) & UIDFolder.MAXUID) * j) + (((long) iArr2[i8]) & UIDFolder.MAXUID);
        iArr2[i8] = (int) j5;
        int i9 = i4 + 4;
        long j6 = (j5 >>> 32) + ((((long) iArr[i3 + 4]) & UIDFolder.MAXUID) * j) + (((long) iArr2[i9]) & UIDFolder.MAXUID);
        iArr2[i9] = (int) j6;
        int i10 = i4 + 5;
        long j7 = (j6 >>> 32) + ((((long) iArr[i3 + 5]) & UIDFolder.MAXUID) * j) + (((long) iArr2[i10]) & UIDFolder.MAXUID);
        iArr2[i10] = (int) j7;
        int i11 = i4 + 6;
        long j8 = (j7 >>> 32) + (j * (((long) iArr[i3 + 6]) & UIDFolder.MAXUID)) + (((long) iArr2[i11]) & UIDFolder.MAXUID);
        iArr2[i11] = (int) j8;
        return (int) (j8 >>> 32);
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
        return n.incAt(7, iArr, i3, 3);
    }

    public static void square(int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) iArr[i2 + 0]) & UIDFolder.MAXUID;
        int i4 = 0;
        int i5 = 14;
        int i6 = 6;
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
                long j21 = j18 & UIDFolder.MAXUID;
                long j22 = j16 + (j17 * j);
                int i18 = (int) j22;
                iArr2[i12] = (i18 << 1) | i15;
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & UIDFolder.MAXUID;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & UIDFolder.MAXUID;
                long j28 = ((long) iArr[i2 + 4]) & UIDFolder.MAXUID;
                int i19 = i3 + 7;
                long j29 = (((long) iArr2[i19]) & UIDFolder.MAXUID) + (j26 >>> 32);
                long j30 = j26 & UIDFolder.MAXUID;
                int i20 = i3 + 8;
                long j31 = (((long) iArr2[i20]) & UIDFolder.MAXUID) + (j29 >>> 32);
                long j32 = j29 & UIDFolder.MAXUID;
                long j33 = j25 + (j28 * j);
                int i21 = (int) j33;
                iArr2[i13] = (i18 >>> 31) | (i21 << 1);
                int i22 = i21 >>> 31;
                long j34 = j27 + (j33 >>> 32) + (j28 * j6);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j34 & UIDFolder.MAXUID;
                long j37 = j32 + (j35 >>> 32) + (j28 * j17);
                long j38 = j35 & UIDFolder.MAXUID;
                long j39 = j31 + (j37 >>> 32);
                long j40 = j37 & UIDFolder.MAXUID;
                long j41 = ((long) iArr[i2 + 5]) & UIDFolder.MAXUID;
                int i23 = i3 + 9;
                long j42 = (((long) iArr2[i23]) & UIDFolder.MAXUID) + (j39 >>> 32);
                long j43 = j39 & UIDFolder.MAXUID;
                int i24 = i3 + 10;
                long j44 = (((long) iArr2[i24]) & UIDFolder.MAXUID) + (j42 >>> 32);
                long j45 = j42 & UIDFolder.MAXUID;
                long j46 = j36 + (j41 * j);
                int i25 = (int) j46;
                iArr2[i16] = i22 | (i25 << 1);
                int i26 = i25 >>> 31;
                long j47 = j38 + (j46 >>> 32) + (j41 * j6);
                long j48 = j40 + (j47 >>> 32) + (j41 * j10);
                long j49 = j47 & UIDFolder.MAXUID;
                long j50 = j43 + (j48 >>> 32) + (j41 * j17);
                long j51 = j48 & UIDFolder.MAXUID;
                long j52 = j45 + (j50 >>> 32) + (j41 * j28);
                long j53 = j50 & UIDFolder.MAXUID;
                long j54 = j44 + (j52 >>> 32);
                long j55 = j52 & UIDFolder.MAXUID;
                long j56 = ((long) iArr[i2 + 6]) & UIDFolder.MAXUID;
                int i27 = i3 + 11;
                long j57 = (((long) iArr2[i27]) & UIDFolder.MAXUID) + (j54 >>> 32);
                long j58 = j54 & UIDFolder.MAXUID;
                int i28 = i3 + 12;
                long j59 = (((long) iArr2[i28]) & UIDFolder.MAXUID) + (j57 >>> 32);
                long j60 = j57 & UIDFolder.MAXUID;
                long j61 = j49 + (j * j56);
                int i29 = (int) j61;
                iArr2[i17] = (i29 << 1) | i26;
                long j62 = j51 + (j61 >>> 32) + (j56 * j6);
                long j63 = j53 + (j62 >>> 32) + (j56 * j10);
                long j64 = j55 + (j63 >>> 32) + (j56 * j17);
                long j65 = j58 + (j64 >>> 32) + (j56 * j28);
                long j66 = j60 + (j65 >>> 32) + (j56 * j41);
                long j67 = j59 + (j66 >>> 32);
                int i30 = (int) j62;
                iArr2[i19] = (i29 >>> 31) | (i30 << 1);
                int i31 = (int) j63;
                iArr2[i20] = (i30 >>> 31) | (i31 << 1);
                int i32 = (int) j64;
                iArr2[i23] = (i31 >>> 31) | (i32 << 1);
                int i33 = i32 >>> 31;
                int i34 = (int) j65;
                iArr2[i24] = i33 | (i34 << 1);
                int i35 = i34 >>> 31;
                int i36 = (int) j66;
                iArr2[i27] = i35 | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) j67;
                iArr2[i28] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = i3 + 13;
                iArr2[i40] = i39 | ((iArr2[i40] + ((int) (j67 >>> 32))) << 1);
                return;
            }
            i6 = i7;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & UIDFolder.MAXUID;
        int i2 = 14;
        int i3 = 6;
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
                long j22 = j16 + (j17 * j);
                int i11 = (int) j22;
                iArr2[3] = (i10 >>> 31) | (i11 << 1);
                int i12 = i11 >>> 31;
                long j23 = j19 + (j22 >>> 32) + (j17 * j6);
                long j24 = j21 + (j23 >>> 32) + (j17 * j10);
                long j25 = j23 & UIDFolder.MAXUID;
                long j26 = j20 + (j24 >>> 32);
                long j27 = j24 & UIDFolder.MAXUID;
                long j28 = ((long) iArr[4]) & UIDFolder.MAXUID;
                long j29 = (((long) iArr2[7]) & UIDFolder.MAXUID) + (j26 >>> 32);
                long j30 = j26 & UIDFolder.MAXUID;
                long j31 = (((long) iArr2[8]) & UIDFolder.MAXUID) + (j29 >>> 32);
                long j32 = j29 & UIDFolder.MAXUID;
                long j33 = j25 + (j28 * j);
                int i13 = (int) j33;
                iArr2[4] = (i13 << 1) | i12;
                long j34 = j27 + (j33 >>> 32) + (j28 * j6);
                long j35 = j30 + (j34 >>> 32) + (j28 * j10);
                long j36 = j34 & UIDFolder.MAXUID;
                long j37 = j32 + (j35 >>> 32) + (j28 * j17);
                long j38 = j35 & UIDFolder.MAXUID;
                long j39 = j31 + (j37 >>> 32);
                long j40 = j37 & UIDFolder.MAXUID;
                long j41 = ((long) iArr[5]) & UIDFolder.MAXUID;
                long j42 = (((long) iArr2[9]) & UIDFolder.MAXUID) + (j39 >>> 32);
                long j43 = j39 & UIDFolder.MAXUID;
                long j44 = (((long) iArr2[10]) & UIDFolder.MAXUID) + (j42 >>> 32);
                long j45 = j42 & UIDFolder.MAXUID;
                long j46 = j36 + (j41 * j);
                int i14 = (int) j46;
                iArr2[5] = (i14 << 1) | (i13 >>> 31);
                long j47 = j38 + (j46 >>> 32) + (j41 * j6);
                long j48 = j40 + (j47 >>> 32) + (j41 * j10);
                long j49 = j47 & UIDFolder.MAXUID;
                long j50 = j43 + (j48 >>> 32) + (j41 * j17);
                long j51 = j48 & UIDFolder.MAXUID;
                long j52 = j45 + (j50 >>> 32) + (j41 * j28);
                long j53 = j50 & UIDFolder.MAXUID;
                long j54 = j44 + (j52 >>> 32);
                long j55 = j52 & UIDFolder.MAXUID;
                long j56 = ((long) iArr[6]) & UIDFolder.MAXUID;
                long j57 = (((long) iArr2[11]) & UIDFolder.MAXUID) + (j54 >>> 32);
                long j58 = j54 & UIDFolder.MAXUID;
                long j59 = (((long) iArr2[12]) & UIDFolder.MAXUID) + (j57 >>> 32);
                long j60 = UIDFolder.MAXUID & j57;
                long j61 = j49 + (j * j56);
                int i15 = (int) j61;
                iArr2[6] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                long j62 = j51 + (j61 >>> 32) + (j56 * j6);
                long j63 = j53 + (j62 >>> 32) + (j56 * j10);
                long j64 = j55 + (j63 >>> 32) + (j56 * j17);
                long j65 = j58 + (j64 >>> 32) + (j56 * j28);
                long j66 = j60 + (j65 >>> 32) + (j56 * j41);
                long j67 = j59 + (j66 >>> 32);
                int i17 = (int) j62;
                iArr2[7] = i16 | (i17 << 1);
                int i18 = (int) j63;
                iArr2[8] = (i17 >>> 31) | (i18 << 1);
                int i19 = (int) j64;
                iArr2[9] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j65;
                iArr2[10] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j66;
                iArr2[11] = i22 | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) j67;
                iArr2[12] = i24 | (i25 << 1);
                iArr2[13] = (i25 >>> 31) | ((iArr2[13] + ((int) (j67 >>> 32))) << 1);
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
        long j5 = (j4 >> 32) + ((((long) iArr[i2 + 4]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 4]) & UIDFolder.MAXUID));
        iArr3[i4 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i2 + 5]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 5]) & UIDFolder.MAXUID));
        iArr3[i4 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[i2 + 6]) & UIDFolder.MAXUID) - (((long) iArr2[i3 + 6]) & UIDFolder.MAXUID));
        iArr3[i4 + 6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & UIDFolder.MAXUID) - (((long) iArr2[4]) & UIDFolder.MAXUID));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & UIDFolder.MAXUID) - (((long) iArr2[5]) & UIDFolder.MAXUID));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[6]) & UIDFolder.MAXUID) - (((long) iArr2[6]) & UIDFolder.MAXUID));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & UIDFolder.MAXUID) - (((long) iArr[4]) & UIDFolder.MAXUID)) - (((long) iArr2[4]) & UIDFolder.MAXUID));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + (((((long) iArr3[5]) & UIDFolder.MAXUID) - (((long) iArr[5]) & UIDFolder.MAXUID)) - (((long) iArr2[5]) & UIDFolder.MAXUID));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + (((((long) iArr3[6]) & UIDFolder.MAXUID) - (((long) iArr[6]) & UIDFolder.MAXUID)) - (((long) iArr2[6]) & UIDFolder.MAXUID));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        int i8 = i3 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i8]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 4]) & UIDFolder.MAXUID));
        iArr2[i8] = (int) j5;
        int i9 = i3 + 5;
        long j6 = (j5 >> 32) + ((((long) iArr2[i9]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 5]) & UIDFolder.MAXUID));
        iArr2[i9] = (int) j6;
        int i10 = i3 + 6;
        long j7 = (j6 >> 32) + ((((long) iArr2[i10]) & UIDFolder.MAXUID) - (((long) iArr[i2 + 6]) & UIDFolder.MAXUID));
        iArr2[i10] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & UIDFolder.MAXUID) - (((long) iArr[0]) & UIDFolder.MAXUID)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & UIDFolder.MAXUID) - (((long) iArr[1]) & UIDFolder.MAXUID));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & UIDFolder.MAXUID) - (((long) iArr[2]) & UIDFolder.MAXUID));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & UIDFolder.MAXUID) - (((long) iArr[3]) & UIDFolder.MAXUID));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & UIDFolder.MAXUID) - (((long) iArr[4]) & UIDFolder.MAXUID));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & UIDFolder.MAXUID) - (((long) iArr[5]) & UIDFolder.MAXUID));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr2[6]) & UIDFolder.MAXUID) - (UIDFolder.MAXUID & ((long) iArr[6])));
        iArr2[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i2 = 0; i2 < 7; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                g.a.j.k.intToBigEndian(i3, bArr, (6 - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
    }
}
