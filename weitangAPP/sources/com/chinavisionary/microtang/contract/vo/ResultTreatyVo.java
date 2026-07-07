package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResultTreatyVo extends BaseVo {
    private String content;
    private String key;
    private String message;
    private boolean success;

    public String getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
