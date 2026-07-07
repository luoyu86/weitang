package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RecordTabVo extends BaseVo {
    private int deviceType;
    private String deviceTypeName;
    private String key;
    private String unitName;

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getDeviceTypeName() {
        return this.deviceTypeName;
    }

    public String getKey() {
        return this.key;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public void setDeviceType(int i2) {
        this.deviceType = i2;
    }

    public void setDeviceTypeName(String str) {
        this.deviceTypeName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUnitName(String str) {
        this.unitName = str;
    }
}
