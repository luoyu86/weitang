package com.chinavisionary.microtang.prelook.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class TagVo extends BaseVo {
    private String content;
    private boolean isCheck;
    private String key;

    public String getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
