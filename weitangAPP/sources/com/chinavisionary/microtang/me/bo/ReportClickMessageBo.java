package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ReportClickMessageBo extends BaseVo {
    public static final boolean CLICK_LEFT_FLAG = false;
    public static final boolean CLICK_RIGHT_FLAG = true;
    public static final int CONFIRM_TYPE = 1;
    public static final int EXIT_RENT_CONFIRM_TYPE = 4;
    public static final int EXIT_RENT_MESSAGE_TYPE = 14;
    public static final int NOT_CONFIRM_TYPE = 2;
    public static final int THINK_TYPE = 0;
    private int continueRentFlag;
    private Boolean flag;
    private String primaryKey;

    public int getContinueRentFlag() {
        return this.continueRentFlag;
    }

    public Boolean getFlag() {
        return this.flag;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public void setContinueRentFlag(int i2) {
        this.continueRentFlag = i2;
    }

    public void setFlag(Boolean bool) {
        this.flag = bool;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }
}
