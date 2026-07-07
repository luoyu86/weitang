package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r implements com.ss.android.socialbase.downloader.downloader.k {
    private final SparseArray<DownloadInfo> ok = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> f10062a = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.kf.q>> bl = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized DownloadInfo a(int i2) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.ok.get(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.ok.size(); i2++) {
            DownloadInfo downloadInfo = this.ok.get(this.ok.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo h(int i2) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setStatus(2);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized Map<Long, com.ss.android.socialbase.downloader.kf.q> j(int i2) {
        return this.bl.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo k(int i2) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setStatus(-7);
        }
        return downloadInfoA;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.a>> kf() {
        return this.f10062a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized boolean n(int i2) {
        this.ok.remove(i2);
        return true;
    }

    public SparseArray<DownloadInfo> ok() {
        return this.ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, int i4, int i5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i2) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setStatus(5);
            downloadInfoA.setFirstDownload(false);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo q(int i2) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setStatus(1);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<com.ss.android.socialbase.downloader.kf.q> rh(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.kf.q> map = this.bl.get(i2);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.ok.size(); i2++) {
            DownloadInfo downloadInfo = this.ok.get(this.ok.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean s() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void z(int i2) {
        this.bl.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean kf(int i2) {
        n(i2);
        s(i2);
        z(i2);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> ok(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.ok.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadInfo downloadInfoValueAt = this.ok.valueAt(i2);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.ok.size(); i2++) {
            DownloadInfo downloadInfo = this.ok.get(this.ok.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        int iR = aVar.r();
        List<com.ss.android.socialbase.downloader.model.a> arrayList = this.f10062a.get(iR);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f10062a.put(iR, arrayList);
        }
        arrayList.add(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<com.ss.android.socialbase.downloader.model.a> bl(int i2) {
        return this.f10062a.get(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        r0.a(r5);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void ok(int r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.bl(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L26
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L26
            com.ss.android.socialbase.downloader.model.a r0 = (com.ss.android.socialbase.downloader.model.a) r0     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Ld
            int r1 = r0.zz()     // Catch: java.lang.Throwable -> L26
            if (r1 != r4) goto Ld
            r0.a(r5)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r2)
            return
        L26:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.r.ok(int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void s(int i2) {
        this.f10062a.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void bl() {
        this.ok.clear();
        this.f10062a.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo s(int i2, long j) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setCurBytes(j, false);
            downloadInfoA.setStatus(-2);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> a() {
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.ok.size());
        for (int i2 = 0; i2 < this.ok.size(); i2++) {
            DownloadInfo downloadInfoValueAt = this.ok.valueAt(i2);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo bl(int i2, long j) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setCurBytes(j, false);
            downloadInfoA.setStatus(-3);
            downloadInfoA.setFirstDownload(false);
            downloadInfoA.setFirstSuccess(false);
        }
        return downloadInfoA;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0.h() != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r3 = r0.h().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r3.hasNext() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        if (r5 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r5.zz() != r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        r5.a(r6);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void ok(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.bl(r3)     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4d
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.a r0 = (com.ss.android.socialbase.downloader.model.a) r0     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto Ld
            int r1 = r0.zz()     // Catch: java.lang.Throwable -> L4f
            if (r1 != r5) goto Ld
            boolean r1 = r0.kf()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.h()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L2e
            goto L4d
        L2e:
            java.util.List r3 = r0.h()     // Catch: java.lang.Throwable -> L4f
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        L36:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.a r5 = (com.ss.android.socialbase.downloader.model.a) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L36
            int r0 = r5.zz()     // Catch: java.lang.Throwable -> L4f
            if (r0 != r4) goto L36
            r5.a(r6)     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r2)
            return
        L4f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.r.ok(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i2, long j) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setCurBytes(j, false);
            downloadInfoA.setStatus(-1);
            downloadInfoA.setFirstDownload(false);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(DownloadInfo downloadInfo) {
        ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized DownloadInfo ok(int i2, int i3) {
        DownloadInfo downloadInfoA;
        downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setChunkCount(i3);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized boolean ok(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.ok.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.ok.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, long j, String str, String str2) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setTotalBytes(j);
            downloadInfoA.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoA.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoA.setName(str2);
            }
            downloadInfoA.setStatus(3);
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, long j) {
        DownloadInfo downloadInfoA = a(i2);
        if (downloadInfoA != null) {
            downloadInfoA.setCurBytes(j, false);
            if (downloadInfoA.getStatus() != -3 && downloadInfoA.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoA.getStatus()) && downloadInfoA.getStatus() != -4) {
                downloadInfoA.setStatus(4);
            }
        }
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (list == null) {
            return;
        }
        s(i2);
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null) {
                ok(aVar);
                if (aVar.kf()) {
                    Iterator<com.ss.android.socialbase.downloader.model.a> it = aVar.h().iterator();
                    while (it.hasNext()) {
                        ok(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized boolean ok(int i2, Map<Long, com.ss.android.socialbase.downloader.kf.q> map) {
        this.bl.put(i2, map);
        return false;
    }
}
