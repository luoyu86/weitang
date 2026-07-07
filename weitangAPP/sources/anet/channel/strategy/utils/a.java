package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f695a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f696b = null;

    public static ScheduledThreadPoolExecutor a() {
        if (f696b == null) {
            synchronized (a.class) {
                if (f696b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new b());
                    f696b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    f696b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f696b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "submit task failed", null, e2, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j) {
        try {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "schedule task failed", null, e2, new Object[0]);
        }
    }
}
