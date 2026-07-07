package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CreateCleanOrderVo extends BaseVo {
    private int payChannel;
    private String roomKey;
    private String valueaddedKey;

    public int getPayChannel() {
        return this.payChannel;
    }

    public String getRoomKey() {
        return this.roomKey;
    }

    public String getValueaddedKey() {
        return this.valueaddedKey;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setRoomKey(String str) {
        this.roomKey = str;
    }

    public void setValueaddedKey(String str) {
        this.valueaddedKey = str;
    }
}
