package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class WXminiiPorgramePayRequestParamVo extends BaseVo {
    private String payId;
    private String token;

    public String getPayId() {
        return this.payId;
    }

    public String getToken() {
        return this.token;
    }

    public void setPayId(String str) {
        this.payId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
