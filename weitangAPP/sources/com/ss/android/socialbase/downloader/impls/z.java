package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.em;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends q.ok {
    private static final String ok = z.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.z f10075a = new i(true);

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean a(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void bl(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.bl(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean h(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.h(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean i(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.i(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void j(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.r(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void k(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.k(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public int kf(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return 0;
        }
        return zVar.kf(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public long n(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return 0L;
        }
        return zVar.n(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.a(com.ss.android.socialbase.downloader.q.h.ok(okVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public DownloadInfo p(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.p(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<com.ss.android.socialbase.downloader.model.a> q(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.q(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean r(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.j(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean rh(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.rh(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void s(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.s(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void t(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.t(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public g td(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.q.h.ok(zVar.td(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public m x(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.q.h.ok(zVar.x(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public int z(int i2) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.s.ok().a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public com.ss.android.socialbase.downloader.depend.h zz(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.q.h.ok(zVar.zz(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public DownloadInfo a(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<DownloadInfo> bl(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.bl(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean kf() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<DownloadInfo> n(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.s(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<DownloadInfo> s(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.n(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<DownloadInfo> a(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void bl(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void n() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.kf();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean s() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.n();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<DownloadInfo> a() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.s();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean bl() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.bl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void s(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.s.ok().a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void a(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar != null) {
            zVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public List<DownloadInfo> ok(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return null;
        }
        return zVar.ok(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void a(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public int ok(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return 0;
        }
        return zVar.ok(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, i3, com.ss.android.socialbase.downloader.q.h.ok(qVar), com.ss.android.socialbase.downloader.q.kf.n(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean a(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.bl(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.a(i2, i3, com.ss.android.socialbase.downloader.q.h.ok(qVar), com.ss.android.socialbase.downloader.q.kf.n(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, i3, com.ss.android.socialbase.downloader.q.h.ok(qVar), com.ss.android.socialbase.downloader.q.kf.n(i4), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return false;
        }
        return zVar.ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, int i3, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, int i3, int i4, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, i3, i4, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, int i3, int i4, int i5) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.a(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(em emVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(com.ss.android.socialbase.downloader.q.h.ok(emVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, int i3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, i3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void ok(int i2, m mVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.z zVar = this.f10075a;
        if (zVar == null) {
            return;
        }
        zVar.ok(i2, com.ss.android.socialbase.downloader.q.h.ok(mVar));
    }
}
