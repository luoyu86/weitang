package com.chinavisionary.microtang.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class StateVo extends BaseVo {
    private boolean isOver;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public boolean isOver() {
        return this.isOver;
    }

    public void setOver(boolean z) {
        this.isOver = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
