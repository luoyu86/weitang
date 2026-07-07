package com.intelligoo.sdk;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9220a = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f9225f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f9226g = 171;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f9227h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f9228i = 4;
    private static int j = 3;
    private static int k = 255;
    private static byte[] l = {-1};
    private static final int[] m = {-1992689996, 908635233, -730654905, 1491504540};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9221b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f9222c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static byte[] f9223d = new byte[256];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f9224e = 0;

    public static void a() {
        f9224e = 0;
        f9222c = 0;
    }

    public static byte[] a(int i2, int i3, byte[] bArr) {
        if (bArr == null) {
            l.b("data is null");
            return null;
        }
        int length = bArr.length;
        int i4 = j;
        int i5 = 4 - ((length + i4) % 4);
        int length2 = i4 + bArr.length + i5;
        if (length2 < 8) {
            i5 += 8 - length2;
            length2 = 8;
        }
        byte[] bArr2 = new byte[length2];
        int i6 = f9227h;
        f9220a = i6;
        f9227h = i6 + 1;
        bArr2[0] = (byte) (i6 & 255);
        bArr2[1] = (byte) (i2 & 255);
        bArr2[2] = (byte) (i3 & 255);
        System.arraycopy(bArr, 0, bArr2, 3, bArr.length);
        if (i5 != 0) {
            byte[] bArr3 = {(byte) k};
            for (int i7 = 0; i7 < i5; i7++) {
                System.arraycopy(bArr3, 0, bArr2, j + bArr.length + i7, 1);
            }
        }
        l.a("data length: " + Integer.toString(a(r.a(bArr2, r.a(m, false))).length));
        return c(bArr2);
    }

    public static byte[] a(String str) {
        if (str != null && str.length() > 0) {
            try {
                l.a("long_data:" + Long.parseLong(str.trim()));
                byte[] bArr = new byte[5];
                for (int i2 = 0; i2 < 4; i2++) {
                    bArr[((5 - i2) - 1) - 1] = (byte) ((r3 >> (i2 * 8)) & 255);
                }
                return bArr;
            } catch (NumberFormatException unused) {
                l.b(String.format("invaild data:%s", str.toCharArray()));
            }
        }
        return null;
    }

    public static byte[] a(String str, byte b2) {
        if (str != null && str.length() > 0) {
            try {
                long j2 = Long.parseLong(str.trim());
                byte[] bArr = new byte[5];
                for (int i2 = 0; i2 < 5; i2++) {
                    bArr[(5 - i2) - 1] = (byte) ((j2 >> (i2 * 8)) & 255);
                }
                bArr[0] = (byte) (bArr[0] + (b2 << 5));
                return bArr;
            } catch (NumberFormatException unused) {
                l.b(String.format("invaild data:%s", str.toCharArray()));
            }
        }
        return null;
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i2 = f9228i + length;
        byte[] bArr2 = new byte[i2];
        bArr2[0] = (byte) f9226g;
        bArr2[1] = (byte) (length & 255);
        bArr2[2] = (byte) ((a.a(bArr, 0) >> 8) & 255);
        bArr2[3] = (byte) (a.a(bArr, 0) & 255);
        System.arraycopy(bArr, 0, bArr2, 4, length);
        l.a("L1_len" + Integer.toString(i2));
        return bArr2;
    }

    public static byte[] a(byte[] bArr, int i2) {
        l.a(bArr != null);
        l.a(b(bArr, i2));
        int i3 = f9228i;
        byte[] bArr2 = new byte[i2 - i3];
        System.arraycopy(bArr, i3, bArr2, 0, i2 - i3);
        byte[] bArrB = r.b(bArr2, r.a(m, false));
        int i4 = f9228i - 2;
        if (bArr[i4] != ((byte) ((a.a(bArr2, 0) >> 8) & 255)) || bArr[i4 + 1] != ((byte) (a.a(bArr2, 0) & 255))) {
            l.a("CRC fail");
            return l;
        }
        if (bArrB[0] == ((byte) (f9220a & 255))) {
            byte[] bArr3 = new byte[bArrB.length - 1];
            System.arraycopy(bArrB, 1, bArr3, 0, bArrB.length - 1);
            return bArr3;
        }
        l.a("SEQ " + f9220a + "!=" + Byte.toString(bArrB[0]));
        return l;
    }

    public static byte[] a(byte[] bArr, String str, byte[] bArr2) {
        l.a(bArr != null);
        l.a(bArr2 != null);
        l.a(str != null);
        if (bArr == null || bArr.length <= 0 || str == null || str.length() <= 0 || bArr2 == null || bArr2.length <= 0) {
            return null;
        }
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[12];
        byte[] bArrA = r.a(str);
        r.a(bArrA, bArrA.length);
        System.arraycopy(bArr, 1, bArr4, 0, 12);
        l.a("random_data: " + d(bArr4));
        System.arraycopy(r.a(r.b(bArr4, bArrA), r.a(m, false)), 8, bArr3, 0, 4);
        l.a("b_user: " + d(bArr2));
        byte[] bArr5 = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        System.arraycopy(bArr3, 0, bArr5, bArr2.length, 4);
        return bArr5;
    }

    public static String b(byte[] bArr, int i2) {
        l.a(bArr != null);
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            str = str + " " + String.format("%02x", Byte.valueOf(bArr[i3]));
        }
        return str;
    }

    public static byte[] b(String str) {
        if (str != null && str.length() > 0) {
            try {
                long j2 = Long.parseLong(str.trim());
                byte[] bArr = new byte[5];
                for (int i2 = 0; i2 < 5; i2++) {
                    bArr[(5 - i2) - 1] = (byte) ((j2 >> (i2 * 8)) & 255);
                }
                return bArr;
            } catch (NumberFormatException unused) {
                l.b(String.format("invaild data:%s", str.toCharArray()));
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr) {
        String str;
        l.a(bArr != null);
        int length = bArr.length;
        int i2 = f9222c;
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            System.arraycopy(bArr, 0, f9223d, f9224e, length);
            int i3 = f9224e + length;
            f9224e = i3;
            int i4 = f9225f - length;
            f9225f = i4;
            if (i4 > 0) {
                return null;
            }
            byte[] bArrA = a(f9223d, i3);
            f9224e = 0;
            f9222c = 0;
            l.a(String.format(Locale.getDefault(), "received_content_length %d", Integer.valueOf(length)));
            return bArrA;
        }
        if (bArr[0] != -85) {
            str = "(data[0] != L1_HEADER_MAGIC) ";
        } else {
            f9224e = 0;
            System.arraycopy(bArr, 0, f9223d, 0, length);
            f9224e = length;
            f9225f = (f9223d[1] & 255) + 4;
            l.a(String.format(Locale.getDefault(), "length_to_receive %d", Integer.valueOf(f9225f)));
            f9225f -= length;
            l.a(String.format(Locale.getDefault(), "length_to_receive %d", Integer.valueOf(f9225f)));
            if (f9225f <= 0) {
                byte[] bArrA2 = a(f9223d, f9224e);
                l.a(String.format(Locale.getDefault(), "received_content_length %d", Integer.valueOf(f9224e)));
                f9224e = 0;
                f9222c = 0;
                return bArrA2;
            }
            f9222c = 1;
            str = "wait message";
        }
        l.a(str);
        return null;
    }

    public static String c(byte[] bArr, int i2) {
        if (bArr == null) {
            return null;
        }
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            str = str + String.format("%02x", Byte.valueOf(bArr[i3]));
        }
        return str;
    }

    public static byte[] c(String str) {
        if (str != null && str.length() > 0) {
            try {
                long j2 = Long.parseLong(str.trim());
                byte[] bArr = new byte[3];
                for (int i2 = 0; i2 < 3; i2++) {
                    bArr[i2] = (byte) ((j2 >> (((3 - i2) - 1) * 8)) & 255);
                }
                return bArr;
            } catch (NumberFormatException unused) {
                l.b(String.format("invaild data:%s", str.toCharArray()));
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr) {
        l.a(bArr != null);
        return a(r.a(bArr, r.a(m, false)));
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return b(bArr, bArr.length);
    }

    public static byte[] d(String str) {
        if (str == null || str.length() != 14) {
            return null;
        }
        byte[] bArr = new byte[7];
        for (int i2 = 0; i2 < 7; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Byte.valueOf(str.substring(i3, i3 + 2)).byteValue();
        }
        l.a("time byte:" + d(bArr));
        return bArr;
    }

    public static byte[] e(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        int i2 = length / 2;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            long j2 = Long.parseLong(str.substring(i4, i4 + 2), 16);
            if (j2 <= 0 && j2 >= 256) {
                throw new NumberFormatException("Value out of range for byte,Please check String");
            }
            bArr[i3] = (byte) j2;
        }
        return bArr;
    }
}
