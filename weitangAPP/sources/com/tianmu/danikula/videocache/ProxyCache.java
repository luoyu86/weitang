package com.tianmu.danikula.videocache;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyCache {
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private static final String TAG = "ProxyCache";
    private final Cache cache;
    private final Source source;
    private volatile Thread sourceReaderThread;
    private volatile boolean stopped;
    private final Object wc = new Object();
    private final Object stopLock = new Object();
    private volatile int percentsAvailable = -1;
    private final AtomicInteger readSourceErrorsCount = new AtomicInteger();

    public class SourceReaderRunnable implements Runnable {
        private SourceReaderRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProxyCache.this.readSource();
        }
    }

    public ProxyCache(Source source, Cache cache) {
        this.source = (Source) Preconditions.checkNotNull(source);
        this.cache = (Cache) Preconditions.checkNotNull(cache);
    }

    private void checkReadSourceErrorsCount() throws ProxyCacheException {
        int i2 = this.readSourceErrorsCount.get();
        if (i2 < 1) {
            return;
        }
        this.readSourceErrorsCount.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void closeSource() {
        try {
            this.source.close();
        } catch (ProxyCacheException e2) {
            onError(new ProxyCacheException("Error closing source " + this.source, e2));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.stopped;
    }

    private void notifyNewCacheDataAvailable(long j, long j2) {
        onCacheAvailable(j, j2);
        synchronized (this.wc) {
            this.wc.notifyAll();
        }
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readSource() {
        long length = -1;
        long jAvailable = 0;
        try {
            jAvailable = this.cache.available();
            this.source.open(jAvailable);
            length = this.source.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = this.source.read(bArr);
                if (i2 == -1) {
                    tryComplete();
                    onSourceRead();
                    break;
                }
                synchronized (this.stopLock) {
                    if (isStopped()) {
                        return;
                    } else {
                        this.cache.append(bArr, i2);
                    }
                }
                jAvailable += (long) i2;
                notifyNewCacheDataAvailable(jAvailable, length);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private synchronized void readSourceAsync() {
        boolean z = (this.sourceReaderThread == null || this.sourceReaderThread.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.stopped && !this.cache.isCompleted() && !z) {
            this.sourceReaderThread = new Thread(new SourceReaderRunnable(), "Source reader for " + this.source);
            this.sourceReaderThread.start();
        }
    }

    private void tryComplete() {
        synchronized (this.stopLock) {
            if (!isStopped() && this.cache.available() == this.source.length()) {
                this.cache.complete();
            }
        }
    }

    private void waitForSourceData() {
        synchronized (this.wc) {
            try {
                try {
                    this.wc.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onCacheAvailable(long j, long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i2 != this.percentsAvailable;
        if ((j2 >= 0) && z) {
            onCachePercentsAvailableChanged(i2);
        }
        this.percentsAvailable = i2;
    }

    public void onCachePercentsAvailableChanged(int i2) {
    }

    public final void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            Log.i(TAG, "ProxyCache is interrupted");
        } else {
            Log.i(TAG, "ProxyCache error");
        }
    }

    public int read(byte[] bArr, long j, int i2) throws ProxyCacheException {
        ProxyCacheUtils.assertBuffer(bArr, j, i2);
        while (!this.cache.isCompleted() && this.cache.available() < ((long) i2) + j && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        int i3 = this.cache.read(bArr, j, i2);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        return i3;
    }

    public void shutdown() {
        synchronized (this.stopLock) {
            Log.i(TAG, "Shutdown proxy for " + this.source);
            try {
                this.stopped = true;
                if (this.sourceReaderThread != null) {
                    this.sourceReaderThread.interrupt();
                }
                this.cache.close();
            } catch (ProxyCacheException e2) {
                onError(e2);
            }
        }
    }
}
