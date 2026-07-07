package com.chinavisionary.microtang.order.vo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueVo extends BaseVo {
    private int feeType;
    private String feeTypeName;
    private String key;
    private BigDecimal price;
    private String value;

    public int getFeeType() {
        return this.feeType;
    }

    public String getFeeTypeName() {
        return this.feeTypeName;
    }

    public String getKey() {
        String str = this.key;
        return str == null ? this.feeTypeName : str;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getValue() {
        String str = this.value;
        return str == null ? x.bigDecimalToPlainString(this.price) : str;
    }

    public void setFeeType(int i2) {
        this.feeType = i2;
    }

    public void setFeeTypeName(String str) {
        this.feeTypeName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
