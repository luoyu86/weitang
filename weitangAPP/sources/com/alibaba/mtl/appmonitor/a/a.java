package com.alibaba.mtl.appmonitor.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4467f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4468g = 0;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public Map<String, String> f39g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Integer> f4469h;

    public synchronized void a(String str, String str2) {
        if (com.alibaba.mtl.appmonitor.f.b.d(str)) {
            return;
        }
        if (this.f39g == null) {
            this.f39g = new HashMap();
        }
        if (this.f4469h == null) {
            this.f4469h = new HashMap();
        }
        if (com.alibaba.mtl.appmonitor.f.b.c(str2)) {
            int length = 100;
            if (str2.length() <= 100) {
                length = str2.length();
            }
            this.f39g.put(str, str2.substring(0, length));
        }
        if (this.f4469h.containsKey(str)) {
            Map<String, Integer> map = this.f4469h;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            this.f4469h.put(str, 1);
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public synchronized void clean() {
        super.clean();
        this.f4467f = 0;
        this.f4468g = 0;
        Map<String, String> map = this.f39g;
        if (map != null) {
            map.clear();
        }
        Map<String, Integer> map2 = this.f4469h;
        if (map2 != null) {
            map2.clear();
        }
    }

    public synchronized void e() {
        this.f4467f++;
    }

    public synchronized void f() {
        this.f4468g++;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        jSONObjectA = super.a();
        try {
            jSONObjectA.put("successCount", this.f4467f);
            jSONObjectA.put("failCount", this.f4468g);
            if (this.f4469h != null) {
                JSONArray jSONArray = (JSONArray) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
                for (Map.Entry<String, Integer> entry : this.f4469h.entrySet()) {
                    JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.e.class, new Object[0]);
                    String key = entry.getKey();
                    jSONObject.put("errorCode", key);
                    jSONObject.put("errorCount", entry.getValue());
                    if (this.f39g.containsKey(key)) {
                        jSONObject.put(MediationConstant.KEY_ERROR_MSG, this.f39g.get(key));
                    }
                    jSONArray.put(jSONObject);
                }
                jSONObjectA.put("errors", jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObjectA;
    }
}
