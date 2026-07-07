package com.chinavisionary.microtang.service.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class CreateServiceCommentBo extends BaseVo {
    private String complaintOrderKey;
    private String content;

    public String getComplaintOrderKey() {
        return this.complaintOrderKey;
    }

    public String getContent() {
        return this.content;
    }

    public void setComplaintOrderKey(String str) {
        this.complaintOrderKey = str;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
