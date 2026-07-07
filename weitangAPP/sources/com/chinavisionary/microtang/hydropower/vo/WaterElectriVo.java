package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class WaterElectriVo extends BaseVo {
    private String message;
    private String orderNo;
    private boolean success;

    public String getMessage() {
        return this.message;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
