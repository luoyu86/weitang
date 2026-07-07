package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class NewResponseRollOutVo extends NewBaseVo {
    private String key;
    private String withdrawId;
    private BigDecimal withdrawalAmount;

    public String getKey() {
        String str = this.withdrawId;
        return str != null ? str : this.key;
    }

    public String getWithdrawId() {
        return this.withdrawId;
    }

    public BigDecimal getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setWithdrawId(String str) {
        this.withdrawId = str;
    }

    public void setWithdrawalAmount(BigDecimal bigDecimal) {
        this.withdrawalAmount = bigDecimal;
    }
}
