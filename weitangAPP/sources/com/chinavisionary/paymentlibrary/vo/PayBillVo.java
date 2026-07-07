package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PayBillVo extends BaseVo {
    private H5CreatePayBillBo createPayBillBo;
    private int payChannel;
    private String payMode;
    private String paymentKey;

    public H5CreatePayBillBo getCreatePayBillBo() {
        return this.createPayBillBo;
    }

    public int getPayChannel() {
        return this.payChannel;
    }

    public String getPayMode() {
        return this.payMode;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public void setCreatePayBillBo(H5CreatePayBillBo h5CreatePayBillBo) {
        this.createPayBillBo = h5CreatePayBillBo;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setPayMode(String str) {
        this.payMode = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }
}
