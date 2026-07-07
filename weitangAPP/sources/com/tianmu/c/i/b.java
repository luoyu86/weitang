package com.tianmu.c.i;

import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f11689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f11690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f11691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f11692d;

    public void a(List<String> list) {
        this.f11689a = list;
    }

    public void b(List<String> list) {
        this.f11690b = list;
    }

    public void a(JSONObject jSONObject) {
        this.f11691c = jSONObject;
    }

    public void b(JSONObject jSONObject) {
        this.f11692d = jSONObject;
    }

    public List<String> a() {
        return this.f11689a;
    }

    public List<String> b() {
        return this.f11690b;
    }

    public String a(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.f11691c;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return "";
        }
        String strOptString = TextUtils.isEmpty(str2) ? "" : jSONObjectOptJSONObject.optString(str2);
        return TextUtils.isEmpty(strOptString) ? jSONObjectOptJSONObject.optString(AccsClientConfig.DEFAULT_CONFIG_TAG) : strOptString;
    }

    public String b(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.f11692d;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return "";
        }
        String strOptString = TextUtils.isEmpty(str2) ? "" : jSONObjectOptJSONObject.optString(str2);
        return TextUtils.isEmpty(strOptString) ? jSONObjectOptJSONObject.optString(AccsClientConfig.DEFAULT_CONFIG_TAG) : strOptString;
    }
}
