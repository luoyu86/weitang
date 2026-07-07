package com.tianmu.apilib.api;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tianmu.api.iinterface.IAdmApiAd;
import com.tianmu.biz.utils.i0;
import com.tianmu.c.n.f;
import com.tianmu.http.listener.SimpleHttpListener;
import java.net.URLDecoder;
import java.util.UUID;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.e.a.a f10793a = new com.tianmu.e.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONArray f10797e;

    /* JADX INFO: renamed from: com.tianmu.apilib.api.a$a, reason: collision with other inner class name */
    public class C0182a extends SimpleHttpListener {
        public C0182a() {
        }

        @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
        public void onRequestSuccess(String str) {
            a.this.a(str, true);
        }
    }

    private boolean b() {
        return Build.VERSION.SDK_INT <= 19 || c();
    }

    private boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        return (24 == i2 || 25 == i2) && AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU.equalsIgnoreCase(Build.MANUFACTURER);
    }

    @Override // com.tianmu.apilib.api.b
    public void a(String str, long j) {
        if (TextUtils.isEmpty(this.f10794b)) {
            this.f10794b = str;
        }
        this.f10795c = j;
        if (this.f10796d) {
            return;
        }
        this.f10796d = true;
        a(i0.a().c("api_redirect", "KEY_API_REDIRECT"), false);
        this.f10793a.a(com.tianmu.b.c.a.c().a());
        this.f10793a.a("http://u.ssp.admobile.top/task/url/list", a(), new C0182a());
    }

    @Override // com.tianmu.apilib.api.b
    public boolean a(Context context, String str, String str2) {
        IAdmApiAd iAdmApiAdA = f.b().a();
        if (iAdmApiAdA != null && TextUtils.equals(this.f10794b, str2)) {
            try {
                if (b()) {
                    return false;
                }
                iAdmApiAdA.readyAd(context, str, this.f10795c);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.tianmu.apilib.api.b
    public boolean a(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = this.f10797e;
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < this.f10797e.length(); i2++) {
                        if (str.contains(this.f10797e.optString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strReplace = UUID.randomUUID().toString().replace("-", "");
            jSONObject.put("key", com.tianmu.apilib.utils.a.b(strReplace));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.m.t.a.k, System.currentTimeMillis());
            jSONObject.put("content", com.tianmu.c.d.a.b(jSONObject2.toString(), strReplace));
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("result");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("key");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                String strReplace = com.tianmu.apilib.utils.a.a(URLDecoder.decode(strOptString, "UTF-8")).replace("\"", "");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                String strOptString2 = jSONObjectOptJSONObject.optString("content");
                if (TextUtils.isEmpty(strOptString2)) {
                    return;
                }
                String strA = com.tianmu.c.d.a.a(URLDecoder.decode(strOptString2, "UTF-8"), strReplace);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                JSONArray jSONArrayOptJSONArray = new JSONObject(strA).optJSONArray("urls");
                this.f10797e = jSONArrayOptJSONArray;
                if (!z || jSONArrayOptJSONArray == null) {
                    return;
                }
                i0.a().a("api_redirect", "KEY_API_REDIRECT", str);
            }
        } catch (Throwable unused) {
        }
    }
}
