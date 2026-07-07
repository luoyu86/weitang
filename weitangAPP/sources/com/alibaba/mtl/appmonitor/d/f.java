package com.alibaba.mtl.appmonitor.d;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends g {
    public String TAG;
    private int o;
    private int p;

    public f(com.alibaba.mtl.appmonitor.a.f fVar, int i2) {
        super(fVar, i2);
        this.TAG = "AlarmSampling";
        this.o = 0;
        this.p = 0;
        this.o = i2;
        this.p = i2;
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public /* bridge */ /* synthetic */ boolean a(int i2, String str, String str2, Map map) {
        return super.a(i2, str, str2, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        c(jSONObject);
        ((g) this).f49q.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("module");
                    if (com.alibaba.mtl.appmonitor.f.b.c(string)) {
                        h dVar = ((g) this).f49q.get(string);
                        if (dVar == null) {
                            dVar = new d(string, this.o, this.p);
                            ((g) this).f49q.put(string, dVar);
                        }
                        dVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void setSampling(int i2) {
        super.setSampling(i2);
        this.o = i2;
        this.p = i2;
    }

    public boolean a(int i2, String str, String str2, Boolean bool, Map<String, String> map) {
        h hVar;
        com.alibaba.mtl.log.d.i.a(this.TAG, "samplingSeed:", Integer.valueOf(i2), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:" + this.p);
        Map<String, h> map2 = ((g) this).f49q;
        return (map2 == null || (hVar = map2.get(str)) == null || !(hVar instanceof d)) ? bool.booleanValue() ? i2 < this.o : i2 < this.p : ((d) hVar).a(i2, str2, bool, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.a
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i2 = this.n;
        this.o = i2;
        this.p = i2;
        try {
            Integer numValueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (numValueOf != null) {
                this.o = numValueOf.intValue();
            }
            Integer numValueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (numValueOf2 != null) {
                this.p = numValueOf2.intValue();
            }
        } catch (Exception unused) {
        }
    }
}
