package com.tianmu.e.a;

import android.os.Handler;
import android.os.Looper;
import com.tianmu.http.listener.HttpListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<HttpListener, List<WeakReference<Future<?>>>> f11991c = new WeakHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadPoolExecutor f11993e = com.tianmu.e.c.a.b().a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f11992d = new Handler(Looper.getMainLooper());

    public a a(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            this.f11993e = threadPoolExecutor;
        }
        return this;
    }

    public void b(String str, Map<String, String> map, HttpListener httpListener) {
        b(str, map, a(), httpListener);
    }

    public void c() {
        Iterator<HttpListener> it = this.f11991c.keySet().iterator();
        while (it.hasNext()) {
            a(it.next(), false);
        }
        this.f11991c.clear();
        Handler handler = this.f11992d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void a(String str, Map<String, String> map, HttpListener httpListener) {
        a(str, map, a(), httpListener);
    }

    public void b(String str, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        a(str, null, map, map2, httpListener);
    }

    public void a(String str, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        a("GET", str, null, map, map2, httpListener);
    }

    public void a(String str, String str2, HttpListener httpListener) {
        a(str, str2, a(), httpListener);
    }

    public void a(String str, String str2, Map<String, String> map, HttpListener httpListener) {
        a(str, str2, null, map, httpListener);
    }

    private void a(String str, String str2, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        a("POST", str, str2, map, map2, httpListener);
    }

    private void a(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        com.tianmu.e.b.a aVar = new com.tianmu.e.b.a(str, str2, b());
        aVar.a(str3);
        aVar.b(map);
        aVar.a(map2);
        Future<?> futureSubmit = this.f11993e.submit(new com.tianmu.e.d.a(this.f11992d, aVar, this.f11991c, httpListener));
        if (httpListener != null) {
            List<WeakReference<Future<?>>> linkedList = this.f11991c.get(httpListener);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f11991c.put(httpListener, linkedList);
            }
            linkedList.add(new WeakReference<>(futureSubmit));
        }
    }

    public void a(HttpListener httpListener, boolean z) {
        if (httpListener != null) {
            List<WeakReference<Future<?>>> list = this.f11991c.get(httpListener);
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    WeakReference<Future<?>> weakReference = list.get(i2);
                    if (weakReference != null && weakReference.get() != null) {
                        weakReference.get().cancel(true);
                    }
                }
            }
            if (z) {
                this.f11991c.remove(httpListener);
            }
        }
    }
}
