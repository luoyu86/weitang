package com.chinavisionary.paymentlibrary.vo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseFddSignUrlVo extends NewBaseVo {
    private String contractSignUrl;
    private String key;
    private String notifyUrl;
    private String signUrl;

    public String getContractSignUrl() {
        return x.isNotNull(this.signUrl) ? this.signUrl : this.contractSignUrl;
    }

    public String getKey() {
        return this.key;
    }

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public String getSignUrl() {
        return this.signUrl;
    }

    public void setContractSignUrl(String str) {
        this.contractSignUrl = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setNotifyUrl(String str) {
        this.notifyUrl = str;
    }

    public void setSignUrl(String str) {
        this.signUrl = str;
    }
}
