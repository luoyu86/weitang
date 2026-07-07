package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CreateRoomPreLookVo extends BaseVo {
    private Long appointmentTime;
    private String customerName;
    private String key;
    private String phone;
    private String remark;

    public Long getAppointmentTime() {
        return this.appointmentTime;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getKey() {
        return this.key;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setAppointmentTime(Long l) {
        this.appointmentTime = l;
    }

    public void setCustomerName(String str) {
        this.customerName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }
}
