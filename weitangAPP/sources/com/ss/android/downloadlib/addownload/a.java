package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f9765a = null;

    public static a ok() {
        if (ok == null) {
            synchronized (a.class) {
                if (ok == null) {
                    ok = new a();
                }
            }
        }
        return ok;
    }

    public boolean a() {
        return r.q().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void ok(Context context, DownloadInfo downloadInfo) {
        if (a() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f9765a == null) {
                this.f9765a = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f9765a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.1
                @Override // java.lang.Runnable
                public void run() {
                    r.bl().ok(3, r.getContext(), null, "下载失败，请重试！", null, 0);
                    n nVarOk = com.ss.android.downloadlib.h.ok().ok(url);
                    if (nVarOk != null) {
                        nVarOk.h();
                    }
                }
            });
        }
    }
}
