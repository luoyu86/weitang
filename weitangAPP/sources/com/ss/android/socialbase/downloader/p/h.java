package com.ss.android.socialbase.downloader.p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private ok bl;
    private Handler s;
    private Object ok = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Queue<a> f10163a = new ConcurrentLinkedQueue();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10164a;
        public Runnable ok;

        public a(Runnable runnable, long j) {
            this.ok = runnable;
            this.f10164a = j;
        }
    }

    public class ok extends HandlerThread {
        public ok(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (h.this.ok) {
                h.this.s = new Handler(looper);
            }
            while (!h.this.f10163a.isEmpty()) {
                a aVar = (a) h.this.f10163a.poll();
                if (aVar != null) {
                    h.this.s.postDelayed(aVar.ok, aVar.f10164a);
                }
            }
        }
    }

    public h(String str) {
        this.bl = new ok(str);
    }

    public void a() {
        this.bl.quit();
    }

    public void ok() {
        this.bl.start();
    }

    public void ok(Runnable runnable) {
        ok(runnable, 0L);
    }

    public void ok(Runnable runnable, long j) {
        if (this.s == null) {
            synchronized (this.ok) {
                if (this.s == null) {
                    this.f10163a.add(new a(runnable, j));
                    return;
                }
            }
        }
        this.s.postDelayed(runnable, j);
    }
}
