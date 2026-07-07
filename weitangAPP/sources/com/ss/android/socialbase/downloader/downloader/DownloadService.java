package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10019a = DownloadService.class.getSimpleName();
    public t ok;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f10019a;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.ok != null);
        com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
        t tVar = this.ok;
        if (tVar != null) {
            return tVar.ok(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        bl.ok(this);
        t tVarEp = bl.ep();
        this.ok = tVarEp;
        tVarEp.ok(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(f10019a, "Service onDestroy");
        }
        t tVar = this.ok;
        if (tVar != null) {
            tVar.s();
            this.ok = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i2, final int i3) {
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(f10019a, "DownloadService onStartCommand");
        }
        this.ok.bl();
        ExecutorService executorServiceJ = bl.j();
        if (executorServiceJ != null) {
            executorServiceJ.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    t tVar = DownloadService.this.ok;
                    if (tVar != null) {
                        tVar.ok(intent, i2, i3);
                    }
                }
            });
        }
        return bl.k() ? 2 : 3;
    }
}
