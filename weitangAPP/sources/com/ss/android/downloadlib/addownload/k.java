package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static int ok(int i2, int i3) {
        return (i3 <= 0 || i3 >= 100 || !ok(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d);
    }

    public static long ok(int i2, long j, long j2) {
        if (!ok(i2)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * ((long) ok(i2, (int) ((j * 100) / j2)))) / 100;
    }

    public static DownloadShortInfo ok(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && ok((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = ok((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("pause_optimise_switch", 0) == 1;
    }
}
