package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SelectCouponResultVo extends BaseVo {
    private List<PayCouponParamBo> couponList;
    private int couponTotal;
    private BigDecimal couponValueTotal;
    private List<PayCouponVo> userCouponList;

    public List<PayCouponParamBo> getCouponList() {
        return this.couponList;
    }

    public int getCouponTotal() {
        return this.couponTotal;
    }

    public BigDecimal getCouponValueTotal() {
        if (this.couponValueTotal == null) {
            this.couponValueTotal = new BigDecimal(0);
        }
        return this.couponValueTotal;
    }

    public List<PayCouponVo> getUserCouponList() {
        return this.userCouponList;
    }

    public void setCouponList(List<PayCouponParamBo> list) {
        this.couponList = list;
    }

    public void setCouponTotal(int i2) {
        this.couponTotal = i2;
    }

    public void setCouponValueTotal(BigDecimal bigDecimal) {
        this.couponValueTotal = bigDecimal;
    }

    public void setUserCouponList(List<PayCouponVo> list) {
        this.userCouponList = list;
    }
}
