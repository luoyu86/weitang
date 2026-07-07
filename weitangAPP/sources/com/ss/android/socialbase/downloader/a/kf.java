package com.ss.android.socialbase.downloader.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.a.bl;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.kf.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class kf implements ServiceConnection, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9972a;
    private static int bl;
    private static long s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private bl.ok.InterfaceC0165ok f9973h;

    @Nullable
    private bl ok;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Future<?> f9974q;
    private Handler n = new Handler(Looper.getMainLooper());
    private a kf = null;
    private Runnable p = new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.1
        @Override // java.lang.Runnable
        public void run() {
            if (kf.f9972a || kf.this.f9973h == null) {
                return;
            }
            kf.this.f9973h.ok();
        }
    };
    private CountDownLatch k = new CountDownLatch(1);

    public kf() {
        SqlDownloadCacheService.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public Map<Long, q> j(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo k(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.k(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
    public ArrayList<q> rh(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(int i2, Map<Long, q> map) {
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f9972a = true;
        this.n.removeCallbacks(this.p);
        try {
            this.ok = bl.ok.ok(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f9974q = com.ss.android.socialbase.downloader.downloader.bl.j().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (kf.this.kf != null && kf.this.ok != null) {
                                kf.this.ok.ok(kf.this.kf);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.a.kf.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = kf.f9972a = false;
                                    if (kf.this.h() || kf.this.f9973h == null) {
                                        return;
                                    }
                                    kf.this.n.postDelayed(kf.this.p, 2000L);
                                }
                            };
                        } catch (Throwable th2) {
                            try {
                                com.ss.android.socialbase.downloader.bl.ok.a("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                                if (kf.this.f9973h != null) {
                                    kf.this.f9973h.ok();
                                }
                                kf.this.k.countDown();
                                iBinder2 = iBinder;
                                deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.a.kf.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = kf.f9972a = false;
                                        if (kf.this.h() || kf.this.f9973h == null) {
                                            return;
                                        }
                                        kf.this.n.postDelayed(kf.this.p, 2000L);
                                    }
                                };
                            } finally {
                                kf.this.k.countDown();
                                try {
                                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.a.kf.2.1
                                        @Override // android.os.IBinder.DeathRecipient
                                        public void binderDied() {
                                            boolean unused = kf.f9972a = false;
                                            if (kf.this.h() || kf.this.f9973h == null) {
                                                return;
                                            }
                                            kf.this.n.postDelayed(kf.this.p, 2000L);
                                        }
                                    }, 0);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        iBinder2.linkToDeath(deathRecipient, 0);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.ok = null;
        f9972a = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo q(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.q(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void z(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (Build.VERSION.SDK_INT >= 26 || f9972a) {
            return false;
        }
        if (bl > 5) {
            com.ss.android.socialbase.downloader.bl.ok.s("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - s < 15000) {
            com.ss.android.socialbase.downloader.bl.ok.s("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        bl++;
        s = jCurrentTimeMillis;
        this.n.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), kf.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> bl(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.bl(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.n(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.p(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> s(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.s(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean kf(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.kf(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void ok(bl.ok.InterfaceC0165ok interfaceC0165ok) {
        this.f9973h = interfaceC0165ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void ok(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2, final s sVar) {
        com.ss.android.socialbase.downloader.downloader.bl.j().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                s sVar2;
                Future future;
                kf.this.ok(new a.ok() { // from class: com.ss.android.socialbase.downloader.a.kf.4.1
                    @Override // com.ss.android.socialbase.downloader.a.a
                    public void ok(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.q.kf.ok(sparseArray, map);
                        com.ss.android.socialbase.downloader.q.kf.ok(sparseArray2, map2);
                        sVar.ok();
                        kf.this.ok((a) null);
                    }
                });
                try {
                    z = !kf.this.k.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = kf.this.f9974q) != null) {
                    future.cancel(true);
                }
                kf.this.ok();
                if (!z || (sVar2 = sVar) == null) {
                    return;
                }
                sVar2.ok();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.model.a> bl(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.bl(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.n();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void ok(a aVar) {
        synchronized (this) {
            bl blVar = this.ok;
            if (blVar != null) {
                try {
                    blVar.ok(aVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.kf = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void s(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.s(i2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a();
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void bl() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.bl();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo s(int i2, long j) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.s(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.a(aVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo bl(int i2, long j) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.bl(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void ok() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean s() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.s();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo h(int i2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.h(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i2, long j) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> ok(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(DownloadInfo downloadInfo) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.a(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(aVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.a(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, long j) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i2, i3, j);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, int i4, long j) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i2, i3, i4, j);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, int i3, int i4, int i5) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i2, i3, i4, i5);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, int i3) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(i2, i3);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(DownloadInfo downloadInfo) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, long j, String str, String str2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(i2, j, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i2, long j) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
