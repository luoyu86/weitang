package com.chinavisionary.microtang.pre.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PreOrderDetailsVo extends BaseVo {
    private String key;
    private String monthRent;
    private int payState;
    private String roomNo;
    private int roomState;
    private String stateName;

    public String getKey() {
        return this.key;
    }

    public String getMonthRent() {
        return this.monthRent;
    }

    public int getPayState() {
        return this.payState;
    }

    public String getRoomNo() {
        return this.roomNo;
    }

    public int getRoomState() {
        return this.roomState;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMonthRent(String str) {
        this.monthRent = str;
    }

    public void setPayState(int i2) {
        this.payState = i2;
    }

    public void setRoomNo(String str) {
        this.roomNo = str;
    }

    public void setRoomState(int i2) {
        this.roomState = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }
}
