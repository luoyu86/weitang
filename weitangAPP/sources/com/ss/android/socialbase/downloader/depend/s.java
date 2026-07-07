package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends AbsDownloadListener implements zz {
    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.ok okVarN = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
        if (okVarN != null) {
            okVarN.ok(downloadInfo);
        } else {
            com.ss.android.socialbase.downloader.notification.a.ok().ok(ok());
        }
    }

    private void bl(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.ok okVarN = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
            if (okVarN == null) {
                okVarN = ok();
            }
            okVarN.ok(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    private void ok(int i2, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i2 == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.ok okVarN = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
        if (okVarN == null) {
            okVarN = ok();
        }
        okVarN.a(downloadInfo.getTotalBytes());
        if (i2 == -3) {
            okVarN.ok(downloadInfo.getTotalBytes());
        } else {
            okVarN.ok(downloadInfo.getCurBytes());
        }
        okVarN.ok(i2, baseException, z);
    }

    public abstract com.ss.android.socialbase.downloader.notification.ok ok();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        ok(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        ok(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        a(downloadInfo);
        ok(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        bl(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        ok(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        ok(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.zz
    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        ok(11, downloadInfo, null, true);
    }
}
