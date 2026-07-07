package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import cn.admobiletop.adsuyi.c.InterfaceC0337q;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class P implements InterfaceC0337q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Object f4203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f4204b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f4205c = new O();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f4206d;

    public static class a {
        public static Object a(Context context) {
            File fileR = S.r(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(fileR, S.d(fileR)) : installed;
        }
    }

    public P(Context context) {
        this.f4206d = context.getApplicationContext();
    }

    public static void c(Context context) {
        if (f4203a == null) {
            try {
                synchronized (f4204b) {
                    if (f4203a == null) {
                        f4203a = a.a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.c.InterfaceC0337q
    public InterfaceC0337q.a a(Uri uri, int i2) throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 14) {
            c(this.f4206d);
        }
        HttpURLConnection httpURLConnectionB = b(uri);
        httpURLConnectionB.setUseCaches(true);
        if (i2 != 0) {
            if (x.a(i2)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = f4205c.get();
                sb.setLength(0);
                if (!x.b(i2)) {
                    sb.append("no-cache");
                }
                if (!x.c(i2)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionB.setRequestProperty("Cache-Control", string);
        }
        int responseCode = httpURLConnectionB.getResponseCode();
        if (responseCode < 300) {
            return new InterfaceC0337q.a(httpURLConnectionB.getInputStream(), S.q(httpURLConnectionB.getHeaderField("X-Android-Response-Source")), httpURLConnectionB.getHeaderFieldInt("Content-Length", -1));
        }
        httpURLConnectionB.disconnect();
        throw new InterfaceC0337q.b(responseCode + " " + httpURLConnectionB.getResponseMessage(), i2, responseCode);
    }

    public HttpURLConnection b(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(com.alipay.sdk.m.m.a.e0);
        return httpURLConnection;
    }
}
