package com.alibaba.sdk.android.push.a;

import com.alibaba.sdk.android.error.ErrorCode;

/* JADX INFO: loaded from: classes.dex */
public class f extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ErrorCode f4849a;

    public f(ErrorCode errorCode) {
        super(errorCode.toShortString());
        this.f4849a = errorCode;
    }

    public ErrorCode a() {
        return this.f4849a;
    }
}
