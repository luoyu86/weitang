package g.a.g.a.b0.c;

import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class a2 {
    public static void a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static void b(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 60);
        jArr[1] = (j2 >>> 4) ^ (j3 << 56);
        jArr[2] = (j3 >>> 8) ^ (j4 << 52);
        jArr[3] = (j4 >>> 12) ^ (j5 << 48);
        jArr[4] = (j5 >>> 16) ^ (j6 << 44);
        jArr[5] = (j6 >>> 20) ^ (j7 << 40);
        jArr[6] = (j7 >>> 24) ^ (j8 << 36);
        jArr[7] = j8 >>> 28;
    }

    public static void c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 1152921504606846975L;
        jArr2[1] = ((j >>> 60) ^ (j2 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j2 >>> 56) ^ (j3 << 8)) & 1152921504606846975L;
        jArr2[3] = (j3 >>> 52) ^ (j4 << 12);
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        c(jArr, jArr4);
        c(jArr2, jArr5);
        long[] jArr6 = new long[8];
        e(jArr6, jArr4[0], jArr5[0], jArr3, 0);
        e(jArr6, jArr4[1], jArr5[1], jArr3, 1);
        e(jArr6, jArr4[2], jArr5[2], jArr3, 2);
        e(jArr6, jArr4[3], jArr5[3], jArr3, 3);
        for (int i2 = 5; i2 > 0; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 1];
        }
        e(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        e(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i3 = 7; i3 > 1; i3--) {
            jArr3[i3] = jArr3[i3] ^ jArr3[i3 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        e(jArr6, j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        e(jArr6, j, j3, jArr7, 0);
        e(jArr6, j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        long j7 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        b(jArr3);
    }

    public static void e(long[] jArr, long j, long j2, long[] jArr2, int i2) {
        jArr[1] = j2;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j2;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j2;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j2;
        int i3 = (int) j;
        long j3 = (jArr[(i3 >>> 3) & 7] << 3) ^ jArr[i3 & 7];
        long j4 = 0;
        int i4 = 54;
        do {
            int i5 = (int) (j >>> i4);
            long j5 = (jArr[(i5 >>> 3) & 7] << 3) ^ jArr[i5 & 7];
            j3 ^= j5 << i4;
            j4 ^= j5 >>> (-i4);
            i4 -= 6;
        } while (i4 > 0);
        jArr2[i2] = jArr2[i2] ^ (1152921504606846975L & j3);
        int i6 = i2 + 1;
        jArr2[i6] = ((((((j & 585610922974906400L) & ((j2 << 4) >> 63)) >>> 5) ^ j4) << 4) ^ (j3 >>> 60)) ^ jArr2[i6];
    }

    public static void f(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 4, jArr2, 0);
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(239, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        g.a.g.c.h.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 239; i2 += 2) {
            f(jArr2, jArrCreateExt64);
            reduce(jArrCreateExt64, jArr2);
            f(jArr2, jArrCreateExt64);
            reduce(jArrCreateExt64, jArr2);
            a(jArr, jArr2);
        }
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (g.a.g.c.h.isZero64(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrCreate64 = g.a.g.c.h.create64();
        long[] jArrCreate642 = g.a.g.c.h.create64();
        square(jArr, jArrCreate64);
        multiply(jArrCreate64, jArr, jArrCreate64);
        square(jArrCreate64, jArrCreate64);
        multiply(jArrCreate64, jArr, jArrCreate64);
        squareN(jArrCreate64, 3, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        square(jArrCreate642, jArrCreate642);
        multiply(jArrCreate642, jArr, jArrCreate642);
        squareN(jArrCreate642, 7, jArrCreate64);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 14, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        square(jArrCreate642, jArrCreate642);
        multiply(jArrCreate642, jArr, jArrCreate642);
        squareN(jArrCreate642, 29, jArrCreate64);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        square(jArrCreate64, jArrCreate64);
        multiply(jArrCreate64, jArr, jArrCreate64);
        squareN(jArrCreate64, 59, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        square(jArrCreate642, jArrCreate642);
        multiply(jArrCreate642, jArr, jArrCreate642);
        squareN(jArrCreate642, 119, jArrCreate64);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        square(jArrCreate64, jArr2);
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        d(jArr, jArr2, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        d(jArr, jArr2, jArrCreateExt64);
        addExt(jArr3, jArrCreateExt64, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = j7 ^ (j8 >>> 17);
        long j10 = (j6 ^ (j8 << 47)) ^ (j9 >>> 17);
        long j11 = ((j5 ^ (j8 >>> 47)) ^ (j9 << 47)) ^ (j10 >>> 17);
        long j12 = j ^ (j11 << 17);
        long j13 = (j2 ^ (j10 << 17)) ^ (j11 >>> 47);
        long j14 = ((j3 ^ (j9 << 17)) ^ (j10 >>> 47)) ^ (j11 << 47);
        long j15 = (((j4 ^ (j8 << 17)) ^ (j9 >>> 47)) ^ (j10 << 47)) ^ (j11 >>> 17);
        long j16 = j15 >>> 47;
        jArr2[0] = j12 ^ j16;
        jArr2[1] = j13;
        jArr2[2] = (j16 << 30) ^ j14;
        jArr2[3] = 140737488355327L & j15;
    }

    public static void reduce17(long[] jArr, int i2) {
        int i3 = i2 + 3;
        long j = jArr[i3];
        long j2 = j >>> 47;
        jArr[i2] = jArr[i2] ^ j2;
        int i4 = i2 + 2;
        jArr[i4] = (j2 << 30) ^ jArr[i4];
        jArr[i3] = j & 140737488355327L;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        int i2 = 0;
        long jUnshuffle = g.a.g.c.b.unshuffle(jArr[0]);
        long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[1]);
        long j = (jUnshuffle & UIDFolder.MAXUID) | (jUnshuffle2 << 32);
        long j2 = (jUnshuffle >>> 32) | (jUnshuffle2 & (-4294967296L));
        int i3 = 2;
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[2]);
        long jUnshuffle4 = g.a.g.c.b.unshuffle(jArr[3]);
        long j3 = (jUnshuffle3 & UIDFolder.MAXUID) | (jUnshuffle4 << 32);
        long j4 = (jUnshuffle4 & (-4294967296L)) | (jUnshuffle3 >>> 32);
        long j5 = j4 >>> 49;
        long j6 = (j2 >>> 49) | (j4 << 15);
        long j7 = j4 ^ (j2 << 15);
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        int[] iArr = {39, 120};
        while (i2 < i3) {
            int i4 = iArr[i2] >>> 6;
            int i5 = iArr[i2] & 63;
            jArrCreateExt64[i4] = jArrCreateExt64[i4] ^ (j2 << i5);
            int i6 = i4 + 1;
            int[] iArr2 = iArr;
            int i7 = -i5;
            jArrCreateExt64[i6] = jArrCreateExt64[i6] ^ ((j7 << i5) | (j2 >>> i7));
            int i8 = i4 + 2;
            jArrCreateExt64[i8] = jArrCreateExt64[i8] ^ ((j6 << i5) | (j7 >>> i7));
            int i9 = i4 + 3;
            jArrCreateExt64[i9] = jArrCreateExt64[i9] ^ ((j5 << i5) | (j6 >>> i7));
            int i10 = i4 + 4;
            jArrCreateExt64[i10] = jArrCreateExt64[i10] ^ (j5 >>> i7);
            i2++;
            i3 = 2;
            iArr = iArr2;
        }
        reduce(jArrCreateExt64, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ j3;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        f(jArr, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        f(jArr, jArrCreateExt64);
        addExt(jArr2, jArrCreateExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        f(jArr, jArrCreateExt64);
        while (true) {
            reduce(jArrCreateExt64, jArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                f(jArr2, jArrCreateExt64);
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[1] >>> 17)) ^ (jArr[2] >>> 34))) & 1;
    }
}
