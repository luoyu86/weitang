package com.chinavisionary.core.app.net.base.dto;

/* JADX INFO: loaded from: classes.dex */
public class ResponseUploadImgVo extends BaseVo {
    private String code;
    private long createTime;
    private String createUserKey;
    private String key;
    private String message;
    private String name;
    private String originalName;
    private String sourceUrl;
    private boolean success;
    private String url;

    public String getCode() {
        return this.code;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCreateUserKey() {
        return this.createUserKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalName() {
        return this.originalName;
    }

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setCreateUserKey(String str) {
        this.createUserKey = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOriginalName(String str) {
        this.originalName = str;
    }

    public void setSourceUrl(String str) {
        this.sourceUrl = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
