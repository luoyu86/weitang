package com.alibaba.mtl.appmonitor.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends JSONObject> {
    public int n;

    public a(int i2) {
        this.n = i2;
    }

    public void a(T t) {
        try {
            Integer numValueOf = Integer.valueOf(t.getInt("sampling"));
            if (numValueOf != null) {
                this.n = numValueOf.intValue();
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(int i2) {
        return i2 < this.n;
    }
}
