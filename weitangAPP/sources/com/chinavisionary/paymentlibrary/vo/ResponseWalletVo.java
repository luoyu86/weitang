package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseWalletVo extends NewBaseVo {
    private BigDecimal balance;
    private String key;
    private boolean rechargeable;

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isRechargeable() {
        return this.rechargeable;
    }

    public void setBalance(BigDecimal bigDecimal) {
        this.balance = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRechargeable(boolean z) {
        this.rechargeable = z;
    }
}
