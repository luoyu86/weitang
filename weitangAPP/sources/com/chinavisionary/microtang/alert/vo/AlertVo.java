package com.chinavisionary.microtang.alert.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AlertVo extends BaseVo {
    private String content;
    private Object extObj;
    private boolean isForce;
    private String key;
    private String title;

    public String getContent() {
        return this.content;
    }

    public Object getExtObj() {
        return this.extObj;
    }

    public String getKey() {
        return this.key;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isForce() {
        return this.isForce;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtObj(Object obj) {
        this.extObj = obj;
    }

    public void setForce(boolean z) {
        this.isForce = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
