package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CreateIncrementOrderParamBo extends BaseVo {
    private String commodityId;
    private Object extraParam;
    private int payChannel;
    private String remark;
    private String spaceId;

    public String getCommodityId() {
        return this.commodityId;
    }

    public Object getExtraParam() {
        return this.extraParam;
    }

    public int getPayChannel() {
        return this.payChannel;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setCommodityId(String str) {
        this.commodityId = str;
    }

    public void setExtraParam(Object obj) {
        this.extraParam = obj;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
