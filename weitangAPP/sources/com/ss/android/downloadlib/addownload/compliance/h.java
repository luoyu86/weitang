package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static void a(String str, long j) {
        ok(str, null, j);
    }

    public static void ok(String str, long j) {
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        if (nVarN.y()) {
            return;
        }
        nVarN.bl.setRefer(str);
        com.ss.android.downloadlib.s.ok.ok().a("lp_app_dialog_click", nVarN);
    }

    public static void ok(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.s.ok.ok().a(str, jSONObject, com.ss.android.downloadlib.addownload.a.kf.ok().n(j));
    }

    public static void ok(String str, com.ss.android.downloadlib.addownload.a.n nVar) {
        com.ss.android.downloadlib.s.ok.ok().a(str, nVar);
    }

    public static void ok(int i2, com.ss.android.downloadlib.addownload.a.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("lp_compliance_error", jSONObject, nVar);
    }

    public static void ok(int i2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.a.kf.ok().n(j));
    }
}
