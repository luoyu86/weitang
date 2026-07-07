package com.alipay.sdk.m.n0;

import android.content.Context;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f5531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f5532b = new Object();

    public static long a(b bVar) {
        if (bVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", bVar.c(), bVar.d(), Long.valueOf(bVar.a()), bVar.e(), bVar.b());
        if (com.alipay.sdk.m.l0.f.m66a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static synchronized b b(Context context) {
        b bVar = f5531a;
        if (bVar != null) {
            return bVar;
        }
        if (context == null) {
            return null;
        }
        b bVarA = a(context);
        f5531a = bVarA;
        return bVarA;
    }

    public static b a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (f5532b) {
            String strB = d.a(context).b();
            if (com.alipay.sdk.m.l0.f.m66a(strB)) {
                return null;
            }
            if (strB.endsWith("\n")) {
                strB = strB.substring(0, strB.length() - 1);
            }
            b bVar = new b();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = com.alipay.sdk.m.l0.d.a(context);
            String strB2 = com.alipay.sdk.m.l0.d.b(context);
            bVar.c(strA);
            bVar.a(strA);
            bVar.b(jCurrentTimeMillis);
            bVar.b(strB2);
            bVar.d(strB);
            bVar.a(a(bVar));
            return bVar;
        }
    }
}
