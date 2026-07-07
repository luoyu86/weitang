package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class ResponseRollOutVo extends BaseVo {
    private String key;
    private String message;
    private boolean success;
    private String withdrawId;
    private BigDecimal withdrawalAmount;

    public String getKey() {
        String str = this.withdrawId;
        return str != null ? str : this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getWithdrawId() {
        return this.withdrawId;
    }

    public BigDecimal getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setWithdrawId(String str) {
        this.withdrawId = str;
    }

    public void setWithdrawalAmount(BigDecimal bigDecimal) {
        this.withdrawalAmount = bigDecimal;
    }
}
