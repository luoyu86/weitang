package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseDiscountVo extends NewBaseVo {
    private List<Object> coupons;
    private List<DiscountVo> discount;

    public List<Object> getCoupons() {
        return this.coupons;
    }

    public List<DiscountVo> getDiscount() {
        return this.discount;
    }

    public void setCoupons(List<Object> list) {
        this.coupons = list;
    }

    public void setDiscount(List<DiscountVo> list) {
        this.discount = list;
    }
}
