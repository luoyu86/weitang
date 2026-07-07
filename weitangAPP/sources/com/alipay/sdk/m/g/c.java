package com.alipay.sdk.m.g;

import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SecureRandom f5343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f5344b = "0123456789ABCDEF".toCharArray();

    public static SecureRandom a() {
        if (f5343a != null) {
            return f5343a;
        }
        synchronized (c.class) {
            if (f5343a == null) {
                f5343a = new SecureRandom();
            }
        }
        return f5343a;
    }

    public static byte[] a(byte b2) {
        return new byte[]{b2};
    }

    public static byte[] a(char c2) {
        return new byte[]{(byte) (c2 & 255)};
    }

    public static byte[] a(char c2, char c3) {
        return new byte[]{(byte) (c2 & 255), (byte) (c3 & 255)};
    }

    public static byte[] a(int i2) {
        return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
    }

    public static byte[] a(short s) {
        return new byte[]{(byte) s, (byte) (s >> 8)};
    }

    public static byte[] b() {
        byte[] bArr = new byte[2];
        a().nextBytes(bArr);
        return bArr;
    }

    public static byte[] c() {
        byte[] bArr = new byte[4];
        a().nextBytes(bArr);
        return bArr;
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f5344b;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArrCopyOf = null;
        int length2 = 0;
        for (byte[] bArr3 : bArr) {
            if (bArrCopyOf == null) {
                bArrCopyOf = Arrays.copyOf(bArr3, length);
                length2 = bArr3.length;
            } else {
                System.arraycopy(bArr3, 0, bArrCopyOf, length2, bArr3.length);
                length2 += bArr3.length;
            }
        }
        return bArrCopyOf;
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }
}
