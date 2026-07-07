package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class SqlDownloadCacheService extends Service {
    private static final String ok = SqlDownloadCacheService.class.getSimpleName();

    public static void ok(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(ok, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k kVarM = bl.m();
        u uVarKf = kVarM instanceof com.ss.android.socialbase.downloader.impls.s ? ((com.ss.android.socialbase.downloader.impls.s) kVarM).kf() : kVarM instanceof u ? (u) kVarM : null;
        return uVarKf instanceof IBinder ? (IBinder) uVarKf : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        bl.ok(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int iOnStartCommand = super.onStartCommand(intent, i2, i3);
        if (bl.k()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
