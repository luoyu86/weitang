package com.vtown.doorlibrary.bo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BleUnlockResponse implements Serializable {
    private String bluetoothCookie;
    private String bluetoothMac;
    private String bluetoothPassword;

    public String getBluetoothCookie() {
        return this.bluetoothCookie;
    }

    public String getBluetoothMac() {
        return this.bluetoothMac;
    }

    public String getBluetoothPassword() {
        return this.bluetoothPassword;
    }

    public void setBluetoothCookie(String str) {
        this.bluetoothCookie = str;
    }

    public void setBluetoothMac(String str) {
        this.bluetoothMac = str;
    }

    public void setBluetoothPassword(String str) {
        this.bluetoothPassword = str;
    }
}
