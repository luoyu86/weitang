package com.alipay.sdk.m.p0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5577b = "VMS_IDLG_SDK_DB";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5578c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5579d = "value";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5580e = "OAID";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5581f = "AAID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5582g = "VAID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5583h = "OAIDSTATUS";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5584i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5585a;

    public b(Context context) {
        this.f5585a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L41
            r1 = 1
            if (r8 == r1) goto L2b
            r1 = 2
            if (r8 == r1) goto L15
            r9 = 4
            if (r8 == r9) goto Le
            r2 = r0
            goto L48
        Le:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L47
        L15:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L47
        L2b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L47
        L41:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L47:
            r2 = r8
        L48:
            android.content.Context r8 = r7.f5585a
            android.content.ContentResolver r1 = r8.getContentResolver()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L6d
            boolean r9 = r8.moveToNext()
            if (r9 == 0) goto L69
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)
            java.lang.String r9 = r8.getString(r9)
            r0 = r9
        L69:
            r8.close()
            goto L74
        L6d:
            java.lang.String r8 = "VMS_IDLG_SDK_DB"
            java.lang.String r9 = "return cursor is null,return"
            android.util.Log.d(r8, r9)
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.p0.b.a(int, java.lang.String):java.lang.String");
    }
}
