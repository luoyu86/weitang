package com.intelligoo.sdk.exception.handler;

import com.intelligoo.sdk.exception.ConnectException;
import com.intelligoo.sdk.exception.GattException;
import com.intelligoo.sdk.exception.InitiatedException;
import com.intelligoo.sdk.exception.OtherException;
import com.intelligoo.sdk.exception.TimeoutException;
import com.intelligoo.sdk.utils.BleLog;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultBleExceptionHandler extends BleExceptionHandler {
    @Override // com.intelligoo.sdk.exception.handler.BleExceptionHandler
    public void onConnectException(ConnectException connectException) {
        BleLog.e(connectException.getDescription());
    }

    @Override // com.intelligoo.sdk.exception.handler.BleExceptionHandler
    public void onGattException(GattException gattException) {
        BleLog.e(gattException.getDescription());
    }

    @Override // com.intelligoo.sdk.exception.handler.BleExceptionHandler
    public void onInitiatedException(InitiatedException initiatedException) {
        BleLog.e(initiatedException.getDescription());
    }

    @Override // com.intelligoo.sdk.exception.handler.BleExceptionHandler
    public void onOtherException(OtherException otherException) {
        BleLog.e(otherException.getDescription());
    }

    @Override // com.intelligoo.sdk.exception.handler.BleExceptionHandler
    public void onTimeoutException(TimeoutException timeoutException) {
        BleLog.e(timeoutException.getDescription());
    }
}
