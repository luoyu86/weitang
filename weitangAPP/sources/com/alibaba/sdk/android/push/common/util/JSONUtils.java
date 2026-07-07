package com.alibaba.sdk.android.push.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JSONUtils {
    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.get(next);
            map.put(next, jSONObject.get(next).toString());
        }
        return map;
    }
}
