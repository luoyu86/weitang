package com.alibaba.sdk.android.push.common.util.a;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends AsyncTask<Map<String, String>, Void, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AmsLogger f4891a = AmsLogger.getLogger("MPS:SendRequestTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f4893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4894d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4892b = "POST";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4895e = 0;

    public c(Context context, String str) {
        this.f4893c = context;
        this.f4894d = str;
    }

    private void a(String str, Map<String, String> map) {
        try {
            f4891a.d("request url :" + str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                f4891a.d("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    public int a() {
        return this.f4895e;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b doInBackground(Map<String, String>... mapArr) {
        b bVar;
        Map<String, String> map = mapArr[0];
        if (map.containsKey("VipRequestType")) {
            this.f4895e = Integer.parseInt(map.get("VipRequestType"));
            bVar = new b(Integer.parseInt(map.get("VipRequestType")));
        } else {
            bVar = new b();
        }
        try {
            String strA = a(this.f4893c, this.f4894d, map);
            bVar.f4888b = 200;
            bVar.f4887a = strA;
        } catch (a e2) {
            bVar.f4889c = e2.a();
            bVar.f4888b = -1;
            bVar.f4887a = e2.getMessage();
        }
        return bVar;
    }

    public String a(Context context, String str, Map<String, String> map) {
        int i2;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    Map<String, String> mapA = a(context, map);
                    a(str, mapA);
                    HttpURLConnection httpURLConnectionA = com.alibaba.sdk.android.ams.common.util.a.a(str, mapA, this.f4892b);
                    if (httpURLConnectionA == null) {
                        f4891a.e("failed to access VIP service.");
                        throw new a(com.alibaba.sdk.android.push.common.global.c.p.copy().msg("创建请求连接失败").build());
                    }
                    if (httpURLConnectionA.getResponseCode() != 200) {
                        throw new a(com.alibaba.sdk.android.push.common.global.c.p.copy().msg("请求失败：" + httpURLConnectionA.getResponseCode()).build());
                    }
                    InputStream inputStream = httpURLConnectionA.getInputStream();
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    while (!Thread.interrupted() && (i2 = inputStream.read(bArr)) != -1) {
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    String string = byteArrayOutputStream.toString("utf-8");
                    httpURLConnectionA.disconnect();
                    return string;
                } catch (a e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                f4891a.e("VIP API failed! error: ", th);
                throw new a(com.alibaba.sdk.android.push.common.global.c.p.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    public abstract Map<String, String> a(Context context, Map<String, String> map);

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(b bVar) {
        f4891a.i("HTTP Return code: " + bVar.f4888b);
    }
}
