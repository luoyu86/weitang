package com.alibaba.mtl.appmonitor.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a<JSONObject> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.alibaba.mtl.appmonitor.a.f f4503e;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4504q;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public Map<String, h> f49q;

    public g(com.alibaba.mtl.appmonitor.a.f fVar, int i2) {
        super(i2);
        this.f4504q = -1;
        this.f4503e = fVar;
        this.f49q = Collections.synchronizedMap(new HashMap());
    }

    public boolean a(int i2, String str, String str2, Map<String, String> map) {
        h hVar;
        Map<String, h> map2 = this.f49q;
        return (map2 == null || (hVar = map2.get(str)) == null) ? i2 < this.n : hVar.a(i2, str2, map);
    }

    public void b(JSONObject jSONObject) {
        a(jSONObject);
        c(jSONObject);
        this.f49q.clear();
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("metrics");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    String strOptString = jSONObject2.optString("module");
                    if (com.alibaba.mtl.appmonitor.f.b.c(strOptString)) {
                        h hVar = this.f49q.get(strOptString);
                        if (hVar == null) {
                            hVar = new h(strOptString, this.n);
                            this.f49q.put(strOptString, hVar);
                        }
                        hVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void c(JSONObject jSONObject) {
        com.alibaba.mtl.appmonitor.a.f fVar;
        com.alibaba.mtl.log.d.i.a("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("cacheCount");
            if (iOptInt <= 0 || (fVar = this.f4503e) == null) {
                return;
            }
            fVar.b(iOptInt);
        } catch (Throwable th) {
            com.alibaba.mtl.log.d.i.a("EventTypeSampling", "updateTriggerCount", th);
        }
    }

    public void setSampling(int i2) {
        this.n = i2;
    }
}
