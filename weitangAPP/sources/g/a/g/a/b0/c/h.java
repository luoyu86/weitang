package g.a.g.a.b0.c;

import androidx.appcompat.widget.ActivityChooserView;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13959a = {ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13960b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13961c = {-1, -1073741826, -1, -1, -1, 1, 1};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.e.add(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && g.a.g.c.e.gte(iArr3, f13959a))) {
            g.a.g.c.n.addWordTo(5, -2147483647, iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.add(10, iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && g.a.g.c.n.gte(10, iArr3, f13960b))) {
            int[] iArr4 = f13961c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(10, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.inc(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && g.a.g.c.e.gte(iArr2, f13959a))) {
            g.a.g.c.n.addWordTo(5, -2147483647, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = g.a.g.c.e.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[4] == -1) {
            int[] iArr = f13959a;
            if (g.a.g.c.e.gte(iArrFromBigInteger, iArr)) {
                g.a.g.c.e.subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            g.a.g.c.n.shiftDownBit(5, iArr, 0, iArr2);
        } else {
            g.a.g.c.n.shiftDownBit(5, iArr2, g.a.g.c.e.add(iArr, f13959a, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13959a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = g.a.g.c.e.createExt();
        g.a.g.c.e.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.e.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && g.a.g.c.n.gte(10, iArr3, f13960b))) {
            int[] iArr4 = f13961c;
            if (g.a.g.c.n.addTo(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.incAt(10, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            g.a.g.c.e.sub(f13959a, iArr, iArr2);
        } else {
            int[] iArr3 = f13959a;
            g.a.g.c.e.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[20];
        do {
            secureRandom.nextBytes(bArr);
            g.a.j.k.littleEndianToInt(bArr, 0, iArr, 0, 5);
        } while (g.a.g.c.n.lessThan(5, iArr, f13959a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[5]) & UIDFolder.MAXUID;
        long j2 = ((long) iArr[6]) & UIDFolder.MAXUID;
        long j3 = ((long) iArr[7]) & UIDFolder.MAXUID;
        long j4 = ((long) iArr[8]) & UIDFolder.MAXUID;
        long j5 = ((long) iArr[9]) & UIDFolder.MAXUID;
        long j6 = (((long) iArr[0]) & UIDFolder.MAXUID) + j + (j << 31) + 0;
        iArr2[0] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[1]) & UIDFolder.MAXUID) + j2 + (j2 << 31);
        iArr2[1] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[2]) & UIDFolder.MAXUID) + j3 + (j3 << 31);
        iArr2[2] = (int) j8;
        long j9 = (j8 >>> 32) + (((long) iArr[3]) & UIDFolder.MAXUID) + j4 + (j4 << 31);
        iArr2[3] = (int) j9;
        long j10 = (j9 >>> 32) + (UIDFolder.MAXUID & ((long) iArr[4])) + j5 + (j5 << 31);
        iArr2[4] = (int) j10;
        reduce32((int) (j10 >>> 32), iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        if ((i2 == 0 || g.a.g.c.e.mulWordsAdd(-2147483647, i2, iArr, 0) == 0) && !(iArr[4] == -1 && g.a.g.c.e.gte(iArr, f13959a))) {
            return;
        }
        g.a.g.c.n.addWordTo(5, -2147483647, iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.e.createExt();
        g.a.g.c.e.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = g.a.g.c.e.createExt();
        g.a.g.c.e.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                g.a.g.c.e.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.e.sub(iArr, iArr2, iArr3) != 0) {
            g.a.g.c.n.subWordFrom(5, -2147483647, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g.a.g.c.n.sub(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f13961c;
            if (g.a.g.c.n.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                g.a.g.c.n.decAt(10, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (g.a.g.c.n.shiftUpBit(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && g.a.g.c.e.gte(iArr2, f13959a))) {
            g.a.g.c.n.addWordTo(5, -2147483647, iArr2);
        }
    }
}
