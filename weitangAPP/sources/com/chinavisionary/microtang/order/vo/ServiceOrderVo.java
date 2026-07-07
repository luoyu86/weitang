package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ServiceOrderVo extends BaseVo {
    public static final int ORDER_CLEAN = 2;
    public static final int ORDER_REPAIR = 1;
    public static final int STATUS_ACCEPTED = 3;
    public static final int STATUS_CANCEL = 2;
    public static final int STATUS_ORDER = 1;
    public static final int STATUS_OVER = 5;
    public static final int STATUS_WAIT_COMMENT = 4;
    private String address;
    private int businessOrderType;
    private boolean canCancel;
    private String content;
    private Long fromTime;
    private String orderKey;
    private int status;
    private String statusName;
    private Long toTime;

    public String getAddress() {
        return this.address;
    }

    public int getBusinessOrderType() {
        return this.businessOrderType;
    }

    public boolean getCanCancel() {
        return this.canCancel;
    }

    public String getContent() {
        return this.content;
    }

    public Long getFromTime() {
        return this.fromTime;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public Long getToTime() {
        return this.toTime;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBusinessOrderType(int i2) {
        this.businessOrderType = i2;
    }

    public void setCanCancel(boolean z) {
        this.canCancel = z;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFromTime(Long l) {
        this.fromTime = l;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }

    public void setToTime(Long l) {
        this.toTime = l;
    }
}
