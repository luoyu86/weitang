package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PayCouponParamBo extends BaseVo {
    private String couponId;
    private String type;

    public String getCouponId() {
        return this.couponId;
    }

    public String getType() {
        return this.type;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
