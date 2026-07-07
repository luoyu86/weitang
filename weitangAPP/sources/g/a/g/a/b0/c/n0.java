package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14002a = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f14003b = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f14004c = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & UIDFolder.MAXUID) - 1);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & UIDFolder.MAXUID);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + (((long) iArr[3]) & UIDFolder.MAXUID) + 1;
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + (UIDFolder.MAXUID & ((long) iArr[4])) + 1;
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            g.a.g.c.n.incAt(12, iArr, 5);
        }
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && g.a.g.c.n.gte(12, iArr3, f14002a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && g.a.g.c.n.gte(24, iArr3, f14003b))) {
            int[] iArr4 = f14004c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && g.a.g.c.n.gte(12, iArr2, f14002a))) {
            a(iArr2);
        }
    }

    public static void b(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) - 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + 1;
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & UIDFolder.MAXUID);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + ((((long) iArr[3]) & UIDFolder.MAXUID) - 1);
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + ((UIDFolder.MAXUID & ((long) iArr[4])) - 1);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            g.a.g.c.n.decAt(12, iArr, 5);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.n.fromBigInteger(384, bigInteger);
        if (iArrFromBigInteger[11] == -1) {
            int[] iArr = f14002a;
            if (g.a.g.c.n.gte(12, iArrFromBigInteger, iArr)) {
                g.a.g.c.n.subFrom(12, iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(12, iArr2, g.a.g.c.n.add(12, iArr, f14002a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f14002a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 12; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = g.a.g.c.n.create(24);
        g.a.g.c.j.mul(iArr, iArr2, iArrCreate);
        reduce(iArrCreate, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.n.sub(12, f14002a, iArr, iArr2);
        } else {
            int[] iArr3 = f14002a;
            g.a.g.c.n.sub(12, iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[48];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 12);
        } while (g.a.g.c.n.lessThan(12, iArr, f14002a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[16]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[17]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr[18]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr[19]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr[20]) & UIDFolder.MAXUID;
        long j6 = ((long) iArr[21]) & UIDFolder.MAXUID;
        long j7 = ((long) iArr[22]) & UIDFolder.MAXUID;
        long j8 = ((long) iArr[23]) & UIDFolder.MAXUID;
        long j9 = ((((long) iArr[12]) & UIDFolder.MAXUID) + j5) - 1;
        long j10 = (((long) iArr[13]) & UIDFolder.MAXUID) + j7;
        long j11 = (((long) iArr[14]) & UIDFolder.MAXUID) + j7 + j8;
        long j12 = (((long) iArr[15]) & UIDFolder.MAXUID) + j8;
        long j13 = j2 + j6;
        long j14 = j6 - j8;
        long j15 = j7 - j8;
        long j16 = j9 + j14;
        long j17 = (((long) iArr[0]) & UIDFolder.MAXUID) + j16 + 0;
        iArr2[0] = (int) j17;
        long j18 = (j17 >> 32) + (((((long) iArr[1]) & UIDFolder.MAXUID) + j8) - j9) + j10;
        iArr2[1] = (int) j18;
        long j19 = (j18 >> 32) + (((((long) iArr[2]) & UIDFolder.MAXUID) - j6) - j10) + j11;
        iArr2[2] = (int) j19;
        long j20 = (j19 >> 32) + ((((long) iArr[3]) & UIDFolder.MAXUID) - j11) + j12 + j16;
        iArr2[3] = (int) j20;
        long j21 = (j20 >> 32) + (((((((long) iArr[4]) & UIDFolder.MAXUID) + j) + j6) + j10) - j12) + j16;
        iArr2[4] = (int) j21;
        long j22 = (j21 >> 32) + ((((long) iArr[5]) & UIDFolder.MAXUID) - j) + j10 + j11 + j13;
        iArr2[5] = (int) j22;
        long j23 = (j22 >> 32) + (((((long) iArr[6]) & UIDFolder.MAXUID) + j3) - j2) + j11 + j12;
        iArr2[6] = (int) j23;
        long j24 = (j23 >> 32) + ((((((long) iArr[7]) & UIDFolder.MAXUID) + j) + j4) - j3) + j12;
        iArr2[7] = (int) j24;
        long j25 = (j24 >> 32) + (((((((long) iArr[8]) & UIDFolder.MAXUID) + j) + j2) + j5) - j4);
        iArr2[8] = (int) j25;
        long j26 = (j25 >> 32) + (((((long) iArr[9]) & UIDFolder.MAXUID) + j3) - j5) + j13;
        iArr2[9] = (int) j26;
        long j27 = (j26 >> 32) + ((((((long) iArr[10]) & UIDFolder.MAXUID) + j3) + j4) - j14) + j15;
        iArr2[10] = (int) j27;
        long j28 = (j27 >> 32) + ((((((long) iArr[11]) & UIDFolder.MAXUID) + j4) + j5) - j15);
        iArr2[11] = (int) j28;
        reduce32((int) ((j28 >> 32) + 1), iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        long j;
        if (i2 != 0) {
            long j2 = ((long) i2) & UIDFolder.MAXUID;
            long j3 = (((long) iArr[0]) & UIDFolder.MAXUID) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = (j3 >> 32) + ((((long) iArr[1]) & UIDFolder.MAXUID) - j2);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (((long) iArr[2]) & UIDFolder.MAXUID);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = j5 + (((long) iArr[3]) & UIDFolder.MAXUID) + j2;
            iArr[3] = (int) j7;
            long j8 = (j7 >> 32) + (UIDFolder.MAXUID & ((long) iArr[4])) + j2;
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || g.a.g.c.n.incAt(12, iArr, 5) == 0) && !(iArr[11] == -1 && g.a.g.c.n.gte(12, iArr, f14002a))) {
            return;
        }
        a(iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreate = g.a.g.c.n.create(24);
        g.a.g.c.j.square(iArr, iArrCreate);
        reduce(iArrCreate, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreate = g.a.g.c.n.create(24);
        g.a.g.c.j.square(iArr, iArrCreate);
        while (true) {
            reduce(iArrCreate, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.j.square(iArr2, iArrCreate);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(12, iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f14004c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && g.a.g.c.n.gte(12, iArr2, f14002a))) {
            a(iArr2);
        }
    }
}
