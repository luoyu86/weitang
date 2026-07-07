package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestFundNewsParamBo extends BaseVo {
    private int pnumber;
    private int ppage;
    private String type = "fund";

    public int getPnumber() {
        return this.pnumber;
    }

    public int getPpage() {
        return this.ppage;
    }

    public String getType() {
        return this.type;
    }

    public void setPnumber(int i2) {
        this.pnumber = i2;
    }

    public void setPpage(int i2) {
        this.ppage = i2;
    }

    public void setType(String str) {
        this.type = str;
    }
}
