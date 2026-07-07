package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class WaterElectricReadBalanceVo extends BaseVo {
    private Double electricity;
    private String electricityName;
    private Double gasWaterBalance;
    private String gasWaterName;
    private Double hotWaterBalance;
    private String hotWaterName;
    private Double waterBalance;
    private String waterName;

    public Double getElectricity() {
        return this.electricity;
    }

    public String getElectricityName() {
        return this.electricityName;
    }

    public Double getGasWaterBalance() {
        return this.gasWaterBalance;
    }

    public String getGasWaterName() {
        return this.gasWaterName;
    }

    public Double getHotWaterBalance() {
        return this.hotWaterBalance;
    }

    public String getHotWaterName() {
        return this.hotWaterName;
    }

    public Double getWaterBalance() {
        return this.waterBalance;
    }

    public String getWaterName() {
        return this.waterName;
    }

    public void setElectricity(Double d2) {
        this.electricity = d2;
    }

    public void setElectricityName(String str) {
        this.electricityName = str;
    }

    public void setGasWaterBalance(Double d2) {
        this.gasWaterBalance = d2;
    }

    public void setGasWaterName(String str) {
        this.gasWaterName = str;
    }

    public void setHotWaterBalance(Double d2) {
        this.hotWaterBalance = d2;
    }

    public void setHotWaterName(String str) {
        this.hotWaterName = str;
    }

    public void setWaterBalance(Double d2) {
        this.waterBalance = d2;
    }

    public void setWaterName(String str) {
        this.waterName = str;
    }
}
