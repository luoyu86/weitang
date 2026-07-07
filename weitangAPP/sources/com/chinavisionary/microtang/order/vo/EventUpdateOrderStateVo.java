package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventUpdateOrderStateVo extends BaseVo {
    private int oldOrderState;
    private int orderState;

    public int getOldOrderState() {
        return this.oldOrderState;
    }

    public int getOrderState() {
        return this.orderState;
    }

    public void setOldOrderState(int i2) {
        this.oldOrderState = i2;
    }

    public void setOrderState(int i2) {
        this.orderState = i2;
    }
}
