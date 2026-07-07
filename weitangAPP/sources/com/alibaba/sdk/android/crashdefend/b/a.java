package com.alibaba.sdk.android.crashdefend.b;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadFactory f4643a = new ThreadFactory() { // from class: com.alibaba.sdk.android.crashdefend.b.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "safe_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f4644b;

    public synchronized ExecutorService a() {
        if (this.f4644b == null) {
            this.f4644b = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1L, TimeUnit.SECONDS, new SynchronousQueue(), this.f4643a);
        }
        return this.f4644b;
    }
}
