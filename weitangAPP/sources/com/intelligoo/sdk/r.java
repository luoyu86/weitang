package com.intelligoo.sdk;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static byte a(char c2) {
        return (byte) "0123456789ABCDEF".indexOf(c2);
    }

    public static void a(byte[] bArr, int i2) {
        l.a(bArr != null);
        for (int i3 = 0; i3 < i2 / 4; i3++) {
            for (int i4 = 0; i4 < 2; i4++) {
                int i5 = i3 * 4;
                int i6 = i5 + i4;
                byte b2 = bArr[i6];
                int i7 = ((i5 + 4) - i4) - 1;
                bArr[i6] = bArr[i7];
                bArr[i7] = b2;
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static byte[] a(String str) {
        l.a(str != null);
        char[] charArray = str.toUpperCase().toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (a(charArray[i3 + 1]) | (a(charArray[i3]) << 4));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : a(a(a(bArr, false), a(bArr2, false)), false);
    }

    public static byte[] a(int[] iArr, boolean z) {
        l.a(iArr != null);
        int length = iArr.length << 2;
        if (z) {
            int i2 = iArr[iArr.length - 1];
            if (i2 > length) {
                return null;
            }
            length = i2;
        }
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) ((iArr[i3 >>> 2] >>> ((i3 & 3) << 3)) & 255);
        }
        return bArr;
    }

    public static int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        l.a(bArr != null);
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : 1 + (bArr.length >>> 2);
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = i2 >>> 2;
            iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << ((i2 & 3) << 3));
        }
        return iArr;
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        l.a(iArr != null);
        int length = iArr.length;
        int i2 = (52 / length) + 6;
        int i3 = length - 1;
        int i4 = iArr[i3];
        int i5 = 0;
        do {
            i5 -= 1640531527;
            int i6 = (i5 >>> 2) & 3;
            int i7 = 0;
            while (i7 < i3) {
                int i8 = i7 + 1;
                int i9 = iArr[i8];
                i4 = ((((i4 >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i4 << 4))) ^ ((i9 ^ i5) + (i4 ^ iArr2[(i7 & 3) ^ i6]))) + iArr[i7];
                iArr[i7] = i4;
                i7 = i8;
            }
            int i10 = iArr[0];
            i4 = ((((i4 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i4 << 4))) ^ ((i10 ^ i5) + (i4 ^ iArr2[i6 ^ (i7 & 3)]))) + iArr[i3];
            iArr[i3] = i4;
            i2--;
        } while (i2 > 0);
        return iArr;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : a(b(a(bArr, false), a(bArr2, false)), false);
    }

    public static int[] b(int[] iArr, int[] iArr2) {
        l.a(iArr != null);
        int length = iArr.length;
        int i2 = length - 1;
        int i3 = iArr[i2];
        int i4 = iArr[0];
        int i5 = ((52 / length) + 6) * (-1640531527);
        int i6 = iArr[0];
        do {
            int i7 = (i5 >>> 2) & 3;
            int i8 = i2;
            while (i8 > 0) {
                int i9 = iArr[i8 - 1];
                i6 = iArr[i8] - (((i6 ^ i5) + (i9 ^ iArr2[(i8 & 3) ^ i7])) ^ (((i9 >>> 5) ^ (i6 << 2)) + ((i6 >>> 3) ^ (i9 << 4))));
                iArr[i8] = i6;
                i8--;
            }
            int i10 = iArr[i2];
            i6 = iArr[0] - (((i6 ^ i5) + (iArr2[i7 ^ (i8 & 3)] ^ i10)) ^ (((i10 >>> 5) ^ (i6 << 2)) + ((i6 >>> 3) ^ (i10 << 4))));
            iArr[0] = i6;
            i5 -= -1640531527;
        } while (i5 != 0);
        return iArr;
    }
}
