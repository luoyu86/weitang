package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile b f5999e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f6000a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f6001b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Runnable> f6002c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Runnable> f6003d = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f5999e == null) {
            synchronized (b.class) {
                if (f5999e == null) {
                    f5999e = new b();
                }
            }
        }
        return f5999e;
    }
}
