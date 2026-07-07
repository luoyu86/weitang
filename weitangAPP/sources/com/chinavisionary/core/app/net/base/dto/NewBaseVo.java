package com.chinavisionary.core.app.net.base.dto;

/* JADX INFO: loaded from: classes.dex */
public class NewBaseVo {
    private String baseKey;
    private String code;
    private Boolean enableCache;
    private String message;
    private String requestParamBaseKey;
    private boolean success;

    public String getBaseKey() {
        return this.baseKey;
    }

    public String getCode() {
        return this.code;
    }

    public Boolean getEnableCache() {
        return this.enableCache;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRequestParamBaseKey() {
        return this.requestParamBaseKey;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBaseKey(String str) {
        this.baseKey = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setEnableCache(Boolean bool) {
        this.enableCache = bool;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRequestParamBaseKey(String str) {
        this.requestParamBaseKey = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
