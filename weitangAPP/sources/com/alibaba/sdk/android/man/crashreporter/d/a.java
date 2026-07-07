package com.alibaba.sdk.android.man.crashreporter.d;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4710a;
    private com.alibaba.sdk.android.man.crashreporter.c environment;
    private final String TOMBSTONE_PATH = "tombstone";
    private final String FILENAME = com.alibaba.sdk.android.man.crashreporter.handler.c.a.MODULE;
    private final String t = ".base";

    public a(Context context, com.alibaba.sdk.android.man.crashreporter.c cVar) {
        this.environment = null;
        this.f4710a = context;
        this.environment = cVar;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    public void a(BaseDataContent baseDataContent) throws Throwable {
        if (baseDataContent == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.g("base data object is null!");
            return;
        }
        File dir = this.f4710a.getDir("tombstone", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (dir.canWrite()) {
            try {
                com.alibaba.sdk.android.man.crashreporter.d.a.a.a(baseDataContent, new File(String.format("%s/%s%s", dir, com.alibaba.sdk.android.man.crashreporter.handler.c.a.MODULE, ".base")));
                com.alibaba.sdk.android.man.crashreporter.b.a.e("base data succ");
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("base data write error.", e2);
            }
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    public void b(boolean z) throws Throwable {
        BaseDataContent baseDataContentA;
        if (!z || (baseDataContentA = a()) == null) {
            return;
        }
        baseDataContentA.hashCode = null;
        baseDataContentA.path = null;
        baseDataContentA.times = 0;
        a(baseDataContentA);
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    public String h() throws Throwable {
        try {
            BaseDataContent baseDataContentA = a();
            if (baseDataContentA != null) {
                String str = baseDataContentA.userNick;
                if (str != null) {
                    return str;
                }
            }
            return "";
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("get local user nick err!", e2);
            return "";
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0072: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent a() throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r6.f4710a     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            java.lang.String r3 = "tombstone"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            java.lang.String r3 = "%s/%s%s"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            java.lang.String r2 = r2.getPath()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            r4[r0] = r2     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            r2 = 1
            java.lang.String r5 = "crashreporter"
            r4[r2] = r5     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            r2 = 2
            java.lang.String r5 = ".base"
            r4[r2] = r5     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            java.lang.String r2 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            if (r2 == 0) goto L4b
            boolean r2 = r3.isFile()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            if (r2 == 0) goto L4b
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.FileNotFoundException -> L5f
            java.lang.Object r3 = com.alibaba.sdk.android.man.crashreporter.d.a.a.a(r2)     // Catch: java.lang.Exception -> L49 java.io.FileNotFoundException -> L60 java.lang.Throwable -> L71
            if (r3 == 0) goto L4c
            boolean r4 = r3 instanceof com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent     // Catch: java.lang.Exception -> L49 java.io.FileNotFoundException -> L60 java.lang.Throwable -> L71
            if (r4 == 0) goto L4c
            com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent r3 = (com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent) r3     // Catch: java.lang.Exception -> L49 java.io.FileNotFoundException -> L60 java.lang.Throwable -> L71
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r2)
            return r3
        L49:
            r0 = move-exception
            goto L56
        L4b:
            r2 = r1
        L4c:
            if (r2 == 0) goto L5e
        L4e:
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r2)
            goto L5e
        L52:
            r0 = move-exception
            goto L73
        L54:
            r0 = move-exception
            r2 = r1
        L56:
            java.lang.String r3 = "read base data file error."
            com.alibaba.sdk.android.man.crashreporter.b.a.d(r3, r0)     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L5e
            goto L4e
        L5e:
            return r1
        L5f:
            r2 = r1
        L60:
            java.lang.String r3 = "Trying to load crash report but base data not found."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch: java.lang.Throwable -> L71
            com.alibaba.sdk.android.man.crashreporter.b.a.h(r0)     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L70
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r2)
        L70:
            return r1
        L71:
            r0 = move-exception
            r1 = r2
        L73:
            if (r1 == 0) goto L78
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r1)
        L78:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.crashreporter.d.a.a():com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent");
    }
}
