package com.ss.android.downloadlib.kf;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements k {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.ok okVar) {
        com.ss.android.downloadad.api.ok.a aVarOk = kf.ok().ok(downloadInfo);
        boolean zOk = com.ss.android.downloadlib.a.kf.ok(aVarOk);
        boolean zA = com.ss.android.downloadlib.a.kf.a(aVarOk);
        if (zOk && zA) {
            com.ss.android.downloadlib.a.bl.ok(aVarOk, new com.ss.android.downloadlib.guide.install.ok() { // from class: com.ss.android.downloadlib.kf.ok.3
                @Override // com.ss.android.downloadlib.guide.install.ok
                public void ok() {
                    okVar.ok();
                }
            });
        } else {
            okVar.ok();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.k
    public void ok(DownloadInfo downloadInfo, final q qVar) {
        ok(downloadInfo, new com.ss.android.downloadlib.guide.install.ok() { // from class: com.ss.android.downloadlib.kf.ok.1
            @Override // com.ss.android.downloadlib.guide.install.ok
            public void ok() {
                qVar.ok();
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.ok okVar) {
        com.ss.android.downloadad.api.ok.a aVarOk = kf.ok().ok(downloadInfo);
        if (aVarOk != null && com.ss.android.downloadlib.a.q.ok(aVarOk)) {
            TTDelegateActivity.ok(aVarOk, new com.ss.android.downloadlib.guide.install.ok() { // from class: com.ss.android.downloadlib.kf.ok.2
                @Override // com.ss.android.downloadlib.guide.install.ok
                public void ok() {
                    ok.this.a(downloadInfo, okVar);
                }
            });
        } else {
            a(downloadInfo, okVar);
        }
    }
}
