package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class NewUpdatePwdToPhoneCode extends BaseVo {
    private String code;
    private Boolean flag = Boolean.FALSE;
    private String newConfirmPwd;
    private String newPwd;
    private String phone;

    public String getCode() {
        return this.code;
    }

    public Boolean getFlag() {
        return this.flag;
    }

    public String getNewConfirmPwd() {
        return this.newConfirmPwd;
    }

    public String getNewPwd() {
        return this.newPwd;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setFlag(Boolean bool) {
        this.flag = bool;
    }

    public void setNewConfirmPwd(String str) {
        this.newConfirmPwd = str;
    }

    public void setNewPwd(String str) {
        this.newPwd = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
