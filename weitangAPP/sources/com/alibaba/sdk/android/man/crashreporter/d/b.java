package com.alibaba.sdk.android.man.crashreporter.d;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.e.e;
import com.alibaba.sdk.android.man.crashreporter.e.f;
import com.alibaba.sdk.android.man.crashreporter.e.i;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {
    private final String TOMBSTONE_PATH = "tombstone";
    private final String MOTU_PATH = "motu";
    private final String t = ".stacktrace";
    private final String u = "-waitsend";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4712a = null;

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public BaseDataContent a() {
        return null;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public void a(BaseDataContent baseDataContent) {
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public String[] a(int i2) {
        Context context = this.f4712a;
        if (context == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.h("Trying to load crash report but context is null.");
            return null;
        }
        if (i2 == 0 || i2 == 2) {
            return com.alibaba.sdk.android.man.crashreporter.d.a.a.a(context, "tombstone");
        }
        if (i2 == 1) {
            return com.alibaba.sdk.android.man.crashreporter.d.a.a.a(this.f4712a, String.format("%s/%s", context.getDir("tombstone", 0).getAbsolutePath(), "motu"), ".stacktrace");
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public CrashReportDataForSave b(String str) throws Throwable {
        String str2;
        FileInputStream fileInputStream;
        Context context = this.f4712a;
        FileInputStream fileInputStream2 = null;
        if (context == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.h("Trying to load crash report but context is null.");
            return null;
        }
        try {
            try {
                str2 = context.getDir("tombstone", 0).getPath() + "/" + str;
                try {
                    fileInputStream = new FileInputStream(new File(str2));
                } catch (Exception unused) {
                    fileInputStream = null;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused2) {
            str2 = null;
            fileInputStream = null;
        }
        try {
            try {
                Object objA = com.alibaba.sdk.android.man.crashreporter.d.a.a.a(fileInputStream);
                if (!(objA instanceof CrashReportDataForSave)) {
                    f.a(fileInputStream);
                    return null;
                }
                CrashReportDataForSave crashReportDataForSave = (CrashReportDataForSave) objA;
                f.a(fileInputStream);
                return crashReportDataForSave;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
            }
        } catch (Exception unused3) {
            com.alibaba.sdk.android.man.crashreporter.b.a.h(String.format("Trying to load crash report but file:%s not found.", str2));
            if (str2 != null) {
                e.i(str2);
            }
            if (fileInputStream != null) {
                f.a(fileInputStream);
            }
            return null;
        }
        th = th2;
        fileInputStream2 = fileInputStream;
        if (fileInputStream2 != null) {
            f.a(fileInputStream2);
        }
        throw th;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public void b(boolean z) {
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public boolean c(Context context) {
        try {
            this.f4712a = context;
            return true;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("init storer err", e2);
            return false;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public String h() {
        return "";
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public String i() {
        File dir = this.f4712a.getDir("tombstone", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (dir.canWrite()) {
            return dir.getPath();
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public String j() {
        return ".stacktrace";
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public boolean a(CrashReportDataForSave crashReportDataForSave, int i2) {
        String str = crashReportDataForSave.path;
        if (str == null && i2 == 1) {
            return true;
        }
        if (i.a((CharSequence) str)) {
            return false;
        }
        String str2 = crashReportDataForSave.path;
        File file = new File(str2);
        if (!file.exists()) {
            file = new File(str2 + "-waitsend");
            if (file.exists() && file.isFile()) {
                crashReportDataForSave.path = str2 + "-waitsend";
                com.alibaba.sdk.android.man.crashreporter.b.a.e("file exists!");
                return true;
            }
        }
        if (file.exists() && file.isFile()) {
            String str3 = str2 + "-waitsend";
            if (file.renameTo(new File(str3))) {
                crashReportDataForSave.path = str3;
                com.alibaba.sdk.android.man.crashreporter.b.a.e("file exists!");
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public void b(CrashReportDataForSave crashReportDataForSave) throws Throwable {
        if (this.f4712a == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.h("Trying to load crash report but context is null.");
            return;
        }
        try {
            File fileA = a(crashReportDataForSave.fileName);
            if (fileA != null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.b("save crash file: ", fileA.getAbsolutePath());
                com.alibaba.sdk.android.man.crashreporter.d.a.a.a(crashReportDataForSave, fileA);
                com.alibaba.sdk.android.man.crashreporter.b.a.e("save crash file succ ");
            } else {
                com.alibaba.sdk.android.man.crashreporter.b.a.h("store crash report file failure!");
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("crash data save error.", e2);
        }
    }

    private File a(String str) {
        File dir = this.f4712a.getDir("tombstone", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!dir.canWrite()) {
            return null;
        }
        try {
            return new File(str.contains(".stacktrace") ? String.format("%s/%s", dir.getPath(), str) : String.format("%s/%s%s", dir.getPath(), str, ".stacktrace"));
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("data build error.", e2);
            return null;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    public String a(long j) {
        return String.format("%s_%s", Integer.toString(i.a(i.a(com.alibaba.sdk.android.man.crashreporter.e.a.a(this.f4712a), ""))), Long.valueOf(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    @Override // com.alibaba.sdk.android.man.crashreporter.d.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave a(java.lang.String r5, int r6) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L75
            int r1 = r5.length()
            if (r1 != 0) goto Lb
            goto L75
        Lb:
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r5 = r1.exists()
            if (r5 == 0) goto L74
            boolean r5 = r1.isFile()
            if (r5 == 0) goto L74
            boolean r5 = r1.canRead()
            if (r5 == 0) goto L74
            boolean r5 = r1.canWrite()
            if (r5 == 0) goto L74
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3f java.io.FileNotFoundException -> L41
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L3f java.io.FileNotFoundException -> L41
            java.lang.Object r2 = com.alibaba.sdk.android.man.crashreporter.d.a.a.a(r5)     // Catch: java.io.FileNotFoundException -> L42 java.lang.Throwable -> L6c
            boolean r3 = r2 instanceof com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave     // Catch: java.io.FileNotFoundException -> L42 java.lang.Throwable -> L6c
            if (r3 == 0) goto L3b
            com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave r2 = (com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave) r2     // Catch: java.io.FileNotFoundException -> L42 java.lang.Throwable -> L6c
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r5)
            goto L54
        L3b:
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r5)
            return r0
        L3f:
            r6 = move-exception
            goto L6e
        L41:
            r5 = r0
        L42:
            java.lang.String r2 = "Trying to load deduplication crash report but file not found."
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6c
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch: java.lang.Throwable -> L6c
            com.alibaba.sdk.android.man.crashreporter.b.a.h(r2)     // Catch: java.lang.Throwable -> L6c
            if (r5 == 0) goto L53
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r5)
        L53:
            r2 = r0
        L54:
            if (r2 == 0) goto L74
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L65
            r2.times = r5     // Catch: java.lang.Exception -> L65
            com.alibaba.sdk.android.man.crashreporter.d.a.a.a(r2, r1)     // Catch: java.lang.Exception -> L65
            java.lang.String r5 = "save deduplication file succ "
            com.alibaba.sdk.android.man.crashreporter.b.a.e(r5)     // Catch: java.lang.Exception -> L65
            return r2
        L65:
            r5 = move-exception
            java.lang.String r6 = "deduplicationFile build error."
            com.alibaba.sdk.android.man.crashreporter.b.a.d(r6, r5)
            goto L74
        L6c:
            r6 = move-exception
            r0 = r5
        L6e:
            if (r0 == 0) goto L73
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r0)
        L73:
            throw r6
        L74:
            return r0
        L75:
            java.lang.String r5 = "load file failure"
            com.alibaba.sdk.android.man.crashreporter.b.a.h(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.crashreporter.d.b.a(java.lang.String, int):com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave");
    }
}
