package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerHotReasonVo extends BaseVo {
    private String content;
    private boolean isOpen;
    private String title;
    private int type;

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
