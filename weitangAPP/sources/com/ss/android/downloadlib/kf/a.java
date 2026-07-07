package com.ss.android.downloadlib.kf;

import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a implements k {
    @Override // com.ss.android.socialbase.appdownloader.bl.k
    public void ok(DownloadInfo downloadInfo, q qVar) {
        com.ss.android.downloadad.api.ok.a aVarOk;
        if (downloadInfo != null && (aVarOk = kf.ok().ok(downloadInfo)) != null) {
            downloadInfo.setLinkMode(aVarOk.l());
        }
        if (qVar != null) {
            qVar.ok();
        }
    }
}
