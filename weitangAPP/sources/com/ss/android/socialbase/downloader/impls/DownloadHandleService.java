package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadHandleService extends Service {
    private static final String ok = DownloadHandleService.class.getSimpleName();

    private void ok(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
            com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.ss.android.socialbase.downloader.downloader.s.ok().t(intExtra);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
            com.ss.android.socialbase.downloader.downloader.s.ok().x(intExtra);
        } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
            com.ss.android.socialbase.downloader.downloader.bl.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.bl.ok(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        ok(intent);
        return 2;
    }
}
