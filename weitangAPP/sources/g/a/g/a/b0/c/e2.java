package g.a.g.a.b0.c;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f13944a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
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
        jArr[0] = j ^ (j2 << 57);
        jArr[1] = (j2 >>> 7) ^ (j3 << 50);
        jArr[2] = (j3 >>> 14) ^ (j4 << 43);
        jArr[3] = (j4 >>> 21) ^ (j5 << 36);
        jArr[4] = (j5 >>> 28) ^ (j6 << 29);
        jArr[5] = (j6 >>> 35) ^ (j7 << 22);
        jArr[6] = (j7 >>> 42) ^ (j8 << 15);
        jArr[7] = (j8 >>> 49) ^ (j9 << 8);
        jArr[8] = (j9 >>> 56) ^ (j10 << 1);
        jArr[9] = j10 >>> 63;
    }

    public static void c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        c(jArr, jArr4);
        c(jArr2, jArr5);
        long[] jArr6 = new long[26];
        e(jArr3, jArr4[0], jArr5[0], jArr6, 0);
        e(jArr3, jArr4[1], jArr5[1], jArr6, 2);
        e(jArr3, jArr4[2], jArr5[2], jArr6, 4);
        e(jArr3, jArr4[3], jArr5[3], jArr6, 6);
        e(jArr3, jArr4[4], jArr5[4], jArr6, 8);
        long j = jArr4[0] ^ jArr4[1];
        long j2 = jArr5[0] ^ jArr5[1];
        long j3 = jArr4[0] ^ jArr4[2];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr4[2] ^ jArr4[4];
        long j6 = jArr5[2] ^ jArr5[4];
        long j7 = jArr4[3] ^ jArr4[4];
        long j8 = jArr5[3] ^ jArr5[4];
        e(jArr3, j3 ^ jArr4[3], j4 ^ jArr5[3], jArr6, 18);
        e(jArr3, j5 ^ jArr4[1], j6 ^ jArr5[1], jArr6, 20);
        long j9 = j ^ j7;
        long j10 = j2 ^ j8;
        long j11 = j9 ^ jArr4[2];
        long j12 = j10 ^ jArr5[2];
        e(jArr3, j9, j10, jArr6, 22);
        e(jArr3, j11, j12, jArr6, 24);
        e(jArr3, j, j2, jArr6, 10);
        e(jArr3, j3, j4, jArr6, 12);
        e(jArr3, j5, j6, jArr6, 14);
        e(jArr3, j7, j8, jArr6, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j13 = jArr6[0] ^ jArr6[1];
        long j14 = jArr6[2] ^ j13;
        long j15 = jArr6[10] ^ j14;
        jArr3[1] = j15;
        long j16 = jArr6[3] ^ jArr6[4];
        long j17 = j14 ^ (j16 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j17;
        long j18 = j13 ^ j16;
        long j19 = jArr6[5] ^ jArr6[6];
        long j20 = (j18 ^ j19) ^ jArr6[8];
        long j21 = jArr6[13] ^ jArr6[14];
        jArr3[3] = (j20 ^ j21) ^ ((jArr6[18] ^ jArr6[22]) ^ jArr6[24]);
        long j22 = (jArr6[7] ^ jArr6[8]) ^ jArr6[9];
        long j23 = j22 ^ jArr6[17];
        jArr3[8] = j23;
        long j24 = (j22 ^ j19) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j24;
        long j25 = j15 ^ j24;
        long j26 = (jArr6[19] ^ jArr6[20]) ^ (jArr6[25] ^ jArr6[24]);
        jArr3[4] = (j26 ^ (jArr6[18] ^ jArr6[23])) ^ j25;
        jArr3[5] = ((j17 ^ j23) ^ j26) ^ (jArr6[21] ^ jArr6[22]);
        jArr3[6] = (((((j20 ^ jArr6[0]) ^ jArr6[9]) ^ j21) ^ jArr6[21]) ^ jArr6[23]) ^ jArr6[25];
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
        long j3 = jArr[((int) j) & 7];
        long j4 = 0;
        int i3 = 48;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = (jArr[(i4 >>> 6) & 7] << 6) ^ (jArr[i4 & 7] ^ (jArr[(i4 >>> 3) & 7] << 3));
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 9;
        } while (i3 > 0);
        jArr2[i2] = 144115188075855871L & j3;
        jArr2[i2 + 1] = (((((j & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j4) << 7) ^ (j3 >>> 57);
    }

    public static void f(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 4, jArr2, 0);
        jArr2[8] = g.a.g.c.b.expand32to64((int) jArr[4]);
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(283, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(9);
        g.a.g.c.i.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 283; i2 += 2) {
            f(jArr2, jArrCreate64);
            reduce(jArrCreate64, jArr2);
            f(jArr2, jArrCreate64);
            reduce(jArrCreate64, jArr2);
            a(jArr, jArr2);
        }
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (g.a.g.c.i.isZero64(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrCreate64 = g.a.g.c.i.create64();
        long[] jArrCreate642 = g.a.g.c.i.create64();
        square(jArr, jArrCreate64);
        multiply(jArrCreate64, jArr, jArrCreate64);
        squareN(jArrCreate64, 2, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        squareN(jArrCreate642, 4, jArrCreate64);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 8, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        square(jArrCreate642, jArrCreate642);
        multiply(jArrCreate642, jArr, jArrCreate642);
        squareN(jArrCreate642, 17, jArrCreate64);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        square(jArrCreate64, jArrCreate64);
        multiply(jArrCreate64, jArr, jArrCreate64);
        squareN(jArrCreate64, 35, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        squareN(jArrCreate642, 70, jArrCreate64);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        square(jArrCreate64, jArrCreate64);
        multiply(jArrCreate64, jArr, jArrCreate64);
        squareN(jArrCreate64, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, jArrCreate642);
        multiply(jArrCreate642, jArrCreate64, jArrCreate642);
        square(jArrCreate642, jArr2);
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.i.createExt64();
        d(jArr, jArr2, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.i.createExt64();
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
        long j9 = jArr[8];
        long j10 = j5 ^ ((((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15));
        long j11 = j ^ ((((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49));
        long j12 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        long j13 = j10 >>> 27;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 12);
        jArr2[1] = j12;
        jArr2[2] = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        jArr2[3] = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        jArr2[4] = 134217727 & j10;
    }

    public static void reduce37(long[] jArr, int i2) {
        int i3 = i2 + 4;
        long j = jArr[i3];
        long j2 = j >>> 27;
        jArr[i2] = ((j2 << 12) ^ (((j2 << 5) ^ j2) ^ (j2 << 7))) ^ jArr[i2];
        jArr[i3] = j & 134217727;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        long jUnshuffle = g.a.g.c.b.unshuffle(jArr[0]);
        long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[1]);
        long j = (jUnshuffle & UIDFolder.MAXUID) | (jUnshuffle2 << 32);
        jArrCreate64[0] = (jUnshuffle >>> 32) | (jUnshuffle2 & (-4294967296L));
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[2]);
        long jUnshuffle4 = g.a.g.c.b.unshuffle(jArr[3]);
        long j2 = (jUnshuffle3 & UIDFolder.MAXUID) | (jUnshuffle4 << 32);
        jArrCreate64[1] = (jUnshuffle3 >>> 32) | ((-4294967296L) & jUnshuffle4);
        long jUnshuffle5 = g.a.g.c.b.unshuffle(jArr[4]);
        long j3 = UIDFolder.MAXUID & jUnshuffle5;
        jArrCreate64[2] = jUnshuffle5 >>> 32;
        multiply(jArrCreate64, f13944a, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ j2;
        jArr2[2] = jArr2[2] ^ j3;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(9);
        f(jArr, jArrCreate64);
        reduce(jArrCreate64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(9);
        f(jArr, jArrCreate64);
        addExt(jArr2, jArrCreate64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.n.create64(9);
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
        return ((int) (jArr[0] ^ (jArr[4] >>> 15))) & 1;
    }
}
