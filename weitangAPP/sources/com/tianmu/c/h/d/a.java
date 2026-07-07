package com.tianmu.c.h.d;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.c.i.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f11641d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.tianmu.c.h.a.c> f11642a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, com.tianmu.c.h.a.b> f11643b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f11644c = new ArrayList();

    private a() {
    }

    public static a c() {
        if (f11641d == null) {
            synchronized (a.class) {
                if (f11641d == null) {
                    f11641d = new a();
                }
            }
        }
        return f11641d;
    }

    private String e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "TianmuApk_" + str + ".apk";
        }
        return "TianmuApk_" + str2 + ".apk";
    }

    public String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public List<String> b() {
        return this.f11644c;
    }

    public void d(String str, String str2) {
        com.tianmu.c.h.a.b bVar = this.f11643b.get(str);
        if (bVar != null) {
            bVar.b(str2);
        }
    }

    public com.tianmu.c.h.a.c a(String str, String str2, String str3, String str4, String str5) {
        String strE = e(str, str3);
        com.tianmu.c.h.a.a aVar = new com.tianmu.c.h.a.a(strE, str2, str3, str4, str5);
        this.f11642a.put(strE, aVar);
        return aVar;
    }

    public com.tianmu.c.h.a.c b(String str, String str2) {
        return this.f11642a.get(e(str, str2));
    }

    public com.tianmu.c.h.a.b b(String str) {
        return this.f11643b.get(str);
    }

    public void a(com.tianmu.c.i.c cVar, j jVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.u()) || this.f11643b.get(cVar.u()) != null) {
            return;
        }
        com.tianmu.c.h.a.b bVar = new com.tianmu.c.h.a.b();
        bVar.c(cVar.u());
        bVar.e(cVar.y());
        bVar.d(cVar.getAppName());
        bVar.a(cVar.getAppIconUrl());
        bVar.f(cVar.getDeepLinkUrl());
        bVar.a(cVar.n());
        bVar.a(jVar);
        bVar.e(cVar.r());
        bVar.b(cVar.q());
        bVar.c(cVar.x());
        bVar.d(cVar.o());
        this.f11643b.put(cVar.u(), bVar);
    }

    public void c(String str, String str2) {
        this.f11642a.remove(e(str, str2));
    }

    public Map<String, com.tianmu.c.h.a.c> a() {
        return this.f11642a;
    }

    public void a(String str, String str2) {
        try {
            File file = new File(com.tianmu.c.h.b.a.a(e(str, str2), TianmuSDK.getInstance().getContext()));
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
