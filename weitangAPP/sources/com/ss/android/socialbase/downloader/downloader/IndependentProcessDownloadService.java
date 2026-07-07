package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        bl.ok(this);
        if (bl.tr() == null) {
            bl.ok(new ul());
        }
        t tVarVz = bl.vz();
        this.ok = tVarVz;
        tVarVz.ok(new WeakReference(this));
    }
}
