package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAuthOpenDoorParamBo extends BaseVo {
    private Long endTime;
    private Long startTime;
    private int type;
    private String workOrderKey;

    public Long getEndTime() {
        return this.endTime;
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

    public void setEndTime(Long l) {
        this.endTime = l;
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
