package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseEnterpriseNotifyBo extends NewBaseVo {
    private String authEnterpriseKey;
    private String content;
    private String jumpUrl;
    private Boolean needAuth;

    public String getAuthEnterpriseKey() {
        return this.authEnterpriseKey;
    }

    public String getContent() {
        return this.content;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public Boolean getNeedAuth() {
        return this.needAuth;
    }

    public void setAuthEnterpriseKey(String str) {
        this.authEnterpriseKey = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setNeedAuth(Boolean bool) {
        this.needAuth = bool;
    }
}
