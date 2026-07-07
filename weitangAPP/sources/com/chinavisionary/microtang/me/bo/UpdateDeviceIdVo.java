package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDeviceIdVo extends BaseVo {
    private static final int WT_APP = 1;
    private String deviceid;
    private int sourceType = 1;

    public String getDeviceid() {
        return this.deviceid;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
    }

    public void setSourceType(int i2) {
        this.sourceType = i2;
    }
}
