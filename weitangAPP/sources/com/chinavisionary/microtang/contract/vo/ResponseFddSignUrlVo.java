package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseFddSignUrlVo extends BaseVo {
    private String contractSignUrl;
    private String key;
    private String message;
    private String notifyUrl;
    private boolean success;

    public String getContractSignUrl() {
        return this.contractSignUrl;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setContractSignUrl(String str) {
        this.contractSignUrl = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNotifyUrl(String str) {
        this.notifyUrl = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
