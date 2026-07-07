package com.ss.android.downloadlib.addownload.s;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k implements q {
    private boolean a(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(com.ss.android.downloadad.api.ok.a aVar, int i2, p pVar) {
        if (aVar == null || !a(aVar.zz())) {
            return false;
        }
        if (System.currentTimeMillis() - aVar.qx() > ok(aVar.zz())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
        return true;
    }

    private long ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("pause_optimise_mistake_click_interval", 300);
    }
}
