package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13945a = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13946b = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13947c = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && g.a.g.c.h.gte(iArr3, f13945a))) {
            g.a.g.c.n.add33To(8, 977, iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(16, iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && g.a.g.c.n.gte(16, iArr3, f13946b))) {
            int[] iArr4 = f13947c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(16, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && g.a.g.c.h.gte(iArr2, f13945a))) {
            g.a.g.c.n.add33To(8, 977, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.h.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[7] == -1) {
            int[] iArr = f13945a;
            if (g.a.g.c.h.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.h.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(8, iArr2, g.a.g.c.h.add(iArr, f13945a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13945a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        g.a.g.c.h.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && g.a.g.c.n.gte(16, iArr3, f13946b))) {
            int[] iArr4 = f13947c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(16, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.h.sub(f13945a, iArr, iArr2);
        } else {
            int[] iArr3 = f13945a;
            g.a.g.c.h.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 8);
        } while (g.a.g.c.n.lessThan(8, iArr, f13945a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        if (g.a.g.c.h.mul33DWordAdd(977, g.a.g.c.h.mul33Add(977, iArr, 8, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[7] == -1 && g.a.g.c.h.gte(iArr2, f13945a))) {
            g.a.g.c.n.add33To(8, 977, iArr2);
        }
    }

    public static void reduce32(int i2, int[] iArr) {
        if ((i2 == 0 || g.a.g.c.h.mul33WordAdd(977, i2, iArr, 0) == 0) && !(iArr[7] == -1 && g.a.g.c.h.gte(iArr, f13945a))) {
            return;
        }
        g.a.g.c.n.add33To(8, 977, iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        g.a.g.c.h.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        g.a.g.c.h.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.h.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.h.sub(iArr, iArr2, iArr3) != 0) {
            g.a.g.c.n.sub33From(8, 977, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(16, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f13947c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(16, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && g.a.g.c.h.gte(iArr2, f13945a))) {
            g.a.g.c.n.add33To(8, 977, iArr2);
        }
    }
}
