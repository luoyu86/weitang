package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CouponMutexVo extends BaseVo {
    private boolean isMutex;
    private PayCouponVo selectCouponVo;

    public PayCouponVo getSelectCouponVo() {
        return this.selectCouponVo;
    }

    public boolean isMutex() {
        return this.isMutex;
    }

    public void setMutex(boolean z) {
        this.isMutex = z;
    }

    public void setSelectCouponVo(PayCouponVo payCouponVo) {
        this.selectCouponVo = payCouponVo;
    }
}
