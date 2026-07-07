package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartCountVo extends BaseVo {
    private int buyCount;
    private BigDecimal buyCountPrice;

    public int getBuyCount() {
        return this.buyCount;
    }

    public BigDecimal getBuyCountPrice() {
        return this.buyCountPrice;
    }

    public void setBuyCount(int i2) {
        this.buyCount = i2;
    }

    public void setBuyCountPrice(BigDecimal bigDecimal) {
        this.buyCountPrice = bigDecimal;
    }
}
