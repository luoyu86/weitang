package c.e.a.d;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile y f1238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f1239d;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f1236a = iAvailableProcessors;
        f1237b = (iAvailableProcessors * 2) + 1;
    }

    public y() {
        int i2 = f1237b;
        this.f1239d = new ThreadPoolExecutor(i2, i2, 5000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(20), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static y get() {
        if (f1238c == null) {
            synchronized (y.class) {
                if (f1238c == null) {
                    f1238c = new y();
                }
            }
        }
        return f1238c;
    }

    public boolean addRunnable(Runnable runnable) {
        this.f1239d.execute(runnable);
        return true;
    }

    public void shutDownThreadPool() {
        this.f1239d.shutdown();
        this.f1239d = null;
        f1238c = null;
    }
}
