package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountReasonBo extends NewBaseVo {
    private String cancellationAgreement;
    private String cancellationCondition;
    private String cancellationConsequence;
    private String cancellationFailureReason;
    private List<ReasonCloudDtosBean> reasonCloudDtos;

    public String getCancellationAgreement() {
        return this.cancellationAgreement;
    }

    public String getCancellationCondition() {
        return this.cancellationCondition;
    }

    public String getCancellationConsequence() {
        return this.cancellationConsequence;
    }

    public String getCancellationFailureReason() {
        return this.cancellationFailureReason;
    }

    public List<ReasonCloudDtosBean> getReasonCloudDtos() {
        return this.reasonCloudDtos;
    }

    public void setCancellationAgreement(String str) {
        this.cancellationAgreement = str;
    }

    public void setCancellationCondition(String str) {
        this.cancellationCondition = str;
    }

    public void setCancellationConsequence(String str) {
        this.cancellationConsequence = str;
    }

    public void setCancellationFailureReason(String str) {
        this.cancellationFailureReason = str;
    }

    public void setReasonCloudDtos(List<ReasonCloudDtosBean> list) {
        this.reasonCloudDtos = list;
    }
}
