package com.tianmu.c.k;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tianmu.biz.utils.n0;
import com.tianmu.c.n.o;
import com.tianmu.http.listener.HttpListener;
import com.tianmu.http.listener.SimpleHttpListener;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f11779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TrustManager[] f11780c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HostnameVerifier f11781d = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private javax.net.ssl.SSLSocketFactory f11782a;

    private d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, f11780c, new SecureRandom());
            this.f11782a = sSLContext.getSocketFactory();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static d d() {
        if (f11779b == null) {
            synchronized (d.class) {
                if (f11779b == null) {
                    f11779b = new d();
                }
            }
        }
        return f11779b;
    }

    public com.tianmu.biz.web.c a() {
        return a(null);
    }

    public HostnameVerifier b() {
        return f11781d;
    }

    public javax.net.ssl.SSLSocketFactory c() {
        return this.f11782a;
    }

    public com.tianmu.biz.web.c a(ThreadPoolExecutor threadPoolExecutor) {
        return threadPoolExecutor == null ? new a(com.tianmu.c.n.c.c().a()) : new a(threadPoolExecutor);
    }

    public static class a implements com.tianmu.biz.web.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tianmu.e.a.a f11783a = new com.tianmu.e.a.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f11784b = new HashMap();

        public a(ThreadPoolExecutor threadPoolExecutor) {
            this.f11783a.a(d.d().b());
            this.f11783a.a(d.d().c());
            this.f11783a.a(threadPoolExecutor);
        }

        @Override // com.tianmu.biz.web.c
        public void a(String str, Map<String, String> map, HttpListener httpListener) {
            try {
                if (this.f11783a != null) {
                    b();
                    String strB = n0.b(str);
                    com.tianmu.e.a.a aVar = this.f11783a;
                    if (httpListener == null) {
                        httpListener = new SimpleHttpListener();
                    }
                    aVar.a(strB, map, httpListener);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.tianmu.biz.web.c
        public void b(String str, Map<String, String> map, HttpListener httpListener) {
            try {
                if (this.f11783a != null) {
                    b();
                    com.tianmu.e.a.a aVar = this.f11783a;
                    if (httpListener == null) {
                        httpListener = new SimpleHttpListener();
                    }
                    aVar.a(str, map, httpListener);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private void b() {
            this.f11783a.a(3000L);
            String strA = o.b().a();
            if (strA != null) {
                this.f11784b.put(HttpHeaders.USER_AGENT, strA);
                this.f11783a.a(this.f11784b);
            }
        }

        @Override // com.tianmu.biz.web.c
        public void a() {
            try {
                com.tianmu.e.a.a aVar = this.f11783a;
                if (aVar != null) {
                    aVar.c();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
