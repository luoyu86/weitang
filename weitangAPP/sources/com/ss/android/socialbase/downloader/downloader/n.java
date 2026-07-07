package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10031a = "ResponseHandler";
    private final DownloadInfo bl;
    private boolean ep;
    private long er;
    private long fb;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f10033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f10034i;
    private final com.ss.android.socialbase.downloader.ok.ok io;
    private volatile boolean j;
    private com.ss.android.socialbase.downloader.model.n k;
    private final com.ss.android.socialbase.downloader.network.q kf;
    private long kz;
    private final boolean m;
    private final com.ss.android.socialbase.downloader.model.a n;
    private final long o;
    private com.ss.android.socialbase.downloader.impls.r p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private u f10035q;
    private BaseException r;
    private final com.ss.android.socialbase.downloader.p.kf rh;
    private final String s;
    private long t;
    private volatile long td;
    private final com.ss.android.socialbase.downloader.h.ok u;
    private final boolean ul;
    private long vz;
    private volatile long x;
    private final long y;
    private volatile boolean z;
    private final boolean zz;
    public boolean ok = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f10032g = 0;
    private volatile long v = 0;

    public n(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.q qVar, com.ss.android.socialbase.downloader.model.a aVar, com.ss.android.socialbase.downloader.p.kf kfVar) {
        this.bl = downloadInfo;
        this.s = str;
        k kVarM = bl.m();
        this.f10033h = kVarM;
        if (kVarM instanceof com.ss.android.socialbase.downloader.impls.s) {
            com.ss.android.socialbase.downloader.impls.s sVar = (com.ss.android.socialbase.downloader.impls.s) kVarM;
            this.p = sVar.ok();
            this.f10035q = sVar.kf();
        }
        this.kf = qVar;
        this.n = aVar;
        this.rh = kfVar;
        long jRh = aVar.rh();
        this.t = jRh;
        this.f10034i = jRh;
        if (aVar.s()) {
            this.td = aVar.x();
        } else {
            this.td = aVar.bl(false);
        }
        this.x = aVar.i();
        this.io = com.ss.android.socialbase.downloader.ok.ok.ok();
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        this.u = okVarOk;
        boolean z = okVarOk.ok("sync_strategy", 0) == 1;
        this.ul = z;
        if (z) {
            long jOk = okVarOk.ok("sync_interval_ms_fg", 5000);
            long jOk2 = okVarOk.ok("sync_interval_ms_bg", 1000);
            this.o = Math.max(jOk, 500L);
            this.y = Math.max(jOk2, 500L);
        } else {
            this.o = 0L;
            this.y = 0L;
        }
        this.m = okVarOk.a("monitor_rw") == 1;
        this.zz = com.ss.android.socialbase.downloader.q.ok.ok(65536);
    }

    private boolean a(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    private void h() {
        ExecutorService executorServiceJ;
        if (this.kf == null || (executorServiceJ = bl.j()) == null) {
            return;
        }
        executorServiceJ.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.kf.s();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private boolean kf() {
        return this.j || this.z;
    }

    private void p() {
        boolean z;
        long jNanoTime = this.m ? System.nanoTime() : 0L;
        try {
            this.k.ok();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.bl.updateRealDownloadTime(true);
            boolean z2 = this.bl.getChunkCount() > 1;
            z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(com.ss.android.socialbase.downloader.q.kf.a());
            if (z2) {
                ok(this.f10035q);
                if (zVarOk != null) {
                    zVarOk.bl(this.bl);
                } else {
                    this.f10035q.ok(this.bl.getId(), this.bl.getCurBytes());
                }
            } else if (zVarOk != null) {
                zVarOk.bl(this.bl);
            } else {
                this.f10035q.ok(this.n.r(), this.t);
            }
            this.f10032g = this.t;
        }
        if (this.m) {
            this.er += System.nanoTime() - jNanoTime;
        }
    }

    public void a() {
        if (this.j) {
            return;
        }
        this.j = true;
        h();
    }

    public void bl() {
        if (this.z) {
            return;
        }
        synchronized (this.rh) {
            this.z = true;
        }
        h();
    }

    public long n() {
        return this.f10032g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02e1 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:351:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0361 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:351:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e9  */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v12 */
    /* JADX WARN: Type inference failed for: r32v13 */
    /* JADX WARN: Type inference failed for: r32v14 */
    /* JADX WARN: Type inference failed for: r32v15 */
    /* JADX WARN: Type inference failed for: r32v16 */
    /* JADX WARN: Type inference failed for: r32v17 */
    /* JADX WARN: Type inference failed for: r32v18 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3, types: [long] */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.n.s():void");
    }

    public long ok() {
        return this.t;
    }

    public void ok(long j, long j2, long j3) {
        this.t = j;
        this.f10034i = j;
        this.x = j2;
        this.td = j3;
    }

    public void ok(long j, long j2) {
        this.x = j;
        this.td = j2;
    }

    private com.ss.android.socialbase.downloader.n.a ok(InputStream inputStream) {
        int iFd = bl.fd();
        if (this.u.ok("rw_concurrent", 0) == 1 && this.bl.getChunkCount() == 1 && this.bl.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.n.ok okVar = new com.ss.android.socialbase.downloader.n.ok(inputStream, iFd, this.u.ok("rw_concurrent_max_buffer_count", 4));
                this.ep = true;
                return okVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.n.bl blVar = new com.ss.android.socialbase.downloader.n.bl(inputStream, iFd);
        this.ep = false;
        return blVar;
    }

    private void ok(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.v;
        if (this.ul) {
            if (j > (this.io.a() ? this.o : this.y)) {
                p();
                this.v = jUptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.t - this.f10032g;
        if (z || a(j2, j)) {
            p();
            this.v = jUptimeMillis;
        }
    }

    private void ok(k kVar) {
        com.ss.android.socialbase.downloader.model.a aVarN;
        com.ss.android.socialbase.downloader.model.a aVar;
        if (kVar == null) {
            return;
        }
        z zVarOk = null;
        boolean z = kVar instanceof com.ss.android.socialbase.downloader.a.n;
        if (z && (zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(com.ss.android.socialbase.downloader.q.kf.a())) == null) {
            return;
        }
        z zVar = zVarOk;
        if (this.n.s()) {
            aVarN = this.n.n();
        } else {
            aVarN = this.n;
        }
        com.ss.android.socialbase.downloader.model.a aVar2 = aVarN;
        if (aVar2 != null) {
            aVar2.a(this.t);
            if (z && zVar != null) {
                zVar.ok(aVar2.r(), aVar2.zz(), aVar2.a(), this.t);
                aVar = aVar2;
            } else {
                aVar = aVar2;
                kVar.ok(aVar2.r(), aVar2.zz(), aVar2.a(), this.t);
            }
            if (aVar.p()) {
                boolean z2 = false;
                if (aVar.q()) {
                    long jK = aVar.k();
                    if (jK > this.t) {
                        if (z && zVar != null) {
                            zVar.ok(aVar.r(), aVar.a(), jK);
                        } else {
                            kVar.ok(aVar.r(), aVar.a(), jK);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && zVar != null) {
                    zVar.ok(aVar.r(), aVar.a(), this.t);
                    return;
                } else {
                    kVar.ok(aVar.r(), aVar.a(), this.t);
                    return;
                }
            }
            return;
        }
        if (this.n.s()) {
            if (z && zVar != null) {
                zVar.ok(this.n.r(), this.n.zz(), this.t);
            } else {
                kVar.ok(this.n.r(), this.n.zz(), this.t);
            }
        }
    }
}
