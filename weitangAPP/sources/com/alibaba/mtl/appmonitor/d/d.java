package com.alibaba.mtl.appmonitor.d;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends h {
    private int o;
    private int p;

    public d(String str, int i2, int i3) {
        super(str, 0);
        int i4 = this.n;
        this.o = i4;
        this.p = i4;
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public /* bridge */ /* synthetic */ boolean a(int i2, String str, Map map) {
        return super.a(i2, str, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("monitorPoint");
                    if (com.alibaba.mtl.appmonitor.f.b.c(string)) {
                        i eVar = this.r.get(string);
                        if (eVar == null) {
                            eVar = new e(string, this.o, this.p);
                            this.r.put(string, eVar);
                        }
                        eVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(int i2, String str, Boolean bool, Map<String, String> map) {
        i iVar;
        com.alibaba.mtl.log.d.i.a("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i2), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p));
        Map<String, i> map2 = this.r;
        return (map2 == null || (iVar = map2.get(str)) == null || !(iVar instanceof e)) ? a(i2, bool.booleanValue()) : ((e) iVar).a(i2, bool, map);
    }

    public boolean a(int i2, boolean z) {
        return z ? i2 < this.o : i2 < this.p;
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
            com.alibaba.mtl.log.d.i.a("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", numValueOf, "failSampling");
        } catch (Exception unused) {
        }
    }
}
