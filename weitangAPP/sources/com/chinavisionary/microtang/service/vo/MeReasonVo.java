package com.chinavisionary.microtang.service.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;

/* JADX INFO: loaded from: classes2.dex */
public class MeReasonVo extends BaseVo {
    private boolean canReply;
    private String complaintOrderKey;
    private Long createTime;
    private ResponseFormBo dataSourceVo;
    private ResponseFormBo formDataSourceVo;
    private String formKey;
    private String handleFormKey;
    private String replyContent;
    private String title;
    private int type;

    public String getComplaintOrderKey() {
        return this.complaintOrderKey;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public ResponseFormBo getDataSourceVo() {
        return this.dataSourceVo;
    }

    public ResponseFormBo getFormDataSourceVo() {
        return this.formDataSourceVo;
    }

    public String getFormKey() {
        return this.formKey;
    }

    public String getHandleFormKey() {
        return this.handleFormKey;
    }

    public String getReplyContent() {
        return this.replyContent;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isCanReply() {
        return this.canReply;
    }

    public void setCanReply(boolean z) {
        this.canReply = z;
    }

    public void setComplaintOrderKey(String str) {
        this.complaintOrderKey = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setDataSourceVo(ResponseFormBo responseFormBo) {
        this.dataSourceVo = responseFormBo;
    }

    public void setFormDataSourceVo(ResponseFormBo responseFormBo) {
        this.formDataSourceVo = responseFormBo;
    }

    public void setFormKey(String str) {
        this.formKey = str;
    }

    public void setHandleFormKey(String str) {
        this.handleFormKey = str;
    }

    public void setReplyContent(String str) {
        this.replyContent = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
