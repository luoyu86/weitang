package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13975a = {-1, -1, -1, 0, 0, 0, 1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13976b = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & UIDFolder.MAXUID);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & UIDFolder.MAXUID);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + ((((long) iArr[3]) & UIDFolder.MAXUID) - 1);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & UIDFolder.MAXUID);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + ((((long) iArr[6]) & UIDFolder.MAXUID) - 1);
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + (UIDFolder.MAXUID & ((long) iArr[7])) + 1);
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && g.a.g.c.h.gte(iArr3, f13975a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(16, iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && g.a.g.c.n.gte(16, iArr3, f13976b))) {
            g.a.g.c.n.subFrom(16, f13976b, iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && g.a.g.c.h.gte(iArr2, f13975a))) {
            a(iArr2);
        }
    }

    public static void b(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & UIDFolder.MAXUID);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & UIDFolder.MAXUID);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + (((long) iArr[3]) & UIDFolder.MAXUID) + 1;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & UIDFolder.MAXUID);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + (((long) iArr[6]) & UIDFolder.MAXUID) + 1;
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + ((UIDFolder.MAXUID & ((long) iArr[7])) - 1));
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.h.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[7] == -1) {
            int[] iArr = f13975a;
            if (g.a.g.c.h.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.h.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(8, iArr2, g.a.g.c.h.add(iArr, f13975a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13975a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        g.a.g.c.h.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && g.a.g.c.n.gte(16, iArr3, f13976b))) {
            g.a.g.c.n.subFrom(16, f13976b, iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.h.sub(f13975a, iArr, iArr2);
        } else {
            int[] iArr3 = f13975a;
            g.a.g.c.h.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 8);
        } while (g.a.g.c.n.lessThan(8, iArr, f13975a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[8]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[9]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr[10]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr[11]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr[12]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr[13]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr[14]) & UIDFolder.MAXUID;
        long j8 = ((long) iArr[15]) & UIDFolder.MAXUID;
        long j9 = j - 6;
        long j10 = j9 + j2;
        long j11 = j2 + j3;
        long j12 = (j3 + j4) - j8;
        long j13 = j4 + j5;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j7 + j8;
        long j17 = j15 - j10;
        long j18 = (((((long) iArr[0]) & UIDFolder.MAXUID) - j13) - j17) + 0;
        iArr2[0] = (int) j18;
        long j19 = (j18 >> 32) + ((((((long) iArr[1]) & UIDFolder.MAXUID) + j11) - j14) - j16);
        iArr2[1] = (int) j19;
        long j20 = (j19 >> 32) + (((((long) iArr[2]) & UIDFolder.MAXUID) + j12) - j15);
        iArr2[2] = (int) j20;
        long j21 = (j20 >> 32) + ((((((long) iArr[3]) & UIDFolder.MAXUID) + (j13 << 1)) + j17) - j16);
        iArr2[3] = (int) j21;
        long j22 = (j21 >> 32) + ((((((long) iArr[4]) & UIDFolder.MAXUID) + (j14 << 1)) + j7) - j11);
        iArr2[4] = (int) j22;
        long j23 = (j22 >> 32) + (((((long) iArr[5]) & UIDFolder.MAXUID) + (j15 << 1)) - j12);
        iArr2[5] = (int) j23;
        long j24 = (j23 >> 32) + (((long) iArr[6]) & UIDFolder.MAXUID) + (j16 << 1) + j17;
        iArr2[6] = (int) j24;
        long j25 = (j24 >> 32) + (((((((long) iArr[7]) & UIDFolder.MAXUID) + (j8 << 1)) + j9) - j12) - j14);
        iArr2[7] = (int) j25;
        reduce32((int) ((j25 >> 32) + 6), iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        long j;
        if (i2 != 0) {
            long j2 = ((long) i2) & UIDFolder.MAXUID;
            long j3 = (((long) iArr[0]) & UIDFolder.MAXUID) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & UIDFolder.MAXUID);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (((long) iArr[2]) & UIDFolder.MAXUID);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + ((((long) iArr[3]) & UIDFolder.MAXUID) - j2);
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (((long) iArr[4]) & UIDFolder.MAXUID);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID);
                iArr[5] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = j8 + ((((long) iArr[6]) & UIDFolder.MAXUID) - j2);
            iArr[6] = (int) j11;
            long j12 = (j11 >> 32) + (UIDFolder.MAXUID & ((long) iArr[7])) + j2;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && g.a.g.c.h.gte(iArr, f13975a))) {
            a(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        g.a.g.c.h.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        g.a.g.c.h.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.h.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.sub(iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(16, iArr, iArr2, iArr3) != 0) {
            g.a.g.c.n.addTo(16, f13976b, iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && g.a.g.c.h.gte(iArr2, f13975a))) {
            a(iArr2);
        }
    }
}
