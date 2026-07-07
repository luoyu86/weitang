package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairHistoryVo extends BaseVo {
    public static final int OVER = 2;
    public static final int PROGRESS = 1;
    private long createTime;
    private String key;
    private String maintainItemName;
    private String orderCode;
    private int state;
    private String stateName;
    private int type;
    private String typeName;

    public long getCreateTime() {
        return this.createTime;
    }

    public String getKey() {
        return this.key;
    }

    public String getMaintainItemName() {
        return this.maintainItemName;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public int getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaintainItemName(String str) {
        this.maintainItemName = str;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
