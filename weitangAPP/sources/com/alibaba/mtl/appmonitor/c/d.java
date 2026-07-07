package com.alibaba.mtl.appmonitor.c;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class d extends JSONArray implements b {
    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        for (int i2 = 0; i2 < length(); i2++) {
            Object objOpt = opt(i2);
            if (objOpt != null && (objOpt instanceof b)) {
                a.a().a((b) objOpt);
            }
        }
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
    }
}
