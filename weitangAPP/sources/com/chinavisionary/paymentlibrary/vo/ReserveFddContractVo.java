package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveFddContractVo extends NewBaseVo {
    private String key;
    private String notifyUrl;
    private String reserveSignUrl;

    public String getKey() {
        return this.key;
    }

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public String getReserveSignUrl() {
        return this.reserveSignUrl;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setNotifyUrl(String str) {
        this.notifyUrl = str;
    }

    public void setReserveSignUrl(String str) {
        this.reserveSignUrl = str;
    }
}
