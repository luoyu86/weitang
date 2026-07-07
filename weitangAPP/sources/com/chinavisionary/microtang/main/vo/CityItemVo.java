package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CityItemVo extends BaseVo {
    private String cityName;
    private boolean isSelect;
    private String key;

    public String getCityName() {
        return this.cityName;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
