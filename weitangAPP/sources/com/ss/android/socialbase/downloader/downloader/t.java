package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface t<T extends DownloadService> {
    void a(DownloadTask downloadTask);

    boolean a();

    void bl();

    void bl(DownloadTask downloadTask);

    IBinder ok(Intent intent);

    void ok(int i2);

    void ok(int i2, Notification notification);

    void ok(Intent intent, int i2, int i3);

    void ok(rh rhVar);

    void ok(WeakReference<T> weakReference);

    void ok(boolean z);

    boolean ok();

    void s();

    void startService();
}
