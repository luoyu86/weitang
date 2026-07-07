package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f4506a;
    private String A;
    private int r;
    private Map<com.alibaba.mtl.appmonitor.a.f, g> s = new HashMap();

    private j() {
        for (com.alibaba.mtl.appmonitor.a.f fVar : com.alibaba.mtl.appmonitor.a.f.values()) {
            if (fVar == com.alibaba.mtl.appmonitor.a.f.ALARM) {
                this.s.put(fVar, new f(fVar, fVar.e()));
            } else {
                this.s.put(fVar, new g(fVar, fVar.e()));
            }
        }
    }

    public static j a() {
        if (f4506a == null) {
            synchronized (j.class) {
                if (f4506a == null) {
                    f4506a = new j();
                }
            }
        }
        return f4506a;
    }

    public boolean b(com.alibaba.mtl.appmonitor.a.f fVar, String str, String str2, Map<String, String> map) {
        g gVar = this.s.get(fVar);
        if (gVar != null) {
            return gVar.a(this.r, str, str2, map);
        }
        return false;
    }

    public void j() {
        this.r = new Random(System.currentTimeMillis()).nextInt(10000);
    }

    public boolean b(String str, String str2, Boolean bool, Map<String, String> map) {
        g gVar = this.s.get(com.alibaba.mtl.appmonitor.a.f.ALARM);
        if (gVar == null || !(gVar instanceof f)) {
            return false;
        }
        return ((f) gVar).a(this.r, str, str2, bool, map);
    }

    public void b(String str) {
        String str2;
        com.alibaba.mtl.log.d.i.a("SampleRules", "config:", str);
        synchronized (this) {
            if (!com.alibaba.mtl.appmonitor.f.b.d(str) && ((str2 = this.A) == null || !str2.equals(str))) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    for (com.alibaba.mtl.appmonitor.a.f fVar : com.alibaba.mtl.appmonitor.a.f.values()) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(fVar.toString());
                        g gVar = this.s.get(fVar);
                        if (jSONObjectOptJSONObject != null && gVar != null) {
                            com.alibaba.mtl.log.d.i.a(TAG, fVar, jSONObjectOptJSONObject);
                            gVar.b(jSONObjectOptJSONObject);
                        }
                    }
                    this.A = str;
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void a(Context context) {
        j();
    }

    public static boolean a(com.alibaba.mtl.appmonitor.a.f fVar, String str, String str2) {
        return a().b(fVar, str, str2, (Map<String, String>) null);
    }

    public static boolean a(com.alibaba.mtl.appmonitor.a.f fVar, String str, String str2, Map<String, String> map) {
        return a().b(fVar, str, str2, map);
    }

    public static boolean a(String str, String str2, Boolean bool, Map<String, String> map) {
        return a().b(str, str2, bool, map);
    }

    public void a(com.alibaba.mtl.appmonitor.a.f fVar, int i2) {
        g gVar = this.s.get(fVar);
        if (gVar != null) {
            gVar.setSampling(i2);
        }
    }
}
