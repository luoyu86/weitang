package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestDelBuyCartBo extends BaseVo {
    private List<String> cartKeys;

    public List<String> getCartKeys() {
        return this.cartKeys;
    }

    public void setCartKeys(List<String> list) {
        this.cartKeys = list;
    }
}
