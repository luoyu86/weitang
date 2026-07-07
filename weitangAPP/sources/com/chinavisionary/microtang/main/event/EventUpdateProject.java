package com.chinavisionary.microtang.main.event;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventUpdateProject extends BaseVo {
    private String key;
    private String title;

    public String getKey() {
        return this.key;
    }

    public String getTitle() {
        return this.title;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
