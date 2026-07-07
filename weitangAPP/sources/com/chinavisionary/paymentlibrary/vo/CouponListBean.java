package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CouponListBean extends BaseVo {
    private String couponId;
    private String couponName;

    public String getCouponId() {
        return this.couponId;
    }

    public String getCouponName() {
        return this.couponName;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public void setCouponName(String str) {
        this.couponName = str;
    }
}
