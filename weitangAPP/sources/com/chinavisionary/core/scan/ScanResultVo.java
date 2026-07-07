package com.chinavisionary.core.scan;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ScanResultVo extends BaseVo {
    private String key;
    private int type;

    public String getKey() {
        return this.key;
    }

    public int getType() {
        return this.type;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
