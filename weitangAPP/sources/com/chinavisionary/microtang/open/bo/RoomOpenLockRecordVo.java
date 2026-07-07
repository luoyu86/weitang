package com.chinavisionary.microtang.open.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordVo extends BaseVo {
    private long createTime;
    private String deviceid;
    private String location;
    private String rentHouseKey;
    private String supplierName;

    public long getCreateTime() {
        return this.createTime;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public String getLocation() {
        return this.location;
    }

    public String getRentHouseKey() {
        return this.rentHouseKey;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setRentHouseKey(String str) {
        this.rentHouseKey = str;
    }

    public void setSupplierName(String str) {
        this.supplierName = str;
    }
}
