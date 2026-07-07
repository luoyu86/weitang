package com.chinavisionary.core.app.net.base.dto;

/* JADX INFO: loaded from: classes.dex */
public class TokenInvalidBo extends BaseVo {
    private long createTime;
    private int errCode;
    private String errMsg;
    private String interfaceUrl;
    private String token;

    public long getCreateTime() {
        return this.createTime;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getInterfaceUrl() {
        return this.interfaceUrl;
    }

    public String getToken() {
        return this.token;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setErrCode(int i2) {
        this.errCode = i2;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setInterfaceUrl(String str) {
        this.interfaceUrl = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
