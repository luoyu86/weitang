package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class RoomOtherFeeUnitVo extends BaseVo {
    private String address;
    private String assetKey;
    private BigDecimal electricityPrice;
    private String key;
    private String message;
    private boolean success;
    private BigDecimal waterPrice;

    public String getAddress() {
        return this.address;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public BigDecimal getElectricityPrice() {
        return this.electricityPrice;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public BigDecimal getWaterPrice() {
        return this.waterPrice;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setElectricityPrice(BigDecimal bigDecimal) {
        this.electricityPrice = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setWaterPrice(BigDecimal bigDecimal) {
        this.waterPrice = bigDecimal;
    }
}
