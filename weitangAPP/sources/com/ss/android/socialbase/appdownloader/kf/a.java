package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static void a(final DownloadInfo downloadInfo) {
        final Context contextL = com.ss.android.socialbase.downloader.downloader.bl.l();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.bl.a(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iOk = z ? com.ss.android.socialbase.appdownloader.bl.ok(contextL, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.kf.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.bl.s sVarA = com.ss.android.socialbase.appdownloader.s.k().a();
                ep downloadNotificationEventListener = Downloader.getInstance(contextL).getDownloadNotificationEventListener(downloadInfo.getId());
                if (sVarA == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoOk = com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo, file);
                        if (packageInfoOk != null) {
                            String packageName = (iOk == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoOk.packageName : downloadInfo.getPackageName();
                            if (sVarA != null) {
                                sVarA.ok(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.ok(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public static void ok(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }
}
