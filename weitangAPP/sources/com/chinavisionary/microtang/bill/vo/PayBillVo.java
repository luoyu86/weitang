package com.chinavisionary.microtang.bill.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class PayBillVo extends BaseVo {
    private int payChannel;
    private String paymentKey;

    public int getPayChannel() {
        return this.payChannel;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }
}
