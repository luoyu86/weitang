package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseWaterElectricVo extends BaseVo {
    private String assetKey;
    private String contractCode;
    private String contractKey;
    private Long electricityLoadTime;
    private Long waterLoadTime;
    private double electricityBalance = 0.0d;
    private double waterBalance = 0.0d;

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public double getElectricityBalance() {
        return this.electricityBalance;
    }

    public Long getElectricityLoadTime() {
        return this.electricityLoadTime;
    }

    public double getWaterBalance() {
        return this.waterBalance;
    }

    public Long getWaterLoadTime() {
        return this.waterLoadTime;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setElectricityBalance(double d2) {
        this.electricityBalance = d2;
    }

    public void setElectricityLoadTime(Long l) {
        this.electricityLoadTime = l;
    }

    public void setWaterBalance(double d2) {
        this.waterBalance = d2;
    }

    public void setWaterLoadTime(Long l) {
        this.waterLoadTime = l;
    }
}
