package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class s implements com.ss.android.socialbase.downloader.downloader.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f10064a;
    private volatile boolean bl;
    private com.ss.android.socialbase.downloader.p.p kf;
    private p.ok n = new p.ok() { // from class: com.ss.android.socialbase.downloader.impls.s.1
        @Override // com.ss.android.socialbase.downloader.p.p.ok
        public void ok(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.s.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            s.this.q();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final r ok = new r();
    private volatile boolean s;

    public s() {
        this.kf = null;
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_sigbus_downloader_db") && !com.ss.android.socialbase.downloader.q.kf.ok() && com.ss.android.socialbase.downloader.downloader.bl.qx()) {
            this.f10064a = com.ss.android.socialbase.downloader.downloader.bl.tr().ok(new bl.ok.InterfaceC0165ok() { // from class: com.ss.android.socialbase.downloader.impls.s.2
                @Override // com.ss.android.socialbase.downloader.downloader.bl.ok.InterfaceC0165ok
                public void ok() {
                    s.this.f10064a = new com.ss.android.socialbase.downloader.a.n();
                    Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        } else {
            this.f10064a = new com.ss.android.socialbase.downloader.a.n();
        }
        this.bl = false;
        this.kf = new com.ss.android.socialbase.downloader.p.p(Looper.getMainLooper(), this.n);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this) {
            this.bl = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> bl(String str) {
        return this.ok.bl(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo h(int i2) {
        DownloadInfo downloadInfoH = this.ok.h(i2);
        bl(downloadInfoH);
        return downloadInfoH;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public Map<Long, com.ss.android.socialbase.downloader.kf.q> j(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.kf.q> mapJ = this.ok.j(i2);
        if (mapJ != null && !mapJ.isEmpty()) {
            return mapJ;
        }
        Map<Long, com.ss.android.socialbase.downloader.kf.q> mapJ2 = this.f10064a.j(i2);
        this.ok.ok(i2, mapJ2);
        return mapJ2;
    }

    public u kf() {
        return this.f10064a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n() {
        if (this.bl) {
            return true;
        }
        synchronized (this) {
            if (!this.bl) {
                com.ss.android.socialbase.downloader.bl.ok.s("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.socialbase.downloader.bl.ok.s("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.bl;
    }

    public void p() {
        this.kf.sendMessageDelayed(this.kf.obtainMessage(1), com.ss.android.socialbase.downloader.h.ok.bl().ok("task_resume_delay") ? 4000L : Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L);
    }

    public void q() {
        List<String> listOk;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.bl) {
            if (this.s) {
                com.ss.android.socialbase.downloader.bl.ok.a("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.s = true;
            if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                com.ss.android.socialbase.downloader.downloader.j jVarY = com.ss.android.socialbase.downloader.downloader.bl.y();
                if (jVarY != null) {
                    listOk = jVarY.ok();
                    arrayList = (listOk == null || listOk.isEmpty()) ? null : new ArrayList();
                } else {
                    listOk = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> sparseArrayOk = this.ok.ok();
                    for (int i2 = 0; i2 < sparseArrayOk.size(); i2++) {
                        int iKeyAt = sparseArrayOk.keyAt(i2);
                        if (iKeyAt != 0 && (downloadInfo2 = sparseArrayOk.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int iKeyAt2 = sparseArray.keyAt(i3);
                    if (iKeyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(iKeyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.s.ok.ok(com.ss.android.socialbase.downloader.downloader.bl.h(), downloadInfo, (BaseException) null, -5);
                        }
                        if (listOk != null && arrayList != null && downloadInfo.getMimeType() != null && listOk.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (jVarY == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                jVarY.ok(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.kf.q> rh(int i2) {
        List<com.ss.android.socialbase.downloader.kf.q> listRh = this.ok.rh(i2);
        return (listRh == null || listRh.size() == 0) ? this.f10064a.rh(i2) : listRh;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean s() {
        return this.bl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void z(int i2) {
        this.ok.z(i2);
        this.f10064a.z(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i2) {
        return this.ok.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.model.a> bl(int i2) {
        return this.ok.bl(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean kf(int i2) {
        com.ss.android.socialbase.downloader.downloader.z zVarOk;
        if (!com.ss.android.socialbase.downloader.q.kf.a() || (zVarOk = j.ok(true)) == null) {
            this.f10064a.kf(i2);
        } else {
            zVarOk.i(i2);
        }
        return this.ok.kf(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> s(String str) {
        return this.ok.s(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a(String str) {
        return this.ok.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void bl() {
        try {
            this.ok.bl();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.kf();
                return;
            } else {
                this.f10064a.bl();
                return;
            }
        }
        this.f10064a.bl();
    }

    public void h() {
        List<com.ss.android.socialbase.downloader.model.a> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.bl.ok(com.ss.android.socialbase.downloader.constants.s.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2 = new SparseArray<>();
        synchronized (this.ok) {
            SparseArray<DownloadInfo> sparseArrayOk = this.ok.ok();
            for (int i2 = 0; i2 < sparseArrayOk.size(); i2++) {
                int iKeyAt = sparseArrayOk.keyAt(i2);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayOk.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArrayKf = this.ok.kf();
            for (int i3 = 0; i3 < sparseArrayKf.size(); i3++) {
                int iKeyAt2 = sparseArrayKf.keyAt(i3);
                if (iKeyAt2 != 0 && (list = sparseArrayKf.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.f10064a.ok(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.a.s() { // from class: com.ss.android.socialbase.downloader.impls.s.3
            @Override // com.ss.android.socialbase.downloader.a.s
            public void ok() {
                synchronized (s.this.ok) {
                    SparseArray<DownloadInfo> sparseArrayOk2 = s.this.ok.ok();
                    if (sparseArray != null) {
                        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                            int iKeyAt3 = sparseArray.keyAt(i4);
                            if (iKeyAt3 != 0) {
                                sparseArrayOk2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArrayKf2 = s.this.ok.kf();
                    if (sparseArray2 != null) {
                        for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                            int iKeyAt4 = sparseArray2.keyAt(i5);
                            if (iKeyAt4 != 0) {
                                sparseArrayKf2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                s.this.k();
                s.this.p();
                com.ss.android.socialbase.downloader.downloader.bl.ok(com.ss.android.socialbase.downloader.constants.s.SYNC_SUCCESS);
            }
        });
    }

    public r ok() {
        return this.ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void s(int i2) {
        this.ok.s(i2);
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.t(i2);
                return;
            } else {
                this.f10064a.s(i2);
                return;
            }
        }
        this.f10064a.s(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a() {
        return this.ok.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> ok(String str) {
        return this.ok.ok(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.ok(aVar);
                return;
            } else {
                this.f10064a.ok(aVar);
                return;
            }
        }
        this.f10064a.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo k(int i2) {
        DownloadInfo downloadInfoK = this.ok.k(i2);
        bl(downloadInfoK);
        return downloadInfoK;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        synchronized (this.ok) {
            this.ok.ok(aVar);
        }
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.ok(aVar);
                return;
            } else {
                this.f10064a.ok(aVar);
                return;
            }
        }
        this.f10064a.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i2) {
        DownloadInfo downloadInfoP = this.ok.p(i2);
        bl(downloadInfoP);
        return downloadInfoP;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo s(int i2, long j) {
        DownloadInfo downloadInfoS = this.ok.s(i2, j);
        a(i2, (List<com.ss.android.socialbase.downloader.model.a>) null);
        return downloadInfoS;
    }

    private void bl(DownloadInfo downloadInfo) {
        ok(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i2, long j) {
        DownloadInfo downloadInfoA = this.ok.a(i2, j);
        a(i2, (List<com.ss.android.socialbase.downloader.model.a>) null);
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo bl(int i2, long j) {
        DownloadInfo downloadInfoBl = this.ok.bl(i2, j);
        a(i2, (List<com.ss.android.socialbase.downloader.model.a>) null);
        return downloadInfoBl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n(int i2) {
        com.ss.android.socialbase.downloader.downloader.z zVarOk;
        try {
            if (com.ss.android.socialbase.downloader.q.kf.a() && (zVarOk = j.ok(true)) != null) {
                zVarOk.rh(i2);
            } else {
                this.f10064a.n(i2);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.ok.n(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.ok.ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            ok(this.ok.a(i2));
            if (list == null) {
                list = this.ok.bl(i2);
            }
            if (com.ss.android.socialbase.downloader.q.kf.a()) {
                com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
                if (zVarOk != null) {
                    zVarOk.a(i2, list);
                    return;
                } else {
                    this.f10064a.a(i2, list);
                    return;
                }
            }
            this.f10064a.a(i2, list);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, long j) {
        this.ok.ok(i2, i3, j);
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.ok(i2, i3, j);
                return;
            } else {
                this.f10064a.ok(i2, i3, j);
                return;
            }
        }
        this.f10064a.ok(i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, int i4, long j) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.ok(i2, i3, i4, j);
                return;
            } else {
                this.f10064a.ok(i2, i3, i4, j);
                return;
            }
        }
        this.f10064a.ok(i2, i3, i4, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, int i4, int i5) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.ok(i2, i3, i4, i5);
                return;
            } else {
                this.f10064a.ok(i2, i3, i4, i5);
                return;
            }
        }
        this.f10064a.ok(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, int i3) {
        DownloadInfo downloadInfoOk = this.ok.ok(i2, i3);
        bl(downloadInfoOk);
        return downloadInfoOk;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zOk = this.ok.ok(downloadInfo);
        bl(downloadInfo);
        return zOk;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, long j, String str, String str2) {
        DownloadInfo downloadInfoOk = this.ok.ok(i2, j, str, str2);
        bl(downloadInfoOk);
        return downloadInfoOk;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo q(int i2) {
        DownloadInfo downloadInfoQ = this.ok.q(i2);
        bl(downloadInfoQ);
        return downloadInfoQ;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, long j) {
        DownloadInfo downloadInfoOk = this.ok.ok(i2, j);
        ok(downloadInfoOk, false);
        return downloadInfoOk;
    }

    private void ok(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.q.kf.a()) {
            this.f10064a.ok(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.z zVarOk = j.ok(true);
            if (zVarOk != null) {
                zVarOk.bl(downloadInfo);
            } else {
                this.f10064a.ok(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.ok.ok(i2, list);
        if (com.ss.android.socialbase.downloader.q.kf.bl()) {
            this.f10064a.a(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(int i2, Map<Long, com.ss.android.socialbase.downloader.kf.q> map) {
        this.ok.ok(i2, map);
        this.f10064a.ok(i2, map);
        return false;
    }
}
