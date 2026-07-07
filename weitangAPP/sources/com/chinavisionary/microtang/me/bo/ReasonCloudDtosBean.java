package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ReasonCloudDtosBean extends BaseVo {
    private int cancellationReasonType;
    private String cancellationReasonTypeName;
    private boolean otherReason;

    public int getCancellationReasonType() {
        return this.cancellationReasonType;
    }

    public String getCancellationReasonTypeName() {
        return this.cancellationReasonTypeName;
    }

    public boolean isOtherReason() {
        return this.otherReason;
    }

    public void setCancellationReasonType(int i2) {
        this.cancellationReasonType = i2;
    }

    public void setCancellationReasonTypeName(String str) {
        this.cancellationReasonTypeName = str;
    }

    public void setOtherReason(boolean z) {
        this.otherReason = z;
    }
}
