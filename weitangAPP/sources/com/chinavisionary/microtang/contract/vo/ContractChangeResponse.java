package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractChangeResponse extends BaseVo {
    private String content;
    private String key;
    private String message;
    private String oldRentBackRemark;
    private Long oldRentBackTimeFrom;
    private Long oldRentBackTimeTo;
    private String remark;
    private boolean success;

    public String getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOldRentBackRemark() {
        return this.oldRentBackRemark;
    }

    public Long getOldRentBackTimeFrom() {
        return this.oldRentBackTimeFrom;
    }

    public Long getOldRentBackTimeTo() {
        return this.oldRentBackTimeTo;
    }

    public String getRemark() {
        return this.remark;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOldRentBackRemark(String str) {
        this.oldRentBackRemark = str;
    }

    public void setOldRentBackTimeFrom(Long l) {
        this.oldRentBackTimeFrom = l;
    }

    public void setOldRentBackTimeTo(Long l) {
        this.oldRentBackTimeTo = l;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
