package com.alipay.sdk.m.s;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String A = "act_info";
    public static final String B = "UTF-8";
    public static final String C = "new_external_info==";
    public static final String m = "\"&";
    public static final String n = "&";
    public static final String o = "bizcontext=\"";
    public static final String p = "bizcontext=";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5632q = "\"";
    public static final String r = "appkey";
    public static final String s = "ty";
    public static final String t = "sv";
    public static final String u = "an";
    public static final String v = "setting";
    public static final String w = "av";
    public static final String x = "sdk_start_time";
    public static final String y = "extInfo";
    public static final String z = "ap_link_token";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f5635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5640h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5641i = false;
    public boolean j = false;
    public final ActivityInfo k;
    public final com.alipay.sdk.m.k.b l;

    public a(Context context, String str, String str2) {
        String str3;
        this.f5633a = "";
        this.f5634b = "";
        this.f5635c = null;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        this.l = new com.alipay.sdk.m.k.b(context, zIsEmpty);
        String strB = b(str, this.f5634b);
        this.f5636d = strB;
        this.f5637e = SystemClock.elapsedRealtime();
        this.f5638f = n.g();
        ActivityInfo activityInfoA = n.a(context);
        this.k = activityInfoA;
        this.f5639g = str2;
        if (!zIsEmpty) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "eptyp", str2 + "|" + strB);
            if (activityInfoA != null) {
                str3 = activityInfoA.name + "|" + activityInfoA.launchMode;
            } else {
                str3 = "null";
            }
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "actInfo", str3);
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, NotificationCompat.CATEGORY_SYSTEM, n.a(this));
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "sdkv", "1281fd4-clean");
        }
        try {
            this.f5635c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f5633a = packageInfo.versionName;
            this.f5634b = packageInfo.packageName;
        } catch (Exception e2) {
            e.a(e2);
        }
        if (!zIsEmpty) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "u" + n.g());
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Q, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(context, this, str, this.f5636d);
        }
        if (zIsEmpty || !com.alipay.sdk.m.m.a.D().s()) {
            return;
        }
        com.alipay.sdk.m.m.a.D().a(this, this.f5635c, true, 2);
    }

    private String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(19));
            jSONObject.put("bizcontext", b(jSONObject.optString("bizcontext")));
            return C + jSONObject.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private String e(String str) {
        try {
            String strA = a(str, m, o);
            if (TextUtils.isEmpty(strA)) {
                return str + "&" + a(o, "\"");
            }
            if (!strA.endsWith("\"")) {
                strA = strA + "\"";
            }
            int iIndexOf = str.indexOf(strA);
            return str.substring(0, iIndexOf) + b(strA, o, "\"") + str.substring(iIndexOf + strA.length());
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "fmt2", th, str);
            return str;
        }
    }

    private boolean f(String str) {
        return !str.contains(m);
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z, this.f5636d);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static a h() {
        return null;
    }

    public Context a() {
        return this.f5635c;
    }

    public String b() {
        return this.f5634b;
    }

    public String c() {
        return this.f5633a;
    }

    private String b(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        String strSubstring = str.substring(str2.length());
        boolean z2 = false;
        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - str3.length());
        if (strSubstring2.length() >= 2 && strSubstring2.startsWith("\"") && strSubstring2.endsWith("\"")) {
            jSONObject = new JSONObject(strSubstring2.substring(1, strSubstring2.length() - 1));
            z2 = true;
        } else {
            jSONObject = new JSONObject(strSubstring2);
        }
        String strA = a(jSONObject);
        if (z2) {
            strA = "\"" + strA + "\"";
        }
        return str2 + strA + str3;
    }

    private String c(String str) {
        try {
            String strA = a(str, "&", p);
            if (TextUtils.isEmpty(strA)) {
                str = str + "&" + a(p, "");
            } else {
                int iIndexOf = str.indexOf(strA);
                str = str.substring(0, iIndexOf) + b(strA, p, "") + str.substring(iIndexOf + strA.length());
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "fmt1", th, str);
        }
        return str;
    }

    public String a(String str) {
        return TextUtils.isEmpty(str) ? str : str.startsWith(C) ? d(str) : f(str) ? c(str) : e(str);
    }

    public boolean f() {
        return this.j;
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.s.a$a, reason: collision with other inner class name */
    public static final class C0089a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<UUID, a> f5642a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashMap<String, a> f5643b = new HashMap<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f5644c = "i_uuid_b_c";

        public static void a(a aVar, Intent intent) {
            if (aVar == null || intent == null) {
                return;
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            f5642a.put(uuidRandomUUID, aVar);
            intent.putExtra(f5644c, uuidRandomUUID);
        }

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra(f5644c);
            if (serializableExtra instanceof UUID) {
                return f5642a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static void a(a aVar, String str) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            f5643b.put(str, aVar);
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f5643b.remove(str);
        }
    }

    public boolean d() {
        return this.f5641i;
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(str2);
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (!TextUtils.isEmpty(strArrSplit[i2]) && strArrSplit[i2].startsWith(str3)) {
                return strArrSplit[i2];
            }
        }
        return null;
    }

    private String b(String str) throws JSONException {
        return a(new JSONObject(str));
    }

    public void c(boolean z2) {
        this.j = z2;
    }

    public static String b(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", n.g(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "-";
        }
    }

    public boolean e() {
        return this.f5640h;
    }

    private String a(String str, String str2) {
        return str + a(new JSONObject()) + str2;
    }

    public String a(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", com.alipay.sdk.m.l.a.f5442g);
            }
            if (!jSONObject.has(s)) {
                jSONObject.put(s, "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.8.15");
            }
            if (!jSONObject.has(u)) {
                jSONObject.put(u, this.f5634b);
            }
            if (!jSONObject.has(w)) {
                jSONObject.put(w, this.f5633a);
            }
            if (!jSONObject.has(x)) {
                jSONObject.put(x, System.currentTimeMillis());
            }
            if (!jSONObject.has(y)) {
                jSONObject.put(y, g());
            }
            if (!jSONObject.has(A)) {
                if (this.k != null) {
                    str = this.k.name + "|" + this.k.launchMode;
                } else {
                    str = "null";
                }
                jSONObject.put(A, str);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "fmt3", th, String.valueOf(jSONObject));
            e.a(th);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    public void b(boolean z2) {
        this.f5640h = z2;
    }

    public static HashMap<String, String> a(a aVar) {
        HashMap<String, String> map = new HashMap<>();
        if (aVar != null) {
            map.put("sdk_ver", "15.8.15");
            map.put("app_name", aVar.f5634b);
            map.put("token", aVar.f5636d);
            map.put("call_type", aVar.f5639g);
            map.put("ts_api_invoke", String.valueOf(aVar.f5637e));
            com.alipay.sdk.m.u.a.a(aVar, map);
        }
        return map;
    }

    public void a(boolean z2) {
        this.f5641i = z2;
    }
}
