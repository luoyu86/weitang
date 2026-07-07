package com.intelligoo.sdk.exception;

import com.intelligoo.sdk.c.a;

/* JADX INFO: loaded from: classes2.dex */
public class TimeoutException extends BleException {
    public TimeoutException() {
        super(a.TIMEOUT, "Timeout Exception Occurred! ");
    }
}
