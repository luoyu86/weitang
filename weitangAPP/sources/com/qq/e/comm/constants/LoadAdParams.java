package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LoadAdParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginType f9652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f9656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f9657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f9658g = new JSONObject();

    public Map getDevExtra() {
        return this.f9656e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f9656e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f9656e).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f9657f;
    }

    public String getLoginAppId() {
        return this.f9653b;
    }

    public String getLoginOpenid() {
        return this.f9654c;
    }

    public LoginType getLoginType() {
        return this.f9652a;
    }

    public JSONObject getParams() {
        return this.f9658g;
    }

    public String getUin() {
        return this.f9655d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f9656e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f9657f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f9653b = str;
    }

    public void setLoginOpenid(String str) {
        this.f9654c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f9652a = loginType;
    }

    public void setUin(String str) {
        this.f9655d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f9652a + ", loginAppId=" + this.f9653b + ", loginOpenid=" + this.f9654c + ", uin=" + this.f9655d + ", passThroughInfo=" + this.f9656e + ", extraInfo=" + this.f9657f + '}';
    }
}
