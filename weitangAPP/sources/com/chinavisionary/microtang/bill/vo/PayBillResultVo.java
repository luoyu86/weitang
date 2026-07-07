package com.chinavisionary.microtang.bill.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class PayBillResultVo extends BaseVo {
    private String billKey;
    private String key;
    private String message;
    private String paySign;
    private String paymentKey;
    private boolean success;

    public String getBillKey() {
        return this.billKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPaySign() {
        return this.paySign;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBillKey(String str) {
        this.billKey = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPaySign(String str) {
        this.paySign = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
