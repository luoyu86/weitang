package com.chinavisionary.microtang.life.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestGetCouponGoodsParam extends BaseVo {
    private String couponTemplateKey;
    private String name;

    public String getCouponTemplateKey() {
        return this.couponTemplateKey;
    }

    public String getName() {
        return this.name;
    }

    public void setCouponTemplateKey(String str) {
        this.couponTemplateKey = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
