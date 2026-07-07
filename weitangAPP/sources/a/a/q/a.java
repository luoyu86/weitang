package a.a.q;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService[] f195a = new ExecutorService[2];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicInteger f196b = new AtomicInteger(0);

    static {
        for (int i2 = 0; i2 < 2; i2++) {
            f195a[i2] = Executors.newSingleThreadExecutor(new b());
        }
    }

    public static void a(int i2, Runnable runnable) {
        f195a[Math.abs(i2 % 2)].submit(runnable);
    }
}
