package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class DiscountVo extends BaseVo {
    private BigDecimal amount;
    private String discountKey;
    private String name;
    private int type;
    private String typeName;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getDiscountKey() {
        return this.discountKey;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setDiscountKey(String str) {
        this.discountKey = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
