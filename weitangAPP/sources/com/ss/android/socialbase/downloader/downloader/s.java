package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.er;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static volatile s ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile SparseArray<Boolean> f10039a = new SparseArray<>();
    private Handler bl = new Handler(Looper.getMainLooper());
    private volatile List<er> s = new ArrayList();

    public static s ok() {
        if (ok == null) {
            synchronized (s.class) {
                ok = new s();
            }
        }
        return ok;
    }

    public void a(er erVar) {
        if (erVar == null) {
            return;
        }
        synchronized (this.s) {
            if (this.s.contains(erVar)) {
                this.s.remove(erVar);
            }
        }
    }

    public z bl(int i2) {
        return com.ss.android.socialbase.downloader.impls.j.ok(ok(i2) == 1 && !com.ss.android.socialbase.downloader.q.kf.bl());
    }

    public void h(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.s(i2);
    }

    public void i(int i2) {
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (zVarOk != null) {
            zVarOk.r(i2);
        }
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (zVarOk2 != null) {
            zVarOk2.r(i2);
        }
    }

    public ep j(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return null;
        }
        return zVarBl.x(i2);
    }

    public boolean k(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return false;
        }
        return zVarBl.h(i2);
    }

    public void kf(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.bl(i2);
    }

    public boolean n(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return false;
        }
        return zVarBl.a(i2);
    }

    public long p(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return 0L;
        }
        return zVarBl.n(i2);
    }

    public int q(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return 0;
        }
        return zVarBl.kf(i2);
    }

    public DownloadInfo r(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return null;
        }
        return zVarBl.p(i2);
    }

    public void rh(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.k(i2);
    }

    public void s(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.ok(i2);
    }

    public boolean t(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return false;
        }
        return zVarBl.j(i2);
    }

    public IDownloadFileUriProvider td(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return null;
        }
        return zVarBl.zz(i2);
    }

    public void x(int i2) {
        if (i2 == 0) {
            return;
        }
        a(i2, true);
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (zVarOk == null) {
            return;
        }
        zVarOk.startService();
    }

    public v z(int i2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return null;
        }
        return zVarBl.td(i2);
    }

    public void bl(int i2, boolean z) {
        if (!com.ss.android.socialbase.downloader.q.kf.ok()) {
            z zVarBl = bl(i2);
            if (zVarBl != null) {
                zVarBl.ok(i2, z);
            }
            com.ss.android.socialbase.downloader.impls.j.ok(true).ok(2, i2);
            return;
        }
        if (com.ss.android.socialbase.downloader.q.ok.ok(8388608)) {
            z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(true);
            if (zVarOk != null) {
                zVarOk.ok(i2, z);
            }
            z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
            if (zVarOk2 != null) {
                zVarOk2.ok(i2, z);
                return;
            }
            return;
        }
        z zVarOk3 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (zVarOk3 != null) {
            zVarOk3.ok(i2, z);
        }
        z zVarOk4 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (zVarOk4 != null) {
            zVarOk4.ok(i2, z);
        }
    }

    public boolean kf() {
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (zVarOk != null) {
            return zVarOk.n();
        }
        return false;
    }

    public List<DownloadInfo> n(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> listN = zVarOk != null ? zVarOk.n(str) : null;
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(listN, zVarOk2 != null ? zVarOk2.n(str) : null, sparseArray);
    }

    public void s(int i2, boolean z) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.a(i2, z);
    }

    public void a() {
        synchronized (this.s) {
            for (er erVar : this.s) {
                if (erVar != null) {
                    erVar.ok();
                }
            }
        }
    }

    public boolean s() {
        return bl.wv();
    }

    public void ok(er erVar) {
        if (erVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.q.kf.bl()) {
            erVar.ok();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.j.ok(true).h()) {
            erVar.ok();
        }
        synchronized (this.s) {
            if (!this.s.contains(erVar)) {
                this.s.add(erVar);
            }
        }
    }

    public List<DownloadInfo> s(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> listS = zVarOk != null ? zVarOk.s(str) : null;
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(listS, zVarOk2 != null ? zVarOk2.s(str) : null, sparseArray);
    }

    public List<DownloadInfo> n() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> listS = zVarOk != null ? zVarOk.s() : null;
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(listS, zVarOk2 != null ? zVarOk2.s() : null, sparseArray);
    }

    public synchronized void a(int i2, boolean z) {
        this.f10039a.put(i2, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized int a(int i2) {
        if (this.f10039a.get(i2) == null) {
            return -1;
        }
        return this.f10039a.get(i2).booleanValue() ? 1 : 0;
    }

    public void ok(int i2, boolean z) {
        a(i2, z);
        if (bl.qx() && !com.ss.android.socialbase.downloader.q.kf.bl() && com.ss.android.socialbase.downloader.impls.j.ok(true).h()) {
            com.ss.android.socialbase.downloader.impls.j.ok(true).bl(i2, z);
        }
        if (bl.bl() || com.ss.android.socialbase.downloader.q.kf.bl() || com.ss.android.socialbase.downloader.q.kf.ok()) {
            return;
        }
        try {
            Intent intent = new Intent(bl.l(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i2);
            bl.l().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bl() {
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (zVarOk != null) {
            zVarOk.ok();
        }
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (zVarOk2 != null) {
            zVarOk2.ok();
        }
    }

    private z a(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.a> listQ;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.q.kf.bl() || !com.ss.android.socialbase.downloader.q.kf.ok()) {
            zIsNeedIndependentProcess = true;
        }
        int iOk = ok(downloadInfo.getId());
        if (iOk >= 0 && iOk != zIsNeedIndependentProcess) {
            try {
                if (iOk == 1) {
                    if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                        com.ss.android.socialbase.downloader.impls.j.ok(true).ok(downloadInfo.getId());
                        DownloadInfo downloadInfoP = com.ss.android.socialbase.downloader.impls.j.ok(true).p(downloadInfo.getId());
                        if (downloadInfoP != null) {
                            com.ss.android.socialbase.downloader.impls.j.ok(false).a(downloadInfoP);
                        }
                        if (downloadInfoP.getChunkCount() > 1 && (listQ = com.ss.android.socialbase.downloader.impls.j.ok(true).q(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.j.ok(false).ok(downloadInfo.getId(), com.ss.android.socialbase.downloader.q.kf.ok(listQ));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                    com.ss.android.socialbase.downloader.impls.j.ok(false).ok(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.a> listQ2 = com.ss.android.socialbase.downloader.impls.j.ok(false).q(downloadInfo.getId());
                    if (listQ2 != null) {
                        com.ss.android.socialbase.downloader.impls.j.ok(true).ok(downloadInfo.getId(), com.ss.android.socialbase.downloader.q.kf.ok(listQ2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.j.ok(true).ok(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        ok(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.ss.android.socialbase.downloader.impls.j.ok(zIsNeedIndependentProcess);
    }

    public List<DownloadInfo> bl(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> listBl = zVarOk != null ? zVarOk.bl(str) : null;
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(listBl, zVarOk2 != null ? zVarOk2.bl(str) : null, sparseArray);
    }

    public int ok(int i2) {
        if (!bl.qx()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.q.kf.bl() && com.ss.android.socialbase.downloader.impls.j.ok(true).h()) {
            return com.ss.android.socialbase.downloader.impls.j.ok(true).z(i2);
        }
        return a(i2);
    }

    public int ok(String str, String str2) {
        return bl.ok(str, str2);
    }

    public List<DownloadInfo> ok(String str) {
        List<DownloadInfo> listOk = com.ss.android.socialbase.downloader.impls.j.ok(false).ok(str);
        List<DownloadInfo> listOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true).ok(str);
        if (listOk == null && listOk2 == null) {
            return null;
        }
        if (listOk == null || listOk2 == null) {
            return listOk != null ? listOk : listOk2;
        }
        ArrayList arrayList = new ArrayList(listOk);
        arrayList.addAll(listOk2);
        return arrayList;
    }

    public void ok(int i2, ep epVar) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.ok(i2, epVar);
    }

    private List<DownloadInfo> ok(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList;
    }

    public DownloadInfo a(String str, String str2) {
        int iOk = ok(str, str2);
        z zVarBl = bl(iOk);
        if (zVarBl == null) {
            return null;
        }
        return zVarBl.p(iOk);
    }

    public List<DownloadInfo> a(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> listA = zVarOk != null ? zVarOk.a(str) : null;
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(listA, zVarOk2 != null ? zVarOk2.a(str) : null, sparseArray);
    }

    public void ok(List<String> list) {
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (zVarOk != null) {
            zVarOk.ok(list);
        }
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (zVarOk2 != null) {
            zVarOk2.ok(list);
        }
    }

    public void a(List<String> list) {
        z zVarOk = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (zVarOk != null) {
            zVarOk.a(list);
        }
        z zVarOk2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (zVarOk2 != null) {
            zVarOk2.a(list);
        }
    }

    public void ok(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.a(i2, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, kfVar, z);
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.ok(i2, iDownloadListener.hashCode(), iDownloadListener, kfVar, z);
    }

    public void ok(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z, boolean z2) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.ok(i2, iDownloadListener.hashCode(), iDownloadListener, kfVar, z, z2);
    }

    public void a(com.ss.android.socialbase.downloader.depend.r rVar) {
        bl.a(rVar);
    }

    public boolean ok(DownloadInfo downloadInfo) {
        z zVarBl;
        if (downloadInfo == null || (zVarBl = bl(downloadInfo.getId())) == null) {
            return false;
        }
        return zVarBl.ok(downloadInfo);
    }

    public void ok(final DownloadTask downloadTask) {
        final z zVarA = a(downloadTask);
        if (zVarA == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.bl.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.s.1
                @Override // java.lang.Runnable
                public void run() {
                    zVarA.ok(downloadTask);
                }
            }, 500L);
        } else {
            zVarA.ok(downloadTask);
        }
    }

    public void ok(com.ss.android.socialbase.downloader.depend.r rVar) {
        bl.ok(rVar);
    }

    public void ok(int i2, long j) {
        z zVarBl = bl(i2);
        if (zVarBl == null) {
            return;
        }
        zVarBl.ok(i2, j);
    }
}
