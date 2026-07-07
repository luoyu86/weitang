package com.ss.android.socialbase.downloader.kf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final DownloadInfo bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final bl f10080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f10081i;
    private final com.ss.android.socialbase.downloader.p.kf kf;
    private final com.ss.android.socialbase.downloader.h.ok n;
    private BaseException p;
    private final long rh;
    private final long t;
    private long x;
    private final boolean z;
    private final List<j> ok = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<j> f10079a = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f10082q = false;
    private volatile boolean k = false;
    private volatile boolean r = false;
    private volatile long td = 0;
    private volatile long zz = 0;
    private final com.ss.android.socialbase.downloader.downloader.k s = com.ss.android.socialbase.downloader.downloader.bl.m();
    private final com.ss.android.socialbase.downloader.ok.ok j = com.ss.android.socialbase.downloader.ok.ok.ok();

    public h(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.p.kf kfVar, bl blVar) {
        this.bl = downloadInfo;
        this.kf = kfVar;
        this.f10080h = blVar;
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        this.n = okVarOk;
        boolean z = okVarOk.ok("sync_strategy", 0) == 1;
        this.z = z;
        if (z) {
            long jOk = okVarOk.ok("sync_interval_ms_fg", 5000);
            long jOk2 = okVarOk.ok("sync_interval_ms_bg", 1000);
            this.rh = Math.max(jOk, 500L);
            this.t = Math.max(jOk2, 500L);
        } else {
            this.rh = 0L;
            this.t = 0L;
        }
        this.f10081i = okVarOk.a("monitor_rw") == 1;
    }

    private void a(List<j> list) throws IOException {
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            it.next().bl();
        }
    }

    private void bl() throws IOException {
        boolean z = this.f10081i;
        long jNanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.bl;
        com.ss.android.socialbase.downloader.downloader.k kVar = this.s;
        List<j> list = this.ok;
        List<j> list2 = this.f10079a;
        Map<Long, q> mapJ = kVar.j(downloadInfo.getId());
        if (mapJ == null) {
            mapJ = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            ok(list);
            try {
                a(list);
                z2 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ok(list, mapJ);
            if (list2.size() > 0) {
                bl(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            downloadInfo.updateRealDownloadTime(true);
            kVar.ok(downloadInfo.getId(), mapJ);
            kVar.ok(downloadInfo);
            this.td = downloadInfo.getCurBytes();
        }
        if (z) {
            this.x += System.nanoTime() - jNanoTime;
        }
    }

    private boolean ok(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public void ok(j jVar) {
        synchronized (this) {
            this.ok.add(jVar);
        }
    }

    public void a() {
        this.k = true;
        this.f10082q = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
    
        if (r13 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
    
        r3.a(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f3 A[Catch: all -> 0x03d7, TryCatch #28 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ff A[Catch: all -> 0x03d7, TryCatch #28 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032f A[Catch: all -> 0x03d7, TryCatch #28 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03bb A[Catch: all -> 0x03d7, TryCatch #28 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0362 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0415 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x03f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ok(com.ss.android.socialbase.downloader.kf.s r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1131
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.h.ok(com.ss.android.socialbase.downloader.kf.s):void");
    }

    private void bl(List<j> list) {
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            it.next().s();
        }
    }

    private void ok(long j, boolean z) throws IOException {
        long j2 = j - this.zz;
        if (this.z) {
            if (j2 > (this.j.a() ? this.rh : this.t)) {
                bl();
                this.zz = j;
                return;
            }
            return;
        }
        long curBytes = this.bl.getCurBytes() - this.td;
        if (z || ok(curBytes, j2)) {
            bl();
            this.zz = j;
        }
    }

    private void ok(n nVar) {
        synchronized (this) {
            this.f10079a.add((j) nVar);
        }
    }

    private void ok(List<j> list) throws IOException {
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void ok(List<j> list, Map<Long, q> map) {
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            q qVarN = it.next().n();
            q qVar = map.get(Long.valueOf(qVarN.bl()));
            if (qVar == null) {
                map.put(Long.valueOf(qVarN.bl()), new q(qVarN));
            } else {
                qVar.ok(qVarN.s());
                qVar.bl(qVarN.kf());
            }
        }
    }

    public void ok() {
        this.r = true;
        this.f10082q = true;
    }
}
