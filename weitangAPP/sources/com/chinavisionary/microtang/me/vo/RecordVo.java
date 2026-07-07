package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RecordVo extends BaseVo {
    private float currentMeterReading;
    private Long currentMeterReadingTime;
    private int deviceType;
    private String deviceTypeName;
    private String livingExpensesKey;

    public float getCurrentMeterReading() {
        return this.currentMeterReading;
    }

    public Long getCurrentMeterReadingTime() {
        return this.currentMeterReadingTime;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getDeviceTypeName() {
        return this.deviceTypeName;
    }

    public String getLivingExpensesKey() {
        return this.livingExpensesKey;
    }

    public void setCurrentMeterReading(float f2) {
        this.currentMeterReading = f2;
    }

    public void setCurrentMeterReadingTime(Long l) {
        this.currentMeterReadingTime = l;
    }

    public void setDeviceType(int i2) {
        this.deviceType = i2;
    }

    public void setDeviceTypeName(String str) {
        this.deviceTypeName = str;
    }

    public void setLivingExpensesKey(String str) {
        this.livingExpensesKey = str;
    }
}
