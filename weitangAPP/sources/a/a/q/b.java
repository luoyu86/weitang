package a.a.q;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(a.f196b.getAndIncrement())));
    }
}
