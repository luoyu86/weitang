package com.ss.android.socialbase.downloader.p;

import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.kf.r;
import com.ss.android.socialbase.downloader.kf.rh;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.a;
import com.ss.android.socialbase.downloader.network.q;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements kf, Runnable {
    private static final String ok = bl.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Future f10156a;
    private final DownloadTask bl;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10157e;
    private o ep;
    private final com.ss.android.socialbase.downloader.h.ok fd;
    private long fl;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.n f10159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DownloadInfo f10160i;
    private zz io;
    private boolean j;
    private boolean k;
    private com.ss.android.socialbase.downloader.network.h m;
    private AtomicInteger n;
    private volatile BaseException o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10161q;
    private boolean r;
    private final k t;
    private final com.ss.android.socialbase.downloader.downloader.p td;
    private final com.ss.android.socialbase.downloader.downloader.h u;
    private final com.ss.android.socialbase.downloader.downloader.kf ul;
    private td vz;
    private com.ss.android.socialbase.downloader.downloader.p x;
    private q y;
    private final AtomicBoolean z;
    private com.ss.android.socialbase.downloader.downloader.h zz;
    private volatile boolean s = false;
    private final ArrayList<a> kf = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.p rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_NONE;
    private volatile int kz = 5;
    private boolean er = false;
    private boolean fb = false;
    private boolean v = false;
    private int em = 0;
    private volatile r sg = null;

    public bl(DownloadTask downloadTask, Handler handler) {
        this.bl = downloadTask;
        if (downloadTask != null) {
            this.f10160i = downloadTask.getDownloadInfo();
            this.x = downloadTask.getChunkStrategy();
            this.zz = downloadTask.getChunkAdjustCalculator();
            this.ep = downloadTask.getForbiddenHandler();
            this.vz = downloadTask.getDiskSpaceHandler();
            this.io = ok(downloadTask);
            this.fd = com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId());
        } else {
            this.fd = com.ss.android.socialbase.downloader.h.ok.bl();
        }
        p();
        this.t = com.ss.android.socialbase.downloader.downloader.bl.m();
        this.td = com.ss.android.socialbase.downloader.downloader.bl.em();
        this.u = com.ss.android.socialbase.downloader.downloader.bl.qu();
        this.ul = new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, handler);
        this.z = new AtomicBoolean(true);
    }

    private void e() {
        com.ss.android.socialbase.downloader.bl.ok.s(ok, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.t.s(this.f10160i.getId());
            this.t.z(this.f10160i.getId());
            com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
            this.f10161q = false;
            this.f10160i.resetDataForEtagEndure("");
            this.t.ok(this.f10160i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em() {
        com.ss.android.socialbase.downloader.impls.ok okVarFb;
        if (ul() || (okVarFb = com.ss.android.socialbase.downloader.downloader.bl.fb()) == null) {
            return;
        }
        okVarFb.j(this.f10160i.getId());
    }

    private void ep() {
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_NONE;
    }

    private boolean er() {
        DownloadInfo downloadInfo = this.f10160i;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.f10161q || this.f10160i.getChunkCount() > 1) && !this.f10160i.isChunkDowngradeRetryUsed() && this.k && !this.j;
    }

    private void fb() throws BaseException {
        long jS;
        int iOk;
        try {
            jS = com.ss.android.socialbase.downloader.q.kf.s(this.f10160i.getTempPath());
        } catch (BaseException unused) {
            jS = 0;
        }
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.bl(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.q.kf.ok(jS) + "MB");
        if (jS > 0) {
            long totalBytes = this.f10160i.getTotalBytes() - this.f10160i.getCurBytes();
            if (jS < totalBytes && (iOk = com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).ok("space_fill_min_keep_mb", 100)) > 0) {
                long j = jS - (((long) iOk) * 1048576);
                com.ss.android.socialbase.downloader.bl.ok.bl(str, "checkSpaceOverflowInProgress: minKeep  = " + iOk + "MB, canDownload = " + com.ss.android.socialbase.downloader.q.kf.ok(j) + "MB");
                if (j > 0) {
                    this.fl = this.f10160i.getCurBytes() + j + 1048576;
                    return;
                } else {
                    this.fl = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.s(jS, totalBytes);
                }
            }
        }
        this.fl = 0L;
    }

    private void fd() {
        try {
            for (a aVar : (ArrayList) this.kf.clone()) {
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.bl.ok.bl(ok, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private void fl() {
        long jKf = com.ss.android.socialbase.downloader.q.kf.kf(this.f10160i);
        long curBytes = this.f10160i.getCurBytes();
        if (jKf != curBytes) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "checkTaskCanResume: offset = " + jKf + ", curBytes = " + curBytes);
        }
        this.f10160i.setCurBytes(jKf);
        boolean z = jKf > 0;
        this.f10161q = z;
        if (z || this.v) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "checkTaskCanResume: deleteAllDownloadFiles");
        this.t.s(this.f10160i.getId());
        this.t.z(this.f10160i.getId());
        com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
    }

    private void g() throws com.ss.android.socialbase.downloader.exception.kf {
        if (this.f10160i.isOnlyWifi() && !com.ss.android.socialbase.downloader.q.kf.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.kf(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.f10160i.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.bl();
        }
        if (!this.f10160i.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.n();
        }
    }

    private void i() {
        boolean zO;
        boolean z;
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "endDownloadRunnable::runStatus=" + this.rh);
        boolean z2 = (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE || this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) ? false : true;
        try {
            zO = o();
            z = false;
        } catch (Exception e2) {
            if (e2 instanceof BaseException) {
                this.ul.ok((BaseException) e2);
            } else {
                this.ul.ok(new BaseException(1046, e2));
            }
            zO = true;
            z = true;
        }
        if (!zO && !z) {
            this.er = true;
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "jump to restart");
            return;
        }
        this.z.set(false);
        if (z2) {
            try {
                com.ss.android.socialbase.downloader.impls.ok okVarFb = com.ss.android.socialbase.downloader.downloader.bl.fb();
                if (okVarFb != null) {
                    okVarFb.ok(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                y monitorDepend = this.bl.getMonitorDepend();
                DownloadInfo downloadInfo = this.f10160i;
                BaseException baseException = new BaseException(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, com.ss.android.socialbase.downloader.q.kf.a(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.f10160i;
                com.ss.android.socialbase.downloader.s.ok.ok(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private boolean io() {
        return this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED || this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE;
    }

    private void j() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.a> listBl;
        try {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_NONE;
            this.f10160i.updateStartDownloadTime();
            this.f10160i.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f10160i.setFirstSpeedTime(-1L);
            try {
                k();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.ok e2) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok, "file exist " + e2.ok());
                this.f10158g = e2.ok();
                z = true;
            }
            if (!this.er) {
                this.ul.a();
            }
            this.er = false;
            if (ul()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f10158g) && z) {
                if (this.f10160i.isExpiredRedownload()) {
                    this.v = com.ss.android.socialbase.downloader.q.kf.s(this.f10160i);
                }
                if (!this.v) {
                    z();
                    return;
                }
            }
            while (!ul()) {
                try {
                    try {
                        try {
                            try {
                                v();
                                kz();
                                g();
                                listBl = this.t.bl(this.f10160i.getId());
                                fl();
                            } catch (com.ss.android.socialbase.downloader.exception.q e3) {
                                try {
                                    com.ss.android.socialbase.downloader.bl.ok.s(ok, "downloadInner: retry throwable for " + e3.ok());
                                    if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                                        AtomicInteger atomicInteger = this.n;
                                        if (atomicInteger != null && atomicInteger.get() > 0) {
                                            this.f10160i.updateCurRetryTime(this.n.decrementAndGet());
                                            this.f10160i.setStatus(5);
                                        } else if (this.n == null) {
                                            a(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.ok()));
                                        } else if (this.f10160i.trySwitchToNextBackupUrl()) {
                                            this.f10160i.setStatus(5);
                                            this.n.set(this.f10160i.getRetryCount());
                                            this.f10160i.updateCurRetryTime(this.n.get());
                                        } else {
                                            a(new BaseException(PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.f10160i.getRetryCount()), e3.ok())));
                                        }
                                        zz();
                                    }
                                } catch (Throwable th) {
                                    zz();
                                    throw th;
                                }
                            }
                        } catch (BaseException e4) {
                            com.ss.android.socialbase.downloader.bl.ok.s(ok, "downloadInner: baseException = " + e4);
                            if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                                if (e4.getErrorCode() != 1025 && e4.getErrorCode() != 1009) {
                                    if (ok(e4)) {
                                        if (com.ss.android.socialbase.downloader.q.kf.ok(e4)) {
                                            e();
                                        }
                                        if (ok(e4, 0L) == com.ss.android.socialbase.downloader.exception.p.RETURN) {
                                            zz();
                                            return;
                                        }
                                        zz();
                                    } else {
                                        a(e4);
                                    }
                                }
                                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW;
                                zz();
                                return;
                            }
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.ok unused) {
                        z();
                    }
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.bl.ok.s(ok, "downloadInner: throwable =  " + th2);
                    if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                        a(new BaseException(1045, th2));
                    }
                }
                if (rh()) {
                    com.ss.android.socialbase.downloader.bl.ok.bl(ok, "downloadSegments return");
                    zz();
                    return;
                }
                String connectionUrl = this.f10160i.getConnectionUrl();
                if (ul()) {
                    zz();
                    return;
                }
                long jN = this.f10161q ? com.ss.android.socialbase.downloader.q.kf.n(this.f10160i) : 0L;
                com.ss.android.socialbase.downloader.model.a aVarOk = ok(this.f10160i, jN);
                List<com.ss.android.socialbase.downloader.model.bl> listOk = ok(aVarOk);
                com.ss.android.socialbase.downloader.q.kf.ok(listOk, this.f10160i);
                com.ss.android.socialbase.downloader.q.kf.a(listOk, this.f10160i);
                this.f10160i.setPreconnectLevel(0);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                try {
                    ok(connectionUrl, listOk, jN);
                    this.f10160i.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                    if (ul()) {
                        zz();
                        return;
                    }
                    long totalBytes = this.f10160i.getTotalBytes();
                    ok(totalBytes);
                    int iOk = ok(totalBytes, listBl);
                    if (ul()) {
                        zz();
                        return;
                    }
                    if (iOk <= 0) {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                    boolean z2 = iOk == 1;
                    this.p = z2;
                    if (z2) {
                        if (this.y == null) {
                            try {
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                ok(connectionUrl, listOk);
                                this.f10160i.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                            } finally {
                            }
                        }
                        if (ul()) {
                            zz();
                            return;
                        } else {
                            this.f10160i.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                            t();
                            ok(aVarOk, connectionUrl, this.y);
                        }
                    } else {
                        if (!this.f10160i.isNeedReuseFirstConnection()) {
                            td();
                        }
                        if (ul()) {
                            zz();
                            return;
                        }
                        t();
                        this.f10160i.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                        if (this.f10161q) {
                            ok(iOk, listBl);
                        } else {
                            ok(totalBytes, iOk);
                        }
                    }
                    zz();
                    return;
                } finally {
                }
            }
        } finally {
            i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00e8, TryCatch #5 {all -> 0x00e8, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e7), top: B:84:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5 A[Catch: SQLiteException -> 0x00fd, TRY_LEAVE, TryCatch #11 {SQLiteException -> 0x00fd, blocks: (B:77:0x00ed, B:79:0x00f5), top: B:90:0x00ed }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() throws com.ss.android.socialbase.downloader.exception.ok {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.k():void");
    }

    private void kz() throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        com.ss.android.socialbase.downloader.impls.ok okVarFb;
        int id = this.f10160i.getId();
        int iOk = com.ss.android.socialbase.downloader.downloader.bl.ok(this.f10160i);
        if (this.f10160i.isDownloaded() && !this.f10160i.isExpiredRedownload() && !this.v) {
            throw new BaseException(PointerIconCompat.TYPE_VERTICAL_TEXT, "file has downloaded");
        }
        DownloadInfo downloadInfoA = this.t.a(iOk);
        if (downloadInfoA == null || (okVarFb = com.ss.android.socialbase.downloader.downloader.bl.fb()) == null || downloadInfoA.getId() == id || !downloadInfoA.equalsTask(this.f10160i)) {
            return;
        }
        if (okVarFb.ok(downloadInfoA.getId())) {
            this.t.kf(id);
            throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.model.a> listBl = this.t.bl(iOk);
        com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
        this.t.kf(iOk);
        if (downloadInfoA.isBreakpointAvailable()) {
            this.f10160i.copyFromCacheData(downloadInfoA, false);
            this.t.ok(this.f10160i);
            if (listBl != null) {
                for (com.ss.android.socialbase.downloader.model.a aVar : listBl) {
                    aVar.a(id);
                    this.t.ok(aVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.q("retry task because id generator changed");
        }
    }

    private boolean m() {
        if (this.f10160i.isChunked()) {
            DownloadInfo downloadInfo = this.f10160i;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.f10160i.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.f10160i.getTotalBytes());
        if (this.f10160i.getCurBytes() > 0) {
            if (this.f10160i.isIgnoreDataVerify()) {
                return true;
            }
            if (this.f10160i.getTotalBytes() > 0 && this.f10160i.getCurBytes() == this.f10160i.getTotalBytes()) {
                return true;
            }
        }
        this.f10160i.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.f10160i.reset();
        this.t.ok(this.f10160i);
        this.t.s(this.f10160i.getId());
        this.t.z(this.f10160i.getId());
        com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
        return false;
    }

    private boolean o() {
        if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ERROR) {
            this.ul.ok(this.o);
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
            this.ul.bl();
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
            this.ul.s();
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.ul.h();
            } catch (BaseException e2) {
                this.ul.ok(e2);
            }
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.ul.ok(this.f10158g);
            } catch (BaseException e3) {
                this.ul.ok(e3);
            }
        } else {
            if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.ul.ok(this.o, false);
                return false;
            }
            if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.constants.p pVar = this.rh;
            com.ss.android.socialbase.downloader.constants.p pVar2 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY;
            if (pVar == pVar2 && !y()) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok, "doTaskStatusHandle retryDelay");
                ep();
                return this.rh == pVar2;
            }
            try {
                if (!m()) {
                    return false;
                }
                this.ul.kf();
                com.ss.android.socialbase.downloader.impls.td.ok().s();
            } catch (Throwable th) {
                a(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.q.kf.a(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private void p() {
        DownloadInfo downloadInfo = this.f10160i;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.f10160i.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.n;
        if (atomicInteger == null) {
            this.n = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean q() {
        int status = this.f10160i.getStatus();
        if (status == 1 || this.f10160i.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        a(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    private void r() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.f10160i;
            if (downloadInfo != null && this.f10157e > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.f10157e);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.bl.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.ul.n();
                    return;
                }
            }
        } finally {
        }
        if (!q()) {
            y monitorDepend = this.bl.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.f10160i;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.f10160i;
            com.ss.android.socialbase.downloader.s.ok.ok(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            j();
            if (!this.er) {
                return;
            }
            if (this.kz > 0) {
                this.kz--;
            } else {
                if (this.f10160i.getCurBytes() != this.f10160i.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, this.f10160i.getErrorBytesLog());
                    this.ul.ok(new com.ss.android.socialbase.downloader.exception.kf(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.f10160i.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.f10160i.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, this.f10160i.getErrorBytesLog());
                    this.ul.ok(new com.ss.android.socialbase.downloader.exception.kf(1026, "curBytes is 0, bytes invalid retry status is : " + this.f10160i.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.f10160i.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, this.f10160i.getErrorBytesLog());
                    this.ul.ok(new com.ss.android.socialbase.downloader.exception.kf(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.f10160i.getByteInvalidRetryStatus()));
                    return;
                }
            }
        }
    }

    private boolean rh() throws InterruptedException, BaseException {
        if (this.f10160i.isExpiredRedownload() || this.f10160i.getChunkCount() != 1 || this.f10160i.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectS = com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).s("segment_config");
        List<com.ss.android.socialbase.downloader.kf.q> listRh = this.t.rh(this.f10160i.getId());
        if (this.f10160i.getCurBytes() > 0) {
            if (listRh == null || listRh.isEmpty()) {
                return false;
            }
            if (jSONObjectS == null) {
                jSONObjectS = new JSONObject();
            }
        }
        if (jSONObjectS == null) {
            return false;
        }
        this.sg = new r(this.f10160i, rh.ok(jSONObjectS), this);
        if (!ul()) {
            return this.sg.ok(listRh);
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "downloadSegments: is stopped by user");
        if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
            this.sg.ok();
        } else {
            this.sg.a();
        }
        return true;
    }

    private boolean sg() {
        return false;
    }

    private void t() {
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).ok("reset_retain_retry_times", 0) != 1 || this.em >= 3) {
            return;
        }
        this.n.set(this.f10160i.isBackUpUrlUsed() ? this.f10160i.getBackUpUrlRetryCount() : this.f10160i.getRetryCount());
        this.em++;
    }

    private void td() {
        q qVar = this.y;
        if (qVar != null) {
            qVar.s();
            this.y = null;
        }
    }

    private void u() throws BaseException {
        if (this.f10159h != null) {
            if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                this.f10160i.setStatus(-4);
                this.f10159h.bl();
            } else if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                this.f10159h.s();
            } else {
                this.f10160i.setStatus(-2);
                this.f10159h.a();
            }
        }
    }

    private boolean ul() {
        if (!io() && this.f10160i.getStatus() != -2) {
            return false;
        }
        if (io()) {
            return true;
        }
        if (this.f10160i.getStatus() == -2) {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.f10160i.getStatus() != -4) {
            return true;
        }
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED;
        return true;
    }

    private void v() throws BaseException {
        if (TextUtils.isEmpty(this.f10160i.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.f10160i.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.f10160i.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.ss.android.socialbase.downloader.q.s.a(this.f10160i)) {
                throw new BaseException(1031, "download savePath is not a directory:" + this.f10160i.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new BaseException(1031, "download savePath is not directory:path=" + this.f10160i.getSavePath());
        }
        boolean zMkdirs = file.mkdirs();
        if (zMkdirs || file.exists()) {
            return;
        }
        int i2 = 0;
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).ok("opt_mkdir_failed", 0) != 1) {
            throw new BaseException(1030, "download savePath directory can not created:" + this.f10160i.getSavePath());
        }
        while (!zMkdirs) {
            int i3 = i2 + 1;
            if (i2 >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                zMkdirs = file.mkdirs();
                i2 = i3;
            } catch (InterruptedException unused) {
            }
        }
        if (zMkdirs || file.exists()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.q.kf.s(this.f10160i.getSavePath()) < PlaybackStateCompat.ACTION_PREPARE) {
            throw new BaseException(1006, "download savePath directory can not created:" + this.f10160i.getSavePath());
        }
        throw new BaseException(1030, "download savePath directory can not created:" + this.f10160i.getSavePath());
    }

    private long vz() {
        return this.io.ok(this.f10160i.getCurRetryTimeInTotal(), this.f10160i.getTotalRetryCount());
    }

    private void x() {
        com.ss.android.socialbase.downloader.network.h hVar = this.m;
        if (hVar != null) {
            hVar.bl();
            this.m = null;
        }
    }

    private boolean y() {
        if (this.f10160i.getChunkCount() <= 1) {
            return this.f10160i.getCurBytes() > 0 && this.f10160i.getCurBytes() == this.f10160i.getTotalBytes();
        }
        List<com.ss.android.socialbase.downloader.model.a> listBl = this.t.bl(this.f10160i.getId());
        if (listBl == null || listBl.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.a aVar : listBl) {
            if (aVar == null || !aVar.q()) {
                return false;
            }
        }
        return true;
    }

    private void z() {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.h.ok.bl().a("fix_end_for_file_exist_error", true)) {
            if (this.f10158g.equals(this.f10160i.getName())) {
                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.f10158g.equals(this.f10160i.getTargetFilePath())) {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private void zz() {
        x();
        td();
    }

    public void a() {
        com.ss.android.socialbase.downloader.constants.p pVar = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED;
        this.rh = pVar;
        if (this.sg != null) {
            this.sg.ok();
        }
        if (this.f10159h != null) {
            this.f10159h.bl();
        }
        if (this.sg == null && this.f10159h == null) {
            zz();
            this.rh = pVar;
            i();
        }
        fd();
    }

    public DownloadTask bl() {
        return this.bl;
    }

    public Future h() {
        return this.f10156a;
    }

    public void kf() {
        this.f10157e = System.currentTimeMillis();
        this.ul.ok();
    }

    public int n() {
        DownloadInfo downloadInfo = this.f10160i;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.bl.ok(this.bl, 3);
        try {
            com.ss.android.socialbase.downloader.network.a.ok().a();
            r();
            com.ss.android.socialbase.downloader.network.a.ok().bl();
            com.ss.android.socialbase.downloader.downloader.bl.a(this.bl, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.a.ok().bl();
            throw th;
        }
    }

    public boolean s() {
        return this.z.get();
    }

    private boolean s(BaseException baseException) {
        AtomicInteger atomicInteger = this.n;
        boolean z = true;
        if (atomicInteger == null) {
            a(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.f10160i.trySwitchToNextBackupUrl()) {
                this.n.set(this.f10160i.getBackUpUrlRetryCount());
                this.f10160i.updateCurRetryTime(this.n.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.f10160i.canReplaceHttpForRetry())) {
                    a(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.n), String.valueOf(this.f10160i.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                this.n.set(this.f10160i.getRetryCount());
                this.f10160i.updateCurRetryTime(this.n.get());
                this.f10160i.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY && z) {
            this.f10160i.updateCurRetryTime(this.n.decrementAndGet());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void bl(BaseException baseException) {
        DownloadInfo downloadInfo = this.f10160i;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        ok(baseException, false);
    }

    public void ok() {
        com.ss.android.socialbase.downloader.constants.p pVar = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE;
        this.rh = pVar;
        if (this.sg != null) {
            this.sg.a();
        }
        if (this.f10159h != null) {
            this.f10159h.a();
        }
        if (this.sg == null && this.f10159h == null) {
            zz();
            this.rh = pVar;
            i();
        }
        try {
            for (a aVar : (ArrayList) this.kf.clone()) {
                if (aVar != null) {
                    aVar.ok();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bl(long j) {
        q qVar = this.y;
        if (qVar != null && (qVar instanceof com.ss.android.socialbase.downloader.network.ok)) {
            try {
                ((com.ss.android.socialbase.downloader.network.ok) qVar).ok(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.bl> list, long j) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        com.ss.android.socialbase.downloader.network.ok.bl blVarOk;
        boolean z = true;
        if (this.f10160i.getChunkCount() == 1 && (blVarOk = com.ss.android.socialbase.downloader.network.ok.ok.ok().ok(str, list)) != null) {
            this.m = blVarOk;
            this.f10160i.setPreconnectLevel(1);
        }
        if (this.m == null && !this.fb && this.f10160i.isHeadConnectionAvailable()) {
            try {
                int iA = this.fd.a("net_lib_strategy");
                if (this.fd.ok("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.m = com.ss.android.socialbase.downloader.downloader.bl.ok(str, list, iA, z, this.f10160i);
            } catch (Throwable th) {
                this.f10160i.setHeadConnectionException(com.ss.android.socialbase.downloader.q.kf.k(th));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ok(long r7, java.util.List<com.ss.android.socialbase.downloader.model.a> r9) {
        /*
            r6 = this;
            boolean r0 = r6.er()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.f10161q
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.f10160i
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.p r9 = r6.x
            if (r9 == 0) goto L23
            int r9 = r9.ok(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.p r9 = r6.td
            int r9 = r9.ok(r7)
        L29:
            com.ss.android.socialbase.downloader.network.r r0 = com.ss.android.socialbase.downloader.network.r.ok()
            com.ss.android.socialbase.downloader.network.j r0 = r0.a()
            java.lang.String r3 = com.ss.android.socialbase.downloader.p.bl.ok
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.bl.ok.a(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.f10160i
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.h r3 = r6.zz
            if (r3 == 0) goto L56
            int r9 = r3.ok(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.h r3 = r6.u
            int r9 = r3.ok(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.bl.ok.ok()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.p.bl.ok
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.f10160i
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.bl.ok.a(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public boolean a(long j) throws BaseException {
        if (this.fl > 0 && this.f10160i.getCurBytes() > this.fl) {
            fb();
        }
        return this.ul.ok(j);
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onError:" + baseException.getMessage());
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ERROR;
        this.o = baseException;
        fd();
    }

    private void ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list, long j) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        a(str, list, j);
        com.ss.android.socialbase.downloader.network.h hVar = this.m;
        if (hVar != null) {
            try {
                ok(str, hVar, j);
            } catch (Throwable unused) {
                this.fb = true;
            }
        }
        if (this.m == null || this.fb) {
            ok(str, list);
            ok(str, this.y, j);
        }
    }

    private void ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        q qVarOk;
        if (this.y != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.ok.s sVarA = this.f10160i.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.ok.ok.ok().a(str, list) : null;
        try {
            if (sVarA != null) {
                ok(this.y);
                this.f10160i.setPreconnectLevel(2);
                this.y = sVarA;
            } else {
                try {
                    qVarOk = com.ss.android.socialbase.downloader.downloader.bl.ok(this.f10160i.isNeedDefaultHttpServiceBackUp(), this.f10160i.getMaxBytes(), str, null, list, this.fd.a("net_lib_strategy"), this.fd.ok("monitor_download_connect", 0) > 0, this.f10160i);
                    this.y = qVarOk;
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (this.f10160i.isExpiredRedownload() && com.ss.android.socialbase.downloader.q.kf.h(th) && com.ss.android.socialbase.downloader.q.kf.bl(list)) {
                        com.ss.android.socialbase.downloader.bl.ok.a(ok, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.f10160i.getCacheControl());
                        long jQ = com.ss.android.socialbase.downloader.q.kf.q(this.f10160i.getCacheControl());
                        if (jQ <= 0) {
                            jQ = com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).ok("default_304_max_age", 300);
                        }
                        this.f10160i.setCacheExpiredTime(System.currentTimeMillis() + (jQ * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.ok(this.f10158g);
                    }
                    if (com.ss.android.socialbase.downloader.q.kf.kf(th)) {
                        ok("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.q.kf.n(th)) {
                        ok("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.q.kf.ok(th, "CreateFirstConnection");
                    }
                    qVarOk = this.y;
                }
                ok(qVarOk);
            }
            if (this.y == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            ok(this.y);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.a ok(DownloadInfo downloadInfo, long j) {
        return new a.ok(downloadInfo.getId()).ok(-1).ok(0L).n(j).a(j).bl(0L).s(downloadInfo.getTotalBytes() - j).ok();
    }

    private List<com.ss.android.socialbase.downloader.model.bl> ok(com.ss.android.socialbase.downloader.model.a aVar) {
        List<com.ss.android.socialbase.downloader.model.bl> listOk = com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i.getExtraHeaders(), this.f10160i.geteTag(), aVar);
        if (this.f10160i.isExpiredRedownload() && this.v && this.f10160i.getLastModified() != null) {
            listOk.add(new com.ss.android.socialbase.downloader.model.bl("if-modified-since", this.f10160i.getLastModified()));
            listOk.add(new com.ss.android.socialbase.downloader.model.bl("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "dcache::add head IF_MODIFIED_SINCE=" + this.f10160i.getLastModified());
        }
        return listOk;
    }

    private void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws BaseException {
        if (list.size() == i2) {
            ok(list, this.f10160i.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void ok(long j, int i2) throws BaseException {
        long j2 = j / ((long) i2);
        int id = this.f10160i.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j3 = 0;
        while (i3 < i2) {
            com.ss.android.socialbase.downloader.model.a aVarOk = new a.ok(id).ok(i3).ok(j3).n(j3).a(j3).bl(i3 == i2 + (-1) ? 0L : (j3 + j2) - 1).ok();
            arrayList.add(aVarOk);
            this.t.ok(aVarOk);
            j3 += j2;
            i3++;
        }
        this.f10160i.setChunkCount(i2);
        this.t.ok(id, i2);
        ok(arrayList, j);
    }

    private void ok(List<com.ss.android.socialbase.downloader.model.a> list, long j) throws BaseException {
        long jI;
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null) {
                if (aVar.i() == 0) {
                    jI = j - aVar.rh();
                } else {
                    jI = (aVar.i() - aVar.rh()) + 1;
                }
                if (jI > 0) {
                    aVar.ok(jI);
                    if (this.f10160i.isNeedReuseFirstConnection() && this.y != null && (!this.f10160i.isHeadConnectionAvailable() || this.fb)) {
                        if (aVar.zz() == 0) {
                            this.kf.add(new a(aVar, this.bl, this.y, this));
                        } else if (aVar.zz() > 0) {
                            this.kf.add(new a(aVar, this.bl, this));
                        }
                    } else {
                        this.kf.add(new a(aVar, this.bl, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.q.ok.ok(64)) {
            ArrayList arrayList = new ArrayList(this.kf.size());
            for (a aVar2 : this.kf) {
                if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                    aVar2.a();
                } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                    aVar2.ok();
                } else {
                    arrayList.add(aVar2);
                }
            }
            try {
                List<Future> listS = com.ss.android.socialbase.downloader.impls.n.s(arrayList);
                for (Runnable runnableN = (Runnable) arrayList.remove(0); runnableN != null; runnableN = com.ss.android.socialbase.downloader.impls.n.n(listS)) {
                    if (ul()) {
                        return;
                    }
                    try {
                        runnableN.run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (listS == null || listS.isEmpty()) {
                    return;
                }
                for (Future future : listS) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.kf.size());
        for (a aVar3 : this.kf) {
            if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                aVar3.a();
            } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                aVar3.ok();
            } else {
                arrayList2.add(Executors.callable(aVar3));
            }
        }
        if (ul()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.n.bl(arrayList2);
        } catch (InterruptedException e2) {
            throw new BaseException(PointerIconCompat.TYPE_GRAB, e2);
        }
    }

    private void ok(com.ss.android.socialbase.downloader.model.a aVar, String str, q qVar) throws BaseException {
        aVar.ok(this.f10160i.getTotalBytes() - aVar.rh());
        this.f10160i.setChunkCount(1);
        this.t.ok(this.f10160i.getId(), 1);
        this.f10159h = new com.ss.android.socialbase.downloader.downloader.n(this.f10160i, str, qVar, aVar, this);
        u();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:81|6|7|(9:9|(1:11)|12|(2:14|(4:16|(2:18|(1:20)(2:21|22))(1:23)|24|(3:26|(1:28)|49))(2:29|(1:31)(4:32|(1:34)(1:35)|36|37)))|84|50|51|72|73)(2:38|(4:40|(1:42)(1:43)|44|45)(2:46|(2:76|77)))|48|49|84|50|51|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0170, code lost:
    
        com.ss.android.socialbase.downloader.bl.ok.n(com.ss.android.socialbase.downloader.p.bl.ok, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0192, code lost:
    
        if (r5 >= r24) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x019e, code lost:
    
        r7.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a4, code lost:
    
        com.ss.android.socialbase.downloader.bl.ok.n(com.ss.android.socialbase.downloader.p.bl.ok, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c0, code lost:
    
        if (r4 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c8, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1040, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c9, code lost:
    
        if (r4 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01da, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1040, r0);
     */
    @Override // com.ss.android.socialbase.downloader.p.kf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ok(long r24) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(long):void");
    }

    private boolean ok(int i2, String str, String str2) {
        if (i2 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.r || this.k)) {
            return (i2 == 201 || i2 == 416) && this.f10160i.getCurBytes() > 0;
        }
        return true;
    }

    private void ok(String str, String str2) throws com.ss.android.socialbase.downloader.exception.q {
        this.t.s(this.f10160i.getId());
        this.t.z(this.f10160i.getId());
        com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
        this.f10161q = false;
        this.f10160i.resetDataForEtagEndure(str);
        this.t.ok(this.f10160i);
        throw new com.ss.android.socialbase.downloader.exception.q(str2);
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(String str, com.ss.android.socialbase.downloader.network.h hVar, long j) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        com.ss.android.socialbase.downloader.network.h hVar2;
        long jA;
        if (hVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.s sVar = new com.ss.android.socialbase.downloader.model.s(str, hVar);
            int i2 = sVar.bl;
            String strS = sVar.s();
            if (TextUtils.isEmpty(this.f10160i.getMimeType()) && !TextUtils.isEmpty(strS)) {
                this.f10160i.setMimeType(strS);
            }
            boolean zA = sVar.a();
            this.k = zA;
            this.f10160i.setSupportPartial(zA);
            this.r = sVar.ok();
            String str2 = this.f10160i.geteTag();
            String strBl = sVar.bl();
            String strKf = sVar.kf();
            String strH = sVar.h();
            String str3 = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str3, "dcache=responseCode=" + i2 + " last_modified=" + strKf + " CACHE_CONTROL=" + strH + " max-age=" + sVar.r() + " isDeleteCacheIfCheckFailed=" + this.f10160i.isDeleteCacheIfCheckFailed());
            StringBuilder sb = new StringBuilder();
            sb.append("dcache=firstOffset=");
            sb.append(j);
            sb.append(" cur=");
            sb.append(strKf);
            sb.append(" before=");
            sb.append(this.f10160i.getLastModified());
            sb.append(" cur=");
            String str4 = strBl;
            sb.append(sVar.k());
            sb.append(" before=");
            sb.append(this.f10160i.getTotalBytes());
            com.ss.android.socialbase.downloader.bl.ok.a(str3, sb.toString());
            if (!TextUtils.isEmpty(strH)) {
                this.f10160i.setCacheControl(strH);
                if (sVar.r() > 0) {
                    this.f10160i.setCacheExpiredTime(System.currentTimeMillis() + (sVar.r() * 1000));
                }
            }
            if (this.f10160i.isExpiredRedownload() && this.v && !TextUtils.isEmpty(this.f10158g)) {
                boolean z = false;
                if (i2 == 304 || ((!TextUtils.isEmpty(this.f10160i.getLastModified()) || !this.f10160i.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strKf, this.f10160i.getLastModified()))) {
                    z = true;
                }
                if (!z) {
                    com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
                } else {
                    com.ss.android.socialbase.downloader.bl.ok.a(str3, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + strKf);
                    throw new com.ss.android.socialbase.downloader.exception.ok(this.f10158g);
                }
            }
            if (j > 0 && this.f10160i.isExpiredRedownload() && !TextUtils.equals(strKf, this.f10160i.getLastModified())) {
                com.ss.android.socialbase.downloader.bl.ok.a(str3, "dcache cdn file change, so retry");
                ok("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strKf)) {
                this.f10160i.setLastModified(strKf);
            }
            if (ok(i2, str2, str4)) {
                hVar2 = hVar;
                if (hVar2 instanceof q) {
                    if (!TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        str4 = "";
                    }
                    ok(str4, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.a(1002, i2, "");
                }
            } else {
                hVar2 = hVar;
            }
            if (!this.k && !this.r) {
                if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.a(1004, i2, "response code error : " + i2);
            }
            if (this.r && j > 0) {
                if (hVar2 instanceof q) {
                    ok("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            String str5 = str4;
            long jP = sVar.p();
            if (!(hVar2 instanceof q) && jP < 0 && com.ss.android.socialbase.downloader.q.s.ok(this.f10160i)) {
                throw new BaseException(1004, "");
            }
            String strOk = TextUtils.isEmpty(this.f10160i.getName()) ? com.ss.android.socialbase.downloader.q.kf.ok(hVar2, this.f10160i.getUrl()) : "";
            boolean zQ = sVar.q();
            this.j = zQ;
            if (!zQ && jP == 0 && !(hVar2 instanceof q)) {
                throw new BaseException(1004, "");
            }
            if (zQ) {
                jA = -1;
            } else {
                String strA = com.ss.android.socialbase.downloader.q.kf.a(hVar2, "Content-Range");
                com.ss.android.socialbase.downloader.bl.ok.bl(str3, "firstConnection: contentRange = " + strA);
                if (!TextUtils.isEmpty(strA) && this.fd.a("fix_get_total_bytes", true)) {
                    jA = com.ss.android.socialbase.downloader.q.kf.a(strA);
                    com.ss.android.socialbase.downloader.bl.ok.bl(str3, "firstConnection: 1 totalLength = " + jA);
                } else {
                    long j2 = j + jP;
                    com.ss.android.socialbase.downloader.bl.ok.n(str3, "firstConnection: 2 totalLength = " + j2 + ", contentLength = " + jP);
                    jA = j2;
                }
            }
            if (!TextUtils.isEmpty(this.f10160i.getTaskKey()) && this.f10160i.getTotalBytes() > 0 && jA != this.f10160i.getTotalBytes()) {
                if (hVar2 instanceof q) {
                    ok("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.a(1002, i2, "");
                }
            }
            if (ul()) {
                return;
            }
            if (this.f10160i.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).a("force_check_file_length") == 1 && this.f10160i.getExpectFileLength() != jA) {
                throw new BaseException(1070, "expectFileLength = " + this.f10160i.getExpectFileLength() + " , totalLength = " + jA);
            }
            this.ul.ok(jA, str5, strOk);
        } catch (BaseException e2) {
            throw e2;
        } catch (com.ss.android.socialbase.downloader.exception.q e3) {
            throw e3;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.q.kf.ok(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(a aVar) {
        if (this.p) {
            return;
        }
        synchronized (this) {
            this.kf.remove(aVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public boolean ok(BaseException baseException) {
        if (this.sg != null && com.ss.android.socialbase.downloader.q.kf.q(baseException) && this.n.get() < this.f10160i.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.q.kf.a(baseException)) {
            if (this.p && !this.s) {
                com.ss.android.socialbase.downloader.q.kf.ok(this.f10160i);
                this.s = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.n;
        if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.f10160i.hasNextBackupUrl()) {
            if (baseException == null) {
                return false;
            }
            if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.f10160i.canReplaceHttpForRetry()) {
                return false;
            }
        }
        return !(baseException instanceof com.ss.android.socialbase.downloader.exception.kf);
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onAllChunkRetryWithReset");
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.o = baseException;
        fd();
        if (z ? s(baseException) : false) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f10160i.setForbiddenBackupUrls(list, this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.ok okVarFb = com.ss.android.socialbase.downloader.downloader.bl.fb();
        if (okVarFb != null) {
            okVarFb.j(this.f10160i.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public com.ss.android.socialbase.downloader.exception.p ok(com.ss.android.socialbase.downloader.model.a aVar, BaseException baseException, long j) {
        if (io()) {
            return com.ss.android.socialbase.downloader.exception.p.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.q.kf.p(baseException))) {
            return ok(baseException, j);
        }
        this.o = baseException;
        this.f10160i.increaseCurBytes(-j);
        this.t.ok(this.f10160i);
        if (s(baseException)) {
            return com.ss.android.socialbase.downloader.exception.p.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.kf kfVar = this.ul;
        com.ss.android.socialbase.downloader.constants.p pVar = this.rh;
        com.ss.android.socialbase.downloader.constants.p pVar2 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY;
        kfVar.ok(aVar, baseException, pVar == pVar2);
        if (this.rh != pVar2 && this.f10160i.isNeedRetryDelay()) {
            long jVz = vz();
            if (jVz > 0) {
                com.ss.android.socialbase.downloader.bl.ok.bl(ok, "onSingleChunkRetry with delay time " + jVz);
                try {
                    Thread.sleep(jVz);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.bl.ok.s(ok, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.p.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public com.ss.android.socialbase.downloader.exception.p ok(BaseException baseException, long j) {
        long totalBytes;
        long jOk;
        boolean z;
        this.o = baseException;
        this.f10160i.increaseCurBytes(-j);
        this.t.ok(this.f10160i);
        if (io()) {
            return com.ss.android.socialbase.downloader.exception.p.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.ep != null && !this.f10160i.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.a aVar = new com.ss.android.socialbase.downloader.depend.a() { // from class: com.ss.android.socialbase.downloader.p.bl.1
                    @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.ul
                    public void ok(List<String> list) {
                        super.ok(list);
                        bl.this.ok(list);
                    }
                };
                boolean zOk = this.ep.ok(aVar);
                this.f10160i.setForbiddenRetryed();
                if (zOk) {
                    if (!aVar.ok()) {
                        fd();
                        this.ul.p();
                        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    z = true;
                }
            } else if (s(baseException)) {
                return com.ss.android.socialbase.downloader.exception.p.RETURN;
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.q.kf.p(baseException)) {
            if (this.vz == null) {
                a(baseException);
                return com.ss.android.socialbase.downloader.exception.p.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            x xVar = new x() { // from class: com.ss.android.socialbase.downloader.p.bl.2
                @Override // com.ss.android.socialbase.downloader.depend.x
                public void ok() {
                    synchronized (bl.this) {
                        atomicBoolean.set(true);
                        bl.this.em();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.s) {
                com.ss.android.socialbase.downloader.exception.s sVar = (com.ss.android.socialbase.downloader.exception.s) baseException;
                jOk = sVar.ok();
                totalBytes = sVar.a();
            } else {
                totalBytes = this.f10160i.getTotalBytes();
                jOk = -1;
            }
            synchronized (this) {
                if (this.vz.ok(jOk, totalBytes, xVar)) {
                    if (!com.ss.android.socialbase.downloader.h.ok.ok(this.f10160i.getId()).a("not_delete_when_clean_space", false)) {
                        m();
                    }
                    if (!atomicBoolean.get()) {
                        com.ss.android.socialbase.downloader.constants.p pVar = this.rh;
                        com.ss.android.socialbase.downloader.constants.p pVar2 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (pVar != pVar2) {
                            this.rh = pVar2;
                            fd();
                            this.ul.p();
                        }
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    if (s(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    z = true;
                } else {
                    if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    a(baseException);
                    return com.ss.android.socialbase.downloader.exception.p.RETURN;
                }
            }
        } else {
            if (s(baseException)) {
                return com.ss.android.socialbase.downloader.exception.p.RETURN;
            }
            z = false;
        }
        if (!z && sg()) {
            fd();
        }
        com.ss.android.socialbase.downloader.downloader.kf kfVar = this.ul;
        com.ss.android.socialbase.downloader.constants.p pVar3 = this.rh;
        com.ss.android.socialbase.downloader.constants.p pVar4 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY;
        kfVar.ok(baseException, pVar3 == pVar4);
        return this.rh == pVar4 ? com.ss.android.socialbase.downloader.exception.p.RETURN : com.ss.android.socialbase.downloader.exception.p.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public synchronized com.ss.android.socialbase.downloader.model.a ok(int i2) {
        com.ss.android.socialbase.downloader.model.a aVarOk;
        if (this.f10160i.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.a> listBl = this.t.bl(this.f10160i.getId());
        if (listBl != null && !listBl.isEmpty()) {
            for (int i3 = 0; i3 < listBl.size(); i3++) {
                com.ss.android.socialbase.downloader.model.a aVar = listBl.get(i3);
                if (aVar != null && (aVarOk = ok(aVar, i2)) != null) {
                    return aVarOk;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(com.ss.android.socialbase.downloader.network.h hVar) {
        boolean z;
        if (hVar != null) {
            try {
                int iA = hVar.a();
                this.f10160i.setHttpStatusCode(iA);
                this.f10160i.setHttpStatusMessage(com.ss.android.socialbase.downloader.q.a.ok(iA));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.f10160i.setHttpStatusCode(-1);
        this.f10160i.setHttpStatusMessage("");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.model.a ok(com.ss.android.socialbase.downloader.model.a r9, int r10) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(com.ss.android.socialbase.downloader.model.a, int):com.ss.android.socialbase.downloader.model.a");
    }

    private zz ok(DownloadTask downloadTask) {
        zz retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.x(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.bl.xy();
    }

    public void ok(Future future) {
        this.f10156a = future;
    }
}
