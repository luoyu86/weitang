package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5696a = "pref_trade_token";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5697b = ";";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5698c = "result={";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5699d = "}";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5700e = "trade_token=\"";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5701f = "\"";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5702g = "trade_token=";

    public static void a(com.alipay.sdk.m.s.a aVar, Context context, String str) {
        try {
            String strA = a(str);
            e.b(com.alipay.sdk.m.l.a.A, "trade token: " + strA);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            j.b(aVar, context, f5696a, strA);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.I, th);
            e.a(th);
        }
    }

    public static String a(String str) {
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(f5697b);
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (strArrSplit[i2].startsWith(f5698c) && strArrSplit[i2].endsWith(f5699d)) {
                String[] strArrSplit2 = strArrSplit[i2].substring(8, strArrSplit[i2].length() - 1).split("&");
                int i3 = 0;
                while (true) {
                    if (i3 >= strArrSplit2.length) {
                        break;
                    }
                    if (strArrSplit2[i3].startsWith(f5700e) && strArrSplit2[i3].endsWith("\"")) {
                        strSubstring = strArrSplit2[i3].substring(13, strArrSplit2[i3].length() - 1);
                        break;
                    }
                    if (strArrSplit2[i3].startsWith(f5702g)) {
                        strSubstring = strArrSplit2[i3].substring(12);
                        break;
                    }
                    i3++;
                }
            }
        }
        return strSubstring;
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context) {
        String strA = j.a(aVar, context, f5696a, "");
        e.b(com.alipay.sdk.m.l.a.A, "get trade token: " + strA);
        return strA;
    }
}
