package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class WaterBalanceVo extends BaseVo {
    private Long updateTime;
    private String waterVolume;

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public String getWaterVolume() {
        return this.waterVolume;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    public void setWaterVolume(String str) {
        this.waterVolume = str;
    }
}
