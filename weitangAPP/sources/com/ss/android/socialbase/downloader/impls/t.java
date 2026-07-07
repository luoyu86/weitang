package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t implements com.ss.android.socialbase.downloader.downloader.rh, com.ss.android.socialbase.downloader.downloader.z {
    private static final String ok = "t";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.q f10066a;
    private com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> bl;
    private com.ss.android.socialbase.downloader.downloader.z s = new i();

    public t() {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVarVz = com.ss.android.socialbase.downloader.downloader.bl.vz();
        this.bl = tVarVz;
        tVarVz.ok(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a(int i2) {
        if (this.f10066a == null) {
            return false;
        }
        try {
            return this.f10066a.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i2) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.bl(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h(int i2) {
        if (this.f10066a == null) {
            return false;
        }
        try {
            return this.f10066a.h(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean i(int i2) {
        if (this.f10066a == null) {
            return this.s.i(i2);
        }
        try {
            return this.f10066a.i(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean j(int i2) {
        if (this.f10066a == null) {
            return false;
        }
        try {
            return this.f10066a.r(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void k(int i2) {
        if (this.f10066a == null) {
            this.s.k(i2);
            return;
        }
        try {
            this.f10066a.k(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int kf(int i2) {
        if (this.f10066a == null) {
            return 0;
        }
        try {
            return this.f10066a.kf(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public long n(int i2) {
        if (this.f10066a == null) {
            return 0L;
        }
        try {
            return this.f10066a.n(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.ok(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo p(int i2) {
        if (this.f10066a == null) {
            return this.s.p(i2);
        }
        try {
            return this.f10066a.p(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<com.ss.android.socialbase.downloader.model.a> q(int i2) {
        if (this.f10066a == null) {
            return this.s.q(i2);
        }
        try {
            return this.f10066a.q(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void r(int i2) {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar = this.bl;
        if (tVar != null) {
            tVar.ok(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean rh(int i2) {
        if (this.f10066a == null) {
            return this.s.rh(i2);
        }
        try {
            return this.f10066a.rh(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void s(int i2) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.s(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar = this.bl;
        if (tVar != null) {
            tVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void t(int i2) {
        if (this.f10066a == null) {
            this.s.t(i2);
            return;
        }
        try {
            this.f10066a.t(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public v td(int i2) {
        if (this.f10066a == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.q.h.ok(this.f10066a.td(i2));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public ep x(int i2) {
        if (this.f10066a == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.q.h.ok(this.f10066a.x(i2));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int z(int i2) {
        if (this.f10066a == null) {
            return com.ss.android.socialbase.downloader.downloader.s.ok().a(i2);
        }
        try {
            return this.f10066a.z(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public IDownloadFileUriProvider zz(int i2) {
        if (this.f10066a == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.q.h.ok(this.f10066a.zz(i2));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo a(String str, String str2) {
        return p(ok(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> bl(String str) {
        if (this.f10066a == null) {
            return this.s.bl(str);
        }
        try {
            return this.f10066a.bl(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h() {
        return this.f10066a != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void kf() {
        if (this.f10066a == null) {
            this.s.kf();
            return;
        }
        try {
            this.f10066a.n();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> n(String str) {
        if (this.f10066a == null) {
            return null;
        }
        try {
            return this.f10066a.s(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, boolean z) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.ok(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s() {
        if (this.f10066a == null) {
            return this.s.s();
        }
        try {
            return this.f10066a.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.rh
    public void p() {
        this.f10066a = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> a(String str) {
        if (this.f10066a == null) {
            return this.s.a(str);
        }
        try {
            return this.f10066a.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean n() {
        if (this.f10066a == null) {
            return this.s.n();
        }
        try {
            return this.f10066a.s();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok() {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.ok();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl() {
        return com.ss.android.socialbase.downloader.downloader.bl.wv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s(String str) {
        if (this.f10066a == null) {
            return this.s.s(str);
        }
        try {
            return this.f10066a.n(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i2, boolean z) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.s(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(List<String> list) {
        if (this.f10066a == null) {
            this.s.a(list);
            return;
        }
        try {
            this.f10066a.a(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> ok(String str) {
        if (this.f10066a == null) {
            return this.s.ok(str);
        }
        try {
            return this.f10066a.ok(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl(DownloadInfo downloadInfo) {
        if (this.f10066a == null) {
            return this.s.bl(downloadInfo);
        }
        try {
            return this.f10066a.a(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i2, boolean z) {
        if (this.f10066a == null) {
            this.s.a(i2, z);
            return;
        }
        try {
            this.f10066a.a(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int ok(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.bl.ok(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(List<String> list) {
        if (this.f10066a == null) {
            this.s.ok(list);
            return;
        }
        try {
            this.f10066a.ok(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.ok(i2, i3, com.ss.android.socialbase.downloader.q.h.ok(iDownloadListener, kfVar != com.ss.android.socialbase.downloader.constants.kf.SUB), kfVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.a(i2, i3, com.ss.android.socialbase.downloader.q.h.ok(iDownloadListener, kfVar != com.ss.android.socialbase.downloader.constants.kf.SUB), kfVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a() {
        if (this.f10066a == null) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "aidlService.isServiceForeground");
        try {
            return this.f10066a.kf();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z, boolean z2) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.ok(i2, i3, com.ss.android.socialbase.downloader.q.h.ok(iDownloadListener, kfVar != com.ss.android.socialbase.downloader.constants.kf.SUB), kfVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean ok(DownloadInfo downloadInfo) {
        if (this.f10066a == null) {
            return this.s.ok(downloadInfo);
        }
        try {
            this.f10066a.ok(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar;
        if (downloadTask == null || (tVar = this.bl) == null) {
            return;
        }
        tVar.bl(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (this.f10066a == null) {
            this.s.a(i2, list);
            return;
        }
        try {
            this.f10066a.ok(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, Notification notification) {
        if (this.f10066a == null) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "aidlService.startForeground, id = " + i2);
        try {
            this.f10066a.ok(i2, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(boolean z, boolean z2) {
        if (this.f10066a == null) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "aidlService.stopForeground");
        try {
            this.f10066a.ok(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar;
        if (downloadTask == null || (tVar = this.bl) == null) {
            return;
        }
        tVar.a(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.a(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        if (this.f10066a == null) {
            this.s.ok(aVar);
            return;
        }
        try {
            this.f10066a.ok(aVar);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, long j) {
        if (this.f10066a == null) {
            this.s.ok(i2, i3, j);
            return;
        }
        try {
            this.f10066a.ok(i2, i3, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, int i4, long j) {
        if (this.f10066a == null) {
            this.s.ok(i2, i3, i4, j);
            return;
        }
        try {
            this.f10066a.ok(i2, i3, i4, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3, int i4, int i5) {
        if (this.f10066a == null) {
            this.s.ok(i2, i3, i4, i5);
            return;
        }
        try {
            this.f10066a.ok(i2, i3, i4, i5);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(sg sgVar) {
        if (this.f10066a != null) {
            try {
                this.f10066a.ok(com.ss.android.socialbase.downloader.q.h.ok(sgVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, int i3) {
        if (this.f10066a != null) {
            try {
                this.f10066a.ok(i2, i3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, ep epVar) {
        if (this.f10066a != null) {
            try {
                this.f10066a.ok(i2, com.ss.android.socialbase.downloader.q.h.ok(epVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.rh
    public void ok(IBinder iBinder) {
        this.f10066a = q.ok.ok(iBinder);
        if (com.ss.android.socialbase.downloader.q.kf.ok()) {
            ok(new sg() { // from class: com.ss.android.socialbase.downloader.impls.t.1
                @Override // com.ss.android.socialbase.downloader.depend.sg
                public void ok(int i2, int i3) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(i2);
                        }
                    } else {
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).pause(i2);
                        List<com.ss.android.socialbase.downloader.model.a> listQ = j.ok(false).q(i2);
                        if (listQ != null) {
                            j.ok(true).ok(i2, com.ss.android.socialbase.downloader.q.kf.ok(listQ));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i2, long j) {
        if (this.f10066a == null) {
            return;
        }
        try {
            this.f10066a.ok(i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
