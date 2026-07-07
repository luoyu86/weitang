package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13915a = {-1, -1, -1, -3};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13916b = {1, 0, 0, 4, -2, -1, 3, -4};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13917c = {-1, -1, -1, -5, 1, 0, -4, 3};

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
        iArr[3] = (int) (j2 + (UIDFolder.MAXUID & ((long) iArr[3])) + 2);
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.d.add(iArr, iArr2, iArr3) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && g.a.g.c.d.gte(iArr3, f13915a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.add(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && g.a.g.c.h.gte(iArr3, f13916b))) {
            int[] iArr4 = f13917c;
            g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && g.a.g.c.d.gte(iArr2, f13915a))) {
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
        iArr[3] = (int) (j2 + ((UIDFolder.MAXUID & ((long) iArr[3])) - 2));
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.d.fromBigInteger(bigInteger);
        if ((iArrFromBigInteger[3] >>> 1) >= 2147483646) {
            int[] iArr = f13915a;
            if (g.a.g.c.d.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.d.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(4, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(4, iArr2, g.a.g.c.d.add(iArr, f13915a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13915a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.d.createExt();
        g.a.g.c.d.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.d.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && g.a.g.c.h.gte(iArr3, f13916b))) {
            int[] iArr4 = f13917c;
            g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.d.sub(f13915a, iArr, iArr2);
        } else {
            int[] iArr3 = f13915a;
            g.a.g.c.d.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[16];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 4);
        } while (g.a.g.c.n.lessThan(4, iArr, f13915a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[1]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr[2]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr[3]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr[4]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr[5]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr[6]) & UIDFolder.MAXUID;
        long j8 = ((long) iArr[7]) & UIDFolder.MAXUID;
        long j9 = j4 + j8;
        long j10 = j7 + (j8 << 1);
        long j11 = j3 + j10;
        long j12 = j6 + (j10 << 1);
        long j13 = j2 + j12;
        long j14 = j5 + (j12 << 1);
        long j15 = j + j14;
        iArr2[0] = (int) j15;
        long j16 = j13 + (j15 >>> 32);
        iArr2[1] = (int) j16;
        long j17 = j11 + (j16 >>> 32);
        iArr2[2] = (int) j17;
        long j18 = j9 + (j14 << 1) + (j17 >>> 32);
        iArr2[3] = (int) j18;
        reduce32((int) (j18 >>> 32), iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        while (i2 != 0) {
            long j = ((long) i2) & UIDFolder.MAXUID;
            long j2 = (((long) iArr[0]) & UIDFolder.MAXUID) + j;
            iArr[0] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (((long) iArr[1]) & UIDFolder.MAXUID);
                iArr[1] = (int) j4;
                long j5 = (j4 >> 32) + (((long) iArr[2]) & UIDFolder.MAXUID);
                iArr[2] = (int) j5;
                j3 = j5 >> 32;
            }
            long j6 = j3 + (UIDFolder.MAXUID & ((long) iArr[3])) + (j << 1);
            iArr[3] = (int) j6;
            i2 = (int) (j6 >> 32);
        }
        if ((iArr[3] >>> 1) < 2147483646 || !g.a.g.c.d.gte(iArr, f13915a)) {
            return;
        }
        a(iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.d.createExt();
        g.a.g.c.d.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.d.createExt();
        g.a.g.c.d.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.d.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.d.sub(iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f13917c;
            g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && g.a.g.c.d.gte(iArr2, f13915a))) {
            a(iArr2);
        }
    }
}
