package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile f f5376g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f5377h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f5383f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5378a = new a("udid");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f5379b = new a("oaid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f5381d = new a("vaid");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f5380c = new a("aaid");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f5382e = new c();

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(com.alipay.sdk.m.p0.b.f5579d);
                if (columnIndex >= 0) {
                    dVar.f5373a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.f5374b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.f5375c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (f5376g == null) {
            synchronized (f.class) {
                if (f5376g == null) {
                    f5376g = new f();
                }
            }
        }
        return f5376g;
    }

    public static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static void a(String str) {
        if (f5377h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        f5377h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[PHI: r7
  0x0056: PHI (r7v3 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:19:0x0054, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r7 == 0) goto L39
            com.alipay.sdk.m.i0.d r8 = a(r7)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.f5374b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r1 != r2) goto L34
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f5373a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r8 == 0) goto L35
        L34:
            r0 = 1
        L35:
            r7.close()
            return r0
        L39:
            if (r7 == 0) goto L59
            goto L56
        L3c:
            r8 = move-exception
            goto L5a
        L3e:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L3c
            r1.append(r8)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            a(r8)     // Catch: java.lang.Throwable -> L3c
            if (r7 == 0) goto L59
        L56:
            r7.close()
        L59:
            return r0
        L5a:
            if (r7 == 0) goto L5f
            r7.close()
        L5f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.f.a(android.content.Context):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r10, com.alipay.sdk.m.i0.a r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f5367c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r6 = r11.f5367c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            if (r1 == 0) goto L7b
            com.alipay.sdk.m.i0.d r2 = a(r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r0 = r2.f5373a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.a(r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            long r3 = r2.f5375c     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.a(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r3 = r2.f5374b     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.a(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.<init>()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r4 = r11.f5367c     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.append(r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r11 = r11.f5368d     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.append(r11)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            a(r11)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r11 = r2.f5374b     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L8f
            r9.b(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r11 != 0) goto L8f
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L76:
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L8c
        L7b:
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r11 == 0) goto L8f
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L76
        L8c:
            a(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L8f:
            if (r1 == 0) goto Lbb
            goto Lb6
        L92:
            r10 = move-exception
            r0 = r1
            goto Lbc
        L95:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto L9d
        L99:
            r10 = move-exception
            goto Lbc
        L9b:
            r10 = move-exception
            r11 = r0
        L9d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L99
            r1.append(r10)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L99
            a(r10)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lba
            r1 = r0
            r0 = r11
        Lb6:
            r1.close()
            goto Lbb
        Lba:
            r0 = r11
        Lbb:
            return r0
        Lbc:
            if (r0 == 0) goto Lc1
            r0.close()
        Lc1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.f.b(android.content.Context, com.alipay.sdk.m.i0.a):java.lang.String");
    }

    public static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.f5383f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f5383f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.f5366b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final boolean a(Context context, boolean z) {
        if (this.f5382e.a() && !z) {
            return this.f5382e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.f5382e.a() && this.f5382e.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.f5382e.b();
        }
        this.f5382e.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.f5382e.a(zA);
        return zA;
    }
}
