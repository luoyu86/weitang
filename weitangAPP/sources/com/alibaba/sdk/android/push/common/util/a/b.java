package com.alibaba.sdk.android.push.common.util.a;

import com.alibaba.sdk.android.error.ErrorCode;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ErrorCode f4889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f4890d;

    public b() {
        this.f4889c = com.alibaba.sdk.android.push.common.global.c.f4875a;
        this.f4887a = "";
        this.f4888b = 0;
        this.f4890d = d.UNKNOWN_TYPE;
    }

    public b(int i2) {
        this.f4889c = com.alibaba.sdk.android.push.common.global.c.f4875a;
        for (d dVar : d.values()) {
            if (dVar.a() == i2) {
                this.f4890d = dVar;
            }
        }
        this.f4887a = "";
        this.f4888b = 0;
    }
}
