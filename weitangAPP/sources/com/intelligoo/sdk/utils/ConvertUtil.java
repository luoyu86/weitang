package com.intelligoo.sdk.utils;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class ConvertUtil {
    public static boolean doesArrayBeginWith(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int getIntFrom2ByteArray(byte[] bArr) {
        return getIntFromByteArray(new byte[]{0, 0, bArr[0], bArr[1]});
    }

    public static int getIntFromByte(byte b2) {
        return b2 & 255;
    }

    public static int getIntFromByteArray(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getInt();
    }

    public static long getLongFromByteArray(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getLong();
    }

    public static void invertArray(byte[] bArr) {
        int length = bArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            byte b2 = bArr[i2];
            int i3 = (length - 1) - i2;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
    }
}
