package com.alibaba.mtl.appmonitor.c;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends JSONObject implements b {
    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        Iterator<String> itKeys = keys();
        if (itKeys != null) {
            while (itKeys.hasNext()) {
                try {
                    Object obj = get(itKeys.next());
                    if (obj != null && (obj instanceof b)) {
                        a.a().a((b) obj);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
    }
}
