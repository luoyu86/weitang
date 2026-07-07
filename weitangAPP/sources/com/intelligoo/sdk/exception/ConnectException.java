package com.intelligoo.sdk.exception;

import android.bluetooth.BluetoothGatt;
import com.intelligoo.sdk.c.a;

/* JADX INFO: loaded from: classes2.dex */
public class ConnectException extends BleException {
    private BluetoothGatt bluetoothGatt;
    private int gattStatus;

    public ConnectException(BluetoothGatt bluetoothGatt, int i2) {
        super(a.CONNECT_ERR, "Connect Exception Occurred! ");
        this.bluetoothGatt = bluetoothGatt;
        this.gattStatus = i2;
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.bluetoothGatt;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public ConnectException setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.bluetoothGatt = bluetoothGatt;
        return this;
    }

    public ConnectException setGattStatus(int i2) {
        this.gattStatus = i2;
        return this;
    }

    @Override // com.intelligoo.sdk.exception.BleException
    public String toString() {
        return "ConnectException{gattStatus=" + this.gattStatus + ", bluetoothGatt=" + this.bluetoothGatt + "} " + super.toString();
    }
}
