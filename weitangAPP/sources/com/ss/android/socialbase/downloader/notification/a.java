package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a bl;
    private static final Object n = new Object();
    private final long ok = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Long> f10147a = new HashMap();
    private final Set<String> s = new HashSet();
    private final SparseArray<ok> kf = new SparseArray<>();

    private a() {
    }

    public static boolean a(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public static boolean bl(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && a(downloadInfo.getNotificationVisibility());
    }

    public static a ok() {
        if (bl == null) {
            synchronized (a.class) {
                if (bl == null) {
                    bl = new a();
                }
            }
        }
        return bl;
    }

    public void a(DownloadInfo downloadInfo) {
        if (bl(downloadInfo)) {
            kf(downloadInfo.getId());
        }
    }

    public void kf(int i2) {
        s(i2);
        if (i2 != 0) {
            ok().bl(i2);
        }
    }

    public ok n(int i2) {
        ok okVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.kf) {
            okVar = this.kf.get(i2);
        }
        return okVar;
    }

    public ok s(int i2) {
        ok okVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.kf) {
            okVar = this.kf.get(i2);
            if (okVar != null) {
                this.kf.remove(i2);
                com.ss.android.socialbase.downloader.bl.ok.ok("removeNotificationId " + i2);
            }
        }
        return okVar;
    }

    public void bl(int i2) {
        Context contextL = bl.l();
        if (contextL == null || i2 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(contextL, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            contextL.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SparseArray<ok> a() {
        SparseArray<ok> sparseArray;
        synchronized (this.kf) {
            sparseArray = this.kf;
        }
        return sparseArray;
    }

    public void ok(int i2) {
        DownloadInfo downloadInfo = Downloader.getInstance(bl.l()).getDownloadInfo(i2);
        if (downloadInfo == null) {
            return;
        }
        ok(downloadInfo);
        a(downloadInfo);
    }

    public void ok(DownloadInfo downloadInfo) {
        k kVarM = bl.m();
        if (kVarM != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                kVarM.ok(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void ok(int i2, int i3, Notification notification) {
        Context contextL = bl.l();
        if (contextL == null || i2 == 0 || notification == null) {
            return;
        }
        if (i3 == 4) {
            synchronized (this.f10147a) {
                Long l = this.f10147a.get(Integer.valueOf(i2));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.f10147a.put(Integer.valueOf(i2), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        try {
            Intent intent = new Intent(contextL, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i3);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            contextL.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ok(ok okVar) {
        if (okVar == null) {
            return;
        }
        synchronized (this.kf) {
            this.kf.put(okVar.ok(), okVar);
        }
    }
}
