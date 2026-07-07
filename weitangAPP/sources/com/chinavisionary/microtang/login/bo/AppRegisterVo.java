package com.chinavisionary.microtang.login.bo;

import android.os.Build;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AppRegisterVo extends BaseVo {
    public static final int MAN = 1;
    public static final int WOMAN = 0;
    private String account;
    private String code;
    private int gender;
    private String nickname;
    private String password;
    private String phone;
    private String deviceName = Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL;
    private int systemType = 1;

    public String getAccount() {
        return this.account;
    }

    public String getCode() {
        return this.code;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getGender() {
        return this.gender;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setGender(int i2) {
        this.gender = i2;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSystemType(int i2) {
        this.systemType = i2;
    }
}
