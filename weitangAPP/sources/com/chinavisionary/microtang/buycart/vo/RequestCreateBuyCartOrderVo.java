package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestCreateBuyCartOrderVo extends BaseVo {
    private List<CreateOrderSpecVo> items;

    public List<CreateOrderSpecVo> getItems() {
        return this.items;
    }

    public void setItems(List<CreateOrderSpecVo> list) {
        this.items = list;
    }
}
