package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a extends ThreadPoolExecutor {
    public a(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0009a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0009a(callable);
    }

    /* JADX INFO: renamed from: anet.channel.thread.a$a, reason: collision with other inner class name */
    public class C0009a<V> extends FutureTask<V> implements Comparable<C0009a<V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f711b;

        public C0009a(Callable<V> callable) {
            super(callable);
            this.f711b = callable;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0009a<V> c0009a) {
            if (this == c0009a) {
                return 0;
            }
            if (c0009a == null) {
                return -1;
            }
            Object obj = this.f711b;
            if (obj != null && c0009a.f711b != null && obj.getClass().equals(c0009a.f711b.getClass())) {
                Object obj2 = this.f711b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(c0009a.f711b);
                }
            }
            return 0;
        }

        public C0009a(Runnable runnable, V v) {
            super(runnable, v);
            this.f711b = runnable;
        }
    }
}
