package com.alipay.sdk.m.b0;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        synchronized (a.class) {
            String strB = null;
            if (context != null) {
                try {
                    if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2)) {
                        try {
                            String strA = e.a(context, str, str2, "");
                            if (com.alipay.sdk.m.z.a.a(strA)) {
                                return null;
                            }
                            strB = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), strA);
                        } catch (Throwable unused) {
                        }
                        return strB;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2) || context == null) {
                return;
            }
            try {
                String strA = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3);
                HashMap map = new HashMap();
                map.put(str2, strA);
                e.a(context, str, map);
            } catch (Throwable unused) {
            }
        }
    }
}
