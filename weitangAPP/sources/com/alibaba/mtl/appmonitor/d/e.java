package com.alibaba.mtl.appmonitor.d;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends i {
    private int o;
    private int p;

    public e(String str, int i2, int i3) {
        super(str, 0);
        this.o = i2;
        this.p = i3;
    }

    @Override // com.alibaba.mtl.appmonitor.d.i
    public /* bridge */ /* synthetic */ boolean a(int i2, Map map) {
        return super.a(i2, (Map<String, String>) map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.i
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
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
            com.alibaba.mtl.log.d.i.a("AlarmMonitorPointSampling", "[updateSelfSampling]", jSONObject, "successSampling:", numValueOf, "failSampling", numValueOf2);
        } catch (Exception unused) {
        }
    }

    public boolean a(int i2, Boolean bool, Map<String, String> map) {
        com.alibaba.mtl.log.d.i.a("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i2), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p));
        List<c> list = this.f4505e;
        if (list != null && map != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                Boolean boolA = it.next().a(i2, map);
                if (boolA != null) {
                    return boolA.booleanValue();
                }
            }
        }
        return a(i2, bool.booleanValue());
    }

    public boolean a(int i2, boolean z) {
        return z ? i2 < this.o : i2 < this.p;
    }
}
