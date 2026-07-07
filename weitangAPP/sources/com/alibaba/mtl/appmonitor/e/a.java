package com.alibaba.mtl.appmonitor.e;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.t;
import com.alibaba.mtl.log.model.LogField;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f4507a;

    private a() {
    }

    public static synchronized a a() {
        if (f4507a == null) {
            f4507a = new a();
        }
        return f4507a;
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        i.a(TAG, "[sendToUT]:", " args:", map);
        if (com.alibaba.mtl.log.a.r) {
            com.alibaba.mtl.log.a.a(map.get(LogField.PAGE.toString()), map.get(LogField.EVENTID.toString()), map.get(LogField.ARG1.toString()), map.get(LogField.ARG2.toString()), map.get(LogField.ARG3.toString()), map);
        } else {
            map.put("_fuamf", "yes");
            t.send(map);
        }
    }
}
