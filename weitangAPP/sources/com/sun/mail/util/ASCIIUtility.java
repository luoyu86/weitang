package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ASCIIUtility {
    private ASCIIUtility() {
    }

    public static byte[] getBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) charArray[i2];
        }
        return bArr;
    }

    public static int parseInt(byte[] bArr, int i2, int i3, int i4) throws NumberFormatException {
        int i5;
        int i6;
        boolean z;
        if (bArr == null) {
            throw new NumberFormatException("null");
        }
        if (i3 <= i2) {
            throw new NumberFormatException("illegal number");
        }
        int i7 = 0;
        if (bArr[i2] == 45) {
            i5 = Integer.MIN_VALUE;
            i6 = i2 + 1;
            z = true;
        } else {
            i5 = -2147483647;
            i6 = i2;
            z = false;
        }
        int i8 = i5 / i4;
        if (i6 < i3) {
            int i9 = i6 + 1;
            int iDigit = Character.digit((char) bArr[i6], i4);
            if (iDigit < 0) {
                throw new NumberFormatException("illegal number: " + toString(bArr, i2, i3));
            }
            i7 = -iDigit;
            i6 = i9;
        }
        while (i6 < i3) {
            int i10 = i6 + 1;
            int iDigit2 = Character.digit((char) bArr[i6], i4);
            if (iDigit2 < 0) {
                throw new NumberFormatException("illegal number");
            }
            if (i7 < i8) {
                throw new NumberFormatException("illegal number");
            }
            int i11 = i7 * i4;
            if (i11 < i5 + iDigit2) {
                throw new NumberFormatException("illegal number");
            }
            i7 = i11 - iDigit2;
            i6 = i10;
        }
        if (!z) {
            return -i7;
        }
        if (i6 > i2 + 1) {
            return i7;
        }
        throw new NumberFormatException("illegal number");
    }

    public static long parseLong(byte[] bArr, int i2, int i3, int i4) throws NumberFormatException {
        int i5;
        long j;
        boolean z;
        int i6 = i3;
        int i7 = i4;
        if (bArr == null) {
            throw new NumberFormatException("null");
        }
        long j2 = 0;
        if (i6 <= i2) {
            throw new NumberFormatException("illegal number");
        }
        if (bArr[i2] == 45) {
            i5 = i2 + 1;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            i5 = i2;
            j = -9223372036854775807L;
            z = false;
        }
        long j3 = i7;
        long j4 = j / j3;
        if (i5 < i6) {
            int i8 = i5 + 1;
            int iDigit = Character.digit((char) bArr[i5], i7);
            if (iDigit < 0) {
                throw new NumberFormatException("illegal number: " + toString(bArr, i2, i3));
            }
            i5 = i8;
            j2 = -iDigit;
        }
        while (i5 < i6) {
            int i9 = i5 + 1;
            int iDigit2 = Character.digit((char) bArr[i5], i7);
            if (iDigit2 < 0) {
                throw new NumberFormatException("illegal number");
            }
            if (j2 < j4) {
                throw new NumberFormatException("illegal number");
            }
            long j5 = j2 * j3;
            long j6 = iDigit2;
            if (j5 < j + j6) {
                throw new NumberFormatException("illegal number");
            }
            j2 = j5 - j6;
            i6 = i3;
            i7 = i4;
            i5 = i9;
        }
        if (!z) {
            return -j2;
        }
        if (i5 > i2 + 1) {
            return j2;
        }
        throw new NumberFormatException("illegal number");
    }

    public static String toString(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i5 < i4) {
            cArr[i5] = (char) (bArr[i2] & 255);
            i5++;
            i2++;
        }
        return new String(cArr);
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, 0, bArr.length);
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            int iAvailable = inputStream.available();
            byte[] bArr = new byte[iAvailable];
            inputStream.read(bArr, 0, iAvailable);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr2, 0, 1024);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr2, 0, i2);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int iAvailable = byteArrayInputStream.available();
        char[] cArr = new char[iAvailable];
        byte[] bArr = new byte[iAvailable];
        byteArrayInputStream.read(bArr, 0, iAvailable);
        for (int i2 = 0; i2 < iAvailable; i2++) {
            cArr[i2] = (char) (bArr[i2] & 255);
        }
        return new String(cArr);
    }

    public static int parseInt(byte[] bArr, int i2, int i3) throws NumberFormatException {
        return parseInt(bArr, i2, i3, 10);
    }

    public static long parseLong(byte[] bArr, int i2, int i3) throws NumberFormatException {
        return parseLong(bArr, i2, i3, 10);
    }
}
