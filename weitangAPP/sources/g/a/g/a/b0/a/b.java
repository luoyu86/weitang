package g.a.g.a.b0.a;

import androidx.appcompat.widget.ActivityChooserView;
import g.a.g.c.h;
import g.a.g.c.n;
import g.a.j.k;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13893a = {-19, -1, -1, -1, -1, -1, -1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13894b = {361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

    public static int a(int[] iArr) {
        long j = ((long) iArr[0]) & UIDFolder.MAXUID;
        int[] iArr2 = f13894b;
        long j2 = j + (((long) iArr2[0]) & UIDFolder.MAXUID);
        iArr[0] = (int) j2;
        long jIncAt = j2 >> 32;
        if (jIncAt != 0) {
            jIncAt = n.incAt(8, iArr, 1);
        }
        long j3 = jIncAt + ((((long) iArr[8]) & UIDFolder.MAXUID) - 19);
        iArr[8] = (int) j3;
        long jDecAt = j3 >> 32;
        if (jDecAt != 0) {
            jDecAt = n.decAt(15, iArr, 9);
        }
        long j4 = jDecAt + (((long) iArr[15]) & UIDFolder.MAXUID) + (UIDFolder.MAXUID & ((long) (iArr2[15] + 1)));
        iArr[15] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        h.add(iArr, iArr2, iArr3);
        if (h.gte(iArr3, f13893a)) {
            d(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        n.add(16, iArr, iArr2, iArr3);
        if (n.gte(16, iArr3, f13894b)) {
            c(iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        n.inc(8, iArr, iArr2);
        if (h.gte(iArr2, f13893a)) {
            d(iArr2);
        }
    }

    public static int b(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) - 19;
        iArr[0] = (int) j;
        long jDecAt = j >> 32;
        if (jDecAt != 0) {
            jDecAt = n.decAt(7, iArr, 1);
        }
        long j2 = jDecAt + (UIDFolder.MAXUID & ((long) iArr[7])) + 2147483648L;
        iArr[7] = (int) j2;
        return (int) (j2 >> 32);
    }

    public static int c(int[] iArr) {
        long j = ((long) iArr[0]) & UIDFolder.MAXUID;
        int[] iArr2 = f13894b;
        long j2 = j - (((long) iArr2[0]) & UIDFolder.MAXUID);
        iArr[0] = (int) j2;
        long jDecAt = j2 >> 32;
        if (jDecAt != 0) {
            jDecAt = n.decAt(8, iArr, 1);
        }
        long j3 = jDecAt + (((long) iArr[8]) & UIDFolder.MAXUID) + 19;
        iArr[8] = (int) j3;
        long jIncAt = j3 >> 32;
        if (jIncAt != 0) {
            jIncAt = n.incAt(15, iArr, 9);
        }
        long j4 = jIncAt + ((((long) iArr[15]) & UIDFolder.MAXUID) - (UIDFolder.MAXUID & ((long) (iArr2[15] + 1))));
        iArr[15] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int d(int[] iArr) {
        long j = (((long) iArr[0]) & UIDFolder.MAXUID) + 19;
        iArr[0] = (int) j;
        long jIncAt = j >> 32;
        if (jIncAt != 0) {
            jIncAt = n.incAt(7, iArr, 1);
        }
        long j2 = jIncAt + ((UIDFolder.MAXUID & ((long) iArr[7])) - 2147483648L);
        iArr[7] = (int) j2;
        return (int) (j2 >> 32);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = h.fromBigInteger(bigInteger);
        while (true) {
            int[] iArr = f13893a;
            if (!h.gte(iArrFromBigInteger, iArr)) {
                return iArrFromBigInteger;
            }
            h.subFrom(iArr, iArrFromBigInteger);
        }
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            n.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            h.add(iArr, f13893a, iArr2);
            n.shiftDownBit(8, iArr2, 0);
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        g.a.g.c.c.checkedModOddInverse(f13893a, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = h.createExt();
        h.mul(iArr, iArr2, iArrCreateExt);
        reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        h.mulAddTo(iArr, iArr2, iArr3);
        if (n.gte(16, iArr3, f13894b)) {
            c(iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) == 0) {
            h.sub(f13893a, iArr, iArr2);
        } else {
            int[] iArr3 = f13893a;
            h.sub(iArr3, iArr3, iArr2);
        }
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            k.littleEndianToInt(bArr, 0, iArr, 0, 8);
            iArr[7] = iArr[7] & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        } while (n.lessThan(8, iArr, f13893a) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int i2 = iArr[7];
        n.shiftUpBit(8, iArr, 8, i2, iArr2, 0);
        int iMulByWordAddTo = h.mulByWordAddTo(19, iArr, iArr2) << 1;
        int i3 = iArr2[7];
        iArr2[7] = (i3 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + n.addWordTo(7, (iMulByWordAddTo + ((i3 >>> 31) - (i2 >>> 31))) * 19, iArr2);
        if (h.gte(iArr2, f13893a)) {
            d(iArr2);
        }
    }

    public static void reduce27(int i2, int[] iArr) {
        int i3 = iArr[7];
        iArr[7] = (i3 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + n.addWordTo(7, ((i2 << 1) | (i3 >>> 31)) * 19, iArr);
        if (h.gte(iArr, f13893a)) {
            d(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = h.createExt();
        h.square(iArr, iArrCreateExt);
        reduce(iArrCreateExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] iArrCreateExt = h.createExt();
        h.square(iArr, iArrCreateExt);
        while (true) {
            reduce(iArrCreateExt, iArr2);
            i2--;
            if (i2 <= 0) {
                return;
            } else {
                h.square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h.sub(iArr, iArr2, iArr3) != 0) {
            b(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (n.sub(16, iArr, iArr2, iArr3) != 0) {
            a(iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        n.shiftUpBit(8, iArr, 0, iArr2);
        if (h.gte(iArr2, f13893a)) {
            d(iArr2);
        }
    }
}
