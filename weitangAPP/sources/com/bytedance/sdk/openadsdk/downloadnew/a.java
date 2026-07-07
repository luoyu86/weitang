package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class a {

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f6365a;
        public int bl;
        public InputStream ok;
        public HttpURLConnection s;

        public ok(InputStream inputStream, Map<String, String> map, int i2, HttpURLConnection httpURLConnection) {
            this.ok = inputStream;
            this.f6365a = map;
            this.bl = i2;
            this.s = httpURLConnection;
        }
    }

    public static HttpURLConnection ok(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? ok(httpURLConnection2.getHeaderField("Location"), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> ok(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            map.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
        }
        return map;
    }

    public static ok ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                map.put(blVar.ok(), blVar.a());
            }
        }
        HttpURLConnection httpURLConnectionOk = ok(str, map);
        if (httpURLConnectionOk == null || (responseCode = httpURLConnectionOk.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapOk = ok(httpURLConnectionOk);
        InputStream inputStream = httpURLConnectionOk.getInputStream();
        String contentEncoding = httpURLConnectionOk.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(HttpConstant.GZIP)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new ok(inputStream, mapOk, responseCode, httpURLConnectionOk);
    }
}
