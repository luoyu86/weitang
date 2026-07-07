package com.chinavisionary.core.app.oss.bo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AliYunOssResultVo extends BaseVo {
    private String bucketName;
    private String pathName;
    private String picUrl;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getPathName() {
        return this.pathName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public boolean isContains(String str) {
        return x.isNotNull(str) && x.isNotNull(this.pathName) && this.pathName.indexOf(str) > 0;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setPathName(String str) {
        this.pathName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }
}
