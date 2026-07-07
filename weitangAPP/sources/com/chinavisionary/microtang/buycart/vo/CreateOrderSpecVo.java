package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CreateOrderSpecVo extends BaseVo {
    private String commoditySpecificationKey;
    private int quantity;

    public String getCommoditySpecificationKey() {
        return this.commoditySpecificationKey;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setCommoditySpecificationKey(String str) {
        this.commoditySpecificationKey = str;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }
}
