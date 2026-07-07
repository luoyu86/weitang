package com.ss.android.socialbase.downloader.q;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("optimize_save_path") == 1;
    }

    public static boolean ok(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("optimize_head_request") == 1;
    }
}
