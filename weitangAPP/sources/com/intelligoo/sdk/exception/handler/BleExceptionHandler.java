package com.intelligoo.sdk.exception.handler;

import com.intelligoo.sdk.exception.BleException;
import com.intelligoo.sdk.exception.ConnectException;
import com.intelligoo.sdk.exception.GattException;
import com.intelligoo.sdk.exception.InitiatedException;
import com.intelligoo.sdk.exception.OtherException;
import com.intelligoo.sdk.exception.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BleExceptionHandler {
    public BleExceptionHandler handleException(BleException bleException) {
        if (bleException != null) {
            if (bleException instanceof ConnectException) {
                onConnectException((ConnectException) bleException);
            } else if (bleException instanceof GattException) {
                onGattException((GattException) bleException);
            } else if (bleException instanceof TimeoutException) {
                onTimeoutException((TimeoutException) bleException);
            } else if (bleException instanceof InitiatedException) {
                onInitiatedException((InitiatedException) bleException);
            } else {
                onOtherException((OtherException) bleException);
            }
        }
        return this;
    }

    public abstract void onConnectException(ConnectException connectException);

    public abstract void onGattException(GattException gattException);

    public abstract void onInitiatedException(InitiatedException initiatedException);

    public abstract void onOtherException(OtherException otherException);

    public abstract void onTimeoutException(TimeoutException timeoutException);
}
