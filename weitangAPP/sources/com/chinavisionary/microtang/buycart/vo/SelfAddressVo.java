package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class SelfAddressVo extends BaseVo {
    private String address;
    private boolean isAgreeProtocol;
    private String phone;
    private long startTime;

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isAgreeProtocol() {
        return this.isAgreeProtocol;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAgreeProtocol(boolean z) {
        this.isAgreeProtocol = z;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }
}
