package com.chinavisionary.microtang.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ILockPasswordVo extends BaseVo {
    private String BluetoothDataSecret;
    private String BluetoothUserKey;
    private Long UnixTimestamp;

    public String getBluetoothDataSecret() {
        return this.BluetoothDataSecret;
    }

    public String getBluetoothUserKey() {
        return this.BluetoothUserKey;
    }

    public Long getUnixTimestamp() {
        return this.UnixTimestamp;
    }

    public void setBluetoothDataSecret(String str) {
        this.BluetoothDataSecret = str;
    }

    public void setBluetoothUserKey(String str) {
        this.BluetoothUserKey = str;
    }

    public void setUnixTimestamp(Long l) {
        this.UnixTimestamp = l;
    }
}
