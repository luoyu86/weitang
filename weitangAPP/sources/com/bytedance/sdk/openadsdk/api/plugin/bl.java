package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6346a;
    private long bl;
    private String ok;
    private Map<String, Long> s = new HashMap();

    private bl(String str, long j) {
        this.ok = str;
        this.f6346a = j;
        this.bl = j;
    }

    public static bl ok(String str) {
        return new bl(str, SystemClock.elapsedRealtime());
    }

    public long a(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.bl;
        this.bl = SystemClock.elapsedRealtime();
        this.s.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long ok() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f6346a;
        this.s.put(this.ok, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long a() {
        return this.f6346a;
    }

    public void ok(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.s.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
