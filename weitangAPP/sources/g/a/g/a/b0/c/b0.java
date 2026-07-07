package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13918a = {1, 0, 0, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13919b = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13920c = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void a(int[] iArr) {
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
        long j5 = j2 + (UIDFolder.MAXUID & ((long) iArr[3])) + 1;
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            g.a.g.c.n.incAt(7, iArr, 4);
        }
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.g.add(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && g.a.g.c.g.gte(iArr3, f13918a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && g.a.g.c.n.gte(14, iArr3, f13919b))) {
            int[] iArr4 = f13920c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && g.a.g.c.g.gte(iArr2, f13918a))) {
            a(iArr2);
        }
    }

    public static void b(int[] iArr) {
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
        long j5 = j2 + ((UIDFolder.MAXUID & ((long) iArr[3])) - 1);
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            g.a.g.c.n.decAt(7, iArr, 4);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.g.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[6] == -1) {
            int[] iArr = f13918a;
            if (g.a.g.c.g.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.g.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(7, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(7, iArr2, g.a.g.c.g.add(iArr, f13918a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13918a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 7; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        g.a.g.c.g.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.g.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && g.a.g.c.n.gte(14, iArr3, f13919b))) {
            int[] iArr4 = f13920c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.g.sub(f13918a, iArr, iArr2);
        } else {
            int[] iArr3 = f13918a;
            g.a.g.c.g.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[28];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 7);
        } while (g.a.g.c.n.lessThan(7, iArr, f13918a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[10]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[11]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr[12]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr[13]) & UIDFolder.MAXUID;
        long j5 = ((((long) iArr[7]) & UIDFolder.MAXUID) + j2) - 1;
        long j6 = (((long) iArr[8]) & UIDFolder.MAXUID) + j3;
        long j7 = (((long) iArr[9]) & UIDFolder.MAXUID) + j4;
        long j8 = ((((long) iArr[0]) & UIDFolder.MAXUID) - j5) + 0;
        long j9 = j8 & UIDFolder.MAXUID;
        long j10 = (j8 >> 32) + ((((long) iArr[1]) & UIDFolder.MAXUID) - j6);
        iArr2[1] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[2]) & UIDFolder.MAXUID) - j7);
        iArr2[2] = (int) j11;
        long j12 = (j11 >> 32) + (((((long) iArr[3]) & UIDFolder.MAXUID) + j5) - j);
        long j13 = j12 & UIDFolder.MAXUID;
        long j14 = (j12 >> 32) + (((((long) iArr[4]) & UIDFolder.MAXUID) + j6) - j2);
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + (((((long) iArr[5]) & UIDFolder.MAXUID) + j7) - j3);
        iArr2[5] = (int) j15;
        long j16 = (j15 >> 32) + (((((long) iArr[6]) & UIDFolder.MAXUID) + j) - j4);
        iArr2[6] = (int) j16;
        long j17 = (j16 >> 32) + 1;
        long j18 = j13 + j17;
        long j19 = j9 - j17;
        iArr2[0] = (int) j19;
        long j20 = j19 >> 32;
        if (j20 != 0) {
            long j21 = j20 + (((long) iArr2[1]) & UIDFolder.MAXUID);
            iArr2[1] = (int) j21;
            long j22 = (j21 >> 32) + (UIDFolder.MAXUID & ((long) iArr2[2]));
            iArr2[2] = (int) j22;
            j18 += j22 >> 32;
        }
        iArr2[3] = (int) j18;
        if (((j18 >> 32) == 0 || g.a.g.c.n.incAt(7, iArr2, 4) == 0) && !(iArr2[6] == -1 && g.a.g.c.g.gte(iArr2, f13918a))) {
            return;
        }
        a(iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        long j;
        if (i2 != 0) {
            long j2 = ((long) i2) & UIDFolder.MAXUID;
            long j3 = ((((long) iArr[0]) & UIDFolder.MAXUID) - j2) + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & UIDFolder.MAXUID);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (((long) iArr[2]) & UIDFolder.MAXUID);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + (UIDFolder.MAXUID & ((long) iArr[3])) + j2;
            iArr[3] = (int) j7;
            j = j7 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || g.a.g.c.n.incAt(7, iArr, 4) == 0) && !(iArr[6] == -1 && g.a.g.c.g.gte(iArr, f13918a))) {
            return;
        }
        a(iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        g.a.g.c.g.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        g.a.g.c.g.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.g.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.g.sub(iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f13920c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && g.a.g.c.g.gte(iArr2, f13918a))) {
            a(iArr2);
        }
    }
}
