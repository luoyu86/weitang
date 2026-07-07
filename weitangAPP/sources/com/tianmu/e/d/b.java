package com.tianmu.e.d;

import android.text.TextUtils;
import java.io.Closeable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12012a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.tianmu.e.b.a f12017f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12013b = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, List<String>> f12018g = null;

    public b(com.tianmu.e.b.a aVar) {
        this.f12017f = aVar;
        if (aVar != null) {
            try {
                if (aVar.a() != null) {
                    String str = aVar.a().get("CIBA_RESPONSE_HEADER");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.f12012a = "1".equals(str);
                    aVar.a().remove("CIBA_RESPONSE_HEADER");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f2 A[Catch: all -> 0x0223, TryCatch #3 {all -> 0x0223, blocks: (B:108:0x01ee, B:110:0x01f2, B:112:0x01f6, B:115:0x01fb, B:116:0x0203), top: B:128:0x01ee }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0203 A[Catch: all -> 0x0223, TRY_LEAVE, TryCatch #3 {all -> 0x0223, blocks: (B:108:0x01ee, B:110:0x01f2, B:112:0x01f6, B:115:0x01fb, B:116:0x0203), top: B:128:0x01ee }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5 A[Catch: all -> 0x0145, Exception -> 0x0149, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x0149, all -> 0x0145, blocks: (B:32:0x00c1, B:34:0x00cd, B:46:0x00f5), top: B:137:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125 A[Catch: all -> 0x012d, Exception -> 0x0130, TRY_LEAVE, TryCatch #17 {Exception -> 0x0130, all -> 0x012d, blocks: (B:54:0x011f, B:56:0x0125), top: B:129:0x011f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.e.d.b.a():java.lang.String");
    }

    private void a(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void a(int i2, String str) {
        this.f12014c = i2;
        this.f12016e = str;
    }
}
