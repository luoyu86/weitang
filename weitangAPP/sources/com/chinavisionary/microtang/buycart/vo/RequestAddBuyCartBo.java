package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestAddBuyCartBo extends BaseVo {
    private int cartType;
    private String commoditySpecificationKey;
    private int quantity;

    public int getCartType() {
        return this.cartType;
    }

    public String getCommoditySpecificationKey() {
        return this.commoditySpecificationKey;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setCartType(int i2) {
        this.cartType = i2;
    }

    public void setCommoditySpecificationKey(String str) {
        this.commoditySpecificationKey = str;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }
}
