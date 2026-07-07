package cn.com.heaton.blelibrary.ble.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteUtils {
    public static String BinaryToHexString(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            str = str + (String.valueOf("0123456789ABCDEF".charAt((b2 & 240) >> 4)) + String.valueOf("0123456789ABCDEF".charAt(b2 & 15))) + " ";
        }
        return str;
    }

    public static int byte2int(byte[] bArr) {
        return (bArr[3] << 24) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 24) >>> 8);
    }

    public static String byteArrayToHexStr(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            cArr[i4] = charArray[i3 >>> 4];
            cArr[i4 + 1] = charArray[i3 & 15];
        }
        return new String(cArr);
    }

    public static short bytes2Short2(byte[] bArr) {
        return (short) ((bArr[0] & 255) | ((bArr[1] & 255) << 8));
    }

    public static byte[] hexStrToByteArray(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static byte[] int2byte(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) (i2 >>> 24)};
    }

    public static byte[] short2Bytes(short s) {
        return new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)};
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (-1 == i2) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
