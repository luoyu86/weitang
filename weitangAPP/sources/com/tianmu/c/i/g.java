package com.tianmu.c.i;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11717b;

    public g(String str) {
        this.f11716a = "0";
        this.f11717b = "0001";
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length < 3) {
                return;
            }
            String str2 = strArrSplit[0];
            this.f11716a = strArrSplit[1];
            this.f11717b = strArrSplit[2];
        }
    }

    public String a() {
        return this.f11717b;
    }

    public String b() {
        return this.f11716a;
    }
}
