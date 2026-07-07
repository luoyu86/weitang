package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class rh extends com.ss.android.socialbase.downloader.downloader.ok implements ServiceConnection {
    private static final String n = rh.class.getSimpleName();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.rh f10063h;
    private com.ss.android.socialbase.downloader.downloader.q kf;
    private int p = -1;

    private void h() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.ok) {
                sparseArrayClone = this.ok.clone();
                this.ok.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.bl.fb() == null) {
                return;
            }
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.kf.ok(com.ss.android.socialbase.downloader.q.h.ok(it.next()));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.bl.ok.a(n, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = n;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.kf == null);
        com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
        if (this.kf == null) {
            ok(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.bl.l(), this);
            return;
        }
        h();
        try {
            this.kf.ok(com.ss.android.socialbase.downloader.q.h.ok(downloadTask));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void bl(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.s.ok().ok(downloadTask.getDownloadId(), true);
        ok okVarFb = com.ss.android.socialbase.downloader.downloader.bl.fb();
        if (okVarFb != null) {
            okVarFb.ok(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public IBinder ok(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(n, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.h.ok.ok("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.bl.ok.a(n, "onBind IndependentDownloadBinder");
        return new z();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.kf = null;
        com.ss.android.socialbase.downloader.downloader.rh rhVar = this.f10063h;
        if (rhVar != null) {
            rhVar.p();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = n;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "onServiceConnected ");
        this.kf = q.ok.ok(iBinder);
        com.ss.android.socialbase.downloader.downloader.rh rhVar = this.f10063h;
        if (rhVar != null) {
            rhVar.ok(iBinder);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.kf != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.ok.size());
        com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
        if (this.kf != null) {
            com.ss.android.socialbase.downloader.downloader.s.ok().a();
            this.f10036a = true;
            this.s = false;
            int i2 = this.p;
            if (i2 != -1) {
                try {
                    this.kf.j(i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.kf != null) {
                h();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.bl.ok.a(n, "onServiceDisconnected ");
        this.kf = null;
        this.f10036a = false;
        com.ss.android.socialbase.downloader.downloader.rh rhVar = this.f10063h;
        if (rhVar != null) {
            rhVar.p();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.bl.ok.a(n, "bindService");
            Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.bl.ok.a(n, "stopService");
        this.f10036a = false;
        Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void ok(com.ss.android.socialbase.downloader.downloader.rh rhVar) {
        this.f10063h = rhVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void ok(int i2) {
        com.ss.android.socialbase.downloader.downloader.q qVar = this.kf;
        if (qVar == null) {
            this.p = i2;
            return;
        }
        try {
            qVar.j(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void startService() {
        if (this.kf == null) {
            startService(com.ss.android.socialbase.downloader.downloader.bl.l(), this);
        }
    }
}
