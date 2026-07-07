package com.alibaba.sdk.android.ams.common.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static Map<String, String> a(Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.put("sign", com.alibaba.sdk.android.ams.common.b.c.a().a(map2, "TMP_SEED_KEY"));
        return map2;
    }
}
