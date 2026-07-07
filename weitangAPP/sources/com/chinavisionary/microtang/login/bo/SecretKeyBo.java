package com.chinavisionary.microtang.login.bo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class SecretKeyBo extends NewBaseVo {
    private String key;
    private String publicSecurityCode;
    private String token;

    public String getKey() {
        return this.key;
    }

    public String getPublicSecurityCode() {
        return this.publicSecurityCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPublicSecurityCode(String str) {
        this.publicSecurityCode = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
