package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class NewUpdateDeviceIdVo extends BaseVo {
    private static final int WT_APP = 1;
    private int deviceType = 1;
    private String deviceid;

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public void setDeviceType(int i2) {
        this.deviceType = i2;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
    }
}
