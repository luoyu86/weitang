package g.a.g.a.b0.b;

import g.a.g.c.h;
import g.a.g.c.n;
import g.a.j.k;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13902a = {-1, -1, 0, -1, -1, -1, -1, -2};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13903b = {1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & UIDFolder.MAXUID);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + ((((long) iArr[2]) & UIDFolder.MAXUID) - 1);
        iArr[2] = (int) j4;
        long j5 = (j4 >> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + 1;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & UIDFolder.MAXUID);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID);
            iArr[5] = (int) j8;
            long j9 = (j8 >> 32) + (((long) iArr[6]) & UIDFolder.MAXUID);
            iArr[6] = (int) j9;
            j6 = j9 >> 32;
        }
        iArr[7] = (int) (j6 + (UIDFolder.MAXUID & ((long) iArr[7])) + 1);
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h.add(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= Integer.MAX_VALUE && h.gte(iArr3, f13902a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (n.add(16, iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && n.gte(16, iArr3, f13903b))) {
            n.subFrom(16, f13903b, iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (n.inc(8, iArr, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && h.gte(iArr2, f13902a))) {
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
            j2 = j3 >> 32;
        }
        long j4 = j2 + (((long) iArr[2]) & UIDFolder.MAXUID) + 1;
        iArr[2] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[3]) & UIDFolder.MAXUID) - 1);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & UIDFolder.MAXUID);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID);
            iArr[5] = (int) j8;
            long j9 = (j8 >> 32) + (((long) iArr[6]) & UIDFolder.MAXUID);
            iArr[6] = (int) j9;
            j6 = j9 >> 32;
        }
        iArr[7] = (int) (j6 + ((UIDFolder.MAXUID & ((long) iArr[7])) - 1));
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = h.fromBigInteger(bigInteger);
        if ((iArrFromBigInteger[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = f13902a;
            if (h.gte(iArrFromBigInteger, iArr)) {
                h.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            n.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            n.shiftDownBit(8, iArr2, h.add(iArr, f13902a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13902a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = h.createExt();
        h.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && n.gte(16, iArr3, f13903b))) {
            n.subFrom(16, f13903b, iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            h.sub(f13902a, iArr, iArr2);
        } else {
            int[] iArr3 = f13902a;
            h.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            k.littleEndianToInt(bArr, 0, iArr, 0, 8);
        } while (n.lessThan(8, iArr, f13902a) == 0);
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
        long j9 = j3 + j4;
        long j10 = j6 + j7;
        long j11 = j10 + (j8 << 1);
        long j12 = j + j2 + j10;
        long j13 = j9 + j5 + j8 + j12;
        long j14 = (((long) iArr[0]) & UIDFolder.MAXUID) + j13 + j6 + j7 + j8 + 0;
        iArr2[0] = (int) j14;
        long j15 = (j14 >> 32) + (((((long) iArr[1]) & UIDFolder.MAXUID) + j13) - j) + j7 + j8;
        iArr2[1] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr[2]) & UIDFolder.MAXUID) - j12);
        iArr2[2] = (int) j16;
        long j17 = (j16 >> 32) + ((((((long) iArr[3]) & UIDFolder.MAXUID) + j13) - j2) - j3) + j6;
        iArr2[3] = (int) j17;
        long j18 = (j17 >> 32) + ((((((long) iArr[4]) & UIDFolder.MAXUID) + j13) - j9) - j) + j7;
        iArr2[4] = (int) j18;
        long j19 = (j18 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID) + j11 + j3;
        iArr2[5] = (int) j19;
        long j20 = (j19 >> 32) + (((long) iArr[6]) & UIDFolder.MAXUID) + j4 + j7 + j8;
        iArr2[6] = (int) j20;
        long j21 = (j20 >> 32) + (UIDFolder.MAXUID & ((long) iArr[7])) + j13 + j11 + j5;
        iArr2[7] = (int) j21;
        reduce32((int) (j21 >> 32), iArr2);
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
                j4 = j5 >> 32;
            }
            long j6 = j4 + ((((long) iArr[2]) & UIDFolder.MAXUID) - j2);
            iArr[2] = (int) j6;
            long j7 = (j6 >> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + j2;
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (((long) iArr[4]) & UIDFolder.MAXUID);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID);
                iArr[5] = (int) j10;
                long j11 = (j10 >> 32) + (((long) iArr[6]) & UIDFolder.MAXUID);
                iArr[6] = (int) j11;
                j8 = j11 >> 32;
            }
            long j12 = j8 + (UIDFolder.MAXUID & ((long) iArr[7])) + j2;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && h.gte(iArr, f13902a))) {
            a(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = h.createExt();
        h.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = h.createExt();
        h.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                h.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h.sub(iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (n.sub(16, iArr, iArr2, iArr3) != 0) {
            n.addTo(16, f13903b, iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (n.shiftUpBit(8, iArr, 0, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && h.gte(iArr2, f13902a))) {
            a(iArr2);
        }
    }
}
