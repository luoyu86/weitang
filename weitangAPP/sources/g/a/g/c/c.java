package g.a.g.c;

import java.util.Random;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static int a(int i2, int[] iArr, int[] iArr2) {
        int i3 = i2 - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + iArr[i5] + iArr2[i5];
            iArr[i5] = 1073741823 & i6;
            i4 = i6 >> 30;
        }
        int i7 = i4 + iArr[i3] + iArr2[i3];
        iArr[i3] = i7;
        return i7 >> 30;
    }

    public static void b(int i2, int i3, int[] iArr) {
        int i4 = i2 - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i5 + ((iArr[i6] ^ i3) - i3);
            iArr[i6] = 1073741823 & i7;
            i5 = i7 >> 30;
        }
        iArr[i4] = i5 + ((iArr[i4] ^ i3) - i3);
    }

    public static void c(int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = i2 - 1;
        int i5 = iArr[i4] >> 31;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = i6 + (((iArr[i7] + (iArr2[i7] & i5)) ^ i3) - i3);
            iArr[i7] = 1073741823 & i8;
            i6 = i8 >> 30;
        }
        iArr[i4] = i6 + (((iArr[i4] + (i5 & iArr2[i4])) ^ i3) - i3);
        int i9 = iArr[i4] >> 31;
        int i10 = 0;
        for (int i11 = 0; i11 < i4; i11++) {
            int i12 = i10 + iArr[i11] + (iArr2[i11] & i9);
            iArr[i11] = i12 & 1073741823;
            i10 = i12 >> 30;
        }
        iArr[i4] = i10 + iArr[i4] + (i9 & iArr2[i4]);
    }

    public static void checkedModOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        if (modOddInverse(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!modOddInverseVar(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void d(int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        int i5 = 0;
        long j = 0;
        while (i2 > 0) {
            while (i5 < Math.min(32, i2)) {
                j |= ((long) iArr[i3]) << i5;
                i5 += 30;
                i3++;
            }
            iArr2[i4] = (int) j;
            j >>>= 32;
            i5 -= 32;
            i2 -= 32;
            i4++;
        }
    }

    public static int e(int i2, int i3, int i4, int[] iArr) {
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        for (int i9 = 0; i9 < 30; i9++) {
            int i10 = i2 >> 31;
            int i11 = -(i4 & 1);
            int i12 = i4 + (((i3 ^ i10) - i10) & i11);
            i7 += ((i5 ^ i10) - i10) & i11;
            i8 += ((i6 ^ i10) - i10) & i11;
            int i13 = i10 & i11;
            i2 = (i2 ^ i13) - (i13 + 1);
            i3 += i12 & i13;
            i4 = i12 >> 1;
            i5 = (i5 + (i7 & i13)) << 1;
            i6 = (i6 + (i13 & i8)) << 1;
        }
        iArr[0] = i5;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i8;
        return i2;
    }

    public static int f(int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = 30;
        int i10 = 1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (true) {
            int iNumberOfTrailingZeros = g.a.j.g.numberOfTrailingZeros(((-1) << i9) | i8);
            int i14 = i8 >> iNumberOfTrailingZeros;
            i10 <<= iNumberOfTrailingZeros;
            i11 <<= iNumberOfTrailingZeros;
            i6 -= iNumberOfTrailingZeros;
            i9 -= iNumberOfTrailingZeros;
            if (i9 <= 0) {
                iArr[0] = i10;
                iArr[1] = i11;
                iArr[2] = i12;
                iArr[3] = i13;
                return i6;
            }
            if (i6 < 0) {
                i6 = -i6;
                int i15 = -i7;
                int i16 = -i10;
                int i17 = -i11;
                int i18 = i6 + 1;
                if (i18 > i9) {
                    i18 = i9;
                }
                i5 = ((-1) >>> (32 - i18)) & 63 & (i14 * i15 * ((i14 * i14) - 2));
                i14 = i15;
                i7 = i14;
                int i19 = i12;
                i12 = i16;
                i10 = i19;
                int i20 = i13;
                i13 = i17;
                i11 = i20;
            } else {
                int i21 = i6 + 1;
                if (i21 > i9) {
                    i21 = i9;
                }
                i5 = ((-1) >>> (32 - i21)) & 15 & ((-((((i7 + 1) & 4) << 1) + i7)) * i14);
            }
            i8 = i14 + (i7 * i5);
            i12 += i10 * i5;
            i13 += i5 * i11;
        }
    }

    public static void g(int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        int i5 = 0;
        long j = 0;
        while (i2 > 0) {
            if (i5 < Math.min(30, i2)) {
                j |= (((long) iArr[i3]) & UIDFolder.MAXUID) << i5;
                i5 += 32;
                i3++;
            }
            iArr2[i4] = ((int) j) & 1073741823;
            j >>>= 30;
            i5 -= 30;
            i2 -= 30;
            i4++;
        }
    }

    public static int h(int i2) {
        return ((i2 * 49) + (i2 < 46 ? 80 : 47)) / 17;
    }

    public static int i(int i2, int[] iArr) {
        int i3 = i2 - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 - iArr[i5];
            iArr[i5] = 1073741823 & i6;
            i4 = i6 >> 30;
        }
        int i7 = i4 - iArr[i3];
        iArr[i3] = i7;
        return i7 >> 30;
    }

    public static int inverse32(int i2) {
        int i3 = (2 - (i2 * i2)) * i2;
        int i4 = i3 * (2 - (i2 * i3));
        int i5 = i4 * (2 - (i2 * i4));
        return i5 * (2 - (i2 * i5));
    }

    public static void j(int i2, int[] iArr, int[] iArr2, int[] iArr3, int i3, int[] iArr4) {
        int i4 = i2;
        int i5 = iArr3[0];
        int i6 = iArr3[1];
        int i7 = iArr3[2];
        int i8 = iArr3[3];
        int i9 = i4 - 1;
        int i10 = iArr[i9] >> 31;
        int i11 = iArr2[i9] >> 31;
        int i12 = (i5 & i10) + (i6 & i11);
        int i13 = (i10 & i7) + (i11 & i8);
        int i14 = iArr4[0];
        long j = i5;
        long j2 = iArr[0];
        long j3 = i6;
        long j4 = iArr2[0];
        long j5 = (j * j2) + (j3 * j4);
        long j6 = i7;
        long j7 = i8;
        long j8 = (j2 * j6) + (j4 * j7);
        long j9 = i14;
        long j10 = i12 - (((((int) j5) * i3) + i12) & 1073741823);
        int i15 = i9;
        long j11 = i13 - (((((int) j8) * i3) + i13) & 1073741823);
        long j12 = (j8 + (j9 * j11)) >> 30;
        long j13 = (j5 + (j9 * j10)) >> 30;
        int i16 = 1;
        while (i16 < i4) {
            int i17 = iArr4[i16];
            long j14 = j12;
            long j15 = iArr[i16];
            int i18 = i16;
            long j16 = iArr2[i16];
            long j17 = j11;
            long j18 = i17;
            long j19 = j13 + (j * j15) + (j3 * j16) + (j18 * j10);
            long j20 = j14 + (j15 * j6) + (j16 * j7) + (j18 * j17);
            int i19 = i18 - 1;
            iArr[i19] = ((int) j19) & 1073741823;
            j13 = j19 >> 30;
            iArr2[i19] = ((int) j20) & 1073741823;
            j12 = j20 >> 30;
            i16 = i18 + 1;
            i4 = i2;
            i15 = i15;
            j11 = j17;
        }
        int i20 = i15;
        iArr[i20] = (int) j13;
        iArr2[i20] = (int) j12;
    }

    public static void k(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        int i3 = iArr3[0];
        int i4 = iArr3[1];
        int i5 = iArr3[2];
        int i6 = iArr3[3];
        long j = i3;
        long j2 = iArr[0];
        long j3 = i4;
        long j4 = iArr2[0];
        long j5 = i5;
        long j6 = i6;
        long j7 = ((j * j2) + (j3 * j4)) >> 30;
        long j8 = ((j2 * j5) + (j4 * j6)) >> 30;
        int i7 = 1;
        while (i7 < i2) {
            int i8 = iArr[i7];
            int i9 = iArr2[i7];
            int i10 = i7;
            long j9 = i8;
            long j10 = j * j9;
            long j11 = j;
            long j12 = i9;
            long j13 = j7 + j10 + (j3 * j12);
            long j14 = j8 + (j9 * j5) + (j12 * j6);
            int i11 = i10 - 1;
            iArr[i11] = ((int) j13) & 1073741823;
            j7 = j13 >> 30;
            iArr2[i11] = 1073741823 & ((int) j14);
            j8 = j14 >> 30;
            i7 = i10 + 1;
            j = j11;
        }
        int i12 = i2 - 1;
        iArr[i12] = (int) j7;
        iArr2[i12] = (int) j8;
    }

    public static int modOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iNumberOfLeadingZeros = (length << 5) - g.a.j.g.numberOfLeadingZeros(iArr[length - 1]);
        int i2 = (iNumberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[i2];
        int[] iArr7 = new int[i2];
        int[] iArr8 = new int[i2];
        int[] iArr9 = new int[i2];
        char c2 = 0;
        iArr6[0] = 1;
        g(iNumberOfLeadingZeros, iArr2, 0, iArr8, 0);
        g(iNumberOfLeadingZeros, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i2);
        int iInverse32 = inverse32(iArr9[0]);
        int iH = h(iNumberOfLeadingZeros);
        int i3 = -1;
        int i4 = 0;
        while (i4 < iH) {
            int iE = e(i3, iArr7[c2], iArr8[c2], iArr4);
            j(i2, iArr5, iArr6, iArr4, iInverse32, iArr9);
            k(i2, iArr7, iArr8, iArr4);
            i4 += 30;
            i3 = iE;
            iH = iH;
            c2 = 0;
        }
        int i5 = iArr7[i2 - 1] >> 31;
        b(i2, i5, iArr7);
        c(i2, i5, iArr5, iArr9);
        d(iNumberOfLeadingZeros, iArr5, 0, iArr3, 0);
        return n.equalTo(i2, iArr7, 1) & n.equalToZero(i2, iArr8);
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iNumberOfLeadingZeros = (length << 5) - g.a.j.g.numberOfLeadingZeros(iArr[length - 1]);
        int i2 = (iNumberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[i2];
        int[] iArr7 = new int[i2];
        int[] iArr8 = new int[i2];
        int[] iArr9 = new int[i2];
        ?? r9 = 0;
        iArr6[0] = 1;
        g(iNumberOfLeadingZeros, iArr2, 0, iArr8, 0);
        g(iNumberOfLeadingZeros, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i2);
        int i3 = i2 - 1;
        int iNumberOfLeadingZeros2 = (-1) - (g.a.j.g.numberOfLeadingZeros(iArr8[i3] | 1) - (((i2 * 30) + 2) - iNumberOfLeadingZeros));
        int iInverse32 = inverse32(iArr9[0]);
        int iH = h(iNumberOfLeadingZeros);
        int i4 = i2;
        int i5 = 0;
        while (!n.isZero(i4, iArr8)) {
            if (i5 >= iH) {
                return r9;
            }
            int i6 = i5 + 30;
            int iF = f(iNumberOfLeadingZeros2, iArr7[r9], iArr8[r9], iArr4);
            int i7 = i4;
            int i8 = iH;
            int[] iArr10 = iArr6;
            j(i2, iArr5, iArr6, iArr4, iInverse32, iArr9);
            k(i7, iArr7, iArr8, iArr4);
            int i9 = i7 - 1;
            int i10 = iArr7[i9];
            int i11 = iArr8[i9];
            int i12 = i7 - 2;
            if (((i12 >> 31) | ((i10 >> 31) ^ i10) | ((i11 >> 31) ^ i11)) == 0) {
                iArr7[i12] = (i10 << 30) | iArr7[i12];
                iArr8[i12] = iArr8[i12] | (i11 << 30);
                i4 = i7 - 1;
            } else {
                i4 = i7;
            }
            i5 = i6;
            iNumberOfLeadingZeros2 = iF;
            iH = i8;
            iArr6 = iArr10;
            r9 = 0;
        }
        int i13 = i4;
        int i14 = iArr7[i13 - 1] >> 31;
        int i15 = iArr5[i3] >> 31;
        if (i15 < 0) {
            i15 = a(i2, iArr5, iArr9);
        }
        if (i14 < 0) {
            i15 = i(i2, iArr5);
            i(i13, iArr7);
        }
        if (!n.isOne(i13, iArr7)) {
            return false;
        }
        if (i15 < 0) {
            a(i2, iArr5, iArr9);
        }
        d(iNumberOfLeadingZeros, iArr5, 0, iArr3, 0);
        return true;
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] iArrCreate = n.create(length);
        int i2 = length - 1;
        int i3 = iArr[i2];
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        do {
            for (int i9 = 0; i9 != length; i9++) {
                iArrCreate[i9] = random.nextInt();
            }
            iArrCreate[i2] = iArrCreate[i2] & i8;
        } while (n.gte(length, iArrCreate, iArr));
        return iArrCreate;
    }
}
