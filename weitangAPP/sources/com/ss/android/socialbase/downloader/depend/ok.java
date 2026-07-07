package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ok extends AbsDownloadListener implements zz {
    private static final String ok = "ok";

    public void ok(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.bl.ok.ok() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
