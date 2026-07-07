package com.alibaba.mtl.appmonitor.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    public int count;
    public double value;

    public synchronized void a(double d2) {
        this.value += d2;
        this.count++;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public synchronized void fill(Object... objArr) {
        super.fill(objArr);
        this.value = 0.0d;
        this.count = 0;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        jSONObjectA = super.a();
        try {
            jSONObjectA.put("count", this.count);
            jSONObjectA.put(com.alipay.sdk.m.p0.b.f5579d, this.value);
        } catch (Exception unused) {
        }
        return jSONObjectA;
    }
}
