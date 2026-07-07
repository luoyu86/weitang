package cn.com.heaton.blelibrary.ble.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class TlvWrap {
    public static final int TAGLENGTH_LENGTH = 4;

    private static int byte2int(byte b2) {
        return b2 & 255;
    }

    public static int getLength(byte[] bArr, int i2) {
        if (bArr == null || bArr.length < i2 + 4) {
            return 0;
        }
        return (byte2int(bArr[i2 + 2]) * 256) + byte2int(bArr[i2 + 3]);
    }

    public static int getTag(byte[] bArr, int i2) {
        if (bArr == null || bArr.length < i2 + 2) {
            return 0;
        }
        return (byte2int(bArr[i2]) * 256) + byte2int(bArr[i2 + 1]);
    }

    public static byte[] getValue(byte[] bArr, int i2) {
        int length = getLength(bArr, i2);
        if (length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2 + 4, bArr2, 0, length);
        return bArr2;
    }

    public static Date parseTime(int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(((long) i2) * 1000);
        return calendar.getTime();
    }

    public static int readInt(byte[] bArr, int i2, int i3, int i4) {
        Integer inteter = readInteter(bArr, i2, i3);
        return inteter != null ? inteter.intValue() : i4;
    }

    public static Integer readInteter(byte[] bArr, int i2, int i3) {
        byte[] tag = readTag(bArr, i2, i3);
        if (tag == null) {
            return null;
        }
        return Integer.valueOf(readint(tag));
    }

    public static String readString(byte[] bArr, int i2, int i3, String str) {
        byte[] tag = readTag(bArr, i2, i3);
        return tag == null ? str : new String(tag);
    }

    public static byte[] readTag(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        while (i3 < bArr.length) {
            if (getTag(bArr, i3) == i2) {
                return getValue(bArr, i3);
            }
            i3 = i3 + 4 + getLength(bArr, i3);
        }
        return null;
    }

    public static Date readTime(byte[] bArr, int i2, int i3) {
        int i4 = readInt(bArr, i2, i3);
        return (i4 == Integer.MIN_VALUE || i4 < 31536000) ? new Date() : parseTime(i4);
    }

    public static int readint(byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length && (i4 = i2 + i6) < i3; i6++) {
            i5 = (i5 * 256) + (bArr[i4] & 255);
        }
        return i5;
    }

    public static byte[][] splitTag(byte[] bArr, int i2) {
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < bArr.length) {
            int length = getLength(bArr, i2);
            int i3 = length + 4;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            arrayList.add(bArr2);
            i2 = i2 + 4 + length;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static void writeByteArrayValue(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr2, 0, bArr, 4, bArr2.length);
    }

    public static void writeInt(byte[] bArr, int i2, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            bArr[i2 + i5] = (byte) (i3 % 256);
            i3 /= 256;
        }
    }

    public static void writeIntValue(byte[] bArr, int i2, int i3) {
        writeInt(bArr, 4, i2, i3);
    }

    public static void writeLength(byte[] bArr, int i2) {
        writeInt(bArr, 2, i2, 2);
    }

    public static void writeTag(byte[] bArr, int i2) {
        writeInt(bArr, 0, i2, 2);
    }

    public static int readInt(byte[] bArr, int i2, int i3) {
        byte[] tag = readTag(bArr, i2, i3);
        if (tag == null) {
            return Integer.MIN_VALUE;
        }
        return readint(tag);
    }

    public static String readString(byte[] bArr, int i2, int i3) {
        byte[] tag = readTag(bArr, i2, i3);
        return tag == null ? "" : new String(tag);
    }

    public static int readint(byte[] bArr) {
        return readint(bArr, 0, bArr.length);
    }
}
