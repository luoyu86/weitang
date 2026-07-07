package c.e.a.c.b;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f1169b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f1168a = Executors.newSingleThreadScheduledExecutor(new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledFuture<?> f1170c = null;

    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public f(Activity activity) {
        this.f1169b = activity;
        onActivity();
    }

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.f1170c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f1170c = null;
        }
    }

    public void onActivity() {
        a();
        this.f1170c = this.f1168a.schedule(new e(this.f1169b), 300L, TimeUnit.SECONDS);
    }

    public void shutdown() {
        a();
        this.f1168a.shutdown();
    }
}
