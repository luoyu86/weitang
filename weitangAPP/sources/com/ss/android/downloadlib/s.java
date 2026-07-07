package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserView;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f9905a;
    private ScheduledExecutorService bl;
    private ExecutorService ok;

    public static class ok {
        private static s ok = new s();
    }

    public static s ok() {
        return ok.ok;
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public ExecutorService bl() {
        if (this.f9905a == null) {
            synchronized (s.class) {
                if (this.f9905a == null) {
                    this.f9905a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.p.ok(p.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f9905a;
    }

    public void n() {
        ok(new Runnable() { // from class: com.ss.android.downloadlib.s.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (s.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i2 = 0; i2 < 13; i2++) {
                            SharedPreferences sharedPreferences = r.getContext().getSharedPreferences(strArr[i2], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        k kVarM = com.ss.android.socialbase.downloader.downloader.bl.m();
                        if (!(kVarM instanceof com.ss.android.socialbase.downloader.impls.s)) {
                            return;
                        }
                        SparseArray<DownloadInfo> sparseArrayOk = ((com.ss.android.socialbase.downloader.impls.s) kVarM).ok().ok();
                        for (int size = sparseArrayOk.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = sparseArrayOk.get(sparseArrayOk.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(r.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public ScheduledExecutorService s() {
        if (this.bl == null) {
            synchronized (s.class) {
                if (this.bl == null) {
                    this.bl = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.p.ok(p.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.bl;
    }

    private s() {
    }

    public void a(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || j.a()) {
            bl().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void ok(Runnable runnable) {
        ok(runnable, false);
    }

    public void ok(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !j.a()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }

    public ExecutorService a() {
        if (this.ok == null) {
            synchronized (s.class) {
                if (this.ok == null) {
                    this.ok = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.p.ok(p.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.ok;
    }

    public void ok(Runnable runnable, long j) {
        try {
            s().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
