package com.chinavisionary.microtang.map.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class MapItemVo extends BaseVo {
    public static final int BD_TYPE = 2;
    public static final int CANCEL_TYPE = 3;
    public static final int GD_TYPE = 1;
    private String name;
    private int type;

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
