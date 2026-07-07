package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ExpressVo extends BaseVo {
    public static final int EXPRESS = 3;
    public static final int EXPRESS_SELF_RAISING = 2;
    public static final int EXPRESS_TAKEOUT = 1;
    private String address;
    private String addressKey;
    private boolean isSelect;
    private String personName;
    private String phone;

    public String getAddress() {
        return this.address;
    }

    public String getAddressKey() {
        return this.addressKey;
    }

    public String getPersonName() {
        return this.personName;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAddressKey(String str) {
        this.addressKey = str;
    }

    public void setPersonName(String str) {
        this.personName = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
