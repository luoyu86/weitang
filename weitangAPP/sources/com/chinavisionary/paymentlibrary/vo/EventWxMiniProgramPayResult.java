package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class EventWxMiniProgramPayResult extends BaseVo {
    private boolean isPaySuccess;
    private String msg;

    public boolean getIsPaySuccess() {
        return this.isPaySuccess;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setIsPaySuccess(boolean z) {
        this.isPaySuccess = z;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
