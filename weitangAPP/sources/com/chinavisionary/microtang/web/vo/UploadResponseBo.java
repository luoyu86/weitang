package com.chinavisionary.microtang.web.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class UploadResponseBo extends BaseVo {
    private String fileKey;
    private String fileUrl;

    public String getFileKey() {
        return this.fileKey;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileKey(String str) {
        this.fileKey = str;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }
}
