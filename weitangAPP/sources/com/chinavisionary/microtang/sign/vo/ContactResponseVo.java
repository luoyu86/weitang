package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ContactResponseVo extends BaseVo {
    private Boolean hasUnpaidContract;
    private String termsText;

    public Boolean getHasUnpaidContract() {
        return this.hasUnpaidContract;
    }

    public String getTermsText() {
        return this.termsText;
    }

    public void setHasUnpaidContract(Boolean bool) {
        this.hasUnpaidContract = bool;
    }

    public void setTermsText(String str) {
        this.termsText = str;
    }
}
