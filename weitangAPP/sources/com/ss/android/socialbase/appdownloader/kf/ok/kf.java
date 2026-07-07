package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f9934a;
    private int[] ok;

    private kf() {
    }

    public static kf ok(s sVar) throws IOException {
        a.ok(sVar, 1835009);
        int iA = sVar.a();
        int iA2 = sVar.a();
        int iA3 = sVar.a();
        sVar.a();
        int iA4 = sVar.a();
        int iA5 = sVar.a();
        kf kfVar = new kf();
        kfVar.ok = sVar.a(iA2);
        if (iA3 != 0) {
            sVar.a(iA3);
        }
        int i2 = (iA5 == 0 ? iA : iA5) - iA4;
        if (i2 % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
        }
        kfVar.f9934a = sVar.a(i2 / 4);
        if (iA5 != 0) {
            int i3 = iA - iA5;
            if (i3 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
            }
            sVar.a(i3 / 4);
        }
        return kfVar;
    }

    public String ok(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.ok) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int iOk = ok(this.f9934a, i3);
        StringBuilder sb = new StringBuilder(iOk);
        while (iOk != 0) {
            i3 += 2;
            sb.append((char) ok(this.f9934a, i3));
            iOk--;
        }
        return sb.toString();
    }

    private static final int ok(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}
