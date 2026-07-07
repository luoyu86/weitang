package com.ciba.http.manager;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncThreadPoolManager {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static AsyncThreadPoolManager instance;
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, 20, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(iAvailableProcessors - 1, 5));
    }

    private AsyncThreadPoolManager() {
    }

    public static AsyncThreadPoolManager getInstance() {
        if (instance == null) {
            synchronized (AsyncThreadPoolManager.class) {
                if (instance == null) {
                    instance = new AsyncThreadPoolManager();
                }
            }
        }
        return instance;
    }

    public ThreadPoolExecutor getThreadPool() {
        return this.threadPool;
    }
}
