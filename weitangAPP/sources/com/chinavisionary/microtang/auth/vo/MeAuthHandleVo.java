package com.chinavisionary.microtang.auth.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthHandleVo extends BaseVo {
    private String authDoorKey;
    private String reason;
    private boolean result;

    public String getAuthDoorKey() {
        return this.authDoorKey;
    }

    public String getReason() {
        return this.reason;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setAuthDoorKey(String str) {
        this.authDoorKey = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
