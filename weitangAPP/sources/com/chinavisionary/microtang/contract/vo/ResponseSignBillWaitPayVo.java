package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseSignBillWaitPayVo extends BaseVo {
    private String contractCode;
    private String contractKey;
    private String rentTerm;
    private int unPayBillNumber;

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public String getRentTerm() {
        return this.rentTerm;
    }

    public int getUnPayBillNumber() {
        return this.unPayBillNumber;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setRentTerm(String str) {
        this.rentTerm = str;
    }

    public void setUnPayBillNumber(int i2) {
        this.unPayBillNumber = i2;
    }
}
