package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;

/* JADX INFO: loaded from: classes2.dex */
public class p extends com.ss.android.socialbase.downloader.downloader.ok {
    private static final String n = "p";

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void bl() {
        if (com.ss.android.socialbase.downloader.q.ok.ok(262144)) {
            this.f10036a = true;
            this.s = false;
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(n, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void ok(Intent intent, int i2, int i3) {
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(n, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.q.ok.ok(262144)) {
            this.f10036a = true;
        }
        n();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) DownloadService.class));
        this.f10036a = false;
    }
}
