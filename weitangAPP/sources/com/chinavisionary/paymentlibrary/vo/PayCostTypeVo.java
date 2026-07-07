package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class PayCostTypeVo extends BaseVo {
    private BigDecimal couponValue;
    private String desc;
    private String name;
    private String type;
    private BigDecimal value;

    public BigDecimal getCouponValue() {
        return this.couponValue;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setCouponValue(BigDecimal bigDecimal) {
        this.couponValue = bigDecimal;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(BigDecimal bigDecimal) {
        this.value = bigDecimal;
    }
}
