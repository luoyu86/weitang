package com.tianmu.apilib.utils;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void a(String str, String str2, int i2, List<String> list) {
        HttpURLConnection httpURLConnectionA;
        InputStream errorStream;
        if (i2 >= 5) {
            return;
        }
        list.add(str);
        InputStream inputStream = null;
        try {
            httpURLConnectionA = a(str, str2);
            try {
                int responseCode = httpURLConnectionA.getResponseCode();
                if (200 == responseCode) {
                    errorStream = httpURLConnectionA.getInputStream();
                } else {
                    if (a(responseCode)) {
                        String headerField = httpURLConnectionA.getHeaderField("Location");
                        if (!QuickAppLinkUtil.isFilterQuickAppLink(headerField)) {
                            a(headerField, str2, i2 + 1, list);
                            a(httpURLConnectionA);
                            a(inputStream);
                        } else {
                            list.add(headerField);
                            QuickAppLinkUtil.reportAppLink(list);
                            a(httpURLConnectionA);
                            a(null);
                            return;
                        }
                    }
                    errorStream = httpURLConnectionA.getErrorStream();
                }
                inputStream = errorStream;
                a(httpURLConnectionA);
                a(inputStream);
            } catch (Throwable unused) {
                a(httpURLConnectionA);
                a(null);
            }
        } catch (Throwable unused2) {
            httpURLConnectionA = null;
        }
    }

    public static boolean a(int i2) {
        return 301 == i2 || 302 == i2 || 303 == i2;
    }

    public static String b(String str, String str2, int i2, List<String> list) {
        int responseCode;
        if (i2 >= 5) {
            return str;
        }
        list.add(str);
        HttpURLConnection httpURLConnectionA = null;
        try {
            httpURLConnectionA = a(str, str2);
            responseCode = httpURLConnectionA.getResponseCode();
        } catch (Throwable unused) {
        }
        if (200 == responseCode) {
            if (!QuickAppLinkUtil.isFilterQuickAppLink(str)) {
                a(httpURLConnectionA);
                return str;
            }
            QuickAppLinkUtil.reportAppLink(list);
            a(httpURLConnectionA);
            return "";
        }
        if (a(responseCode)) {
            String headerField = httpURLConnectionA.getHeaderField("Location");
            if (!QuickAppLinkUtil.isFilterQuickAppLink(headerField)) {
                String strB = b(headerField, str2, i2 + 1, list);
                a(httpURLConnectionA);
                return strB;
            }
            list.add(headerField);
            QuickAppLinkUtil.reportAppLink(list);
            a(httpURLConnectionA);
            return "";
        }
        a(httpURLConnectionA);
        return str;
    }

    private static HttpURLConnection a(String str, String str2) throws ProtocolException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        if (str != null && str.startsWith("https://")) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier(com.tianmu.b.b.a.c().a());
            httpsURLConnection.setSSLSocketFactory(com.tianmu.b.b.a.c().b());
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("connection", "Keep-Alive");
        if (!TextUtils.isEmpty(str2)) {
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, str2);
        }
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
