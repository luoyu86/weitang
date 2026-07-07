package g.a.g.a.b0.c;

import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f13955a = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static void b(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 55);
        jArr[1] = (j2 >>> 9) ^ (j3 << 46);
        jArr[2] = (j3 >>> 18) ^ (j4 << 37);
        jArr[3] = (j4 >>> 27) ^ (j5 << 28);
        jArr[4] = (j5 >>> 36) ^ (j6 << 19);
        jArr[5] = j6 >>> 45;
    }

    public static void c(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = (j2 >>> 46) ^ (jArr[2] << 18);
        long j4 = ((j2 << 9) ^ (j >>> 55)) & 36028797018963967L;
        long j5 = j & 36028797018963967L;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = (j7 >>> 46) ^ (jArr2[2] << 18);
        long j9 = ((j7 << 9) ^ (j6 >>> 55)) & 36028797018963967L;
        long j10 = j6 & 36028797018963967L;
        long[] jArr4 = new long[10];
        d(jArr3, j5, j10, jArr4, 0);
        d(jArr3, j3, j8, jArr4, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        d(jArr3, j11, j12, jArr4, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        d(jArr3, j5 ^ j13, j10 ^ j14, jArr4, 6);
        d(jArr3, j11 ^ j13, j12 ^ j14, jArr4, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j19 ^ j17) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j20 ^ j18) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 55);
        long j24 = (j21 ^ j16) ^ (j23 >>> 55);
        long j25 = j23 & 36028797018963967L;
        long j26 = ((j22 & 36028797018963967L) >>> 1) ^ ((j25 & 1) << 54);
        long j27 = j26 ^ (j26 << 1);
        long j28 = j27 ^ (j27 << 2);
        long j29 = j28 ^ (j28 << 4);
        long j30 = j29 ^ (j29 << 8);
        long j31 = j30 ^ (j30 << 16);
        long j32 = (j31 ^ (j31 << 32)) & 36028797018963967L;
        long j33 = ((j25 >>> 1) ^ ((j24 & 1) << 54)) ^ (j32 >>> 54);
        long j34 = j33 ^ (j33 << 1);
        long j35 = j34 ^ (j34 << 2);
        long j36 = j35 ^ (j35 << 4);
        long j37 = j36 ^ (j36 << 8);
        long j38 = j37 ^ (j37 << 16);
        long j39 = (j38 ^ (j38 << 32)) & 36028797018963967L;
        long j40 = (j24 >>> 1) ^ (j39 >>> 54);
        long j41 = j40 ^ (j40 << 1);
        long j42 = j41 ^ (j41 << 2);
        long j43 = j42 ^ (j42 << 4);
        long j44 = j43 ^ (j43 << 8);
        long j45 = j44 ^ (j44 << 16);
        long j46 = j45 ^ (j45 << 32);
        jArr3[0] = j19;
        jArr3[1] = (j20 ^ j32) ^ jArr4[2];
        jArr3[2] = ((j21 ^ j39) ^ j32) ^ jArr4[3];
        jArr3[3] = j39 ^ j46;
        jArr3[4] = jArr4[2] ^ j46;
        jArr3[5] = jArr4[3];
        b(jArr3);
    }

    public static void d(long[] jArr, long j, long j2, long[] jArr2, int i2) {
        jArr[1] = j2;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j2;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j2;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j2;
        long j3 = jArr[((int) j) & 3];
        long j4 = 0;
        int i3 = 47;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = (jArr[(i4 >>> 6) & 7] << 6) ^ (jArr[i4 & 7] ^ (jArr[(i4 >>> 3) & 7] << 3));
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 9;
        } while (i3 > 0);
        jArr2[i2] = 36028797018963967L & j3;
        jArr2[i2 + 1] = (j3 >>> 55) ^ (j4 << 9);
    }

    public static void e(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 3, jArr2, 0);
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(163, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.f.createExt64();
        g.a.g.c.f.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 163; i2 += 2) {
            e(jArr2, jArrCreateExt64);
            reduce(jArrCreateExt64, jArr2);
            e(jArr2, jArrCreateExt64);
            reduce(jArrCreateExt64, jArr2);
            a(jArr, jArr2);
        }
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (g.a.g.c.f.isZero64(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrCreate64 = g.a.g.c.f.create64();
        long[] jArrCreate642 = g.a.g.c.f.create64();
        square(jArr, jArrCreate64);
        squareN(jArrCreate64, 1, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 1, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 3, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 3, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 9, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 9, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 27, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 27, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 81, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArr2);
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        c(jArr, jArr2, jArr4);
        reduce(jArr4, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        c(jArr, jArr2, jArr4);
        addExt(jArr3, jArr4, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = j4 ^ ((((j6 >>> 35) ^ (j6 >>> 32)) ^ (j6 >>> 29)) ^ (j6 >>> 28));
        long j8 = (j3 ^ ((((j6 << 29) ^ (j6 << 32)) ^ (j6 << 35)) ^ (j6 << 36))) ^ ((j5 >>> 28) ^ (((j5 >>> 35) ^ (j5 >>> 32)) ^ (j5 >>> 29)));
        long j9 = j ^ ((((j7 << 29) ^ (j7 << 32)) ^ (j7 << 35)) ^ (j7 << 36));
        long j10 = (j2 ^ ((((j5 << 29) ^ (j5 << 32)) ^ (j5 << 35)) ^ (j5 << 36))) ^ ((j7 >>> 28) ^ (((j7 >>> 35) ^ (j7 >>> 32)) ^ (j7 >>> 29)));
        long j11 = j8 >>> 35;
        jArr2[0] = (((j9 ^ j11) ^ (j11 << 3)) ^ (j11 << 6)) ^ (j11 << 7);
        jArr2[1] = j10;
        jArr2[2] = 34359738367L & j8;
    }

    public static void reduce29(long[] jArr, int i2) {
        int i3 = i2 + 2;
        long j = jArr[i3];
        long j2 = j >>> 35;
        jArr[i2] = ((j2 << 7) ^ (((j2 << 3) ^ j2) ^ (j2 << 6))) ^ jArr[i2];
        jArr[i3] = j & 34359738367L;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        long jUnshuffle = g.a.g.c.b.unshuffle(jArr[0]);
        long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[1]);
        long j = (jUnshuffle & UIDFolder.MAXUID) | (jUnshuffle2 << 32);
        jArrCreate64[0] = (jUnshuffle >>> 32) | (jUnshuffle2 & (-4294967296L));
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[2]);
        long j2 = jUnshuffle3 & UIDFolder.MAXUID;
        jArrCreate64[1] = jUnshuffle3 >>> 32;
        multiply(jArrCreate64, f13955a, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ j2;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.f.createExt64();
        e(jArr, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.f.createExt64();
        e(jArr, jArrCreateExt64);
        addExt(jArr2, jArrCreateExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.f.createExt64();
        e(jArr, jArrCreateExt64);
        while (true) {
            reduce(jArrCreateExt64, jArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                e(jArr2, jArrCreateExt64);
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }
}
