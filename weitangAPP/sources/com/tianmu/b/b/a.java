package com.tianmu.b.b;

import android.os.Build;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alipay.sdk.m.l.c;
import com.sun.mail.imap.IMAPStore;
import com.tianmu.apilib.ad.IAdHttp;
import com.tianmu.apilib.utils.f;
import com.tianmu.b.c.b;
import com.tianmu.biz.utils.u0;
import com.tianmu.biz.utils.x;
import com.tianmu.c.i.i;
import com.tianmu.c.n.n;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f10806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HostnameVerifier f10807c = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TrustManager[] f10808d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private javax.net.ssl.SSLSocketFactory f10809a;

    /* JADX INFO: renamed from: com.tianmu.b.b.a$a, reason: collision with other inner class name */
    public static class C0183a implements IAdHttp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tianmu.e.a.a f10810a = new com.tianmu.e.a.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f10811b = new HashMap();

        public C0183a(ThreadPoolExecutor threadPoolExecutor) {
            this.f10810a.a(a.c().a());
            this.f10810a.a(a.c().b());
            this.f10810a.a(threadPoolExecutor);
        }

        private void a() {
            this.f10810a.a(3000L);
            String strE = b.g().e();
            if (strE != null) {
                this.f10811b.put(HttpHeaders.USER_AGENT, strE);
                this.f10810a.a(this.f10811b);
            }
        }

        @Override // com.tianmu.apilib.ad.IAdHttp
        public void get(String str, Map<String, String> map, HttpListener httpListener) {
            try {
                if (this.f10810a != null) {
                    a();
                    this.f10810a.a(str, map, httpListener);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.tianmu.apilib.ad.IAdHttp
        public void getAd(String str, Map<String, String> map, HttpListener httpListener) {
            try {
                if (this.f10810a != null) {
                    a();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    map.put("ts", jCurrentTimeMillis + "");
                    i iVarD = n.D().d();
                    if (iVarD != null) {
                        map.put("appid", iVarD.c());
                        map.put("sign", x.a(jCurrentTimeMillis + iVarD.d()));
                    }
                    map.put(IMAPStore.ID_VENDOR, Build.MANUFACTURER);
                    String strA = u0.a(32);
                    String strA2 = f.a(strA);
                    String strB = com.tianmu.c.d.a.b(new JSONObject(map).toString(), strA);
                    HashMap map2 = new HashMap();
                    map2.put(c.m, "1.0");
                    map2.put("apiSecret", strA2);
                    map2.put("apiInfo", strB);
                    com.tianmu.e.a.a aVar = this.f10810a;
                    if (httpListener == null) {
                        httpListener = new SimpleHttpListener();
                    }
                    aVar.a(str, map2, httpListener);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.tianmu.apilib.ad.IAdHttp
        public void post(String str, Map<String, String> map, HttpListener httpListener) {
            try {
                if (this.f10810a != null) {
                    a();
                    this.f10810a.b(str, map, httpListener);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, f10808d, new SecureRandom());
            this.f10809a = sSLContext.getSocketFactory();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static a c() {
        if (f10806b == null) {
            synchronized (a.class) {
                if (f10806b == null) {
                    f10806b = new a();
                }
            }
        }
        return f10806b;
    }

    public IAdHttp a(ThreadPoolExecutor threadPoolExecutor) {
        return threadPoolExecutor == null ? new C0183a(com.tianmu.b.c.a.c().a()) : new C0183a(threadPoolExecutor);
    }

    public javax.net.ssl.SSLSocketFactory b() {
        return this.f10809a;
    }

    public HostnameVerifier a() {
        return f10807c;
    }
}
