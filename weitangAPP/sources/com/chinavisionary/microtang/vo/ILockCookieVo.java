package com.chinavisionary.microtang.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ILockCookieVo extends BaseVo {
    private String SuperDataSecret;
    private String SuperUserKey;

    public String getSuperDataSecret() {
        return this.SuperDataSecret;
    }

    public String getSuperUserKey() {
        return this.SuperUserKey;
    }

    public void setSuperDataSecret(String str) {
        this.SuperDataSecret = str;
    }

    public void setSuperUserKey(String str) {
        this.SuperUserKey = str;
    }
}
