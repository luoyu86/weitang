package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class RechargeWaterEleVo extends BaseVo {
    private BigDecimal amount;
    private String assetKey;
    private int payChannel;
    private Float quantity;
    private Integer rechangeType;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public int getPayChannel() {
        return this.payChannel;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public Integer getRechangeType() {
        return this.rechangeType;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setQuantity(Float f2) {
        this.quantity = f2;
    }

    public void setRechangeType(Integer num) {
        this.rechangeType = num;
    }
}
