package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CancelContractParamBo extends BaseVo {
    public static final int CANCEL = 2;
    public static final int CONFIRM = 1;
    private Integer cancelStatus;
    private String messageKey;

    public Integer getCancelStatus() {
        return this.cancelStatus;
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    public void setCancelStatus(Integer num) {
        this.cancelStatus = num;
    }

    public void setMessageKey(String str) {
        this.messageKey = str;
    }
}
