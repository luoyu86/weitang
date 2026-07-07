package com.alipay.sdk.m.p;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5556b;

    public b(String str, String str2) {
        this.f5555a = str;
        this.f5556b = str2;
    }

    public String a() {
        return this.f5556b;
    }

    public String b() {
        return this.f5555a;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f5556b)) {
            return null;
        }
        try {
            return new JSONObject(this.f5556b);
        } catch (Exception e2) {
            com.alipay.sdk.m.u.e.a(e2);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f5555a, this.f5556b);
    }
}
