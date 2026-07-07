package com.alibaba.sdk.android.utils.crashdefend;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadFactory f5043a = new ThreadFactory() { // from class: com.alibaba.sdk.android.utils.crashdefend.f.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "safe_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f5044c;

    public synchronized ExecutorService a() {
        if (this.f5044c == null) {
            this.f5044c = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1L, TimeUnit.SECONDS, new SynchronousQueue(), this.f5043a);
        }
        return this.f5044c;
    }
}
