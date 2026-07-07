package com.chinavisionary.microtang.pre.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveFddContractVo extends BaseVo {
    private String key;
    private String message;
    private String notifyUrl;
    private String reserveSignUrl;
    private boolean success;

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public String getReserveSignUrl() {
        return this.reserveSignUrl;
    }

    public boolean isSuccess() {
        return this.success;
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

    public void setReserveSignUrl(String str) {
        this.reserveSignUrl = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
