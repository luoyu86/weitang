package com.chinavisionary.microtang.msg.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestReadBadgeBo extends BaseVo {
    private String messageKey;
    private boolean readAll;

    public String getMessageKey() {
        return this.messageKey;
    }

    public boolean isReadAll() {
        return this.readAll;
    }

    public void setMessageKey(String str) {
        this.messageKey = str;
    }

    public void setReadAll(boolean z) {
        this.readAll = z;
    }
}
