package com.alibaba.sdk.android.man.crashreporter.a.b;

import android.os.Looper;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class a extends Error {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Thread, StackTraceElement[]> f4691b;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.a.b.a$a, reason: collision with other inner class name */
    public static class C0061a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StackTraceElement[] f4693a;
        private final String r;

        /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.a.b.a$a$a, reason: collision with other inner class name */
        public class C0062a extends Throwable {
            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                setStackTrace(C0061a.this.f4693a);
                return this;
            }

            private C0062a(C0062a c0062a) {
                super(C0061a.this.r, c0062a);
            }
        }

        private C0061a(String str, StackTraceElement[] stackTraceElementArr) {
            this.r = str;
            this.f4693a = stackTraceElementArr;
        }
    }

    private a(C0061a.C0062a c0062a, Map<Thread, StackTraceElement[]> map) {
        super("Application Not Responding", c0062a);
        this.f4691b = map;
    }

    public static a a(String str, boolean z) {
        final Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() { // from class: com.alibaba.sdk.android.man.crashreporter.a.b.a.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Thread thread2, Thread thread3) {
                if (thread2 == thread3) {
                    return 0;
                }
                Thread thread4 = thread;
                if (thread2 == thread4) {
                    return 1;
                }
                if (thread3 == thread4) {
                    return -1;
                }
                return thread3.getName().compareTo(thread2.getName());
            }
        });
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        C0061a.C0062a c0062a = null;
        for (Map.Entry entry2 : treeMap.entrySet()) {
            c0062a = new C0061a.C0062a(c0062a);
        }
        return new a(c0062a, treeMap);
    }

    public static Map<Thread, StackTraceElement[]> d() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread == null) {
            return null;
        }
        HashMap map = new HashMap(1);
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        map.put(threadCurrentThread, stackTrace);
        return map;
    }

    public static Map<Thread, StackTraceElement[]> e() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            return null;
        }
        HashMap map = new HashMap(1);
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        map.put(thread, stackTrace);
        return map;
    }

    public Map<Thread, StackTraceElement[]> c() {
        return this.f4691b;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public static a a() {
        Thread thread = Looper.getMainLooper().getThread();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        HashMap map = new HashMap(1);
        map.put(thread, stackTrace);
        return new a(new C0061a.C0062a(0 == true ? 1 : 0), map);
    }
}
