package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestUpdateBuyCartBo extends BaseVo {
    private String cartKey;
    private int quantity;

    public String getCartKey() {
        return this.cartKey;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setCartKey(String str) {
        this.cartKey = str;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }
}
