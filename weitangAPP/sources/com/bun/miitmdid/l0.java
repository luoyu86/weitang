package com.bun.miitmdid;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BlockingQueue<Runnable> f5883d = new ArrayBlockingQueue(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ThreadFactory f5884e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5880a = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f5882c = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5881b = 6000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ThreadPoolExecutor f5885f = new ThreadPoolExecutor(f5880a, f5882c, f5881b, TimeUnit.SECONDS, f5883d, f5884e);

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f5886a = new AtomicInteger();

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    public static native void a(Runnable runnable);
}
