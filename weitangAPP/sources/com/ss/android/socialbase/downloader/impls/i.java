package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.taobao.accs.utl.BaseMonitor;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDButton;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i implements com.ss.android.socialbase.downloader.downloader.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.k f10049a;
    private final com.ss.android.socialbase.downloader.downloader.t bl;
    private final ok ok;
    private final boolean s;

    public i() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.rh(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.kf(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.ok(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean i(int i2) {
        return this.f10049a.kf(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean j(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.r(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void k(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.z(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int kf(int i2) {
        DownloadInfo downloadInfoS;
        ok okVar = this.ok;
        if (okVar == null || (downloadInfoS = okVar.s(i2)) == null) {
            return 0;
        }
        return downloadInfoS.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public long n(int i2) {
        DownloadInfo downloadInfoA;
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f10049a;
        if (kVar == null || (downloadInfoA = kVar.a(i2)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfoA.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfoA.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.a> listBl = this.f10049a.bl(i2);
        if (listBl == null || listBl.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.q.kf.a(listBl);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.n(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo p(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.s(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<com.ss.android.socialbase.downloader.model.a> q(int i2) {
        return this.f10049a.bl(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void r(int i2) {
        com.ss.android.socialbase.downloader.bl.ok.ok(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean rh(int i2) {
        return this.f10049a.n(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void s(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.h(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void t(int i2) {
        this.f10049a.s(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public v td(int i2) {
        ok okVar = this.ok;
        v vVarP = okVar != null ? okVar.p(i2) : null;
        return vVarP == null ? com.ss.android.socialbase.downloader.downloader.bl.sg() : vVarP;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public ep x(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.q(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int z(int i2) {
        return com.ss.android.socialbase.downloader.downloader.s.ok().ok(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public IDownloadFileUriProvider zz(int i2) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.k(i2);
        }
        return null;
    }

    public i(boolean z) {
        this.ok = com.ss.android.socialbase.downloader.downloader.bl.fb();
        this.f10049a = com.ss.android.socialbase.downloader.downloader.bl.m();
        if (z) {
            this.bl = com.ss.android.socialbase.downloader.downloader.bl.vz();
        } else {
            this.bl = com.ss.android.socialbase.downloader.downloader.bl.ep();
        }
        this.s = com.ss.android.socialbase.downloader.h.ok.bl().a(BaseMonitor.COUNT_SERVICE_ALIVE, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> a(String str) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f10049a;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> bl(String str) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f10049a;
        if (kVar != null) {
            return kVar.bl(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h() {
        com.ss.android.socialbase.downloader.downloader.t tVar;
        return this.s && (tVar = this.bl) != null && tVar.ok();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, boolean z) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s() {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f10049a;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void kf() {
        this.f10049a.bl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(List<String> list) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl() {
        return com.ss.android.socialbase.downloader.downloader.bl.wv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok() {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a();
        }
    }

    public void s(int i2, boolean z) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.bl(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.s.ok().ok(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo a(String str, String str2) {
        return p(com.ss.android.socialbase.downloader.downloader.bl.ok(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl(DownloadInfo downloadInfo) {
        return this.f10049a.ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(List<String> list) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s(String str) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f10049a;
        if (kVar != null) {
            return kVar.s(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> n(String str) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i2, boolean z) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> ok(String str) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.ok(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean n() {
        return this.f10049a.s();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i2, i3, iDownloadListener, kfVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int ok(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.bl.ok(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(i2, i3, iDownloadListener, kfVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a() {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            return tVar.a();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z, boolean z2) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i2, i3, iDownloadListener, kfVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.bl(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zOk = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (zOk) {
            if (com.ss.android.socialbase.downloader.q.ok.ok(PDButton.FLAG_RADIOS_IN_UNISON)) {
                a(downloadInfo.getId(), true);
            } else {
                s(downloadInfo.getId(), true);
            }
        }
        return zOk;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadInfo downloadInfo) {
        this.f10049a.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        this.f10049a.a(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.ok(i2, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.ok(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.a(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        this.f10049a.ok(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        this.f10049a.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, long j) {
        this.f10049a.ok(i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, int i4, long j) {
        this.f10049a.ok(i2, i3, i4, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, int i4, int i5) {
        this.f10049a.ok(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(sg sgVar) {
        com.ss.android.socialbase.downloader.downloader.bl.ok(sgVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3) {
        if (com.ss.android.socialbase.downloader.downloader.bl.n() != null) {
            for (sg sgVar : com.ss.android.socialbase.downloader.downloader.bl.n()) {
                if (sgVar != null) {
                    sgVar.ok(i3, i2);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, ep epVar) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i2, epVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, long j) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(i2, j);
        }
    }
}
