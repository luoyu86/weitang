package com.chinavisionary.microtang.me.vo;

import c.f.b.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class NameValueVo extends BaseVo implements a {
    private boolean defaultFlag;
    private String name;
    private int value;

    public String getName() {
        return this.name;
    }

    @Override // c.f.b.a
    public String getPickerViewText() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isDefaultFlag() {
        return this.defaultFlag;
    }

    public void setDefaultFlag(boolean z) {
        this.defaultFlag = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(int i2) {
        this.value = i2;
    }
}
