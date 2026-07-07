package cn.admobiletop.adsuyi.a.h;

import com.ciba.http.client.AsyncHttpClient;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f3337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsyncHttpClient f3338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadPoolExecutor f3339c = e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f3340d = e();

    public d() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        this.f3338b = asyncHttpClient;
        asyncHttpClient.setThreadPool(b());
        asyncHttpClient.setConnectTimeout(5000L);
        asyncHttpClient.setReadTimeout(5000L);
    }

    public static d c() {
        if (f3337a == null) {
            synchronized (d.class) {
                if (f3337a == null) {
                    f3337a = new d();
                }
            }
        }
        return f3337a;
    }

    public void a(String str, Map<String, Object> map, cn.admobiletop.adsuyi.a.h.a.b bVar) {
        b(str, map, null, bVar);
    }

    public void b(String str, Map<String, Object> map, Map<String, Object> map2, cn.admobiletop.adsuyi.a.h.a.b bVar) {
        b().execute(new c(str, map, map2, bVar));
    }

    public ThreadPoolExecutor d() {
        return this.f3339c;
    }

    public final ThreadPoolExecutor e() {
        return new ThreadPoolExecutor(2, 10, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public void a(String str, Map<String, Object> map, Map<String, Object> map2, cn.admobiletop.adsuyi.a.h.a.b bVar) {
        b().execute(new b(str, map, map2, bVar));
    }

    public ThreadPoolExecutor b() {
        return this.f3340d;
    }

    public AsyncHttpClient a() {
        return this.f3338b;
    }
}
