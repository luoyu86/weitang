package com.tianmu.e.d;

import android.os.Handler;
import android.text.TextUtils;
import com.tianmu.http.listener.HttpListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.tianmu.e.d.b implements Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f12006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HttpListener f12007i;
    private final Map<HttpListener, List<WeakReference<Future<?>>>> j;

    /* JADX INFO: renamed from: com.tianmu.e.d.a$a, reason: collision with other inner class name */
    public class RunnableC0220a implements Runnable {
        public RunnableC0220a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f12007i.onRequestStart();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f12014c != -2001) {
                HttpListener httpListener = aVar.f12007i;
                a aVar2 = a.this;
                httpListener.onRequestFailed(aVar2.f12014c, aVar2.f12016e);
            } else {
                HttpListener httpListener2 = aVar.f12007i;
                a aVar3 = a.this;
                int i2 = aVar3.f12014c;
                String str = aVar3.f12016e;
                com.tianmu.e.b.a aVar4 = aVar3.f12017f;
                httpListener2.onRequestFailed(i2, str, aVar4 == null ? "" : aVar4.f());
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12010a;

        public c(String str) {
            this.f12010a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f12007i.onRequestSuccess(this.f12010a);
            a aVar = a.this;
            if (aVar.f12012a) {
                aVar.f12007i.onRequestSuccess(this.f12010a, a.this.f12018g);
            }
        }
    }

    public a(Handler handler, com.tianmu.e.b.a aVar, Map<HttpListener, List<WeakReference<Future<?>>>> map, HttpListener httpListener) {
        super(aVar);
        this.f12006h = handler;
        this.j = map;
        this.f12007i = httpListener;
    }

    private boolean b() {
        HttpListener httpListener;
        Map<HttpListener, List<WeakReference<Future<?>>>> map;
        return (this.f12006h == null || (httpListener = this.f12007i) == null || (map = this.j) == null || map.get(httpListener) == null) ? false : true;
    }

    private void c() {
        if (b()) {
            this.f12006h.post(new b());
        }
    }

    private void d() {
        if (b()) {
            this.f12006h.post(new RunnableC0220a());
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        d();
        String strA = a();
        if (this.f12015d == 200 || !TextUtils.isEmpty(strA)) {
            a(strA);
        } else {
            c();
        }
    }

    private void a(String str) {
        if (b()) {
            this.f12006h.post(new c(str));
        }
    }
}
