package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class IDTypeNameValueVo extends BaseVo {
    private boolean defaultFlag;
    private String idBackName;
    private String idFaceName;
    private String name;
    private int value;

    public String getIdBackName() {
        return this.idBackName;
    }

    public String getIdFaceName() {
        return this.idFaceName;
    }

    public String getName() {
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

    public void setIdBackName(String str) {
        this.idBackName = str;
    }

    public void setIdFaceName(String str) {
        this.idFaceName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(int i2) {
        this.value = i2;
    }
}
