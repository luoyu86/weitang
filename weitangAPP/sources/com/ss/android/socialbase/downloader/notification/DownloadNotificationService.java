package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.downloader.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p.h;
import com.ss.android.socialbase.downloader.q.kf;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadNotificationService extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile long f10142h;
    private static volatile long kf;
    private static boolean p;
    private h k;
    private final SparseArray<Notification> r = new SparseArray<>(2);
    private static final String ok = DownloadNotificationService.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f10141a = -1;
    private static int bl = -1;
    private static boolean s = true;
    private static boolean n = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f10143q = 900;

    private void s() {
        if (this.k == null) {
            h hVar = new h("DownloaderNotifyThread");
            this.k = hVar;
            hVar.ok();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s();
        bl.ok(this);
        com.ss.android.socialbase.downloader.h.ok okVarBl = com.ss.android.socialbase.downloader.h.ok.bl();
        int iOk = okVarBl.ok("download_service_foreground", 0);
        if ((iOk == 1 || iOk == 3) && f10141a == -1) {
            f10141a = 0;
        }
        if ((iOk == 2 || iOk == 3) && bl == -1) {
            bl = 0;
        }
        n = okVarBl.a("non_going_notification_foreground", false);
        p = okVarBl.a("notify_too_fast", false);
        long jOk = okVarBl.ok("notification_time_window", 900L);
        f10143q = jOk;
        if (jOk < 0 || jOk > 1200) {
            f10143q = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h hVar = this.k;
        if (hVar != null) {
            try {
                hVar.a();
            } catch (Throwable unused) {
            }
            this.k = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ok(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2, Notification notification) {
        if (ok(i2, notification)) {
            try {
                boolean z = false;
                boolean z2 = s.ok().ok(i2) == 1 && !kf.bl();
                if ((!z2 && f10141a == 0) || (z2 && bl == 0)) {
                    z = true;
                }
                if (z) {
                    z zVarBl = s.ok().bl(i2);
                    if (zVarBl.h() && !zVarBl.a()) {
                        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                        if (z2) {
                            bl = i2;
                        } else {
                            f10141a = i2;
                        }
                        zVarBl.ok(i2, notification);
                    } else {
                        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((f10141a == i2 || bl == i2) && n && (notification.flags & 2) == 0) {
            a(notificationManager, i2);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (kf < jCurrentTimeMillis) {
                kf = jCurrentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable unused) {
        }
    }

    private void ok(final Intent intent) {
        h hVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (hVar = this.k) == null) {
            return;
        }
        hVar.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.a(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (kf.ok((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(n.ok)) {
                                arrayList.add(n.ok);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.p) {
                            DownloadNotificationService.this.ok(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.p) {
                        DownloadNotificationService.this.ok(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.k != null) {
                            DownloadNotificationService.this.k.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(bl.l()).isDownloading(intExtra)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(bl.l()).getDownloadInfo(intExtra);
                    if (!DownloadNotificationService.p) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.f10142h <= DownloadNotificationService.f10143q) {
                        return;
                    }
                    DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(final NotificationManager notificationManager, final int i2, Notification notification) {
        synchronized (this.r) {
            int iIndexOfKey = this.r.indexOfKey(i2);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.r.size()) {
                this.r.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = f10143q - (System.currentTimeMillis() - kf);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            f10142h = jCurrentTimeMillis2;
            kf = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                a(notificationManager, i2, notification);
            } else if (this.k != null) {
                synchronized (this.r) {
                    this.r.put(i2, notification);
                }
                this.k.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.ok(notificationManager, i2);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        boolean z;
        ok okVarValueAt;
        int iOk;
        int i3 = f10141a;
        if (i3 != i2 && bl != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i3 == i2) {
            f10141a = 0;
            z = false;
        } else {
            bl = 0;
            z = true;
        }
        try {
            z zVarBl = s.ok().bl(i2);
            if (!zVarBl.a()) {
                s = false;
                com.ss.android.socialbase.downloader.bl.ok.s(ok, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
            }
            com.ss.android.socialbase.downloader.bl.ok.bl(ok, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
            zVarBl.ok(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (s) {
            try {
                SparseArray<ok> sparseArrayA = a.ok().a();
                if (sparseArrayA != null) {
                    for (int size = sparseArrayA.size() - 1; size >= 0; size--) {
                        okVarValueAt = sparseArrayA.valueAt(size);
                        if (okVarValueAt != null && (iOk = okVarValueAt.ok()) != i2 && iOk != f10141a && iOk != bl && okVarValueAt.p()) {
                            if ((s.ok().ok(okVarValueAt.ok()) == 1 && !kf.bl()) == z) {
                                break;
                            }
                        }
                    }
                    okVarValueAt = null;
                } else {
                    okVarValueAt = null;
                }
                if (okVarValueAt != null) {
                    int iOk2 = okVarValueAt.ok();
                    try {
                        notificationManager.cancel(iOk2);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (Downloader.getInstance(this).getStatus(iOk2) != 1) {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.bl.ok.bl(ok, "doCancel, updateNotification id = " + iOk2);
                    okVarValueAt.ok((BaseException) null, z2);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.r) {
            notification = this.r.get(i2);
            this.r.remove(i2);
        }
        if (notification != null) {
            a(notificationManager, i2, notification);
        }
    }

    private boolean ok(int i2, Notification notification) {
        int i3;
        int i4;
        if (!s || (i3 = f10141a) == i2 || (i4 = bl) == i2) {
            return false;
        }
        if (i3 != 0 && i4 != 0) {
            return false;
        }
        if (n && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }
}
