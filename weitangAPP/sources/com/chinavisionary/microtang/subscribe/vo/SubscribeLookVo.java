package com.chinavisionary.microtang.subscribe.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class SubscribeLookVo extends BaseVo {
    public static final int CANCEL = 3;
    public static final int OVER = 2;
    public static final int PROGRESS = 1;
    private String address;
    private String key;
    private String orderNo;
    private Long reserveTime;
    private int state;
    private String stateName;

    public String getAddress() {
        return this.address;
    }

    public String getKey() {
        return this.key;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public Long getReserveTime() {
        return this.reserveTime;
    }

    public int getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setReserveTime(Long l) {
        this.reserveTime = l;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }
}
