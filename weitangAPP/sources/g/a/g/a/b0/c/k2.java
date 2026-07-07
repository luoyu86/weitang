package g.a.g.a.b0.c;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class k2 {
    public static void a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
        jArr2[5] = jArr2[5] ^ jArr[5];
        jArr2[6] = jArr2[6] ^ jArr[6];
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 13; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
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
        long j9 = jArr[8];
        long j10 = jArr[9];
        long j11 = jArr[10];
        long j12 = jArr[11];
        long j13 = jArr[12];
        long j14 = jArr[13];
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = (j8 >>> 35) ^ (j9 << 24);
        jArr[8] = (j9 >>> 40) ^ (j10 << 19);
        jArr[9] = (j10 >>> 45) ^ (j11 << 14);
        jArr[10] = (j11 >>> 50) ^ (j12 << 9);
        jArr[11] = ((j12 >>> 55) ^ (j13 << 4)) ^ (j14 << 63);
        jArr[12] = j14 >>> 1;
    }

    public static void c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = ((j3 >>> 49) ^ (j4 << 15)) & 576460752303423487L;
        jArr2[4] = ((j4 >>> 44) ^ (j5 << 20)) & 576460752303423487L;
        jArr2[5] = ((j5 >>> 39) ^ (j6 << 25)) & 576460752303423487L;
        jArr2[6] = (j6 >>> 34) ^ (j7 << 30);
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        c(jArr, jArr4);
        c(jArr2, jArr5);
        long[] jArr6 = new long[8];
        for (int i2 = 0; i2 < 7; i2++) {
            e(jArr6, jArr4[i2], jArr5[i2], jArr3, i2 << 1);
        }
        long j = jArr3[0];
        long j2 = jArr3[1];
        long j3 = j ^ jArr3[2];
        jArr3[1] = j3 ^ j2;
        long j4 = j2 ^ jArr3[3];
        long j5 = j3 ^ jArr3[4];
        jArr3[2] = j5 ^ j4;
        long j6 = j4 ^ jArr3[5];
        long j7 = j5 ^ jArr3[6];
        jArr3[3] = j7 ^ j6;
        long j8 = j6 ^ jArr3[7];
        long j9 = j7 ^ jArr3[8];
        jArr3[4] = j9 ^ j8;
        long j10 = j8 ^ jArr3[9];
        long j11 = j9 ^ jArr3[10];
        jArr3[5] = j11 ^ j10;
        long j12 = j10 ^ jArr3[11];
        long j13 = j11 ^ jArr3[12];
        jArr3[6] = j13 ^ j12;
        long j14 = j13 ^ (j12 ^ jArr3[13]);
        jArr3[7] = jArr3[0] ^ j14;
        jArr3[8] = jArr3[1] ^ j14;
        jArr3[9] = jArr3[2] ^ j14;
        jArr3[10] = jArr3[3] ^ j14;
        jArr3[11] = jArr3[4] ^ j14;
        jArr3[12] = jArr3[5] ^ j14;
        jArr3[13] = j14 ^ jArr3[6];
        e(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        e(jArr6, jArr4[0] ^ jArr4[2], jArr5[0] ^ jArr5[2], jArr3, 2);
        e(jArr6, jArr4[0] ^ jArr4[3], jArr5[0] ^ jArr5[3], jArr3, 3);
        e(jArr6, jArr4[1] ^ jArr4[2], jArr5[1] ^ jArr5[2], jArr3, 3);
        e(jArr6, jArr4[0] ^ jArr4[4], jArr5[0] ^ jArr5[4], jArr3, 4);
        e(jArr6, jArr4[1] ^ jArr4[3], jArr5[1] ^ jArr5[3], jArr3, 4);
        e(jArr6, jArr4[0] ^ jArr4[5], jArr5[0] ^ jArr5[5], jArr3, 5);
        e(jArr6, jArr4[1] ^ jArr4[4], jArr5[1] ^ jArr5[4], jArr3, 5);
        e(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 5);
        e(jArr6, jArr4[0] ^ jArr4[6], jArr5[0] ^ jArr5[6], jArr3, 6);
        e(jArr6, jArr4[1] ^ jArr4[5], jArr5[1] ^ jArr5[5], jArr3, 6);
        e(jArr6, jArr4[2] ^ jArr4[4], jArr5[2] ^ jArr5[4], jArr3, 6);
        e(jArr6, jArr4[1] ^ jArr4[6], jArr5[1] ^ jArr5[6], jArr3, 7);
        e(jArr6, jArr4[2] ^ jArr4[5], jArr5[2] ^ jArr5[5], jArr3, 7);
        e(jArr6, jArr4[3] ^ jArr4[4], jArr5[3] ^ jArr5[4], jArr3, 7);
        e(jArr6, jArr4[2] ^ jArr4[6], jArr5[2] ^ jArr5[6], jArr3, 8);
        e(jArr6, jArr4[3] ^ jArr4[5], jArr5[3] ^ jArr5[5], jArr3, 8);
        e(jArr6, jArr4[3] ^ jArr4[6], jArr5[3] ^ jArr5[6], jArr3, 9);
        e(jArr6, jArr4[4] ^ jArr4[5], jArr5[4] ^ jArr5[5], jArr3, 9);
        e(jArr6, jArr4[4] ^ jArr4[6], jArr5[4] ^ jArr5[6], jArr3, 10);
        e(jArr6, jArr4[5] ^ jArr4[6], jArr5[5] ^ jArr5[6], jArr3, 11);
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
        jArr2[i2] = jArr2[i2] ^ (576460752303423487L & j3);
        int i6 = i2 + 1;
        jArr2[i6] = jArr2[i6] ^ ((j3 >>> 59) ^ (j4 << 5));
    }

    public static void f(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 6, jArr2, 0);
        jArr2[12] = g.a.g.c.b.expand32to64((int) jArr[6]);
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(TTAdConstant.IMAGE_LIST_CODE, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(13);
        g.a.g.c.k.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 409; i2 += 2) {
            f(jArr2, jArrCreate64);
            reduce(jArrCreate64, jArr2);
            f(jArr2, jArrCreate64);
            reduce(jArrCreate64, jArr2);
            a(jArr, jArr2);
        }
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (g.a.g.c.k.isZero64(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrCreate64 = g.a.g.c.k.create64();
        long[] jArrCreate642 = g.a.g.c.k.create64();
        long[] jArrCreate643 = g.a.g.c.k.create64();
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
        multiply(jArrCreate64, jArrCreate642, jArrCreate643);
        squareN(jArrCreate643, 24, jArrCreate64);
        squareN(jArrCreate64, 24, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 48, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 96, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 192, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        multiply(jArrCreate64, jArrCreate643, jArr2);
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.k.createExt64();
        d(jArr, jArr2, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.k.createExt64();
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
        long j9 = jArr[12];
        long j10 = j6 ^ (j9 << 39);
        long j11 = j7 ^ ((j9 >>> 25) ^ (j9 << 62));
        long j12 = j8 ^ (j9 >>> 2);
        long j13 = jArr[11];
        long j14 = j5 ^ (j13 << 39);
        long j15 = j10 ^ ((j13 >>> 25) ^ (j13 << 62));
        long j16 = j11 ^ (j13 >>> 2);
        long j17 = jArr[10];
        long j18 = j4 ^ (j17 << 39);
        long j19 = j14 ^ ((j17 >>> 25) ^ (j17 << 62));
        long j20 = j15 ^ (j17 >>> 2);
        long j21 = jArr[9];
        long j22 = j3 ^ (j21 << 39);
        long j23 = j18 ^ ((j21 >>> 25) ^ (j21 << 62));
        long j24 = j19 ^ (j21 >>> 2);
        long j25 = jArr[8];
        long j26 = j ^ (j12 << 39);
        long j27 = (j2 ^ (j25 << 39)) ^ ((j12 >>> 25) ^ (j12 << 62));
        long j28 = (j22 ^ ((j25 >>> 25) ^ (j25 << 62))) ^ (j12 >>> 2);
        long j29 = j16 >>> 25;
        jArr2[0] = j26 ^ j29;
        jArr2[1] = (j29 << 23) ^ j27;
        jArr2[2] = j28;
        jArr2[3] = j23 ^ (j25 >>> 2);
        jArr2[4] = j24;
        jArr2[5] = j20;
        jArr2[6] = j16 & 33554431;
    }

    public static void reduce39(long[] jArr, int i2) {
        int i3 = i2 + 6;
        long j = jArr[i3];
        long j2 = j >>> 25;
        jArr[i2] = jArr[i2] ^ j2;
        int i4 = i2 + 1;
        jArr[i4] = (j2 << 23) ^ jArr[i4];
        jArr[i3] = j & 33554431;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long jUnshuffle = g.a.g.c.b.unshuffle(jArr[0]);
        long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[1]);
        long j = (jUnshuffle & UIDFolder.MAXUID) | (jUnshuffle2 << 32);
        long j2 = (jUnshuffle >>> 32) | (jUnshuffle2 & (-4294967296L));
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[2]);
        long jUnshuffle4 = g.a.g.c.b.unshuffle(jArr[3]);
        long j3 = (jUnshuffle3 & UIDFolder.MAXUID) | (jUnshuffle4 << 32);
        long j4 = (jUnshuffle3 >>> 32) | (jUnshuffle4 & (-4294967296L));
        long jUnshuffle5 = g.a.g.c.b.unshuffle(jArr[4]);
        long jUnshuffle6 = g.a.g.c.b.unshuffle(jArr[5]);
        long j5 = (jUnshuffle5 & UIDFolder.MAXUID) | (jUnshuffle6 << 32);
        long j6 = (jUnshuffle5 >>> 32) | (jUnshuffle6 & (-4294967296L));
        long jUnshuffle7 = g.a.g.c.b.unshuffle(jArr[6]);
        long j7 = jUnshuffle7 & UIDFolder.MAXUID;
        long j8 = jUnshuffle7 >>> 32;
        jArr2[0] = j ^ (j2 << 44);
        jArr2[1] = (j3 ^ (j4 << 44)) ^ (j2 >>> 20);
        jArr2[2] = (j5 ^ (j6 << 44)) ^ (j4 >>> 20);
        jArr2[3] = (((j8 << 44) ^ j7) ^ (j6 >>> 20)) ^ (j2 << 13);
        jArr2[4] = (j2 >>> 51) ^ ((j8 >>> 20) ^ (j4 << 13));
        jArr2[5] = (j6 << 13) ^ (j4 >>> 51);
        jArr2[6] = (j8 << 13) ^ (j6 >>> 51);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(13);
        f(jArr, jArrCreate64);
        reduce(jArrCreate64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(13);
        f(jArr, jArrCreate64);
        addExt(jArr2, jArrCreate64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(13);
        f(jArr, jArrCreate64);
        while (true) {
            reduce(jArrCreate64, jArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                f(jArr2, jArrCreate64);
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}
