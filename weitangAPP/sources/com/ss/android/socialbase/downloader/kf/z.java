package com.ss.android.socialbase.downloader.kf;

import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f10097a;
    public final int bl;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10098e;
    private boolean em;
    private volatile boolean ep;
    private int er;
    private int fb;
    private BaseException fd;
    private int fl;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f10100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.s f10101i;
    private final bl j;
    public String k;
    public volatile long kf;
    private volatile boolean kz;
    private volatile boolean m;
    public volatile long n;
    private Future o;
    public volatile q ok;
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10102q;
    private com.ss.android.socialbase.downloader.q.n qu;
    private final kf r;
    private final com.ss.android.socialbase.downloader.h.ok rh;
    public volatile long s;
    private boolean sg;
    private com.ss.android.socialbase.downloader.network.q t;
    private long td;
    private volatile long u;
    private volatile long ul;
    private long v;
    private Thread vz;
    private volatile boolean y;
    private final DownloadInfo z;
    private volatile long zz;
    private final List<q> x = new ArrayList();
    private volatile long io = -1;

    public z(DownloadInfo downloadInfo, r rVar, bl blVar, x xVar, int i2) {
        this.z = downloadInfo;
        this.r = rVar;
        this.j = blVar;
        this.rh = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        this.f10097a = xVar;
        this.bl = i2;
    }

    private void a(q qVar) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        bl(qVar);
        this.r.ok(this, qVar, this.f10097a, this.f10101i);
        this.f10097a.bl();
    }

    private void bl(q qVar) throws BaseException {
        String strReplaceFirst;
        String str;
        com.ss.android.socialbase.downloader.network.q qVarOk;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.n = 0L;
                this.s = jCurrentTimeMillis;
                this.td = qVar.n();
                this.u = qVar.kf();
                if (this.u > 0 && this.td > this.u) {
                    throw new k(6, "createConn, " + qVar);
                }
                this.qu = new com.ss.android.socialbase.downloader.q.n();
                List<com.ss.android.socialbase.downloader.model.bl> listOk = com.ss.android.socialbase.downloader.q.kf.ok(this.z.getExtraHeaders(), this.z.geteTag(), this.td, this.u);
                listOk.add(new com.ss.android.socialbase.downloader.model.bl("Segment-Index", String.valueOf(qVar.h())));
                listOk.add(new com.ss.android.socialbase.downloader.model.bl("Thread-Index", String.valueOf(this.bl)));
                com.ss.android.socialbase.downloader.q.kf.ok(listOk, this.z);
                com.ss.android.socialbase.downloader.q.kf.a(listOk, this.z);
                strReplaceFirst = this.f10097a.ok;
                if (this.f10098e && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith("https")) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("https", "http");
                }
                str = this.f10097a.f10094a;
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + qVar + ", threadIndex = " + this.bl);
                this.p = strReplaceFirst;
                this.f10102q = str;
                qVarOk = com.ss.android.socialbase.downloader.downloader.bl.ok(this.z.isNeedDefaultHttpServiceBackUp(), this.z.getMaxBytes(), strReplaceFirst, str, listOk, 0, jCurrentTimeMillis - this.v > 3000 && this.rh.a("monitor_download_connect") > 0, this.z);
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.q.kf.ok(th, "createConn");
            }
            if (qVarOk == null) {
                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
            }
            this.t = qVarOk;
            this.f10101i = new com.ss.android.socialbase.downloader.model.s(strReplaceFirst, qVarOk);
            if (this.y) {
                throw new i("createConn");
            }
            if (qVarOk instanceof com.ss.android.socialbase.downloader.network.ok) {
                this.k = ((com.ss.android.socialbase.downloader.network.ok) qVarOk).n();
            }
            Log.i("SegmentReader", "createConnectionSuccess: url = " + strReplaceFirst + ", ip = " + str + ", hostRealIp = " + this.k + ", threadIndex = " + this.bl);
        } finally {
            this.n = System.currentTimeMillis();
        }
    }

    private void j() {
        this.fb = this.f10097a.s ? this.z.getRetryCount() : this.z.getBackUpUrlRetryCount();
        this.f10099g = 0;
    }

    private void k() {
        com.ss.android.socialbase.downloader.network.q qVar = this.t;
        if (qVar != null) {
            try {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "closeConnection: thread = " + this.bl);
                qVar.s();
                qVar.bl();
            } catch (Throwable unused) {
            }
        }
    }

    private boolean ok(q qVar) throws BaseException {
        r();
        while (true) {
            try {
                a(qVar);
                s(qVar);
                return true;
            } catch (k e2) {
                this.fd = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.bl.ok.n("SegmentReader", "download: e = " + th + ", threadIndex = " + this.bl + ", reconnect = " + this.m + ", closed = " + this.y);
                    if (this.y) {
                        return false;
                    }
                    if (this.m) {
                        this.m = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.ep) {
                            this.ep = false;
                            throw new k(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.q.kf.ok((Throwable) th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !ok(qVar, e3)) {
                            return false;
                        }
                    }
                } finally {
                    q();
                }
            }
        }
        return false;
    }

    private void q() {
        this.v = this.s;
        this.s = -1L;
        this.n = -1L;
        this.kf = -1L;
        this.f10100h = -1L;
        k();
    }

    private void r() {
        this.f10098e = false;
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017d A[Catch: all -> 0x0271, BaseException -> 0x0276, TryCatch #24 {BaseException -> 0x0276, all -> 0x0271, blocks: (B:84:0x016b, B:86:0x0176, B:87:0x017d, B:89:0x0183, B:91:0x0189, B:94:0x0192, B:95:0x0196), top: B:252:0x016b }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:75:0x0159
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s(com.ss.android.socialbase.downloader.kf.q r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.z.s(com.ss.android.socialbase.downloader.kf.q):void");
    }

    private long z() {
        long j = this.zz;
        this.zz = 0L;
        return j <= 0 ? RecyclerView.FOREVER_NS : j;
    }

    public boolean h() {
        return this.em;
    }

    public void kf() {
        ok(false);
    }

    public void n() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "close: threadIndex = " + this.bl);
        synchronized (this) {
            this.y = true;
            this.kz = true;
        }
        k();
        Future future = this.o;
        if (future != null) {
            this.o = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public long p() {
        return this.td;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r6.ok = null;
        r2 = r6.r;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.z.run():void");
    }

    public long a() {
        long jBl;
        synchronized (this.r) {
            jBl = this.ul + bl();
        }
        return jBl;
    }

    public void a(boolean z) {
        this.em = z;
    }

    public void a(long j) {
        long j2 = this.io;
        com.ss.android.socialbase.downloader.q.n nVar = this.qu;
        if (j2 < 0 || nVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.bl);
        nVar.ok(j2, j);
    }

    public boolean ok(x xVar) {
        int i2 = this.fl;
        if (i2 >= 30) {
            return false;
        }
        this.fl = i2 + 1;
        x xVar2 = this.f10097a;
        if (xVar2 != null) {
            xVar2.a(this);
        }
        xVar.ok(this);
        this.f10097a = xVar;
        j();
        return true;
    }

    private boolean ok(q qVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.f10099g + ", retryCount = " + this.fb);
        this.fd = baseException;
        this.f10097a.a();
        this.r.ok(this, this.f10097a, qVar, baseException, this.f10099g, this.fb);
        int i2 = this.f10099g;
        if (i2 < this.fb) {
            this.f10099g = i2 + 1;
            return true;
        }
        if (ok(baseException)) {
            return true;
        }
        this.r.ok(this, this.f10097a, qVar, baseException);
        return false;
    }

    public long bl() {
        synchronized (this.r) {
            long j = this.io;
            long j2 = this.td;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    private boolean ok(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.q.kf.bl(baseException)) {
            return false;
        }
        String str = this.f10097a.ok;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.z.isNeedHttpsToHttpRetry() || this.f10098e) {
            return false;
        }
        this.f10098e = true;
        j();
        return true;
    }

    public void bl(boolean z) {
        this.sg = z;
    }

    private ok ok(bl blVar, InputStream inputStream) throws Throwable {
        int i2;
        ok okVarA = blVar.a();
        try {
            i2 = inputStream.read(okVarA.ok);
            try {
                if (i2 != -1) {
                    okVarA.bl = i2;
                    if (i2 == -1) {
                        blVar.ok(okVarA);
                    }
                    return okVarA;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th) {
                th = th;
                if (i2 == -1) {
                    blVar.ok(okVarA);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = -1;
        }
    }

    public boolean ok(long j) {
        long j2 = this.u;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.zz = j;
        this.kz = true;
        return true;
    }

    public void ok() {
        x xVar = this.f10097a;
        try {
            synchronized (this.r) {
                long jBl = bl();
                if (jBl > 0) {
                    this.ul += jBl;
                    xVar.ok(jBl);
                }
                this.io = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void ok(boolean z) {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "reconnect: threadIndex = " + this.bl);
        synchronized (this) {
            this.ep = z;
            this.m = true;
            this.kz = true;
        }
        k();
        Thread thread = this.vz;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.bl);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void ok(Future future) {
        this.o = future;
    }

    public long ok(long j, long j2) {
        com.ss.android.socialbase.downloader.q.n nVar = this.qu;
        if (nVar == null) {
            return -1L;
        }
        return nVar.a(j, j2);
    }

    public long s() {
        return this.io;
    }
}
