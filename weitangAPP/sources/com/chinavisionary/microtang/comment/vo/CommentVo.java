package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CommentVo extends BaseVo {
    private String key;
    private String subtitle;
    private String title;
    private int type;

    public String getKey() {
        return this.key;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
