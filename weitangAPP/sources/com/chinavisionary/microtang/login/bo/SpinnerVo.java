package com.chinavisionary.microtang.login.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class SpinnerVo extends BaseVo {
    private int eveValue;
    private String key;
    private boolean select;
    private String value;

    public int getEveValue() {
        return this.eveValue;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isSelect() {
        return this.select;
    }

    public void setEveValue(int i2) {
        this.eveValue = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSelect(boolean z) {
        this.select = z;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
