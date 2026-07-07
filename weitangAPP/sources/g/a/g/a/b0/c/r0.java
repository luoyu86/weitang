package g.a.g.a.b0.c;

import androidx.core.app.FrameMetricsAggregator;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14028a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, FrameMetricsAggregator.EVERY_DURATION};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        g.a.g.c.l.mul(iArr, iArr2, iArr3);
        int i2 = iArr[16];
        int i3 = iArr2[16];
        iArr3[32] = g.a.g.c.n.mul31BothAdd(16, i2, iArr2, i3, iArr, iArr3, 16) + (i2 * i3);
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        int iAdd = g.a.g.c.n.add(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (iAdd > 511 || (iAdd == 511 && g.a.g.c.n.eq(16, iArr3, f14028a))) {
            iAdd = (iAdd + g.a.g.c.n.inc(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = iAdd;
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        int iInc = g.a.g.c.n.inc(16, iArr, iArr2) + iArr[16];
        if (iInc > 511 || (iInc == 511 && g.a.g.c.n.eq(16, iArr2, f14028a))) {
            iInc = (iInc + g.a.g.c.n.inc(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = iInc;
    }

    public static void b(int[] iArr, int[] iArr2) {
        g.a.g.c.l.square(iArr, iArr2);
        int i2 = iArr[16];
        iArr2[32] = g.a.g.c.n.mulWordAddTo(16, i2 << 1, iArr, 0, iArr2, 16) + (i2 * i2);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.n.fromBigInteger(521, bigInteger);
        if (g.a.g.c.n.eq(17, iArrFromBigInteger, f14028a)) {
            g.a.g.c.n.zero(17, iArrFromBigInteger);
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        int i2 = iArr[16];
        iArr2[16] = (g.a.g.c.n.shiftDownBit(16, iArr, i2, iArr2) >>> 23) | (i2 >>> 1);
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f14028a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = g.a.g.c.n.create(33);
        a(iArr, iArr2, iArrCreate);
        reduce(iArrCreate, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.n.sub(17, f14028a, iArr, iArr2);
        } else {
            int[] iArr3 = f14028a;
            g.a.g.c.n.sub(17, iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[68];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 17);
            iArr[16] = iArr[16] & FrameMetricsAggregator.EVERY_DURATION;
        } while (g.a.g.c.n.lessThan(17, iArr, f14028a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int i2 = iArr[32];
        int iShiftDownBits = (g.a.g.c.n.shiftDownBits(16, iArr, 16, 9, i2, iArr2, 0) >>> 23) + (i2 >>> 9) + g.a.g.c.n.addTo(16, iArr, iArr2);
        if (iShiftDownBits > 511 || (iShiftDownBits == 511 && g.a.g.c.n.eq(16, iArr2, f14028a))) {
            iShiftDownBits = (iShiftDownBits + g.a.g.c.n.inc(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = iShiftDownBits;
    }

    public static void reduce23(int[] iArr) {
        int i2 = iArr[16];
        int iAddWordTo = g.a.g.c.n.addWordTo(16, i2 >>> 9, iArr) + (i2 & FrameMetricsAggregator.EVERY_DURATION);
        if (iAddWordTo > 511 || (iAddWordTo == 511 && g.a.g.c.n.eq(16, iArr, f14028a))) {
            iAddWordTo = (iAddWordTo + g.a.g.c.n.inc(16, iArr)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr[16] = iAddWordTo;
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreate = g.a.g.c.n.create(33);
        b(iArr, iArrCreate);
        reduce(iArrCreate, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreate = g.a.g.c.n.create(33);
        b(iArr, iArrCreate);
        while (true) {
            reduce(iArrCreate, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                b(iArr2, iArrCreate);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        int iSub = (g.a.g.c.n.sub(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (iSub < 0) {
            iSub = (iSub + g.a.g.c.n.dec(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = iSub;
    }

    public static void twice(int[] iArr, int[] iArr2) {
        int i2 = iArr[16];
        iArr2[16] = (g.a.g.c.n.shiftUpBit(16, iArr, i2 << 23, iArr2) | (i2 << 1)) & FrameMetricsAggregator.EVERY_DURATION;
    }
}
