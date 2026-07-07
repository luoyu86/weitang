package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9949a = -1;
    public String bl;
    public String n;
    public String ok;
    public String s;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        ok(jSONObject);
        return jSONObject;
    }

    public String ok() {
        return a().toString();
    }

    public void ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.ok);
            jSONObject.put("error_code", String.valueOf(this.f9949a));
            jSONObject.put("error_msg", this.bl);
            jSONObject.put("real_device_plan", this.s);
            jSONObject.put("device_plans", this.n);
        } catch (Throwable unused) {
        }
    }

    public static ok ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ok okVar = new ok();
        try {
            JSONObject jSONObject = new JSONObject(str);
            okVar.n = jSONObject.optString("device_plans", null);
            okVar.s = jSONObject.optString("real_device_plan", null);
            okVar.bl = jSONObject.optString("error_msg", null);
            okVar.ok = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                okVar.f9949a = -1;
            } else {
                okVar.f9949a = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return okVar;
    }
}
