package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RequestCouponParamBo extends BaseVo {
    private List<String> applyTos;
    private String orderId;

    public List<String> getApplyTos() {
        return this.applyTos;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setApplyTos(List<String> list) {
        this.applyTos = list;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
