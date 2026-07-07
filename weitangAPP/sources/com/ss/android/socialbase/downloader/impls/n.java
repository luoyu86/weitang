package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class n extends ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.socialbase.downloader.p.s f10052a;

    public n() {
        f10052a = new com.ss.android.socialbase.downloader.p.s();
    }

    public static void bl(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceX = com.ss.android.socialbase.downloader.downloader.bl.x();
        if (executorServiceX != null) {
            executorServiceX.invokeAll(list);
        }
    }

    public static Runnable n(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceX = com.ss.android.socialbase.downloader.downloader.bl.x();
                if ((executorServiceX instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceX).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.bl.ok.s("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static List<Future> s(List<Runnable> list) {
        ExecutorService executorServiceX = com.ss.android.socialbase.downloader.downloader.bl.x();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceX.submit(it.next()));
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void a(int i2) {
        com.ss.android.socialbase.downloader.p.s sVar = f10052a;
        if (sVar == null) {
            return;
        }
        sVar.bl(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public boolean ok(int i2) {
        DownloadInfo downloadInfoS;
        com.ss.android.socialbase.downloader.p.s sVar = f10052a;
        if (sVar == null || !sVar.ok(i2) || (downloadInfoS = s(i2)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfoS.getStatus())) {
            return true;
        }
        a(i2);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public com.ss.android.socialbase.downloader.p.bl bl(int i2) {
        com.ss.android.socialbase.downloader.p.s sVar = f10052a;
        if (sVar == null) {
            return null;
        }
        return sVar.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void ok(com.ss.android.socialbase.downloader.p.bl blVar) {
        com.ss.android.socialbase.downloader.p.s sVar = f10052a;
        if (sVar == null) {
            return;
        }
        sVar.a(blVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void ok(int i2, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a("DownloadTask", "start doDownload for task : " + i2);
        f10052a.ok(new com.ss.android.socialbase.downloader.p.bl(downloadTask, this.ok));
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public List<Integer> ok() {
        return f10052a.ok();
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void ok(int i2, long j) {
        com.ss.android.socialbase.downloader.p.s sVar = f10052a;
        if (sVar == null) {
            return;
        }
        sVar.ok(i2, j);
    }
}
