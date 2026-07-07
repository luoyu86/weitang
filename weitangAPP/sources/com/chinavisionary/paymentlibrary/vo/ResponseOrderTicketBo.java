package com.chinavisionary.paymentlibrary.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseOrderTicketBo extends NewBaseVo {

    @JSONField(name = "isTicket")
    private boolean isTicket;
    private String popupContent;
    private String targetAppid;
    private String targetPath;

    public String getPopupContent() {
        return this.popupContent;
    }

    public String getTargetAppid() {
        return this.targetAppid;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public boolean isTicket() {
        return this.isTicket;
    }

    public void setPopupContent(String str) {
        this.popupContent = str;
    }

    public void setTargetAppid(String str) {
        this.targetAppid = str;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }

    public void setTicket(boolean z) {
        this.isTicket = z;
    }
}
