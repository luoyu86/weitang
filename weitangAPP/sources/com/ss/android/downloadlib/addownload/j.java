package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j implements td {
    @Override // com.ss.android.socialbase.downloader.downloader.td
    public void ok(DownloadInfo downloadInfo, int i2, int i3) {
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i3));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("pause_reserve_wifi", jSONObject, aVarOk);
    }
}
