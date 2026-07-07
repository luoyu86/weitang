package com.ss.android.downloadlib.bl;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf implements com.ss.android.socialbase.appdownloader.bl.s {
    private Context ok;

    public kf(Context context) {
        this.ok = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(Context context, String str) {
        com.ss.android.downloadlib.ok.ok().ok(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(int i2, int i3, String str, int i4, long j) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.ok.a aVarOk;
        Context context = this.ok;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() == 0 || (aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        if (i3 == 1) {
            com.ss.android.downloadlib.ok.ok(downloadInfo, aVarOk);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.ok.ok().ok(downloadInfo, aVarOk.a(), aVarOk.j(), aVarOk.n(), downloadInfo.getTitle(), aVarOk.s(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i3 == 3) {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_install", com.ss.android.downloadlib.ok.a(new JSONObject(), downloadInfo), aVarOk);
            return;
        }
        if (i3 == 5) {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_pause", aVarOk);
        } else if (i3 == 6) {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_continue", aVarOk);
        } else {
            if (i3 != 7) {
                return;
            }
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_click", aVarOk);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public boolean ok(int i2, boolean z) {
        if (r.t() != null) {
            return r.t().ok(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.h.ok().ok(downloadInfo);
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.s.ok.ok().ok(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        } else {
            com.ss.android.downloadlib.s.ok.ok().a(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(int i2, int i3, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.ok;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.a.ok().ok(this.ok, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public boolean ok() {
        return com.ss.android.downloadlib.addownload.a.ok().a();
    }
}
