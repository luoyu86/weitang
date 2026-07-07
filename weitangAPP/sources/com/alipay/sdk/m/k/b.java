package com.alipay.sdk.m.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String A = "SSLDenied";
    public static final String A0 = "out_trade_no";
    public static final String B = "H5PayDataAnalysisError";
    public static final String B0 = "trade_no";
    public static final String C = "H5AuthDataAnalysisError";
    public static final String C0 = "biz_content";
    public static final String D = "PublicKeyUnmatch";
    public static final String D0 = "app_id";
    public static final String E = "ClientBindFailed";
    public static final String F = "TriDesEncryptError";
    public static final String G = "TriDesDecryptError";
    public static final String H = "ClientBindException";
    public static final String I = "SaveTradeTokenError";
    public static final String J = "ClientBindServiceFailed";
    public static final String K = "TryStartServiceEx";
    public static final String L = "BindWaitTimeoutEx";
    public static final String M = "CheckClientExistEx";
    public static final String N = "CheckClientSignEx";
    public static final String O = "GetInstalledAppEx";
    public static final String P = "ParserTidClientKeyEx";
    public static final String Q = "PgApiInvoke";
    public static final String R = "PgBindStarting";
    public static final String S = "PgBinded";
    public static final String T = "PgBindEnd";
    public static final String U = "PgBindPay";
    public static final String V = "PgReturn";
    public static final String W = "PgReturnV";
    public static final String X = "PgWltVer";
    public static final String Y = "PgOpenStarting";
    public static final String Z = "ErrIntentEx";
    public static final String a0 = "ErrActNull";
    public static final String b0 = "ErrActEx";
    public static final String c0 = "ErrActNull2";
    public static final String d0 = "ErrActEx2";
    public static final String e0 = "ErrActNotCreated";
    public static final String f0 = "GetInstalledAppEx";
    public static final String g0 = "StartLaunchAppTransEx";
    public static final String h0 = "CheckLaunchAppExistEx";
    public static final String i0 = "LogBindCalledH5";
    public static final String j0 = "LogCalledH5";
    public static final String k = "net";
    public static final String k0 = "LogHkLoginByIntent";
    public static final String l = "biz";
    public static final String l0 = "SchemePayWrongHashEx";
    public static final String m = "cp";
    public static final String m0 = "LogAppFetchConfigTimeout";
    public static final String n = "auth";
    public static final String n0 = "H5CbUrlEmpty";
    public static final String o = "third";
    public static final String o0 = "H5CbEx";
    public static final String p = "wlt";
    public static final String p0 = "StartActivityEx";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5421q = "FormatResultEx";
    public static final String q0 = "JSONEx";
    public static final String r = "GetApdidEx";
    public static final String r0 = "ParseBundleSerializableError";
    public static final String s = "GetApdidNull";
    public static final String s0 = "ParseSchemeQueryError";
    public static final String t = "GetApdidTimeout";
    public static final String t0 = "TbChk";
    public static final String u = "GetUtdidEx";
    public static final String u0 = "TbStart";
    public static final String v = "GetPackageInfoEx";
    public static final String v0 = "TbCancel";
    public static final String w = "NotIncludeSignatures";
    public static final String w0 = "TbUnknown";
    public static final String x = "GetPublicKeyFromSignEx";
    public static final String x0 = "TbOk";
    public static final String y = "webError";
    public static final String y0 = "TbActFail";
    public static final String z = "SSLError";
    public static final String z0 = "partner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5429h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5430i = "";
    public String j;

    public b(Context context, boolean z2) {
        context = context != null ? context.getApplicationContext() : context;
        this.f5422a = b();
        this.f5424c = a(context);
        this.f5425d = a(z2 ? 0L : a.e.a(context));
        this.f5426e = a();
        this.f5427f = b(context);
        this.f5428g = "-";
        this.j = "-";
    }

    private synchronized void c(String str, String str2, String str3) {
        e.d(com.alipay.sdk.m.l.a.A, String.format("event %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f5429h)) {
            str4 = "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(str) ? "-" : c(str);
        objArr[1] = c(str2);
        objArr[2] = c(str3);
        objArr[3] = c(c());
        sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.f5429h += sb.toString();
    }

    private boolean d() {
        return TextUtils.isEmpty(this.f5430i);
    }

    public static String e() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    public void a(String str, String str2, Throwable th) {
        d(str, str2, a(th));
    }

    public void b(String str, String str2, String str3) {
        d(str, str2, str3);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        return String.format("%s,%s", e(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    private synchronized void d(String str, String str2, String str3) {
        e.c(com.alipay.sdk.m.l.a.A, String.format("err %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f5430i)) {
            str4 = "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? "-" : c(str3);
        objArr[3] = c(c());
        sb.append(String.format("%s,%s,%s,%s", objArr));
        this.f5430i += sb.toString();
    }

    public void a(String str, String str2, Throwable th, String str3) {
        d(str, str2, str3 + ": " + a(th));
    }

    public static String b(String str) {
        String string;
        String strReplace;
        if (str == null) {
            str = "";
        }
        String[] strArrSplit = str.split("&");
        String strReplace2 = null;
        if (strArrSplit != null) {
            string = null;
            strReplace = null;
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    if (strArrSplit2[0].equalsIgnoreCase("partner")) {
                        strReplace2 = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(A0)) {
                        string = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(B0)) {
                        strReplace = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(C0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(n.e(com.alipay.sdk.m.s.a.h(), strArrSplit2[1]));
                            if (TextUtils.isEmpty(string)) {
                                string = jSONObject.getString(A0);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (strArrSplit2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(strReplace2)) {
                        strReplace2 = strArrSplit2[1];
                    }
                }
            }
        } else {
            string = null;
            strReplace = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", c(strReplace), c(string), c(strReplace2));
    }

    public void a(String str, String str2, String str3) {
        c("", str, str2 + "|" + str3);
    }

    public void a(String str, String str2) {
        c("", str, str2);
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i2 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i2++;
                    if (i2 > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static String c() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", "~").replace("#", "＃");
    }

    public String a(String str) {
        String strB = b(str);
        this.f5423b = strB;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.f5422a, strB, this.f5424c, this.f5425d, this.f5426e, this.f5427f, this.f5428g, d(this.f5429h), d(this.f5430i), this.j);
    }

    public static String a(Context context) {
        String packageName;
        String str = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                    str = packageInfo.versionName + "|" + a(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                packageName = "-";
            }
        } else {
            packageName = "-";
        }
        return String.format("%s,%s,-,-,-", c(packageName), c(str));
    }

    public static String a(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String strSubstring;
        String strA;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                try {
                    strA = n.a((com.alipay.sdk.m.s.a) null, signature.toByteArray());
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(strA)) {
                    strSubstring = "?";
                    sb.append("-");
                    sb.append(strSubstring);
                } else {
                    strSubstring = n.g(strA).substring(0, 8);
                    sb.append("-");
                    sb.append(strSubstring);
                }
            }
            return sb.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    public static String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", c(c.c(context)), DispatchConstants.ANDROID, c(Build.VERSION.RELEASE), c(Build.MODEL), "-", "0", c(c.d(context).b()), "gw", c(com.alipay.sdk.m.w.b.b(null, context)));
    }

    public static String a(long j) {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", c("15.8.15"), c("h.a.3.8.15"), "~" + j);
    }

    public static String a() {
        return String.format("%s,%s,-,-,-", c(com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).d()), c(com.alipay.sdk.m.s.b.d().c()));
    }
}
