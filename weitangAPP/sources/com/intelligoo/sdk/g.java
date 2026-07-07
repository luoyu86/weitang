package com.intelligoo.sdk;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ArrayList<DMFingerprintModel> f9255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ArrayList<byte[]> f9256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f9257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f9259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f9260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f9261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static byte[] f9262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static byte[] f9263i;
    private static boolean j;

    public static ArrayList<byte[]> a() {
        if (f9256b == null) {
            f9256b = e();
        }
        return f9256b;
    }

    public static void a(ArrayList<DMFingerprintModel> arrayList) {
        f9255a = arrayList;
    }

    public static void a(boolean z) {
        j = z;
    }

    private static byte[] a(int i2, int i3) {
        return new byte[]{(byte) ((i2 >> 8) & 255), (byte) (i2 & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }

    public static int b() {
        return f9257c;
    }

    public static void c() {
        f9257c = 0;
        f9255a = null;
        j = false;
        f9259e = 0;
        f9258d = 0;
        f9256b = null;
        f9262h = null;
        f9263i = null;
        f9260f = 0;
        f9261g = 0;
    }

    public static byte[] d() {
        byte[] bArr;
        if (!j) {
            return f9263i;
        }
        if (f9256b == null) {
            f9256b = e();
        }
        ArrayList<byte[]> arrayList = f9256b;
        if (arrayList == null || f9257c >= arrayList.size()) {
            return null;
        }
        byte[] bArr2 = f9256b.get(f9257c);
        int length = bArr2.length;
        int i2 = f9258d;
        if (length > i2 + 230) {
            bArr = new byte[234];
            System.arraycopy(bArr2, i2, bArr, 4, 230);
            int i3 = f9258d + 230;
            f9258d = i3;
            System.arraycopy(a(i3 - 10, bArr2.length - i3), 0, bArr, 0, 4);
        } else {
            bArr = new byte[(bArr2.length - i2) + 4];
            System.arraycopy(bArr2, i2, bArr, 4, bArr2.length - i2);
            f9258d = 0;
            f9257c++;
            System.arraycopy(a(bArr2.length - 10, 0), 0, bArr, 0, 4);
        }
        f9263i = bArr;
        j = false;
        return bArr;
    }

    private static ArrayList<byte[]> e() {
        if (f9255a == null) {
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < f9255a.size(); i2++) {
            DMFingerprintModel dMFingerprintModel = f9255a.get(i2);
            ArrayList<byte[]> arrayList2 = dMFingerprintModel.fingerprintdatas;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i3 = 0; i3 < dMFingerprintModel.fingerprintdatas.size(); i3++) {
                    byte[] bArr = new byte[dMFingerprintModel.fingerprintdatas.get(i3).length + 10];
                    int i4 = (int) Long.parseLong(dMFingerprintModel.identity);
                    for (int i5 = 0; i5 < 4; i5++) {
                        bArr[i5] = (byte) ((i4 >> ((3 - i5) * 8)) & 255);
                        if (i5 < 3 && dMFingerprintModel.startDate.length() >= 6 && dMFingerprintModel.endDate.length() >= 6) {
                            int i6 = i5 * 2;
                            int i7 = i6 + 2;
                            bArr[i5 + 4] = (byte) (Integer.parseInt(dMFingerprintModel.startDate.substring(i6, i7)) & 255);
                            bArr[i5 + 7] = (byte) (Integer.parseInt(dMFingerprintModel.endDate.substring(i6, i7)) & 255);
                        }
                    }
                    System.arraycopy(dMFingerprintModel.fingerprintdatas.get(i3), 0, bArr, 10, dMFingerprintModel.fingerprintdatas.get(i3).length);
                    arrayList.add(bArr);
                }
            }
        }
        return arrayList;
    }
}
