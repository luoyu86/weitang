package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseNewBannerItemVo extends BaseVo {
    private String iconUrl;
    private String linkKey;
    private String linkParam;
    private String linkUrl;
    private String primaryKey;
    private String targetAppid;
    private String targetMiniType;
    private String targetPath;
    private String title;
    private long displayDuration = 3;
    private int linkForwardType = 1;

    public long getDisplayDuration() {
        return this.displayDuration;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getLinkForwardType() {
        return this.linkForwardType;
    }

    public String getLinkKey() {
        return this.linkKey;
    }

    public String getLinkParam() {
        return this.linkParam;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getTargetAppid() {
        return this.targetAppid;
    }

    public String getTargetMiniType() {
        return this.targetMiniType;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDisplayDuration(long j) {
        this.displayDuration = j;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setLinkForwardType(int i2) {
        this.linkForwardType = i2;
    }

    public void setLinkKey(String str) {
        this.linkKey = str;
    }

    public void setLinkParam(String str) {
        this.linkParam = str;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setTargetAppid(String str) {
        this.targetAppid = str;
    }

    public void setTargetMiniType(String str) {
        this.targetMiniType = str;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
