package com.alibaba.mtl.log.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.mtl.log.d.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f4532a = new d();
    private String W;
    private Map<String, c> u = Collections.synchronizedMap(new HashMap());

    public static d a() {
        return f4532a;
    }

    public void b(String str) {
        JSONObject jSONObject;
        i.a("HostConfigMgr", "host config:" + str);
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject(DispatchConstants.HOSTS)) != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null) {
                            c cVar = new c();
                            JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                            if (jSONObject4 != null) {
                                cVar.V = next.substring(1);
                                cVar.U = jSONObject4.getString("host");
                                JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                if (jSONArray != null) {
                                    cVar.f4531a = new ArrayList<>();
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        cVar.f4531a.add(jSONArray.getString(i2));
                                    }
                                }
                            }
                            this.u.put(cVar.V + "", cVar);
                        }
                    }
                }
                this.W = jSONObject2.getString(com.alipay.sdk.m.t.a.k);
            } catch (Throwable unused) {
            }
        }
    }

    public Map<String, c> b() {
        return this.u;
    }
}
