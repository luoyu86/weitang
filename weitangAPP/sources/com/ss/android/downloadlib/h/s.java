package com.ss.android.downloadlib.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static String ok(String str, String str2, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z);
            jSONObject.put("business_type", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
