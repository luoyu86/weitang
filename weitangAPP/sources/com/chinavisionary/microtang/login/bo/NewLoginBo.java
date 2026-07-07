package com.chinavisionary.microtang.login.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class NewLoginBo extends BaseVo {
    public static final String LOGIN_NAME = "loginname";
    public static final String SMS_LOGIN_NAME = "phone";
    private String code;
    private String credential;
    private String identifier;
    private String identityType = SMS_LOGIN_NAME;
    private Extend extend = new Extend();

    public static class Extend extends BaseVo {
        private String deviceType;
        private int source = 1;

        public String getDeviceType() {
            return this.deviceType;
        }

        public int getSource() {
            return this.source;
        }

        public void setDeviceType(String str) {
            this.deviceType = str;
        }

        public void setSource(int i2) {
            this.source = i2;
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getCredential() {
        return this.credential;
    }

    public Extend getExtend() {
        return this.extend;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getIdentityType() {
        return this.identityType;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCredential(String str) {
        this.credential = str;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setIdentityType(String str) {
        this.identityType = str;
    }
}
