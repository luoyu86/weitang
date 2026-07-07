package com.chinavisionary.paymentlibrary.vo;

import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class H5CreatePayBillBo extends BaseVo {
    private List<PayCouponParamBo> couponList;
    private String orderId;
    private String payMode;
    private Integer payType;

    public List<PayCouponParamBo> getCouponList() {
        return this.couponList;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPayMode() {
        return this.payMode;
    }

    public Integer getPayType() {
        return this.payType;
    }

    public void setCouponList(List<PayCouponParamBo> list) {
        if (!o.isNotEmpty(list)) {
            this.couponList = list;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PayCouponParamBo payCouponParamBo : list) {
            PayCouponParamBo payCouponParamBo2 = new PayCouponParamBo();
            payCouponParamBo2.setType("1");
            payCouponParamBo2.setCouponId(payCouponParamBo.getCouponId());
            arrayList.add(payCouponParamBo2);
        }
        this.couponList = arrayList;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPayMode(String str) {
        this.payMode = str;
    }

    public void setPayType(Integer num) {
        this.payType = num;
        setPayMode(ResponsePayModeBo.getPayTypeToMode(num.intValue()));
    }
}
