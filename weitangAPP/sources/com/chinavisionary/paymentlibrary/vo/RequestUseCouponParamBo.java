package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RequestUseCouponParamBo extends BaseVo {
    private List<String> couponIds;
    private String orderId;

    public List<String> getCouponIds() {
        return this.couponIds;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setCouponIds(List<String> list) {
        this.couponIds = list;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
