package com.chinavisionary.microtang.web.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class EventUpdateOpenLockVo extends BaseVo {
    private boolean isSuccess;
    private String msg;

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
