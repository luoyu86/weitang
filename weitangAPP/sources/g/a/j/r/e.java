package g.a.j.r;

import com.tom_roush.fontbox.ttf.GlyfDescript;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short[] f14669a = new short[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f14670b;

    static {
        byte[] bArr = new byte[112];
        f14670b = bArr;
        byte[] bArr2 = new byte[128];
        a(bArr2, 0, 15, (byte) 1);
        a(bArr2, 16, 31, (byte) 2);
        a(bArr2, 32, 63, (byte) 3);
        a(bArr2, 64, 65, (byte) 0);
        a(bArr2, 66, 95, (byte) 4);
        a(bArr2, 96, 96, (byte) 5);
        a(bArr2, 97, 108, (byte) 6);
        a(bArr2, 109, 109, (byte) 7);
        a(bArr2, 110, 111, (byte) 6);
        a(bArr2, 112, 112, (byte) 8);
        a(bArr2, 113, 115, (byte) 9);
        a(bArr2, 116, 116, (byte) 10);
        a(bArr2, 117, 127, (byte) 0);
        a(bArr, 0, bArr.length - 1, (byte) -2);
        a(bArr, 8, 11, (byte) -1);
        a(bArr, 24, 27, (byte) 0);
        a(bArr, 40, 43, GlyfDescript.X_DUAL);
        a(bArr, 58, 59, (byte) 0);
        a(bArr, 72, 73, (byte) 0);
        a(bArr, 89, 91, GlyfDescript.X_DUAL);
        a(bArr, 104, 104, GlyfDescript.X_DUAL);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, 48, GlyfDescript.X_DUAL, 64, 80, 32, 96};
        for (int i2 = 0; i2 < 128; i2++) {
            byte b2 = bArr2[i2];
            f14669a[i2] = (short) (bArr4[b2] | ((bArr3[b2] & i2) << 8));
        }
    }

    public static void a(byte[] bArr, int i2, int i3, byte b2) {
        while (i2 <= i3) {
            bArr[i2] = b2;
            i2++;
        }
    }

    public static int transcodeToUTF16(byte[] bArr, char[] cArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 < 0) {
                short s = f14669a[b2 & 127];
                int i5 = s >>> 8;
                byte b3 = (byte) s;
                while (b3 >= 0) {
                    if (i4 >= bArr.length) {
                        return -1;
                    }
                    int i6 = i4 + 1;
                    byte b4 = bArr[i4];
                    i5 = (i5 << 6) | (b4 & 63);
                    b3 = f14670b[b3 + ((b4 & 255) >>> 4)];
                    i4 = i6;
                }
                if (b3 == -2) {
                    return -1;
                }
                if (i5 <= 65535) {
                    if (i3 >= cArr.length) {
                        return -1;
                    }
                    cArr[i3] = (char) i5;
                    i3++;
                } else {
                    if (i3 >= cArr.length - 1) {
                        return -1;
                    }
                    int i7 = i3 + 1;
                    cArr[i3] = (char) ((i5 >>> 10) + 55232);
                    i3 = i7 + 1;
                    cArr[i7] = (char) (56320 | (i5 & 1023));
                }
                i2 = i4;
            } else {
                if (i3 >= cArr.length) {
                    return -1;
                }
                cArr[i3] = (char) b2;
                i2 = i4;
                i3++;
            }
        }
        return i3;
    }
}
