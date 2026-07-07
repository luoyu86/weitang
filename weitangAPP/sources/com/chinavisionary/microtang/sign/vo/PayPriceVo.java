package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PayPriceVo extends BaseVo {
    private String goodsKey;
    private int paymentMethod;
    private int rentPeriod;

    public String getGoodsKey() {
        return this.goodsKey;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public int getRentPeriod() {
        return this.rentPeriod;
    }

    public void setGoodsKey(String str) {
        this.goodsKey = str;
    }

    public void setPaymentMethod(int i2) {
        this.paymentMethod = i2;
    }

    public void setRentPeriod(int i2) {
        this.rentPeriod = i2;
    }
}
