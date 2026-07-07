package com.tom_roush.fontbox.cff;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class Type1FontUtil {
    private Type1FontUtil() {
    }

    public static byte[] charstringDecrypt(byte[] bArr, int i2) {
        return decrypt(bArr, 4330, i2);
    }

    public static byte[] charstringEncrypt(byte[] bArr, int i2) {
        return encrypt(bArr, 4330, i2);
    }

    private static byte[] decrypt(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & 255;
            bArr2[i4] = (byte) ((i2 >> 8) ^ i5);
            i2 = 65535 & (((i5 + i2) * 52845) + 22719);
        }
        int length = bArr.length - i3;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, i3, bArr3, 0, length);
        return bArr3;
    }

    public static byte[] eexecDecrypt(byte[] bArr) {
        return decrypt(bArr, 55665, 4);
    }

    public static byte[] eexecEncrypt(byte[] bArr) {
        return encrypt(bArr, 55665, 4);
    }

    private static byte[] encrypt(byte[] bArr, int i2, int i3) {
        int length = bArr.length + i3;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, i3, length - i3);
        byte[] bArr3 = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = (bArr2[i4] & 255) ^ (i2 >> 8);
            bArr3[i4] = (byte) i5;
            i2 = 65535 & (((i5 + i2) * 52845) + 22719);
        }
        return bArr3;
    }

    public static byte[] hexDecode(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
            i2 = i3;
        }
        return bArr;
    }

    public static String hexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString.toUpperCase(Locale.US));
        }
        return sb.toString();
    }
}
