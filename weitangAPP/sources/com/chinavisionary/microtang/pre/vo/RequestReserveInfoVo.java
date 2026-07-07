package com.chinavisionary.microtang.pre.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RequestReserveInfoVo extends BaseVo {
    private String assetInstanceKey;
    private String cardNo;
    private int cardType;
    private String reserveUserName;

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public int getCardType() {
        return this.cardType;
    }

    public String getReserveUserName() {
        return this.reserveUserName;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setCardType(int i2) {
        this.cardType = i2;
    }

    public void setReserveUserName(String str) {
        this.reserveUserName = str;
    }
}
