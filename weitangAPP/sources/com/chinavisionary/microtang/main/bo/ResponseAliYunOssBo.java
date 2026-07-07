package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ResponseAliYunOssBo extends NewBaseVo {
    private String accessKeyId;
    private String bucketName;
    private String endpoint;
    private String key;
    private String secretKeyId;
    private String securityToken;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getKey() {
        return this.key;
    }

    public String getSecretKeyId() {
        return this.secretKeyId;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSecretKeyId(String str) {
        this.secretKeyId = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }
}
