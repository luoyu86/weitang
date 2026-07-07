package com.ss.android.socialbase.appdownloader.n;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.ss.android.socialbase.downloader.depend.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9942a;
    private String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.ok f9943h;
    private String kf;
    private String n;
    private Context ok;
    private String s;

    public a(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.ok = context.getApplicationContext();
        } else {
            this.ok = com.ss.android.socialbase.downloader.downloader.bl.l();
        }
        this.f9942a = i2;
        this.bl = str;
        this.s = str2;
        this.n = str3;
        this.kf = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.s
    public com.ss.android.socialbase.downloader.notification.ok ok() {
        Context context;
        com.ss.android.socialbase.downloader.notification.ok okVar = this.f9943h;
        return (okVar != null || (context = this.ok) == null) ? okVar : new ok(context, this.f9942a, this.bl, this.s, this.n, this.kf);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.ok == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.ok == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.kf.a.ok(downloadInfo);
        }
    }

    public a(com.ss.android.socialbase.downloader.notification.ok okVar) {
        this.ok = com.ss.android.socialbase.downloader.downloader.bl.l();
        this.f9943h = okVar;
    }
}
