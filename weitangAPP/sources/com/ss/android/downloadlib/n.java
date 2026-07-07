package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.io;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.x;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;

/* JADX INFO: loaded from: classes2.dex */
public class n implements com.ss.android.download.api.ok {
    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull q qVar) {
        r.ok(qVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull com.ss.android.download.api.config.h hVar) {
        r.ok(hVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull j jVar) {
        r.ok(jVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull com.ss.android.download.api.config.p pVar) {
        r.ok(pVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull k kVar) {
        r.ok(kVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull com.ss.android.download.api.model.ok okVar) {
        r.ok(okVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(String str) {
        r.ok(str);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull final com.ss.android.download.api.config.a aVar) {
        r.ok(aVar);
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.bl() { // from class: com.ss.android.downloadlib.n.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new v() { // from class: com.ss.android.downloadlib.n.2
                private boolean s(DownloadInfo downloadInfo) {
                    io ioVarZz = r.zz();
                    if (ioVarZz == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
                    String strOk = (aVarOk == null || !aVarOk.bl()) ? com.ss.android.downloadlib.addownload.q.ok(downloadInfo) : com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("ad_notification_jump_url", (String) null);
                    if (TextUtils.isEmpty(strOk)) {
                        return false;
                    }
                    return ioVarZz.ok(r.getContext(), strOk);
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean a(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean bl(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
                    if (aVarOk != null) {
                        com.ss.android.downloadlib.a.ok.ok(aVarOk);
                    } else {
                        com.ss.android.downloadlib.h.q.a(r.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.a.ok().kf(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean ok(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
                    if (okVarOk.a("notification_opt_2") != 1) {
                        boolean zS = s(downloadInfo);
                        if (okVarOk.ok("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return zS;
                    }
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.ok(r.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.s.k().a(), Downloader.getInstance(r.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                    }
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.bl.bl());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(x xVar) {
        r.ok(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public void ok() {
        if (!r.o()) {
            com.ss.android.downloadlib.n.bl.ok().ok("ttdownloader init error");
        }
        r.ok(com.ss.android.downloadlib.n.bl.ok());
        try {
            com.ss.android.socialbase.appdownloader.s.k().a(r.ul());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.s.k().ok(ok.ok());
        s.ok().a(new Runnable() { // from class: com.ss.android.downloadlib.n.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.kf.n.ok("");
                if (com.ss.android.socialbase.appdownloader.kf.n.t()) {
                    com.ss.android.socialbase.downloader.downloader.bl.ok(true);
                }
                if (com.ss.android.socialbase.downloader.h.ok.bl().ok("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.kf.kf.ok(r.getContext());
                }
            }
        });
    }
}
