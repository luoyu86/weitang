package com.alipay.sdk.m.l0;

/* JADX INFO: loaded from: classes.dex */
public class e {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f5480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5482c;

        public b() {
            this.f5480a = new int[256];
        }
    }

    public static byte[] a(byte[] bArr) {
        b bVarA;
        if (bArr == null || (bVarA = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, bVarA);
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b();
        for (int i2 = 0; i2 < 256; i2++) {
            bVar.f5480a[i2] = i2;
        }
        bVar.f5481b = 0;
        bVar.f5482c = 0;
        int length = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            try {
                char cCharAt = str.charAt(length);
                int[] iArr = bVar.f5480a;
                i3 = ((cCharAt + iArr[i4]) + i3) % 256;
                int i5 = iArr[i4];
                iArr[i4] = iArr[i3];
                iArr[i3] = i5;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return bVar;
    }

    public static byte[] a(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i2 = bVar.f5481b;
        int i3 = bVar.f5482c;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = bVar.f5480a;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            int i6 = (iArr[i2] + iArr[i3]) % 256;
            bArr[i4] = (byte) (iArr[i6] ^ bArr[i4]);
        }
        bVar.f5481b = i2;
        bVar.f5482c = i3;
        return bArr;
    }
}
