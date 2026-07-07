package com.chinavisionary.framework.mobile.common.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseContentVo extends BaseVo {
    private String code;
    private String message;
    private boolean success;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
