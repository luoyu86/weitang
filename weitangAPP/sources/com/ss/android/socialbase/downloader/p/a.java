package com.ss.android.socialbase.downloader.p;

import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.q;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {
    private static final String ok = a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.a f10153a;
    private com.ss.android.socialbase.downloader.model.a bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kf f10154h;
    private boolean j;
    private volatile boolean k;
    private DownloadInfo kf;
    private final DownloadTask n;
    private q p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k f10155q;
    private volatile boolean r;
    private com.ss.android.socialbase.downloader.downloader.n s;

    public a(com.ss.android.socialbase.downloader.model.a aVar, DownloadTask downloadTask, kf kfVar) {
        this.j = false;
        this.bl = aVar;
        this.n = downloadTask;
        if (downloadTask != null) {
            this.kf = downloadTask.getDownloadInfo();
        }
        this.f10154h = kfVar;
        this.f10155q = com.ss.android.socialbase.downloader.downloader.bl.m();
        this.bl.ok(this);
    }

    private String bl() {
        return this.kf.getConnectionUrl();
    }

    private boolean n() {
        return this.k || this.r;
    }

    private void s() {
        q qVar = this.p;
        if (qVar != null) {
            qVar.s();
            this.p = null;
        }
    }

    public void a() {
        this.r = true;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.s;
        if (nVar != null) {
            nVar.bl();
        }
    }

    public void ok(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.n nVar = this.s;
        if (nVar == null) {
            return;
        }
        nVar.ok(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r3.f10153a.ok(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.a r0 = r3.bl
            r3.f10153a = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.a r1 = r3.f10153a     // Catch: java.lang.Throwable -> L5d
            r1.ok(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f10153a     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.ok(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f10153a     // Catch: java.lang.Throwable -> L5d
            r1.ok(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.a r1 = r3.f10153a     // Catch: java.lang.Throwable -> L5d
            r1.ok(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.n()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.p.kf r1 = r3.f10154h     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r2 = r3.f10153a     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.zz()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r1 = r1.ok(r2)     // Catch: java.lang.Throwable -> L5d
            r3.f10153a = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.n()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f10153a     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L42
            goto L4d
        L42:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.model.a r1 = r3.f10153a
            if (r1 == 0) goto L54
            r1.ok(r0)
        L54:
            r3.s()
            com.ss.android.socialbase.downloader.p.kf r0 = r3.f10154h
            r0.ok(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.a r2 = r3.f10153a
            if (r2 == 0) goto L65
            r2.ok(r0)
        L65:
            r3.s()
            com.ss.android.socialbase.downloader.p.kf r0 = r3.f10154h
            r0.ok(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.a.run():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01ba A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc A[Catch: all -> 0x029f, TRY_ENTER, TryCatch #16 {all -> 0x029f, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:167:0x0247, B:169:0x024d, B:171:0x025a, B:175:0x0262, B:170:0x0254, B:161:0x022e, B:162:0x023a, B:177:0x026d, B:179:0x0275, B:181:0x027d, B:183:0x0285, B:185:0x028d, B:188:0x0296, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:214:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff A[Catch: all -> 0x01b2, BaseException -> 0x01ce, TRY_ENTER, TryCatch #3 {BaseException -> 0x01ce, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:62:0x00f5, B:66:0x00ff, B:68:0x0103, B:79:0x0131, B:51:0x00db), top: B:198:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ok(com.ss.android.socialbase.downloader.model.a r31) {
        /*
            Method dump skipped, instruction units count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.a.ok(com.ss.android.socialbase.downloader.model.a):boolean");
    }

    public a(com.ss.android.socialbase.downloader.model.a aVar, DownloadTask downloadTask, q qVar, kf kfVar) {
        this(aVar, downloadTask, kfVar);
        this.p = qVar;
    }

    private void ok(com.ss.android.socialbase.downloader.model.a aVar, long j) {
        com.ss.android.socialbase.downloader.model.a aVarN = aVar.s() ? aVar.n() : aVar;
        if (aVarN != null) {
            if (aVarN.p()) {
                this.f10155q.ok(aVarN.r(), aVarN.a(), j);
            }
            aVarN.a(j);
            this.f10155q.ok(aVarN.r(), aVarN.zz(), aVarN.a(), j);
            return;
        }
        if (aVar.s()) {
            this.f10155q.ok(aVar.r(), aVar.zz(), j);
        }
    }

    public void ok() {
        this.k = true;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.s;
        if (nVar != null) {
            nVar.a();
        }
    }
}
