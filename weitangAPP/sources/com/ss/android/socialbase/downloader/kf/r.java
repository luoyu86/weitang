package com.ss.android.socialbase.downloader.kf;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.bl;
import com.ss.android.socialbase.downloader.p.n;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r implements kf, bl.ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rh f10088a;
    private final a bl;
    private float ep;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10090i;
    private final com.ss.android.socialbase.downloader.p.n io;
    private com.ss.android.socialbase.downloader.model.s k;
    private final boolean kz;
    private long m;
    private final h n;
    private long o;
    private final DownloadInfo ok;
    private com.ss.android.socialbase.downloader.model.s r;
    private final com.ss.android.socialbase.downloader.p.kf s;
    private volatile boolean td;
    private final com.ss.android.socialbase.downloader.q.n u;
    private int vz;
    private BaseException x;
    private long y;
    private long z;
    private volatile boolean kf = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f10089h = false;
    private final List<z> p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List<x> f10091q = new ArrayList();
    private volatile boolean j = true;
    private final LinkedList<q> rh = new LinkedList<>();
    private final List<q> t = new ArrayList();
    private final Object zz = new Object();
    private volatile boolean ul = false;
    private final n.a er = new n.a() { // from class: com.ss.android.socialbase.downloader.kf.r.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10092a;

        @Override // com.ss.android.socialbase.downloader.p.n.a
        public long ok() {
            if (r.this.kf || r.this.f10089h) {
                return -1L;
            }
            synchronized (r.this) {
                if (r.this.k == null && r.this.r == null) {
                    long j = r.this.o;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.f10092a++;
                    z zVarOk = r.this.ok(false, System.currentTimeMillis(), j);
                    if (zVarOk == null) {
                        return j;
                    }
                    Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                    r.this.bl(zVarOk);
                    zVarOk.kf();
                    return ((long) ((this.f10092a / r.this.f10091q.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    private final n.a fb = new n.a() { // from class: com.ss.android.socialbase.downloader.kf.r.2
        @Override // com.ss.android.socialbase.downloader.p.n.a
        public long ok() {
            return r.this.td();
        }
    };

    public r(@NonNull DownloadInfo downloadInfo, @NonNull rh rhVar, com.ss.android.socialbase.downloader.p.kf kfVar) {
        this.ok = downloadInfo;
        this.f10088a = rhVar;
        a aVar = new a(rhVar.s(), rhVar.n());
        this.bl = aVar;
        this.s = kfVar;
        this.n = new h(downloadInfo, kfVar, aVar);
        this.io = new com.ss.android.socialbase.downloader.p.n();
        this.u = new com.ss.android.socialbase.downloader.q.n();
        this.kz = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a(TTLiveConstants.INIT_DEBUG) == 1;
    }

    private q i() {
        int i2 = 0;
        while (true) {
            q qVarX = x();
            if (qVarX == null) {
                return null;
            }
            z zVar = qVarX.ok;
            if (zVar == null) {
                return qVarX;
            }
            if (qVarX.k() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            a(jCurrentTimeMillis);
            if (jCurrentTimeMillis - zVar.kf > 2000 && ok(zVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.kz) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + qVarX + ", owner.threadIndex = " + zVar.bl);
                }
                return qVarX;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.kz) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + qVarX);
                }
                return qVarX;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private boolean j() {
        Iterator<z> it = this.p.iterator();
        while (it.hasNext()) {
            if (!it.next().h()) {
                return false;
            }
        }
        return true;
    }

    private x k() {
        x xVar;
        synchronized (this) {
            int size = this.f10090i % this.f10091q.size();
            if (this.f10088a.a()) {
                this.f10090i++;
            }
            xVar = this.f10091q.get(size);
        }
        return xVar;
    }

    private void p() {
        if (this.y > 0) {
            this.m = System.currentTimeMillis();
            this.io.ok(this.fb, 0L);
        }
    }

    private void q() {
        List<String> backUpUrls;
        int iJ = this.f10088a.j();
        if (iJ <= 0) {
            this.j = false;
            n();
            return;
        }
        com.ss.android.socialbase.downloader.network.bl blVarOk = com.ss.android.socialbase.downloader.network.bl.ok();
        blVarOk.ok(this.ok.getUrl(), this, 2000L);
        if (iJ <= 2 || (backUpUrls = this.ok.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                blVarOk.ok(str, this, 2000L);
            }
        }
    }

    private void r() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "onComplete");
        this.bl.bl();
        synchronized (this.zz) {
            this.zz.notify();
        }
    }

    private boolean rh() {
        long j = this.z;
        if (j <= 0) {
            this.td = false;
            return false;
        }
        synchronized (this) {
            long jOk = t.ok(this.t);
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + jOk);
            if (jOk >= j) {
                this.td = true;
                return true;
            }
            this.td = false;
            return false;
        }
    }

    private long t() {
        Iterator<z> it = this.p.iterator();
        long jA = 0;
        while (it.hasNext()) {
            jA += it.next().a();
        }
        return jA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long td() {
        if (this.kf || this.f10089h) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            a(jCurrentTimeMillis);
            long jR = this.f10088a.r();
            if (jR > 0) {
                long j = this.m;
                if (j > 0 && jCurrentTimeMillis - j > jR && ok(jCurrentTimeMillis, jR)) {
                    this.m = jCurrentTimeMillis;
                    this.vz++;
                }
            }
        }
        return 2000L;
    }

    private q x() {
        int iK;
        q qVar = null;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (q qVar2 : this.t) {
            if (ok(qVar2) > 0 && (iK = qVar2.k()) < i2) {
                qVar = qVar2;
                i2 = iK;
            }
        }
        return qVar;
    }

    private void z() {
        int size;
        if (this.z > 0 && (size = this.t.size()) > 1) {
            ArrayList<q> arrayList = null;
            int i2 = 0;
            for (int i3 = 1; i3 < size; i3++) {
                q qVar = this.t.get(i2);
                q qVar2 = this.t.get(i3);
                if (qVar.n() > qVar2.bl() && qVar2.ok() <= 0 && qVar2.ok == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(qVar2);
                    if (this.kz) {
                        Log.w("SegmentDispatcher", "clearCovered, covered = " + qVar2 + ", prev = " + qVar);
                    }
                } else if (qVar2.n() > qVar.n()) {
                    i2++;
                }
            }
            if (arrayList != null) {
                for (q qVar3 : arrayList) {
                    this.t.remove(qVar3);
                    for (z zVar : this.p) {
                        if (zVar.ok == qVar3) {
                            if (this.kz) {
                                Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + qVar3 + ", threadIndex = " + zVar.bl);
                            }
                            zVar.ok(true);
                        }
                    }
                }
            }
        }
    }

    private void a(List<q> list) {
        long totalBytes = this.ok.getTotalBytes();
        this.z = totalBytes;
        if (totalBytes <= 0) {
            this.z = this.ok.getExpectFileLength();
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.z);
        }
        synchronized (this) {
            this.rh.clear();
            if (list == null || list.isEmpty()) {
                ok((List<q>) this.rh, new q(0L, -1L), false);
            } else {
                Iterator<q> it = list.iterator();
                while (it.hasNext()) {
                    ok((List<q>) this.rh, new q(it.next()), false);
                }
                s(this.rh);
                bl(this.rh);
            }
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "initSegments: totalLength = " + this.z);
        }
    }

    private void bl() throws InterruptedException, BaseException {
        BaseException baseException;
        synchronized (this.zz) {
            if (this.k == null && this.r == null) {
                this.zz.wait();
            }
        }
        if (this.k == null && this.r == null && (baseException = this.x) != null) {
            throw baseException;
        }
    }

    private void h() {
        rh rhVar = this.f10088a;
        this.o = rhVar.k();
        this.y = rhVar.r();
        this.ep = rhVar.t();
        int i2 = this.vz;
        if (i2 > 0) {
            this.io.ok(this.er, i2);
        }
    }

    private void kf() {
        this.f10091q.add(new x(this.ok.getUrl(), true));
        List<String> backUpUrls = this.ok.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f10091q.add(new x(str, false));
                }
            }
        }
        this.f10088a.ok(this.f10091q.size());
    }

    private void n() {
        int iOk;
        if (this.z <= 0 || this.j) {
            iOk = 1;
        } else {
            iOk = this.f10088a.ok();
            int iP = (int) (this.z / this.f10088a.p());
            if (iOk > iP) {
                iOk = iP;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.z + ", threadCount = " + iOk);
        int i2 = iOk > 0 ? iOk : 1;
        synchronized (this) {
            while (this.p.size() < i2) {
                if (!this.f10089h && !this.kf) {
                    ok(k());
                    if (this.f10088a.kf()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void s() throws BaseException {
        try {
            this.n.ok((s) this.bl);
        } catch (i unused) {
        } catch (BaseException e2) {
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
            ok(e2);
            throw e2;
        }
        if (this.f10089h || this.kf) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.rh.isEmpty()) {
                    q qVarPoll = this.rh.poll();
                    if (qVarPoll != null) {
                        ok(this.t, qVarPoll, true);
                    }
                }
                bl(this.t);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.ul || this.x == null) {
            if (this.ok.getCurBytes() != this.ok.getTotalBytes()) {
                com.ss.android.socialbase.downloader.s.ok.ok(this.ok, this.t);
            }
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "dispatchSegments::download finished");
        } else {
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.x);
            throw this.x;
        }
    }

    public boolean ok(List<q> list) throws InterruptedException, BaseException {
        try {
            kf();
            a(list);
            n();
            h();
            q();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                bl();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.ok.increaseAllConnectTime(jCurrentTimeMillis2);
                this.ok.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.f10089h && !this.kf) {
                    this.s.ok(this.z);
                    p();
                    s();
                    return true;
                }
                if (!this.f10089h && !this.kf) {
                    com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "finally pause");
                    a();
                }
                this.io.a();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.ok.increaseAllConnectTime(jCurrentTimeMillis3);
                this.ok.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.f10089h && !this.kf) {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "finally pause");
                a();
            }
            this.io.a();
        }
    }

    private void bl(List<q> list) {
        long jA = t.a(list);
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.ok.getCurBytes() + ", totalBytes = " + this.ok.getTotalBytes() + ", downloadedBytes = " + jA);
        if (jA > this.ok.getTotalBytes() && this.ok.getTotalBytes() > 0) {
            jA = this.ok.getTotalBytes();
        }
        if (this.ok.getCurBytes() == this.ok.getTotalBytes() || this.ok.getCurBytes() == jA) {
            return;
        }
        this.ok.setCurBytes(jA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        if ((r10.n() - r24.n()) < (r14 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n(com.ss.android.socialbase.downloader.kf.z r23, com.ss.android.socialbase.downloader.kf.q r24) throws com.ss.android.socialbase.downloader.kf.k {
        /*
            Method dump skipped, instruction units count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.r.n(com.ss.android.socialbase.downloader.kf.z, com.ss.android.socialbase.downloader.kf.q):void");
    }

    private void a(String str, List<x> list) {
        int iOk;
        if (this.kz) {
            Iterator<x> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int iJ = this.f10088a.j();
        if ((iJ == 1 || iJ == 3) && (iOk = ok(str)) >= 0 && iOk < this.f10091q.size()) {
            this.f10091q.addAll(iOk + 1, list);
        } else {
            this.f10091q.addAll(list);
        }
    }

    private List<x> bl(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.kz) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        x xVar = new x(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(xVar.bl);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(xVar.bl, linkedList);
                        }
                        linkedList.add(xVar);
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((x) linkedList2.pollFirst());
                            i2--;
                            z = true;
                        }
                    }
                    if (i2 <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void s(List<q> list) {
        q qVar = list.get(0);
        long jBl = qVar.bl();
        if (jBl > 0) {
            q qVar2 = new q(0L, jBl - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + qVar + ", add new first = " + qVar2);
            ok(list, qVar2, true);
        }
        Iterator<q> it = list.iterator();
        if (it.hasNext()) {
            q next = it.next();
            while (it.hasNext()) {
                q next2 = it.next();
                if (next.kf() < next2.bl() - 1) {
                    com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.bl() - 1));
                    next.bl(next2.bl() - 1);
                }
                next = next2;
            }
        }
        q qVar3 = list.get(list.size() - 1);
        long totalBytes = this.ok.getTotalBytes();
        if (totalBytes <= 0 || (qVar3.kf() != -1 && qVar3.kf() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "fixSegment: last segment = " + qVar3 + ", new end=-1");
            qVar3.bl(-1L);
        }
    }

    private q a(z zVar, x xVar) {
        while (!this.rh.isEmpty()) {
            q qVarPoll = this.rh.poll();
            if (qVarPoll != null) {
                ok(this.t, qVarPoll, true);
                if (ok(qVarPoll) > 0 || this.z <= 0) {
                    return qVarPoll;
                }
            }
        }
        z();
        q qVarBl = bl(zVar, xVar);
        if (qVarBl != null && ok(qVarBl) > 0) {
            ok(this.t, qVarBl, true);
            return qVarBl;
        }
        q qVarI = i();
        if (qVarI != null) {
            return qVarI;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void a(z zVar, q qVar) throws BaseException {
        synchronized (this) {
            n(zVar, qVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.bl.ok
    public void ok(String str, List<InetAddress> list) {
        if (this.f10089h || this.kf) {
            return;
        }
        List<x> listBl = null;
        try {
            listBl = bl(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (listBl != null) {
                a(str, listBl);
                this.j = false;
                this.f10088a.ok(this.f10091q.size());
                Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                n();
            } else {
                this.j = false;
                this.f10088a.ok(this.f10091q.size());
                Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                n();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void a(z zVar) {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "onReaderExit: threadIndex = " + zVar.bl);
        synchronized (this) {
            zVar.bl(true);
            this.p.remove(zVar);
            z();
            if (this.p.isEmpty()) {
                r();
            } else if (rh()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                Iterator<z> it = this.p.iterator();
                while (it.hasNext()) {
                    it.next().n();
                }
                r();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void bl(z zVar, q qVar) {
        synchronized (this) {
            if (qVar.ok == zVar) {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "unApplySegment " + qVar);
                qVar.s(zVar.s());
                qVar.ok = null;
                zVar.ok();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public n s(z zVar, q qVar) throws BaseException {
        n nVarOk;
        synchronized (this) {
            j jVar = new j(this.ok, this.bl, qVar);
            this.n.ok(jVar);
            nVarOk = jVar.ok();
        }
        return nVarOk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bl(z zVar) {
        synchronized (this) {
            x xVarS = s(zVar);
            if (xVarS == null) {
                return false;
            }
            return zVar.ok(xVarS);
        }
    }

    private int ok(String str) {
        int size = this.f10091q.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.f10091q.get(i2).ok, str)) {
                return i2;
            }
        }
        return -1;
    }

    private x s(z zVar) {
        x next;
        Iterator<x> it = this.f10091q.iterator();
        x xVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != zVar.f10097a && !next.s()) {
                if (xVar == null) {
                    xVar = next;
                }
                if (next.ok() <= 0) {
                    break;
                }
            }
        }
        if (this.f10088a.a()) {
            if (next != null) {
                return next;
            }
            if (this.f10088a.bl()) {
                return null;
            }
        }
        return xVar;
    }

    private void ok(List<q> list, q qVar, boolean z) {
        long jBl = qVar.bl();
        int size = list.size();
        int i2 = 0;
        while (i2 < size && jBl >= list.get(i2).bl()) {
            i2++;
        }
        list.add(i2, qVar);
        if (z) {
            qVar.ok(size);
        }
    }

    private void a(z zVar, q qVar, x xVar, com.ss.android.socialbase.downloader.model.s sVar) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        z zVar2 = qVar.ok;
        if (zVar2 != null && zVar2 != zVar) {
            throw new k(1, "segment already has an owner");
        }
        if (zVar.p() == qVar.n()) {
            if (!sVar.a()) {
                if (qVar.n() <= 0) {
                    com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + qVar.n());
                    if (!sVar.ok()) {
                        throw new com.ss.android.socialbase.downloader.exception.a(1004, sVar.bl, "2: response code error : " + sVar.bl + " segment=" + qVar);
                    }
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.a(1004, sVar.bl, "1: response code error : " + sVar.bl + " segment=" + qVar);
                }
            }
            if (xVar.s) {
                if (this.k == null) {
                    this.k = sVar;
                    synchronized (this.zz) {
                        this.zz.notify();
                    }
                    com.ss.android.socialbase.downloader.p.kf kfVar = this.s;
                    if (kfVar != null) {
                        kfVar.ok(xVar.ok, sVar.f10118a, qVar.n());
                    }
                    long jK = sVar.k();
                    if (jK > 0) {
                        for (q qVar2 : this.t) {
                            if (qVar2.kf() <= 0 || qVar2.kf() > jK - 1) {
                                qVar2.bl(jK - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            ok(sVar);
            if (this.r == null) {
                this.r = sVar;
                if (this.ok.getTotalBytes() <= 0) {
                    long jK2 = sVar.k();
                    com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jK2 + ",url=" + xVar.ok);
                    this.ok.setTotalBytes(jK2);
                }
                synchronized (this.zz) {
                    this.zz.notify();
                }
                return;
            }
            return;
        }
        throw new k(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.kf.q bl(com.ss.android.socialbase.downloader.kf.z r28, com.ss.android.socialbase.downloader.kf.x r29) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.r.bl(com.ss.android.socialbase.downloader.kf.z, com.ss.android.socialbase.downloader.kf.x):com.ss.android.socialbase.downloader.kf.q");
    }

    private float s(z zVar, x xVar) {
        long jA = zVar.a();
        int size = this.p.size();
        if (size <= 1) {
            size = this.f10088a.ok();
        }
        float f2 = 1.0f;
        if (jA <= 0) {
            float fZ = this.f10088a.z();
            if (fZ <= 0.0f || fZ >= 1.0f) {
                fZ = 1.0f / size;
            }
            if (zVar.bl == 0) {
                return fZ;
            }
            if (size > 1) {
                f2 = 1.0f - fZ;
                size--;
            }
        } else {
            long jT = t();
            if (jT > jA) {
                return jA / jT;
            }
        }
        return f2 / size;
    }

    private void ok(x xVar) {
        z zVar = new z(this.ok, this, this.bl, xVar, this.p.size());
        this.p.add(zVar);
        zVar.ok(com.ss.android.socialbase.downloader.downloader.bl.x().submit(zVar));
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar) {
        if (this.kz) {
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "onReaderRun, threadIndex = " + zVar.bl);
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public q ok(z zVar, x xVar) {
        if (this.kf || this.f10089h) {
            return null;
        }
        synchronized (this) {
            q qVarA = a(zVar, xVar);
            if (qVarA != null) {
                qVarA.p();
                if (qVarA.k() > 1) {
                    return new q(qVarA);
                }
            }
            return qVarA;
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, q qVar) {
        synchronized (this) {
            qVar.q();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, q qVar, x xVar, com.ss.android.socialbase.downloader.model.s sVar) throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        synchronized (this) {
            if (!this.kf && !this.f10089h) {
                a(zVar, qVar, xVar, sVar);
                zVar.a(false);
                if (this.z <= 0) {
                    long totalBytes = this.ok.getTotalBytes();
                    this.z = totalBytes;
                    if (totalBytes <= 0) {
                        this.z = sVar.k();
                    }
                    n();
                } else if (this.f10088a.kf()) {
                    n();
                }
            } else {
                throw new i("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, x xVar, q qVar, BaseException baseException, int i2, int i3) {
        boolean zA = com.ss.android.socialbase.downloader.q.kf.a(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zA = true;
        }
        if (zA || i2 >= i3) {
            bl(zVar);
        }
    }

    public void a() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "pause1");
        this.f10089h = true;
        synchronized (this) {
            Iterator<z> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
        this.n.a();
        this.bl.bl();
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, x xVar, q qVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "onSegmentFailed: segment = " + qVar + ", e = " + baseException);
            zVar.a(true);
            if (zVar.bl == 0) {
                this.x = baseException;
            }
            if (j()) {
                if (this.x == null) {
                    this.x = baseException;
                }
                this.ul = true;
                ok(this.x);
            }
        }
    }

    private void a(long j) {
        this.u.ok(this.ok.getCurBytes(), j);
        Iterator<z> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a(j);
        }
    }

    private void ok(BaseException baseException) {
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "onError, e = " + baseException);
        this.x = baseException;
        this.bl.bl();
        synchronized (this) {
            Iterator<z> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
    }

    private void ok(com.ss.android.socialbase.downloader.model.s sVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.s sVar2 = this.k;
        if (sVar2 == null && (sVar2 = this.r) == null) {
            return;
        }
        long jK = sVar.k();
        long jK2 = sVar2.k();
        if (jK != jK2) {
            String str = "total len not equals,len=" + jK + ",sLen=" + jK2 + ",code=" + sVar.bl + ",sCode=" + sVar2.bl + ",range=" + sVar.n() + ",sRange = " + sVar2.n() + ",url = " + sVar.ok + ",sUrl=" + sVar2.ok;
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", str);
            if (jK > 0 && jK2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String strBl = sVar.bl();
        String strBl2 = sVar2.bl();
        if (TextUtils.equals(strBl, strBl2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strBl + ", mainEtag = " + strBl2;
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strBl) && !TextUtils.isEmpty(strBl2) && !strBl.equalsIgnoreCase(strBl2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void ok() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "cancel");
        this.kf = true;
        synchronized (this) {
            Iterator<z> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
        this.n.ok();
        this.bl.bl();
    }

    private int ok(long j) {
        int size = this.t.size();
        for (int i2 = 0; i2 < size; i2++) {
            q qVar = this.t.get(i2);
            if (qVar.bl() == j) {
                return i2;
            }
            if (qVar.bl() > j) {
                return -1;
            }
        }
        return -1;
    }

    private long ok(int i2, int i3) {
        q qVar = this.t.get(i2);
        long jOk = ok(qVar);
        int i4 = i2 + 1;
        q qVar2 = i4 < i3 ? this.t.get(i4) : null;
        if (qVar2 == null) {
            return jOk;
        }
        long jBl = qVar2.bl() - qVar.n();
        return jOk == -1 ? jBl : Math.min(jOk, jBl);
    }

    private long ok(q qVar) {
        long jA = qVar.a();
        if (jA != -1) {
            return jA;
        }
        long j = this.z;
        return j > 0 ? j - qVar.n() : jA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z ok(boolean z, long j, long j2) {
        z zVar = null;
        for (z zVar2 : this.p) {
            if (zVar2.bl != 0 || z) {
                if (zVar2.s > 0 && zVar2.n <= 0 && j - zVar2.s > j2 && (zVar == null || zVar2.s < zVar.s)) {
                    zVar = zVar2;
                }
            }
        }
        return zVar;
    }

    private boolean ok(z zVar, long j, long j2, long j3, double d2) {
        if (zVar.kf <= 0) {
            return false;
        }
        long jA = this.u.a(j, j2);
        int size = this.p.size();
        long j4 = size > 0 ? jA / ((long) size) : jA;
        long jOk = zVar.ok(j, j2);
        if (jOk >= j3 && jOk >= j4 * d2) {
            return false;
        }
        Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + jA + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + jOk + ",threadIndex = " + zVar.bl);
        return true;
    }

    private boolean ok(long j, long j2) {
        long j3 = j - j2;
        long jA = this.u.a(j3, j);
        int size = this.p.size();
        if (size > 0) {
            jA /= (long) size;
        }
        z zVarOk = ok(j3, j, (long) Math.max(10.0f, jA * this.ep), size / 2);
        if (zVarOk != null) {
            bl(zVarOk);
            com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + zVarOk.bl);
            zVarOk.kf();
            return true;
        }
        z zVarOk2 = ok(true, j, j2);
        if (zVarOk2 == null) {
            return false;
        }
        bl(zVarOk2);
        com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + zVarOk2.bl);
        zVarOk2.kf();
        return true;
    }

    private z ok(long j, long j2, long j3, int i2) {
        long j4;
        long j5 = RecyclerView.FOREVER_NS;
        int i3 = 0;
        z zVar = null;
        for (z zVar2 : this.p) {
            if (zVar2.kf > 0) {
                i3++;
                long j6 = j5;
                if (zVar2.kf < j) {
                    long jOk = zVar2.ok(j, j2);
                    if (this.kz) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + jOk + ", threadIndex = " + zVar2.bl);
                        j4 = 0;
                    } else {
                        j4 = 0;
                    }
                    if (jOk >= j4 && jOk < j6) {
                        j5 = jOk;
                        zVar = zVar2;
                    }
                }
                j5 = j6;
            }
        }
        long j7 = j5;
        if (zVar == null || i3 < i2 || j7 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + zVar.bl);
        return zVar;
    }
}
