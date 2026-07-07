package com.chinavisionary.framework.mobile.login.param;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class LoginSMSParam {
    private String code;
    private String phone;
    private String deviceName = Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL;
    private int systemType = 1;
    private int loginMode = 0;

    public String getCode() {
        return this.code;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getLoginMode() {
        return this.loginMode;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setLoginMode(int i2) {
        this.loginMode = i2;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSystemType(int i2) {
        this.systemType = i2;
    }
}
