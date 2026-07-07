package com.alipay.apmobilesecuritysdk.b;

import com.alipay.sdk.m.d0.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f5140b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5141a = 0;

    public static a a() {
        return f5140b;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public final void a(int i2) {
        this.f5141a = i2;
    }

    public final int b() {
        return this.f5141a;
    }

    public final String c() {
        String str;
        String strA = d.a();
        if (com.alipay.sdk.m.z.a.b(strA)) {
            return strA;
        }
        int i2 = this.f5141a;
        if (i2 == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else {
            if (i2 == 2) {
                return "https://mobilegwpre.alipay.com/mgw.htm";
            }
            if (i2 == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else {
                if (i2 != 4) {
                    return "https://mobilegw.alipay.com/mgw.htm";
                }
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a("http", str);
    }
}
