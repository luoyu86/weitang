package com.alipay.sdk.m.i0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f5372b;

    public void a(boolean z) {
        this.f5372b = Boolean.valueOf(z);
    }

    public boolean a() {
        return this.f5372b != null;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f5371a, str);
    }

    public void b(String str) {
        this.f5371a = str;
    }

    public boolean b() {
        Boolean bool = this.f5372b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
