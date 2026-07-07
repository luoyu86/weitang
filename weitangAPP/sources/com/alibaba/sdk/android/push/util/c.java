package com.alibaba.sdk.android.push.util;

import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AmsLogger f5019c = AmsLogger.getLogger("MPS:SyncTool");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lock f5020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Condition f5021b;

    public c() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f5020a = reentrantLock;
        this.f5021b = reentrantLock.newCondition();
    }

    public void a() {
        this.f5020a.lock();
        try {
            this.f5021b.signal();
        } finally {
            this.f5020a.unlock();
        }
    }

    public void a(int i2) {
        this.f5020a.lock();
        try {
            try {
                this.f5021b.await(i2, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                f5019c.e("await error:", e2);
            }
        } finally {
            this.f5020a.unlock();
        }
    }
}
