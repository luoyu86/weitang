package com.alipay.sdk.m.p;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alipay.sdk.m.o.a;
import com.alipay.sdk.m.u.m;
import com.alipay.sdk.m.u.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5561c = "msp-gzip";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5562d = "Msp-Param";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5563e = "Operation-Type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5564f = "content-type";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5565g = "Version";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5566h = "AppId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5567i = "des-mode";
    public static final String j = "namespace";
    public static final String k = "api_name";
    public static final String l = "api_version";
    public static final String m = "data";
    public static final String n = "params";
    public static final String o = "public_key";
    public static final String p = "device";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5568q = "action";
    public static final String r = "type";
    public static final String s = "method";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5569a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5570b = true;

    public Map<String, String> a(boolean z, String str) {
        HashMap map = new HashMap();
        map.put(f5561c, String.valueOf(z));
        map.put(f5563e, "alipay.msp.cashier.dispatch.bytes");
        map.put(f5564f, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        map.put("Version", "2.0");
        map.put(f5566h, "TAOBAO");
        map.put(f5562d, a.a(str));
        map.put(f5567i, "CBC");
        return map;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public abstract boolean c();

    public String a(com.alipay.sdk.m.s.a aVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put(p, Build.MODEL);
        map.put("namespace", "com.alipay.mobilecashier");
        map.put(k, "com.alipay.mcpay");
        map.put(l, b());
        return a(aVar, map, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(s, str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(com.alipay.sdk.m.s.a aVar, String str, JSONObject jSONObject) {
        com.alipay.sdk.m.s.b bVarD = com.alipay.sdk.m.s.b.d();
        com.alipay.sdk.m.t.a aVarA = com.alipay.sdk.m.t.a.a(bVarD.b());
        JSONObject jSONObjectA = com.alipay.sdk.m.u.d.a(new JSONObject(), jSONObject);
        try {
            jSONObjectA.put(com.alipay.sdk.m.l.b.f5449d, str);
            jSONObjectA.put("tid", aVarA.d());
            jSONObjectA.put(com.alipay.sdk.m.l.b.f5447b, bVarD.a().a(aVar, aVarA, c()));
            jSONObjectA.put(com.alipay.sdk.m.l.b.f5450e, n.a(aVar, bVarD.b(), com.alipay.sdk.m.j.a.f5387d, false));
            jSONObjectA.put(com.alipay.sdk.m.l.b.f5451f, n.h(bVarD.b()));
            jSONObjectA.put(com.alipay.sdk.m.l.b.f5453h, com.alipay.sdk.m.l.a.f5442g);
            jSONObjectA.put("utdid", bVarD.c());
            jSONObjectA.put(com.alipay.sdk.m.l.b.j, aVarA.c());
            jSONObjectA.put(com.alipay.sdk.m.l.b.k, com.alipay.sdk.m.m.b.b(bVarD.b()));
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BodyErr", th);
            com.alipay.sdk.m.u.e.a(th);
        }
        return jSONObjectA.toString();
    }

    public static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, f5561c)).booleanValue();
    }

    public static String a(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f5548a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String strOptString = jSONObject.getJSONObject("params").optString(o, null);
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            com.alipay.sdk.m.m.b.a(strOptString);
            return true;
        } catch (JSONException e2) {
            com.alipay.sdk.m.u.e.a(e2);
            return false;
        }
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context) throws Throwable {
        return a(aVar, context, "");
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, m.b(context));
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2) throws Throwable {
        return a(aVar, context, str, str2, true);
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "Packet: " + str2);
        c cVar = new c(this.f5570b);
        b bVar = new b(a(aVar), a(aVar, str, a()));
        Map<String, String> mapA = a(false, str);
        d dVarA = cVar.a(bVar, this.f5569a, mapA.get("iSr"));
        a.b bVarA = com.alipay.sdk.m.o.a.a(context, new a.C0085a(str2, a(dVarA.b(), str), dVarA.a()));
        if (bVarA != null) {
            b bVarA2 = cVar.a(new d(a(bVarA), bVarA.f5550c), mapA.get("iSr"));
            return (bVarA2 != null && a(bVarA2.b()) && z) ? a(aVar, context, str, str2, false) : bVarA2;
        }
        throw new RuntimeException("Response is null.");
    }
}
