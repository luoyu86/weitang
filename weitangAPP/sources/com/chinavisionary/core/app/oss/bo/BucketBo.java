package com.chinavisionary.core.app.oss.bo;

import c.e.a.a.i.c.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class BucketBo extends BaseVo {
    private String bucketName = "chinavisionary-sz-test";
    private a callback;

    public String getBucketName() {
        return this.bucketName;
    }

    public a getCallback() {
        return this.callback;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }
}
