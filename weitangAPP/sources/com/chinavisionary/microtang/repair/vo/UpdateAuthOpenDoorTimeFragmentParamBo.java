package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAuthOpenDoorTimeFragmentParamBo extends BaseVo {
    private boolean auth;
    private Long endServiceTime;
    private Long endTime;
    private String orderKey;
    private Long startServiceTime;
    private Long startTime;
    private int type;
    private String workOrderKey;

    public Long getEndServiceTime() {
        return this.endServiceTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public Long getStartServiceTime() {
        return this.startServiceTime;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public int getType() {
        return this.type;
    }

    public String getWorkOrderKey() {
        return this.workOrderKey;
    }

    public boolean isAuth() {
        return this.auth;
    }

    public void setAuth(boolean z) {
        this.auth = z;
    }

    public void setEndServiceTime(Long l) {
        this.endServiceTime = l;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setStartServiceTime(Long l) {
        this.startServiceTime = l;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setWorkOrderKey(String str) {
        this.workOrderKey = str;
    }
}
