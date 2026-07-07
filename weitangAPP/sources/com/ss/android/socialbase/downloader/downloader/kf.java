package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.fd;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class kf {
    private static final String ok = "kf";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10027a;
    private DownloadInfo bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SparseArray<IDownloadListener> f10028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.depend.rh f10029i;
    private DownloadTask kf;
    private final Handler n;
    private SparseArray<IDownloadListener> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private SparseArray<IDownloadListener> f10030q;
    private int rh;
    private final k s;
    private long t;
    private y x;
    private boolean k = false;
    private volatile long r = 0;
    private final AtomicLong j = new AtomicLong();
    private boolean z = false;

    public kf(DownloadTask downloadTask, Handler handler) {
        this.kf = downloadTask;
        k();
        this.n = handler;
        this.s = bl.m();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f10027a = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("fix_start_with_file_exist_update_error");
        } else {
            this.f10027a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "saveFileAsTargetName onSuccess");
            try {
                z();
                this.bl.setFirstSuccess(false);
                this.bl.setSuccessByCache(false);
                ok(-3, (BaseException) null);
                this.s.bl(this.bl.getId(), this.bl.getTotalBytes());
                this.s.s(this.bl.getId());
                this.s.z(this.bl.getId());
            } catch (BaseException e2) {
                ok(e2);
            }
        } catch (Throwable th) {
            ok(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.q.kf.a(th, "onCompleted")));
        }
    }

    private void k() {
        DownloadTask downloadTask = this.kf;
        if (downloadTask != null) {
            this.bl = downloadTask.getDownloadInfo();
            this.f10028h = this.kf.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.MAIN);
            this.f10030q = this.kf.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION);
            this.p = this.kf.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.SUB);
            this.f10029i = this.kf.getDepend();
            this.x = this.kf.getMonitorDepend();
        }
    }

    private void r() {
        ExecutorService executorServiceJ = bl.j();
        if (executorServiceJ != null) {
            executorServiceJ.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.kf.1
                @Override // java.lang.Runnable
                public void run() {
                    kf.this.s.q(kf.this.bl.getId());
                    kf.this.ok(1, (BaseException) null);
                }
            });
        }
    }

    private void z() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.z> downloadCompleteHandlers = this.kf.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.bl;
        ok(11, (BaseException) null);
        this.s.ok(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.z zVar : downloadCompleteHandlers) {
            try {
                if (zVar.a(downloadInfo)) {
                    zVar.ok(downloadInfo);
                    this.s.ok(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void h() throws BaseException {
        if (!this.f10027a) {
            z();
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "onCompleteForFileExist");
            this.bl.setSuccessByCache(true);
            ok(-3, (BaseException) null);
            this.s.bl(this.bl.getId(), this.bl.getTotalBytes());
            this.s.s(this.bl.getId());
            this.s.z(this.bl.getId());
            return;
        }
        z();
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onCompleteForFileExist");
        this.bl.setSuccessByCache(true);
        ok(-3, (BaseException) null);
        this.s.bl(this.bl.getId(), this.bl.getTotalBytes());
        this.s.s(this.bl.getId());
        this.s.ok(this.bl);
        this.s.z(this.bl.getId());
    }

    public void kf() {
        this.bl.setFirstDownload(false);
        if (!this.bl.isIgnoreDataVerify() && this.bl.getCurBytes() != this.bl.getTotalBytes()) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, this.bl.getErrorBytesLog());
            ok(new com.ss.android.socialbase.downloader.exception.kf(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.bl.getByteInvalidRetryStatus()));
            return;
        }
        if (this.bl.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, this.bl.getErrorBytesLog());
            ok(new com.ss.android.socialbase.downloader.exception.kf(1026, "curBytes is 0, bytes changed with process : " + this.bl.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.bl.isIgnoreDataVerify() && this.bl.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, this.bl.getErrorBytesLog());
            ok(new com.ss.android.socialbase.downloader.exception.kf(1044, "TotalBytes is 0, bytes changed with process : " + this.bl.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "" + this.bl.getName() + " onCompleted start save file as target name");
        y monitorDepend = this.x;
        DownloadTask downloadTask = this.kf;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.q.kf.ok(this.bl, monitorDepend, new fd() { // from class: com.ss.android.socialbase.downloader.downloader.kf.2
            @Override // com.ss.android.socialbase.downloader.depend.fd
            public void ok() {
                kf.this.j();
            }

            @Override // com.ss.android.socialbase.downloader.depend.fd
            public void ok(BaseException baseException) {
                String str = kf.ok;
                StringBuilder sb = new StringBuilder();
                sb.append("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
                kf.this.ok(baseException);
            }
        });
    }

    public void n() {
        this.bl.setStatus(-7);
        try {
            this.s.k(this.bl.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        ok(-7, (BaseException) null);
    }

    public void p() {
        this.bl.setStatus(8);
        this.bl.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.ok okVarFb = bl.fb();
        if (okVarFb != null) {
            okVarFb.ok(this.bl.getId(), this.kf.getHashCodeForSameTask(), 8);
        }
    }

    public void s() {
        this.bl.setStatus(-2);
        try {
            this.s.s(this.bl.getId(), this.bl.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        ok(-2, (BaseException) null);
    }

    public void a() {
        if (this.bl.canSkipStatusHandler()) {
            this.bl.changeSkipStatus();
            return;
        }
        this.s.h(this.bl.getId());
        if (this.bl.isFirstDownload()) {
            ok(6, (BaseException) null);
        }
        ok(2, (BaseException) null);
    }

    public void bl() {
        ok(-4, (BaseException) null);
    }

    private BaseException bl(BaseException baseException) {
        Context contextL;
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.bl.getId()).ok("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.q.kf.q(baseException) || (contextL = bl.l()) == null || com.ss.android.socialbase.downloader.q.kf.bl(contextL)) {
            return baseException;
        }
        return new BaseException(this.bl.isOnlyWifi() ? PointerIconCompat.TYPE_ALL_SCROLL : 1049, baseException.getErrorMessage());
    }

    public void ok() {
        if (this.bl.canSkipStatusHandler()) {
            return;
        }
        this.bl.setStatus(1);
        r();
    }

    public void ok(long j, String str, String str2) {
        this.bl.setTotalBytes(j);
        this.bl.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.bl.getName())) {
            this.bl.setName(str2);
        }
        try {
            this.s.ok(this.bl.getId(), j, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ok(3, (BaseException) null);
        this.t = this.bl.getMinByteIntervalForPostToMainThread(j);
        this.rh = this.bl.getMinProgressTimeMsInterval();
        this.k = true;
        com.ss.android.socialbase.downloader.impls.td.ok().n();
    }

    private void a(BaseException baseException) {
        Log.d(ok, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.s.kf(this.bl.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.s.a(this.bl.getId(), this.bl.getCurBytes());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.s.kf(this.bl.getId());
            }
        }
        BaseException baseExceptionBl = bl(baseException);
        this.bl.setFailedException(baseExceptionBl);
        ok(baseExceptionBl instanceof com.ss.android.socialbase.downloader.exception.n ? -2 : -1, baseExceptionBl);
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.bl.getId()).ok("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.td.ok().ok(this.bl);
        }
    }

    public boolean ok(long j) {
        this.j.addAndGet(j);
        this.bl.increaseCurBytes(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return ok(jUptimeMillis, a(jUptimeMillis));
    }

    private boolean a(long j) {
        boolean z = true;
        if (!this.z) {
            this.z = true;
            return true;
        }
        long j2 = j - this.r;
        if (this.j.get() < this.t && j2 < this.rh) {
            z = false;
        }
        if (z) {
            this.r = j;
            this.j.set(0L);
        }
        return z;
    }

    public void ok(BaseException baseException, boolean z) {
        this.bl.setFirstDownload(false);
        this.j.set(0L);
        a(baseException, z);
    }

    public void ok(com.ss.android.socialbase.downloader.model.a aVar, BaseException baseException, boolean z) {
        this.bl.setFirstDownload(false);
        this.j.set(0L);
        this.s.p(this.bl.getId());
        ok(z ? 10 : 9, baseException, true);
    }

    private void a(BaseException baseException, boolean z) {
        this.s.p(this.bl.getId());
        ok(z ? 7 : 5, baseException);
    }

    public void ok(BaseException baseException) {
        this.bl.setFirstDownload(false);
        a(baseException);
    }

    public void ok(String str) throws BaseException {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.bl.getName());
        if (this.f10027a) {
            com.ss.android.socialbase.downloader.q.kf.ok(this.bl, str);
            z();
            this.bl.setSuccessByCache(true);
            ok(-3, (BaseException) null);
            this.s.ok(this.bl);
            return;
        }
        this.s.ok(this.bl);
        com.ss.android.socialbase.downloader.q.kf.ok(this.bl, str);
        this.bl.setSuccessByCache(true);
        z();
        ok(-3, (BaseException) null);
    }

    private boolean ok(long j, boolean z) {
        boolean z2 = false;
        if (this.bl.getCurBytes() == this.bl.getTotalBytes()) {
            try {
                this.s.ok(this.bl.getId(), this.bl.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.k) {
            this.k = false;
            this.bl.setStatus(4);
        }
        if (this.bl.isNeedPostProgress() && z) {
            z2 = true;
        }
        ok(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, BaseException baseException) {
        ok(i2, baseException, true);
    }

    private void ok(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.bl.getStatus();
        if (status == -3 && i2 == 4) {
            return;
        }
        k();
        if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
            this.bl.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i2)) {
                this.bl.updateDownloadTime();
            }
        }
        if (!this.bl.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.s.ok.ok(this.kf, baseException, i2);
        }
        if (i2 == 6) {
            this.bl.setStatus(2);
        } else if (i2 == -6) {
            this.bl.setStatus(-3);
        } else {
            this.bl.setStatus(i2);
        }
        if (status == -3 || status == -1) {
            if (this.bl.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADING) {
                this.bl.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADED);
            }
            if (this.bl.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_DOWNLOADING) {
                this.bl.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.bl.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.bl.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.q.bl.ok(i2, this.p, true, this.bl, baseException);
        if (i2 == -4) {
            return;
        }
        if (z && this.n != null && (((sparseArray = this.f10028h) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f10030q) != null && sparseArray2.size() > 0 && (this.bl.canShowNotification() || this.bl.isAutoInstallWithoutNotification())))) {
            this.n.obtainMessage(i2, this.bl.getId(), this.kf.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.ok okVarFb = bl.fb();
        if (okVarFb != null) {
            okVarFb.ok(this.bl.getId(), this.kf.getHashCodeForSameTask(), i2);
        }
    }
}
