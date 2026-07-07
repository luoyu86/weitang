package com.alipay.sdk.m.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5647g = "alipay_tid_storage";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5648h = "tidinfo";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5649i = "tid";
    public static final String j = "client_key";
    public static final String k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;
    public static a o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5655f = false;

    public static synchronized a a(Context context) {
        if (o == null) {
            o = new a();
        }
        if (n == null) {
            o.b(context);
        }
        return o;
    }

    private void b(Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (this.f5655f) {
            return;
        }
        this.f5655f = true;
        l();
    }

    private String k() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = com.alipay.sdk.m.t.a.C0090a.a(r3, r4, r5)     // Catch: java.lang.Exception -> L52
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L52
            if (r4 != 0) goto L4e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L52
            r4.<init>(r3)     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L4b
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L48
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L48
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L48
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L46
            goto L59
        L46:
            r0 = move-exception
            goto L56
        L48:
            r0 = move-exception
            r6 = r2
            goto L56
        L4b:
            r0 = move-exception
            r5 = r2
            goto L55
        L4e:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L5b
        L52:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L55:
            r6 = r5
        L56:
            com.alipay.sdk.m.u.e.a(r0)
        L59:
            r0 = r2
            r2 = r3
        L5b:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            com.alipay.sdk.m.u.e.b(r3, r4)
            boolean r3 = r9.a(r2, r5, r6, r0)
            if (r3 == 0) goto L6c
            r9.m()
            goto L7a
        L6c:
            r9.f5650a = r2
            r9.f5651b = r5
            long r1 = r1.longValue()
            r9.f5652c = r1
            r9.f5653d = r6
            r9.f5654e = r0
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.t.a.l():void");
    }

    private void m() {
        this.f5650a = "";
        this.f5651b = b();
        this.f5652c = System.currentTimeMillis();
        this.f5653d = k();
        this.f5654e = k();
        C0090a.b(f5647g, f5648h);
    }

    private void n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f5650a);
            jSONObject.put(j, this.f5651b);
            jSONObject.put(k, this.f5652c);
            jSONObject.put(l, this.f5653d);
            jSONObject.put(m, this.f5654e);
            C0090a.a(f5647g, f5648h, jSONObject.toString(), true);
        } catch (Exception e2) {
            e.a(e2);
        }
    }

    private void o() {
    }

    public String c() {
        return this.f5651b;
    }

    public String d() {
        return this.f5650a;
    }

    public Long e() {
        return Long.valueOf(this.f5652c);
    }

    public String f() {
        return this.f5653d;
    }

    public String g() {
        return this.f5654e;
    }

    public boolean h() {
        return i();
    }

    public boolean i() {
        return TextUtils.isEmpty(this.f5650a) || TextUtils.isEmpty(this.f5651b) || TextUtils.isEmpty(this.f5653d) || TextUtils.isEmpty(this.f5654e);
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.t.a$a, reason: collision with other inner class name */
    public static class C0090a {
        public static boolean a(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.n == null) {
                return;
            }
            a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean c(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String d(String str, String str2) {
            return a(str, str2, true);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.n == null) {
                return null;
            }
            String string = a.n.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = com.alipay.sdk.m.n.e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    e.b(com.alipay.sdk.m.l.a.A, "tid_str: pref failed");
                }
            }
            e.b(com.alipay.sdk.m.l.a.A, "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.n == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
            if (z) {
                String strA = a();
                String strB = com.alipay.sdk.m.n.e.b(strA, str3, str3);
                if (TextUtils.isEmpty(strB)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strA);
                }
                str3 = strB;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String packageName;
            try {
                packageName = a.n.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                e.a(th);
                packageName = "";
            }
            return (packageName + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public String b() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void a() {
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: del");
        m();
    }

    public void a(String str, String str2) {
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f5650a = str;
        this.f5651b = str2;
        this.f5652c = System.currentTimeMillis();
        n();
        o();
    }

    private void a(String str, String str2, String str3, String str4, Long l2) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.f5650a = str;
        this.f5651b = str2;
        this.f5653d = str3;
        this.f5654e = str4;
        if (l2 == null) {
            this.f5652c = System.currentTimeMillis();
        } else {
            this.f5652c = l2.longValue();
        }
        n();
    }
}
