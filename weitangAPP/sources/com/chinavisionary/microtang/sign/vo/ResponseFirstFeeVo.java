package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseFirstFeeVo extends BaseVo {
    private BigDecimal amount;
    private String billKey;
    private String contractKey;
    private Long expireTime;
    private String key;
    private String message;
    private String paymentKey;
    private boolean success;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getBillKey() {
        return this.billKey;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setBillKey(String str) {
        this.billKey = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setExpireTime(Long l) {
        this.expireTime = l;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
