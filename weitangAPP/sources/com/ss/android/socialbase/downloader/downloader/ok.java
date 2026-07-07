package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ok implements t {
    private static final String n = "ok";
    public volatile boolean bl;
    private WeakReference<Service> kf;
    public final SparseArray<List<DownloadTask>> ok = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f10036a = false;
    public volatile boolean s = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f10037h = new Handler(Looper.getMainLooper());
    private Runnable p = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ok.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok.n, "tryDownload: 2 try");
            }
            if (ok.this.f10036a) {
                return;
            }
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok.n, "tryDownload: 2 error");
            }
            ok.this.startService(bl.l(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public boolean a() {
        com.ss.android.socialbase.downloader.bl.ok.bl(n, "isServiceForeground = " + this.bl);
        return this.bl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void bl() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void bl(DownloadTask downloadTask) {
    }

    public void n() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.ok) {
            com.ss.android.socialbase.downloader.bl.ok.a(n, "resumePendingTask pendingTasks.size:" + this.ok.size());
            sparseArrayClone = this.ok.clone();
            this.ok.clear();
        }
        com.ss.android.socialbase.downloader.impls.ok okVarFb = bl.fb();
        if (okVarFb != null) {
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.ss.android.socialbase.downloader.bl.ok.a(n, "resumePendingTask key:" + downloadTask.getDownloadId());
                        okVarFb.ok(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(Intent intent, int i2, int i3) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(rh rhVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(WeakReference weakReference) {
        this.kf = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void s() {
        this.f10036a = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void startService() {
        if (this.f10036a) {
            return;
        }
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(n, "startService");
        }
        startService(bl.l(), null);
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public boolean ok() {
        return this.f10036a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.f10036a) {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(n, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.q.ok.ok(262144)) {
                ok(downloadTask);
                if (!this.s) {
                    if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                        com.ss.android.socialbase.downloader.bl.ok.a(n, "tryDownload: 1");
                    }
                    startService(bl.l(), null);
                    this.s = true;
                    return;
                }
                this.f10037h.removeCallbacks(this.p);
                this.f10037h.postDelayed(this.p, 10L);
                return;
            }
            ok(downloadTask);
            startService(bl.l(), null);
            return;
        }
        String str = n;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "tryDownload when isServiceAlive");
        n();
        com.ss.android.socialbase.downloader.impls.ok okVarFb = bl.fb();
        if (okVarFb != null) {
            com.ss.android.socialbase.downloader.bl.ok.a(str, "tryDownload current task: " + downloadTask.getDownloadId());
            okVarFb.ok(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public IBinder ok(Intent intent) {
        com.ss.android.socialbase.downloader.bl.ok.a(n, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(int i2, Notification notification) {
        WeakReference<Service> weakReference = this.kf;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.bl.ok.bl(n, "startForeground  id = " + i2 + ", service = " + this.kf.get() + ",  isServiceAlive = " + this.f10036a);
            try {
                this.kf.get().startForeground(i2, notification);
                this.bl = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.s(n, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(boolean z) {
        WeakReference<Service> weakReference = this.kf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(n, "stopForeground  service = " + this.kf.get() + ",  isServiceAlive = " + this.f10036a);
        try {
            this.bl = false;
            this.kf.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void ok(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.ok) {
            String str = n;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "pendDownloadTask pendingTasks.size:" + this.ok.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.ok.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.ok.put(downloadId, arrayList);
            }
            com.ss.android.socialbase.downloader.bl.ok.a(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.ss.android.socialbase.downloader.bl.ok.a(str, "after pendDownloadTask pendingTasks.size:" + this.ok.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(int i2) {
        com.ss.android.socialbase.downloader.bl.ok.ok(i2);
    }
}
