package g.a.g.a.b0.c;

import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class o1 {
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
        jArr3[6] = jArr2[6] ^ jArr[6];
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
        jArr[0] = j ^ (j2 << 49);
        jArr[1] = (j2 >>> 15) ^ (j3 << 34);
        jArr[2] = (j3 >>> 30) ^ (j4 << 19);
        jArr[3] = ((j4 >>> 45) ^ (j5 << 4)) ^ (j6 << 53);
        jArr[4] = ((j5 >>> 60) ^ (j7 << 38)) ^ (j6 >>> 11);
        jArr[5] = (j7 >>> 26) ^ (j8 << 23);
        jArr[6] = j8 >>> 41;
        jArr[7] = 0;
    }

    public static void c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 562949953421311L;
        jArr2[1] = ((j >>> 49) ^ (j2 << 15)) & 562949953421311L;
        jArr2[2] = ((j2 >>> 34) ^ (j3 << 30)) & 562949953421311L;
        jArr2[3] = (j3 >>> 19) ^ (j4 << 45);
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
        int i4 = 36;
        do {
            int i5 = (int) (j >>> i4);
            long j5 = (jArr[(i5 >>> 12) & 7] << 12) ^ (((jArr[i5 & 7] ^ (jArr[(i5 >>> 3) & 7] << 3)) ^ (jArr[(i5 >>> 6) & 7] << 6)) ^ (jArr[(i5 >>> 9) & 7] << 9));
            j3 ^= j5 << i4;
            j4 ^= j5 >>> (-i4);
            i4 -= 15;
        } while (i4 > 0);
        jArr2[i2] = jArr2[i2] ^ (562949953421311L & j3);
        int i6 = i2 + 1;
        jArr2[i6] = jArr2[i6] ^ ((j3 >>> 49) ^ (j4 << 15));
    }

    public static void f(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 3, jArr2, 0);
        jArr2[6] = jArr[3] & 1;
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(193, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        g.a.g.c.h.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 193; i2 += 2) {
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
        squareN(jArrCreate64, 1, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 1, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 3, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 6, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 12, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 24, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 48, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 96, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArr2);
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
        long j8 = j5 ^ (j7 >>> 50);
        long j9 = (j4 ^ ((j7 >>> 1) ^ (j7 << 14))) ^ (j6 >>> 50);
        long j10 = j ^ (j8 << 63);
        long j11 = (j2 ^ (j6 << 63)) ^ ((j8 >>> 1) ^ (j8 << 14));
        long j12 = ((j3 ^ (j7 << 63)) ^ ((j6 >>> 1) ^ (j6 << 14))) ^ (j8 >>> 50);
        long j13 = j9 >>> 1;
        jArr2[0] = (j10 ^ j13) ^ (j13 << 15);
        jArr2[1] = (j13 >>> 49) ^ j11;
        jArr2[2] = j12;
        jArr2[3] = 1 & j9;
    }

    public static void reduce63(long[] jArr, int i2) {
        int i3 = i2 + 3;
        long j = jArr[i3];
        long j2 = j >>> 1;
        jArr[i2] = jArr[i2] ^ ((j2 << 15) ^ j2);
        int i4 = i2 + 1;
        jArr[i4] = (j2 >>> 49) ^ jArr[i4];
        jArr[i3] = j & 1;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long jUnshuffle = g.a.g.c.b.unshuffle(jArr[0]);
        long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[1]);
        long j = (jUnshuffle & UIDFolder.MAXUID) | (jUnshuffle2 << 32);
        long j2 = (jUnshuffle >>> 32) | (jUnshuffle2 & (-4294967296L));
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[2]);
        long j3 = (jUnshuffle3 & UIDFolder.MAXUID) ^ (jArr[3] << 32);
        long j4 = jUnshuffle3 >>> 32;
        jArr2[0] = j ^ (j2 << 8);
        jArr2[1] = ((j3 ^ (j4 << 8)) ^ (j2 >>> 56)) ^ (j2 << 33);
        jArr2[2] = (j2 >>> 31) ^ ((j4 >>> 56) ^ (j4 << 33));
        jArr2[3] = j4 >>> 31;
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
        return ((int) jArr[0]) & 1;
    }
}
