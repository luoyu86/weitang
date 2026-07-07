package com.alibaba.mtl.log.d;

/* JADX INFO: loaded from: classes.dex */
public class n {

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f4569d;
        public int x;
        public int y;

        private a() {
            this.f4569d = new int[256];
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        a aVarA;
        if (bArr == null || str == null || (aVarA = a(str)) == null) {
            return null;
        }
        return a(bArr, aVarA);
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i2 = 0; i2 < 256; i2++) {
            aVar.f4569d[i2] = i2;
        }
        aVar.x = 0;
        aVar.y = 0;
        int length = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            try {
                char cCharAt = str.charAt(length);
                int[] iArr = aVar.f4569d;
                i3 = ((cCharAt + iArr[i4]) + i3) % 256;
                int i5 = iArr[i4];
                iArr[i4] = iArr[i3];
                iArr[i3] = i5;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i2 = aVar.x;
        int i3 = aVar.y;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = aVar.f4569d;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            int i6 = (iArr[i2] + iArr[i3]) % 256;
            bArr[i4] = (byte) (iArr[i6] ^ bArr[i4]);
        }
        aVar.x = i2;
        aVar.y = i3;
        return bArr;
    }
}
