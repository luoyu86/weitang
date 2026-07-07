package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestClickStatisticBo extends BaseVo {
    public static final String TYPE_CLICK_FUND = "fund";
    private String position = "convenient";
    private String type;

    public String getPosition() {
        return this.position;
    }

    public String getType() {
        return this.type;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
