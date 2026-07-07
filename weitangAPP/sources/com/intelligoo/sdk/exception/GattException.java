package com.intelligoo.sdk.exception;

import com.intelligoo.sdk.c.a;

/* JADX INFO: loaded from: classes2.dex */
public class GattException extends BleException {
    private int gattStatus;

    public GattException(int i2) {
        super(a.GATT_ERR, "Gatt Exception Occurred! ");
        this.gattStatus = i2;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public GattException setGattStatus(int i2) {
        this.gattStatus = i2;
        return this;
    }

    @Override // com.intelligoo.sdk.exception.BleException
    public String toString() {
        return "GattException{gattStatus=" + this.gattStatus + '}' + super.toString();
    }
}
