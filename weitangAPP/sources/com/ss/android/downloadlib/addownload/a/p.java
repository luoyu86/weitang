package com.ss.android.downloadlib.addownload.a;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static volatile p ok;

    private p() {
    }

    public static p ok() {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new p();
                }
            }
        }
        return ok;
    }

    public void ok(int i2, int i3, com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz());
        if (okVarOk.ok("report_api_hijack", 0) == 0) {
            return;
        }
        int i4 = i3 - i2;
        if (i2 <= 0 || i4 <= okVarOk.ok("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i4);
            jSONObject.put("installed_version_code", i3);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("api_hijack", jSONObject, aVar);
    }
}
