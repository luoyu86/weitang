package com.chinavisionary.microtang.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RequestUserInfoVo extends BaseVo {
    private Integer messageType;
    private int source = 1;

    public Integer getMessageType() {
        return this.messageType;
    }

    public int getSource() {
        return this.source;
    }

    public void setMessageType(Integer num) {
        this.messageType = num;
    }

    public void setSource(int i2) {
        this.source = i2;
    }
}
