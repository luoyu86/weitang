package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CreateFoodPayResultVo extends BaseVo {
    private String canteenOrderKey;
    private String paySign;
    private String paymentKey;

    public String getCanteenOrderKey() {
        return this.canteenOrderKey;
    }

    public String getPaySign() {
        return this.paySign;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public void setCanteenOrderKey(String str) {
        this.canteenOrderKey = str;
    }

    public void setPaySign(String str) {
        this.paySign = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }
}
