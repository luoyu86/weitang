package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePwdToPhoneCode extends BaseVo {
    private String code;
    private String newPassword;

    public String getCode() {
        return this.code;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setNewPassword(String str) {
        this.newPassword = str;
    }
}
