package com.alibaba.mtl.log.d;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private static int G = 1;
    private static int H = 3;
    private static int I = 10;
    private static int J = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s f4570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f67a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f4571f = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f4572b;
    private Handler mHandler;

    public static class a implements ThreadFactory {
        private int priority;

        public a(int i2) {
            this.priority = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppMonitor:" + s.f4571f.getAndIncrement());
            thread.setPriority(this.priority);
            return thread;
        }
    }

    private s() {
        HandlerThread handlerThread = new HandlerThread(AppMonitor.TAG);
        this.f4572b = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.f4572b.getLooper()) { // from class: com.alibaba.mtl.log.d.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    Object obj = message.obj;
                    if (obj == null || !(obj instanceof Runnable)) {
                        return;
                    }
                    s.m32a().submit((Runnable) message.obj);
                } catch (Throwable unused) {
                }
            }
        };
    }

    public final void f(int i2) {
        this.mHandler.removeMessages(i2);
    }

    @TargetApi(9)
    private static ThreadPoolExecutor a(int i2, int i3, int i4, int i5, int i6) {
        return new ThreadPoolExecutor(i3, i4, i5, TimeUnit.SECONDS, i6 > 0 ? new LinkedBlockingQueue(i6) : new LinkedBlockingQueue(), new a(i2), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public final boolean b(int i2) {
        return this.mHandler.hasMessages(i2);
    }

    public void b(Runnable runnable) {
        try {
            m32a().submit(runnable);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized ThreadPoolExecutor m32a() {
        if (f67a == null) {
            f67a = a(G, H, I, J, 500);
        }
        return f67a;
    }

    public static synchronized s a() {
        if (f4570a == null) {
            f4570a = new s();
        }
        return f4570a;
    }

    public final void a(int i2, Runnable runnable, long j) {
        try {
            Message messageObtain = Message.obtain(this.mHandler, i2);
            messageObtain.obj = runnable;
            this.mHandler.sendMessageDelayed(messageObtain, j);
        } catch (Exception e2) {
            com.alibaba.mtl.appmonitor.b.b.m23a((Throwable) e2);
        }
    }
}
