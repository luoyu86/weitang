package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseBannerItemVo extends BaseVo {
    private String coverUrl;
    private Integer jumpType;
    private String jumpUrl;
    private String primaryKey;
    private String title;

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Integer getJumpType() {
        return this.jumpType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setJumpType(Integer num) {
        this.jumpType = num;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
