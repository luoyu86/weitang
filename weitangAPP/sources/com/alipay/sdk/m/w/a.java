package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5726a = "CDT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5727b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5728c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5729d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5730e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5731f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> f5732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ExecutorService f5733h = Executors.newFixedThreadPool(16);

    /* JADX INFO: renamed from: com.alipay.sdk.m.w.a$a, reason: collision with other inner class name */
    public interface InterfaceC0091a<T, R> {
        R a(T t);
    }

    public static synchronized void a(int i2, Object obj) {
        if (f5732g == null) {
            f5732g = new ConcurrentHashMap<>();
        }
        f5732g.put(Integer.valueOf(i2), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
    }

    public static Pair<Boolean, ?> a(int i2, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = f5732g;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i2));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l = (Long) pair.first;
        Object obj = pair.second;
        if (l != null && SystemClock.elapsedRealtime() - l.longValue() <= TimeUnit.MILLISECONDS.convert(j, timeUnit)) {
            return new Pair<>(Boolean.TRUE, obj);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    public static synchronized void a() {
        f5732g = null;
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static <T> T a(int i2, long j, TimeUnit timeUnit, InterfaceC0091a<Object, Boolean> interfaceC0091a, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, com.alipay.sdk.m.s.a aVar, boolean z2) {
        T tCall;
        try {
            Pair<Boolean, ?> pairA = a(i2, timeUnit, j);
            if (((Boolean) pairA.first).booleanValue() && interfaceC0091a.a(pairA.second).booleanValue()) {
                e.d("getC", i2 + " got " + pairA.second);
                return (T) pairA.second;
            }
            if (z2 && n.h()) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "ch_get_main", "" + i2);
                e.d("getC", i2 + " skip");
                tCall = null;
            } else {
                if (z) {
                    tCall = f5733h.submit(callable).get(j2, timeUnit2);
                } else {
                    tCall = callable.call();
                }
                a(i2, tCall);
            }
            e.d("getC", i2 + " new " + tCall);
            return tCall;
        } catch (Throwable th) {
            e.a(f5726a, "ch_get_e|" + i2, th);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ch_get_e|" + i2, th);
            e.d("getC", i2 + " err");
            return null;
        }
    }
}
