package com.ss.android.socialbase.downloader.p;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f10165a;
    private final boolean bl;
    private final String ok;

    public ok(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.ok + "-" + this.f10165a.incrementAndGet());
        if (!this.bl) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public ok(String str, boolean z) {
        this.f10165a = new AtomicInteger();
        this.ok = str;
        this.bl = z;
    }
}
