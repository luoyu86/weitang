package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class NewCancelAccountBo extends BaseVo {
    private String code;
    private String phone;
    private String reason;
    private String reasonDesc;

    public String getCode() {
        return this.code;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getReason() {
        return this.reason;
    }

    public String getReasonDesc() {
        return this.reasonDesc;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonDesc(String str) {
        this.reasonDesc = str;
    }
}
