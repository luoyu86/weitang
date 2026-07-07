package com.tom_roush.pdfbox.util;

/* JADX INFO: loaded from: classes2.dex */
public class NumberFormatUtil {
    private static final int MAX_FRACTION_DIGITS = 5;
    private static final long[] POWER_OF_TENS;
    private static final int[] POWER_OF_TENS_INT;

    static {
        long[] jArr = new long[19];
        POWER_OF_TENS = jArr;
        jArr[0] = 1;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            long[] jArr2 = POWER_OF_TENS;
            if (i3 >= jArr2.length) {
                break;
            }
            jArr2[i3] = jArr2[i3 - 1] * 10;
            i3++;
        }
        int[] iArr = new int[10];
        POWER_OF_TENS_INT = iArr;
        iArr[0] = 1;
        while (true) {
            int[] iArr2 = POWER_OF_TENS_INT;
            if (i2 >= iArr2.length) {
                return;
            }
            iArr2[i2] = iArr2[i2 - 1] * 10;
            i2++;
        }
    }

    private NumberFormatUtil() {
    }

    public static int formatFloatFast(float f2, int i2, byte[] bArr) {
        int i3;
        if (Float.isNaN(f2) || Float.isInfinite(f2) || f2 > 9.223372E18f || f2 <= -9.223372E18f || i2 > 5) {
            return -1;
        }
        long j = (long) f2;
        if (f2 < 0.0f) {
            bArr[0] = 45;
            j = -j;
            i3 = 1;
        } else {
            i3 = 0;
        }
        double dAbs = Math.abs(f2) - j;
        long[] jArr = POWER_OF_TENS;
        long j2 = (long) ((dAbs * jArr[i2]) + 0.5d);
        if (j2 >= jArr[i2]) {
            j++;
            j2 -= jArr[i2];
        }
        long j3 = j;
        long j4 = j2;
        int positiveNumber = formatPositiveNumber(j3, getExponent(j3), false, bArr, i3);
        if (j4 <= 0 || i2 <= 0) {
            return positiveNumber;
        }
        bArr[positiveNumber] = 46;
        return formatPositiveNumber(j4, i2 - 1, true, bArr, positiveNumber + 1);
    }

    private static int formatPositiveNumber(long j, int i2, boolean z, byte[] bArr, int i3) {
        while (j > 2147483647L && (!z || j > 0)) {
            long[] jArr = POWER_OF_TENS;
            j -= jArr[i2] * (j / jArr[i2]);
            bArr[i3] = (byte) (r1 + 48);
            i2--;
            i3++;
        }
        int i4 = (int) j;
        while (i2 >= 0 && (!z || i4 > 0)) {
            int[] iArr = POWER_OF_TENS_INT;
            int i5 = i4 / iArr[i2];
            i4 -= iArr[i2] * i5;
            bArr[i3] = (byte) (i5 + 48);
            i2--;
            i3++;
        }
        return i3;
    }

    private static int getExponent(long j) {
        int i2 = 0;
        while (true) {
            long[] jArr = POWER_OF_TENS;
            if (i2 >= jArr.length - 1) {
                return jArr.length - 1;
            }
            int i3 = i2 + 1;
            if (j < jArr[i3]) {
                return i2;
            }
            i2 = i3;
        }
    }
}
