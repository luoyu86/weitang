package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.n;
import com.vivo.identifier.IdentifierConstant;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5502d = "virtualImeiAndImsi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5503e = "virtual_imei";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5504f = "virtual_imsi";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile b f5505g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5507b = "sdk-and-lite";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5508c;

    public b() {
        String strA = com.alipay.sdk.m.j.a.a();
        if (com.alipay.sdk.m.j.a.b()) {
            return;
        }
        this.f5507b += '_' + strA;
    }

    public static synchronized b b() {
        if (f5505g == null) {
            f5505g = new b();
        }
        return f5505g;
    }

    public static String c() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = contextB.getSharedPreferences(f5502d, 0);
        String string = sharedPreferences.getString(f5503e, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strC = TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(contextB).d()) ? c() : c.b(contextB).b();
        sharedPreferences.edit().putString(f5503e, strC).apply();
        return strC;
    }

    public static String g() {
        String strC;
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = contextB.getSharedPreferences(f5502d, 0);
        String string = sharedPreferences.getString(f5504f, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(contextB).d())) {
            String strC2 = com.alipay.sdk.m.s.b.d().c();
            strC = (TextUtils.isEmpty(strC2) || strC2.length() < 18) ? c() : strC2.substring(3, 18);
        } else {
            strC = c.b(contextB).c();
        }
        String str = strC;
        sharedPreferences.edit().putString(f5504f, str).apply();
        return str;
    }

    public static String h() {
        return "00";
    }

    public static String i() {
        return IdentifierConstant.OAID_STATE_DEFAULT;
    }

    public String a() {
        return this.f5508c;
    }

    public static synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.f5454i, str).apply();
        com.alipay.sdk.m.l.a.f5441f = str;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(i.f5697b);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.t.a aVar2, boolean z) {
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        c cVarB = c.b(contextB);
        if (TextUtils.isEmpty(this.f5506a)) {
            this.f5506a = "Msp/15.8.15 (" + n.f() + i.f5697b + n.e() + i.f5697b + n.c(contextB) + i.f5697b + n.e(contextB) + i.f5697b + n.f(contextB) + i.f5697b + a(contextB);
        }
        String strB = c.d(contextB).b();
        String strB2 = n.b(contextB);
        String strE = e();
        String strC = cVarB.c();
        String strB3 = cVarB.b();
        String strG = g();
        String strF = f();
        if (aVar2 != null) {
            this.f5508c = aVar2.c();
        }
        String strReplace = Build.MANUFACTURER.replace(i.f5697b, " ");
        String strReplace2 = Build.MODEL.replace(i.f5697b, " ");
        boolean zE = com.alipay.sdk.m.s.b.e();
        String strD = cVarB.d();
        String strI = i();
        String strH = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5506a);
        sb.append(i.f5697b);
        sb.append(strB);
        sb.append(i.f5697b);
        sb.append(strB2);
        sb.append(i.f5697b);
        sb.append(strE);
        sb.append(i.f5697b);
        sb.append(strC);
        sb.append(i.f5697b);
        sb.append(strB3);
        sb.append(i.f5697b);
        sb.append(this.f5508c);
        sb.append(i.f5697b);
        sb.append(strReplace);
        sb.append(i.f5697b);
        sb.append(strReplace2);
        sb.append(i.f5697b);
        sb.append(zE);
        sb.append(i.f5697b);
        sb.append(strD);
        sb.append(i.f5697b);
        sb.append(d());
        sb.append(i.f5697b);
        sb.append(this.f5507b);
        sb.append(i.f5697b);
        sb.append(strG);
        sb.append(i.f5697b);
        sb.append(strF);
        sb.append(i.f5697b);
        sb.append(strI);
        sb.append(i.f5697b);
        sb.append(strH);
        if (aVar2 != null) {
            String strA = com.alipay.sdk.m.w.b.a(aVar, contextB, com.alipay.sdk.m.t.a.a(contextB).d(), com.alipay.sdk.m.w.b.c(aVar, contextB));
            if (!TextUtils.isEmpty(strA)) {
                sb.append(";;;");
                sb.append(strA);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
