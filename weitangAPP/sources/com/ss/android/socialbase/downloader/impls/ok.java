package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.p.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ok implements p.ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<DownloadTask> f10053a = new SparseArray<>();
    private final SparseArray<DownloadTask> bl = new SparseArray<>();
    private final SparseArray<DownloadTask> s = new SparseArray<>();
    private final SparseArray<DownloadTask> n = new SparseArray<>();
    private final SparseArray<DownloadTask> kf = new SparseArray<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseArray<SparseArray<DownloadTask>> f10054h = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.q.p<Integer, DownloadTask> p = new com.ss.android.socialbase.downloader.q.p<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final SparseArray<Long> f10055q = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> k = new LinkedBlockingDeque<>();
    public final com.ss.android.socialbase.downloader.p.p ok = new com.ss.android.socialbase.downloader.p.p(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.k r = com.ss.android.socialbase.downloader.downloader.bl.m();

    private void bl(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.k.isEmpty()) {
                ok(downloadTask, true);
                this.k.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.k.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && ok(downloadTask.getDownloadId())) {
                    return;
                }
                n(first.getDownloadId());
                ok(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.k.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.k.getFirst().getDownloadId() == downloadTask.getDownloadId() && ok(downloadTask.getDownloadId())) {
                return;
            }
            Iterator<DownloadTask> it = this.k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.k.put(downloadTask);
            new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).ok();
        } catch (InterruptedException unused) {
        }
    }

    private void i(int i2) {
        DownloadTask first;
        if (this.k.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.k.getFirst();
        if (first2 != null && first2.getDownloadId() == i2) {
            this.k.poll();
        }
        if (this.k.isEmpty() || (first = this.k.getFirst()) == null) {
            return;
        }
        ok(first, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask t(int i2) {
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.s.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.bl.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.n.get(i2);
        return downloadTask4 == null ? this.kf.get(i2) : downloadTask4;
    }

    public abstract void a(int i2);

    public abstract com.ss.android.socialbase.downloader.p.bl bl(int i2);

    public synchronized boolean h(int i2) {
        DownloadTask downloadTask = this.s.get(i2);
        if (downloadTask == null) {
            downloadTask = this.n.get(i2);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        ok(downloadTask);
        return true;
    }

    public synchronized boolean j(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.kf.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            ok(downloadTask);
        }
        return true;
    }

    public synchronized IDownloadFileUriProvider k(int i2) {
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.bl.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.s.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.n.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.kf.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized boolean kf(int i2) {
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            ok(downloadTask);
        } else {
            h(i2);
        }
        return true;
    }

    public synchronized boolean n(int i2) {
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "pause id=" + i2);
        DownloadInfo downloadInfoA = this.r.a(i2);
        if (downloadInfoA != null && downloadInfoA.getStatus() == 11) {
            return false;
        }
        synchronized (this.f10053a) {
            a(i2);
        }
        if (downloadInfoA == null) {
            DownloadTask downloadTask = this.f10053a.get(i2);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).s();
                return true;
            }
        } else {
            ok(downloadInfoA);
            if (downloadInfoA.getStatus() == 1) {
                DownloadTask downloadTask2 = this.f10053a.get(i2);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.kf(downloadTask2, this.ok).s();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoA.getStatus())) {
                downloadInfoA.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public abstract List<Integer> ok();

    public abstract void ok(int i2, long j);

    public abstract void ok(int i2, DownloadTask downloadTask);

    public abstract void ok(com.ss.android.socialbase.downloader.p.bl blVar);

    public abstract boolean ok(int i2);

    public synchronized v p(int i2) {
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.bl.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.s.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.n.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.kf.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized ep q(int i2) {
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.bl.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.s.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.n.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.kf.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized boolean r(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.n.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                ok(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoA = this.r.a(i2);
        if (downloadInfoA != null && downloadInfoA.canStartRetryDelayTask()) {
            ok(new DownloadTask(downloadInfoA), false);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean rh(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f10053a     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.s     // Catch: java.lang.Throwable -> L15
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L18
        L13:
            r2 = 1
            goto L19
        L15:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L18:
            r2 = 0
        L19:
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.ok.rh(int):boolean");
    }

    public synchronized DownloadInfo s(int i2) {
        DownloadInfo downloadInfoA;
        DownloadTask downloadTask;
        downloadInfoA = this.r.a(i2);
        if (downloadInfoA == null && (downloadTask = this.f10053a.get(i2)) != null) {
            downloadInfoA = downloadTask.getDownloadInfo();
        }
        return downloadInfoA;
    }

    public synchronized void z(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            ok(downloadTask);
        }
    }

    private void a(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f10054h.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f10054h.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void ok(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTaskRemove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.q.kf.bl(com.ss.android.socialbase.downloader.downloader.bl.l()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).ok(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            ok(downloadInfo);
        }
        if (this.s.get(id) != null) {
            this.s.remove(id);
        }
        if (this.bl.get(id) != null) {
            this.bl.remove(id);
        }
        if (this.n.get(id) != null) {
            this.n.remove(id);
        }
        if (this.kf.get(id) != null) {
            this.kf.remove(id);
        }
        if (ok(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.q.ok.ok(32768) && (downloadTaskRemove = this.p.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTaskRemove);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f10053a.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            status = 0;
        } else {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        a(downloadTask);
        this.f10053a.put(id, downloadTask);
        this.f10055q.put(id, Long.valueOf(jUptimeMillis));
        ok(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(int i2, boolean z) {
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoA = this.r.a(i2);
            if (downloadInfoA != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.q.kf.ok(downloadInfoA);
                } else {
                    com.ss.android.socialbase.downloader.q.kf.bl(downloadInfoA.getTempPath(), downloadInfoA.getTempName());
                }
                downloadInfoA.erase();
            }
            try {
                this.r.kf(i2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            ok(i2, 0, -4);
            if (this.s.get(i2) != null) {
                this.s.remove(i2);
            }
            if (this.bl.get(i2) != null) {
                this.bl.remove(i2);
            }
            this.p.remove(Integer.valueOf(i2));
            com.ss.android.socialbase.downloader.h.ok.a(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (!com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.socialbase.downloader.downloader.bl.l())) {
                return;
            }
            for (int i2 = 0; i2 < this.f10053a.size(); i2++) {
                DownloadTask downloadTask = this.f10053a.get(this.f10053a.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && a(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    ok(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.td reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.ok(downloadInfo, 5, 2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void bl(final int i2, final boolean z) {
        DownloadInfo downloadInfoA = this.r.a(i2);
        if (downloadInfoA != null) {
            ok(downloadInfoA);
        }
        this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.bl.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.5
            @Override // java.lang.Runnable
            public void run() {
                ok.this.bl(i2);
                ok.this.n(i2, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i2, boolean z) {
        try {
            DownloadInfo downloadInfoA = this.r.a(i2);
            if (downloadInfoA != null) {
                com.ss.android.socialbase.downloader.q.kf.ok(downloadInfoA, z);
                downloadInfoA.erase();
            }
            try {
                this.r.s(i2);
                this.r.ok(downloadInfoA);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.s.get(i2) != null) {
                this.s.remove(i2);
            }
            if (this.bl.get(i2) != null) {
                this.bl.remove(i2);
            }
            this.p.remove(Integer.valueOf(i2));
            com.ss.android.socialbase.downloader.h.ok.a(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void a() {
        List<Integer> listOk = ok();
        if (listOk == null) {
            return;
        }
        Iterator<Integer> it = listOk.iterator();
        while (it.hasNext()) {
            n(it.next().intValue());
        }
    }

    public void a(final int i2, final boolean z) {
        DownloadInfo downloadInfoA = this.r.a(i2);
        if (downloadInfoA != null) {
            ok(downloadInfoA);
        }
        this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.bl.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskT;
                if (ok.this.bl(i2) == null && (downloadTaskT = ok.this.t(i2)) != null) {
                    DownloadInfo downloadInfo = downloadTaskT.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskT.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                ok.this.s(i2, z);
            }
        }, false);
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        ok(i2, i3, iDownloadListener, kfVar, z, true);
    }

    public List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = ok().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoS = s(it.next().intValue());
            if (downloadInfoS != null && str.equals(downloadInfoS.getMimeType())) {
                arrayList.add(downloadInfoS);
            }
        }
        return arrayList;
    }

    public synchronized void ok(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            bl(downloadTask);
        } else {
            ok(downloadTask, true);
        }
    }

    public void a(int i2, long j) {
        DownloadInfo downloadInfoA = this.r.a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setThrottleNetSpeed(j);
        }
        ok(i2, j);
    }

    public synchronized List<DownloadInfo> ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listOk = this.r.ok(str);
        if (listOk != null && !listOk.isEmpty()) {
            return listOk;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f10053a.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadTask downloadTaskValueAt = this.f10053a.valueAt(i2);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean ok(int i2, boolean z) {
        DownloadTask downloadTaskT = this.f10053a.get(i2);
        if (downloadTaskT == null && com.ss.android.socialbase.downloader.q.ok.ok(65536)) {
            downloadTaskT = t(i2);
        }
        if (downloadTaskT != null) {
            if (!com.ss.android.socialbase.downloader.h.ok.ok(i2).a("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.kf(downloadTaskT, this.ok).bl();
            }
            final DownloadInfo downloadInfo = downloadTaskT.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskT.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskT.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION);
            this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i4 = 0; i4 < downloadListeners2.size(); i4++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i4));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfoA = this.r.a(i2);
        if (com.ss.android.socialbase.downloader.q.ok.ok(65536)) {
            if (downloadInfoA != null) {
                downloadInfoA.setStatus(-4);
            }
        } else if (downloadInfoA != null && DownloadStatus.isDownloading(downloadInfoA.getStatus())) {
            downloadInfoA.setStatus(-4);
        }
        a(i2, z);
        return true;
    }

    private void ok(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void ok(int i2, ep epVar) {
        DownloadTask downloadTask = this.f10053a.get(i2);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(epVar);
        }
    }

    public synchronized void ok(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean zA = com.ss.android.socialbase.downloader.q.ok.ok(1048576) ? com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.socialbase.downloader.downloader.bl.l()) : true;
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                DownloadTask downloadTask = this.s.get(this.s.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zA)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    ok(downloadTask);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        DownloadTask downloadTaskT = t(i2);
        if (downloadTaskT == null) {
            downloadTaskT = this.p.get(Integer.valueOf(i2));
        }
        if (downloadTaskT != null) {
            downloadTaskT.removeDownloadListener(i3, iDownloadListener, kfVar, z);
        }
    }

    public synchronized void ok(int i2, int i3, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoA;
        DownloadTask downloadTaskT = t(i2);
        if (downloadTaskT != null) {
            downloadTaskT.addDownloadListener(i3, iDownloadListener, kfVar, z);
            final DownloadInfo downloadInfo = downloadTaskT.getDownloadInfo();
            if (z2 && downloadInfo != null && !ok(i2) && (kfVar == com.ss.android.socialbase.downloader.constants.kf.MAIN || kfVar == com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION)) {
                boolean z3 = true;
                if (kfVar == com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (com.ss.android.socialbase.downloader.q.ok.ok(32768) && (downloadInfoA = this.r.a(i2)) != null && downloadInfoA.getStatus() != -3) {
            DownloadTask downloadTask = this.p.get(Integer.valueOf(i2));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoA);
                this.p.put(Integer.valueOf(i2), downloadTask);
            }
            downloadTask.addDownloadListener(i3, iDownloadListener, kfVar, z);
        }
    }

    private void ok(int i2, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.q.bl.ok(i2, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.q.bl.ok(i2, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void ok(int i2, int i3) {
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
        if (i3 == 0) {
            this.f10053a.remove(i2);
            this.f10054h.remove(i2);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f10054h.get(i2);
        if (sparseArray != null) {
            sparseArray.remove(i3);
            com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.f10053a.remove(i2);
                this.f10054h.remove(i2);
                return;
            }
            return;
        }
        this.f10053a.remove(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007e A[Catch: all -> 0x009d, TryCatch #0 {, blocks: (B:18:0x0019, B:20:0x0023, B:22:0x002b, B:23:0x0030, B:24:0x0034, B:26:0x003e, B:28:0x0046, B:29:0x004b, B:30:0x004e, B:31:0x0052, B:32:0x0066, B:33:0x006d, B:34:0x007e, B:36:0x0088, B:38:0x0090, B:39:0x0095, B:40:0x0098), top: B:46:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void ok(int r2, int r3, int r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = -7
            if (r4 == r0) goto L7e
            r0 = -6
            if (r4 == r0) goto L6d
            r0 = -4
            if (r4 == r0) goto L66
            r0 = -3
            if (r4 == r0) goto L52
            r0 = -1
            if (r4 == r0) goto L7e
            r0 = 7
            if (r4 == r0) goto L34
            r3 = 8
            if (r4 == r3) goto L19
            goto L9b
        L19:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r3 = r1.f10053a     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r3 = (com.ss.android.socialbase.downloader.model.DownloadTask) r3     // Catch: java.lang.Throwable -> L9d
            if (r3 == 0) goto L30
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.kf     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            if (r4 != 0) goto L30
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.kf     // Catch: java.lang.Throwable -> L9d
            r4.put(r2, r3)     // Catch: java.lang.Throwable -> L9d
        L30:
            r1.i(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L34:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f10053a     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            if (r4 == 0) goto L4e
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.n     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L4b
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.n     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
        L4b:
            r1.ok(r2, r3)     // Catch: java.lang.Throwable -> L9d
        L4e:
            r1.i(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L52:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f10053a     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.bl     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
            r1.ok(r2, r3)     // Catch: java.lang.Throwable -> L9d
            r1.i(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L66:
            r1.ok(r2, r3)     // Catch: java.lang.Throwable -> L9d
            r1.i(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L6d:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f10053a     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.bl     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
            r1.ok(r2, r3)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L7e:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f10053a     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            if (r4 == 0) goto L98
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.s     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L95
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.s     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
        L95:
            r1.ok(r2, r3)     // Catch: java.lang.Throwable -> L9d
        L98:
            r1.i(r2)     // Catch: java.lang.Throwable -> L9d
        L9b:
            monitor-exit(r1)
            return
        L9d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.ok.ok(int, int, int):void");
    }

    @Override // com.ss.android.socialbase.downloader.p.p.ok
    public void ok(Message message) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i3 == 0) {
                downloadTask = this.f10053a.get(i2);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f10054h.get(i2);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i3);
                }
            }
            if (downloadTask == null) {
                return;
            }
            ok(message.what, baseException, downloadTask);
            ok(i2, i3, message.what);
        }
    }
}
