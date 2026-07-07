package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CreatePayOrderBo extends BaseVo {
    private String orderKey;
    private int payPlatformType;

    public String getOrderKey() {
        return this.orderKey;
    }

    public int getPayPlatformType() {
        return this.payPlatformType;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setPayPlatformType(int i2) {
        this.payPlatformType = i2;
    }
}
