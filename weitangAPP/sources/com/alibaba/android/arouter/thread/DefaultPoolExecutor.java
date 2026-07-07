package com.alibaba.android.arouter.thread;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DefaultPoolExecutor extends ThreadPoolExecutor {
    private static final int CPU_COUNT;
    private static final int INIT_THREAD_COUNT;
    private static final int MAX_THREAD_COUNT;
    private static final long SURPLUS_THREAD_LIFE = 30;
    private static DefaultPoolExecutor instance;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        int i2 = iAvailableProcessors + 1;
        INIT_THREAD_COUNT = i2;
        MAX_THREAD_COUNT = i2;
    }

    private DefaultPoolExecutor(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() { // from class: com.alibaba.android.arouter.thread.DefaultPoolExecutor.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                ARouter.logger.error("ARouter::", "Task rejected, too many task!");
            }
        });
    }

    public static DefaultPoolExecutor getInstance() {
        if (instance == null) {
            synchronized (DefaultPoolExecutor.class) {
                if (instance == null) {
                    instance = new DefaultPoolExecutor(INIT_THREAD_COUNT, MAX_THREAD_COUNT, SURPLUS_THREAD_LIFE, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new DefaultThreadFactory());
                }
            }
        }
        return instance;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e2) {
                th = e2;
            } catch (ExecutionException e3) {
                th = e3.getCause();
            }
        }
        if (th != null) {
            ARouter.logger.warning("ARouter::", "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + TextUtils.formatStackTrace(th.getStackTrace()));
        }
    }
}
