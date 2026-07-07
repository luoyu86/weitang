package g.a.i.d.a;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static void I2OSP(int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        bArr[i3] = (byte) i2;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) (i2 >>> 16);
        bArr[i5 + 1] = (byte) (i2 >>> 24);
    }

    public static void I2OSP(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            bArr[i3 + i5] = (byte) (i2 >>> (i5 * 8));
        }
    }

    public static void I2OSP(long j, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) j;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >>> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >>> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >>> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >>> 32);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j >>> 40);
        bArr[i8] = (byte) (j >>> 48);
        bArr[i8 + 1] = (byte) (j >>> 56);
    }

    public static byte[] I2OSP(int i2) {
        return new byte[]{(byte) i2, (byte) (i2 >>> 8), (byte) (i2 >>> 16), (byte) (i2 >>> 24)};
    }

    public static byte[] I2OSP(long j) {
        return new byte[]{(byte) j, (byte) (j >>> 8), (byte) (j >>> 16), (byte) (j >>> 24), (byte) (j >>> 32), (byte) (j >>> 40), (byte) (j >>> 48), (byte) (j >>> 56)};
    }

    public static int OS2IP(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static int OS2IP(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        int i6 = i4 + 1;
        return ((bArr[i6] & 255) << 24) | i5 | ((bArr[i4] & 255) << 16);
    }

    public static int OS2IP(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            i4 |= (bArr[i2 + i5] & 255) << (i5 * 8);
        }
        return i4;
    }

    public static long OS2LIP(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        long j = bArr[i2] & 255;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        long j2 = j | ((long) ((bArr[i3] & 255) << 8)) | ((long) ((bArr[i4] & 255) << 16));
        int i6 = i5 + 1;
        long j3 = j2 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        long j4 = j3 | ((((long) bArr[i6]) & 255) << 32);
        int i8 = i7 + 1;
        long j5 = j4 | ((((long) bArr[i7]) & 255) << 40);
        return ((((long) bArr[i8 + 1]) & 255) << 56) | j5 | ((((long) bArr[i8]) & 255) << 48);
    }

    public static byte[] toByteArray(int[] iArr, int i2) {
        int length = iArr.length;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 <= length - 2) {
            I2OSP(iArr[i3], bArr, i4);
            i3++;
            i4 += 4;
        }
        I2OSP(iArr[length - 1], bArr, i4, i2 - i4);
        return bArr;
    }

    public static int[] toIntArray(byte[] bArr) {
        int length = (bArr.length + 3) / 4;
        int length2 = bArr.length & 3;
        int[] iArr = new int[length];
        int i2 = 0;
        int i3 = 0;
        while (i2 <= length - 2) {
            iArr[i2] = OS2IP(bArr, i3);
            i2++;
            i3 += 4;
        }
        int i4 = length - 1;
        if (length2 != 0) {
            iArr[i4] = OS2IP(bArr, i3, length2);
        } else {
            iArr[i4] = OS2IP(bArr, i3);
        }
        return iArr;
    }
}
