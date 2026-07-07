package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class QueryContactClauseVo extends BaseVo {
    private String assetKey;
    private String beginDate;
    private int payMethod;
    private int rentTerm;

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getBeginDate() {
        return this.beginDate;
    }

    public int getPayMethod() {
        return this.payMethod;
    }

    public int getRentTerm() {
        return this.rentTerm;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setBeginDate(String str) {
        this.beginDate = str;
    }

    public void setPayMethod(int i2) {
        this.payMethod = i2;
    }

    public void setRentTerm(int i2) {
        this.rentTerm = i2;
    }
}
