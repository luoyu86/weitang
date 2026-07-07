package com.chinavisionary.microtang.open.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordDetailsVo extends BaseVo {
    private String appName;
    private String appVersion;
    private String errorLog;
    private String name;
    private String openDoorResult;
    private long openDoorTime;
    private String phone;
    private String phoneSystemVersion;
    private String phoneType;
    private String remark;
    private int useTime;

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getErrorLog() {
        return this.errorLog;
    }

    public String getName() {
        return this.name;
    }

    public String getOpenDoorResult() {
        return this.openDoorResult;
    }

    public long getOpenDoorTime() {
        return this.openDoorTime;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneSystemVersion() {
        return this.phoneSystemVersion;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getUseTime() {
        return this.useTime;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setErrorLog(String str) {
        this.errorLog = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpenDoorResult(String str) {
        this.openDoorResult = str;
    }

    public void setOpenDoorTime(long j) {
        this.openDoorTime = j;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPhoneSystemVersion(String str) {
        this.phoneSystemVersion = str;
    }

    public void setPhoneType(String str) {
        this.phoneType = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUseTime(int i2) {
        this.useTime = i2;
    }
}
