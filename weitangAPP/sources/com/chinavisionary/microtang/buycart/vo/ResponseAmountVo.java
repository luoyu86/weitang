package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class ResponseAmountVo extends BaseVo {
    private BigDecimal amount;
    private BigDecimal discountAmount;
    private BigDecimal payAmount;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }

    public BigDecimal getPayAmount() {
        return this.payAmount;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setDiscountAmount(BigDecimal bigDecimal) {
        this.discountAmount = bigDecimal;
    }

    public void setPayAmount(BigDecimal bigDecimal) {
        this.payAmount = bigDecimal;
    }
}
