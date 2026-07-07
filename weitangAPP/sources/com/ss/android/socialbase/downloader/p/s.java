package com.ss.android.socialbase.downloader.p;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static ExecutorService ok = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ok("Download_OP_Thread"));
    private int bl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile SparseArray<bl> f10166a = new SparseArray<>();

    private void a() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f10166a.size(); i2++) {
                int iKeyAt = this.f10166a.keyAt(i2);
                if (!this.f10166a.get(iKeyAt).s()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    Integer num = (Integer) arrayList.get(i3);
                    if (num != null) {
                        this.f10166a.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void ok(Runnable runnable) {
        ok.execute(runnable);
    }

    public void bl(int i2) {
        synchronized (s.class) {
            a();
            bl blVar = this.f10166a.get(i2);
            if (blVar != null) {
                blVar.ok();
                bl(blVar);
                this.f10166a.remove(i2);
            }
        }
    }

    public void ok(bl blVar) {
        blVar.kf();
        synchronized (s.class) {
            int i2 = this.bl;
            if (i2 >= 500) {
                a();
                this.bl = 0;
            } else {
                this.bl = i2 + 1;
            }
            this.f10166a.put(blVar.n(), blVar);
        }
        DownloadTask downloadTaskBl = blVar.bl();
        try {
            ExecutorService executorServiceI = com.ss.android.socialbase.downloader.downloader.bl.i();
            if (downloadTaskBl != null && downloadTaskBl.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskBl.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.h.ok.bl().ok("divide_plugin", 1) == 1) {
                    downloadTaskBl.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = downloadTaskBl.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceI = com.ss.android.socialbase.downloader.downloader.bl.rh();
                } else if (executorGroup == 4) {
                    executorServiceI = com.ss.android.socialbase.downloader.downloader.bl.t();
                }
            }
            if (executorServiceI == null) {
                com.ss.android.socialbase.downloader.s.ok.ok(downloadTaskBl.getMonitorDepend(), downloadTaskBl.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTaskBl.getDownloadInfo() != null ? downloadTaskBl.getDownloadInfo().getStatus() : 0);
            } else if (com.ss.android.socialbase.downloader.h.ok.ok(blVar.n()).a("pause_with_interrupt", false)) {
                blVar.ok(executorServiceI.submit(blVar));
            } else {
                executorServiceI.execute(blVar);
            }
        } catch (Exception e2) {
            if (downloadTaskBl != null) {
                com.ss.android.socialbase.downloader.s.ok.ok(downloadTaskBl.getMonitorDepend(), downloadTaskBl.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.q.kf.a(e2, "DownloadThreadPoolExecute")), downloadTaskBl.getDownloadInfo() != null ? downloadTaskBl.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            if (downloadTaskBl != null) {
                com.ss.android.socialbase.downloader.s.ok.ok(downloadTaskBl.getMonitorDepend(), downloadTaskBl.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTaskBl.getDownloadInfo() != null ? downloadTaskBl.getDownloadInfo().getStatus() : 0);
            }
            e3.printStackTrace();
        }
    }

    private void bl(bl blVar) {
        Future futureH;
        if (blVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceI = com.ss.android.socialbase.downloader.downloader.bl.i();
            DownloadTask downloadTaskBl = blVar.bl();
            if (downloadTaskBl != null && downloadTaskBl.getDownloadInfo() != null) {
                int executorGroup = downloadTaskBl.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceI = com.ss.android.socialbase.downloader.downloader.bl.rh();
                } else if (executorGroup == 4) {
                    executorServiceI = com.ss.android.socialbase.downloader.downloader.bl.t();
                }
            }
            if (executorServiceI == null || !(executorServiceI instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceI).remove(blVar);
            if (!com.ss.android.socialbase.downloader.h.ok.ok(blVar.n()).a("pause_with_interrupt", false) || (futureH = blVar.h()) == null) {
                return;
            }
            futureH.cancel(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(bl blVar) {
        if (blVar == null) {
            return;
        }
        synchronized (s.class) {
            try {
                if (com.ss.android.socialbase.downloader.q.ok.ok(524288)) {
                    int iIndexOfValue = this.f10166a.indexOfValue(blVar);
                    if (iIndexOfValue >= 0) {
                        this.f10166a.removeAt(iIndexOfValue);
                    }
                } else {
                    this.f10166a.remove(blVar.n());
                }
            } finally {
            }
        }
    }

    public bl a(int i2) {
        synchronized (s.class) {
            a();
            bl blVar = this.f10166a.get(i2);
            if (blVar == null) {
                return null;
            }
            blVar.a();
            bl(blVar);
            this.f10166a.remove(i2);
            return blVar;
        }
    }

    public boolean ok(int i2) {
        synchronized (s.class) {
            boolean z = false;
            if (this.f10166a != null && this.f10166a.size() > 0) {
                bl blVar = this.f10166a.get(i2);
                if (blVar != null && blVar.s()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public List<Integer> ok() {
        ArrayList arrayList;
        synchronized (s.class) {
            a();
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f10166a.size(); i2++) {
                bl blVar = this.f10166a.get(this.f10166a.keyAt(i2));
                if (blVar != null) {
                    arrayList.add(Integer.valueOf(blVar.n()));
                }
            }
        }
        return arrayList;
    }

    public void ok(int i2, long j) {
        bl blVar = this.f10166a.get(i2);
        if (blVar != null) {
            blVar.bl(j);
        }
    }
}
