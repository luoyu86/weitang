package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairLeftVo extends BaseVo {
    public static final int CONTENT_TYPE = 3;
    public static final int TITLE_TYPE = 2;
    private boolean isSelect;
    private String jumpUrl;
    private String key;
    private int relationPosition;
    private String title;
    private int type = 3;

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getKey() {
        return this.key;
    }

    public int getRelationPosition() {
        return this.relationPosition;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRelationPosition(int i2) {
        this.relationPosition = i2;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
