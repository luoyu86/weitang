package com.chinavisionary.microtang.prelook.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookVo extends BaseVo {
    public static final int CANCEL_TYPE = 2;
    public static final int COMMENT_TYPE = 1;
    private String address;
    private String appintmentKey;
    private Long appointmentTime;
    private int duringType;
    private String duringTypeDesc;
    private int status;

    public String getAddress() {
        return this.address;
    }

    public String getAppintmentKey() {
        return this.appintmentKey;
    }

    public Long getAppointmentTime() {
        return this.appointmentTime;
    }

    public int getDuringType() {
        return this.duringType;
    }

    public String getDuringTypeDesc() {
        return this.duringTypeDesc;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAppintmentKey(String str) {
        this.appintmentKey = str;
    }

    public void setAppointmentTime(Long l) {
        this.appointmentTime = l;
    }

    public void setDuringType(int i2) {
        this.duringType = i2;
    }

    public void setDuringTypeDesc(String str) {
        this.duringTypeDesc = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
