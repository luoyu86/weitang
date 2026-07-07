package g.a.g.a.b0.c;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f14014a = {-4553, -2, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f14015b = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f14016c = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.f.add(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && g.a.g.c.f.gte(iArr3, f14014a))) {
            g.a.g.c.n.add33To(6, 4553, iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && g.a.g.c.n.gte(12, iArr3, f14015b))) {
            int[] iArr4 = f14016c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && g.a.g.c.f.gte(iArr2, f14014a))) {
            g.a.g.c.n.add33To(6, 4553, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.f.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[5] == -1) {
            int[] iArr = f14014a;
            if (g.a.g.c.f.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.f.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(6, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(6, iArr2, g.a.g.c.f.add(iArr, f14014a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f14014a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        g.a.g.c.f.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.f.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && g.a.g.c.n.gte(12, iArr3, f14015b))) {
            int[] iArr4 = f14016c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.f.sub(f14014a, iArr, iArr2);
        } else {
            int[] iArr3 = f14014a;
            g.a.g.c.f.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[24];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 6);
        } while (g.a.g.c.n.lessThan(6, iArr, f14014a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        if (g.a.g.c.f.mul33DWordAdd(4553, g.a.g.c.f.mul33Add(4553, iArr, 6, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[5] == -1 && g.a.g.c.f.gte(iArr2, f14014a))) {
            g.a.g.c.n.add33To(6, 4553, iArr2);
        }
    }

    public static void reduce32(int i2, int[] iArr) {
        if ((i2 == 0 || g.a.g.c.f.mul33WordAdd(4553, i2, iArr, 0) == 0) && !(iArr[5] == -1 && g.a.g.c.f.gte(iArr, f14014a))) {
            return;
        }
        g.a.g.c.n.add33To(6, 4553, iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        g.a.g.c.f.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        g.a.g.c.f.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.f.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.f.sub(iArr, iArr2, iArr3) != 0) {
            g.a.g.c.n.sub33From(6, 4553, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(12, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f14016c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && g.a.g.c.f.gte(iArr2, f14014a))) {
            g.a.g.c.n.add33To(6, 4553, iArr2);
        }
    }
}
