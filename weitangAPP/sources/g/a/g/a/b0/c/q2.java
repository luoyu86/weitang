package g.a.g.a.b0.c;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.math.BigInteger;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f14027a = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    public static void a(long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        for (int i5 = 0; i5 < 9; i5++) {
            jArr3[i4 + i5] = jArr[i2 + i5] ^ jArr2[i3 + i5];
        }
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 9; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }

    public static void addBothTo(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 9; i2++) {
            jArr3[i2] = jArr3[i2] ^ (jArr[i2] ^ jArr2[i2]);
        }
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 18; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i2 = 1; i2 < 9; i2++) {
            jArr2[i2] = jArr[i2];
        }
    }

    public static void b(long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        for (int i5 = 0; i5 < 9; i5++) {
            int i6 = i4 + i5;
            jArr3[i6] = jArr3[i6] ^ (jArr[i2 + i5] ^ jArr2[i3 + i5]);
        }
    }

    public static void c(long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < 9; i2++) {
            jArr2[i2] = jArr2[i2] ^ jArr[i2];
        }
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[16];
        for (int i2 = 0; i2 < 9; i2++) {
            f(jArr4, jArr[i2], jArr2[i2], jArr3, i2 << 1);
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
        long j14 = j12 ^ jArr3[13];
        long j15 = j13 ^ jArr3[14];
        jArr3[7] = j15 ^ j14;
        long j16 = j14 ^ jArr3[15];
        long j17 = j15 ^ jArr3[16];
        jArr3[8] = j17 ^ j16;
        long j18 = j17 ^ (j16 ^ jArr3[17]);
        jArr3[9] = jArr3[0] ^ j18;
        jArr3[10] = jArr3[1] ^ j18;
        jArr3[11] = jArr3[2] ^ j18;
        jArr3[12] = jArr3[3] ^ j18;
        jArr3[13] = jArr3[4] ^ j18;
        jArr3[14] = jArr3[5] ^ j18;
        jArr3[15] = jArr3[6] ^ j18;
        jArr3[16] = jArr3[7] ^ j18;
        jArr3[17] = jArr3[8] ^ j18;
        f(jArr4, jArr[0] ^ jArr[1], jArr2[0] ^ jArr2[1], jArr3, 1);
        f(jArr4, jArr[0] ^ jArr[2], jArr2[0] ^ jArr2[2], jArr3, 2);
        f(jArr4, jArr[0] ^ jArr[3], jArr2[0] ^ jArr2[3], jArr3, 3);
        f(jArr4, jArr[1] ^ jArr[2], jArr2[1] ^ jArr2[2], jArr3, 3);
        f(jArr4, jArr[0] ^ jArr[4], jArr2[0] ^ jArr2[4], jArr3, 4);
        f(jArr4, jArr[1] ^ jArr[3], jArr2[1] ^ jArr2[3], jArr3, 4);
        f(jArr4, jArr[0] ^ jArr[5], jArr2[0] ^ jArr2[5], jArr3, 5);
        f(jArr4, jArr[1] ^ jArr[4], jArr2[1] ^ jArr2[4], jArr3, 5);
        f(jArr4, jArr[2] ^ jArr[3], jArr2[2] ^ jArr2[3], jArr3, 5);
        f(jArr4, jArr[0] ^ jArr[6], jArr2[0] ^ jArr2[6], jArr3, 6);
        f(jArr4, jArr[1] ^ jArr[5], jArr2[1] ^ jArr2[5], jArr3, 6);
        f(jArr4, jArr[2] ^ jArr[4], jArr2[2] ^ jArr2[4], jArr3, 6);
        f(jArr4, jArr[0] ^ jArr[7], jArr2[0] ^ jArr2[7], jArr3, 7);
        f(jArr4, jArr[1] ^ jArr[6], jArr2[1] ^ jArr2[6], jArr3, 7);
        f(jArr4, jArr[2] ^ jArr[5], jArr2[2] ^ jArr2[5], jArr3, 7);
        f(jArr4, jArr[3] ^ jArr[4], jArr2[3] ^ jArr2[4], jArr3, 7);
        f(jArr4, jArr[0] ^ jArr[8], jArr2[0] ^ jArr2[8], jArr3, 8);
        f(jArr4, jArr[1] ^ jArr[7], jArr2[1] ^ jArr2[7], jArr3, 8);
        f(jArr4, jArr[2] ^ jArr[6], jArr2[2] ^ jArr2[6], jArr3, 8);
        f(jArr4, jArr[3] ^ jArr[5], jArr2[3] ^ jArr2[5], jArr3, 8);
        f(jArr4, jArr[1] ^ jArr[8], jArr2[1] ^ jArr2[8], jArr3, 9);
        f(jArr4, jArr[2] ^ jArr[7], jArr2[2] ^ jArr2[7], jArr3, 9);
        f(jArr4, jArr[3] ^ jArr[6], jArr2[3] ^ jArr2[6], jArr3, 9);
        f(jArr4, jArr[4] ^ jArr[5], jArr2[4] ^ jArr2[5], jArr3, 9);
        f(jArr4, jArr[2] ^ jArr[8], jArr2[2] ^ jArr2[8], jArr3, 10);
        f(jArr4, jArr[3] ^ jArr[7], jArr2[3] ^ jArr2[7], jArr3, 10);
        f(jArr4, jArr[4] ^ jArr[6], jArr2[4] ^ jArr2[6], jArr3, 10);
        f(jArr4, jArr[3] ^ jArr[8], jArr2[3] ^ jArr2[8], jArr3, 11);
        f(jArr4, jArr[4] ^ jArr[7], jArr2[4] ^ jArr2[7], jArr3, 11);
        f(jArr4, jArr[5] ^ jArr[6], jArr2[5] ^ jArr2[6], jArr3, 11);
        f(jArr4, jArr[4] ^ jArr[8], jArr2[4] ^ jArr2[8], jArr3, 12);
        f(jArr4, jArr[5] ^ jArr[7], jArr2[5] ^ jArr2[7], jArr3, 12);
        f(jArr4, jArr[5] ^ jArr[8], jArr2[5] ^ jArr2[8], jArr3, 13);
        f(jArr4, jArr[6] ^ jArr[7], jArr2[6] ^ jArr2[7], jArr3, 13);
        f(jArr4, jArr[6] ^ jArr[8], jArr2[6] ^ jArr2[8], jArr3, 14);
        f(jArr4, jArr[7] ^ jArr[8], jArr2[7] ^ jArr2[8], jArr3, 15);
    }

    public static void e(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 56; i2 >= 0; i2 -= 8) {
            for (int i3 = 1; i3 < 9; i3 += 2) {
                int i4 = (int) (jArr[i3] >>> i2);
                b(jArr2, (i4 & 15) * 9, jArr2, (((i4 >>> 4) & 15) + 16) * 9, jArr3, i3 - 1);
            }
            g.a.g.c.n.shiftUpBits64(16, jArr3, 0, 8, 0L);
        }
        for (int i5 = 56; i5 >= 0; i5 -= 8) {
            for (int i6 = 0; i6 < 9; i6 += 2) {
                int i7 = (int) (jArr[i6] >>> i5);
                b(jArr2, (i7 & 15) * 9, jArr2, (((i7 >>> 4) & 15) + 16) * 9, jArr3, i6);
            }
            if (i5 > 0) {
                g.a.g.c.n.shiftUpBits64(18, jArr3, 0, 8, 0L);
            }
        }
    }

    public static void f(long[] jArr, long j, long j2, long[] jArr2, int i2) {
        long j3 = j;
        jArr[1] = j2;
        for (int i3 = 2; i3 < 16; i3 += 2) {
            jArr[i3] = jArr[i3 >>> 1] << 1;
            jArr[i3 + 1] = jArr[i3] ^ j2;
        }
        int i4 = (int) j3;
        long j4 = 0;
        long j5 = jArr[i4 & 15] ^ (jArr[(i4 >>> 4) & 15] << 4);
        int i5 = 56;
        do {
            int i6 = (int) (j3 >>> i5);
            long j6 = (jArr[(i6 >>> 4) & 15] << 4) ^ jArr[i6 & 15];
            j5 ^= j6 << i5;
            j4 ^= j6 >>> (-i5);
            i5 -= 8;
        } while (i5 > 0);
        for (int i7 = 0; i7 < 7; i7++) {
            j3 = (j3 & (-72340172838076674L)) >>> 1;
            j4 ^= ((j2 << i7) >> 63) & j3;
        }
        jArr2[i2] = jArr2[i2] ^ j5;
        int i8 = i2 + 1;
        jArr2[i8] = jArr2[i8] ^ j4;
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return g.a.g.c.n.fromBigInteger64(571, bigInteger);
    }

    public static void g(long[] jArr, long[] jArr2) {
        g.a.g.c.b.expand64To128(jArr, 0, 9, jArr2, 0);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        g.a.g.c.m.copy64(jArr, jArr2);
        for (int i2 = 1; i2 < 571; i2 += 2) {
            g(jArr2, jArrCreateExt64);
            reduce(jArrCreateExt64, jArr2);
            g(jArr2, jArrCreateExt64);
            reduce(jArrCreateExt64, jArr2);
            c(jArr, jArr2);
        }
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (g.a.g.c.m.isZero64(jArr)) {
            throw new IllegalStateException();
        }
        long[] jArrCreate64 = g.a.g.c.m.create64();
        long[] jArrCreate642 = g.a.g.c.m.create64();
        long[] jArrCreate643 = g.a.g.c.m.create64();
        square(jArr, jArrCreate643);
        square(jArrCreate643, jArrCreate64);
        square(jArrCreate64, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 2, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        multiply(jArrCreate64, jArrCreate643, jArrCreate64);
        squareN(jArrCreate64, 5, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 5, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 15, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate643);
        squareN(jArrCreate643, 30, jArrCreate64);
        squareN(jArrCreate64, 30, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, 60, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, 60, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate64, BaseTransientBottomBar.ANIMATION_FADE_DURATION, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        squareN(jArrCreate642, BaseTransientBottomBar.ANIMATION_FADE_DURATION, jArrCreate642);
        multiply(jArrCreate64, jArrCreate642, jArrCreate64);
        multiply(jArrCreate64, jArrCreate643, jArr2);
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        d(jArr, jArr2, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        d(jArr, jArr2, jArrCreateExt64);
        addExt(jArr3, jArrCreateExt64, jArr3);
    }

    public static void multiplyPrecomp(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        e(jArr, jArr2, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr3);
    }

    public static void multiplyPrecompAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        e(jArr, jArr2, jArrCreateExt64);
        addExt(jArr3, jArrCreateExt64, jArr3);
    }

    public static long[] precompMultiplicand(long[] jArr) {
        long[] jArr2 = new long[288];
        int i2 = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i3 = 7;
        while (i3 > 0) {
            int i4 = i2 + 18;
            g.a.g.c.n.shiftUpBit64(9, jArr2, i4 >>> 1, 0L, jArr2, i4);
            reduce5(jArr2, i4);
            a(jArr2, 9, jArr2, i4, jArr2, i4 + 9);
            i3--;
            i2 = i4;
        }
        g.a.g.c.n.shiftUpBits64(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, jArr2, 0, 4, 0L, jArr2, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS);
        return jArr2;
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j = jArr[9];
        long j2 = jArr[17];
        long j3 = (((j ^ (j2 >>> 59)) ^ (j2 >>> 57)) ^ (j2 >>> 54)) ^ (j2 >>> 49);
        long j4 = (j2 << 15) ^ (((jArr[8] ^ (j2 << 5)) ^ (j2 << 7)) ^ (j2 << 10));
        for (int i2 = 16; i2 >= 10; i2--) {
            long j5 = jArr[i2];
            jArr2[i2 - 8] = (((j4 ^ (j5 >>> 59)) ^ (j5 >>> 57)) ^ (j5 >>> 54)) ^ (j5 >>> 49);
            j4 = (((jArr[i2 - 9] ^ (j5 << 5)) ^ (j5 << 7)) ^ (j5 << 10)) ^ (j5 << 15);
        }
        jArr2[1] = (((j4 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
        long j6 = (j3 << 15) ^ (((jArr[0] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10));
        long j7 = jArr2[8];
        long j8 = j7 >>> 59;
        jArr2[0] = (((j6 ^ j8) ^ (j8 << 2)) ^ (j8 << 5)) ^ (j8 << 10);
        jArr2[8] = 576460752303423487L & j7;
    }

    public static void reduce5(long[] jArr, int i2) {
        int i3 = i2 + 8;
        long j = jArr[i3];
        long j2 = j >>> 59;
        jArr[i2] = ((j2 << 10) ^ (((j2 << 2) ^ j2) ^ (j2 << 5))) ^ jArr[i2];
        jArr[i3] = j & 576460752303423487L;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        long[] jArrCreate642 = g.a.g.c.m.create64();
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i2 + 1;
            long jUnshuffle = g.a.g.c.b.unshuffle(jArr[i2]);
            i2 = i4 + 1;
            long jUnshuffle2 = g.a.g.c.b.unshuffle(jArr[i4]);
            jArrCreate64[i3] = (UIDFolder.MAXUID & jUnshuffle) | (jUnshuffle2 << 32);
            jArrCreate642[i3] = (jUnshuffle >>> 32) | ((-4294967296L) & jUnshuffle2);
        }
        long jUnshuffle3 = g.a.g.c.b.unshuffle(jArr[i2]);
        jArrCreate64[4] = UIDFolder.MAXUID & jUnshuffle3;
        jArrCreate642[4] = jUnshuffle3 >>> 32;
        multiply(jArrCreate642, f14027a, jArr2);
        add(jArr2, jArrCreate64, jArr2);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        g(jArr, jArrCreateExt64);
        reduce(jArrCreateExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        g(jArr, jArrCreateExt64);
        addExt(jArr2, jArrCreateExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        g(jArr, jArrCreateExt64);
        while (true) {
            reduce(jArrCreateExt64, jArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g(jArr2, jArrCreateExt64);
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[8] >>> 49)) ^ (jArr[8] >>> 57))) & 1;
    }
}
