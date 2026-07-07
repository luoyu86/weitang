package com.intelligoo.sdk;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f9269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9270b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Bundle f9271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f9272d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static StringBuffer f9273e = new StringBuffer();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static q f9274f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f9275g = false;

    private static int a(byte[] bArr, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 8) + (bArr[i4] & 255);
        }
        return i3;
    }

    private static String a(String str) {
        if ("FFFFFFFFFFFF".equals(str.toUpperCase())) {
            return str.toUpperCase();
        }
        byte[] bArrE = e.e(str);
        byte[] bArr = {74, 90, 77, 84, 109, 111};
        for (int i2 = 0; i2 < 6; i2++) {
            bArrE[i2] = (byte) (bArrE[i2] ^ bArr[i2]);
        }
        return e.c(bArrE, 6).toUpperCase();
    }

    public static void a(boolean z) {
        f9275g = z;
    }

    public static byte[] a() {
        byte[] bArr = f9269a;
        if (bArr == null) {
            l.a("send_buf is null");
            f9270b = 0;
            return null;
        }
        if (f9270b >= bArr.length) {
            l.a(String.format(Locale.CHINA, "send_buf_index:%d send_buf.length:%d", Integer.valueOf(f9270b), Integer.valueOf(f9269a.length)));
            f9269a = null;
            f9270b = 0;
            return null;
        }
        l.a(String.format(Locale.CHINA, "send_buf_index:%d send_buf.length:%d", Integer.valueOf(f9270b), Integer.valueOf(f9269a.length)));
        byte[] bArr2 = f9269a;
        int length = bArr2.length;
        int i2 = f9270b;
        if (length - i2 >= 20) {
            byte[] bArr3 = new byte[20];
            System.arraycopy(bArr2, i2, bArr3, 0, 20);
            f9270b += 20;
            return bArr3;
        }
        int length2 = bArr2.length - i2;
        byte[] bArr4 = new byte[length2];
        System.arraycopy(bArr2, i2, bArr4, 0, length2);
        f9270b += length2;
        return bArr4;
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte[] bArr) {
        byte[] bArrD = d(bArr);
        byte[] bArr2 = new byte[bArrD.length + 3];
        bArr2[0] = b2;
        bArr2[1] = b3;
        bArr2[2] = b4;
        System.arraycopy(bArrD, 0, bArr2, 3, bArrD.length);
        return e.a(2, 5, bArr2);
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + 3 + bArr2.length];
        bArr3[0] = b2;
        bArr3[1] = b3;
        bArr3[2] = b4;
        System.arraycopy(bArrD, 0, bArr3, 3, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length + 3, bArr2.length);
        return e.a(2, 5, bArr3);
    }

    public static byte[] a(byte b2, byte b3, byte[] bArr) {
        byte[] bArrB = e.b(i.a().f9266b.getString("com.intelligoo.sdk.DeviceModel.DEV_FROM_PHONE"));
        if (bArrB == null || bArrB.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr2 = new byte[bArrD.length + 2 + bArrB.length];
        bArr2[0] = b2;
        bArr2[1] = b3;
        System.arraycopy(bArrD, 0, bArr2, 2, bArrD.length);
        System.arraycopy(bArrB, 0, bArr2, bArrD.length + 2, bArrB.length);
        return e.a(4, 1, bArr2);
    }

    public static byte[] a(byte b2, byte[] bArr) {
        byte[] bArr2;
        if (b2 != 1 && (bArr == null || bArr.length != 5)) {
            l.b("admin_phone is null or length != 5");
            return null;
        }
        if (1 == b2) {
            bArr2 = new byte[1];
        } else {
            byte[] bArr3 = new byte[bArr.length + 1];
            System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
            bArr2 = bArr3;
        }
        bArr2[0] = b2;
        return e.a(3, 1, bArr2);
    }

    public static byte[] a(byte b2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        String str;
        if (bArr6 == null || bArr6.length != 5) {
            str = "send_phone is null or length != 5";
        } else {
            if (b2 != 1) {
                byte[] bArrD = d(bArr5);
                byte[] bArr7 = new byte[bArrD.length + bArr6.length + 17];
                bArr7[0] = b2;
                System.arraycopy(bArrD, 0, bArr7, 17, bArrD.length);
                System.arraycopy(bArr6, 0, bArr7, bArrD.length + 17, bArr6.length);
                return e.a(2, 16, bArr7);
            }
            if (bArr != null && bArr2.length < 7 && bArr3 != null && bArr4.length < 7 && b2 <= 1) {
                byte[] bArrD2 = d(bArr5);
                byte[] bArr8 = new byte[bArrD2.length + bArr6.length + bArr.length + bArr2.length + bArr3.length + bArr4.length + 1];
                bArr8[0] = b2;
                System.arraycopy(bArr, 0, bArr8, 1, bArr.length);
                System.arraycopy(bArr2, 0, bArr8, bArr.length + 1, bArr2.length);
                System.arraycopy(bArr3, 0, bArr8, bArr.length + bArr2.length + 1, bArr3.length);
                System.arraycopy(bArr4, 0, bArr8, bArr.length + bArr2.length + bArr3.length + 1, bArr4.length);
                System.arraycopy(bArrD2, 0, bArr8, bArr.length + bArr2.length + bArr3.length + bArr4.length + 1, bArrD2.length);
                System.arraycopy(bArr6, 0, bArr8, bArrD2.length + bArr.length + bArr2.length + bArr3.length + bArr4.length + 1, bArr6.length);
                return e.a(2, 16, bArr8);
            }
            str = "dhcp is null or length >=  7";
        }
        l.b(str);
        return null;
    }

    public static byte[] a(int i2) {
        byte[] bArrA;
        if (i2 > b() || (bArrA = a(i.a().f9266b.getLongArray(ConstantsUtils.CARD_NUMBER))) == null) {
            return null;
        }
        int i3 = (i2 - 1) * 236;
        int length = bArrA.length - i3;
        if (length >= 236) {
            byte[] bArr = new byte[236];
            System.arraycopy(bArrA, i3, bArr, 0, 236);
            return bArr;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArrA, i3, bArr2, 0, length);
        return bArr2;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            l.b("data is null");
            f9270b = 0;
            return null;
        }
        e.a();
        l.a(String.format(Locale.CHINA, "data.length :%d ", Integer.valueOf(bArr.length)));
        if (bArr.length <= 20) {
            f9269a = null;
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        f9269a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte[] bArr3 = new byte[20];
        System.arraycopy(bArr, 0, bArr3, 0, 20);
        l.a(String.format(Locale.CHINA, "send_buf_index :%d,send.length:%d", Integer.valueOf(f9270b), 20));
        f9270b += 20;
        l.a(String.format(Locale.CHINA, "send_buf.length :%d,send_buf_index:%d", Integer.valueOf(f9269a.length), Integer.valueOf(f9270b)));
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 7) {
            l.b("time is null or length != 7");
            return null;
        }
        byte[] bArrD = d(bArr2);
        byte[] bArr3 = new byte[bArr.length + bArrD.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArrD, 0, bArr3, bArr.length, bArrD.length);
        return e.a(2, 1, bArr3);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte b2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, b2, bArr3);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        String str;
        l.a("");
        byte[] bArrD = d(bArr3);
        if (bArr == null || bArr.length != 3) {
            str = "old_pwd == null || old_pwd.length != 3";
        } else if (bArr2 == null || bArr2.length != 3) {
            str = "new_pwd == null || new_pwd.length != 3";
        } else {
            if (bArr4 != null && bArr4.length == 5) {
                byte[] bArr5 = new byte[bArr.length + bArr2.length + bArrD.length + bArr4.length];
                System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
                System.arraycopy(bArr2, 0, bArr5, bArr.length, bArr2.length);
                System.arraycopy(bArrD, 0, bArr5, bArr.length + bArr2.length, bArrD.length);
                System.arraycopy(bArr4, 0, bArr5, bArr.length + bArr2.length + bArrD.length, bArr4.length);
                return e.a(2, 2, bArr5);
            }
            str = "send_phone is null or length != 5";
        }
        l.b(str);
        return null;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        if (bArr5 == null || bArr5.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr4);
        byte[] bArr6 = new byte[bArrD.length + 3 + bArr5.length + bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr6, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr6, bArr.length + bArr2.length, bArr3.length);
        System.arraycopy(bArrD, 0, bArr6, bArr.length + bArr2.length + bArr3.length, bArrD.length);
        System.arraycopy(bArr5, 0, bArr6, bArr.length + bArr2.length + bArr3.length + bArrD.length, bArr5.length);
        return e.a(2, 13, bArr6);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        String str;
        if (bArr6 == null || bArr6.length != 5) {
            str = "send_phone is null or length != 5";
        } else {
            if (bArr3 != null && bArr3.length < 20 && bArr4 != null && bArr4.length < 20) {
                byte[] bArrD = d(bArr5);
                byte[] bArr7 = new byte[bArrD.length + bArr6.length + bArr.length + bArr2.length + 20 + 20];
                System.arraycopy(bArr, 0, bArr7, 0, bArr.length);
                System.arraycopy(bArr2, 0, bArr7, bArr.length, bArr2.length);
                System.arraycopy(bArr3, 0, bArr7, bArr.length + bArr2.length, bArr3.length);
                System.arraycopy(bArr4, 0, bArr7, bArr.length + bArr2.length + 20, bArr4.length);
                System.arraycopy(bArrD, 0, bArr7, bArr.length + bArr2.length + 40, bArrD.length);
                System.arraycopy(bArr6, 0, bArr7, bArrD.length + bArr.length + bArr2.length + 40, bArr6.length);
                return e.a(2, 11, bArr7);
            }
            str = "apPwd/apName is null or length >=  20";
        }
        l.b(str);
        return null;
    }

    private static byte[] a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        int length = jArr.length;
        byte[] bArr = new byte[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[(i2 * 4) + i3] = (byte) ((jArr[i2] >> (((4 - i3) - 1) * 8)) & 255);
            }
        }
        return bArr;
    }

    public static byte b() {
        int length = i.a().f9266b.getLongArray(ConstantsUtils.CARD_NUMBER).length;
        l.a("len ---->" + length);
        return (byte) ((length / 60) + 1);
    }

    public static void b(byte[] bArr) {
        l.a(bArr != null);
        if (bArr == null) {
            f.a(51, (Bundle) null);
            return;
        }
        byte[] bArrB = e.b(bArr);
        if (bArrB == null) {
            return;
        }
        byte b2 = bArrB[0];
        if (b2 == 1) {
            h(bArrB);
            return;
        }
        if (b2 == 2) {
            i(bArrB);
            return;
        }
        if (b2 == 3) {
            g(bArrB);
        } else if (b2 != 4) {
            f.a(52, (Bundle) null);
        } else {
            j(bArrB);
        }
    }

    public static byte[] b(byte b2, byte[] bArr) {
        l.a("get_local_card_sum_count:" + ((int) b()));
        byte[] bArrB = e.b(h.c(i.a().f9265a.eKey, false));
        if (bArrB == null || bArrB.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArrA = a(b2);
        if (bArrA == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArrA.length + bArrD.length + 2 + bArrB.length];
        bArr2[0] = b();
        bArr2[1] = b2;
        System.arraycopy(bArrD, 0, bArr2, 2, bArrD.length);
        System.arraycopy(bArrB, 0, bArr2, bArrD.length + 2, bArrB.length);
        System.arraycopy(bArrA, 0, bArr2, bArrD.length + 2 + bArrB.length, bArrA.length);
        return e.a(4, 2, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 3, bArr3);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr4 == null || bArr4.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr3);
        byte[] bArr5 = new byte[bArrD.length + bArr4.length + bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr5, bArr.length, bArr2.length);
        System.arraycopy(bArrD, 0, bArr5, bArr.length + bArr2.length, bArrD.length);
        System.arraycopy(bArr4, 0, bArr5, bArrD.length + bArr.length + bArr2.length, bArr4.length);
        return e.a(2, 17, bArr5);
    }

    public static byte[] c(byte b2, byte[] bArr) {
        l.a("get_local_card_sum_count:" + ((int) b()));
        byte[] bArrB = e.b(h.c(i.a().f9265a.eKey, false));
        if (bArrB == null || bArrB.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArrA = a(b2);
        if (bArrA == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArrA.length + bArrD.length + 2 + bArrB.length];
        bArr2[0] = b();
        bArr2[1] = b2;
        System.arraycopy(bArrD, 0, bArr2, 2, bArrD.length);
        System.arraycopy(bArrB, 0, bArr2, bArrD.length + 2, bArrB.length);
        System.arraycopy(bArrA, 0, bArr2, bArrD.length + 2 + bArrB.length, bArrA.length);
        return e.a(4, 3, bArr2);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArrA;
        String str;
        int i2;
        l.a(bArr != null);
        LibDevModel libDevModel = i.a().f9265a;
        String str2 = libDevModel.eKey;
        if (str2 == null) {
            return null;
        }
        int i3 = libDevModel.devType;
        String strB = h.b(str2, false);
        Log.e("bensontest", "devType:" + i3);
        if (i3 == 1 || (i2 = libDevModel.devType) == 9 || i2 == 14 || i3 == 17 || i3 == 18 || i3 == 20) {
            String strD = h.d(libDevModel.eKey, false);
            if (strD.length() == 16) {
                strD = strD.substring(6);
            }
            if ("0000000000".equals(strD) && (str = libDevModel.cardno) != null) {
                strD = str;
            }
            Log.e("bensontest", "cardno:" + strD);
            bArrA = e.a(strD);
        } else if (i3 == 3) {
            String strD2 = h.d(libDevModel.eKey, false);
            if (strD2 == null || strD2.length() == 0) {
                bArrA = e.a(strB);
            } else {
                try {
                    if (Long.parseLong(strD2) != 0) {
                        strB = strD2;
                    }
                    strD2 = strB;
                } catch (Exception unused) {
                }
                bArrA = e.e(strD2);
            }
        } else if (i3 == 27 || i3 == 28 || i3 == 29) {
            byte[] bArrB = e.b(strB);
            String str3 = libDevModel.cardno;
            byte[] bArrA2 = e.a(str3 != null ? str3 : "0000000000");
            if (bArrA2 == null) {
                bArrA2 = new byte[4];
            }
            if (bArrB == null) {
                bArrB = new byte[5];
            }
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArrA2, 1, bArr2, 0, 3);
            System.arraycopy(bArrB, 0, bArr2, 3, 5);
            bArrA = bArr2;
        } else {
            bArrA = e.b(strB);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("open_user_id: ");
        sb.append(bArrA == null ? "null" : e.b(bArrA, bArrA.length));
        l.a(sb.toString());
        return e.a(bArr, h.a(libDevModel.eKey, false), bArrA);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 4, bArr3);
    }

    public static byte[] d(byte[] bArr) {
        l.a(bArr != null);
        byte[] bArr2 = new byte[4];
        if (bArr == null || bArr.length != 16) {
            l.b("not get comm key");
            return null;
        }
        byte[] bArrC = e.c(bArr);
        System.arraycopy(bArrC, bArrC.length - 4, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 9, bArr3);
    }

    public static byte[] e(byte[] bArr) {
        l.a(bArr != null);
        return e.a(1, 2, bArr);
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 10, bArr3);
    }

    public static byte[] f(byte[] bArr) {
        return e.a(3, 2, bArr);
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 24, bArr3);
    }

    public static void g(byte[] bArr) {
        l.a(bArr != null);
        l.a(bArr.length >= 3);
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        if (b2 == 1) {
            if (b3 == 0) {
                byte[] bArr2 = new byte[bArr.length - 2];
                System.arraycopy(bArr, 2, bArr2, 0, bArr.length - 2);
                byte[] bArrC = c(bArr2);
                if (f9275g) {
                    f9274f.onOpenCmdCallBack(b3, a(f(bArrC)));
                    return;
                } else {
                    f.a(a(f(bArrC)));
                    return;
                }
            }
            if (f9275g) {
                f9274f.onOpenCmdCallBack(b3, null);
                return;
            }
        } else {
            if (b2 != 2) {
                return;
            }
            boolean z = f9275g;
            if (b3 == 0) {
                if (z) {
                    f9274f.onRandomCmdCallBack(b3, null);
                    return;
                } else {
                    f.a(0, (Bundle) null);
                    return;
                }
            }
            if (z) {
                f9274f.onRandomCmdCallBack(b3, null);
                return;
            }
        }
        f.a(b3, (Bundle) null);
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 20, bArr3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e6, code lost:
    
        if (r5 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e8, code lost:
    
        com.intelligoo.sdk.f.a(0, (android.os.Bundle) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ec, code lost:
    
        com.intelligoo.sdk.f.a(r5, (android.os.Bundle) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f2, code lost:
    
        if (r5 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(byte[] r13) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intelligoo.sdk.k.h(byte[]):void");
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 6, bArr3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r6 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r6 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x04ef, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04f5, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x04fb, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0501, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        com.intelligoo.sdk.f.a(0, (android.os.Bundle) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0507, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x050d, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0513, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        com.intelligoo.sdk.f.a(r6, (android.os.Bundle) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0519, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0731, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0736, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x074e, code lost:
    
        if (r6 == 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x064d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void i(byte[] r30) {
        /*
            Method dump skipped, instruction units count: 1938
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intelligoo.sdk.k.i(byte[]):void");
    }

    public static byte[] i(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 18, bArr3);
    }

    public static void j(byte[] bArr) {
        String str;
        String str2;
        l.a(bArr != null);
        l.a(bArr.length >= 3);
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        if (b2 != 1) {
            if (b2 != 2) {
                if (b2 != 3) {
                    f.a(55, (Bundle) null);
                    return;
                }
                if (b3 != 0) {
                    str2 = String.format(Locale.CHINA, "res:%d", Byte.valueOf(b3));
                } else {
                    if (bArr[3] > bArr[4]) {
                        LibDevModel libDevModel = i.a().f9265a;
                        l.a(libDevModel != null);
                        f.a(a(c((byte) (bArr[4] + 1), r.a(h.a(libDevModel.eKey, false)))));
                        return;
                    }
                    str = String.format(Locale.CHINA, "res:%d", Byte.valueOf(b3));
                    l.a(str);
                }
            } else if (b3 != 0) {
                str2 = String.format(Locale.CHINA, "res:%d", Byte.valueOf(b3));
            } else if (bArr[3] > bArr[4]) {
                f9270b = 0;
                LibDevModel libDevModel2 = i.a().f9265a;
                l.a(libDevModel2 != null);
                f.a(a(b((byte) (bArr[4] + 1), r.a(h.a(libDevModel2.eKey, false)))));
                return;
            }
            l.a(str2);
            f.a(b3, (Bundle) null);
            return;
        }
        if (b3 == 0) {
            if (bArr[3] > bArr[4]) {
                int length = bArr.length - 5;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 5, bArr2, 0, length);
                f9273e.append(e.c(bArr2, length));
                LibDevModel libDevModel3 = i.a().f9265a;
                l.a(libDevModel3 != null);
                byte[] bArrA = r.a(h.a(libDevModel3.eKey, false));
                f9270b = 0;
                a(a(bArr[3], (byte) (bArr[4] + 1), bArrA));
                return;
            }
            int length2 = bArr.length - 5;
            byte[] bArr3 = new byte[4];
            for (int i2 = 0; i2 < length2 / 4; i2++) {
                System.arraycopy(bArr, (i2 * 4) + 5, bArr3, 0, 4);
                f9273e.append(e.c(bArr3, 4));
            }
            String string = f9273e.toString();
            StringBuffer stringBuffer = f9273e;
            stringBuffer.delete(0, stringBuffer.length());
            str = "rec_data:" + string + "--" + f9273e.toString();
            l.a(str);
        }
        f.a(b3, (Bundle) null);
        return;
        f.a(0, (Bundle) null);
    }

    public static byte[] j(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 28, bArr3);
    }

    public static byte[] k(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        f.c(g.b(), g.a() == null ? 0 : g.a().size());
        byte[] bArrD = g.d();
        if (bArrD == null || bArrD.length <= 0) {
            f.d(0, g.b());
            return null;
        }
        byte[] bArrD2 = d(bArr);
        byte[] bArr3 = new byte[bArrD2.length + bArr2.length + bArrD.length];
        System.arraycopy(bArrD2, 0, bArr3, 0, bArrD2.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD2.length, bArr2.length);
        System.arraycopy(bArrD, 0, bArr3, bArrD2.length + bArr2.length, bArrD.length);
        return e.a(2, 21, bArr3);
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 15, bArr3);
    }

    public static byte[] m(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 7, bArr3);
    }

    public static byte[] n(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 8, bArr3);
    }

    public static byte[] o(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        return e.a(2, 12, bArr3);
    }

    public static byte[] p(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length != 5) {
            l.b("send_phone is null or length != 5");
            return null;
        }
        ArrayList<String> stringArrayList = i.a().f9266b.getStringArrayList(ConstantsUtils.USERIDS);
        long[] jArr = new long[stringArrayList.size()];
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            jArr[i2] = Long.parseLong(stringArrayList.get(i2));
        }
        byte[] bArrA = a(jArr);
        byte[] bArrD = d(bArr);
        byte[] bArr3 = new byte[bArrD.length + bArr2.length + bArrA.length + 1];
        System.arraycopy(bArrD, 0, bArr3, 0, bArrD.length);
        System.arraycopy(bArr2, 0, bArr3, bArrD.length, bArr2.length);
        bArr3[bArrD.length + bArr2.length] = (byte) (stringArrayList.size() & 255);
        System.arraycopy(bArrA, 0, bArr3, bArrD.length + bArr2.length + 1, bArrA.length);
        return e.a(2, 25, bArr3);
    }
}
