package com.tianmu.g;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.tianmu.g.i;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class e0 implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Object f12059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f12060c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f12061d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12062a;

    public static class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    public static class b {
        public static Object a(Context context) {
            File fileB = f0.b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(fileB, f0.a(fileB)) : installed;
        }
    }

    public e0(Context context) {
        this.f12062a = context.getApplicationContext();
    }

    public HttpURLConnection a(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(com.alipay.sdk.m.m.a.e0);
        return httpURLConnection;
    }

    @Override // com.tianmu.g.i
    public i.a a(Uri uri, int i2) throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 14) {
            a(this.f12062a);
        }
        HttpURLConnection httpURLConnectionA = a(uri);
        httpURLConnectionA.setUseCaches(true);
        if (i2 != 0) {
            if (p.a(i2)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = f12061d.get();
                sb.setLength(0);
                if (!p.b(i2)) {
                    sb.append("no-cache");
                }
                if (!p.c(i2)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionA.setRequestProperty("Cache-Control", string);
        }
        int responseCode = httpURLConnectionA.getResponseCode();
        if (responseCode < 300) {
            return new i.a(httpURLConnectionA.getInputStream(), f0.a(httpURLConnectionA.getHeaderField("X-Android-Response-Source")), httpURLConnectionA.getHeaderFieldInt("Content-Length", -1));
        }
        httpURLConnectionA.disconnect();
        throw new i.b(responseCode + " " + httpURLConnectionA.getResponseMessage(), i2, responseCode);
    }

    private static void a(Context context) {
        if (f12059b == null) {
            try {
                synchronized (f12060c) {
                    if (f12059b == null) {
                        f12059b = b.a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }
}
