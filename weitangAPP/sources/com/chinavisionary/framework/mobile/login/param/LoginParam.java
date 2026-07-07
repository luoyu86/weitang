package com.chinavisionary.framework.mobile.login.param;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class LoginParam {
    public static final int ADMIN_USER = 0;
    public static final String DEVICE_NAME = Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL;
    public static final int WT_APP_TYPE = 1;
    private String account;
    private String password;
    private String deviceName = DEVICE_NAME;
    private int systemType = 1;
    private int loginMode = 0;

    public String getAccount() {
        return this.account;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getLoginMode() {
        return this.loginMode;
    }

    public String getPassword() {
        return this.password;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setLoginMode(int i2) {
        this.loginMode = i2;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSystemType(int i2) {
        this.systemType = i2;
    }
}
