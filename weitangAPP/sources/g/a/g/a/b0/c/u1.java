package g.a.g.a.b0.c;

import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class u1 {
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
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = j8 >>> 35;
    }

    public static void c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = (j3 >>> 49) ^ (j4 << 15);
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
        jArr2[i2] = jArr2[i2] ^ (576460752303423487L & j3);
        int i6 = i2 + 1;
        jArr2[i6] = jArr2[i6] ^ ((j3 >>> 59) ^ (j4 << 5));
    }

    public static void f(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 4, jArr2, 0);
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(SubmitLifeOrderVo.ITEM_TYPE_INFO, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        g.a.g.c.h.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 233; i2 += 2) {
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
        squareN(jArrCreate64, 58, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        squareN(jArrCreate642, 116, jArrCreate64);
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
        long j9 = j6 ^ (j8 >>> 31);
        long j10 = (j5 ^ ((j8 >>> 41) ^ (j8 << 33))) ^ (j7 >>> 31);
        long j11 = ((j4 ^ (j8 << 23)) ^ ((j7 >>> 41) ^ (j7 << 33))) ^ (j9 >>> 31);
        long j12 = j ^ (j10 << 23);
        long j13 = (j2 ^ (j9 << 23)) ^ ((j10 >>> 41) ^ (j10 << 33));
        long j14 = ((j3 ^ (j7 << 23)) ^ ((j9 >>> 41) ^ (j9 << 33))) ^ (j10 >>> 31);
        long j15 = j11 >>> 41;
        jArr2[0] = j12 ^ j15;
        jArr2[1] = (j15 << 10) ^ j13;
        jArr2[2] = j14;
        jArr2[3] = 2199023255551L & j11;
    }

    public static void reduce23(long[] jArr, int i2) {
        int i3 = i2 + 3;
        long j = jArr[i3];
        long j2 = j >>> 41;
        jArr[i2] = jArr[i2] ^ j2;
        int i4 = i2 + 1;
        jArr[i4] = (j2 << 10) ^ jArr[i4];
        jArr[i3] = j & 2199023255551L;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long jUnshuffle = g.a.g.c.b.unshuffle(jArr[0]);
        long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[1]);
        long j = (jUnshuffle & UIDFolder.MAXUID) | (jUnshuffle2 << 32);
        long j2 = (jUnshuffle >>> 32) | (jUnshuffle2 & (-4294967296L));
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[2]);
        long jUnshuffle4 = g.a.g.c.b.unshuffle(jArr[3]);
        long j3 = (UIDFolder.MAXUID & jUnshuffle3) | (jUnshuffle4 << 32);
        long j4 = (jUnshuffle3 >>> 32) | (jUnshuffle4 & (-4294967296L));
        long j5 = j4 >>> 27;
        long j6 = j4 ^ ((j2 >>> 27) | (j4 << 37));
        long j7 = j2 ^ (j2 << 37);
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        int[] iArr = {32, 117, 191};
        int i2 = 0;
        for (int i3 = 3; i2 < i3; i3 = 3) {
            int i4 = iArr[i2] >>> 6;
            int i5 = iArr[i2] & 63;
            jArrCreateExt64[i4] = jArrCreateExt64[i4] ^ (j7 << i5);
            int i6 = i4 + 1;
            int i7 = -i5;
            jArrCreateExt64[i6] = jArrCreateExt64[i6] ^ ((j6 << i5) | (j7 >>> i7));
            int i8 = i4 + 2;
            jArrCreateExt64[i8] = jArrCreateExt64[i8] ^ ((j5 << i5) | (j6 >>> i7));
            int i9 = i4 + 3;
            jArrCreateExt64[i9] = jArrCreateExt64[i9] ^ (j5 >>> i7);
            i2++;
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
        return ((int) (jArr[0] ^ (jArr[2] >>> 31))) & 1;
    }
}
