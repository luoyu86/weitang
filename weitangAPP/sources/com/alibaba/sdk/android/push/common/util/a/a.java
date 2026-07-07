package com.alibaba.sdk.android.push.common.util.a;

import com.alibaba.sdk.android.error.ErrorCode;

/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ErrorCode f4886a;

    public a(ErrorCode errorCode) {
        super(errorCode.toShortString());
        this.f4886a = errorCode;
    }

    public ErrorCode a() {
        return this.f4886a;
    }
}
