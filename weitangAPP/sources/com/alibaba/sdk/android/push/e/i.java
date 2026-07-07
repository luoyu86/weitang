package com.alibaba.sdk.android.push.e;

import android.util.Log;
import com.taobao.accs.common.Constants;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static String a(int i2, int i3, String str) throws com.alibaba.sdk.android.push.a.f {
        try {
            if (i3 == 200) {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("code");
                if (string.equals("OK")) {
                    return jSONObject.has("data") ? a(i2, jSONObject.getString("data")) : "";
                }
                throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.b(string, jSONObject.getString(Constants.SHARED_MESSAGE_ID_FILE)));
            }
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.p.copy().msg("请求失败" + i3).detail("requestType:" + i2).build());
        } catch (JSONException e2) {
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.f4883i.copy().msg(e2.getMessage()).detail("content: " + str).build());
        }
    }

    public static String a(int i2, String str) throws com.alibaba.sdk.android.push.a.f {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (i2 == com.alibaba.sdk.android.push.common.util.a.d.LIST_TAGS.a()) {
                return jSONObject.getString("tags");
            }
            if (i2 == com.alibaba.sdk.android.push.common.util.a.d.LIST_ALIASES.a()) {
                return jSONObject.getString("alias");
            }
            if (i2 == com.alibaba.sdk.android.push.common.util.a.d.CONFIG.a()) {
                return jSONObject.getString("deviceId");
            }
            if (i2 == com.alibaba.sdk.android.push.common.util.a.d.CHECK_PUSH_STATUS.a()) {
                return jSONObject.getBoolean("status") ? PDPrintFieldAttributeObject.CHECKED_STATE_ON : PDPrintFieldAttributeObject.CHECKED_STATE_OFF;
            }
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.f4883i.copy().detail("unknown request type " + i2).detail("data : " + str).build());
        } catch (JSONException e2) {
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.f4883i.copy().detail(e2.getMessage()).detail("data : " + str).build());
        }
    }

    public static String a(int i2, HttpURLConnection httpURLConnection) throws com.alibaba.sdk.android.push.a.f {
        try {
            if (httpURLConnection.getResponseCode() == 200) {
                JSONObject jSONObject = new JSONObject(a(httpURLConnection));
                String string = jSONObject.getString("code");
                if (string.equals("OK")) {
                    return jSONObject.has("data") ? a(i2, jSONObject.getString("data")) : "";
                }
                throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.b(string, jSONObject.getString(Constants.SHARED_MESSAGE_ID_FILE)));
            }
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.p.copy().msg("请求失败" + httpURLConnection.getResponseCode()).detail("requestType:" + i2).build());
        } catch (IOException e2) {
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.f4882h.copy().msg(e2.getMessage()).detail(Log.getStackTraceString(e2)).build());
        } catch (JSONException e3) {
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.f4883i.copy().msg(e3.getMessage()).detail("content: " + ((String) null)).build());
        }
    }

    private static String a(HttpURLConnection httpURLConnection) {
        int i2;
        InputStream inputStream = httpURLConnection.getInputStream();
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        while (!Thread.interrupted() && (i2 = inputStream.read(bArr)) != -1) {
            byteArrayOutputStream.write(bArr, 0, i2);
        }
        return byteArrayOutputStream.toString("utf-8");
    }
}
