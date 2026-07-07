package com.ciba.http.request;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.ciba.http.entity.Request;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RequestUtil {
    public static String decompress(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        Inflater inflater = null;
        String string = null;
        inflater = null;
        inflater = null;
        inflater = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                try {
                    Inflater inflater2 = new Inflater();
                    try {
                        inflater2.setInput(bArr);
                        byte[] bArr2 = new byte[1024];
                        while (!inflater2.finished()) {
                            byteArrayOutputStream.write(bArr2, 0, inflater2.inflate(bArr2));
                        }
                        string = byteArrayOutputStream.toString();
                        byteArrayOutputStream.close();
                        inflater2.end();
                        try {
                            byteArrayOutputStream.close();
                            return string;
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            return string;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = string;
                        inflater = inflater2;
                        e.printStackTrace();
                        if (inflater != null) {
                            inflater.end();
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                                e = e4;
                                string = str;
                                e.printStackTrace();
                                return string;
                            }
                        }
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        inflater = inflater2;
                        if (inflater != null) {
                            inflater.end();
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e = e6;
                str = null;
            }
        } catch (Exception e7) {
            e = e7;
            byteArrayOutputStream = null;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static InputStream getInputStream(Request request, HttpURLConnection httpURLConnection) {
        List<String> list = httpURLConnection.getHeaderFields().get("Content-Encoding");
        if (list != null) {
            for (String str : list) {
                if (str != null) {
                    if (str.contains(HttpConstant.GZIP)) {
                        return new GZIPInputStream(httpURLConnection.getInputStream());
                    }
                    if (str.contains("deflate")) {
                        return new InflaterInputStream(httpURLConnection.getInputStream(), new Inflater(true));
                    }
                }
            }
        }
        return httpURLConnection.getInputStream();
    }

    public static String getSpliceParams(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    sb.append(key.trim());
                    sb.append("=");
                    sb.append(URLEncoder.encode(value.trim(), str));
                    sb.append("&");
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf("&"));
        }
        return sb.toString();
    }

    public static URL getUrl(String str, String str2, String str3) {
        String str4;
        if (!"GET".equalsIgnoreCase(str2) || TextUtils.isEmpty(str3)) {
            str4 = null;
        } else {
            str4 = str + "?" + str3;
        }
        if (str4 != null) {
            str = str4;
        }
        return new URL(str);
    }

    public static OutputStream initNotGetRequest(HttpURLConnection httpURLConnection, String str, Request request) throws IOException {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (request.getJson() != null) {
            str = request.getJson();
        }
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(request.getHttpConfig().getCharsetName());
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bytes);
        httpURLConnection.connect();
        return outputStream;
    }

    public static void initPublicRequest(HttpURLConnection httpURLConnection, Request request) throws ProtocolException {
        httpURLConnection.setRequestMethod(request.getRequestMethod());
        httpURLConnection.setConnectTimeout((int) request.getHttpConfig().getConnectTimeout());
        httpURLConnection.setReadTimeout((int) request.getHttpConfig().getReadTimeout());
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(request.getHttpConfig().isUseCaches());
    }

    public static void setHeaders(Request request, HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, "gzip,deflate");
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Content-Type", request.getJson() == null ? request.getHttpConfig().getContentType() : "application/json");
        httpURLConnection.setRequestProperty("Accept", request.getHttpConfig().getAccept());
        Map<String, String> headers = request.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
