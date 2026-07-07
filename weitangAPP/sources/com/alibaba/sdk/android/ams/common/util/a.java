package com.alibaba.sdk.android.ams.common.util;

import android.content.Context;
import android.util.Base64;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.qq.e.comm.constants.ErrorCode;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AmsLogger f4597a = AmsLogger.getLogger("MPS:httpClient");

    /* JADX INFO: renamed from: com.alibaba.sdk.android.ams.common.util.a$a, reason: collision with other inner class name */
    public static class C0056a extends IOException {
        public C0056a(IOException iOException, int i2) {
            super(iOException.getMessage() + " code " + i2, iOException);
        }
    }

    public static HttpURLConnection a(String str, Map<String, String> map, String str2) {
        return "POST".equals(str2) ? a(str, map, str2, 0, null) : a(str, map, str2, 0);
    }

    @Deprecated
    private static HttpURLConnection a(String str, Map<String, String> map, String str2, int i2) throws ProtocolException, C0056a {
        if (i2 >= 3) {
            throw new C0056a(new IOException("redirectCount > 3"), 300);
        }
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    f4597a.w("skip empty entry " + entry.getKey());
                } else {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue(), "utf-8"));
                    sb.append("&");
                }
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str + "?" + ((Object) sb)).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(str2 == null ? "GET" : str2);
        httpURLConnection.setReadTimeout(ErrorCode.UNKNOWN_ERROR);
        httpURLConnection.setConnectTimeout(ErrorCode.UNKNOWN_ERROR);
        httpURLConnection.connect();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            f4597a.d("responseCode: " + responseCode);
            return (responseCode != 200 && responseCode / 3 == 100) ? a(httpURLConnection.getHeaderField("Location"), map, str2, i2) : httpURLConnection;
        } catch (IOException e2) {
            f4597a.d("openConnection: ", e2);
            throw new C0056a(e2, httpURLConnection.getResponseCode());
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map, String str2, int i2, Context context) throws IOException {
        if (i2 >= 3) {
            throw new C0056a(new IOException("redirectCount > 3"), 300);
        }
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    f4597a.w("skip empty entry " + entry.getKey());
                } else {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(Base64.encodeToString(entry.getValue().getBytes(), 8));
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(ErrorCode.UNKNOWN_ERROR);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(ErrorCode.UNKNOWN_ERROR);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(sb.toString().getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            f4597a.d("responseCode: " + responseCode);
            return (responseCode != 200 && responseCode / 3 == 100) ? a(httpURLConnection.getHeaderField("Location"), map, str2, i2, context) : httpURLConnection;
        } catch (IOException e2) {
            f4597a.d("openConnection: ", e2);
            throw new C0056a(e2, httpURLConnection.getResponseCode());
        }
    }
}
