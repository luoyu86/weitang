package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class GetFddContactBo extends BaseVo {
    private String contractKey;
    private String rentKey;

    public String getContractKey() {
        return this.contractKey;
    }

    public String getRentKey() {
        return this.rentKey;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setRentKey(String str) {
        this.rentKey = str;
    }
}
