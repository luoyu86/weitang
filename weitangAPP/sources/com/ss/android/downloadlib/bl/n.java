package com.ss.android.downloadlib.bl;

import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n implements com.ss.android.socialbase.downloader.s.bl {
    @Override // com.ss.android.socialbase.downloader.s.bl
    public void a(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ok.a aVarOk;
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.s.ok.ok().ok(str, jSONObject, aVarOk);
    }

    @Override // com.ss.android.socialbase.downloader.s.bl
    public void ok(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ok.a aVarOk;
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = j.ok(jSONObject);
            com.ss.android.downloadlib.ok.ok(jSONObject, downloadInfo);
            j.ok(jSONObject, "model_id", Long.valueOf(aVarOk.a()));
        }
        com.ss.android.downloadlib.s.ok.ok().a(str, jSONObject, aVarOk);
    }
}
