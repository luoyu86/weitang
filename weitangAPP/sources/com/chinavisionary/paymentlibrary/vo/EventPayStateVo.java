package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class EventPayStateVo extends BaseVo {
    private String billKey;
    private boolean hasRentFee;
    private boolean isSuccess;
    private String msg;

    public String getBillKey() {
        return this.billKey;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isHasRentFee() {
        return this.hasRentFee;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setBillKey(String str) {
        this.billKey = str;
    }

    public void setHasRentFee(boolean z) {
        this.hasRentFee = z;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
