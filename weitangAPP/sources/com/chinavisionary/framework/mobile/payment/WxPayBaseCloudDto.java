package com.chinavisionary.framework.mobile.payment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class WxPayBaseCloudDto implements Serializable {
    private static final long serialVersionUID = -7521894723868692151L;
    private String nonceStr;
    private String partnerId;
    private String paySign;
    private String prepayId;
    private String sign;
    private Long timeStamp;
    private String wxPackage;

    public String getNonceStr() {
        return this.nonceStr;
    }

    public String getPartnerId() {
        return this.partnerId;
    }

    public String getPaySign() {
        return this.paySign;
    }

    public String getPrepayId() {
        return this.prepayId;
    }

    public String getSign() {
        return this.sign;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public String getWxPackage() {
        return this.wxPackage;
    }

    public void setNonceStr(String str) {
        this.nonceStr = str;
    }

    public void setPartnerId(String str) {
        this.partnerId = str;
    }

    public void setPaySign(String str) {
        this.paySign = str;
    }

    public void setPrepayId(String str) {
        this.prepayId = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimeStamp(Long l) {
        this.timeStamp = l;
    }

    public void setWxPackage(String str) {
        this.wxPackage = str;
    }
}
