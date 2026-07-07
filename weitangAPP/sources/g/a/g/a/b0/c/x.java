package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14062a = {-6803, -2, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f14063b = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f14064c = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.g.add(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && g.a.g.c.g.gte(iArr3, f14062a))) {
            g.a.g.c.n.add33To(7, 6803, iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && g.a.g.c.n.gte(14, iArr3, f14063b))) {
            int[] iArr4 = f14064c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && g.a.g.c.g.gte(iArr2, f14062a))) {
            g.a.g.c.n.add33To(7, 6803, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.g.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[6] == -1 && g.a.g.c.g.gte(iArrFromBigInteger, f14062a)) {
            g.a.g.c.n.add33To(7, 6803, iArrFromBigInteger);
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(7, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(7, iArr2, g.a.g.c.g.add(iArr, f14062a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f14062a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 7; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        g.a.g.c.g.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.g.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && g.a.g.c.n.gte(14, iArr3, f14063b))) {
            int[] iArr4 = f14064c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.g.sub(f14062a, iArr, iArr2);
        } else {
            int[] iArr3 = f14062a;
            g.a.g.c.g.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[28];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 7);
        } while (g.a.g.c.n.lessThan(7, iArr, f14062a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        if (g.a.g.c.g.mul33DWordAdd(6803, g.a.g.c.g.mul33Add(6803, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && g.a.g.c.g.gte(iArr2, f14062a))) {
            g.a.g.c.n.add33To(7, 6803, iArr2);
        }
    }

    public static void reduce32(int i2, int[] iArr) {
        if ((i2 == 0 || g.a.g.c.g.mul33WordAdd(6803, i2, iArr, 0) == 0) && !(iArr[6] == -1 && g.a.g.c.g.gte(iArr, f14062a))) {
            return;
        }
        g.a.g.c.n.add33To(7, 6803, iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        g.a.g.c.g.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        g.a.g.c.g.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.g.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.g.sub(iArr, iArr2, iArr3) != 0) {
            g.a.g.c.n.sub33From(7, 6803, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f14064c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && g.a.g.c.g.gte(iArr2, f14062a))) {
            g.a.g.c.n.add33To(7, 6803, iArr2);
        }
    }
}
