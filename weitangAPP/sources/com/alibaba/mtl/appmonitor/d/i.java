package com.alibaba.mtl.appmonitor.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends a<JSONObject> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c> f4505e;
    private String p;

    public i(String str, int i2) {
        super(i2);
        this.p = str;
    }

    public boolean a(int i2, Map<String, String> map) {
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
        return a(i2);
    }

    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("extra");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    c cVar = new c(this.n);
                    if (this.f4505e == null) {
                        this.f4505e = new ArrayList();
                    }
                    this.f4505e.add(cVar);
                    cVar.b(jSONObject2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
