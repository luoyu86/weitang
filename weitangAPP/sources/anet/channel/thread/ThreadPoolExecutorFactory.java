package anet.channel.thread;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ThreadPoolExecutorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f697a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f704h;

    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    public static class a implements Comparable<a>, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f707c;

        public a(Runnable runnable, int i2) {
            this.f705a = null;
            this.f706b = 0;
            this.f707c = System.currentTimeMillis();
            this.f705a = runnable;
            this.f706b = i2;
            this.f707c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i2 = this.f706b;
            int i3 = aVar.f706b;
            return i2 != i3 ? i2 - i3 : (int) (aVar.f707c - this.f707c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f705a.run();
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AtomicInteger f708a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f709b;

        public b(String str) {
            this.f709b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f709b + this.f708a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f698b = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));
        f699c = new anet.channel.thread.a(16, 16, 60L, timeUnit, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));
        f700d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));
        f701e = new ThreadPoolExecutor(32, 32, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));
        f702f = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Detector"));
        f703g = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN HR"));
        f704h = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Cookie"));
        f698b.allowCoreThreadTimeOut(true);
        f699c.allowCoreThreadTimeOut(true);
        f700d.allowCoreThreadTimeOut(true);
        f701e.allowCoreThreadTimeOut(true);
        f702f.allowCoreThreadTimeOut(true);
        f703g.allowCoreThreadTimeOut(true);
        f704h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        f697a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i2) {
        if (i2 < 6) {
            i2 = 6;
        }
        f699c.setCorePoolSize(i2);
        f699c.setMaximumPoolSize(i2);
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f701e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f704h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f702f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f703g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, "priority", Integer.valueOf(i2));
        }
        if (i2 < Priority.HIGH || i2 > Priority.LOW) {
            i2 = Priority.LOW;
        }
        return i2 == Priority.HIGH ? f698b.submit(runnable) : i2 == Priority.LOW ? f700d.submit(runnable) : f699c.submit(new a(runnable, i2));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return f697a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j, TimeUnit timeUnit) {
        return f697a.schedule(runnable, j, timeUnit);
    }
}
