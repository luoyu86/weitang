package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class DiskCacheWriteLocker {
    private final Map<Key, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    public static class WriteLock {
        public int interestedThreads;
        public final Lock lock;

        private WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;

        private WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public WriteLock obtain() {
            WriteLock writeLockPoll;
            synchronized (this.pool) {
                writeLockPoll = this.pool.poll();
            }
            return writeLockPoll == null ? new WriteLock() : writeLockPoll;
        }

        public void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }

    public void acquire(Key key) {
        WriteLock writeLockObtain;
        synchronized (this) {
            writeLockObtain = this.locks.get(key);
            if (writeLockObtain == null) {
                writeLockObtain = this.writeLockPool.obtain();
                this.locks.put(key, writeLockObtain);
            }
            writeLockObtain.interestedThreads++;
        }
        writeLockObtain.lock.lock();
    }

    public void release(Key key) {
        WriteLock writeLock;
        int i2;
        synchronized (this) {
            writeLock = this.locks.get(key);
            if (writeLock != null && (i2 = writeLock.interestedThreads) > 0) {
                int i3 = i2 - 1;
                writeLock.interestedThreads = i3;
                if (i3 == 0) {
                    WriteLock writeLockRemove = this.locks.remove(key);
                    if (!writeLockRemove.equals(writeLock)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLockRemove + ", key: " + key);
                    }
                    this.writeLockPool.offer(writeLockRemove);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(key);
            sb.append(", interestedThreads: ");
            sb.append(writeLock == null ? 0 : writeLock.interestedThreads);
            throw new IllegalArgumentException(sb.toString());
        }
        writeLock.lock.unlock();
    }
}
