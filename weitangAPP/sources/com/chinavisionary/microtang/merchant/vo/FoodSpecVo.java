package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class FoodSpecVo extends BaseVo {
    private int buyNumber;
    private int maxLimit;
    private String name;
    private BigDecimal price;

    public int getBuyNumber() {
        return this.buyNumber;
    }

    public int getMaxLimit() {
        return this.maxLimit;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setBuyNumber(int i2) {
        this.buyNumber = i2;
    }

    public void setMaxLimit(int i2) {
        this.maxLimit = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }
}
