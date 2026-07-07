package com.chinavisionary.microtang.login.bo;

import android.os.Build;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;

/* JADX INFO: loaded from: classes.dex */
public class NewAppRegisterVo extends BaseVo {
    public static final int MAN = 1;
    public static final int WOMAN = 2;
    private String account;
    private String code;
    private String credential;
    private int gender;
    private String identifier;
    private String nickname;
    private String password;
    private String phone;
    private int sex;
    private String identityType = NewLoginBo.LOGIN_NAME;
    private String deviceName = Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL;
    private int systemType = 1;
    private NewLoginBo.Extend extend = new NewLoginBo.Extend();

    public String getAccount() {
        return this.account;
    }

    public String getCode() {
        return this.code;
    }

    public String getCredential() {
        return this.credential;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public NewLoginBo.Extend getExtend() {
        return this.extend;
    }

    public int getGender() {
        return this.gender;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getIdentityType() {
        return this.identityType;
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

    public int getSex() {
        return this.sex;
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

    public void setCredential(String str) {
        this.credential = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setExtend(NewLoginBo.Extend extend) {
        this.extend = extend;
    }

    public void setGender(int i2) {
        this.gender = i2;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setIdentityType(String str) {
        this.identityType = str;
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

    public void setSex(int i2) {
        this.sex = i2;
    }

    public void setSystemType(int i2) {
        this.systemType = i2;
    }
}
