package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RequestPayStateParamBo extends BaseVo {
    private String orderId;
    private String payId;
    private String paymentId;

    public String getOrderId() {
        return this.orderId;
    }

    public String getPayId() {
        return this.payId;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPayId(String str) {
        this.payId = str;
    }

    public void setPaymentId(String str) {
        this.paymentId = str;
    }
}
