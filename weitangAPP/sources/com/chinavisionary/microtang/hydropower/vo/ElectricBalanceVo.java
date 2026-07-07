package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ElectricBalanceVo extends BaseVo {
    private String electricity;
    private Long updateTime;

    public String getElectricity() {
        return this.electricity;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public void setElectricity(String str) {
        this.electricity = str;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }
}
