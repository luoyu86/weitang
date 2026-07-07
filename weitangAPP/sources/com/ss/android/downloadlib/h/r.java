package com.ss.android.downloadlib.h;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static void a(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.r rVarX = com.ss.android.downloadlib.addownload.r.x();
        if (rVarX != null) {
            rVarX.ok(3, str, str2, jSONObject);
        }
    }

    public static void bl(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.r rVarX = com.ss.android.downloadlib.addownload.r.x();
        if (rVarX != null) {
            rVarX.ok(6, str, str2, jSONObject);
        }
    }

    public static void ok(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.r rVarX = com.ss.android.downloadlib.addownload.r.x();
        if (rVarX != null) {
            rVarX.ok(2, str, str2, jSONObject);
        }
    }

    public static void ok(String str, String str2) {
        bl(str, str2, null);
    }

    public static void ok(String str) {
        bl(null, str, null);
    }
}
