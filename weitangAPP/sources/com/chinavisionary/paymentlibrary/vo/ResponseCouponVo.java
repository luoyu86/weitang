package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseCouponVo extends NewBaseVo {
    private List<PayCouponVo> optionalList;
    private List<PayCouponVo> unOptionalList;

    public List<PayCouponVo> getOptionalList() {
        return this.optionalList;
    }

    public List<PayCouponVo> getUnOptionalList() {
        return this.unOptionalList;
    }

    public void setOptionalList(List<PayCouponVo> list) {
        this.optionalList = list;
    }

    public void setUnOptionalList(List<PayCouponVo> list) {
        this.unOptionalList = list;
    }
}
