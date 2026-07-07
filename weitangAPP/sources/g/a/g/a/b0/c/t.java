package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14042a = {-1, -1, -2, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f14043b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f14044c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & UIDFolder.MAXUID);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + (UIDFolder.MAXUID & ((long) iArr[2])) + 1;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            g.a.g.c.n.incAt(6, iArr, 3);
        }
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.f.add(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && g.a.g.c.f.gte(iArr3, f14042a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && g.a.g.c.n.gte(12, iArr3, f14043b))) {
            int[] iArr4 = f14044c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && g.a.g.c.f.gte(iArr2, f14042a))) {
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
        long j4 = j2 + ((UIDFolder.MAXUID & ((long) iArr[2])) - 1);
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            g.a.g.c.n.decAt(6, iArr, 3);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.f.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[5] == -1) {
            int[] iArr = f14042a;
            if (g.a.g.c.f.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.f.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(6, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(6, iArr2, g.a.g.c.f.add(iArr, f14042a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f14042a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        g.a.g.c.f.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.f.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && g.a.g.c.n.gte(12, iArr3, f14043b))) {
            int[] iArr4 = f14044c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.f.sub(f14042a, iArr, iArr2);
        } else {
            int[] iArr3 = f14042a;
            g.a.g.c.f.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[24];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 6);
        } while (g.a.g.c.n.lessThan(6, iArr, f14042a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[6]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[7]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr[8]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr[9]) & UIDFolder.MAXUID;
        long j5 = (((long) iArr[10]) & UIDFolder.MAXUID) + j;
        long j6 = (((long) iArr[11]) & UIDFolder.MAXUID) + j2;
        long j7 = (((long) iArr[0]) & UIDFolder.MAXUID) + j5 + 0;
        int i2 = (int) j7;
        long j8 = (j7 >> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + j6;
        iArr2[1] = (int) j8;
        long j9 = j5 + j3;
        long j10 = j6 + j4;
        long j11 = (j8 >> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + j9;
        long j12 = j11 & UIDFolder.MAXUID;
        long j13 = (j11 >> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + j10;
        iArr2[3] = (int) j13;
        long j14 = (j13 >> 32) + (((long) iArr[4]) & UIDFolder.MAXUID) + (j9 - j);
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + (((long) iArr[5]) & UIDFolder.MAXUID) + (j10 - j2);
        iArr2[5] = (int) j15;
        long j16 = j15 >> 32;
        long j17 = j12 + j16;
        long j18 = j16 + (((long) i2) & UIDFolder.MAXUID);
        iArr2[0] = (int) j18;
        long j19 = j18 >> 32;
        if (j19 != 0) {
            long j20 = j19 + (UIDFolder.MAXUID & ((long) iArr2[1]));
            iArr2[1] = (int) j20;
            j17 += j20 >> 32;
        }
        iArr2[2] = (int) j17;
        if (((j17 >> 32) == 0 || g.a.g.c.n.incAt(6, iArr2, 3) == 0) && !(iArr2[5] == -1 && g.a.g.c.f.gte(iArr2, f14042a))) {
            return;
        }
        a(iArr2);
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
            long j6 = j4 + (UIDFolder.MAXUID & ((long) iArr[2])) + j2;
            iArr[2] = (int) j6;
            j = j6 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || g.a.g.c.n.incAt(6, iArr, 3) == 0) && !(iArr[5] == -1 && g.a.g.c.f.gte(iArr, f14042a))) {
            return;
        }
        a(iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        g.a.g.c.f.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        g.a.g.c.f.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.f.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.f.sub(iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(12, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f14044c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && g.a.g.c.f.gte(iArr2, f14042a))) {
            a(iArr2);
        }
    }
}
