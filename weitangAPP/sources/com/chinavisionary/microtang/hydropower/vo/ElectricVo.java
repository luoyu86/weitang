package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ElectricVo extends BaseVo {
    private boolean defaultFlag;
    private String name;
    private int type;
    private String value;

    public boolean getDefaultFlag() {
        return this.defaultFlag;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setDefaultFlag(boolean z) {
        this.defaultFlag = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
